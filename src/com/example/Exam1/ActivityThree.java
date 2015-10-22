package com.example.Exam1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Arrays;

/**
 * Created by g00291410 on 22/10/2015.
 */
public class ActivityThree extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actv3);

        Intent inte = getIntent();
        Bundle bundle = inte.getExtras();
        TextView txt = (TextView)findViewById(R.id.actv3txt);
        int[] array = bundle.getIntArray("array");

        Arrays.sort(array);

        int max = array[array.length-1];

        int min = array[0];
        int sum = 0;

        for(int i=0; i<array.length; i++)
            sum += array[i];

        bundle.putInt("max",max);
        bundle.putInt("min",min);
        bundle.putInt("sum",sum);


        txt.setText("Max = "+ max + " Min = "+min+" Sum = "+sum);

        inte.putExtras(bundle);
        setResult(Activity.RESULT_OK,inte);


    }

    public void return3(View ClickedButton){
        finish();
    }

}
