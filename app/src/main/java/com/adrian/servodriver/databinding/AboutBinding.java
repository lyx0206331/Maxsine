package com.adrian.servodriver.databinding;

import android.graphics.Typeface;
import android.view.View;

import com.adrian.servodriver.activities.AboutActivity;
import com.adrian.servodriver.activities.BaseActivity;
import com.adrian.servodriver.application.MyApplication;
import com.adrian.servodriver.official_demo.J2xxHyperTerm;

import androidx.databinding.BindingConversion;

/**
 * Created by ranqing on 2017/7/30.
 */

public class AboutBinding {

    private AboutActivity act;
    private String version;
    private int clickIconTimes;
    private long clickTime;

    public AboutBinding(AboutActivity act) {
        this.act = act;
        clickIconTimes = 0;
    }

    @BindingConversion
    public static Typeface convertStringToFace(String s) {
        try {
            return Typeface.createFromAsset(MyApplication.getInstance().getAssets(), s);
        } catch (Exception e) {
            throw e;
        }
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void clickBack(View v) {
        act.close();
    }

    public void bootOffical(View v) {
        if (System.currentTimeMillis() - clickTime > 500) {
            if (clickIconTimes > 0) {
                clickIconTimes = 0;
            }
            clickIconTimes++;
            clickTime = System.currentTimeMillis();
        } else if (System.currentTimeMillis() - clickTime < 500) {
            clickIconTimes++;
            clickTime = System.currentTimeMillis();
        }
        if (clickIconTimes == 3) {
            clickIconTimes = 0;
            act.startActivity(J2xxHyperTerm.class);
        }
    }
}
