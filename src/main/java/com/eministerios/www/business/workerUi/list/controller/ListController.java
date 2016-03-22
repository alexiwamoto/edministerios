package com.eministerios.www.business.workerUi.list.controller;

import com.eministerios.www.business.workerUi.list.view.ListView;
import com.eministerios.www.business.workerUi.main.view.MainView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by alexandre on 07/03/16.
 */
@Controller
public class ListController {

    private ListView listView;

    @Autowired
    public ListController(ListView listView) {
        this.listView = listView;
        addModel();
        addListeners();
    }

    public void addModel(){
        DefaultTableModel userTableModel =
                new DefaultTableModel( new Object[]{ "Customer id", "First name", "Last name" }, 0 );

        String[] data = new String[3];

        data[0] = "Nome";
        data[1] = "Sobrenome";
        data[2] = "Address";


        userTableModel.addRow(data);

        data[0] = "Nome";
        data[1] = "Sobrenome";
        data[2] = "Endereço";

        userTableModel.addRow(data);
        listView.getTblListWorkers().setModel(userTableModel);
        listView.getTblListWorkers().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

    }

    public void addListeners(){
        listView.getBtnEdit().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                MainView.getTabbedPane().setSelectedIndex(0);
                System.out.println("Conectou");
            }
        });

        listView.getBtnDelete().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("Cancelou");
            }
        });

    }

    //tabCliente.setSelectedIndex(0);

}
