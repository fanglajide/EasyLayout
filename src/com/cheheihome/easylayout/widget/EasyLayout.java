package com.cheheihome.easylayout.widget;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ScrollView;

/**
 * Created by chanlevel on 15/1/5.
 */
public class EasyLayout extends ViewGroup {
    private View headView;
    private View indicatorView;
    private AbsListView listView;
private ViewDragHelper viewDragHelper;
    public EasyLayout(Context context) {
        super(context);
        findViews();
    }

    public EasyLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        findViews();
    }

    public EasyLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        findViews();
    }

    private void findViews() {
        headView = this.getChildAt(0);
        indicatorView = this.getChildAt(1);
        listView = (AbsListView) this.getChildAt(2);
        viewDragHelper=ViewDragHelper.create(this, callback);

    }


    ViewDragHelper.Callback callback=new ViewDragHelper.Callback() {
        @Override
        public boolean tryCaptureView(View view, int i) {
            return false;
        }

        @Override
        public int clampViewPositionVertical(View child, int top, int dy) {
            return super.clampViewPositionVertical(child, top, dy);
        }

        @Override
        public void onViewDragStateChanged(int state) {
            super.onViewDragStateChanged(state);
        }

        @Override
        public void onViewReleased(View releasedChild, float xvel, float yvel) {
            super.onViewReleased(releasedChild, xvel, yvel);
        }


        @Override
        public void onViewCaptured(View capturedChild, int activePointerId) {
            super.onViewCaptured(capturedChild, activePointerId);
        }
    };

    @Override
    public void computeScroll() {
        super.computeScroll();

 
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        int startY = 0;
        int startX = 0;
        int upY, upX, currentX, currentY;

        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                startY = (int) ev.getY();
                startX = (int) ev.getX();
                break;

            case MotionEvent.ACTION_MOVE:
                currentY = (int) ev.getY();
                currentX = (int) ev.getX();
                if (Math.abs(currentX - startX) > Math.abs(currentY - startX)) return false;

                    //上滑
                else if (currentY < startY) {
                    if (getAbsFirst() == 0 && getIndicatorY() > 0) return true;
                    else if (getIndicatorY() <= 0) {

                        return false;
                    }
                } else {//下滑

                    if (getIndicatorY() <= 0) return false;
                    else return true;

                }

                break;

            case MotionEvent.ACTION_UP:
                upY = (int) ev.getY();
                break;


        }


        return super.onInterceptTouchEvent(ev);
    }

    /**
     * {@inheritDoc}
     *
     * @param changed
     * @param l
     * @param t
     * @param r
     * @param b
     */
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }


    @Override
    public boolean onTouchEvent(MotionEvent ev) {


        return super.onTouchEvent(ev);
    }


    private int getAbsFirst() {

        return listView.getFirstVisiblePosition();

    }

    private int getlistFirstY() {


        return (int) listView.getChildAt(0).getTop();
    }

    private int firstVisibleItem;

    AbsListView.OnScrollListener scrollListener = new AbsListView.OnScrollListener() {
        @Override
        public void onScrollStateChanged(AbsListView view, int scrollState) {

        }

        @Override
        public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
            EasyLayout.this.firstVisibleItem = firstVisibleItem;
        }
    };







    private boolean compareY() {

        return getlistFirstY() < indicatorView.getBottom();

    }


    private int getIndicatorY() {
        return (int) indicatorView.getY();
    }


}
