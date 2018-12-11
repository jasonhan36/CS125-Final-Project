package com.example.jason.cs125finalproject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "Me and Raymond need help";
    private static final String TAG = "MainActivity";

    private Context mContext;
    private Activity mActivity;
    private TextView mTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = getApplicationContext();

        final Button addButton = findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
//                Log.i("MyApp", "This is a messsage log");
//                Toast.makeText(getApplicationContext(), "You have added an ingredient!", Toast.LENGTH_SHORT)
//                        .show();

//                TextView myText = findViewById(R.id.textView3);
                mTextView = findViewById(R.id.textView3);


                //Instantiate new Request Queue
                RequestQueue requestQueue = Volley.newRequestQueue(mContext);

                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                        Request.Method.GET,
                        //the end point
                        "https://pokeapi.co/api/v2/pokemon/ditto/",
                        null
                        ,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(final JSONObject response) {
                                Log.d(TAG, response.toString());
                                Log.d(TAG, "POO");
                                // Process the JSON
                                try{
                                    // Get the JSON array
                                    JSONArray array = response.getJSONArray("abilities");

                                    // Loop through the array elements
                                    for(int i=0;i<array.length();i++){
                                        // Get current json object
                                        JSONObject student = array.getJSONObject(i);


                                        // Get the current student (json object) data
                                        JSONObject ability = student.getJSONObject("ability");
                                        String name = ability.getString("name");
                                        String url = ability.getString("url");

                                        // Display the formatted json data in text view
                                        mTextView.append("\n\n");
                                        mTextView.append(name);
                                        mTextView.append("\n\n");
                                    }
                                }catch (JSONException e){
                                    e.printStackTrace();
                                }
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
//                        params.put("x-id-key", "623a35a9");
//                        params.put("x-app-key", "59447ffa6f5b0a827dfa2ecca0fc3afc");
//                        params.put("x-remote-user-id", "0");
                        Log.d(TAG, params.toString());
                        return params;
                    }
                };
//                mTextView.setText(jsonObjectRequest.toString());

                // Add JsonObjectRequest to the RequestQueue
                requestQueue.add(jsonObjectRequest);
            }
        });
        final Button episodeDataButton = findViewById(R.id.removeButton);
        episodeDataButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // Code here executes on main thread after user presses button
                //Log.i("MyApp", "This is a messsage log");
                //Toast.makeText(getApplicationContext(), "Retrieving Episode Data!", Toast.LENGTH_SHORT)
                //        .show();
                Intent intent = new Intent(MainActivity.this, SecondScreen.class);
                startActivity(intent);
            }
        });

        final Button saveButton = findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                Log.i("MyApp", "This is a messsage log");
                Toast.makeText(getApplicationContext(), "Get Top Podcasts Test", Toast.LENGTH_SHORT)
                        .show();
                //TextView myText = findViewById(R.id.textView3);
                //myText.setText("Raymond's Message");
            }
        });
        final Button zzzButton = findViewById(R.id.saveButton);
        zzzButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                Log.i("MyApp", "This is a messsage log");
                Toast.makeText(getApplicationContext(), "Search Podcasts Test", Toast.LENGTH_SHORT)
                        .show();
                //TextView myText = findViewById(R.id.textView3);
                //myText.setText("Raymond's Message");
            }
        });


//    }
    }
}