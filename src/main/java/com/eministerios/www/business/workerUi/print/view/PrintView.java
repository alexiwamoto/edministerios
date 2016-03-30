package com.eministerios.www.business.workerUi.print.view;

import com.eministerios.www.business.entity.domain.Worker;
import com.eministerios.www.business.workerUi.util.components.UiComponents;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.swingx.JXLabel;
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

    private JLabel lblName;
    private JLabel lblLastName;
    private JLabel lblType;
    private JLabel lblAddress;
    private JLabel lblEmail1;
    private JLabel lblEmail2;
    private JLabel lblPhone1;
    private JLabel lblPhone2;
    private JLabel lblProfession;
    private JTextArea lblDescription;

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
        infoPanel.setLayout(new MigLayout("", "[40px][grow][20px]", "[40px][][][][][][][][][][][grow]"));

        JLabel lblTitle = new JLabel("Dados do Profissional:");
        lblTitle.setFont(new Font("Verdana", Font.BOLD, 18));
        infoPanel.add(lblTitle, "cell 1 1");

        lblName = new JLabel();
        lblName.setFont(new Font("Verdana", Font.ITALIC, 14));
        infoPanel.add(lblName,"cell 1 2");

        lblLastName = new JLabel();
        lblLastName.setFont(new Font("Verdana", Font.ITALIC, 14));
        infoPanel.add(lblLastName, "cell 1 2");

        lblType = new JLabel();
        lblType.setFont(new Font("Verdana", Font.ITALIC, 14));
        infoPanel.add(lblType,"cell 1 3");

        lblAddress = new JLabel();
        lblAddress.setFont(new Font("Verdana", Font.ITALIC, 14));
        infoPanel.add(lblAddress, "cell 1 4");

        lblEmail1 = new JLabel();
        lblEmail1.setFont(new Font("Verdana", Font.ITALIC, 14));
        infoPanel.add(lblEmail1, "cell 1 5");

        lblEmail2 = new JLabel();
        lblEmail2.setFont(new Font("Verdana", Font.ITALIC, 14));
        infoPanel.add(lblEmail2, "cell 1 6");

        lblPhone1 = new JLabel();
        lblPhone1.setFont(new Font("Verdana", Font.ITALIC, 14));
        infoPanel.add(lblPhone1, "cell 1 7");

        lblPhone2 = new JLabel();
        lblPhone2.setFont(new Font("Verdana", Font.ITALIC, 14));
        infoPanel.add(lblPhone2, "cell 1 8");

        lblProfession = new JLabel();
        lblProfession.setFont(new Font("Verdana", Font.ITALIC, 14));
        infoPanel.add(lblProfession, "cell 1 9");

        lblDescription = new JTextArea();
        lblDescription.setEditable(false);
        lblDescription.setFont(new Font("Verdana", Font.ITALIC, 14));
        lblDescription.setBorder(null);
        lblDescription.setLineWrap(true);
        infoPanel.add(lblDescription, "cell 1 10, growx");

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

    public JTextArea getLblDescription() {
        return lblDescription;
    }

    public void setLblDescription(JTextArea lblDescription) {
        this.lblDescription = lblDescription;
    }

    public JLabel getLblName() {
        return lblName;
    }

    public void setLblName(JLabel lblName) {
        this.lblName = lblName;
    }

    public JLabel getLblLastName() {
        return lblLastName;
    }

    public void setLblLastName(JLabel lblLastName) {
        this.lblLastName = lblLastName;
    }

    public JLabel getLblType() {
        return lblType;
    }

    public void setLblType(JLabel lblType) {
        this.lblType = lblType;
    }

    public JLabel getLblAddress() {
        return lblAddress;
    }

    public void setLblAddress(JLabel lblAddress) {
        this.lblAddress = lblAddress;
    }

    public JLabel getLblEmail1() {
        return lblEmail1;
    }

    public void setLblEmail1(JLabel lblEmail1) {
        this.lblEmail1 = lblEmail1;
    }

    public JLabel getLblEmail2() {
        return lblEmail2;
    }

    public void setLblEmail2(JLabel lblEmail2) {
        this.lblEmail2 = lblEmail2;
    }

    public JLabel getLblPhone1() {
        return lblPhone1;
    }

    public void setLblPhone1(JLabel lblPhone1) {
        this.lblPhone1 = lblPhone1;
    }

    public JLabel getLblPhone2() {
        return lblPhone2;
    }

    public void setLblPhone2(JLabel lblPhone2) {
        this.lblPhone2 = lblPhone2;
    }

    public JLabel getLblProfession() {
        return lblProfession;
    }

    public void setLblProfession(JLabel lblProfession) {
        this.lblProfession = lblProfession;
    }
}
