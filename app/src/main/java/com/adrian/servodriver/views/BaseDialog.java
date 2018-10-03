package com.adrian.servodriver.views;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import com.adrian.servodriver.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;

/**
 * Created by ranqing on 2017/7/23.
 */

public abstract class BaseDialog extends Dialog {

    protected Context context;

    public BaseDialog(@NonNull Context context) {
        super(context, R.style.Dialog);
        this.context = context;
    }

    public BaseDialog(@NonNull Context context, @StyleRes int themeResId) {
        super(context, themeResId);
    }

    protected BaseDialog(@NonNull Context context, boolean cancelable, @Nullable DialogInterface.OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResId());
        initViews();
        loadData();
    }

    protected abstract void initViews();

    protected abstract void loadData();

    protected abstract int getLayoutResId();
}
