package com.eministerios.www.business.workerUi.add.view;


import com.eministerios.www.business.entity.domain.Worker;
import com.eministerios.www.business.workerUi.util.components.UiComponents;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.swingx.prompt.PromptSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.text.ParseException;

/**
 * Created by alexandre on 04/03/16.
 */
@Component
public class AddView extends JPanel {

    private JTextField tfEmail1;
    private JTextField tfEmail2;
    private JTextField tfName;
    private JTextField tfLastName;
    private JTextField tfAddress;
    private JFormattedTextField tfPhone1;
    private JFormattedTextField tfPhone2;
    private JTextField tfProfession;
    private JTextArea tfDescription;

    private JButton btnSave;
    private JButton btnCancel;
    private JButton btnClearFields;

    private JRadioButton radioButtonAutonomous;
    private JRadioButton radioButtonBusinessMan;
    private JRadioButton radioButtonFreeLancer;

    private UiComponents uiComponents;

    private Long id;
    private boolean isEdit = false;

    @Autowired
    public AddView(UiComponents uiComponents) {
        this.uiComponents = uiComponents;
        initialize();
    }

    private void initialize() {
        setUpLayout();
        addComponents();

    }

    public void setUpLayout(){
        setLayout(new BorderLayout(0, 0));
    }


    public void addComponents(){

        createLogoPanel();

        createDataPanel();

        createButtonPanel();
    }

