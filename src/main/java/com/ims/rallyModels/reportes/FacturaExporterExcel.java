package com.ims.rallyModels.reportes;

import com.ims.rallyModels.modelo.MaquetaEntity;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class FacturaExporterExcel {

    private XSSFWorkbook libro;
    private XSSFSheet hoja;

    private List<MaquetaEntity> maquetas;

    public FacturaExporterExcel(List<MaquetaEntity> maquetas) {
        this.maquetas = maquetas;
        libro = new XSSFWorkbook();
        hoja = libro.createSheet("Maquetas");
    }

    private void escribirCabeceraTabla() {
        Row fila = hoja.createRow(0);

        CellStyle estilo = libro.createCellStyle();
        XSSFFont fuente = libro.createFont();
        fuente.setBold(true);
        fuente.setFontHeight(16);
        estilo.setFont(fuente);

        Cell celda = fila.createCell(0);
        celda.setCellValue("Id");
        celda.setCellStyle(estilo);

        celda = fila.createCell(1);
        celda.setCellValue("Coche");
        celda.setCellStyle(estilo);

        celda = fila.createCell(2);
        celda.setCellValue("Piloto");
        celda.setCellStyle(estilo);

        celda = fila.createCell(3);
        celda.setCellValue("Precio");
        celda.setCellStyle(estilo);

    }

    public void escribirDatosDeTabla() {
        int numeroFilas = 1;

        CellStyle estilo = libro.createCellStyle();
        XSSFFont fuente = libro.createFont();
        fuente.setFontHeight(14);
        estilo.setFont(fuente);

        for (MaquetaEntity m : maquetas) {
            Row fila = hoja.createRow(numeroFilas++);

            Cell celda = fila.createCell(0);
            celda.setCellValue(m.getIdMaqueta());
            hoja.autoSizeColumn(0);
            celda.setCellStyle(estilo);

            celda = fila.createCell(1);
            celda.setCellValue(m.getMarca()+" "+m.getModelo());
            hoja.autoSizeColumn(1);
            celda.setCellStyle(estilo);

            celda = fila.createCell(2);
            celda.setCellValue(m.getPiloto());
            hoja.autoSizeColumn(2);
            celda.setCellStyle(estilo);

            celda = fila.createCell(3);
            celda.setCellValue(m.getPrecio());
            hoja.autoSizeColumn(3);
            celda.setCellStyle(estilo);

        }

    }

    public void exportar(HttpServletResponse response) throws IOException {
        escribirCabeceraTabla();
        escribirDatosDeTabla();

        ServletOutputStream outputStream = response.getOutputStream();
        libro.write(outputStream);
        libro.close();
        outputStream.close();

    }

}
