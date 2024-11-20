package newyearproject.controllers;

import newyearproject.views.HomeView;

public class HomeController {

    public HomeController() {
        index();
    }

    public void index() {
        // responde con una vista
        HomeView.index();
    }

}