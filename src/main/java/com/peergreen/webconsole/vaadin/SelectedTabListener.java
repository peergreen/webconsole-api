package com.peergreen.webconsole.vaadin;

import com.peergreen.webconsole.navigator.ViewNavigator;
import com.vaadin.ui.Component;
import com.vaadin.ui.TabSheet;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Mohammed Boukada
 */
public class SelectedTabListener implements TabSheet.SelectedTabChangeListener {

    private ViewNavigator viewNavigator;
    private Map<Component, String> locations;

    public SelectedTabListener(ViewNavigator viewNavigator) {
        this.viewNavigator = viewNavigator;
        this.locations = new ConcurrentHashMap<>();
    }

    public void addLocation(Component component, String location) {
        locations.put(component, location);
    }

    public void removeLocation(Component component) {
        if (locations.containsKey(component)) {
            locations.remove(component);
        }
    }

    @Override
    public void selectedTabChange(TabSheet.SelectedTabChangeEvent event) {
        if (event.getTabSheet().isAttached()) {
            viewNavigator.navigateTo(locations.get(event.getTabSheet().getSelectedTab()));
        }
    }
}
