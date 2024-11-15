package controllers;

import views.HomeView;

public class HomeController {
    public HomeController() {
        index();
    }

    public void index() {
        // responde con una vista
        HomeView.index();
    }

}

