package com.example.sqlite_lifecycle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {

    private static final String TAG = "Update_Activity";

    EditText name_input, address_input, age_input;
    Button update_button, delete_button;

    String id, name, address, age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        Log.i(TAG, "OnCreate");

        name_input = findViewById(R.id.name_input2);
        address_input = findViewById(R.id.address_input2);
        age_input = findViewById(R.id.age_input2);
        update_button = findViewById(R.id.update_button);
        delete_button = findViewById(R.id.delete_button);


        update_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MyDatabaseHelper myDB = new MyDatabaseHelper(UpdateActivity.this);
                name = name_input.getText().toString().trim();
                address = address_input.getText().toString().trim();
                age = age_input.getText().toString().trim();
                myDB.updateData(id, name, address, age);

                /*Intent intent = new Intent(UpdateActivity.this, MainActivity.class);
                startActivity(intent);*/
                finish();

            }
        }

        );

        delete_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                confirmDialog();

            }
        });

        getAndSetIntentData();

        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setTitle(name +"'s File");
        }
    }

    void getAndSetIntentData(){
        if(getIntent().hasExtra("id") && getIntent().hasExtra("name") &&
                getIntent().hasExtra("address") && getIntent().hasExtra("age")){
            //Getting Data from Intent
            id = getIntent().getStringExtra("id");
            name = getIntent().getStringExtra("name");
            address = getIntent().getStringExtra("address");
            age = getIntent().getStringExtra("age");

            //Setting Intent Data
            name_input.setText(name);
            address_input.setText(address);
            age_input.setText(age);
        }else{
            Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show();
        }
    }

    void confirmDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete " + name + "?");
        builder.setMessage("Are you sure you want to delete " + name + "?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(UpdateActivity.this);
                myDB.deleteOneRow(id);
                finish();

               // Intent intent = new Intent(UpdateActivity.this, MainActivity.class);
                // startActivity(intent);

            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.create().show();
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