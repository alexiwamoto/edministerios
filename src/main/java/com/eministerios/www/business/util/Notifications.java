package com.eministerios.www.business.util;

import javax.swing.*;

public class Notifications {

    public static void showFormValidationAlert(String message) {
        JOptionPane.showMessageDialog(null,
                message,
                ConstMessagesPT.Messages.INFORMATION_TITLE,
                JOptionPane.INFORMATION_MESSAGE);
    }

    public static void showTableRowNotSelectedAlert() {
        JOptionPane.showMessageDialog(null,
                ConstMessagesPT.Messages.NON_ROW_SELECTED,
                ConstMessagesPT.Messages.ALERT_TILE,
                JOptionPane.ERROR_MESSAGE);
    }

    public static void showDeleteRowErrorMessage() {
        JOptionPane.showMessageDialog(null,
                ConstMessagesPT.Messages.DELETE_ROW_ERROR,
                ConstMessagesPT.Messages.ALERT_TILE,
                JOptionPane.ERROR_MESSAGE);
    }
}
