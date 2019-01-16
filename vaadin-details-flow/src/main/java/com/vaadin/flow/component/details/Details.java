package com.vaadin.flow.component.details;

/*
 * #%L
 * Vaadin Accordion for Vaadin 13
 * %%
 * Copyright (C) 2017 - 2018 Vaadin Ltd
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.html.Span;

@Tag("vaadin-details")
@HtmlImport("frontend://bower_components/vaadin-details/src/vaadin-details.html")
public class Details extends Component {

    private Component summary;
    private Component content;

    /**
     * Initializes a new Details.
     */
    public Details() {
    }

    /**
     * Sets the component summary
     *
     * @see #getSummary()
     * @param summary
     *            the summary component to set, or <code>null</code> to remove
     *            any previously set summary
     */
    public void setSummary(Component summary) {
        if (this.summary != null) {
            this.summary.getElement().removeFromParent();
        }

        this.summary = summary;
        if (summary == null) {
            return;
        }

        summary.getElement().setAttribute("slot", "summary");
        getElement().appendChild(summary.getElement());
    }

    /**
     * Returns summary component which was set via {@link #setSummary(Component)}
     *
     * @return the summary component, <code>null</code> if nothing was set
     */
    public Component getSummary() {
        return summary;
    }

    /**
     * Creates a text wrapper and {@link #setSummary(Component)}
     */
    public void setSummaryText(String summary) {
        if (summary == null) {
            summary = "";
        }
        setSummary(new Span(summary));
    }

    /**
     * @return summary as string
     */
    public String getSummaryText() {
        return summary.getElement().getText();
    }
}
