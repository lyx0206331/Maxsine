package com.adrian.servodriver.views;

import android.content.Context;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.adrian.servodriver.R;

import androidx.annotation.NonNull;

/**
 * Created by ranqing on 2017/7/18.
 */

public class WarningDialog extends BaseDialog implements View.OnClickListener {

    private ImageButton mBackIB;
    private TextView mCodeTV;
    private TextView mContentTV;
    private TextView mReasonTV;
    private TextView mSolutionTV;
    private Button mKnowBtn;

    public WarningDialog(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initViews() {
        mBackIB = (ImageButton) findViewById(R.id.ib_close);
        mCodeTV = (TextView) findViewById(R.id.tv_code);
        mContentTV = (TextView) findViewById(R.id.tv_content);
        mReasonTV = (TextView) findViewById(R.id.tv_reason);
        mSolutionTV = (TextView) findViewById(R.id.tv_solution);
        mKnowBtn = (Button) findViewById(R.id.btn_know);

        mCodeTV.setMovementMethod(ScrollingMovementMethod.getInstance());
        mContentTV.setMovementMethod(ScrollingMovementMethod.getInstance());
        mReasonTV.setMovementMethod(ScrollingMovementMethod.getInstance());
        mSolutionTV.setMovementMethod(ScrollingMovementMethod.getInstance());

        mBackIB.setOnClickListener(this);
        mKnowBtn.setOnClickListener(this);
    }

    @Override
    protected void loadData() {

    }

    @Override
    protected int getLayoutResId() {
        return R.layout.layout_warning_dialog;
    }

    public WarningDialog setErrCode(String code) {
        mCodeTV.setText(code);
        return this;
    }

    public WarningDialog setErrContent(String content) {
        mContentTV.setText(content);
        return this;
    }

    public WarningDialog setErrReason(String reason) {
        mReasonTV.setText(reason);
        return this;
    }

    public WarningDialog setSolution(String solution) {
        mSolutionTV.setText(solution);
        return this;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ib_close:
            case R.id.btn_know:
//                dismiss();
                cancel();
                break;
        }
    }
}
