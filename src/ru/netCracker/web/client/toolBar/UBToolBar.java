package ru.netCracker.web.client.toolBar;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.*;
import ru.netCracker.web.client.events.ChangeLevelEvent;
import ru.netCracker.web.client.events.MinesWeeperEventBus;
import ru.netCracker.web.client.events.PlayBtnEvent;
import ru.netCracker.web.shared.Level;

/**
 * Created by rewweRrr on 02.03.2016
 */
public class UBToolBar extends Composite {
    interface ubToolBarUiBinder extends UiBinder<HorizontalPanel, UBToolBar> {
    }

    private static ubToolBarUiBinder ourUiBinder = GWT.create(ubToolBarUiBinder.class);

    public UBToolBar() {
        initWidget(ourUiBinder.createAndBindUi(this));
        level = Level.getInstance();
    }

    private Level level;

    @UiField
    HorizontalPanel headPanel;
    @UiField
    Button playBtn;
    @UiField
    RadioButton easyBtn;
    @UiField
    RadioButton mediumBtn;
    @UiField
    RadioButton hardBtn;
    @UiField
    Label timeLabel;
    @UiField
    Label minesNumberLabel;

    @SuppressWarnings("UnusedParameters")
    @UiHandler("easyBtn")
    void onClickEasy(ClickEvent event) {
        level.setLevel(Level.EASY);
        MinesWeeperEventBus.get().fireEvent(new ChangeLevelEvent());
    }

    @SuppressWarnings("UnusedParameters")
    @UiHandler("mediumBtn")
    void onClickMedium(ClickEvent event) {
        level.setLevel(Level.MEDIUM);
        MinesWeeperEventBus.get().fireEvent(new ChangeLevelEvent());
    }

    @SuppressWarnings("UnusedParameters")
    @UiHandler("hardBtn")
    void onClickHard(ClickEvent event) {
        level.setLevel(Level.HARD);
        MinesWeeperEventBus.get().fireEvent(new ChangeLevelEvent());
    }

    @SuppressWarnings("UnusedParameters")
    @UiHandler("playBtn")
    void onClickPlay(ClickEvent event) {
        MinesWeeperEventBus.get().fireEvent(new PlayBtnEvent());
    }
}