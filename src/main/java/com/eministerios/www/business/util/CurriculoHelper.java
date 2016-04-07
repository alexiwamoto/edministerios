package com.eministerios.www.business.util;

import com.eministerios.www.business.entity.domain.Worker;
import com.itextpdf.text.*;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import java.util.logging.Level;
import java.util.logging.Logger;


public class CurriculoHelper {


    public CurriculoHelper(Worker emp, String path) {

        Document doc = null;
        OutputStream os = null;

        try {
            //cria o documento tamanho A4, margens de 2,54cm
            doc = new Document(PageSize.A4, 52, 52, 52, 52);

            //cria a stream de saída
            os = new FileOutputStream(path);

            try {
                //associa a stream de saída ao
                PdfWriter.getInstance(doc, os);
            } catch (DocumentException ex) {
                Logger.getLogger(CurriculoHelper.class.getName()).log(Level.SEVERE, null, ex);
            }

            //abre o documento
            doc.open();

            //adiciona o texto ao PDF
            String fullName = String.format("%1s %2s", emp.getName(), emp.getLastname());

            doc.add(titleString(fullName));
            doc.add(separatorText("INFORMAÇÕES PESSOAIS"));
            doc.add(lineSeparator());
            doc.add(simpleText("    - Tipo de profissional: " + emp.getType()));
            doc.add(simpleText("    - Profissão: " + emp.getProfession()));
            doc.add(simpleText("    - Endereço: " + emp.getAddress()));
            doc.add(simpleText("    - Email principal: " + emp.getEmail1()));
            doc.add(simpleText("    - Email secundário: " + emp.getEmail2()));
            doc.add(simpleText("    - Telefone principal: " + StringParser.transformPhone(emp.getPhone1())));
            doc.add(simpleText("    - Telefone secundário: " + StringParser.transformPhone(emp.getPhone2())));


            doc.add(separatorText("EXPERIÊNCIA PROFISSIONAL"));
            doc.add(lineSeparator());
            doc.add(separatorText("    - Descrição das competências: \n" + emp.getDescription()));

        } catch (FileNotFoundException | DocumentException ex) {
            Logger.getLogger(CurriculoHelper.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (doc != null) {
                //fechamento do documento
                doc.close();
            }
            if (os != null) {
                try {
                    //fechamento da stream de saída
                    os.close();
                } catch (IOException ex) {
                    Logger.getLogger(CurriculoHelper.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }


    }

    public static Paragraph simpleText(String text) {
        Font f = new Font(FontFamily.COURIER, 10, Font.NORMAL);
        Paragraph p = new Paragraph(text, f);
        p.setAlignment(Element.PARAGRAPH);
        return p;
    }

    public static Paragraph titleString(String text) {
        Font f = new Font(FontFamily.COURIER, 20, Font.BOLD);
        Paragraph p = new Paragraph(text, f);
        p.setAlignment(Element.ALIGN_CENTER);
        p.setSpacingAfter(20);
        return p;
    }

    public static Paragraph separatorText(String text) {
        Font f = new Font(FontFamily.COURIER, 12, Font.NORMAL);
        Paragraph p = new Paragraph(text, f);
        p.setSpacingAfter(-15);
        return p;
    }

    public static Chunk lineSeparator() {
        LineSeparator ls = new LineSeparator();
        return (new Chunk(ls));
    }


    public static Paragraph spaceLine() {
        Paragraph p = new Paragraph("");
        return p;
    }


    public static String cityStringFormat(Worker emp) {
        String formStr = String.format("    - Cidade: %1s/%3s / Bairro: %2s ", emp.getAddress());
        return formStr;
    }
}
