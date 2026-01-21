package com.example.unicornstorage;

import javafx.animation.PauseTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
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

    // 🔍 SEARCH
    @FXML
    private TextField search;
    private final PauseTransition debounce =
            new PauseTransition(Duration.millis(300));

    Connection connection;
    Statement statement;
    ObservableList<Tabela_glowna> dane;

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

        loadData();

        // 🔁 AUTO SEARCH
        if (search != null)
        {
            search.textProperty().addListener((obs, oldVal, newVal) ->
            {
                debounce.stop();
                debounce.setOnFinished(e ->
                {
                    String text = (newVal == null) ? "" : newVal.trim();

                    if (text.isEmpty())
                    {
                        query("SELECT * FROM magazyn");
                        return;
                    }

                    String safe = text.replace("'", "''");

                    String sql =
                            "SELECT * FROM magazyn WHERE " +
                                    "LOWER(nazwa) LIKE LOWER('%" + safe + "%') OR " +
                                    "LOWER(producent) LIKE LOWER('%" + safe + "%') OR " +
                                    "LOWER(kategoria) LIKE LOWER('%" + safe + "%') OR " +
                                    "LOWER(id) LIKE LOWER('%" + safe + "%') OR " +
                                    "LOWER(ilosc) LIKE LOWER('%" + safe + "%') OR "+
                                    "LOWER(podkategoria) LIKE LOWER('%" + safe + "%')";

                    query(sql);
                });
                debounce.playFromStart();
            });
        }
    }

    private void query(String q1)
    {
        try
        {
            dane.clear();
            ResultSet resultSet = statement.executeQuery(q1);

            while (resultSet.next())
            {
                dane.add(new Tabela_glowna(
                        resultSet.getString("id"),
                        resultSet.getString("ilosc"),
                        resultSet.getString("ilosc_ostrzezenie"),
                        resultSet.getString("nazwa"),
                        resultSet.getString("producent"),
                        resultSet.getString("kategoria"),
                        resultSet.getString("podkategoria"),
                        resultSet.getString("opis")
                ));
            }

            tableMagazyn.setItems(dane);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void loadData()
    {
        String username = "grupa3_L04";
        String password = "HasloGrupa3_L04!";
        String dbname = "Teams_3_L04";
        String server =
                "jdbc:mariadb://130.61.119.119:3306/" + dbname;

        dane = FXCollections.observableArrayList();

        try
        {
            connection = DriverManager.getConnection(server, username, password);
            statement = connection.createStatement();
            query("SELECT * FROM magazyn");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    // --- PRZYCISKI ---
    @FXML
    private void onOstrzezenie()
    {
        query("SELECT * FROM magazyn WHERE ilosc < ilosc_ostrzezenie AND ilosc > 0");
    }

    @FXML
    private void onBraki()
    {
        query("SELECT * FROM magazyn WHERE ilosc = 0");
    }

    @FXML
    private void onReset()
    {
        query("SELECT * FROM magazyn");
    }
}

