package com.adrian.servodriver.activities;

import android.os.Bundle;

import com.adrian.servodriver.R;
import com.adrian.servodriver.databinding.AboutBinding;
import com.adrian.servodriver.databinding.ActivityAboutBinding;
import com.adrian.servodriver.utils.AppUtils;
import com.jaeger.library.StatusBarUtil;

import androidx.databinding.DataBindingUtil;

public class AboutActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        close();
    }

    @Override
    protected void initVariables() {

    }

    @Override
    protected void initViews() {
        ActivityAboutBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_about);

        AboutBinding about = new AboutBinding(this);
        about.setVersion("v" + AppUtils.getAppVersionName());
        binding.setAbout(about);
        StatusBarUtil.setTransparent(this);
    }

    @Override
    protected void loadData() {

    }

    @Override
    public void notifyByThemeChanged() {

    }
}
