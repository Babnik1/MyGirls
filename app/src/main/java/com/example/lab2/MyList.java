package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MyList extends AppCompatActivity {
    int index;
    ArrayList<String> myStringArray = new ArrayList<String>();
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


        if (savedInstanceState != null )
        {
            myStringArray = savedInstanceState.getStringArrayList("myKey");
        }

        textList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                index = i;
            }

        });
        button_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText = findViewById(R.id.editText);

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

    }


}