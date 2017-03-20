package com.feerlaroc.libs;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.feerlaroc.widgets.ReactiveToggleButton;

import rx.functions.Action1;

public class ToggleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toggle);

        ReactiveToggleButton rtb = (ReactiveToggleButton) findViewById(R.id.toggle_property);
        rtb.setOnValueChangedListener(new ReactiveToggleButton.OnValueChangedListener() {
            @Override
            public void onValueChanged(int value) {
                rtb.getSelectedSubject().onNext(value);
            }
        });


        rtb.getSelectedSubject().subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer integer) {

                Toast.makeText(getBaseContext(), "Selected is : " + rtb.getTextAtChild(integer), Toast.LENGTH_LONG).show();
            }
        });

        rtb.setValueByText("Mganka");
    }
}
