package com.eministerios.www.business.workerUi.print.controller;

import com.eministerios.www.business.entity.domain.Worker;
import com.eministerios.www.business.util.CurriculoHelper;
import com.eministerios.www.business.util.StringParser;
import com.eministerios.www.business.workerUi.print.view.PrintView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.File;


/**
 * Created by alexandre on 22/03/16.
 */
@Controller
public class PrintController {

    private PrintView printView;

    private CurriculoHelper ch;

    private JFileChooser savefile;

    @Autowired
    public PrintController(PrintView printView) {
        this.printView = printView;
        addListeners();
    }

    public void setLabels(){
        Worker worker = printView.getWorker();
        if(worker != null){
            printView.getLblName().setText("Nome: " + worker.getName());
            printView.getLblLastName().setText(worker.getLastname());
            printView.getLblType().setText("Tipo: " + worker.getType());
            printView.getLblAddress().setText("Endereço: " + worker.getAddress());
            printView.getLblEmail1().setText("Email 1: " + worker.getEmail1());
            printView.getLblEmail2().setText("Email 2: " + worker.getEmail2());
            printView.getLblPhone1().setText("Phone 1: " + StringParser.transformPhone(worker.getPhone1()));
            printView.getLblPhone2().setText("Phone 2: " + StringParser.transformPhone(worker.getPhone2()));
            printView.getLblProfession().setText("Profissão: "+ worker.getProfession());
            printView.getLblDescription().setText("Descrição: "+ worker.getDescription());
        }

    }

    public void addListeners() {
        printView.addComponentListener ( new ComponentAdapter()
        {
            public void componentShown ( ComponentEvent e )
            {
                setLabels();
            }

            public void componentHidden ( ComponentEvent e )
            {

            }
        } );

        printView.getBtnPrint().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                createPdf();
            }
        });
    }

    public void createPdf(){
        Worker worker = printView.getWorker();
        StringBuilder nameOfFile = new StringBuilder();
        savefile = new JFileChooser();

        nameOfFile.append(worker.getName())
                .append(worker.getLastname())
                .append(".pdf");

        String filename = nameOfFile.toString();

        savefile.setSelectedFile(new File(filename));
        savefile.showSaveDialog(savefile);

        if (savefile != null) {
            try {
                ch = new CurriculoHelper(worker, savefile.getSelectedFile().toString());
                JOptionPane.showMessageDialog(null, "Arquivo criado com sucesso!", "Sucesso", JOptionPane.PLAIN_MESSAGE );
            }catch (Exception ex){
                JOptionPane.showMessageDialog(null, "Erro ao gerar arquivo...", "Erro", JOptionPane.ERROR);
            }
        }
    }
}
