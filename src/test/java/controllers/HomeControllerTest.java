package controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import newyearproject.controllers.HomeController;
import newyearproject.views.HomeView;

import static org.junit.jupiter.api.Assertions.*;

class HomeControllerTest {

    private HomeView view;
    private HomeController homeController;

    @BeforeEach
    void setUp() {
        
        view = new HomeView();
        homeController = new HomeController(view);
    }

    @Test
    void testIndex() {
       
        homeController.index();
        
        assertTrue(true); 
    }
}

