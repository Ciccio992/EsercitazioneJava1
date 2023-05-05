package it.devlec.pdf;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.VerticalPositionMark;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class EsempioPDF {
    private static final Logger logger =  LogManager.getLogger(EsempioPDF.class);

    public EsempioPDF() {
    }

    public void creaMioPdf(){
        Document document = new Document();
        try {
            String excelFile = null;
            try {
                excelFile = Paths.get(ClassLoader.getSystemResource("excel.xlsx")
                        .toURI()).toString();
            } catch (URISyntaxException e) {
                logger.error("Errore nel trovare nel creare il file");
            }
            File parent = new File(excelFile).getParentFile();
            String mioPDF = parent.getAbsolutePath() + File.separator + "mioPdf.pdf";

            FileOutputStream fileOutputStream = new
                    FileOutputStream(
                    mioPDF);
            PdfWriter.getInstance(document,fileOutputStream);
            document.open();
            Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
            Chunk chunk = new Chunk("Prova PDF", font);

            document.add(chunk);
            document.add(chunk);
            Phrase p = new Phrase();
            p.add(new Chunk(new VerticalPositionMark()));

            document.add(p);
            p.add(new Chunk(new VerticalPositionMark()));
            p.add(new Chunk(new VerticalPositionMark()));
            PdfPTable table = new PdfPTable(3 );

            addTableHeader(table);
            addRows(table);
            addCustomRows(table);
            document.add(p);
            document.add(table);
            document.add(p);
            PdfPTable table = new PdfPTable(3);
            addTableHeader(table);
            addRows(table);
            addCustomRows(table);

            document.add(table);

            Path path = Paths.get(ClassLoader.getSystemResource("Ferrari.jpg").toURI());
            Image img = Image.getInstance(path.toAbsolutePath().toString());
            img.scalePercent(15);

            document.add(img);
            document.close();
        } catch (DocumentException  | IOException |
                URISyntaxException e) {
            logger.error("Errore nella creazione del mio PDF", e);
        }

    }
    private void addTableHeader(PdfPTable table) {
        Stream.of("Nome", "Data nascita", "Codice fiscale", "Email", "Password")
                .forEach(columnTitle -> {
                    PdfPCell header = new PdfPCell();
                    header.setBackgroundColor(BaseColor.LIGHT_GRAY);
                    header.setBorderWidth(2);
                    header.setPhrase(new Phrase(columnTitle));
                    table.addCell(header);
                });
    }

    private void addRows(PdfPTable table) {
        table.addCell("Antonello");
        table.addCell("Federico");
        table.addCell("Angelo");
    }
    private void addCustomRows(PdfPTable table)
            throws URISyntaxException, BadElementException, IOException {

        PdfPCell topAlignCell = new PdfPCell(new Phrase("riga 2, colonna 1"));
        topAlignCell.setHorizontalAlignment(Element.ALIGN_TOP);
        table.addCell(topAlignCell);

        PdfPCell horizontalAlignCell = new PdfPCell(new Phrase("riga 2, colonna 2"));
        horizontalAlignCell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(horizontalAlignCell);

        PdfPCell verticalAlignCell = new PdfPCell(new Phrase("riga 2, colonna 3"));
        verticalAlignCell.setVerticalAlignment(Element.ALIGN_BOTTOM);
        table.addCell(verticalAlignCell);
    }
}
