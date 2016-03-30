package com.eministerios.www.business.workerUi.print.controller;

import com.eministerios.www.business.workerUi.print.view.PrintView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by alexandre on 22/03/16.
 */
@Controller
public class PrintController {

    private PrintView printView;

    @Autowired
    public PrintController(PrintView printView) {
        this.printView = printView;
    }
}
