package ru.netCracker.web.client.gameField.field;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;

/**
 * Created by rewweRrr on 02.03.2016
 */
public class UBField extends Composite {
    interface ubFieldUiBinder extends UiBinder<FlowPanel, UBField> {
    }

    private static ubFieldUiBinder ourUiBinder = GWT.create(ubFieldUiBinder.class);

    public UBField() {
        initWidget(ourUiBinder.createAndBindUi(this));
    }
}