package com.eministerios.www;

import com.eministerios.www.business.ui.main_menu.controller.MainMenuController;
import com.eministerios.www.business.util.LookAndFeelUtils;
import com.eministerios.www.business.workerUi.main.controller.MainControlller;
import com.eministerios.www.business.workerUi.main.view.MainView;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import javax.swing.*;

@SpringBootApplication
@EnableAutoConfiguration
public class Application {

    public static void main(String[] args) {
        LookAndFeelUtils.setWindowsLookAndFeel();

        ConfigurableApplicationContext context = new SpringApplicationBuilder(Application.class).headless(false).run(args);
        /*MainMenuController mainMenuController = context.getBean(MainMenuController.class);
        mainMenuController.prepareAndOpenFrame();*/
        //MainView view = new MainView();
        //view.setVisible(true);
        MainControlller controller = context.getBean(MainControlller.class);  //new MainControlller(view);
    }

}
