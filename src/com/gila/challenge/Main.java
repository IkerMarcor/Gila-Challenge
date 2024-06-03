package com.gila.challenge;

import com.gila.challenge.controller.HomeController;
import com.gila.challenge.view.HomeView;

public class Main {
    public static void main(String[] args) {
        HomeView homeView = new HomeView("Submission form");
        HomeController controller = new HomeController(homeView);
    }
}
