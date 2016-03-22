package com.eministerios.www.business.workerUi.util.components;


import org.jdesktop.swingx.prompt.PromptSupport;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

/**
 * Created by alexandre on 18/03/16.
 */
@Component
public class UiComponents {

    public UiComponents() {
    }

    public JButton createStandardButton(JButton jButton, String label){
        jButton.setText(label);
        jButton.setBackground(new Color(51, 102, 204));
        jButton.setForeground(new Color(255, 255, 255));
        jButton.setFont(new Font("Arial", Font.PLAIN, 13));
        return jButton;
    }

    public JLabel createStandardLabel(JLabel jLabel, String label){
        jLabel.setText(label);
        jLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        jLabel.setForeground(Color.WHITE);
        return jLabel;
    }

    public JPanel createStandartPanel(JPanel jPanel, LayoutManager layout){
        jPanel.setBackground(new Color(51, 102, 153));
        jPanel.setLayout(layout);
        return jPanel;
    }

    public JTextField createStandardTF(JTextField jTextField, String placeholder){
        PromptSupport.setPrompt(placeholder, jTextField);
        PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.HIDE_PROMPT, jTextField);
        PromptSupport.setBackground(Color.WHITE, jTextField);
        PromptSupport.setFontStyle(Font.ITALIC, jTextField);
        jTextField.setColumns(5);
        return jTextField;
    }

    public JTextArea createStandardTA(JTextArea jTextArea, String placeholder){
        jTextArea.setWrapStyleWord(true);
        jTextArea.setLineWrap(true);
        PromptSupport.setPrompt(placeholder, jTextArea);
        PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.HIDE_PROMPT, jTextArea);
        PromptSupport.setBackground(Color.WHITE, jTextArea);
        PromptSupport.setFontStyle(Font.ITALIC, jTextArea);
        return jTextArea;

    }


}

/*
* PromptSupport Properties:
*  PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.HIDE_PROMPT, jTextField);
*  PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.HIGHLIGHT_PROMPT, jTextField);
*  PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.SHOW_PROMPT, jTextField);
*  PromptSupport.setForeground(Color.BLUE, jTextField);
*  PromptSupport.setFontStyle(Font.BOLD, jTextField);
*  PromptSupport.setFontStyle(Font.ITALIC, jTextField);
*  PromptSupport.setFontStyle(Font.ITALIC | Font.BOLD, jTextField);
* */
