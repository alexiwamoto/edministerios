package com.eministerios.www.business.workerUi.main.view;


import com.eministerios.www.business.workerUi.add.view.AddView;
import com.eministerios.www.business.workerUi.list.view.ListView;
import com.eministerios.www.business.workerUi.search.view.SearchView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

/**
 * Created by alexandre on 04/03/16.
 */
@Component
public class MainView extends JFrame{

    private AddView addPanel;
    private ListView listViewPanel;
    private SearchView searchViewPanel;
    private static JTabbedPane tabbedPane = null;

    @Autowired
    public MainView(AddView addPanel, ListView listViewPanel, SearchView searchViewPanel){
        this.addPanel = addPanel;
        this.listViewPanel = listViewPanel;
        this.searchViewPanel = searchViewPanel;
        initialize();
    }

    private void initialize() {
        setUpLayout();
        basicControl();
        addComponents();
    }

    public void setUpLayout(){
        setTitle("Projeto Escola de Ministérios");
        setSize(600, 500);
        setLocation(300,100);
/*        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            // If Nimbus is not available, you can set the GUI to another look and feel.
        }*/
    }

    public void basicControl(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void addComponents(){
        tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        add(tabbedPane, BorderLayout.CENTER);

        tabbedPane.addTab("Cadastro", null, addPanel, null);

        tabbedPane.addTab("Edição", null, listViewPanel, null);

        tabbedPane.addTab("Busca", null, searchViewPanel, null);
    }

    public AddView getAddPanel() {
        return addPanel;
    }

    public ListView getListViewPanel() {
        return listViewPanel;
    }

    public SearchView getSearchViewPanel() {
        return searchViewPanel;
    }

    public static JTabbedPane getTabbedPane() {
        return tabbedPane;
    }
}
