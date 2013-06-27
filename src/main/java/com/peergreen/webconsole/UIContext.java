package com.peergreen.webconsole;

import com.vaadin.ui.UI;

/**
 * Created with IntelliJ IDEA.
 * User: mohammed
 * Date: 28/05/13
 * Time: 15:54
 * To change this template use File | Settings | File Templates.
 */
public interface UIContext {

    ISecurityManager getSecurityManager();

    UI getUI();

    String getUIId();
}
