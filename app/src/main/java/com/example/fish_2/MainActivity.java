package com.example.fish_2;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
private DrawerLayout drawer;
private ListView list;
private String[] array;
private ArrayAdapter<String> adapter;
private Toolbar toolbar;
private int category_index;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = findViewById(R.id.listView);
        array = getResources().getStringArray(R.array.fish_array);
        adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,
                new ArrayList<String>(Arrays.asList(array)));
        list.setAdapter(adapter);
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.fish);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        );
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
Intent intent = new Intent(MainActivity.this, Text_Content_Activity.class);
intent.putExtra("category",category_index);
intent.putExtra("position",i);
startActivity(intent);
            }
        });
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.id_fish){
            fillArray(R.string.fish, R.array.fish_array, 0);
        }
        else if(id == R.id.id_na){
            fillArray(R.string.na, R.array.na_array, 1);
        }
        else if(id == R.id.id_sna){
            fillArray(R.string.sna, R.array.sna_array, 2);
        }
        else if(id == R.id.id_pri){
//            Toast.makeText(this, "Nav pressed", Toast.LENGTH_SHORT).show();
//            array = getResources().getStringArray(R.array.pri_array);
//            adapter.clear();
//            adapter.addAll(array);
//            adapter.notifyDataSetChanged();
//            toolbar.setTitle(R.string.pri);
            setContentView(R.layout.for_pri);
            category_index = 3;
        }
        else if(id == R.id.id_history){
            fillArray(R.string.history, R.array.ri_array, 4);
        }
        else if(id == R.id.id_advice){
            fillArray(R.string.advice, R.array.ps_array, 5);
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    private void fillArray(int rsi, int rai, int index){
        Toast.makeText(this, "Nav pressed", Toast.LENGTH_SHORT).show();
        array = getResources().getStringArray(rai);
        adapter.clear();
        adapter.addAll(array);
        adapter.notifyDataSetChanged();
        toolbar.setTitle(rsi);
        category_index = index;
    }
}