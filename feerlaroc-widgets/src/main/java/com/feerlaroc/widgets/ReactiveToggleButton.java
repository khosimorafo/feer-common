package com.feerlaroc.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.Button;

import com.feerlaroc.widgets.rx.RxToggleButton;
import com.feerlaroc.widgets.view.FeerlarocMultiStateToggleButton;

import rx.Observable;
import rx.subjects.BehaviorSubject;

public class ReactiveToggleButton extends FeerlarocMultiStateToggleButton {

    static BehaviorSubject<Integer> mSelectedSubject = BehaviorSubject.create();

    private static final String TAG = "ReactiveToggleButton";
    private String mKey;

    public ReactiveToggleButton(Context context) {
        super(context);
    }

    public ReactiveToggleButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ReactiveToggleButton setKey(String key){

        mKey = key;
        return this;
    }

    private void setSelected(Integer int_value){

        try {

            RxToggleButton.value(this).call(int_value);

        } catch (Exception e) {

            Log.e(TAG, getContext().getString(R.string.str_dbkey_undefined) + " : " + e.getMessage());
        }
    }

    public void subscribeTo(Observable<Integer> observable){

        observable.subscribe(this::setSelected);
    }

    @Override
    public void setValue(int position) {
        super.setValue(position);

        mSelectedSubject.onNext(position);
    }

    public BehaviorSubject<Integer> getSelectedSubject(){

        return mSelectedSubject;
    }

    public String getTextAtChild(int index){

        Button btn = (Button) getChildAt(index);
        return  (String) btn.getText();
    }
}
