package com.mizi.lib.dialog.base;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.support.annotation.ArrayRes;
import android.support.annotation.AttrRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;

public class TraditionBuilder extends BaseBuilder<TraditionBuilder, TraditionDialog> {

    private final AlertParams P;
    AlertDialog.Builder builder;

    public TraditionBuilder(AppCompatActivity activity) {
        super(activity);
        Context context = activity.getApplicationContext();
        P = new AlertParams(context);
        builder = new AlertDialog.Builder(context);
    }


    public TraditionBuilder setTitle(@StringRes int titleId) {
        P.mTitle = P.mContext.getText(titleId);
        builder.setTitle(titleId);
        return this;
    }


    public TraditionBuilder setTitle(CharSequence title) {
        P.mTitle = title;
        builder.setTitle(title);
        return this;
    }


    public TraditionBuilder setCustomTitle(View customTitleView) {
        P.mCustomTitleView = customTitleView;
        builder.setCustomTitle(customTitleView);
        return this;
    }


    public TraditionBuilder setMessage(@StringRes int messageId) {
        P.mMessage = P.mContext.getText(messageId);
        builder.setMessage(messageId);
        return this;
    }


    public TraditionBuilder setMessage(CharSequence message) {
        P.mMessage = message;
        builder.setMessage(message);
        return this;
    }


    public TraditionBuilder setIcon(@DrawableRes int iconId) {
        P.mIconId = iconId;
        builder.setIcon(iconId);
        return this;
    }


    public TraditionBuilder setIcon(Drawable icon) {
        P.mIcon = icon;
        builder.setIcon(icon);
        return this;
    }


    public TraditionBuilder setIconAttribute(@AttrRes int attrId) {
        TypedValue out = new TypedValue();
        P.mContext.getTheme().resolveAttribute(attrId, out, true);
        P.mIconId = out.resourceId;
        builder.setIconAttribute(attrId);
        return this;
    }


    public TraditionBuilder setPositiveButton(@StringRes int textId, final OnClickListener listener) {
        P.mPositiveButtonText = P.mContext.getText(textId);
        P.mPositiveButtonListener = listener;
        builder.setPositiveButton(textId, listener);
        return this;
    }


    public TraditionBuilder setPositiveButton(CharSequence text, final OnClickListener listener) {
        P.mPositiveButtonText = text;
        P.mPositiveButtonListener = listener;
        builder.setPositiveButton(text, listener);
        return this;
    }


    public TraditionBuilder setNegativeButton(@StringRes int textId, final DialogInterface.OnClickListener listener) {
        P.mNegativeButtonText = P.mContext.getText(textId);
        P.mNegativeButtonListener = listener;
        builder.setNegativeButton(textId, listener);
        return this;
    }


    public TraditionBuilder setNegativeButton(CharSequence text, final DialogInterface.OnClickListener listener) {
        P.mNegativeButtonText = text;
        P.mNegativeButtonListener = listener;
        builder.setNegativeButton(text, listener);
        return this;
    }


    public TraditionBuilder setNeutralButton(@StringRes int textId, final OnClickListener listener) {
        P.mNeutralButtonText = P.mContext.getText(textId);
        P.mNeutralButtonListener = listener;
        builder.setNeutralButton(textId, listener);
        return this;
    }


    public TraditionBuilder setNeutralButton(CharSequence text, final OnClickListener listener) {
        P.mNeutralButtonText = text;
        P.mNeutralButtonListener = listener;
        builder.setNeutralButton(text, listener);
        return this;
    }


    public TraditionBuilder setCancelable(boolean cancelable) {
        P.mCancelable = cancelable;
        builder.setCancelable(cancelable);
        return this;
    }


    public TraditionBuilder setOnCancelListener(OnCancelListener onCancelListener) {
        P.mOnCancelListener = onCancelListener;
        builder.setOnCancelListener(onCancelListener);
        return this;
    }

    public TraditionBuilder setOnDismissListener(OnDismissListener onDismissListener) {
        P.mOnDismissListener = onDismissListener;
        builder.setOnDismissListener(onDismissListener);
        return this;
    }

    public TraditionBuilder setOnKeyListener(OnKeyListener onKeyListener) {
        P.mOnKeyListener = onKeyListener;
        builder.setOnKeyListener(onKeyListener);
        return this;
    }


    public TraditionBuilder setItems(@ArrayRes int itemsId, final OnClickListener listener) {
        P.mItems = P.mContext.getResources().getTextArray(itemsId);
        P.mOnClickListener = listener;
        builder.setItems(itemsId, listener);
        return this;
    }


    public TraditionBuilder setItems(CharSequence[] items, final OnClickListener listener) {
        P.mItems = items;
        P.mOnClickListener = listener;
        builder.setItems(items, listener);
        return this;
    }


