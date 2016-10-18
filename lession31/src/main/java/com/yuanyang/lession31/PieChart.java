package com.yuanyang.lession31;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by yuanyang on 16/10/18.
 */

public class PieChart extends View {

    private boolean isShowText;

    private int labelPosition;

    /**
     * 至少提供一个这样的构造方法
     */
    public PieChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        /**
         *获取属性
         */
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.PieChart, 0, 0);
        try {
            isShowText = typedArray.getBoolean(R.styleable.PieChart_showText, false);
            labelPosition = typedArray.getInteger(R.styleable.PieChart_labelPosition, 0);
        } finally {
            typedArray.recycle();
        }
    }

    public boolean isShowText() {
        return isShowText;
    }

    /**
     * 当属性发生变化的时候,最好调用invalidate 和 requestLayout让界面刷新
     */
    public void setShowText(boolean isShowText) {
        this.isShowText = isShowText;
        invalidate();
        requestLayout();
    }

}
