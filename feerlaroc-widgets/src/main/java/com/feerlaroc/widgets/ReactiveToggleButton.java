package com.feerlaroc.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;

import com.feerlaroc.widgets.rx.RxToggleButton;
import org.honorato.multistatetogglebutton.MultiStateToggleButton;
import rx.Observable;

public class ReactiveToggleButton extends MultiStateToggleButton {

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

    private void updateValue(Integer int_value){

        try {

            RxToggleButton.value(this).call(int_value);

        } catch (Exception e) {

            Log.e(TAG, getContext().getString(R.string.str_dbkey_undefined) + " : " + e.getMessage());
        }
    }

    public void subscribeTo(Observable<Integer> observable){

        observable.subscribe(this::updateValue);
    }

}
