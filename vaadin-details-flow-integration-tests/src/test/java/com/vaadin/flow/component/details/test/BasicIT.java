package com.vaadin.flow.component.details.test;

import com.vaadin.flow.component.details.testbench.DetailsElement;
import com.vaadin.testbench.TestBenchElement;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class BasicIT extends AbstractParallelTest {


    private List<DetailsElement> detailsElements;

    @Before
    public void init() {
        getDriver().get(getBaseURL());
        detailsElements = $(DetailsElement.class).all();

        Assert.assertEquals(3, detailsElements.size());
    }

    @Test
    public void testSummary() {
        DetailsElement detail1 = detailsElements.get(0);
        Assert.assertEquals("Some summary", detail1.getSummaryText());

        DetailsElement detail2 = detailsElements.get(1);
        Assert.assertEquals("Summary Text", detail2.getSummaryText());
    }

    @Test
    public void testContent() {
        DetailsElement detail1 = detailsElements.get(0);
        Assert.assertFalse(detail1.isOpened());
        detail1.getSummary().click();
        Assert.assertTrue(detail1.isOpened());
        Assert.assertEquals("Some content", detail1.getContentText());

        DetailsElement detail2 = detailsElements.get(1);
        Assert.assertTrue(detail2.isOpened());
        Assert.assertEquals("Content Text", detail2.getContentText());
        detail2.getSummary().click();
        Assert.assertFalse(detail2.isOpened());

        DetailsElement detail3 = detailsElements.get(2);
        Assert.assertTrue(detail3.isOpened());
        Assert.assertFalse(detail3.isEnabled());
        Assert.assertEquals("Always visible content", detail3.getContentText());
        detail3.$(TestBenchElement.class).attribute("part", "summary-content").first().click();
        Assert.assertTrue(detail3.isOpened());
    }
}
