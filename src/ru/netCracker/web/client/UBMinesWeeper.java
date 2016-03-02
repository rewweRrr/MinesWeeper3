package ru.netCracker.web.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;

/**
 * Created by rewweRrr on 02.03.2016
 */
public class UBMinesWeeper extends Composite {
    interface ubMinesWeeperUiBinder extends UiBinder<FlowPanel, UBMinesWeeper> {
    }

    private static ubMinesWeeperUiBinder ourUiBinder = GWT.create(ubMinesWeeperUiBinder.class);

    public UBMinesWeeper() {
        initWidget(ourUiBinder.createAndBindUi(this));
    }
}