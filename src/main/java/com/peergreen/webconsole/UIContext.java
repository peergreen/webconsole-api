package com.peergreen.webconsole;

import com.peergreen.webconsole.navigator.ViewNavigator;
import com.vaadin.ui.UI;

/**
 * @author Mohammed Boukada
 */
public interface UIContext {

    ISecurityManager getSecurityManager();

    UI getUI();

    ViewNavigator getViewNavigator();

    String getUIId();
}
