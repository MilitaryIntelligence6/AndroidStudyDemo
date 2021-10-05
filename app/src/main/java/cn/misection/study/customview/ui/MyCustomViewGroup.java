package cn.misection.study.customview.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author Military Intelligence 6 root
 * @version 1.0.0
 * @ClassName MyViewGroup
 * @Description TODO
 * @CreateTime 2021年10月04日 23:48:00
 */
public class MyCustomViewGroup extends ViewGroup {

    public MyCustomViewGroup(Context context) {
        super(context);
    }

    public MyCustomViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        measureChildren(widthMeasureSpec, heightMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        int childCount = getChildCount();
        int width = widthSize;
        int height = heightSize;

        switch (widthMode) {
            case MeasureSpec.AT_MOST:
                width = calcMaxWidth();
                break;
            case MeasureSpec.EXACTLY:
            case MeasureSpec.UNSPECIFIED:
                break;
            default:
                throw new IllegalStateException(String.format("Unexpected value: %d", widthMode));
        }
        switch (heightMode) {
            case MeasureSpec.AT_MOST:
                height = calcTotalHeight();
                break;
            case MeasureSpec.EXACTLY:
            case MeasureSpec.UNSPECIFIED:
                break;
            default:
                throw new IllegalStateException(String.format("Unexpected value: %d", heightMode));
        }
        setMeasuredDimension(width, height);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int curHeight = t;
        for (int i = 0, childCount = getChildCount(); i < childCount; i++) {
            View child = getChildAt(i);
            int childWidth = child.getMeasuredWidth();
            int childHeight = child.getMeasuredHeight();
            child.layout(l, curHeight, l + childWidth, curHeight + childHeight);
            curHeight += childHeight;
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    private int calcTotalHeight() {
        int totalHeight = 0;
        for (int i = 0, childCount = getChildCount(); i < childCount; i++) {
            totalHeight += getChildAt(i).getMeasuredHeight();
        }
        return totalHeight;
    }

    private int calcMaxWidth() {
        int maxWidth = 0;
        for (int i = 0, childCount = getChildCount(); i < childCount; i++) {
            maxWidth = Math.max(maxWidth, getChildAt(i).getMeasuredWidth());
        }
        return maxWidth;
    }
}
