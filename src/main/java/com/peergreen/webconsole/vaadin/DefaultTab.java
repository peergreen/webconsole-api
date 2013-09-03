package com.peergreen.webconsole.vaadin;

import com.vaadin.event.LayoutEvents;
import com.vaadin.server.Resource;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.UI;

import java.util.HashMap;
import java.util.Map;

/**
 * Default tab component for scope tab view
 * @author Mohammed Boukada
 */
public class DefaultTab extends CssLayout {

    private TabSheet tabs;
    private UI ui;

    private Map<String, Component> modulesComponents = new HashMap<>();
    private Map<String, Component> modulesFrames = new HashMap<>();

    /**
     * Create new default tab
     * @param tabs tab sheet where default tab will be added
     */
    public DefaultTab(TabSheet tabs) {
        this.tabs = tabs;
        addStyleName("catalog");
        setSizeFull();
    }

    /**
     * Set Vaadin UI object
     * @param ui UI
     */
    public void setUi(UI ui) {
        this.ui = ui;
    }

    /**
     * Add extension shortcut to the default tab content
     * @param extension extension object
     * @param extensionName extension name
     */
    public void addExtension(Component extension, final String extensionName) {
        addExtension(extension, extensionName, new ThemeResource("img/default-module-icon.png"));
    }

    /**
     * Add extension shortcut to the default tab content
     * @param extension extension object
     * @param extensionName extension name
     * @param extensionIcon extension icon
     */
    public void addExtension(Component extension, final String extensionName, Resource extensionIcon) {
        Image moduleIcon = new Image(extensionName, extensionIcon);
        final CssLayout frame = new CssLayout();
        frame.addComponent(moduleIcon);
        frame.addLayoutClickListener(new LayoutEvents.LayoutClickListener() {
            @Override
            public void layoutClick(LayoutEvents.LayoutClickEvent event) {
                Component moduleComponent = modulesComponents.get(extensionName);
                if (tabs.getTab(moduleComponent) == null) {
                    tabs.addComponent(moduleComponent);
                    tabs.getTab(moduleComponent).setCaption(extensionName);
                    tabs.getTab(moduleComponent).setClosable(true);
                    tabs.setSelectedTab(moduleComponent);
                } else {
                    tabs.setSelectedTab(moduleComponent);
                }
            }
        });
        if (ui != null) {
            ui.access(new Runnable() {
                @Override
                public void run() {
                    addComponent(frame);
                }
            });
        } else {
            addComponent(frame);
        }
        modulesComponents.put(extensionName, extension);
        modulesFrames.put(extensionName, frame);
    }

    /**
     * Remove extension from default tab content
     * @param extensionName extension name
     */
    public void removeExtension(final String extensionName) {
        if (ui != null) {
            ui.access(new Runnable() {
                @Override
                public void run() {
                    removeComponent(modulesFrames.get(extensionName));
                }
            });
        } else {
            removeComponent(modulesFrames.get(extensionName));
        }
    }
}
