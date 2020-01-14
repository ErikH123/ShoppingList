package com.example.shoppinglist;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> shoppingList = new ArrayList<>();
    String item;
    private EditText editText;
    private Button doneButton;
    private Button saveButton;
    private Button backButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        editText = findViewById(R.id.editText);
        doneButton = findViewById(R.id.doneButton);
        saveButton = findViewById(R.id.saveButton);
        backButton = findViewById(R.id.backButton);


    }

    public void lisaaItem(View view){
        item = editText.getText().toString();
        if (item.length() > 2 && item.length() < 16) {
            if (shoppingList.add(item)) {
                Toast.makeText(getApplicationContext(), "Onnistuneesti lisätty: " + item, Toast.LENGTH_SHORT).show();
                editText.setText("");
            }
        }
        else{
            Toast.makeText(getApplicationContext(), "Virhe: Tekstin tulee olla vähintään 3 ja enintään 15 merkkiä pitkä", Toast.LENGTH_LONG).show();
        }
    }

    public void avaaActivity(View view){
        Intent intent = new Intent(this, ShowList.class);
        intent.putStringArrayListExtra("shoppingList", shoppingList);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
