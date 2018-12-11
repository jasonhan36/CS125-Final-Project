package com.example.jason.cs125finalproject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.app.SearchManager;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.SearchView.OnQueryTextListener;
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

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;


public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "Me and Raymond need help";
    private static final String TAG = "MainActivity";

    private Context mContext;
    private Activity mActivity;
    private TextView mTextView;
    private ImageView mImageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = getApplicationContext();
        final Button addButton = findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                SearchView simpleSearchView = (SearchView) findViewById(R.id.searchBar); // inititate a search view
                CharSequence query = simpleSearchView.getQuery(); // get the query string currently in the text field
                // Code here executes on main thread after user presses button
//                Log.i("MyApp", "This is a messsage log");
//                Toast.makeText(getApplicationContext(), "You have added an ingredient!", Toast.LENGTH_SHORT)
//                        .show();

//                TextView myText = findViewById(R.id.textView3);
                mTextView = findViewById(R.id.textView3);
                mImageView = findViewById(R.id.imageView);


                //Instantiate new Request Queue
                RequestQueue requestQueue = Volley.newRequestQueue(mContext);

                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                        Request.Method.GET,
                        //the end point
                        "https://pokeapi.co/api/v2/pokemon/"+ query + "/",
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
                                        mTextView.setText(name);
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
        final Button episodeDataButton = findViewById(R.id.removeButton);
        episodeDataButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // Code here executes on main thread after user presses button
                //Log.i("MyApp", "This is a messsage log");
                //Toast.makeText(getApplicationContext(), "Retrieving Episode Data!", Toast.LENGTH_SHORT)
                //        .show();
                Intent intent = new Intent(MainActivity.this, SecondScreen.class);
                startActivity(intent);
                mImageView = findViewById(R.id.imageView);


                //Instantiate new Request Queue
                RequestQueue requestQueue = Volley.newRequestQueue(mContext);
                SearchView simpleSearchView = (SearchView) findViewById(R.id.searchBar); // inititate a search view
                CharSequence query = simpleSearchView.getQuery(); // get the query string currently in the text field
                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                        Request.Method.GET,
                        //the end point
                        "https://pokeapi.co/api/v2/pokemon/"+ query + "/",
                        null
                        ,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(final JSONObject response) {
                                Log.d(TAG, response.toString());
                                Log.d(TAG, "POO");
                                // Process the JSON


                try {
                    JSONObject sprites = response.getJSONObject("sprites");
                    String pic = sprites.getString("front_default");
                    URL url2 = new URL(pic);
                    Bitmap bmp = BitmapFactory.decodeStream(url2.openConnection().getInputStream());
                    mImageView.setImageBitmap(bmp);
                } catch (IOException error, JSON) {
                    error.printStackTrace();
                }
            }
        });


//    }
    }
}