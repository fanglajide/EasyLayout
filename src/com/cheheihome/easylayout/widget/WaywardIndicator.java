package com.cheheihome.easylayout.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by chanlevel on 15/1/6.
 */
public class WaywardIndicator extends TextView {
    private int h;

    public WaywardIndicator(Context context) {
        super(context);
    }

    public WaywardIndicator(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public WaywardIndicator(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }


    private void iniTop() {

    }

    private int iniHeight() {
        h = h == 0 ? getMeasuredHeight() : h;

        return h;
    }



    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {


        if (top <= 0) {
            top = 0;
            bottom = top + iniHeight();
        }
        Log.i("top",top+"");
        super.onLayout(changed, left, top, right, bottom);
    }
}
