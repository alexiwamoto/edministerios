package com.eministerios.www.business.workerUi.list.view;

import com.eministerios.www.business.workerUi.util.components.UiComponents;
import net.miginfocom.swing.MigLayout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
public class ListView extends JPanel {

    private JButton btnEdit;

    private JButton btnDelete;

    private JTable tblListWorkers;

    private UiComponents uiComponents;

    @Autowired
    public ListView(UiComponents uiComponents) {
        this.uiComponents = uiComponents;
        initialize();
    }

    private void initialize() {
        //uiComponents = new UiComponents();
        setUpLayout();
        createListPanel();
        createButtonsPanel();
    }

    private void setUpLayout() {
        setLayout(new BorderLayout(0, 0));
    }

    private void createListPanel() {

        JPanel listPanel = new JPanel();
        uiComponents.createStandartPanel(listPanel, new MigLayout("", "[][grow][]","[]"));

        JScrollPane scrollPaneListWorkers = new JScrollPane();
        listPanel.add(scrollPaneListWorkers, "cell 1 0, growx, growy");

        tblListWorkers = new JTable();
        tblListWorkers.setFillsViewportHeight(true);

        scrollPaneListWorkers.setViewportView(tblListWorkers);

        this.add(listPanel, BorderLayout.CENTER);
    }

    private void createButtonsPanel(){
        JPanel buttonsPanel = new JPanel();
        uiComponents.createStandartPanel(buttonsPanel, new MigLayout("", "[][][][][][]", "[grow]"));

        btnEdit = new JButton();
        uiComponents.createStandardButton(btnEdit, "Editar");
        buttonsPanel.add(btnEdit, "cell 2 0 , growx, alignx center");

        btnDelete = new JButton();
        uiComponents.createStandardButton(btnDelete, "Remover");
        buttonsPanel.add(btnDelete, "cell 3 0 , growx, alignx center");

        this.add(buttonsPanel, BorderLayout.PAGE_END);
    }

    public JButton getBtnEdit() {
        return btnEdit;
    }

    public void setBtnEdit(JButton btnEdit) {
        this.btnEdit = btnEdit;
    }

    public JButton getBtnDelete() {
        return btnDelete;
    }

    public void setBtnDelete(JButton btnDelete) {
        this.btnDelete = btnDelete;
    }

    public JTable getTblListWorkers() {
        return tblListWorkers;
    }

    public void setTblListWorkers(JTable tblListWorkers) {
        this.tblListWorkers = tblListWorkers;
    }

    /*private void createSpeedPanel() {
        JPanel speedPanel = new JPanel();
        speedPanel.setLayout(new MigLayout("", "[][700px][]", "[20px][150px]"));
        speedPanel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED), "Measurement"));

        JPanel innerSpeedPanel = new JPanel();
        innerSpeedPanel.setBorder(new BevelBorder(BevelBorder.RAISED));
        innerSpeedPanel.setBackground(Color.DARK_GRAY);
        speedPanel.add(innerSpeedPanel, "cell 1 1, align center, growx");

        speedLbl = new JLabel();
        speedLbl.setFont(speedFont);
        speedLbl.setForeground(Color.GREEN);
        innerSpeedPanel.add(speedLbl, "cell 1 1, align center");

        this.add(speedPanel, "cell 0 1");
    }

    private void createMessageLog() {

        messageLogTxa = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(messageLogTxa);

        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(new TitledBorder("Message Log"));

        add(scrollPane, "cell 0 2, growx, growy");
    }*/

/*    public void showSpeed(Integer speed) {
        speedLbl.setText(speed.toString());
    }*/


}

/*
public class MainMenu extends javax.swing.JFrame {

    private DatabaseConnector dbConnector = new DatabaseConnector();

    DefaultTableModel userTableModel = new DefaultTableModel();

    public void refreshCustomersList() throws SQLException, ClassNotFoundException {

        UserBeanList userList = dbConnector.getUserData();

        userListModel.clear();

        for (int i = 0; i < userList.size(); i++) {
            UserBean userBean = userList.getUserBeanAt(i);

            String[] data = new String[3];

            data[0] = userBean.getCustomerID();
            data[1] = userBean.getFirstName();
            data[2] = userBean.getLastName();

            userTableModel.addRow(data);
        }
        tableCustomers.setModel(userTableModel);
    }*/

