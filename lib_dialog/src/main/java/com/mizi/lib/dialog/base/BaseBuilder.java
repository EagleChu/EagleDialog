package com.mizi.lib.dialog.base;

import android.support.v7.app.AppCompatActivity;

public abstract class BaseBuilder<B extends BaseBuilder, D extends BaseDialog> {

    protected AppCompatActivity activity;

    B self() {
        return (B) this;
    }

    BaseBuilder(AppCompatActivity activity) {
        this.activity = activity;
    }

    public AppCompatActivity getActivity() {
        return activity;
    }

    public abstract D build();
}
