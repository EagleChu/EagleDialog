package com.mizi.lib.dialog.base;

import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.*;

@Deprecated
class AlertParams {

    final Context mContext;
    final LayoutInflater mInflater;

    int mIconId = 0;
    Drawable mIcon;
    int mIconAttrId = 0;
    CharSequence mTitle;
    View mCustomTitleView;
    CharSequence mMessage;
    CharSequence mPositiveButtonText;
    DialogInterface.OnClickListener mPositiveButtonListener;
    CharSequence mNegativeButtonText;
    DialogInterface.OnClickListener mNegativeButtonListener;
    CharSequence mNeutralButtonText;
    DialogInterface.OnClickListener mNeutralButtonListener;
    boolean mCancelable;
    DialogInterface.OnCancelListener mOnCancelListener;
    DialogInterface.OnDismissListener mOnDismissListener;
    DialogInterface.OnKeyListener mOnKeyListener;
    CharSequence[] mItems;
    ListAdapter mAdapter;
    DialogInterface.OnClickListener mOnClickListener;
    int mViewLayoutResId;
    View mView;
    boolean mViewSpacingSpecified = false;
    boolean[] mCheckedItems;
    boolean mIsMultiChoice;
    boolean mIsSingleChoice;
    int mCheckedItem = -1;
    DialogInterface.OnMultiChoiceClickListener mOnCheckboxClickListener;
    Cursor mCursor;
    String mLabelColumn;
    String mIsCheckedColumn;
    boolean mForceInverseBackground;
    AdapterView.OnItemSelectedListener mOnItemSelectedListener;
    boolean mRecycleOnMeasure = true;

    AlertParams(Context context) {
        this.mContext = context.getApplicationContext();
        mCancelable = true;
        this.mInflater = LayoutInflater.from(context);
    }
}
