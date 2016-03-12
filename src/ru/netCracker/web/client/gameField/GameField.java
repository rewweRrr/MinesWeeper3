package ru.netCracker.web.client.gameField;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Grid;
import ru.netCracker.web.client.events.ChangeLevelEvent;
import ru.netCracker.web.client.events.MinesWeeperEventBus;
import ru.netCracker.web.client.events.PlayBtnEvent;
import ru.netCracker.web.client.gameField.field.UBField;
import ru.netCracker.web.shared.Level;

/**
 * Created by rewweRrr on 02.03.2016
 */
public class GameField extends Composite {

    private int columns = 8; // 8,16,31
    private int rows = 8;   // 8,16,16
    //private int minesNum = 10; // 10,40,99
    Grid mainFieldPanel = new Grid();

    public GameField() {
        initWidget(mainFieldPanel);
        initMainField();
    }

    private void initMainField() {
        MinesWeeperEventBus.get().addHandler(PlayBtnEvent.TYPE, new PlayBtnEvent.Handler() {
            @Override
            public void onPlayBtn(PlayBtnEvent event) {
                chooseLevel();
                createFields();
            }
        });
    }

    private void chooseLevel() {
        MinesWeeperEventBus.get().addHandler(ChangeLevelEvent.TYPE, new ChangeLevelEvent.Handler() {
            @Override
            public void onChangeLevel(ChangeLevelEvent event) {
                int level = Level.getInstance().getLevel();
                switch (level) {
                    case Level.EASY:
                        columns = 8;
                        rows = 8;
                        //minesNum = 10;
                        break;

                    case Level.MEDIUM:
                        columns = 16;
                        rows = 16;
                        //minesNum = 40;
                        break;

                    case Level.HARD:
                        columns = 16;
                        rows = 31;
                        //minesNum = 99;
                        break;

                    default:
                        throw new IllegalArgumentException();
                }
            }
        });
    }

    private void createFields() {
        mainFieldPanel.resize(columns, rows);

        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {

                UBField field = new UBField(i,j);
                mainFieldPanel.setWidget(i,j, field);
            }
        }
    }

}
