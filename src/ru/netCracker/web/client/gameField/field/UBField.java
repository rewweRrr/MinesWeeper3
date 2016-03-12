package ru.netCracker.web.client.gameField.field;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Image;
import ru.netCracker.web.client.events.ClickCellEvent;
import ru.netCracker.web.client.events.MinesWeeperEventBus;
import ru.netCracker.web.client.logic.CurrentState;

/**
 * Created by rewweRrr on 02.03.2016
 */
public class UBField extends Composite {
    interface ubFieldUiBinder extends UiBinder<FlowPanel, UBField> {
    }

    private static ubFieldUiBinder ourUiBinder = GWT.create(ubFieldUiBinder.class);

    private int currentRow;
    private int currentCol;

    @UiField
    Image img;

    @SuppressWarnings("UnusedParameters")
    @UiHandler("img")
    void onClickImg(ClickEvent event) {
        CurrentState.getInstance().setCurrentRow(currentRow);
        CurrentState.getInstance().setCurrentColumn(currentCol);
        MinesWeeperEventBus.get().fireEvent(new ClickCellEvent());
    }

    public UBField(int currentCol, int currentRow) {
        this.currentRow = currentRow;
        this.currentCol = currentCol;
        initWidget(ourUiBinder.createAndBindUi(this));
    }

}