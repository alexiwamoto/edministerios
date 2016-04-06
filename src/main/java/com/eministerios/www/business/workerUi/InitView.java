package com.eministerios.www.business.workerUi;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;

/**
 * Created by alexandre on 06/04/16.
 */
public class InitView extends JFrame {

    private JProgressBar progressBar;

    public InitView(){
        initialize();
    }

    private void initialize() {
        setUpLayout();
        basicControl();
        addComponents();
    }

    public void setUpLayout(){
        setTitle("JOBS");
        setSize(460, 160);
        //setLocation(400,200);
        setLocationRelativeTo(null);
    }

    public void basicControl(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void addComponents(){
        JPanel jPanel = new JPanel();
        jPanel.setBackground(new Color(0,0,0) /*new Color(51, 102, 153)*/);
        jPanel.setLayout(new MigLayout("", "[grow]", "[grow][]"));


        progressBar = new JProgressBar();

        progressBar.setStringPainted(true);
        progressBar.setForeground(Color.DARK_GRAY);
        progressBar.setFont(new Font("Arial", Font.BOLD, 14));
        progressBar.setString("Loading...");

        ColorUIResource colorResource = new ColorUIResource(/*Color.green.brighter()*/ Color.red.brighter().brighter());
        UIManager.put("nimbusOrange",colorResource);

        progressBar.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
        progressBar.setIndeterminate(true);

        jPanel.add(progressBar, "cell 0 0, growx, aligny center");

        JLabel jLabel = new JLabel("Iniciando a Aplicação...");

        jLabel.setFont(new Font("Arial", Font.PLAIN, 14));

        jLabel.setForeground(Color.WHITE);

        jPanel.add(jLabel, "cell 0 1, alignx center, aligny center");

        add(jPanel);
    }

    public JProgressBar getProgressBar() {
        return progressBar;
    }

    public void setProgress(int value) {
        progressBar.setIndeterminate(false);
        progressBar.setValue(value);
    }

    class FillPainter implements Painter<JComponent> {

        private final Color color;

        FillPainter(Color c) {
            color = c;
        }

        @Override
        public void paint(Graphics2D g, JComponent object, int width, int height) {
            g.setColor(color);
            g.fillRect(0, 0, width - 1, height - 1);
        }
    }
}
