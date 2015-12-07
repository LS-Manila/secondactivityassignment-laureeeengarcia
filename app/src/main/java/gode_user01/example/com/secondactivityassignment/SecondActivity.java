package gode_user01.example.com.secondactivityassignment;

    import android.content.Intent;
    import android.os.Bundle;
    import android.support.v7.app.AppCompatActivity;
    import android.widget.TextView;

    public class SecondActivity extends AppCompatActivity {


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_second);
            Intent();
        }

        private void Intent(){
            Intent i = getIntent();
            String day_out = i.getStringExtra("message");
            TextView tv_out = (TextView) findViewById(R.id.textViewOut);
            tv_out.setText(day_out);
        }

    }