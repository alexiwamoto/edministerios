package com.eministerios.www.business.workerUi.search.controller;


import com.eministerios.www.business.entity.domain.Worker;
import com.eministerios.www.business.service.WorkerService;
import com.eministerios.www.business.workerUi.list.model.WorkerTableModel;
import com.eministerios.www.business.workerUi.print.view.PrintView;
import com.eministerios.www.business.workerUi.search.view.SearchView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Created by alexandre on 17/03/16.
 */
@Controller
public class SearchController {
    private WorkerTableModel workerTableModel;

    private SearchView searchView;

    private PrintView printView;

    private WorkerService workerService;

    @Autowired
    public SearchController(SearchView searchView, PrintView printView, WorkerService workerService) {
        this.workerService = workerService;
        this.searchView = searchView;
        this.printView = printView;
        addListeners();
        addModel();
        addAncestorListener();
    }

    public void addListeners(){
        searchView.getBtnSearch().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                clearTable();
                String word = searchView.getTfSearchItem().getText();
                List<Worker> workers =  workerService.findByProfession(word);
                fillTable(workers);
            }
        });

        searchView.getBtnShow().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                printView.setVisible(true);

                int selectedRow = searchView.getTblList().getSelectedRow();

                Worker worker = workerTableModel.getItem(selectedRow);
                printView.setWorker(worker);
            }
        });
    }

    public void addModel(){
        workerTableModel = new WorkerTableModel();
        searchView.getTblList().setModel(workerTableModel);
    }

    public void fillTable(List<Worker> workers){
        workerTableModel.addItems(workers);
    }

    public void clearTable(){
        workerTableModel.clear();
    }

    public void addAncestorListener() {
        searchView.addAncestorListener(new AncestorListener() {
            @Override
            public void ancestorAdded(AncestorEvent event) {
                searchView.clearTextField();
                clearTable();
            }

            @Override
            public void ancestorRemoved(AncestorEvent event) {
            }

            @Override
            public void ancestorMoved(AncestorEvent event) {
            }
        });
    }
}


/*DirectoryChooser dc = new DirectoryChooser();
                File file = dc.showDialog(null);
                if (file != null) {
                    String strFormat = "/Curriculo_" + employee.getName() + employee.getLastName() + ".pdf";
                    file = new File(file.getAbsolutePath() + strFormat);
                    CurriculoHelper ch = new CurriculoHelper(employee, file.toString());
                }*/