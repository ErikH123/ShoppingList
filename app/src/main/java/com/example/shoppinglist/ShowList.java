package com.example.shoppinglist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class ShowList extends AppCompatActivity {

    ArrayList<String> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_list);

        Intent intent = getIntent();
        data = intent.getStringArrayListExtra("shoppingList");

        TextView textView = findViewById(R.id.textView);
        //textView.setText(data.get(0));
        for (String s : data){
            textView.append(s);
            textView.append("\n");
        }
    }

    public void finishActivity(View view){
        finish();
    }
}
