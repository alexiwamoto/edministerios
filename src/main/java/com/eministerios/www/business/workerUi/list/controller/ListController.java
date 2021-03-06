package com.eministerios.www.business.workerUi.list.controller;

import com.eministerios.www.business.entity.domain.Worker;
import com.eministerios.www.business.service.WorkerService;
import com.eministerios.www.business.workerUi.add.view.AddView;
import com.eministerios.www.business.workerUi.list.model.WorkerTableModel;
import com.eministerios.www.business.workerUi.list.view.ListView;
import com.eministerios.www.business.workerUi.main.view.MainView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Created by alexandre on 07/03/16.
 */
@Controller
public class ListController {
    private WorkerService workerService;

    private WorkerTableModel workerTableModel;

    private ListView listView;

    private AddView addView;

    @Autowired
    public ListController(ListView listView, AddView addView, WorkerService workerService) {
        this.listView = listView;
        this.addView = addView;
        this.workerService = workerService;
        addModel();
        fillTable();
        addListeners();
        addAncestorListener();
    }

    public void addModel() {
        workerTableModel = new WorkerTableModel();
        listView.getTblListWorkers().setModel(workerTableModel);
        listView.getTblListWorkers().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

    }

    public void fillTable() {
        clearTable();
        List<Worker> workers = workerService.findAll();
        workerTableModel.addItems(workers);
    }

    public void addListeners() {
        listView.getBtnEdit().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                fillEditFields();
            }
        });

        listView.getBtnDelete().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int result = JOptionPane.showConfirmDialog(null, "Deseja Realmente excluir o item selecionado?",
                        "Atenção.", JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION) {
                    deleteItem();
                }
                fillTable();
                addView.clearFields();
            }
        });

    }

    public void fillEditFields() {
        int selectedRow = listView.getTblListWorkers().getSelectedRow();
        MainView.getTabbedPane().setSelectedIndex(0);
        Worker worker = workerTableModel.getItem(selectedRow);
        addView.getTfName().setText(worker.getName());
        addView.getTfLastName().setText(worker.getLastname());
        setSelected(worker.getType());
        addView.getTfAddress().setText(worker.getAddress());
        setChurch(worker.getChurch());
        addView.getTfEmail1().setText(worker.getEmail1());
        addView.getTfEmail2().setText(worker.getEmail2());
        addView.getTfPhone1().setText(worker.getPhone1());
        addView.getTfPhone2().setText(worker.getPhone2());
        addView.getTfProfession().setText(worker.getProfession());
        addView.getTfDescription().setText(worker.getDescription());
        addView.setId(worker.getId());
        addView.setEdit(true);
    }

    public void setSelected(String type) {
        switch (type){
            case "Autônomo":
                addView.getRadioButtonAutonomous().setSelected(true);
                addView.getRadioButtonBusinessMan().setSelected(false);
                addView.getRadioButtonFreeLancer().setSelected(false);
                break;
            case "Empresário":
                addView.getRadioButtonAutonomous().setSelected(false);
                addView.getRadioButtonBusinessMan().setSelected(true);
                addView.getRadioButtonFreeLancer().setSelected(false);
                break;
            case "Free Lancer":
                addView.getRadioButtonAutonomous().setSelected(false);
                addView.getRadioButtonBusinessMan().setSelected(false);
                addView.getRadioButtonFreeLancer().setSelected(true);
                break;
        }
    }

    public void setChurch(String type) {
        switch (type){
            case "Sede":
                addView.getRadioButtonCenter().setSelected(true);
                addView.getRadioButtonEast().setSelected(false);
                addView.getRadioButtonSouth().setSelected(false);
                break;
            case "Zona Leste":
                addView.getRadioButtonCenter().setSelected(false);
                addView.getRadioButtonEast().setSelected(true);
                addView.getRadioButtonSouth().setSelected(false);
                break;
            case "Zona Sul":
                addView.getRadioButtonCenter().setSelected(false);
                addView.getRadioButtonEast().setSelected(false);
                addView.getRadioButtonSouth().setSelected(true);
                break;
        }
    }

    public void deleteItem() {
        int selectedRow = listView.getTblListWorkers().getSelectedRow();
        Worker worker = workerTableModel.getItem(selectedRow);
        workerService.remove(worker);
    }

    public void addAncestorListener() {
        addView.addAncestorListener(new AncestorListener() {
            @Override
            public void ancestorAdded(AncestorEvent event) {
            }

            @Override
            public void ancestorRemoved(AncestorEvent event) {
                fillTable();
            }

            @Override
            public void ancestorMoved(AncestorEvent event) {
            }
        });
    }

    public void clearTable() {
        workerTableModel.clear();
    }

}
