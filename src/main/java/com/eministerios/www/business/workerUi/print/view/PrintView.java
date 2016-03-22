package com.eministerios.www.business.workerUi.print.view;

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

    public PrintView(){
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
        infoPanel = new JPanel();
        infoPanel.setBackground(Color.BLACK);
        infoPanel.setSize(200,600);
        commandsPanel = new JPanel();
        commandsPanel.setBackground(Color.BLUE);
        commandsPanel.setSize(300,600);
        add(infoPanel, BorderLayout.PAGE_START);

        add(commandsPanel, BorderLayout.SOUTH);
    }
}