    public void createLogoPanel(){
        JLabel imgLabel = new JLabel();
        ImageIcon imageIcon = new ImageIcon(new ImageIcon(getClass().getClassLoader().getResource("img/logo.png")).getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
        imgLabel.setIcon(imageIcon);

        JPanel imagePanel = new JPanel();
        uiComponents.createStandartPanel(imagePanel, new MigLayout("", "[][][]", "[]"));

        imagePanel.setSize(30,30);
        imagePanel.add(imgLabel, "cell 0 0");

        add(imagePanel, BorderLayout.NORTH);
    }

    public void createDataPanel(){
        JPanel dataPanel = new JPanel();
        uiComponents.createStandartPanel(dataPanel, new MigLayout("", "[][grow]", "[][][][][][][][][][]"));

        JLabel lblName = new JLabel();
        uiComponents.createStandardLabel(lblName, "Nome:");

        tfName = new JTextField();
        uiComponents.createStandardTF(tfName,"João");

        JLabel lblLastName = new JLabel();
        uiComponents.createStandardLabel(lblLastName, "Sobrenome:");

        tfLastName = new JTextField();
        uiComponents.createStandardTF(tfLastName, "Silva");

        JLabel lblType = new JLabel();
        uiComponents.createStandardLabel(lblType, "Tipo:");

        ButtonGroup bg = new ButtonGroup();
        radioButtonAutonomous = new JRadioButton();
        radioButtonAutonomous.setSelected(true);
        radioButtonBusinessMan = new JRadioButton();
        radioButtonFreeLancer = new JRadioButton();

        uiComponents.createStandardRadioButton(radioButtonAutonomous, "Autônomo");
        uiComponents.createStandardRadioButton(radioButtonBusinessMan, "Empresário");
        uiComponents.createStandardRadioButton(radioButtonFreeLancer, "Free Lancer");

        bg.add(radioButtonAutonomous);
        bg.add(radioButtonBusinessMan);
        bg.add(radioButtonFreeLancer);

        JLabel lblAddress = new JLabel();
        uiComponents.createStandardLabel(lblAddress, "Endereço:");

        tfAddress = new JTextField();
        uiComponents.createStandardTF(tfAddress, "Rua 10 , 10");

        JLabel lblEmail1 = new JLabel();
        uiComponents.createStandardLabel(lblEmail1, "Email 1:");

        tfEmail1 = new JTextField();
        uiComponents.createStandardTF(tfEmail1, "joao1@email.com");

        JLabel lblEmail2 = new JLabel();
        uiComponents.createStandardLabel(lblEmail2, "Email 2:");

        tfEmail2 = new JTextField();
        uiComponents.createStandardTF(tfEmail2, "joao2@email.com");

        JLabel lblPhone1 = new JLabel();
        uiComponents.createStandardLabel(lblPhone1, "Phone 1:");

        try {
            tfPhone1 = new JFormattedTextField(new MaskFormatter("(##)*####-####"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        uiComponents.createStandardFTF(tfPhone1, "11999999999");

        JLabel lblPhone2 = new JLabel();
        uiComponents.createStandardLabel(lblPhone2, "Phone 2:");

        try {
            tfPhone2 = new JFormattedTextField(new MaskFormatter("(##)*####-####"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        uiComponents.createStandardFTF(tfPhone2, "11999999999");

        JLabel lblProfession = new JLabel();
        uiComponents.createStandardLabel(lblProfession, "Profissão:");

        tfProfession = new JTextField();
        uiComponents.createStandardTF(tfProfession, "Pedreiro");

        JLabel lblDescription = new JLabel();
        uiComponents.createStandardLabel(lblDescription, "Descrição:");


        tfDescription = new JTextArea(5,10);
        uiComponents.createStandardTA(tfDescription, "Ex. Profissional habilitado a trabalhar na área de construção civil.");


        dataPanel.add(lblName, "cell 0 0");
        dataPanel.add(tfName, "cell 1 0,growx");
        dataPanel.add(lblLastName, "cell 0 1");
        dataPanel.add(tfLastName, "cell 1 1,growx");
        dataPanel.add(lblType, "cell 0 2");
        dataPanel.add(radioButtonAutonomous,"cell 1 2");
        dataPanel.add(radioButtonBusinessMan, "cell 1 2");
        dataPanel.add(radioButtonFreeLancer, "cell 1 2");
        dataPanel.add(lblAddress, "cell 0 3");
        dataPanel.add(tfAddress, "cell 1 3,growx");
        dataPanel.add(lblEmail1, "cell 0 4");
        dataPanel.add(tfEmail1, "cell 1 4,growx");
        dataPanel.add(lblEmail2, "cell 0 5");
        dataPanel.add(tfEmail2, "cell 1 5,growx");
        dataPanel.add(lblPhone1, "cell 0 6");
        dataPanel.add(tfPhone1, "cell 1 6,growx");
        dataPanel.add(lblPhone2, "cell 0 7");
        dataPanel.add(tfPhone2, "cell 1 7,growx");
        dataPanel.add(lblProfession, "cell 0 8");
        dataPanel.add(tfProfession, "cell 1 8,growx");
        dataPanel.add(lblDescription, "cell 0 9");
        dataPanel.add(tfDescription, "cell 1 9,growx");

        add(dataPanel, BorderLayout.CENTER);
    }

    public void createButtonPanel(){
        JPanel dataPanel = new JPanel();
        uiComponents.createStandartPanel(dataPanel, new MigLayout("", "[120px][][][]", "[]"));

        btnClearFields = new JButton();
        btnSave = new JButton("Salvar");
        //btnSave.setIcon(new ImageIcon(getClass().getResource("/images/saveIcon.png")));
        dataPanel.add(uiComponents.createStandardButton(btnClearFields, "Limpar Campos"), "cell 1 0");

        btnCancel = new JButton();
        dataPanel.add(uiComponents.createStandardButton(btnCancel,"Cancelar"), "cell 2 0");

        btnSave = new JButton();
        dataPanel.add(uiComponents.createStandardButton(btnSave,"Salvar"), "cell 3 0");

        add(dataPanel, BorderLayout.SOUTH);
    }

    public Worker getWorkerFromForm(){
        Worker worker = new Worker();
        worker.setName(tfName.getText());
        worker.setLastname(tfLastName.getText());
        worker.setType(getSelected());
        worker.setAddress(tfAddress.getText());
        worker.setEmail1(tfEmail1.getText());
        worker.setEmail2(tfEmail2.getText());
        String phone = tfPhone1.getText().replace("(","").replace(")","").replace("-","");
        worker.setPhone1(phone);
        String phone2 = tfPhone2.getText().replace("(","").replace(")","").replace("-","");
        worker.setPhone2(phone2);
        worker.setProfession(tfProfession.getText());
        worker.setDescription(tfDescription.getText());
        return worker;
    }

    public void clearFields(){
        tfName.setText("");
        tfLastName.setText("");
        radioButtonAutonomous.setSelected(true);
        tfAddress.setText("");
        tfEmail1.setText("");
        tfEmail2.setText("");
        tfPhone1.setText("");
        tfPhone2.setText("");
        tfProfession.setText("");
        tfDescription.setText("");
    }

    public String getSelected(){
        if(radioButtonAutonomous.isSelected())
            return "Autônomo";
        else if(radioButtonBusinessMan.isSelected())
            return "Empresário";
        else
            return  "Free Lancer";
    }

    public JTextField getTfEmail1() {
        return tfEmail1;
    }

    public void setTfEmail1(JTextField tfEmail1) {
        this.tfEmail1 = tfEmail1;
    }

    public JTextField getTfEmail2() {
        return tfEmail2;
    }

    public void setTfEmail2(JTextField tfEmail2) {
        this.tfEmail2 = tfEmail2;
    }

    public JTextField getTfName() {
        return tfName;
    }

    public void setTfName(JTextField tfName) {
        this.tfName = tfName;
    }

    public JTextField getTfLastName() {
        return tfLastName;
    }

    public void setTfLastName(JTextField tfLastName) {
        this.tfLastName = tfLastName;
    }

    public JRadioButton getRadioButtonAutonomous() {
        return radioButtonAutonomous;
    }

    public void setRadioButtonAutonomous(JRadioButton radioButtonAutonomous) {
        this.radioButtonAutonomous = radioButtonAutonomous;
    }

    public JRadioButton getRadioButtonBusinessMan() {
        return radioButtonBusinessMan;
    }

    public void setRadioButtonBusinessMan(JRadioButton radioButtonBusinessMan) {
        this.radioButtonBusinessMan = radioButtonBusinessMan;
    }

    public JRadioButton getRadioButtonFreeLancer() {
        return radioButtonFreeLancer;
    }

    public void setRadioButtonFreeLancer(JRadioButton radioButtonFreeLancer) {
        this.radioButtonFreeLancer = radioButtonFreeLancer;
    }

    public JTextField getTfAddress() {
        return tfAddress;
    }

    public void setTfAddress(JTextField tfAddress) {
        this.tfAddress = tfAddress;
    }

    public JFormattedTextField getTfPhone1() {
        return tfPhone1;
    }

    public void setTfPhone1(JFormattedTextField tfPhone1) {
        this.tfPhone1 = tfPhone1;
    }

    public JFormattedTextField getTfPhone2() {
        return tfPhone2;
    }

    public void setTfPhone2(JFormattedTextField tfPhone2) {
        this.tfPhone2 = tfPhone2;
    }

    public JTextField getTfProfession() {
        return tfProfession;
    }

    public void setTfProfession(JTextField tfProfession) {
        this.tfProfession = tfProfession;
    }

    public JTextArea getTfDescription() {
        return tfDescription;
    }

    public void setTfDescription(JTextArea tfDescription) {
        this.tfDescription = tfDescription;
    }

    public JButton getBtnSave() {
        return btnSave;
    }

    public void setBtnSave(JButton btnSave) {
        this.btnSave = btnSave;
    }

    public JButton getBtnCancel() {
        return btnCancel;
    }

    public void setBtnCancel(JButton btnCancel) {
        this.btnCancel = btnCancel;
    }

    public JButton getBtnClearFields() {
        return btnClearFields;
    }

    public void setBtnClearFields(JButton btnClearFields) {
        this.btnClearFields = btnClearFields;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isEdit() {
        return isEdit;
    }

    public void setEdit(boolean edit) {
        isEdit = edit;
    }

}
