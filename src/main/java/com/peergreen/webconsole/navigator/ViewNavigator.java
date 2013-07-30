package com.peergreen.webconsole.navigator;

import com.vaadin.ui.Component;

/**
 * @author Mohammed Boukada
 */
public interface ViewNavigator {
    void navigateTo(String path);
    String getUrlOf(String extension);
    NavigableModel getNavigableModel(String extension);
    void registerNavigableModel(Component component, NavigableModel navigableModel);
    void unregisterNavigableModel(Component component);
}
