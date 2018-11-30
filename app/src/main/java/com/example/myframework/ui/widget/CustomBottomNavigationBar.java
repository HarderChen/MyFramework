package com.example.myframework.ui.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.util.TypedValue;

import java.lang.ref.WeakReference;
import java.lang.reflect.Field;

/**
 * Created by 陈行 on 2018/11/30 0030.
 */

public class CustomBottomNavigationBar extends BottomNavigationView {
    private float mShiftAmount;
    private float mScaleUpFactor;
    private float mScaleDownFactor;
    private boolean animationRecord;
    private float mLargeLabelSize;
    private float mSmallLabelSize;
    private boolean visibilityTextSizeRecord;
    private boolean visibilityHeightRecord;
    private int mItemHeight;
    private boolean textVisibility = true;

    private ViewPager mViewPager;
    private BottomNavigationMenuView mMenuView;
    private BottomNavigationItemView[] mButtons;

    private static boolean isNavigationItemClicking = false;

    public CustomBottomNavigationBar(Context context) {
        super(context);
    }

    public CustomBottomNavigationBar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomBottomNavigationBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    public void enableShiftingMode(boolean enable) {
        BottomNavigationMenuView mMenuView = getBottomNavigationMenuView();

        setField(mMenuView.getClass(), mMenuView, "isShifting", enable);
        mMenuView.updateMenuView();
    }

    public void enableItemShiftingMode(boolean enable) {
        BottomNavigationMenuView mMenuView = getBottomNavigationMenuView();

        BottomNavigationItemView[] mButtons = getBottomNavigationItemViews();

        for (BottomNavigationItemView button : mButtons) {
            setField(button.getClass(), button, "mShiftingMode", enable);
        }
        mMenuView.updateMenuView();
    }

    public BottomNavigationItemView[] getBottomNavigationItemViews() {
        if (null != mButtons)
            return mButtons;
        /*
         * 1 private final BottomNavigationMenuView mMenuView;
         * 2 private BottomNavigationItemView[] mButtons;
         */
        BottomNavigationMenuView mMenuView = getBottomNavigationMenuView();
        mButtons = getField(mMenuView.getClass(), mMenuView, "buttons");
        return mButtons;
    }

    private <T> T getField(Class targetClass, Object instance, String fieldName) {
        try {
            Field field = targetClass.getDeclaredField(fieldName);
            field.setAccessible(true);
            return (T) field.get(instance);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void setField(Class targetClass, Object instance, String fieldName, Object value) {
        try {
            Field field = targetClass.getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(instance, value);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private BottomNavigationMenuView getBottomNavigationMenuView() {
        if (null == mMenuView)
            mMenuView = getField(BottomNavigationView.class, this, "menuView");
        return mMenuView;
    }
}
