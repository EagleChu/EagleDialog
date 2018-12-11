package com.mizi.lib.dialog.base;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

public class TraditionDialog extends BaseDialog<TraditionDialog.Builder> {

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder alertBuilder = builder.getAlertBuilder();
        return alertBuilder.create();
    }

    public static class Builder extends TraditionBuilder {

        public Builder(AppCompatActivity activity) {
            super(activity);
        }
    }
}
