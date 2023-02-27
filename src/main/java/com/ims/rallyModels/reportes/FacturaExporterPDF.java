package com.ims.rallyModels.reportes;

import com.ims.rallyModels.modelo.CompraEntity;
import com.ims.rallyModels.modelo.MaquetaEntity;
import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import jakarta.servlet.http.HttpServletResponse;

import java.awt.*;
import java.io.IOException;
import java.util.List;

public class FacturaExporterPDF {


    private List<MaquetaEntity> compra;

    public FacturaExporterPDF(List<MaquetaEntity> compra) {
        super();
        this.compra = compra;
    }

    private void escribirCabeceraDeLaTabla(PdfPTable tabla) {
        PdfPCell cell = new PdfPCell();

        cell.setBackgroundColor(Color.LIGHT_GRAY);
        cell.setPadding(5);

        Font fuente = FontFactory.getFont(FontFactory.HELVETICA);
        fuente.setColor(Color.WHITE);

        cell.setPhrase(new Phrase("Id",fuente));
        tabla.addCell(cell);

        cell.setPhrase(new Phrase("Coche",fuente));
        tabla.addCell(cell);

        cell.setPhrase(new Phrase("Piloto",fuente));
        tabla.addCell(cell);

        cell.setPhrase(new Phrase("Precio",fuente));
        tabla.addCell(cell);

    }

    private void escribirDatosDeLaTable(PdfPTable table) {
        for (MaquetaEntity m : compra) {
            table.addCell(String.valueOf(m.getIdMaqueta()));
            table.addCell(m.getMarca()+" "+m.getModelo());
            table.addCell(m.getPiloto());
            table.addCell(m.getPrecio().toString());
        }
    }

    public void exportar(HttpServletResponse response) throws IOException {
        Document documento = new Document(PageSize.A4);
        PdfWriter.getInstance(documento,response.getOutputStream());

        documento.open();

        Font fuente = FontFactory.getFont(FontFactory.HELVETICA);
        fuente.setColor(Color.RED);
        fuente.setSize(18);

        Paragraph titulo = new Paragraph("Factura de maquetas", fuente);
        titulo.setAlignment(Paragraph.ALIGN_CENTER);
        documento.add(titulo);

        PdfPTable tabla = new PdfPTable(4);
        tabla.setWidthPercentage(100);
        tabla.setSpacingBefore(15);
        tabla.setWidths(new float[] {1f,2.3f,2.3f,2.3f});
        tabla.setWidthPercentage(110);

        escribirCabeceraDeLaTabla(tabla);
        escribirDatosDeLaTable(tabla);

        documento.add(tabla);

        documento.close();

    }

}
