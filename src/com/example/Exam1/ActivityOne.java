package com.example.Exam1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Arrays;

/**
 * Created by g00291410 on 22/10/2015.
 */
public class ActivityOne extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actv1);

        Intent inte = getIntent();
        Bundle bundle = inte.getExtras();
        int array[] = new int[5];

        array[0] = bundle. getInt("one");
        array[1]= bundle. getInt("two");
        array[2] = bundle. getInt("three");
        array[3]= bundle. getInt("four");
        array[4] = bundle. getInt("five");


        Arrays.sort(array);

        int max,min,sum;

        max = array[4];
        min = array[0];
        sum = array[0] + array[1] + array[2] + array[3] + array[4];

        bundle.putInt("max",max);
        bundle.putInt("min",min);
        bundle.putInt("sum",sum);

        TextView txt = (TextView)findViewById(R.id.actv1txt);
        txt.setText("Max = "+ max + " Min = "+min+" Sum = "+sum);

        inte.putExtras(bundle);
        setResult(Activity.RESULT_OK,inte);
    }

    public void return1(View ButtonClicked){
        finish();
    }

}
