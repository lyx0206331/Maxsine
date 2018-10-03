package com.adrian.servodriver.activities;

import android.os.Bundle;
import android.view.View;

import com.adrian.servodriver.R;
import com.adrian.servodriver.databinding.ActivityDevDisconnBinding;
import com.adrian.servodriver.utils.D2xxUtil;
import com.jaeger.library.StatusBarUtil;

import androidx.databinding.DataBindingUtil;

public class DevDisconnActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initVariables() {

    }

    @Override
    protected void initViews() {
        setContentView(R.layout.activity_dev_disconn);
        ActivityDevDisconnBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_dev_disconn);
        DevDisconnect disconnect = new DevDisconnect();
        binding.setDisconnect(disconnect);
        StatusBarUtil.setTransparent(this);

    }

    @Override
    protected void loadData() {

    }

    @Override
    public void notifyByThemeChanged() {

    }

    public class DevDisconnect {
        public void clickBack(View v) {
            close();
        }

        public void clickConn(View v) {
//            ToastUtils.showShortSafe("连接设备");
            if (D2xxUtil.getInstance().isConnected()) {
                startActivity(MainActivity.class);
                finish();
            }
        }
    }
}