    public TraditionBuilder setAdapter(final ListAdapter adapter, final OnClickListener listener) {
        P.mAdapter = adapter;
        P.mOnClickListener = listener;
        builder.setAdapter(adapter, listener);
        return this;
    }


    public TraditionBuilder setCursor(final Cursor cursor, final OnClickListener listener,
                                      String labelColumn) {
        P.mCursor = cursor;
        P.mLabelColumn = labelColumn;
        P.mOnClickListener = listener;
        builder.setCursor(cursor, listener, labelColumn);
        return this;
    }


    public TraditionBuilder setMultiChoiceItems(@ArrayRes int itemsId, boolean[] checkedItems,
                                                final OnMultiChoiceClickListener listener) {
        P.mItems = P.mContext.getResources().getTextArray(itemsId);
        P.mOnCheckboxClickListener = listener;
        P.mCheckedItems = checkedItems;
        P.mIsMultiChoice = true;
        builder.setMultiChoiceItems(itemsId, checkedItems, listener);
        return this;
    }

    public TraditionBuilder setMultiChoiceItems(CharSequence[] items, boolean[] checkedItems,
                                                final OnMultiChoiceClickListener listener) {
        P.mItems = items;
        P.mOnCheckboxClickListener = listener;
        P.mCheckedItems = checkedItems;
        P.mIsMultiChoice = true;
        builder.setMultiChoiceItems(items, checkedItems, listener);
        return this;
    }

    public TraditionBuilder setMultiChoiceItems(Cursor cursor, String isCheckedColumn, String labelColumn,
                                                final OnMultiChoiceClickListener listener) {
        P.mCursor = cursor;
        P.mOnCheckboxClickListener = listener;
        P.mIsCheckedColumn = isCheckedColumn;
        P.mLabelColumn = labelColumn;
        P.mIsMultiChoice = true;
        builder.setMultiChoiceItems(cursor, isCheckedColumn, labelColumn, listener);
        return this;
    }

    public TraditionBuilder setSingleChoiceItems(@ArrayRes int itemsId, int checkedItem,
                                                 final OnClickListener listener) {
        P.mItems = P.mContext.getResources().getTextArray(itemsId);
        P.mOnClickListener = listener;
        P.mCheckedItem = checkedItem;
        P.mIsSingleChoice = true;
        builder.setSingleChoiceItems(itemsId, checkedItem, listener);
        return this;
    }

    public TraditionBuilder setSingleChoiceItems(Cursor cursor, int checkedItem, String labelColumn,
                                                 final OnClickListener listener) {
        P.mCursor = cursor;
        P.mOnClickListener = listener;
        P.mCheckedItem = checkedItem;
        P.mLabelColumn = labelColumn;
        P.mIsSingleChoice = true;
        builder.setSingleChoiceItems(cursor, checkedItem, labelColumn, listener);
        return this;
    }

    public TraditionBuilder setSingleChoiceItems(CharSequence[] items, int checkedItem, final OnClickListener listener) {
        P.mItems = items;
        P.mOnClickListener = listener;
        P.mCheckedItem = checkedItem;
        P.mIsSingleChoice = true;
        builder.setSingleChoiceItems(items, checkedItem, listener);
        return this;
    }

    public TraditionBuilder setSingleChoiceItems(ListAdapter adapter, int checkedItem, final OnClickListener listener) {
        P.mAdapter = adapter;
        P.mOnClickListener = listener;
        P.mCheckedItem = checkedItem;
        P.mIsSingleChoice = true;
        builder.setSingleChoiceItems(adapter, checkedItem, listener);
        return this;
    }

    public TraditionBuilder setOnItemSelectedListener(final AdapterView.OnItemSelectedListener listener) {
        P.mOnItemSelectedListener = listener;
        builder.setOnItemSelectedListener(listener);
        return this;
    }

    /**
     * Set a custom view resource to be the contents of the Dialog. The
     * resource will be inflated, adding all top-level views to the screen.
     *
     * @param layoutResId Resource ID to be inflated.
     * @return this TraditionBuilder object to allow for chaining of calls to set
     * methods
     */
    public TraditionBuilder setView(int layoutResId) {
        P.mView = null;
        P.mViewLayoutResId = layoutResId;
        P.mViewSpacingSpecified = false;
        builder.setView(layoutResId);
        return this;
    }

    public TraditionBuilder setView(View view) {
        P.mView = view;
        P.mViewLayoutResId = 0;
        P.mViewSpacingSpecified = false;
        builder.setView(view);
        return this;
    }

    public AlertDialog.Builder getAlertBuilder() {
        return builder;
    }

    @Override
    public TraditionDialog build() {
        return new TraditionDialog();
    }
}
