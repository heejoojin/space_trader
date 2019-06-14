package com.example.m4.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

public class ConfigurationViewModel extends AndroidViewModel {

    private int score = 16;

    private int pilot = 0;
    private int fighter = 0;
    private int trader = 0;
    private int engineer = 0;

    public ConfigurationViewModel(@NonNull Application application) {
        super(application);
    }

    public void setScore(int score) {
        this.score = score;
    }
    public void setPilot(int pilot) {
        this.pilot = pilot;
    }
    public void setFighter(int fighter) {
        this.fighter = fighter;
    }
    public void settrader(int trader) {
        this.trader = trader;
    }
    public void setEngineer(int engineer) {
        this.engineer = engineer;
    }

    public int getScore() {
        return this.score;
    }
    public int getPilot() {
        return this.pilot;
    }
    public int getFighter() {
        return this.fighter;
    }
    public int getTrader() {
        return this.trader;
    }
    public int getEngineer() {
        return this.engineer;
    }



}
