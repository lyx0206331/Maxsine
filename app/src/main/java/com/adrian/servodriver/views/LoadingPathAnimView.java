package com.adrian.servodriver.views;

import android.content.Context;
import android.util.AttributeSet;

import com.mcxtzhang.pathanimlib.PathAnimView;
import com.mcxtzhang.pathanimlib.res.StoreHousePath;
import com.mcxtzhang.pathanimlib.utils.PathParserUtils;

/**
 * 介绍：一种填充loading的动画View
 * 继承View的好处是 xml可以预览 ，也可以代码动态设置
 */

public class LoadingPathAnimView extends PathAnimView {
    public LoadingPathAnimView(Context context) {
        this(context, null);
    }

    public LoadingPathAnimView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LoadingPathAnimView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setSourcePath(PathParserUtils.getPathFromArrayFloatList(StoreHousePath.getPath("MaxSine")));
    }
}
