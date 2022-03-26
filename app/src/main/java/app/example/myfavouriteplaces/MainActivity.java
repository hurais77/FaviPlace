package app.example.myfavouriteplaces;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ListView listview;
    Intent intent;
    static ArrayList <String> places = new ArrayList<String>();
    static ArrayList <LatLng> locations = new ArrayList<LatLng>();
    static ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listview = (ListView) findViewById(R.id.listview);

        places.add("Add a new place");
        locations.add(new LatLng(0,0));

        adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,places);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                intent = new Intent(getApplicationContext(),MapsActivity.class);
                intent.putExtra("pos",position);
            startActivity(intent);
            }
        });


    }
}