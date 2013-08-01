package com.peergreen.webconsole.vaadin;

import com.peergreen.webconsole.navigator.ViewNavigator;
import com.vaadin.ui.Component;
import com.vaadin.ui.TabSheet;

/**
 * @author Mohammed Boukada
 */
public class SelectedTabListener implements TabSheet.SelectedTabChangeListener {

    private ViewNavigator viewNavigator;
    private Component defaultTab;

    public SelectedTabListener(ViewNavigator viewNavigator, Component defaultTab) {
        this.viewNavigator = viewNavigator;
        this.defaultTab = defaultTab;
    }

    @Override
    public void selectedTabChange(TabSheet.SelectedTabChangeEvent event) {
        Component selectedTab = event.getTabSheet().getSelectedTab();
        String location;
        if (defaultTab.equals(selectedTab)) {
            location = viewNavigator.getLocation(event.getSource().getClass().getName());
        } else {
            location = viewNavigator.getLocation(selectedTab.getClass().getName());
        }
        if (location != null) {
            viewNavigator.navigateTo(location);
        }
    }
}
