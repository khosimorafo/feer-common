package com.feerlaroc.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;

import com.feerlaroc.widgets.rx.RxSelectable;
import com.feerlaroc.widgets.view.WheelView;

import java.util.List;

import rx.Observable;

public class ReactiveWheelView extends WheelView {

    public ReactiveWheelView(Context context) {
        super(context);
    }

    public ReactiveWheelView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ReactiveWheelView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    private void updateValue(List items){

        try {

            RxSelectable.items(this).call(items);
        } catch (Exception e) {

            Log.e(TAG, getContext().getString(R.string.str_dbkey_undefined) + " : " + e.getMessage());
        }
    }

    private void setSelected(Integer selected){

        try {

            RxSelectable.selected(this).call(selected);
        } catch (Exception e) {

            Log.e(TAG, getContext().getString(R.string.str_dbkey_undefined) + " : " + e.getMessage());
        }
    }

    private void setSelected(String text){

        try {

            RxSelectable.selectedText(this).call(text);
        } catch (Exception e) {

            Log.e(TAG, getContext().getString(R.string.str_dbkey_undefined) + " : " + e.getMessage());
        }
    }

    public void setItems(Observable<List> observable){

        observable.subscribe(this::updateValue);
    }

    @Deprecated
    public void subscribeTo(Observable<List> observable){

        observable.subscribe(this::updateValue);
    }

    public void setSelected(Observable<Integer> selected){

        selected.subscribe(this::setSelected);
    }

    public void setSelectedText(Observable<String> selected){

        selected.subscribe(this::setSelected);
    }
}
