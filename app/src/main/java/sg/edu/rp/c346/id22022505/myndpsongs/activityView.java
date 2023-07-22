package sg.edu.rp.c346.id22022505.myndpsongs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class activityView extends AppCompatActivity {
    ArrayList<String> songs;
    ListView lv;
    Button showAll, back;
    ArrayList<Song> al;
    ArrayAdapter<Song> aa;
    CustomAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        lv = findViewById(R.id.lvDisplay);
        showAll = findViewById(R.id.btn5);
        back = findViewById(R.id.btnback);
        al = new ArrayList<Song>();
        DBHelper db = new DBHelper(activityView.this);
        al.clear();
        al.addAll(db.getSongs());
        adapter = new CustomAdapter(this, R.layout.row, al);

        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int
                    position, long identity) {
                Song data = al.get(position);
                Intent i = new Intent(activityView.this, activityEdit.class);
                i.putExtra("ID", data);
                i.putExtra("Title", data);
                i.putExtra("Singers", data);
                i.putExtra("Year", data);
                i.putExtra("Stars", data);
                startActivity(i);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        showAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(activityView.this);
                al.clear();
                String filterText = "*****";
                al.addAll(dbh.getAllSongs(String.valueOf(filterText.length())));
                adapter.notifyDataSetChanged();
            }
        });
    }
}