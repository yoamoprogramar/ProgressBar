/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdf;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.GrayColor;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author skriom
 */
@WebServlet(name = "GenerarPDF", urlPatterns = {"/GenerarPDF"})
public class GenerarPDF extends HttpServlet {

    private HttpServletRequest varRequest = null;
    String file_path = "";
    File file;
    Document doc;
    OutputStream out;
    String dir = "", sub = "";

    int tam = 0, filas = 0;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("application/pdf");
        response.setCharacterEncoding("UTF-8");
        doc = new Document();
        out = response.getOutputStream();
        try {
            PdfWriter.getInstance(doc, out);
            doc.open();

            String ruta = this.getServletContext().getRealPath("/imagen.jpg");
            Image img = Image.getInstance(ruta);
            img.setAlignment(Element.ALIGN_CENTER);
            img.scaleToFit(520, 80);
            doc.add(img);
            Paragraph p1 = new Paragraph(10);
            Font normal = new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL, BaseColor.BLACK);
            Font negrita = new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.BOLD, BaseColor.BLACK);
            Font n = new Font(Font.FontFamily.TIMES_ROMAN, 6, Font.NORMAL, BaseColor.BLACK);
            p1.add(Chunk.NEWLINE);
            p1.add(new Phrase("GRUPO: ", normal));
            p1.add(Chunk.TABBING);
            p1.add(Chunk.TABBING);
            p1.add(new Phrase("SEMESTRE: ", normal));
            p1.add(Chunk.TABBING);
            p1.add(Chunk.TABBING);
            p1.add(new Phrase("ESPECIALIDAD: ", normal));
            p1.add(Chunk.NEWLINE);
            p1.add(new Phrase("TURNO: ", normal));
            p1.add(Chunk.TABBING);
            p1.add(Chunk.TABBING);
            p1.add(new Phrase("AULA: ", normal));
            p1.add(Chunk.NEWLINE);
            p1.add(Chunk.NEWLINE);
            p1.add(Chunk.NEWLINE);
            p1.setAlignment(Element.ALIGN_CENTER);
            doc.add(p1);
            Font negrit = new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.BOLD, BaseColor.BLACK);
            PdfPTable tabla = new PdfPTable(7);
            tabla.setWidthPercentage(100);
            PdfPCell f11 = new PdfPCell(new Phrase("HORA", negrit));
            PdfPCell f12 = new PdfPCell(new Phrase("LUNES", negrit));
            PdfPCell f13 = new PdfPCell(new Phrase("MARTES", negrit));
            PdfPCell f14 = new PdfPCell(new Phrase("MIERCOLES", negrit));
            PdfPCell f15 = new PdfPCell(new Phrase("JUEVES", negrit));
            PdfPCell f16 = new PdfPCell(new Phrase("VIERNES", negrit));
            PdfPCell f17 = new PdfPCell(new Phrase("SABADO", negrit));
            f11.setHorizontalAlignment(Element.ALIGN_CENTER);
            f12.setHorizontalAlignment(Element.ALIGN_CENTER);
            f13.setHorizontalAlignment(Element.ALIGN_CENTER);
            f14.setHorizontalAlignment(Element.ALIGN_CENTER);
            f15.setHorizontalAlignment(Element.ALIGN_CENTER);
            f16.setHorizontalAlignment(Element.ALIGN_CENTER);
            f17.setHorizontalAlignment(Element.ALIGN_CENTER);
            f11.setBackgroundColor(GrayColor.LIGHT_GRAY);
            f12.setBackgroundColor(GrayColor.LIGHT_GRAY);
            f13.setBackgroundColor(GrayColor.LIGHT_GRAY);
            f14.setBackgroundColor(GrayColor.LIGHT_GRAY);
            f15.setBackgroundColor(GrayColor.LIGHT_GRAY);
            f16.setBackgroundColor(GrayColor.LIGHT_GRAY);
            f17.setBackgroundColor(GrayColor.LIGHT_GRAY);
            tabla.addCell(f11);
            tabla.addCell(f12);
            tabla.addCell(f13);
            tabla.addCell(f14);
            tabla.addCell(f15);
            tabla.addCell(f16);
            tabla.addCell(f17);

            doc.add(tabla);

        } catch (DocumentException ex) {
            Logger.getLogger(GenerarPDF.class.getName()).log(Level.SEVERE, null, ex);
        }
        doc.close();

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
