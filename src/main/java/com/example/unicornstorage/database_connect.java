package com.example.unicornstorage;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import java.io.*;

import java.sql.*;
import java.util.Scanner;

public class database_connect {
    @FXML
    private Label exeptionListener;
    @FXML
    protected void onConnect() {
            //String username = "notif";
            String username = "root";
            String password = "";
            String dbname = null;
            //String servername = "jdbc:mysql://192.168.236.120:3306/" + dbname;
            String servername = null;
            System.out.println("test");
            Connection connection = null;

            try {
                Scanner scanner = new Scanner(new File("config.txt"));
                dbname = scanner.nextLine();
                servername = scanner.nextLine();
                servername = servername + dbname;
                //                Class.forName("com.mysql.cj.jdbc.Driver");
                System.out.println("test");
                connection = DriverManager.getConnection(servername, username, password);
                System.out.println("test");
                Statement statement;
                statement = connection.createStatement();//połączenie z bazą danych
                ResultSet resultSet;
                resultSet = statement.executeQuery("SELECT * FROM magazyn");

                String ilosc="";
                String id="";
                String nazwa="";
                String opis="";
                String a="";

                // wyświetlenie w terminalu
                while (resultSet.next()) {

                    id = resultSet.getString("id");
                    ilosc = resultSet.getString("ilosc");
                    nazwa = resultSet.getString("nazwa");
                    opis = resultSet.getString("opis").trim();
                    a=a+("Title : " + id + " Note : " + ilosc + " Time : " + nazwa + " Date : " + opis+"\n");

                }
                this.exeptionListener.setText(a);
                resultSet.close();
                statement.close();
                connection.close();

            } catch (Exception exception) {
                this.exeptionListener.setText(exception.toString());
//                System.out.println(exception);

            }


    }
}