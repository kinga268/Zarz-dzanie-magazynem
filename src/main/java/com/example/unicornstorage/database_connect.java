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
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicLong;

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

    @FXML
    private TextField szukaj;

    private final PauseTransition debounce = new PauseTransition(Duration.millis(250));
    private final AtomicLong querySeq = new AtomicLong(0);

    @FXML
    private void initialize()
    {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colIlosc.setCellValueFactory(new PropertyValueFactory<>("ilosc"));
        colNazwa.setCellValueFactory(new PropertyValueFactory<>("nazwa"));
        colProducent.setCellValueFactory(new PropertyValueFactory<>("producent"));
        colKategoria.setCellValueFactory(new PropertyValueFactory<>("kategoria"));
        colPodkategoria.setCellValueFactory(new PropertyValueFactory<>("podkategoria"));
        colOpis.setCellValueFactory(new PropertyValueFactory<>("opis"));

        colId.setStyle("-fx-alignment: CENTER;");
        colIlosc.setStyle("-fx-alignment: CENTER;");

        tableMagazyn.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tableMagazyn.setFixedCellSize(Control.USE_COMPUTED_SIZE);

        configureWrappingColumn(colNazwa);
        configureWrappingColumn(colProducent);
        configureWrappingColumn(colKategoria);
        configureWrappingColumn(colPodkategoria);
        configureWrappingColumn(colOpis);

        // Start: pełna tabela
        loadDataAsync("");

        // Listener na pole szukaj
        if (szukaj != null)
        {
            szukaj.textProperty().addListener((obs, oldVal, newVal) ->
            {
                debounce.stop();
                debounce.setOnFinished(e ->
                {
                    String fraza = (newVal == null) ? "" : newVal.trim();
                    loadDataAsync(fraza);
                });
                debounce.playFromStart();
            });
        }
    }

    private void configureWrappingColumn(TableColumn<Tabela_glowna, String> col)
    {
        col.setCellFactory(c ->
        {
            TableCell<Tabela_glowna, String> cell = new TableCell<>();
            Text text = new Text();

            text.wrappingWidthProperty().bind(col.widthProperty().subtract(10));
            text.textProperty().bind(cell.itemProperty());

            cell.setGraphic(text);
            cell.setPrefHeight(Control.USE_COMPUTED_SIZE);
            return cell;
        });
    }

    private void loadDataAsync(String fraza)
    {
        long mySeq = querySeq.incrementAndGet();

        new Thread(() ->
        {
            ObservableList<Tabela_glowna> wynik = loadDataFromDb(fraza);

            Platform.runLater(() ->
            {
                // jeśli w międzyczasie przyszło nowsze zapytanie – ignoruj stare
                if (mySeq != querySeq.get())
                {
                    return;
                }

                tableMagazyn.setItems(wynik);

                // dopasuj prefWidth (bez sztywnego maxWidth/minWidth, żeby OPIS brał resztę)
                Platform.runLater(this::autoResizeColumns);
            });
        }, "db-search-thread").start();
    }

    private ObservableList<Tabela_glowna> loadDataFromDb(String fraza)
    {
        String username = "grupa3_L04";
        String password = "HasloGrupa3_L04!";
        String dbname = "Teams_3_L04";
        String servername = "jdbc:mariadb://130.61.119.119:3306/" + dbname;

        ObservableList<Tabela_glowna> dane = FXCollections.observableArrayList();

        try
        {
            // config.txt: 1 linia = dbname, 2 linia = prefix url (np. jdbc:mariadb://IP:3306/)
//            Scanner scanner = new Scanner(new File("config.txt"));
//            dbname = scanner.nextLine();
//            servername = scanner.nextLine();
//            servername = servername + dbname;

            String sql =
                    "SELECT id, ilosc, ilosc_ostrzezenie, nazwa, producent, kategoria, podkategoria, opis " +
                            "FROM magazyn " +
                            "WHERE (? = '') " +
                            "   OR (LOWER(nazwa) LIKE LOWER(?) " +
                            "   OR  LOWER(producent) LIKE LOWER(?) " +
                            "   OR  LOWER(kategoria) LIKE LOWER(?) " +
                            "   OR  LOWER(podkategoria) LIKE LOWER(?)) " +
                            "ORDER BY id";

            String like = "%" + fraza + "%";

            try (Connection connection = DriverManager.getConnection(servername, username, password);
                 PreparedStatement ps = connection.prepareStatement(sql))
            {
                ps.setString(1, fraza);
                ps.setString(2, like);
                ps.setString(3, like);
                ps.setString(4, like);
                ps.setString(5, like);

                try (ResultSet resultSet = ps.executeQuery())
                {
                    while (resultSet.next())
                    {
                        String id = safeString(resultSet.getString("id"));
                        String ilosc = safeString(resultSet.getString("ilosc"));
                        String ilosc_ostrzezenie = safeString(resultSet.getString("ilosc_ostrzezenie"));
                        String nazwa = safeString(resultSet.getString("nazwa"));
                        String producent = safeString(resultSet.getString("producent"));
                        String kategoria = safeString(resultSet.getString("kategoria"));
                        String podkategoria = safeString(resultSet.getString("podkategoria"));
                        String opis = safeString(resultSet.getString("opis"));

                        dane.add(new Tabela_glowna(
                                id, ilosc, ilosc_ostrzezenie, nazwa,
                                producent, kategoria,
                                podkategoria, opis
                        ));
                    }
                }
            }
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }

        return dane;
    }

    private String safeString(String s)
    {
        return (s == null) ? "" : s;
    }

    private void autoResizeColumns()
    {
        // ustawiamy TYLKO prefWidth dla kolumn poza OPIS, żeby OPIS zgarnął resztę przy CONSTRAINED
        setPrefToContent(colId);
        setPrefToContent(colIlosc);
        setPrefToContent(colNazwa);
        setPrefToContent(colProducent);
        setPrefToContent(colKategoria);
        setPrefToContent(colPodkategoria);

        // colOpis zostaje elastyczny (bierze resztę)
    }

    private void setPrefToContent(TableColumn<Tabela_glowna, ?> col)
    {
        double max = 0;

        for (int i = 0; i < tableMagazyn.getItems().size(); i++)
        {
            Object cellData = col.getCellData(i);
            String text = (cellData == null) ? "" : cellData.toString();
            max = Math.max(max, computeTextWidth(text));
        }

        // mała szerokość minimalna, żeby nie było mikroskopijne
        double finalWidth = Math.max(60, max + 30);
        col.setPrefWidth(finalWidth);
    }

    private double computeTextWidth(String text)
    {
        if (text == null || text.isEmpty())
            return 0;

        Text helper = new Text(text);
        return helper.getLayoutBounds().getWidth();
    }



}
