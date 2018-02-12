package com.example.simplelistview;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String[] listLaptop = {
            "ASUS",
            "ACER",
            "TOSHIBA",
            "LENOVO",
            "MSI",
            "XENOM",
            "DELL",
            "HP",
            "SONY",
            "FUJITSU",
            "SAMSUNG",
            "APPLE"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("List Merk Laptop");

        ListView listData = findViewById(R.id.lv);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listLaptop);

        listData.setAdapter(adapter);

        listData.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                Toast.makeText(MainActivity.this, "Anda memilih laptop merek " + listLaptop[position], Toast.LENGTH_SHORT).show();
                AlertDialog.Builder popup = new AlertDialog.Builder(MainActivity.this);
                popup
                        .setMessage("Anda memilih Laptop " + listLaptop[position])
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent pindah = new Intent(MainActivity.this, DetailActivity.class);
                                pindah.putExtra("nama", listLaptop[position]);
                                startActivity(pindah);
                            }
                        }).show();
            }
        });

    }
}
