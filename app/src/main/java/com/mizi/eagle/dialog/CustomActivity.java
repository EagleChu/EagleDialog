package com.mizi.eagle.dialog;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;
import com.mizi.lib.dialog.EagleDialog;
import com.mizi.lib.dialog.EaglePanel;

public class CustomActivity extends AppCompatActivity {

    EagleDialog currentDialog;
    EaglePanel currentPanel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom);
    }

    public void showLoading(View view) {
        EagleDialog dialog = new EagleDialog.Builder(this)
                .setLayoutResId(R.layout.dialog_loading)
                .build();
        dialog.show();
    }

    public void showTraditionAlert(View view) {
        currentDialog = new EagleDialog.Builder(this)
                .setLayoutResId(R.layout.dialog_tradition_alert)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (v.getId() == R.id.btnLeft) {
                            toast("点击了Left");
                            currentDialog.dismiss();
                        } else if (v.getId() == R.id.btnRight) {
                            toast("点击了Right");
                            currentDialog.dismiss();
                        } else {
                            toast("点击了其他位置");
                        }
                    }
                }, R.id.btnLeft, R.id.btnRight, R.id.tvTitle, R.id.tvContent)
                .build();
        currentDialog.show();

    }

    public void showCommonUpgrade(View view) {
        currentDialog = new EagleDialog.Builder(this)
                .setLayoutResId(R.layout.dialog_common_upgrade)
                .setCancelableOutside(true)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (v.getId() == R.id.tvCancel) {
                            currentDialog.dismiss();
                        } else if (v.getId() == R.id.tvConfirm) {
                            toast("开始升级");
                            currentDialog.dismiss();
                        }
                    }
                }, R.id.tvCancel, R.id.tvConfirm)
                .build();
        currentDialog.show();
    }

    public void showForceUpgrade(View view) {
        currentDialog = new EagleDialog.Builder(this)
                .setLayoutResId(R.layout.dialog_force_upgrade)
                .setCancelableOutside(false)
                .setOnKeyListener(new DialogInterface.OnKeyListener() {
                    @Override
                    public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
                        if (keyCode == KeyEvent.KEYCODE_BACK) {
                            toast("返回健无效，请强制升级后使用");
                            return true;
                        }
                        return false;
                    }
                })
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        toast("开始升级");
                        currentDialog.dismiss();
                    }
                }, R.id.tvConfirm)
                .build();
        currentDialog.show();
    }

    public void showLeftPanel(View view) {
        currentPanel = new EaglePanel.Builder(this)
                .setLayoutResId(R.layout.panel_lefe_panel)
                .build();
        currentPanel.showLeft();
    }

    public void showRightPanel(View view) {
        currentPanel = new EaglePanel.Builder(this)
                .setLayoutResId(R.layout.panel_right_panel)
                .build();
        currentPanel.showRight();
    }

    public void showTopPanel(View view) {
        currentPanel = new EaglePanel.Builder(this)
                .setLayoutResId(R.layout.panel_top_panel)
                .build();
        currentPanel.showTop();
    }

    public void showBottomPanel(View view) {
        currentPanel = new EaglePanel.Builder(this)
                .setLayoutResId(R.layout.panel_bottom_panel)
                .build();
        currentPanel.showBottom();
    }


    void toast(String msg) {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
    }
}
