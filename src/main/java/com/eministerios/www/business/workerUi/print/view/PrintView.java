package com.eministerios.www.business.workerUi.print.view;

import com.eministerios.www.business.entity.domain.Worker;
import com.eministerios.www.business.workerUi.util.components.UiComponents;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

/**
 * Created by alexandre on 22/03/16.
 */
@Component
public class PrintView extends JFrame{

    private JPanel infoPanel;

    private JPanel commandsPanel;

    private JButton btnPrint;

    private UiComponents uiComponents;

    private Worker worker;

    @Autowired
    public PrintView(UiComponents uiComponents){
        this.uiComponents = uiComponents;
        initialize();
    }

    public void initialize(){
        setUpLayout();
        basicControl();
        addComponents();
    }

    public void setUpLayout(){
        setTitle("Profissional");
        setSize(400, 600);
        setLocation(300,100);
        setLayout(new BorderLayout(0,0));
    }

    public void basicControl(){
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public void addComponents(){
        createCommandsPanel();

        createInfoPanel();


    }

    public void createInfoPanel(){
        infoPanel = new JPanel();
        infoPanel.setBackground(Color.WHITE);

        this.add(infoPanel, BorderLayout.CENTER);
    }

    public void createCommandsPanel(){
        commandsPanel = new JPanel();
        commandsPanel.setBackground(Color.WHITE);

        btnPrint = new JButton();
        uiComponents.createStandardButton(btnPrint, "Imprimir");

        commandsPanel.add(btnPrint);

        this.add(commandsPanel, BorderLayout.SOUTH);
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }
}
