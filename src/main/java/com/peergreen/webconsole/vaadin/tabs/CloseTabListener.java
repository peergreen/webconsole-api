package com.peergreen.webconsole.vaadin.tabs;

import com.peergreen.webconsole.notifier.INotifierService;
import com.vaadin.ui.Component;
import com.vaadin.ui.TabSheet;

/**
 * Default close tab listener
 *
 * @author Mohammed Boukada
 */
public class CloseTabListener implements TabSheet.CloseHandler {

    private INotifierService notifierService;

    public CloseTabListener(INotifierService notifierService) {
        this.notifierService = notifierService;
    }

    @Override
    public void onTabClose(TabSheet tabsheet, Component tabContent) {
        notifierService.addNotification("Warning ! You have closed " +
                tabsheet.getTab(tabContent).getCaption() + " tab");
        tabsheet.removeComponent(tabContent);
    }
}
