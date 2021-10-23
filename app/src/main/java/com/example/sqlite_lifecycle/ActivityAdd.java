package com.example.sqlite_lifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

public class ActivityAdd extends AppCompatActivity {

    private static final String TAG = "Add_Activity";

    EditText name_input, address_input, age_input;
    Button add_button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        Log.i(TAG, "OnCreate");

        name_input = findViewById(R.id.name_input);
        address_input = findViewById(R.id.address_input);
        age_input = findViewById(R.id.age_input);
        add_button = findViewById(R.id.add_button);
        add_button.setOnClickListener(view -> {
            MyDatabaseHelper myDB = new MyDatabaseHelper(ActivityAdd.this);
            myDB.addfriends(name_input.getText().toString().trim(),
                            address_input.getText().toString().trim(),
                            Integer.parseInt(age_input.getText().toString().trim()));
        finish();

        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart");
    }
}