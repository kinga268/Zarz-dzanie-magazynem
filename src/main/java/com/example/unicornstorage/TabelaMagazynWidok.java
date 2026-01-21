package com.example.unicornstorage;

import javafx.scene.control.Control;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Region;
import javafx.scene.text.Text;

public class TabelaMagazynWidok {


    public static void configureColumns(
            TableView<Tabela_glowna> table,
            TableColumn<Tabela_glowna, Integer> colId,
            TableColumn<Tabela_glowna, Integer> colIlosc,
            TableColumn<Tabela_glowna, String> colNazwa,
            TableColumn<Tabela_glowna, String> colProducent,
            TableColumn<Tabela_glowna, String> colKategoria,
            TableColumn<Tabela_glowna, String> colPodkategoria,
            TableColumn<Tabela_glowna, String> colOpis
    ) {

        colId.setStyle("-fx-alignment: CENTER;");
        colIlosc.setStyle("-fx-alignment: CENTER;");

        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        table.setFixedCellSize(Control.USE_COMPUTED_SIZE);

        configureWrappingColumn(colNazwa);
        configureWrappingColumn(colProducent);
        configureWrappingColumn(colKategoria);
        configureWrappingColumn(colPodkategoria);
        configureWrappingColumn(colOpis);
    }

    private static void configureWrappingColumn(TableColumn<Tabela_glowna, String> col) {
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



    public static void autoResizeColumns(
            TableView<Tabela_glowna> table,
            TableColumn<Tabela_glowna, Integer> colId,
            TableColumn<Tabela_glowna, Integer> colIlosc,
            TableColumn<Tabela_glowna, String> colNazwa,
            TableColumn<Tabela_glowna, String> colProducent,
            TableColumn<Tabela_glowna, String> colKategoria,
            TableColumn<Tabela_glowna, String> colPodkategoria
    ) {
        resizeToContent(table, colId, 16);
        resizeToContent(table, colIlosc, 16);
        resizeToContent(table, colNazwa, 24);
        resizeToContent(table, colProducent, 24);
        resizeToContent(table, colKategoria, 24);
        resizeToContent(table, colPodkategoria, 24);
        // colOpis celowo pominięta
    }

    private static void resizeToContent(
            TableView<Tabela_glowna> table,
            TableColumn<Tabela_glowna, ?> col,
            int padding
    ) {
        if (col == null) return;

        double max = computeTextWidth(col.getText());

        for (Tabela_glowna item : table.getItems()) {
            Object cellData = col.getCellData(item);
            if (cellData != null) {
                double w = computeTextWidth(cellData.toString());
                if (w > max) max = w;
            }
        }

        double finalWidth = max + padding;
        col.setMinWidth(finalWidth);
        col.setPrefWidth(finalWidth);
        col.setMaxWidth(finalWidth);
    }

    private static double computeTextWidth(String text) {
        if (text == null || text.isEmpty()) return 0;
        Text helper = new Text(text);
        return helper.getLayoutBounds().getWidth();
    }
}
