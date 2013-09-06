package com.peergreen.webconsole;

import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Window;

/**
 * Notification Overlay
 * @author Mohammed Boukada
 */
public class HelpOverlay extends Window {

    private boolean seen = false;

    /**
     * Notification overlay constructor
     */
    public HelpOverlay() {
        setContent(new CssLayout());
        setPrimaryStyleName("help-overlay");
        setDraggable(false);
        setResizable(false);
        center();
        addCloseListener(new CloseListener() {
            @Override
            public void windowClose(CloseEvent e) {
                seen = true;
            }
        });
    }

    /**
     * Add component
     * @param c
     */
    public void addComponent(Component c) {
        ((CssLayout) getContent()).addComponent(c);
    }

    public boolean isSeen() {
        return seen;
    }
}