/*    DefaultTableModel userTableModel =
            new DefaultTableModel( new Object[]{ "Customer id", "First name", "Last name" }, 0 );*/

/*

setBorder(null);
        setBackground(new Color(51, 102, 153));

        setBackground(new Color(51, 102, 153));
        setLayout(new MigLayout("", "[][82px,grow]", "[][][][][][][][][][][][][58.00,grow][][][][][][]"));

        btnCalibration = new JButton("");
        add(btnCalibration, "cell 0 0 1 2,grow");
        btnCalibration.setIcon(new ImageIcon(getClass().getResource("/images/calibration.png")));
        btnCalibration.setBackground(new Color(51, 102, 153));
lblBelow = new JLabel("Abaixo de 100 Km");
        lblBelow.setFont(new Font("Arial", Font.PLAIN, 12));
        lblBelow.setForeground(Color.WHITE);
        add(lblBelow, "cell 2 14,alignx right,aligny center");

        textDecimal = new JSpinner();
        textDecimal.setFont(new Font("Arial", Font.PLAIN, 12));
        textDecimal.setModel(new SpinnerNumberModel(0, 0, 100, 1));
        add(textDecimal, "flowx,cell 3 14,alignx left");

        lblKilometer = new JLabel("Km");
        lblKilometer.setFont(new Font("Arial", Font.PLAIN, 12));
        lblKilometer.setForeground(new Color(255, 255, 255));
        add(lblKilometer, "cell 3 14");

        chcDecimal = new JCheckBox("");
        chcDecimal.setHorizontalAlignment(SwingConstants.LEFT);
        chcDecimal.setSelected(true);
        chcDecimal.setForeground(new Color(255, 255, 255));
        chcDecimal.setBackground(new Color(51, 102, 153));
        add(chcDecimal, "cell 3 14,alignx left");*/




 /*   I use to override the text fields paint method, until I ended up with more custom text fields then I really wanted...

        Then I found this prompt API which is simple to use and doesn't require you to extend any components. It also has a nice "buddy" API

        This has now been included in the SwingLabs, SwingX library which makes it even eaiser to use...

        For example (this uses SwingX-1.6.4)

        PromptSupport

        import java.awt.BorderLayout;
        import java.awt.EventQueue;
        import java.awt.Font;
        import java.awt.GridBagConstraints;
        import java.awt.GridBagLayout;
        import javax.swing.JFrame;
        import javax.swing.JTextField;
        import javax.swing.UIManager;
        import javax.swing.UnsupportedLookAndFeelException;
        import org.jdesktop.swingx.prompt.PromptSupport;*/

/*public class PromptExample {

    public static void main(String[] args) {
        new PromptExample();
    }

    public PromptExample() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JTextField bunnies = new JTextField(10);
                JTextField ponnies = new JTextField(10);
                JTextField unicorns = new JTextField(10);
                JTextField fairies = new JTextField(10);

                PromptSupport.setPrompt("Bunnies", bunnies);
                PromptSupport.setPrompt("Ponnies", ponnies);
                PromptSupport.setPrompt("Unicorns", unicorns);
                PromptSupport.setPrompt("Fairies", fairies);

                PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.HIDE_PROMPT, bunnies);
                PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.HIGHLIGHT_PROMPT, ponnies);
                PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.SHOW_PROMPT, unicorns);

                PromptSupport.setFontStyle(Font.BOLD, bunnies);
                PromptSupport.setFontStyle(Font.ITALIC, ponnies);
                PromptSupport.setFontStyle(Font.ITALIC | Font.BOLD, unicorns);

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new GridBagLayout());
                GridBagConstraints gbc = new GridBagConstraints();
                gbc.gridwidth = GridBagConstraints.REMAINDER;
                frame.add(bunnies, gbc);
                frame.add(ponnies, gbc);
                frame.add(unicorns, gbc);
                frame.add(fairies, gbc);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

}*/


