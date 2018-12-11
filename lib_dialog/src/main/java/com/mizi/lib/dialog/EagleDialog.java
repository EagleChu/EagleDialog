package com.mizi.lib.dialog;

import android.support.v7.app.AppCompatActivity;
import com.mizi.lib.dialog.base.WrapperBuilder;
import com.mizi.lib.dialog.base.WrapperDialog;

public class EagleDialog extends WrapperDialog<EagleDialog.Builder> {

    public void show() {
        super.show(builder.getActivity().getSupportFragmentManager(), EagleDialog.class.getSimpleName());
    }

    public static class Builder extends WrapperBuilder<Builder, EagleDialog> {

        public Builder(AppCompatActivity activity) {
            super(activity);
        }

        public EagleDialog build() {
            EagleDialog dialog = new EagleDialog();
            dialog.setBuilder(this);
            return dialog;
        }
    }
}
