package ru.netCracker.web.client.logic;

import ru.netCracker.web.client.events.ClickCellEvent;
import ru.netCracker.web.client.events.MinesWeeperEventBus;

/**
 * Created by rewweRrr on 11.03.2016
 */
public class CurrentState {

    private static CurrentState instance;

    private int currentRow;
    private int currentColumn;

    public void setCurrentColumn(int currentColumn) {
        this.currentColumn = currentColumn;
    }

    public void setCurrentRow(int currentRow) {
        this.currentRow = currentRow;
    }

    public int getCurrentColumn() {
        return currentColumn;
    }

    public int getCurrentRow() {
        return currentRow;
    }

    public static CurrentState getInstance() {
        if (instance == null) {
            instance = new CurrentState();
        }
        return instance;
    }

    private void method() {
        MinesWeeperEventBus.get().addHandler(ClickCellEvent.TYPE, new ClickCellEvent.Handler() {
            @Override
            public void onClickCell(ClickCellEvent event) {

            }
        });
    }
}
