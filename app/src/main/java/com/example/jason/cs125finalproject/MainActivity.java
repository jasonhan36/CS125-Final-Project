package com.example.jason.cs125finalproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "Me and Raymond need help";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button addButton = findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                Log.i("MyApp", "This is a messsage log");
                Toast.makeText(getApplicationContext(), "You have added an ingredient!", Toast.LENGTH_SHORT)
                        .show();
                //TextView myText = findViewById(R.id.textView3);
                //myText.setText("Raymond's Message");
            }
        });
        final Button removeButton = findViewById(R.id.removeButton);
        removeButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                Log.i("MyApp", "This is a messsage log");
                Toast.makeText(getApplicationContext(), "You have removed an ingredient!", Toast.LENGTH_SHORT)
                        .show();
                //TextView myText = findViewById(R.id.textView3);
                //myText.setText("Raymond's Message");
            }
        });
        final Button saveButton = findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                Log.i("MyApp", "This is a messsage log");
                Toast.makeText(getApplicationContext(), "You have saved!", Toast.LENGTH_SHORT)
                        .show();
                //TextView myText = findViewById(R.id.textView3);
                //myText.setText("Raymond's Message");
            }
        });

//    }
    }

    ;
}
