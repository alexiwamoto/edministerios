package com.eministerios.www.business.workerUi.add.controller;


import com.eministerios.www.business.entity.domain.Worker;
import com.eministerios.www.business.service.WorkerService;
import com.eministerios.www.business.util.Notifications;
import com.eministerios.www.business.validation.ValidationError;
import com.eministerios.www.business.validation.WorkerValidator;
import com.eministerios.www.business.workerUi.add.view.AddView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Optional;

/**
 * Created by alexandre on 07/03/16.
 */
@Controller
public class AddController {

    private AddView addView;

    private WorkerService workerService;

    private WorkerValidator workerValidator;


    @Autowired
    public AddController(AddView addView, WorkerService workerService, WorkerValidator workerValidator){
        this.workerService = workerService;
        this.addView = addView;
        this.workerValidator = workerValidator;
        addListeners();
        addAncestorListener();
    }

    public void addListeners(){
        addView.getBtnClearFields().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                addView.clearFields();
            }
        });

        addView.getBtnCancel().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                addView.clearFields();
            }
        });

        addView.getBtnSave().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Worker worker = addView.getWorkerFromForm();
                Optional<ValidationError> errors = workerValidator.validate(worker);
                if (errors.isPresent()) {
                    ValidationError validationError = errors.get();
                    Notifications.showFormValidationAlert(validationError.getMessage());
                } else {
                    if(addView.isEdit())
                        worker.setId(addView.getId());
                    workerService.save(worker);
                    JOptionPane.showMessageDialog(null, "Cadastro feito com sucesso",
                            "Sucesso.", JOptionPane.PLAIN_MESSAGE);
                    addView.clearFields();
                }
                addView.setEdit(false);
            }
        });
    }

    public void addAncestorListener() {
        addView.addAncestorListener(new AncestorListener() {
            @Override
            public void ancestorAdded(AncestorEvent event) {

            }

            @Override
            public void ancestorRemoved(AncestorEvent event) {
                addView.clearFields();
            }

            @Override
            public void ancestorMoved(AncestorEvent event) {
            }
        });
    }

}
