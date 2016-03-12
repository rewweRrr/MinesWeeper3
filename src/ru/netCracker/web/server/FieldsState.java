package ru.netCracker.web.server;

import ru.netCracker.web.shared.Level;

import java.util.ArrayList;

/**
 * Created by rewweRrr on 11.03.2016
 */
public class FieldsState {
    private static FieldsState instance;

    private final int UNUSED_FIELD = -2;
    private int columns;
    private int rows;
    private int minesNum;
    private ArrayList<ArrayList<Integer>> currentState;

    public static FieldsState getInstance() {
        if (instance == null)
            instance = new FieldsState();
        return instance;
    }

    public int getMinesNum() {
        return minesNum;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public ArrayList<ArrayList<Integer>> getCurrentState() {
        return currentState;
    }

    private void chooseLevel() {
        int level = Level.getInstance().getLevel();
        switch (level) {
            case Level.EASY:
                columns = 8;
                rows = 8;
                minesNum = 10;
                addUnusedFields(columns, rows);
                break;

            case Level.MEDIUM:
                columns = 16;
                rows = 16;
                minesNum = 40;
                addUnusedFields(columns, rows);
                break;

            case Level.HARD:
                columns = 16;
                rows = 31;
                minesNum = 99;
                addUnusedFields(columns, rows);
                break;

            default:
                throw new IllegalArgumentException();
        }
    }

    private void addUnusedFields(int columns, int rows) {
        currentState.clear();
        currentState = new ArrayList<>();
        for (int i = 0; i < columns; i++) {
            currentState.add(new ArrayList<Integer>());
            for (int j = 0; j < rows; j++) {
                currentState.get(i).add(UNUSED_FIELD);
            }
        }
    }

    private void getInfo() {
        chooseLevel();
    }
}
