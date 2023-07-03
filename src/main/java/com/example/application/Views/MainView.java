package com.example.application.Views;

import com.example.application.model.Restaurant;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "")
public class MainView extends VerticalLayout {

    Grid<Restaurant> gr = new Grid<>(Restaurant.class);

    private void configureGrid(){
        gr.addClassName("Restaurant");
        gr.setSizeFull();
//        gr.setColumns("VINnumber","registrationNumber","model","przebieg");
//        gr.getColumns().forEach(col->col.setAutoWidth(true));

    }
    public MainView(){
        add(gr);
    }
}
