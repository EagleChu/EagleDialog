package com.mizi.lib.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.*;
import com.mizi.lib.dialog.base.WrapperBuilder;
import com.mizi.lib.dialog.base.WrapperDialog;

public class EaglePanel extends WrapperDialog<EaglePanel.Builder> {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (locationGravity == Gravity.BOTTOM)
            setStyle(STYLE_NO_TITLE, R.style.mz_PanelFragment_Bottom);
        else if (locationGravity == Gravity.TOP)
            setStyle(STYLE_NO_TITLE, R.style.mz_PanelFragment_Top);
        else if (locationGravity == Gravity.LEFT)
            setStyle(STYLE_NO_TITLE, R.style.mz_PanelFragment_Left);
        else if (locationGravity == Gravity.RIGHT)
            setStyle(STYLE_NO_TITLE, R.style.mz_PanelFragment_Right);
        else {
            setStyle(STYLE_NO_TITLE, R.style.mz_PanelDialog);
        }
    }

    protected void show(FragmentManager manager, String tag, int gravity) {
        Dialog dialog = this.getDialog();
        if (dialog == null || !dialog.isShowing()) { // 对按钮做点击排重处理
            show(manager, tag);
            locationGravity = gravity;
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Window window = getDialog().getWindow();
        //设置宽高
        WindowManager.LayoutParams layoutParams = window.getAttributes();
        if (locationGravity == Gravity.BOTTOM || locationGravity == Gravity.TOP) {
            layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
            layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
        } else if (locationGravity == Gravity.LEFT || locationGravity == Gravity.RIGHT) {
            layoutParams.width = WindowManager.LayoutParams.WRAP_CONTENT;
            layoutParams.height = WindowManager.LayoutParams.MATCH_PARENT;
        } else {
            layoutParams.width = WindowManager.LayoutParams.WRAP_CONTENT;
            layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
        }


        // 可通过如下方式设置外部点击是否可以 dismiss dialog
//        getDialog().setCanceledOnTouchOutside(builder.isCancelableOutside());

        // 可复制此代码,将 Dialog 背景设为透明, 在Xml里设置根部局是无效的
//        if (builder.isTransparent())
//            getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        // 可复制此代码, DialogFragment弹出后Activity背景不变暗
//         getDialog().getWindow().getAttributes().dimAmount = 0f;
    }

    public void show(FragmentManager manager, int gravity) {
        show(manager, EaglePanel.class.getSimpleName(), gravity);
    }

    private FragmentManager getManager() {
        return builder.getActivity().getSupportFragmentManager();
    }

    @Deprecated //可以试用 EagleDialog
    public void showCenter(String tag) {
        show(getManager(), tag, Gravity.CENTER);
    }

    public void showBottom(String tag) {
        show(getManager(), tag, Gravity.BOTTOM);
    }

    public void showTop(String tag) {
        show(getManager(), tag, Gravity.TOP);
    }

    public void showLeft(String tag) {
        show(getManager(), tag, Gravity.LEFT);
    }

    public void showRight(String tag) {
        show(getManager(), tag, Gravity.RIGHT);
    }

    public void showBottom() {
        show(getManager(), Gravity.BOTTOM);
    }

    public void showTop() {
        show(getManager(), Gravity.TOP);
    }

    public void showLeft() {
        show(getManager(), Gravity.LEFT);
    }

    public void showRight() {
        show(getManager(), Gravity.RIGHT);
    }

    public static class Builder extends WrapperBuilder<Builder, EaglePanel> {

        public Builder(AppCompatActivity activity) {
            super(activity);
        }

        @Override
        public EaglePanel build() {
            EaglePanel panel = new EaglePanel();
            panel.setBuilder(this);
            return panel;
        }
    }
}
