package gode_user01.example.com.secondactivityassignment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Integer d;
    private Integer m;
    private Integer y;
    private Integer c;
    private Integer day;
    private String s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void getInputValues(){

        EditText et_day = (EditText) findViewById(R.id.edittextday);
        EditText et_month = (EditText) findViewById(R.id.edittextmonth);
        EditText et_year = (EditText) findViewById(R.id.edittextyear);

        try {
            d = Integer.parseInt(et_day.getText().toString());
        }
        catch (Exception e){
            d = 0;
        }

        try {

            m = Integer.parseInt(et_month.getText().toString());
        }
        catch (Exception e){
            m = 0;
        }



        try {
            s = et_year.getText().toString();
            y = Integer.parseInt(s.substring(2));
            c =  Integer.parseInt(s.substring(0,2));
        }
        catch (Exception e){
            y = 0;
            c = 0;
        }


        if (m == 1 || m == 2) {
            m += 12;
            y--;
        }



        et_day.setText(d.toString());
        et_month.setText(m.toString());
        et_year.setText(s);
    }

    private void computeDay(){

        Log.d("computeDay()","s = "  + s + ", year = " + Integer.toString(y) + ", " + "century = " + Integer.toString(c));

        day = (d + (int)(26 *(m + 1)/10.0) + y + (int)(y/4.0) + (int)(c/4.0) + 5 * c ) % 7;
    }

    public void onClickCompute(View view){
        getInputValues();
        computeDay();
        printDay();
    }

    private void printDay(){
        String text;
        switch(day) {
            case 0:
                text = "Saturday!";
                break;
            case 1:
                text = "Sunday!";
                break;
            case 2:
                text = "Monday!";
                break;
            case 3:
                text = "Tuesday!";
                break;
            case 4:
                text ="Wednesday!";
                break;
            case 5:
                text ="Thursday!";
                break;
            case 6:
                text ="Friday!";
                break;
            default:
                text ="Invalid";
        }



        Intent i = new Intent(this, SecondActivity.class);


        i.putExtra("message", text);

        startActivity(i);
    }



}