package controllers;

import views.HomeViewTest;

public class HomeController {

    public HomeController() {
        index();
    }

    public void index() {
        // responde con una vista
        HomeViewTest.index();
    }

}