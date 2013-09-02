package com.peergreen.webconsole.vaadin;

import com.vaadin.event.ShortcutAction;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;

import java.io.Serializable;

/**
 * @author Mohammed Boukada
 */
public class ConfirmDialog extends DefaultWindow {

    public ConfirmDialog(String caption, Component content, Button... footerButtons) {
        super(caption, content, footerButtons);
    }

    public interface Listener extends Serializable {
        void onClose(boolean isConfirmed);
    }

    private Listener confirmListener = null;

    public static void show(UI parent, Listener listener) {
        show(parent, null, null, null, null, listener);
    }

    public static void show(UI parent, Component content, Listener listener) {
        show(parent, null, content, null, null, listener);
    }

    public static void show(UI parent, String windowCaption, Component content, String okCaption, String cancelCaption, Listener listener) {
        ConfirmDialog confirmDialog = ConfirmDialogFactory.create(windowCaption, content, okCaption, cancelCaption);
        confirmDialog.show(parent, listener, true);
    }

    public void show(UI parent, Listener listener, boolean modal) {
        confirmListener = listener;
        setModal(modal);
        parent.addWindow(this);
    }

    protected final Listener getListener() {
        return confirmListener;
    }

    public static class ConfirmDialogFactory {

        protected static final String DEFAULT_CAPTION = "Confirm";
        protected static final String DEFAULT_MESSAGE = "Are you sure?";
        protected static final String DEFAULT_OK_CAPTION = "Ok";
        protected static final String DEFAULT_CANCEL_CAPTION = "Cancel";

        public static ConfirmDialog create(String windowCaption, Component content, String okCaption, String cancelCaption) {
            if (content == null) {
                content = new Label(DEFAULT_MESSAGE, ContentMode.HTML);
            }

            Button cancel = new Button(cancelCaption != null ? cancelCaption : DEFAULT_CANCEL_CAPTION);
            cancel.setClickShortcut(ShortcutAction.KeyCode.ESCAPE, null);

            final Button ok = new Button(okCaption != null ? okCaption : DEFAULT_OK_CAPTION);
            ok.addStyleName("wide");
            ok.addStyleName("default");
            ok.setClickShortcut(ShortcutAction.KeyCode.ENTER, null);

            final ConfirmDialog confirmDialog = new ConfirmDialog(windowCaption != null ? windowCaption : DEFAULT_CAPTION, content, cancel, ok);

            Button.ClickListener clickListener = new Button.ClickListener() {
                @Override
                public void buttonClick(Button.ClickEvent event) {
                    if (confirmDialog.isEnabled()) {
                        confirmDialog.setEnabled(false);

                        if (confirmDialog.getListener() != null) {
                            confirmDialog.getListener().onClose(event.getButton().equals(ok));
                        }

                        confirmDialog.close();
                    }
                }
            };
            cancel.addClickListener(clickListener);
            ok.addClickListener(clickListener);
            return confirmDialog;
        }
    }
}
