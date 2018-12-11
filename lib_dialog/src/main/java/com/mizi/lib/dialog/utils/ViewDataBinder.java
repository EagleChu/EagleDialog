package com.mizi.lib.dialog.utils;

import android.net.Uri;
import android.view.View;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.TextView;

public class ViewDataBinder {

    /**
     * 绑定数据到相应的View中
     *
     * @param v    绑定的目标
     * @param data 相应的数据
     */
    public static void bindViewByData(View v, Object data) {
        String text = data == null ? "" : String.valueOf(data);
        if (v instanceof Checkable) {
            if (data instanceof Boolean) {
                ((Checkable) v).setChecked((Boolean) data);
            } else if (v instanceof TextView) {
                // Note: keep the instanceof TextView check at the bottom of these
                // ifs since a lot of views are TextViews (e.g. CheckBoxes).
                setViewText((TextView) v, text);
            } else {
                throw new IllegalStateException(v.getClass().getName() +
                        " should be bound to a Boolean, not a " +
                        (data == null ? "<unknown type>" : data.getClass()));
            }
        } else if (v instanceof TextView) {
            // Note: keep the instanceof TextView check at the bottom of these
            // ifs since a lot of views are TextViews (e.g. CheckBoxes).
            setViewText((TextView) v, text);
        } else if (v instanceof ImageView) {
            if (data instanceof Integer) {
                setViewImage((ImageView) v, (Integer) data);
            } else {
                setViewImage((ImageView) v, text);
            }
        } else {
            throw new IllegalStateException(v.getClass().getName() + " is not a " +
                    " view that can be bounds by this SimpleArrayAdapter");
        }
    }

    private static void setViewImage(ImageView v, String value) {
        try {
            v.setImageResource(Integer.parseInt(value));
        } catch (NumberFormatException nfe) {
            v.setImageURI(Uri.parse(value));
        }
    }

    private static void setViewImage(ImageView v, int value) {
        v.setImageResource(value);
    }

    private static void setViewText(TextView v, String text) {
        v.setText(text);
    }
}
