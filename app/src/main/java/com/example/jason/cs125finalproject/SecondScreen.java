package com.example.jason.cs125finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.view.View;
import android.widget.ImageView;

public class SecondScreen extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_screen_layout);

        Button goBackButton = (Button) findViewById(R.id.goBack);

        goBackButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view){

                Intent intent = new Intent(SecondScreen.this, MainActivity.class);
                startActivity(intent);
            }
        });

        ImageView firstImage = (ImageView) findViewById(R.id.firstImage);

        int imageResource = getResources().getIdentifier("@drawable/pokemon", null, this.getPackageName());
        firstImage.setImageResource(imageResource);
    }
}
