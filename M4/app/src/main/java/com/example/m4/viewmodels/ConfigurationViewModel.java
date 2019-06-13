package com.example.m4.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.example.m4.model.Player;

public class ConfigurationViewModel extends AndroidViewModel {

    private Player player;

    public ConfigurationViewModel(@NonNull Application application) {
        super(application);

    }
}
