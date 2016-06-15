package johnkriegerinc.counter;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Count extends AppCompatActivity {
    public static final String PREFS_NAME ="MyPrefsFile";
    int number;
    void setNumber(int numba){
        number=numba;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count);
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        int savedNumber = settings.getInt("savedNumber", 0);
        setNumber(savedNumber);
    }

    void count(View v){


        EditText counter = (EditText)findViewById(R.id.num);
        //EditText number = (EditText) findViewById(R.id.num);
        number++;
        counter.setText(Integer.toString(number));

    }

    protected void onSave(View v){
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("savedNumber", number);

        editor.commit();
    }


}
