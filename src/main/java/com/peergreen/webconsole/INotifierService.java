package com.peergreen.webconsole;

/**
 * Notifier service
 * @author Mohammed Boukada
 */
public interface INotifierService {

    /**
     * Add an overlay
     * @param caption
     * @param text
     * @param style
     * @return
     */
    NotificationOverlay addOverlay(String caption, String text, String style);

    /**
     * Close all overlays
     */
    void closeAll();

    /**
     * Add a notification
     * @param notification notification message
     */
    void addNotification(String notification);

    /**
     * Start a task
     * @param worker worker object
     * @param message task message
     * @param contentLength task length
     */
    void startTask(Object worker, String message, Long contentLength);

    /**
     * Update running task
     * @param worker worker object
     * @param bytesReceived
     */
    void updateTask(Object worker, Long bytesReceived);

    /**
     * Stop task
     * @param worker worker object
     */
    void stopTask(Object worker);
}
