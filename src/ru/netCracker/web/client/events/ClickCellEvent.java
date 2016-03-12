package ru.netCracker.web.client.events;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;

/**
 * Created by rewweRrr on 11.03.2016
 */
public class ClickCellEvent extends GwtEvent<ClickCellEvent.Handler> {
    public static Type<Handler> TYPE = new Type<>();

    public Type<Handler> getAssociatedType() {
        return TYPE;
    }

    protected void dispatch(Handler handler) {
        handler.onClickCell(this);
    }

    public interface Handler extends EventHandler {
        void onClickCell(ClickCellEvent event);
    }
}
