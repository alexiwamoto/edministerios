package com.eministerios.www.business.workerUi.main.controller;


import com.eministerios.www.business.workerUi.add.controller.AddController;
import com.eministerios.www.business.workerUi.list.controller.ListController;
import com.eministerios.www.business.workerUi.main.view.MainView;
import com.eministerios.www.business.workerUi.search.controller.SearchController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by alexandre on 04/03/16.
 */
@Controller
public class MainControlller {

    private MainView mainView;

    private AddController addController;

    private ListController listController;

    private SearchController searchController;

    @Autowired
    public MainControlller(MainView mainView, AddController addController, ListController listController, SearchController searchController) {
        this.mainView = mainView;
        this.addController = addController;
        this.listController = listController;
        this.searchController = searchController;
        setControllers();
    }

    public void setControllers(){
        mainView.setVisible(true);
    }
}
