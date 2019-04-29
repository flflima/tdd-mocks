package br.com.tdd.mocks;

import java.util.Calendar;

public class RelogiodoSistema implements Relogio {

    @Override
    public Calendar hoje() {
        return Calendar.getInstance();
    }
}
