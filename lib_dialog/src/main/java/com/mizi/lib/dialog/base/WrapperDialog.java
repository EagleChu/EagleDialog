package com.mizi.lib.dialog.base;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.SparseArray;
import android.view.*;
import android.widget.FrameLayout;
import com.mizi.lib.dialog.R;

import static com.mizi.lib.dialog.utils.ViewDataBinder.bindViewByData;

public class WrapperDialog<B extends WrapperBuilder> extends BaseDialog<B> {
    private FrameLayout rootView;
    protected SparseArray<View> views;
    protected int locationGravity = Gravity.CENTER;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(STYLE_NO_TITLE, android.R.style.Theme_DeviceDefault_Light_Dialog);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = (FrameLayout) inflater.inflate(R.layout.dialog_base, container, false);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT);
        rootView.setLayoutParams(layoutParams);
        inflater.inflate(builder.getLayoutResId(), rootView);
        return rootView;
    }

    /**
     * onViewCreated 紧跟在 onCreateView 之后执行，执行界面初始化完成之后的一些操作，如动画效果。
     */
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //去除Dialog默认头部
        Dialog dialog = getDialog();
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCanceledOnTouchOutside(builder.isCancelableOutside());
        if (dialog.getWindow() != null && builder.getAnimationResId() > 0) {
            dialog.getWindow().setWindowAnimations(builder.getAnimationResId());
        }

        Window window = dialog.getWindow();
        if (window != null) {
            //设置宽高
            WindowManager.LayoutParams layoutParams = window.getAttributes();
            layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
            layoutParams.height = WindowManager.LayoutParams.MATCH_PARENT;
            //透明度
            layoutParams.dimAmount = builder.getDimAmount();
            layoutParams.gravity = locationGravity;
            window.setAttributes(layoutParams);

            if (builder.isTransparent()) {
                //设置窗体背景色透明
                window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            }
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        views = new SparseArray<>();
        int[] bindTo = builder.getBindTo();
        findView(bindTo);

        int[] eventTo = builder.getEventTo();
        View.OnClickListener listener = builder.getClickListener();
        bindEvent(listener, eventTo);

        Dialog dialog = getDialog();
        if (builder.getKeyListener() != null)
            dialog.setOnKeyListener(builder.getKeyListener());
    }

    public void bindView(Object from, int to) {
        final View v = findView(to);
        if (v != null) {
            bindViewByData(v, from);
        }
    }

    public void bindView(String[] from, int[] to) {
        if (to == null || to.length <= 0) {
            return;
        }

        if (to.length < from.length) {
            for (int i = 0; i < to.length; i++) {
                final View v = findView(to[i]);
                if (v != null) {
                    final Object data = from[i];
                    bindViewByData(v, data);
                }
            }
        }

        if (from.length < to.length) {
            for (int i = 0; i < from.length; i++) {
                final View v = findView(to[i]);
                if (v != null) {
                    final Object data = from[i];
                    bindViewByData(v, data);
                }
            }
        }

    }

    public void bindEvent(View.OnClickListener clickListener, int id) {
        findView(id).setOnClickListener(clickListener);
    }

    public void bindEvent(View.OnClickListener clickListener, int... ids) {
        if (clickListener != null && ids != null && ids.length > 0) {
            for (int id : ids) {
                bindEvent(clickListener, id);
            }
        }
    }

    protected void findView(int... ids) {
        if (ids != null && ids.length > 0)
            for (int id : ids) {
                findView(id);
            }
    }

    protected <T extends View> T findView(int viewId) {
        View view = views.get(viewId);
        if (view == null && viewId != 0) {
            view = rootView.findViewById(viewId);
            views.put(viewId, view);
        }
        return (T) view;
    }
}
