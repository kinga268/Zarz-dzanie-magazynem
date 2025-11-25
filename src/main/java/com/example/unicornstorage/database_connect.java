package com.example.unicornstorage;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Control;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Region;
import javafx.scene.text.Text;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class database_connect
{
    @FXML
    private TableView<MagazynItem> tableMagazyn;

    @FXML
    private TableColumn<MagazynItem, Integer> colId;

    @FXML
    private TableColumn<MagazynItem, Integer> colIlosc;

    @FXML
    private TableColumn<MagazynItem, String> colNazwa;

    @FXML
    private TableColumn<MagazynItem, String> colProducent;

    @FXML
    private TableColumn<MagazynItem, String> colKategoria;

    @FXML
    private TableColumn<MagazynItem, String> colPodkategoria;

    @FXML
    private TableColumn<MagazynItem, String> colOpis;

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
    }

    private void configureWrappingColumn(TableColumn<MagazynItem, String> col)
    {
        col.setCellFactory(c -> {
            TableCell<MagazynItem, String> cell = new TableCell<>();
            Text text = new Text();

            text.wrappingWidthProperty().bind(col.widthProperty().subtract(10));
            text.textProperty().bind(cell.itemProperty());

            cell.setGraphic(text);
            cell.setPrefHeight(Region.USE_COMPUTED_SIZE);
            return cell;
        });
    }

    private void loadData()
    {
        String username = "root";
        String password = "";
        String dbname = "projekt";
        String servername = "jdbc:mariadb://127.0.0.1:3306/" + dbname;

        ObservableList<MagazynItem> dane = FXCollections.observableArrayList();

        try
        {
            Connection connection = DriverManager.getConnection(servername, username, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM magazyn");

            while (resultSet.next())
            {
                int id = resultSet.getInt("id");
                int ilosc = resultSet.getInt("ilosc");
                String nazwa = resultSet.getString("nazwa");
                String producent = resultSet.getString("producent");
                String kategoria = resultSet.getString("kategoria");
                String podkategoria = resultSet.getString("podkategoria");
                String opis = resultSet.getString("opis");

                dane.add(new MagazynItem(
                        id, ilosc, nazwa,
                        producent, kategoria,
                        podkategoria, opis
                ));
            }

            resultSet.close();
            statement.close();
            connection.close();

            tableMagazyn.setItems(dane);

            // po ustawieniu danych dopasuj szerokości kolumn
            Platform.runLater(this::autoResizeColumns);
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }

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

    private void resizeToContent(TableColumn<MagazynItem, ?> col, int padding)
    {
        if (col == null) return;

        double max = computeTextWidth(col.getText());

        for (MagazynItem item : tableMagazyn.getItems())
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
}
