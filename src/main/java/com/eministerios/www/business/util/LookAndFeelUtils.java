package com.eministerios.www.business.util;

import javax.swing.*;

public class LookAndFeelUtils {

    public static void setWindowsLookAndFeel() {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    null,
                    ConstMessagesPT.Messages.WINDOWS_STYLE_LOADING_ERROR_MESSAGE + e,
                    ConstMessagesPT.Messages.ALERT_TILE,
                    JOptionPane.ERROR_MESSAGE);

        }
    }

}
