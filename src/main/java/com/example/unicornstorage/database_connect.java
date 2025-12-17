package com.example.unicornstorage;

import javafx.animation.PauseTransition;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Control;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Region;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.util.Duration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class database_connect
{
    @FXML
    private TableView<Tabela_glowna> tableMagazyn;

    @FXML
    private TableColumn<Tabela_glowna, String> colId;

    @FXML
    private TableColumn<Tabela_glowna, String> colIlosc;

    @FXML
    private TableColumn<Tabela_glowna, String> colNazwa;

    @FXML
    private TableColumn<Tabela_glowna, String> colProducent;

    @FXML
    private TableColumn<Tabela_glowna, String> colKategoria;

    @FXML
    private TableColumn<Tabela_glowna, String> colPodkategoria;

    @FXML
    private TableColumn<Tabela_glowna, String> colOpis;


    // ===== DODANE: pole wyszukiwania + debounce =====
    @FXML
    private TextField szukaj;

    private final PauseTransition debounce = new PauseTransition(Duration.millis(250));
    // ===============================================

    @FXML
    private void initialize()
    {
        // powiązanie kolumn z danymi
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colIlosc.setCellValueFactory(new PropertyValueFactory<>("ilosc"));
        colNazwa.setCellValueFactory(new PropertyValueFactory<>("nazwa"));
        colProducent.setCellValueFactory(new PropertyValueFactory<>("producent"));
        colKategoria.setCellValueFactory(new PropertyValueFactory<>("kategoria"));
        colPodkategoria.setCellValueFactory(new PropertyValueFactory<>("podkategoria"));
        colOpis.setCellValueFactory(new PropertyValueFactory<>("opis"));

        // centrowanie ID i ILOSC
        colId.setStyle("-fx-alignment: CENTER;");
        colIlosc.setStyle("-fx-alignment: CENTER;");

        // kolumny mają wypełniać całą szerokość tabeli (reszta idzie w opis)
        tableMagazyn.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        // zmienna wysokość wierszy
        tableMagazyn.setFixedCellSize(Control.USE_COMPUTED_SIZE);

        // zawijanie + automatyczna wysokość dla kolumn tekstowych
        configureWrappingColumn(colNazwa);
        configureWrappingColumn(colProducent);
        configureWrappingColumn(colKategoria);
        configureWrappingColumn(colPodkategoria);
        configureWrappingColumn(colOpis);

        loadData();

        // ===== DODANE: listener wyszukiwania =====
        if (szukaj != null)
        {
            szukaj.textProperty().addListener((obs, oldVal, newVal) ->
            {
                debounce.stop();
                debounce.setOnFinished(e ->
                {
                    String fraza = (newVal == null) ? "" : newVal.trim();

                    // jeśli puste -> wróć do pełnej listy (tak jak reset)
                    if (fraza.isEmpty())
                    {
                        tableMagazyn.setItems(dane);
                        return;
                    }

                    // kwerenda po nazwa/producent/kategoria/podkategoria
                    // proste zabezpieczenie apostrofu, bo tu używasz Statement
                    String safe = fraza.replace("'", "''");

                    String q =
                            "SELECT * FROM magazyn " +
                                    "WHERE LOWER(nazwa) LIKE LOWER('%" + safe + "%') " +
                                    "   OR LOWER(producent) LIKE LOWER('%" + safe + "%') " +
                                    "   OR LOWER(kategoria) LIKE LOWER('%" + safe + "%') " +
                                    "   OR LOWER(podkategoria) LIKE LOWER('%" + safe + "%')";

                    // nie używamy Twojego query(), bo ono zamyka connection/statement
                    loadDataSearch(q);
                });
                debounce.playFromStart();
            });
        }
        // ==========================================
    }

    private void configureWrappingColumn(TableColumn<Tabela_glowna, String> col)
    {
        col.setCellFactory(c -> {
            TableCell<Tabela_glowna, String> cell = new TableCell<>();
            Text text = new Text();

            text.wrappingWidthProperty().bind(col.widthProperty().subtract(10));
            text.textProperty().bind(cell.itemProperty());

            cell.setGraphic(text);
            cell.setPrefHeight(Region.USE_COMPUTED_SIZE);
            return cell;
        });
    }

    // ===== Twoja funkcja query (zostawiam jak jest) =====
    private void query(String q1)
    {
        try
        {
            dane.clear();
            ResultSet resultSet = statement.executeQuery(q1);

            while (resultSet.next())
            {
                String id = resultSet.getString("id");
                String ilosc = resultSet.getString("ilosc");
                String ilosc_ostrzezenie = resultSet.getString("ilosc_ostrzezenie");
                String nazwa = resultSet.getString("nazwa");
                String producent = resultSet.getString("producent");
                String kategoria = resultSet.getString("kategoria");
                String podkategoria = resultSet.getString("podkategoria");
                String opis = resultSet.getString("opis");

                dane.add(new Tabela_glowna(
                        id, ilosc, ilosc_ostrzezenie, nazwa,
                        producent, kategoria,
                        podkategoria, opis
                ));
            }



            tableMagazyn.setItems(dane);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }

    Connection connection;
    Statement statement;
    ObservableList<Tabela_glowna> dane;

    public void loadData()
    {
        String username = "grupa3_L04";
        String password = "HasloGrupa3_L04!";
        String dbname = "Teams_3_L04";
        String servername = "jdbc:mariadb://130.61.119.119:3306/" + dbname;

        dane = FXCollections.observableArrayList();

        try
        {
            connection = DriverManager.getConnection(servername, username, password);
            statement = connection.createStatement();
            query("SELECT * FROM  magazyn");

            // po ustawieniu danych dopasuj szerokości kolumn
            Platform.runLater(this::autoResizeColumns);
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }

    // ===== DODANE: osobne ładowanie wyników wyszukiwania (bez zamykania globalnych connection/statement) =====
    private void loadDataSearch(String sql)
    {
        String username = "grupa3_L04";
        String password = "HasloGrupa3_L04!";
        String dbname = "Teams_3_L04";
        String servername = "jdbc:mariadb://130.61.119.119:3306/" + dbname;

        ObservableList<Tabela_glowna> wyniki = FXCollections.observableArrayList();

        try (Connection c = DriverManager.getConnection(servername, username, password);
             Statement s = c.createStatement();
             ResultSet rs = s.executeQuery(sql))
        {
            while (rs.next())
            {
                String id = rs.getString("id");
                String ilosc = rs.getString("ilosc");
                String ilosc_ostrzezenie = rs.getString("ilosc_ostrzezenie");
                String nazwa = rs.getString("nazwa");
                String producent = rs.getString("producent");
                String kategoria = rs.getString("kategoria");
                String podkategoria = rs.getString("podkategoria");
                String opis = rs.getString("opis");

                wyniki.add(new Tabela_glowna(
                        id, ilosc, ilosc_ostrzezenie, nazwa,
                        producent, kategoria,
                        podkategoria, opis
                ));
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }

        tableMagazyn.setItems(wyniki);
        Platform.runLater(this::autoResizeColumns);
    }
    // =========================================================================================================

    // dopasowanie szerokości kolumn do najdłuższego tekstu (oprócz OPIS)
    private void autoResizeColumns()
    {
        resizeToContent(colId, 16);          // trochę paddingu
        resizeToContent(colIlosc, 16);
        resizeToContent(colNazwa, 24);
        resizeToContent(colProducent, 24);
        resizeToContent(colKategoria, 24);
        resizeToContent(colPodkategoria, 24);
        // colOpis nie ruszamy – dostanie całą pozostałą szerokość
    }

    private void resizeToContent(TableColumn<Tabela_glowna, ?> col, int padding)
    {
        if (col == null) return;

        double max = computeTextWidth(col.getText());

        for (Tabela_glowna item : tableMagazyn.getItems())
        {
            Object cellData = col.getCellData(item);
            if (cellData != null)
            {
                double w = computeTextWidth(cellData.toString());
                if (w > max) max = w;
            }
        }

        double finalWidth = max + padding;
        col.setMinWidth(finalWidth);
        col.setPrefWidth(finalWidth);
        col.setMaxWidth(finalWidth);
    }

    private double computeTextWidth(String text)
    {
        if (text == null || text.isEmpty())
            return 0;

        Text helper = new Text(text);
        return helper.getLayoutBounds().getWidth();
    }

    @FXML
    private void onOstrzezenie()
    {
        query("SELECT * FROM magazyn WHERE ilosc < ilosc_ostrzezenie AND ilosc > 0"
        );
    }
    @FXML
    private void onBraki()
    {
        query("SELECT * FROM magazyn WHERE ilosc = 0"
        );
    }



    @FXML
    private void onReset()
    {
        query("SELECT * FROM magazyn"
        );
    }
}



