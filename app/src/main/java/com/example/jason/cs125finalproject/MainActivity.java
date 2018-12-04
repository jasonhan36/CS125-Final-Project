package com.example.jason.cs125finalproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "Me and Raymond need help";
    private static final String TAG = "MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button addButton = findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
//                Log.i("MyApp", "This is a messsage log");
//                Toast.makeText(getApplicationContext(), "You have added an ingredient!", Toast.LENGTH_SHORT)
//                        .show();
                TextView myText = findViewById(R.id.textView3);

                JSONObject jsonBody = new JSONObject();
                try {
                    jsonBody.put("query", "kashi");
                } catch(JSONException e) {
                    Log.e("MYAPP", "unexpected JSON exception", e);
                }



                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                        Request.Method.POST,
                        //the end point
                        "https://api.nutritionix.com/v1_1/search",
                        jsonBody
                        ,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(final JSONObject response) {
                                Log.d(TAG, response.toString());
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(final VolleyError error) {
                        Log.w(TAG, error.toString());
                    }
                }) {
                    @Override
                    public Map<String, String> getHeaders() {
                        Map<String, String>  params = new HashMap<String, String>();
                        // any app keys and fields that need to be filled
                        params.put("x-id-key", "623a35a9");
                        params.put("x-app-key", "59447ffa6f5b0a827dfa2ecca0fc3afc");
                        params.put("x-remote-user-id", "0");
                        Log.d(TAG, params.toString());
                        return params;
                    }
                };
                myText.setText(jsonObjectRequest.toString());
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
}