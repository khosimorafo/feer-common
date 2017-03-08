package com.feerlaroc.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import rx.Observable;

/**
 * Created by root on 2016/09/07.
 */
public class ReactiveCurrencyBite extends ReactiveDataBite {

    Observable<Double> mObservable;

    public ReactiveCurrencyBite(Context context) {

        super(context);
    }

    public ReactiveCurrencyBite(Context context, AttributeSet attrs) {

        super(context, attrs);
    }

    public ReactiveCurrencyBite(Context context, AttributeSet attrs, int defStyleAttr) {

        super(context, attrs, defStyleAttr);
    }


    @Override
    public void subscribeTo(Object observable) {

        mObservable = (Observable<Double>) observable;
        mObservable.subscribe(this::updateValue);
    }

    private void updateValue(Double amount){

        setValue("R " + amount.toString());
    }

    @Override
    public void onClick(View v) {

    }
}
