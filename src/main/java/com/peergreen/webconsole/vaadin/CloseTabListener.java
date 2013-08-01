package com.peergreen.webconsole.vaadin;

import com.peergreen.webconsole.INotifierService;
import com.vaadin.ui.Component;
import com.vaadin.ui.TabSheet;

/**
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
