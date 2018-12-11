package com.mizi.lib.dialog.base;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.mizi.lib.dialog.EagleDialog;
import com.mizi.lib.dialog.EaglePanel;

/**
 * 这里是对 DialogFragment 的封装,
 * 分成三类:
 * 一是传统的AlertDialog, 在{@link #onCreateDialog(Bundle)}方法中创建 AlertDialog
 * 二是直接像 Fragment 一样使用, 相关的封装放在 {@link EagleDialog } 中
 * 三则是对 Gravity, setStyle 进行处理, 相关封装放在 {@link EaglePanel} 中
 */
public class BaseDialog<BB extends BaseBuilder> extends AppCompatDialogFragment {

    protected BB builder;
    private AppCompatActivity activity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = builder.activity;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        return super.onCreateDialog(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        Dialog dialog = getDialog();

        // Work around bug: http://code.google.com/p/android/issues/detail?id=17423
        if (dialog != null && getRetainInstance()) {
            dialog.setDismissMessage(null);
        }
        super.onDestroyView();
    }

    public void setBuilder(BB builder) {
        this.builder = builder;
    }
}
