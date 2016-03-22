package com.eministerios.www.business.workerUi.add.controller;


import com.eministerios.www.business.entity.domain.Worker;
import com.eministerios.www.business.service.WorkerService;
import com.eministerios.www.business.util.Notifications;
import com.eministerios.www.business.validation.ValidationError;
import com.eministerios.www.business.validation.WorkerValidator;
import com.eministerios.www.business.workerUi.add.view.AddView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

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
    }

    public void addListeners(){
        addView.getBtnClearFields().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                addView.clearFields();
                workerService.findByProfession("pedreiro");
                /*DirectoryChooser dc = new DirectoryChooser();
                File file = dc.showDialog(null);
                if (file != null) {
                    String strFormat = "/Curriculo_" + employee.getName() + employee.getLastName() + ".pdf";
                    file = new File(file.getAbsolutePath() + strFormat);
                    CurriculoHelper ch = new CurriculoHelper(employee, file.toString());
                }*/
                System.out.println("Conectou");
            }
        });

        addView.getBtnCancel().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("Cancelou");
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
                    workerService.save(worker);
                }


                System.out.printf("Salvou");
            }
        });
    }
}
