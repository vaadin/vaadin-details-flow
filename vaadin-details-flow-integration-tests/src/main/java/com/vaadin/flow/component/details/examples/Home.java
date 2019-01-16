package com.vaadin.flow.component.details.examples;

import com.vaadin.flow.component.details.Details;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.router.Route;

@Route(value = "")
public class Home extends Div {

    public Home() {
        Details details = new Details();
        details.setSummary(new Span("Some summary"));

        Details detailsText = new Details();
        detailsText.setSummaryText("Summary Text");

        add(details, detailsText);
    }
}
