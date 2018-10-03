package com.adrian.servodriver.views;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.adrian.servodriver.R;
import com.adrian.servodriver.adapter.SaveFileAdapter;
import com.adrian.servodriver.pojo.FileBean;
import com.adrian.servodriver.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;

/**
 * Created by ranqing on 2017/6/24.
 */

public class SaveDialog extends BaseDialog implements View.OnClickListener {

    private ListView mFilesLV;
    private EditText mFileNameET;
    private Button mSaveBtn;
    private Button mCancelBtn;

    private SaveFileAdapter mAdapter;
    private List<FileBean> data;

    public SaveDialog(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initViews() {
        mFilesLV = (ListView) findViewById(R.id.lv_files);
        mFileNameET = (EditText) findViewById(R.id.et_save_name);
        mSaveBtn = (Button) findViewById(R.id.btn_save);
        mCancelBtn = (Button) findViewById(R.id.btn_cancel);

        mAdapter = new SaveFileAdapter(context);
        mFilesLV.setAdapter(mAdapter);

        mSaveBtn.setOnClickListener(this);
        mCancelBtn.setOnClickListener(this);

        setOnDismissListener(new OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                mFileNameET.setText(null);
                mFileNameET.setError(null);
            }
        });
    }

    @Override
    protected void loadData() {
        data = new ArrayList();
        for (int i = 0; i < 20; i++) {
            FileBean bean = new FileBean();
            bean.setFileName("文件" + i);
            bean.setCreateTime(System.currentTimeMillis() + i);
            data.add(bean);
        }
        mAdapter.setData(data);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.layout_save_dialog;
    }

    /**
     * 是否有重名文件
     *
     * @param name
     * @return
     */
    private boolean hasSameName(String name) {
        if (data != null && data.size() > 0) {
            for (FileBean bean :
                    data) {
                if (bean.getFileName().equals(name.trim())) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_save:
                if (TextUtils.isEmpty(mFileNameET.getText())) {
//                    Drawable dr = getContext().getResources().getDrawable(
//                            R.drawable.ic_et_error);
//
//                    dr.setBounds(0, 0, dr.getIntrinsicWidth(), dr.getIntrinsicHeight());
                    mFileNameET.setError(context.getResources().getString(R.string.null_file_name));
                } else if (hasSameName(mFileNameET.getText().toString())) {
                    mFileNameET.setError(context.getResources().getString(R.string.has_same_name));
                } else {
                    ToastUtils.showShort("文件已保存");
                    dismiss();
                }
                break;
            case R.id.btn_cancel:
//                dismiss();
                cancel();
                break;
        }
    }
}
