package com.example.flextrack;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class tips extends AppCompatActivity {
        private Button includedButton , timeButton , completeButton  , deleteButton , limitedButton;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips);

        // Set up buttons
        includedButton = findViewById(R.id.included);
         timeButton = findViewById(R.id.time);
         completeButton = findViewById(R.id.complete);
         deleteButton = findViewById(R.id.delete);
         limitedButton = findViewById(R.id.limited);

        // Set onClickListeners for each button
        includedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                passData("Exercises Included in This App", "Jumping Jacks\n" +
                        "Squats\n" +
                        "Push-ups\n" +
                        "Plank\n" +
                        "Lunges\n" +
                        "Crunches\n" +
                        "High Knees\n" +
                        "Glute Bridges\n" +
                        "Mountain Climbers\n" +
                        "Leg Raises\n" +
                        "Tricep Dips\n" +
                        "Russian Twists\n" +
                        "Side Lunges\n" +
                        "Bicycle Crunches\n" +
                        "Supermans\n" +
                        "Wall Sit\n" +
                        "Toe Touches\n" +
                        "Side Plank");
            }
        });

        timeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                passData("Take Your Time", " If you find a particular exercise challenging, feel free to pause the timer to give yourself a little more time to complete it. It's important to go at your own pace.");
            }
        });

        completeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                passData("Complete Your Daily Exercises", "The app is designed to track your daily progress. However, if you don't complete all the exercises for a given day, your progress won't be saved. To achieve the best results, make sure to complete all the exercises for each day.");
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                passData("Manage Your Progress", " If you wish to start fresh or remove past progress, you have the option to delete all your previous days’ data. This can be helpful if you want to reset your workout routine.");
            }
        });

        limitedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                passData("Limited Resources", "Due to limited resources, the app provides static images for each exercise. For a better understanding and demonstration, consider searching for the exercise names on YouTube. There, you can find videos that will show you the proper form and technique.");
            }
        });
    }

    // Method to pass data to SecondActivity
    private void passData(String heading, String description) {
        Intent intent = new Intent(tips.this, detail.class);
        intent.putExtra("HEADING", heading);
        intent.putExtra("DESCRIPTION", description);
        startActivity(intent);
    }


    public void onclickfooddetails(View view) {
        Intent intent = new Intent(tips.this, PlanCategories.class);
        startActivity(intent);
        finish();
    }
    @SuppressLint("MissingSuperCall")
    @Override
    public void onBackPressed() {

        // Do nothing to disable back press
    }
}
