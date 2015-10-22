package com.example.Exam1;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Exam extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        EditText edt1 = (EditText)findViewById(R.id.editText);
        edt1.setText("Used numbers are 1, 4, 6, 7, 9");
    }



    public void btn1(View ButtonClicked){

        Intent inte = new Intent(this,ActivityOne.class);
        Bundle bundle = new Bundle();

        bundle.putInt("one",1);
        bundle.putInt("two",4);
        bundle.putInt("three",6);
        bundle.putInt("four",7);
        bundle.putInt("five",9);

        inte.putExtras(bundle);
        startActivityForResult(inte,101);
    }

    public void btn2(View ClickedButton){
        EditText txt1 = (EditText)findViewById(R.id.editText2);
        Intent inte = new Intent(this,ActivityTwo.class);
        Bundle bundle = new Bundle();

        String str = txt1.getText().toString();

        String[] array = str.split(" ");
        int[] tosend = new int[array.length];

        for(int y= 0; y<array.length; y++){
            tosend[y] = Integer.parseInt(array[y]);
        }

        bundle.putIntArray("array",tosend);
        inte.putExtras(bundle);

        startActivityForResult(inte,102);
    }

    public void btn3(View ClickedButton){
        EditText txt1 = (EditText)findViewById(R.id.editText3);
        Uri uri = Uri.parse("App3://example.com/app3");
        Intent inte1 = new Intent(Intent.ACTION_VIEW,uri);
        Bundle bundle = new Bundle();

        String str = txt1.getText().toString();

        String[] array = str.split(" ");
        int[] tosend = new int[array.length];

        for(int y= 0; y<array.length; y++){
            tosend[y] = Integer.parseInt(array[y]);
        }

        bundle.putIntArray("array",tosend);
        inte1.putExtras(bundle);

        startActivityForResult(inte1,103);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try{
            if((requestCode == 101 ) && (resultCode == Activity.RESULT_OK)){
                Bundle result = data.getExtras();
                int sum = result.getInt("sum");
                int max = result.getInt("max");
                int min = result.getInt("min");

                TextView txt = (TextView)findViewById(R.id.textView);
                txt.setText("Max = "+ max + " Min = "+min+" Sum = "+sum);
            }
            else if((requestCode == 102 ) && (resultCode == Activity.RESULT_OK)){
                Bundle result = data.getExtras();
                int sum = result.getInt("sum");
                int max = result.getInt("max");
                int min = result.getInt("min");

                TextView txt = (TextView)findViewById(R.id.textView2);
                txt.setText("Max = "+ max + " Min = "+min+" Sum = "+sum);
            }
            else if((requestCode == 103 ) && (resultCode == Activity.RESULT_OK)){
                Bundle result = data.getExtras();
                int sum = result.getInt("sum");
                int max = result.getInt("max");
                int min = result.getInt("min");

                TextView txt = (TextView)findViewById(R.id.textView3);
                txt.setText("Max = "+ max + " Min = "+min+" Sum = "+sum);
            }
        }catch (Exception e){
        }
    }


}
