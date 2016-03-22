package com.eministerios.www.business.workerUi.search.controller;


import com.eministerios.www.business.workerUi.search.view.SearchView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by alexandre on 17/03/16.
 */
@Controller
public class SearchController {
    private SearchView searchView;

    @Autowired
    public SearchController(SearchView searchView) {
        this.searchView = searchView;
    }


}
