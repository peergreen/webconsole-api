package com.peergreen.webconsole.notifier;

import com.peergreen.webconsole.HelpOverlay;

/**
 * Notifier service
 *
 * @author Mohammed Boukada
 */
public interface INotifierService {

    /**
     * Add an overlay
     *
     * @param caption
     * @param text
     * @return
     */
    HelpOverlay createHelpOverlay(String caption, String text);

    /**
     * Close all overlays
     */
    void closeAll();

    /**
     * Add a notification
     *
     * @param notification notification message
     */
    void addNotification(String notification);

    /**
     * Create task
     * @param message task message
     * @return task handle
     */
    Task createTask(String message);
}
