package com.mizi.lib.dialog.base;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;

public abstract class WrapperBuilder<B extends WrapperBuilder, D extends WrapperDialog> extends BaseBuilder<B, D> {
    int layoutResId;
    int animationResId;
    boolean isCancelableOutside = true;
    boolean isTransparent = true;

    float dimAmount = 0.2f;
    int gravity = Gravity.CENTER;

    Object[] bindFrom;
    int[] bindTo;
    View.OnClickListener clickListener;
    int[] eventTo;
    DialogInterface.OnKeyListener keyListener;

    public WrapperBuilder(AppCompatActivity activity) {
        super(activity);
    }

    public B setCancelableOutside(boolean cancelableOutside) {
        isCancelableOutside = cancelableOutside;
        return self();
    }

    public B setDimAmount(float dimAmount) {
        this.dimAmount = dimAmount;
        return self();
    }

    public B setLayoutResId(int layoutResId) {
        this.layoutResId = layoutResId;
        return self();
    }

    public B setTransparent(boolean transparent) {
        isTransparent = transparent;
        return self();
    }

    public B setAnimationResId(int animationResId) {
        this.animationResId = animationResId;
        return self();
    }

    public B setBindFrom(Object... from) {
        this.bindFrom = from;
        return self();
    }

    public B setBindTo(int... bindTo) {
        this.bindTo = bindTo;
        return self();
    }

    public B setOnClickListener(View.OnClickListener listener, int... eventTo) {
        this.clickListener = listener;
        this.eventTo = eventTo;
        return self();
    }

    public B setOnKeyListener(DialogInterface.OnKeyListener listener) {
        this.keyListener = listener;
        return self();
    }

    int getLayoutResId() {
        return layoutResId;
    }

    int getAnimationResId() {
        return animationResId;
    }

    boolean isCancelableOutside() {
        return isCancelableOutside;
    }

    boolean isTransparent() {
        return isTransparent;
    }

    float getDimAmount() {
        return dimAmount;
    }

    public int getGravity() {
        return gravity;
    }

    public Object[] getBindFrom() {
        return bindFrom;
    }

    int[] getBindTo() {
        return bindTo;
    }

    View.OnClickListener getClickListener() {
        return clickListener;
    }

    DialogInterface.OnKeyListener getKeyListener() {
        return keyListener;
    }

    int[] getEventTo() {
        return eventTo;
    }

    @Override
    public abstract D build();
}
