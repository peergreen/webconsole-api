package com.peergreen.webconsole.vaadin;

import com.vaadin.event.ShortcutAction;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

import java.io.Serializable;

/**
 * @author Mohammed Boukada
 */
public class ConfirmDialog extends Window {

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
            final ConfirmDialog confirmDialog = new ConfirmDialog();
            confirmDialog.setCaption(windowCaption != null ? windowCaption : DEFAULT_CAPTION);
            confirmDialog.setClosable(false);
            confirmDialog.setResizable(false);
            confirmDialog.addStyleName("edit-dashboard");

            VerticalLayout main = new VerticalLayout();
            main.setSpacing(true);
            main.setMargin(true);
            main.setStyleName("confirm-dialog");

            if (content == null) {
                content = new Label(DEFAULT_MESSAGE, ContentMode.HTML);
            }
            content.addStyleName("confirm-dialog-message");
            main.addComponent(content);

            HorizontalLayout buttons = new HorizontalLayout();
            buttons.setSizeFull();
            buttons.setSpacing(true);
            buttons.setMargin(true);
            buttons.addStyleName("footer");
            buttons.setWidth("100%");

            Button cancel = new Button(cancelCaption != null ? cancelCaption : DEFAULT_CANCEL_CAPTION);
            cancel.setClickShortcut(ShortcutAction.KeyCode.ESCAPE, null);
            buttons.addComponent(cancel);
            buttons.setExpandRatio(cancel, 1);
            buttons.setComponentAlignment(cancel, Alignment.TOP_RIGHT);

            final Button ok = new Button(okCaption != null ? okCaption : DEFAULT_OK_CAPTION);
            ok.addStyleName("wide");
            ok.addStyleName("default");
            ok.setClickShortcut(ShortcutAction.KeyCode.ENTER, null);
            buttons.addComponent(ok);

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
            main.addComponent(buttons);

            confirmDialog.setContent(main);
            return confirmDialog;
        }
    }
}
