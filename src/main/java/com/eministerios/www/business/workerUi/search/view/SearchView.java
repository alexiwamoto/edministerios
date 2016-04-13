package com.eministerios.www.business.workerUi.search.view;

import com.eministerios.www.business.entity.domain.Worker;
import com.eministerios.www.business.workerUi.util.components.UiComponents;
import net.miginfocom.swing.MigLayout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

/**
 * Created by alexandre on 17/03/16.
 */
@Component
public class SearchView extends JPanel{
    private JLabel lblSearch;

    private JTextField tfSearchItem;

    private JButton btnSearch;

    private JTable tblList;
    private JButton btnShow;
    private UiComponents uiComponents;

    private Worker worker;

    @Autowired
    public SearchView(UiComponents uiComponents) {
        this.uiComponents = uiComponents;
        initialize();
    }

    private void initialize() {
        uiComponents = new UiComponents();
        setUpLayout();
        createSearchFieldPanel();
        createFoundListPanel();
        createButtonsPanel();

    }

    private void setUpLayout(){
        setLayout(new BorderLayout(0, 0));
    }

    private void createSearchFieldPanel(){
        JPanel listPanel = new JPanel();
        uiComponents.createStandartPanel(listPanel, new MigLayout("", "[][grow][]","[]"));


        lblSearch = new JLabel();
        uiComponents.createStandardLabel(lblSearch, "Buscar Profissão:");
        listPanel.add(lblSearch,"cell 0 0 , growx, alignx left");

        tfSearchItem = new JTextField();
        uiComponents.createStandardTF(tfSearchItem, "Ex. Pedreiro");
        listPanel.add(tfSearchItem, "cell 1 0, growx");

        btnSearch = new JButton();
        uiComponents.createStandardButton(btnSearch, "Buscar");
        listPanel.add(btnSearch, "cell 2 0, alignx right");

        add(listPanel, BorderLayout.PAGE_START);
    }

    private void createFoundListPanel(){
        JPanel listPanel = new JPanel();
        uiComponents.createStandartPanel(listPanel, new MigLayout("", "[][grow][]","[grow]"));

        JScrollPane scrollPane = new JScrollPane();
        listPanel.add(scrollPane, "cell 1 0, growx, growy");

        tblList = new JTable();
        tblList.setFillsViewportHeight(true);
        scrollPane.setViewportView(tblList);

        add(listPanel, BorderLayout.CENTER);
    }

    private void createButtonsPanel(){
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        String pix = String.valueOf(dimension.getWidth()-200);
        JPanel buttonPanel = new JPanel();
        uiComponents.createStandartPanel(buttonPanel, new MigLayout("", "[20%][20%][20%][25%][15%]", "[grow]"));

        btnShow = new JButton();
        uiComponents.createStandardButton(btnShow, "Visualizar");
        buttonPanel.add(btnShow, "cell 2 0 , growx, alignx center");

        JLabel imgLabel = new JLabel();
        ImageIcon imageIcon = new ImageIcon(new ImageIcon(getClass().getClassLoader().getResource("img/logo.png")).getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
        imgLabel.setIcon(imageIcon);
        buttonPanel.add(imgLabel, "cell 4 0, alignx left");

        this.add(buttonPanel, BorderLayout.PAGE_END);
    }

    public JButton getBtnSearch() {
        return btnSearch;
    }

    public JButton getBtnShow() {
        return btnShow;
    }

    public JTextField getTfSearchItem() {
        return tfSearchItem;
    }

    public JTable getTblList() {
        return tblList;
    }

    public void clearTextField(){
        tfSearchItem.setText("");
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }
}
