package com.eministerios.www;

import com.eministerios.www.business.util.LookAndFeelUtils;
import com.eministerios.www.business.workerUi.InitView;
import com.eministerios.www.business.workerUi.main.controller.MainControlller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
@EnableAutoConfiguration
public class Application {

    public static void main(String[] args) {
        LookAndFeelUtils.setWindowsLookAndFeel();

        InitView initView = new InitView();

        initView.setVisible(true);

        ConfigurableApplicationContext context = new SpringApplicationBuilder(Application.class).headless(false).run(args);

        initView.setProgress(100);

        initView.setVisible(false);

        MainControlller controller = context.getBean(MainControlller.class);
    }

}
