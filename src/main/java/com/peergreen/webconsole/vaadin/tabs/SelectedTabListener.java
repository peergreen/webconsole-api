package com.peergreen.webconsole.vaadin.tabs;

import com.peergreen.webconsole.navigator.ViewNavigator;
import com.vaadin.ui.Component;
import com.vaadin.ui.TabSheet;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Default selected tab listener
 * @author Mohammed Boukada
 */
public class SelectedTabListener implements TabSheet.SelectedTabChangeListener {

    private ViewNavigator viewNavigator;
    private Map<Component, String> locations;

    public SelectedTabListener(ViewNavigator viewNavigator) {
        this.viewNavigator = viewNavigator;
        this.locations = new ConcurrentHashMap<>();
    }

    /**
     * Add extension location
     * @param extension extension object
     * @param location extension path
     */
    public void addLocation(Component extension, String location) {
        locations.put(extension, location);
    }

    /**
     * Remove extension location
     * @param extension extension object
     */
    public void removeLocation(Component extension) {
        if (locations.containsKey(extension)) {
            locations.remove(extension);
        }
    }

    /**
     * {@inheritDoc} <br />
     *
     * Call view navigator to navigate to the selected extension
     */
    @Override
    public void selectedTabChange(TabSheet.SelectedTabChangeEvent event) {
        if (event.getTabSheet().isAttached()) {
            viewNavigator.navigateTo(locations.get(event.getTabSheet().getSelectedTab()));
        }
    }
}
