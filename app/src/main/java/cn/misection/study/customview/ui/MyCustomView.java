package cn.misection.study.customview.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

import cn.misection.study.BuildConfig;
import cn.misection.study.R;

/**
 * @author Military Intelligence 6 root
 * @version 1.0.0
 * @ClassName MyView
 * @Description TODO
 * @CreateTime 2021年10月04日 18:17:00
 */
public class MyCustomView extends View {

    private int defaultSize;

    /**
     * 如果这个控件会在 java 代码中 new 的话，必须实现;
     *
     * @param context
     */
    public MyCustomView(Context context) {
        super(context);
    }

    /**
     * 如果控件直接在 xml 中使用，必须实现;
     *
     * @param context
     * @param attrs
     */
    public MyCustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        // pair
        TypedArray freeNeededTypedArray = context.obtainStyledAttributes(attrs, R.styleable.MyViewStyle);
        defaultSize = freeNeededTypedArray.getDimensionPixelSize(R.styleable.MyViewStyle_default_size, 100);
        freeNeededTypedArray.recycle();
        // end pair
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = calcMySize(widthMeasureSpec);
        int height = calcMySize(heightMeasureSpec);
        // 获得正方形;
        int sideLength = Math.min(width, height);
        setMeasuredDimension(sideLength, sideLength);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int radius = getMeasuredWidth() / 2;
        int centerX = getLeft() + radius;
        int centerY = getTop() + radius;
        Paint paint = new Paint();
        paint.setColor(Color.GREEN);
        canvas.drawCircle(centerX, centerY, radius, paint);
    }

    private int calcMySize(int measureSpec) {
        // 测量模式;
        switch (MeasureSpec.getMode(measureSpec)) {
            case MeasureSpec.UNSPECIFIED:
                // 未指明, 设置为默认大小;
                return defaultSize;
            case MeasureSpec.AT_MOST:
                // 测量模式取最大值
                // 则将大小取最大值, 你也可以取其他值
            case MeasureSpec.EXACTLY:
                // 固定大小;
                return MeasureSpec.getSize(measureSpec);
            default:
                throw new IllegalStateException(String.format("Unexpected value: %d", measureSpec));
        }
    }
}
