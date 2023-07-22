package sg.edu.rp.c346.id22022505.myndpsongs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button insert, display;
    EditText title, singers, year;
    RadioGroup RGstars;
    ArrayList<Song> al;
    ArrayAdapter<Song> aa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        insert = findViewById(R.id.btnInsert);
        display = findViewById(R.id.btnDisplay);
        title = findViewById(R.id.title);
        singers = findViewById(R.id.singers);
        year = findViewById(R.id.year);
        RGstars = findViewById(R.id.stars);
        al = new ArrayList<Song>();
        aa = new ArrayAdapter<Song>(this,
                android.R.layout.simple_list_item_1, al);
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
// Create the DBHelper object, passing in the
// activity's Context
                DBHelper db = new DBHelper(MainActivity.this);
                String stTitle = String.valueOf(title.getText());
                String stSingers = String.valueOf(singers.getText());
                int iYear = Integer.valueOf(String.valueOf(year.getText()));
                int starCount = 0;
                int checkedRadioId = RGstars.getCheckedRadioButtonId();
                if (checkedRadioId == R.id.star1) {
                    starCount += 1;
                } else if (checkedRadioId == R.id.star2) {
                    starCount += 2;
                } else if (checkedRadioId == R.id.star3) {
                    starCount += 3;
                } else if (checkedRadioId == R.id.star4) {
                    starCount += 4;
                } else if (checkedRadioId == R.id.star5) {
                    starCount += 5;
                }
// Insert a task
                db.insertSong(stTitle, stSingers, iYear, starCount);
            }
        });
        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
// Create the DBHelper object, passing in the
// activity's Context
                Intent i = new Intent(MainActivity.this, activityView.class);
                startActivity(i);
            }
        });
    }}