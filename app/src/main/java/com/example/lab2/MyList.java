package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MyList extends AppCompatActivity {
    int index;
    SharedPreferences sharedPref;
    ArrayList<String> myStringArray = new ArrayList<String>();;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ArrayAdapter<String> TextAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1, myStringArray);
        ListView textList = findViewById(R.id.textList);
        textList.setAdapter(TextAdapter);
        TextAdapter.notifyDataSetChanged();

        Button button_add = findViewById(R.id.button_add);
        Button button_delete = findViewById(R.id.button_delete);
        EditText editText = findViewById(R.id.editText);
        textList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                index = i;
            }
        });
        button_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            myStringArray.add(editText.getText().toString());
            editText.setText("");
            TextAdapter.notifyDataSetChanged();
            }
        });

        button_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            myStringArray.remove(index);
            index = 0;
            TextAdapter.notifyDataSetChanged();
            }

        });

        sharedPref = this.getPreferences(Context.MODE_PRIVATE);

        for (int i = 0; i < sharedPref.getInt("size", 0);i++)
        {
            Log.i("Fact_size_OnCreate", String.valueOf(sharedPref.getInt("size", 0)));
            myStringArray.add(sharedPref.getString("text" + i, ""+ i));
            Log.i("Size",String.valueOf(sharedPref.getInt("size", 0)));
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();

        for (int i=0; i<myStringArray.size();i++ )
        {
            editor.putString("text"+i, myStringArray.get(i).toString());
            Log.i("Save",myStringArray.get(i).toString());
            editor.apply();

        }
            editor.putInt("size", myStringArray.size());
            editor.apply();

        Log.i("Size",String.valueOf(myStringArray.size()));
        Log.i("Fact_size", String.valueOf(sharedPref.getInt("size", 0)));
    }
}