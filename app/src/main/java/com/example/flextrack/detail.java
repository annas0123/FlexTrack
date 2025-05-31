package com.example.flextrack;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class detail extends AppCompatActivity {

    TextView headingTextView , descriptionTextView ;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // Get the data passed from MainActivity
        String heading = getIntent().getStringExtra("HEADING");
        String description = getIntent().getStringExtra("DESCRIPTION");

        // Set the heading and description to TextViews
        headingTextView = findViewById(R.id.headingTextView);
        descriptionTextView = findViewById(R.id.descriptionTextView);

        headingTextView.setText(heading);
        descriptionTextView.setText(description);
    }

    public void onclickfooddetails(View view) {
        Intent intent = new Intent(detail.this, tips.class);
        startActivity(intent);
        finish();
    }
    @SuppressLint("MissingSuperCall")
    @Override
    public void onBackPressed() {

        // Do nothing to disable back press
    }
}
