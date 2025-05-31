package com.example.flextrack;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


//---------------------------------------------------
import android.app.AlertDialog;
import android.content.DialogInterface;
//---------------------------------------------------


public class challenge365 extends AppCompatActivity {

    private RecyclerView recyclerView;
    private challenge365adapter daysAdapter;
    private List<Day> daysList;
    private Button resetButton;
    private static final int REQUEST_CODE_DAY_DETAIL = 4;
    private SharedPreferences sharedPreferences;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge365);

        recyclerView = findViewById(R.id.recycler_view);
        resetButton = findViewById(R.id.clearalldata);

        daysList = new ArrayList<>();
        sharedPreferences = getSharedPreferences("ChallengeCompletionStatus", MODE_PRIVATE);

        for (int i = 1; i <= 365; i++) {
            String dayNumber = "Day " + i;
            boolean isDayCompleted = sharedPreferences.getBoolean(dayNumber, false);
            Day day = new Day(dayNumber, "Exercise plan for " + dayNumber, 12);
            day.setAvailable(i == 1 || sharedPreferences.getBoolean("Day " + (i - 1), false)); // Set availability
            daysList.add(day);
        }

        daysAdapter = new challenge365adapter(daysList, new challenge365adapter.OnItemClickListener() {
            @Override
            public void onItemClick(Day day) {
                String dayNumber = day.getDayNumber();
                boolean isDayCompleted = sharedPreferences.getBoolean(dayNumber, false);

                if (isDayCompleted) {
                    Toast.makeText(challenge365.this, dayNumber + " is already completed!", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(challenge365.this, challengedetailactivity.class);
                    intent.putExtra("DAY_NUMBER_365", day.getDayNumber());
                    intent.putExtra("EXERCISES_365", getExercisesForDay(day.getDayNumber()));
                    intent.putExtra("TIMER_365", day.getMinutes()); // Pass the minutes to the detail activity
                    startActivityForResult(intent, REQUEST_CODE_DAY_DETAIL);
                }
            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(daysAdapter);

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showResetConfirmationDialog();
            }
        });

    }
    private void showResetConfirmationDialog() {
        new AlertDialog.Builder(this)
                .setTitle("Delete All Days")
                .setMessage("Do you want to delete all days?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        resetProgress();
                    }
                })
                .setNegativeButton("No", null)
                .show();
    }



    private String getExercisesForDay(String dayNumber) {
        int day = Integer.parseInt(dayNumber.replace("Day ", ""));

        // Day 1: Upper Body & Core Focus
        String day1 =
                "Push-ups\n" +
                        "Tricep Dips\n" +
                        "Plank\n" +
                        "Crunches\n" +
                        "Bicycle Crunches\n" +
                        "Supermans\n" +
                        "Russian Twists\n" +
                        "Side Plank\n" +
                        "Push-ups\n" +
                        "Plank";

// Day 2: Lower Body & Full Body Focus
        String day2 =
                "Squats\n" +
                        "Lunges\n" +
                        "Glute Bridges\n" +
                        "Side Lunges\n" +
                        "Wall Sit\n" +
                        "Leg Raises\n" +
                        "Jumping Jacks\n" +
                        "High Knees\n" +
                        "Mountain Climbers\n" +
                        "Toe Touches";

// Day 3: Upper Body & Core Focus (repeat Day 1)
        String day3 =
                "Push-ups\n" +
                        "Tricep Dips\n" +
                        "Plank\n" +
                        "Crunches\n" +
                        "Bicycle Crunches\n" +
                        "Supermans\n" +
                        "Russian Twists\n" +
                        "Side Plank\n" +
                        "Push-ups\n" +
                        "Plank";

// Day 4: Lower Body & Full Body Focus (repeat Day 2)
        String day4 =
                "Squats\n" +
                        "Lunges\n" +
                        "Glute Bridges\n" +
                        "Side Lunges\n" +
                        "Wall Sit\n" +
                        "Leg Raises\n" +
                        "Jumping Jacks\n" +
                        "High Knees\n" +
                        "Mountain Climbers\n" +
                        "Toe Touches";

// Day 5: Upper Body & Core Focus (repeat Day 1)
        String day5 =
                "Push-ups\n" +
                        "Tricep Dips\n" +
                        "Plank\n" +
                        "Crunches\n" +
                        "Bicycle Crunches\n" +
                        "Supermans\n" +
                        "Russian Twists\n" +
                        "Side Plank\n" +
                        "Push-ups\n" +
                        "Plank";

// Day 6: Lower Body & Full Body Focus (repeat Day 2)
        String day6 =
                "Squats\n" +
                        "Lunges\n" +
                        "Glute Bridges\n" +
                        "Side Lunges\n" +
                        "Wall Sit\n" +
                        "Leg Raises\n" +
                        "Jumping Jacks\n" +
                        "High Knees\n" +
                        "Mountain Climbers\n" +
                        "Toe Touches";

// Day 7: Upper Body & Core Focus (repeat Day 1)
        String day7 =
                "Push-ups\n" +
                        "Tricep Dips\n" +
                        "Plank\n" +
                        "Crunches\n" +
                        "Bicycle Crunches\n" +
                        "Supermans\n" +
                        "Russian Twists\n" +
                        "Side Plank\n" +
                        "Push-ups\n" +
                        "Plank";

// Day 8: Lower Body & Full Body Focus (repeat Day 2)
        String day8 =
                "Squats\n" +
                        "Lunges\n" +
                        "Glute Bridges\n" +
                        "Side Lunges\n" +
                        "Wall Sit\n" +
                        "Leg Raises\n" +
                        "Jumping Jacks\n" +
                        "High Knees\n" +
                        "Mountain Climbers\n" +
                        "Toe Touches";

// Day 9: Upper Body & Core Focus (repeat Day 1)
        String day9 =
                "Push-ups\n" +
                        "Tricep Dips\n" +
                        "Plank\n" +
                        "Crunches\n" +
                        "Bicycle Crunches\n" +
                        "Supermans\n" +
                        "Russian Twists\n" +
                        "Side Plank\n" +
                        "Push-ups\n" +
                        "Plank";

// Day 10: Lower Body & Full Body Focus (repeat Day 2)
        String day10 =
                "Squats\n" +
                        "Lunges\n" +
                        "Glute Bridges\n" +
                        "Side Lunges\n" +
                        "Wall Sit\n" +
                        "Leg Raises\n" +
                        "Jumping Jacks\n" +
                        "High Knees\n" +
                        "Mountain Climbers\n" +
                        "Toe Touches";}

//// Day 3: Upper Body & Core Focus (repeat Day 1)
//        String day3 =
//                "Push-ups\n" +
//                        "Tricep Dips\n" +
//                        "Plank\n" +
//                        "Crunches\n" +
//                        "Bicycle Crunches\n" +
//                        "Supermans\n" +
//                        "Russian Twists\n" +
//                        "Side Plank\n" +
//                        "Push-ups\n" +
//                        "Plank";
//
//// Day 4: Lower Body & Full Body Focus (repeat Day 2)
//        String day4 =
//                "Squats\n" +
//                        "Lunges\n" +
//                        "Glute Bridges\n" +
//                        "Side Lunges\n" +
//                        "Wall Sit\n" +
//                        "Leg Raises\n" +
//                        "Jumping Jacks\n" +
//                        "High Knees\n" +
//                        "Mountain Climbers\n" +
//                        "Toe Touches";
//
//// Day 5: Upper Body & Core Focus (repeat Day 1)
//        String day5 =
//                "Push-ups\n" +
//                        "Tricep Dips\n" +
//                        "Plank\n" +
//                        "Crunches\n" +
//                        "Bicycle Crunches\n" +
//                        "Supermans\n" +
//                        "Russian Twists\n" +
//                        "Side Plank\n" +
//                        "Push-ups\n" +
//                        "Plank";
//
//// Day 6: Lower Body & Full Body Focus (repeat Day 2)
//        String day6 =
//                "Squats\n" +
//                        "Lunges\n" +
//                        "Glute Bridges\n" +
//                        "Side Lunges\n" +
//                        "Wall Sit\n" +
//                        "Leg Raises\n" +
//                        "Jumping Jacks\n" +
//                        "High Knees\n" +
//                        "Mountain Climbers\n" +
//                        "Toe Touches";
//
//// Day 7: Upper Body & Core Focus (repeat Day 1)
//        String day7 =
//                "Push-ups\n" +
//                        "Tricep Dips\n" +
//                        "Plank\n" +
//                        "Crunches\n" +
//                        "Bicycle Crunches\n" +
//                        "Supermans\n" +
//                        "Russian Twists\n" +
//                        "Side Plank\n" +
//                        "Push-ups\n" +
//                        "Plank";
//
//// Day 8: Lower Body & Full Body Focus (repeat Day 2)
//        String day8 =
//                "Squats\n" +
//                        "Lunges\n" +
//                        "Glute Bridges\n" +
//                        "Side Lunges\n" +
//                        "Wall Sit\n" +
//                        "Leg Raises\n" +
//                        "Jumping Jacks\n" +
//                        "High Knees\n" +
//                        "Mountain Climbers\n" +
//                        "Toe Touches";
//
//// Day 9: Upper Body & Core Focus (repeat Day 1)
//        String day9 =
//                "Push-ups\n" +
//                        "Tricep Dips\n" +
//                        "Plank\n" +
//                        "Crunches\n" +
//                        "Bicycle Crunches\n" +
//                        "Supermans\n" +
//                        "Russian Twists\n" +
//                        "Side Plank\n" +
//                        "Push-ups\n" +
//                        "Plank";
//
//// Day 10: Lower Body & Full Body Focus (repeat Day 2)
//        String day10 =
//                "Squats\n" +
//                        "Lunges\n" +
//                        "Glute Bridges\n" +
//                        "Side Lunges\n" +
//                        "Wall Sit\n" +
//                        "Leg Raises\n" +
//                        "Jumping Jacks\n" +
//                        "High Knees\n" +
//                        "Mountain Climbers\n" +
//                        "Toe Touches";


        String day11 =
                "Push-ups\n" +
                        "Tricep Dips\n" +
                        "Plank\n" +
                        "Crunches\n" +
                        "Bicycle Crunches\n" +
                        "Supermans\n" +
                        "Russian Twists\n" +
                        "Side Plank\n" +
                        "Push-ups\n" +
                        "Plank\n" +
                        "Tricep Dips";

        String day12 =
                "Squats\n" +
                        "Lunges\n" +
                        "Glute Bridges\n" +
                        "Side Lunges\n" +
                        "Wall Sit\n" +
                        "Leg Raises\n" +
                        "Jumping Jacks\n" +
                        "High Knees\n" +
                        "Mountain Climbers\n" +
                        "Toe Touches\n" +
                        "Squats";


//        String day11to20 =
//                "Squats\n" +
//                        "Lunges\n" +
//                        "Glute Bridges\n" +
//                        "Side Lunges\n" +
//                        "Wall Sit\n" +
//                        "Leg Raises\n" +
//                        "Jumping Jacks\n" +
//                        "High Knees\n" +
//                        "Mountain Climbers\n" +
//                        "Toe Touches\n" +
//                        "Squats";


//        String day21to30 =
//                "Push-ups\n" +
//                        "Tricep Dips\n" +
//                        "Plank\n" +
//                        "Crunches\n" +
//                        "Bicycle Crunches\n" +
//                        "Supermans\n" +
//                        "Russian Twists\n" +
//                        "Side Plank\n" +
//                        "Push-ups\n" +
//                        "Plank\n" +
//                        "Tricep Dips\n" +
//                        "Crunches";
        String day21 =
                "Push-ups\n" +
                        "Tricep Dips\n" +
                        "Plank\n" +
                        "Crunches\n" +
                        "Bicycle Crunches\n" +
                        "Supermans\n" +
                        "Russian Twists\n" +
                        "Side Plank\n" +
                        "Push-ups\n" +
                        "Tricep Dips\n" +
                        "Plank\n" +
                        "Crunches";
        String day22 =
                "Squats\n" +
                        "Lunges\n" +
                        "Glute Bridges\n" +
                        "Side Lunges\n" +
                        "Wall Sit\n" +
                        "Leg Raises\n" +
                        "Jumping Jacks\n" +
                        "High Knees\n" +
                        "Mountain Climbers\n" +
                        "Toe Touches\n" +
                        "Squats\n" +
                        "Lunges";


//        String day31to40 =
//                "Squats\n" +
//                        "Lunges\n" +
//                        "Glute Bridges\n" +
//                        "Side Lunges\n" +
//                        "Wall Sit\n" +
//                        "Leg Raises\n" +
//                        "Jumping Jacks\n" +
//                        "High Knees\n" +
//                        "Mountain Climbers\n" +
//                        "Toe Touches\n" +
//                        "Squats\n" +
//                        "Lunges\n" +
//                        "Wall Sit";
        String day31 =
                "Push-ups\n" +
                        "Tricep Dips\n" +
                        "Plank\n" +
                        "Crunches\n" +
                        "Bicycle Crunches\n" +
                        "Supermans\n" +
                        "Russian Twists\n" +
                        "Side Plank\n" +
                        "Push-ups\n" +
                        "Plank\n" +
                        "Crunches\n" +
                        "Russian Twists\n" +
                        "Supermans";

        String day32 =
                "Squats\n" +
                        "Lunges\n" +
                        "Glute Bridges\n" +
                        "Side Lunges\n" +
                        "Wall Sit\n" +
                        "Leg Raises\n" +
                        "Jumping Jacks\n" +
                        "High Knees\n" +
                        "Mountain Climbers\n" +
                        "Toe Touches\n" +
                        "Squats\n" +
                        "Lunges\n" +
                        "Glute Bridges";


//        String day41to50 =
//                "Push-ups\n" +
//                        "Tricep Dips\n" +
//                        "Plank\n" +
//                        "Crunches\n" +
//                        "Bicycle Crunches\n" +
//                        "Supermans\n" +
//                        "Russian Twists\n" +
//                        "Side Plank\n" +
//                        "Push-ups\n" +
//                        "Plank\n" +
//                        "Tricep Dips\n" +
//                        "Crunches\n" +
//                        "Bicycle Crunches\n" +
//                        "Supermans";
        String day41 =
                "Push-ups\n" +
                        "Tricep Dips\n" +
                        "Plank\n" +
                        "Crunches\n" +
                        "Bicycle Crunches\n" +
                        "Supermans\n" +
                        "Russian Twists\n" +
                        "Side Plank\n" +
                        "Push-ups\n" +
                        "Tricep Dips\n" +
                        "Plank\n" +
                        "Crunches\n" +
                        "Bicycle Crunches\n" +
                        "Supermans";

        String day42 =
                "Squats\n" +
                        "Lunges\n" +
                        "Glute Bridges\n" +
                        "Side Lunges\n" +
                        "Wall Sit\n" +
                        "Leg Raises\n" +
                        "Jumping Jacks\n" +
                        "High Knees\n" +
                        "Mountain Climbers\n" +
                        "Toe Touches\n" +
                        "Squats\n" +
                        "Lunges\n" +
                        "Glute Bridges\n" +
                        "Side Lunges";


//        String day51to60 =
//                "Squats\n" +
//                        "Lunges\n" +
//                        "Glute Bridges\n" +
//                        "Side Lunges\n" +
//                        "Wall Sit\n" +
//                        "Leg Raises\n" +
//                        "Jumping Jacks\n" +
//                        "High Knees\n" +
//                        "Mountain Climbers\n" +
//                        "Toe Touches\n" +
//                        "Squats\n" +
//                        "Lunges\n" +
//                        "Glute Bridges\n" +
//                        "Side Lunges\n" +
//                        "Jumping Jacks";
        String day51 =
                "Push-ups\n" +
                        "Tricep Dips\n" +
                        "Plank\n" +
                        "Crunches\n" +
                        "Bicycle Crunches\n" +
                        "Supermans\n" +
                        "Russian Twists\n" +
                        "Side Plank\n" +
                        "Push-ups\n" +
                        "Tricep Dips\n" +
                        "Plank\n" +
                        "Crunches\n" +
                        "Bicycle Crunches\n" +
                        "Supermans\n" +
                        "Russian Twists";
        String day52 =
                "Squats\n" +
                        "Lunges\n" +
                        "Glute Bridges\n" +
                        "Side Lunges\n" +
                        "Wall Sit\n" +
                        "Leg Raises\n" +
                        "Jumping Jacks\n" +
                        "High Knees\n" +
                        "Mountain Climbers\n" +
                        "Toe Touches\n" +
                        "Squats\n" +
                        "Lunges\n" +
                        "Glute Bridges\n" +
                        "Side Lunges\n" +
                        "Wall Sit";



//        String day61to67 =
//                "Push-ups\n" +
//                        "Tricep Dips\n" +
//                        "Plank\n" +
//                        "Crunches\n" +
//                        "Bicycle Crunches\n" +
//                        "Supermans\n" +
//                        "Russian Twists\n" +
//                        "Side Plank\n" +
//                        "Push-ups\n" +
//                        "Plank\n" +
//                        "Tricep Dips\n" +
//                        "Crunches\n" +
//                        "Bicycle Crunches\n" +
//                        "Supermans\n" +
//                        "Russian Twists\n" +
//                        "Side Plank";
        String day61 =
                "Push-ups\n" +
                        "Tricep Dips\n" +
                        "Plank\n" +
                        "Crunches\n" +
                        "Bicycle Crunches\n" +
                        "Supermans\n" +
                        "Russian Twists\n" +
                        "Side Plank\n" +
                        "Push-ups\n" +
                        "Tricep Dips\n" +
                        "Plank\n" +
                        "Crunches\n" +
                        "Bicycle Crunches\n" +
                        "Supermans\n" +
                        "Russian Twists\n" +
                        "Side Plank";
        String day62 =
                "Squats\n" +
                        "Lunges\n" +
                        "Glute Bridges\n" +
                        "Side Lunges\n" +
                        "Wall Sit\n" +
                        "Leg Raises\n" +
                        "Jumping Jacks\n" +
                        "High Knees\n" +
                        "Mountain Climbers\n" +
                        "Toe Touches\n" +
                        "Squats\n" +
                        "Lunges\n" +
                        "Glute Bridges\n" +
                        "Side Lunges\n" +
                        "Wall Sit\n" +
                        "Leg Raises";



//        String day68to75 =
//                "Squats\n" +
//                        "Lunges\n" +
//                        "Glute Bridges\n" +
//                        "Side Lunges\n" +
//                        "Wall Sit\n" +
//                        "Leg Raises\n" +
//                        "Jumping Jacks\n" +
//                        "High Knees\n" +
//                        "Mountain Climbers\n" +
//                        "Toe Touches\n" +
//                        "Squats\n" +
//                        "Lunges\n" +
//                        "Glute Bridges\n" +
//                        "Side Lunges\n" +
//                        "Wall Sit\n" +
//                        "Leg Raises\n" +
//                        "Jumping Jacks";
        String day69 =
                "Push-ups\n" +
                        "Tricep Dips\n" +
                        "Plank\n" +
                        "Crunches\n" +
                        "Bicycle Crunches\n" +
                        "Supermans\n" +
                        "Russian Twists\n" +
                        "Side Plank\n" +
                        "Push-ups\n" +
                        "Tricep Dips\n" +
                        "Plank\n" +
                        "Crunches\n" +
                        "Bicycle Crunches\n" +
                        "Supermans\n" +
                        "Russian Twists\n" +
                        "Side Plank\n" +
                        "Push-ups";
        String day70 =
                "Squats\n" +
                        "Lunges\n" +
                        "Glute Bridges\n" +
                        "Side Lunges\n" +
                        "Wall Sit\n" +
                        "Leg Raises\n" +
                        "Jumping Jacks\n" +
                        "High Knees\n" +
                        "Mountain Climbers\n" +
                        "Toe Touches\n" +
                        "Squats\n" +
                        "Lunges\n" +
                        "Glute Bridges\n" +
                        "Side Lunges\n" +
                        "Wall Sit\n" +
                        "Leg Raises\n" +
                        "Jumping Jacks";




//        String day76to83 =
//                "Push-ups\n" +
//                        "Tricep Dips\n" +
//                        "Plank\n" +
//                        "Crunches\n" +
//                        "Bicycle Crunches\n" +
//                        "Supermans\n" +
//                        "Russian Twists\n" +
//                        "Side Plank\n" +
//                        "Push-ups\n" +
//                        "Plank\n" +
//                        "Tricep Dips\n" +
//                        "Crunches\n" +
//                        "Bicycle Crunches\n" +
//                        "Supermans\n" +
//                        "Russian Twists\n" +
//                        "Side Plank\n" +
//                        "Push-ups\n" +
//                        "Plank";
        String day77 =
                "Push-ups\n" +
                        "Tricep Dips\n" +
                        "Plank\n" +
                        "Crunches\n" +
                        "Bicycle Crunches\n" +
                        "Supermans\n" +
                        "Russian Twists\n" +
                        "Side Plank\n" +
                        "Push-ups\n" +
                        "Plank\n" +
                        "Tricep Dips\n" +
                        "Crunches\n" +
                        "Bicycle Crunches\n" +
                        "Supermans\n" +
                        "Russian Twists\n" +
                        "Side Plank\n" +
                        "Push-ups\n" +
                        "Tricep Dips";
        String day78 =
                "Squats\n" +
                        "Lunges\n" +
                        "Glute Bridges\n" +
                        "Side Lunges\n" +
                        "Wall Sit\n" +
                        "Leg Raises\n" +
                        "Jumping Jacks\n" +
                        "High Knees\n" +
                        "Mountain Climbers\n" +
                        "Toe Touches\n" +
                        "Squats\n" +
                        "Lunges\n" +
                        "Glute Bridges\n" +
                        "Side Lunges\n" +
                        "Wall Sit\n" +
                        "Leg Raises\n" +
                        "Jumping Jacks\n" +
                        "High Knees";




//        String day84to90 =
//                "Squats\n" +
//                        "Lunges\n" +
//                        "Glute Bridges\n" +
//                        "Side Lunges\n" +
//                        "Wall Sit\n" +
//                        "Leg Raises\n" +
//                        "Jumping Jacks\n" +
//                        "High Knees\n" +
//                        "Mountain Climbers\n" +
//                        "Toe Touches\n" +
//                        "Squats\n" +
//                        "Lunges\n" +
//                        "Glute Bridges\n" +
//                        "Side Lunges\n" +
//                        "Wall Sit\n" +
//                        "Leg Raises\n" +
//                        "Jumping Jacks\n" +
//                        "High Knees\n" +
//                        "Mountain Climbers";
        String day85 =
                "Push-ups\n" +
                        "Tricep Dips\n" +
                        "Plank\n" +
                        "Crunches\n" +
                        "Bicycle Crunches\n" +
                        "Supermans\n" +
                        "Russian Twists\n" +
                        "Side Plank\n" +
                        "Push-ups\n" +
                        "Tricep Dips\n" +
                        "Plank\n" +
                        "Crunches\n" +
                        "Bicycle Crunches\n" +
                        "Supermans\n" +
                        "Russian Twists\n" +
                        "Side Plank\n" +
                        "Push-ups\n" +
                        "Tricep Dips\n" +
                        "Plank";

        String day86 =
                "Squats\n" +
                        "Lunges\n" +
                        "Glute Bridges\n" +
                        "Side Lunges\n" +
                        "Wall Sit\n" +
                        "Leg Raises\n" +
                        "Jumping Jacks\n" +
                        "High Knees\n" +
                        "Mountain Climbers\n" +
                        "Toe Touches\n" +
                        "Squats\n" +
                        "Lunges\n" +
                        "Glute Bridges\n" +
                        "Side Lunges\n" +
                        "Wall Sit\n" +
                        "Leg Raises\n" +
                        "Jumping Jacks\n" +
                        "High Knees\n" +
                        "Mountain Climbers";



//        String day91to100 =
//                "Push-ups\n" +
//                        "Tricep Dips\n" +
//                        "Plank\n" +
//                        "Crunches\n" +
//                        "Bicycle Crunches\n" +
//                        "Supermans\n" +
//                        "Russian Twists\n" +
//                        "Side Plank\n" +
//                        "Push-ups\n" +
//                        "Plank\n" +
//                        "Tricep Dips\n" +
//                        "Crunches\n" +
//                        "Bicycle Crunches\n" +
//                        "Supermans\n" +
//                        "Russian Twists\n" +
//                        "Side Plank\n" +
//                        "Push-ups\n" +
//                        "Plank\n" +
//                        "Tricep Dips\n" +
//                        "Crunches";
        String day91 =
                "Push-ups\n" +
                        "Tricep Dips\n" +
                        "Plank\n" +
                        "Crunches\n" +
                        "Bicycle Crunches\n" +
                        "Supermans\n" +
                        "Russian Twists\n" +
                        "Side Plank\n" +
                        "Push-ups\n" +
                        "Plank\n" +
                        "Tricep Dips\n" +
                        "Crunches\n" +
                        "Bicycle Crunches\n" +
                        "Supermans\n" +
                        "Russian Twists\n" +
                        "Side Plank\n" +
                        "Push-ups\n" +
                        "Plank\n" +
                        "Crunches\n" +
                        "Bicycle Crunches";
        String day92 =
                "Squats\n" +
                        "Lunges\n" +
                        "Glute Bridges\n" +
                        "Side Lunges\n" +
                        "Wall Sit\n" +
                        "Leg Raises\n" +
                        "Jumping Jacks\n" +
                        "High Knees\n" +
                        "Mountain Climbers\n" +
                        "Toe Touches\n" +
                        "Squats\n" +
                        "Lunges\n" +
                        "Glute Bridges\n" +
                        "Side Lunges\n" +
                        "Wall Sit\n" +
                        "Leg Raises\n" +
                        "Jumping Jacks\n" +
                        "High Knees\n" +
                        "Mountain Climbers\n" +
                        "Toe Touches";


//        String day101to110 =
//                "Squats\n" +
//                        "Lunges\n" +
//                        "Glute Bridges\n" +
//                        "Side Lunges\n" +
//                        "Wall Sit\n" +
//                        "Leg Raises\n" +
//                        "Jumping Jacks\n" +
//                        "High Knees\n" +
//                        "Mountain Climbers\n" +
//                        "Toe Touches\n" +
//                        "Squats\n" +
//                        "Lunges\n" +
//                        "Glute Bridges\n" +
//                        "Side Lunges\n" +
//                        "Wall Sit\n" +
//                        "Leg Raises\n" +
//                        "Jumping Jacks\n" +
//                        "High Knees\n" +
//                        "Mountain Climbers\n" +
//                        "Toe Touches\n" +
//                        "Squats";
        String day101 =
                "Push-ups\n" +
                        "Tricep Dips\n" +
                        "Plank\n" +
                        "Crunches\n" +
                        "Bicycle Crunches\n" +
                        "Supermans\n" +
                        "Russian Twists\n" +
                        "Side Plank\n" +
                        "Push-ups\n" +
                        "Tricep Dips\n" +
                        "Plank\n" +
                        "Crunches\n" +
                        "Bicycle Crunches\n" +
                        "Supermans\n" +
                        "Russian Twists\n" +
                        "Side Plank\n" +
                        "Push-ups\n" +
                        "Tricep Dips\n" +
                        "Plank\n" +
                        "Crunches\n" +
                        "Bicycle Crunches\n";
        String day102 =
                "Squats\n" +
                        "Lunges\n" +
                        "Glute Bridges\n" +
                        "Side Lunges\n" +
                        "Wall Sit\n" +
                        "Leg Raises\n" +
                        "Jumping Jacks\n" +
                        "High Knees\n" +
                        "Mountain Climbers\n" +
                        "Toe Touches\n" +
                        "Squats\n" +
                        "Lunges\n" +
                        "Glute Bridges\n" +
                        "Side Lunges\n" +
                        "Wall Sit\n" +
                        "Leg Raises\n" +
                        "Jumping Jacks\n" +
                        "High Knees\n" +
                        "Mountain Climbers\n" +
                        "Toe Touches\n" +
                        "Squats\n";



//        String day111to120 =
//                "Push-ups\n" +
//                        "Tricep Dips\n" +
//                        "Plank\n" +
//                        "Crunches\n" +
//                        "Bicycle Crunches\n" +
//                        "Supermans\n" +
//                        "Russian Twists\n" +
//                        "Side Plank\n" +
//                        "Push-ups\n" +
//                        "Plank\n" +
//                        "Tricep Dips\n" +
//                        "Crunches\n" +
//                        "Bicycle Crunches\n" +
//                        "Supermans\n" +
//                        "Russian Twists\n" +
//                        "Side Plank\n" +
//                        "Push-ups\n" +
//                        "Plank\n" +
//                        "Tricep Dips\n" +
//                        "Crunches\n" +
//                        "Bicycle Crunches\n" +
//                        "Supermans";
        String day111 =
                "Push-ups\n" +
                        "Tricep Dips\n" +
                        "Plank\n" +
                        "Crunches\n" +
                        "Bicycle Crunches\n" +
                        "Supermans\n" +
                        "Russian Twists\n" +
                        "Side Plank\n" +
                        "Push-ups\n" +
                        "Tricep Dips\n" +
                        "Plank\n" +
                        "Crunches\n" +
                        "Bicycle Crunches\n" +
                        "Supermans\n" +
                        "Russian Twists\n" +
                        "Side Plank\n" +
                        "Push-ups\n" +
                        "Tricep Dips\n" +
                        "Plank\n" +
                        "Crunches\n" +
                        "Bicycle Crunches\n" +
                        "Supermans";
        String day112 =
                "Squats\n" +
                        "Lunges\n" +
                        "Glute Bridges\n" +
                        "Side Lunges\n" +
                        "Wall Sit\n" +
                        "Leg Raises\n" +
                        "Jumping Jacks\n" +
                        "High Knees\n" +
                        "Mountain Climbers\n" +
                        "Toe Touches\n" +
                        "Squats\n" +
                        "Lunges\n" +
                        "Glute Bridges\n" +
                        "Side Lunges\n" +
                        "Wall Sit\n" +
                        "Leg Raises\n" +
                        "Jumping Jacks\n" +
                        "High Knees\n" +
                        "Mountain Climbers\n" +
                        "Toe Touches\n" +
                        "Squats\n" +
                        "Lunges";



//        String day121to130 =
//                "Squats\n" +
//                        "Lunges\n" +
//                        "Glute Bridges\n" +
//                        "Side Lunges\n" +
//                        "Wall Sit\n" +
//                        "Leg Raises\n" +
//                        "Jumping Jacks\n" +
//                        "High Knees\n" +
//                        "Mountain Climbers\n" +
//                        "Toe Touches\n" +
//                        "Squats\n" +
//                        "Lunges\n" +
//                        "Glute Bridges\n" +
//                        "Side Lunges\n" +
//                        "Wall Sit\n" +
//                        "Leg Raises\n" +
//                        "Jumping Jacks\n" +
//                        "High Knees\n" +
//                        "Mountain Climbers\n" +
//                        "Toe Touches\n" +
//                        "Squats\n" +
//                        "Lunges\n" +
//                        "Wall Sit";
        String day121 =
                "Push-ups\n" +
                        "Tricep Dips\n" +
                        "Plank\n" +
                        "Crunches\n" +
                        "Bicycle Crunches\n" +
                        "Supermans\n" +
                        "Russian Twists\n" +
                        "Side Plank\n" +
                        "Push-ups\n" +
                        "Tricep Dips\n" +
                        "Plank\n" +
                        "Crunches\n" +
                        "Bicycle Crunches\n" +
                        "Supermans\n" +
                        "Russian Twists\n" +
                        "Side Plank\n" +
                        "Push-ups\n" +
                        "Tricep Dips\n" +
                        "Plank\n" +
                        "Crunches\n" +
                        "Bicycle Crunches\n" +
                        "Supermans\n" +
                        "Russian Twists";

        String day122 =
                "Squats\n" +
                        "Lunges\n" +
                        "Glute Bridges\n" +
                        "Side Lunges\n" +
                        "Wall Sit\n" +
                        "Leg Raises\n" +
                        "Jumping Jacks\n" +
                        "High Knees\n" +
                        "Mountain Climbers\n" +
                        "Toe Touches\n" +
                        "Squats\n" +
                        "Lunges\n" +
                        "Glute Bridges\n" +
                        "Side Lunges\n" +
                        "Wall Sit\n" +
                        "Leg Raises\n" +
                        "Jumping Jacks\n" +
                        "High Knees\n" +
                        "Mountain Climbers\n" +
                        "Toe Touches\n" +
                        "Squats\n" +
                        "Lunges";



//        String day131to140 =
//                "Push-ups\n" +
//                        "Tricep Dips\n" +
//                        "Plank\n" +
//                        "Crunches\n" +
//                        "Bicycle Crunches\n" +
//                        "Supermans\n" +
//                        "Russian Twists\n" +
//                        "Side Plank\n" +
//                        "Push-ups\n" +
//                        "Plank\n" +
//                        "Tricep Dips\n" +
//                        "Crunches\n" +
//                        "Bicycle Crunches\n" +
//                        "Supermans\n" +
//                        "Russian Twists\n" +
//                        "Side Plank\n" +
//                        "Push-ups\n" +
//                        "Plank\n" +
//                        "Tricep Dips\n" +
//                        "Crunches\n" +
//                        "Bicycle Crunches\n" +
//                        "Supermans\n" +
//                        "Russian Twists\n" +
//                        "Side Plank";
        String day131 =
                "Push-ups\n" +
                        "Tricep Dips\n" +
                        "Plank\n" +
                        "Crunches\n" +
                        "Bicycle Crunches\n" +
                        "Supermans\n" +
                        "Russian Twists\n" +
                        "Side Plank\n" +
                        "Push-ups\n" +
                        "Tricep Dips\n" +
                        "Plank\n" +
                        "Crunches\n" +
                        "Bicycle Crunches\n" +
                        "Supermans\n" +
                        "Russian Twists\n" +
                        "Side Plank\n" +
                        "Push-ups\n" +
                        "Tricep Dips\n" +
                        "Plank\n" +
                        "Crunches\n" +
                        "Bicycle Crunches\n" +
                        "Supermans\n" +
                        "Russian Twists\n" +
                        "Side Plank";

        String day132 =
                "Squats\n" +
                        "Lunges\n" +
                        "Glute Bridges\n" +
                        "Side Lunges\n" +
                        "Wall Sit\n" +
                        "Leg Raises\n" +
                        "Jumping Jacks\n" +
                        "High Knees\n" +
                        "Mountain Climbers\n" +
                        "Toe Touches\n" +
                        "Squats\n" +
                        "Lunges\n" +
                        "Glute Bridges\n" +
                        "Side Lunges\n" +
                        "Wall Sit\n" +
                        "Leg Raises\n" +
                        "Jumping Jacks\n" +
                        "High Knees\n" +
                        "Mountain Climbers\n" +
                        "Toe Touches\n" +
                        "Squats\n" +
                        "Lunges\n" +
                        "Glute Bridges\n" +
                        "Side Lunges";



//        String day141to150 =
//                "Squats\n" +
//                        "Lunges\n" +
//                        "Glute Bridges\n" +
//                        "Side Lunges\n" +
//                        "Wall Sit\n" +
//                        "Leg Raises\n" +
//                        "Jumping Jacks\n" +
//                        "High Knees\n" +
//                        "Mountain Climbers\n" +
//                        "Toe Touches\n" +
//                        "Squats\n" +
//                        "Lunges\n" +
//                        "Glute Bridges\n" +
//                        "Side Lunges\n" +
//                        "Wall Sit\n" +
//                        "Leg Raises\n" +
//                        "Jumping Jacks\n" +
//                        "High Knees\n" +
//                        "Mountain Climbers\n" +
//                        "Toe Touches\n" +
//                        "Squats\n" +
//                        "Lunges\n" +
//                        "Glute Bridges\n" +
//                        "Side Lunges";
        String day141 =
                "Push-ups\n" +
                        "Tricep Dips\n" +
                        "Plank\n" +
                        "Crunches\n" +
                        "Bicycle Crunches\n" +
                        "Supermans\n" +
                        "Russian Twists\n" +
                        "Side Plank\n" +
                        "Push-ups\n" +
                        "Tricep Dips\n" +
                        "Plank\n" +
                        "Crunches\n" +
                        "Bicycle Crunches\n" +
                        "Supermans\n" +
                        "Russian Twists\n" +
                        "Side Plank\n" +
                        "Push-ups\n" +
                        "Tricep Dips\n" +
                        "Plank\n" +
                        "Crunches\n" +
                        "Bicycle Crunches\n" +
                        "Supermans\n" +
                        "Russian Twists\n" +
                        "Side Plank\n" +
                        "Push-ups";
        String day142 =
                "Squats\n" +
                        "Lunges\n" +
                        "Glute Bridges\n" +
                        "Side Lunges\n" +
                        "Wall Sit\n" +
                        "Leg Raises\n" +
                        "Jumping Jacks\n" +
                        "High Knees\n" +
                        "Mountain Climbers\n" +
                        "Toe Touches\n" +
                        "Squats\n" +
                        "Lunges\n" +
                        "Glute Bridges\n" +
                        "Side Lunges\n" +
                        "Wall Sit\n" +
                        "Leg Raises\n" +
                        "Jumping Jacks\n" +
                        "High Knees\n" +
                        "Mountain Climbers\n" +
                        "Toe Touches\n" +
                        "Squats\n" +
                        "Lunges\n" +
                        "Glute Bridges\n" +
                        "Side Lunges\n" +
                        "Wall Sit\n" +
                        "Leg Raises";



//        String day151to157 =
//                "Push-ups\n" +
//                        "Tricep Dips\n" +
//                        "Plank\n" +
//                        "Crunches\n" +
//                        "Bicycle Crunches\n" +
//                        "Supermans\n" +
//                        "Russian Twists\n" +
//                        "Side Plank\n" +
//                        "Push-ups\n" +
//                        "Plank\n" +
//                        "Tricep Dips\n" +
//                        "Crunches\n" +
//                        "Bicycle Crunches\n" +
//                        "Supermans\n" +
//                        "Russian Twists\n" +
//                        "Side Plank\n" +
//                        "Push-ups\n" +
//                        "Plank\n" +
//                        "Tricep Dips\n" +
//                        "Crunches\n" +
//                        "Bicycle Crunches\n" +
//                        "Supermans\n" +
//                        "Russian Twists\n" +
//                        "Side Plank\n" +
//                        "Push-ups\n" +
//                        "Tricep Dips";
        String day151 =
                "Push-ups\n" +
                        "Tricep Dips\n" +
                        "Plank\n" +
                        "Crunches\n" +
                        "Bicycle Crunches\n" +
                        "Supermans\n" +
                        "Russian Twists\n" +
                        "Side Plank\n" +
                        "Push-ups\n" +
                        "Tricep Dips\n" +
                        "Plank\n" +
                        "Crunches\n" +
                        "Bicycle Crunches\n" +
                        "Supermans\n" +
                        "Russian Twists\n" +
                        "Side Plank\n" +
                        "Push-ups\n" +
                        "Tricep Dips\n" +
                        "Plank\n" +
                        "Crunches\n" +
                        "Bicycle Crunches\n" +
                        "Supermans\n" +
                        "Russian Twists\n" +
                        "Side Plank\n" +
                        "Push-ups\n" +
                        "Tricep Dips";
        String day152 =
                "Squats\n" +
                        "Lunges\n" +
                        "Glute Bridges\n" +
                        "Side Lunges\n" +
                        "Wall Sit\n" +
                        "Leg Raises\n" +
                        "Jumping Jacks\n" +
                        "High Knees\n" +
                        "Mountain Climbers\n" +
                        "Toe Touches\n" +
                        "Squats\n" +
                        "Lunges\n" +
                        "Glute Bridges\n" +
                        "Side Lunges\n" +
                        "Wall Sit\n" +
                        "Leg Raises\n" +
                        "Jumping Jacks\n" +
                        "High Knees\n" +
                        "Mountain Climbers\n" +
                        "Toe Touches\n" +
                        "Squats\n" +
                        "Lunges\n" +
                        "Glute Bridges\n" +
                        "Side Lunges\n" +
                        "Wall Sit\n" +
                        "Leg Raises";



//        String day158to164 =
//                "Squats\n" +
//                        "Lunges\n" +
//                        "Glute Bridges\n" +
//                        "Side Lunges\n" +
//                        "Wall Sit\n" +
//                        "Leg Raises\n" +
//                        "Jumping Jacks\n" +
//                        "High Knees\n" +
//                        "Mountain Climbers\n" +
//                        "Toe Touches\n" +
//                        "Squats\n" +
//                        "Lunges\n" +
//                        "Glute Bridges\n" +
//                        "Side Lunges\n" +
//                        "Wall Sit\n" +
//                        "Leg Raises\n" +
//                        "Jumping Jacks\n" +
//                        "High Knees\n" +
//                        "Mountain Climbers\n" +
//                        "Toe Touches\n" +
//                        "Squats\n" +
//                        "Lunges\n" +
//                        "Glute Bridges\n" +
//                        "Side Lunges\n" +
//                        "Wall Sit\n" +
//                        "Leg Raises\n" +
//                        "Jumping Jacks";
        String day159 =
                "Push-ups\n" +
                        "Tricep Dips\n" +
                        "Plank\n" +
                        "Crunches\n" +
                        "Bicycle Crunches\n" +
                        "Supermans\n" +
                        "Russian Twists\n" +
                        "Side Plank\n" +
                        "Push-ups\n" +
                        "Tricep Dips\n" +
                        "Plank\n" +
                        "Crunches\n" +
                        "Bicycle Crunches\n" +
                        "Supermans\n" +
                        "Russian Twists\n" +
                        "Side Plank\n" +
                        "Push-ups\n" +
                        "Tricep Dips\n" +
                        "Plank\n" +
                        "Crunches\n" +
                        "Bicycle Crunches\n" +
                        "Supermans\n" +
                        "Russian Twists\n" +
                        "Side Plank\n" +
                        "Push-ups\n" +
                        "Tricep Dips\n" +
                        "Plank";

        String day158 =
                "Squats\n" +
                        "Lunges\n" +
                        "Glute Bridges\n" +
                        "Side Lunges\n" +
                        "Wall Sit\n" +
                        "Leg Raises\n" +
                        "Jumping Jacks\n" +
                        "High Knees\n" +
                        "Mountain Climbers\n" +
                        "Toe Touches\n" +
                        "Squats\n" +
                        "Lunges\n" +
                        "Glute Bridges\n" +
                        "Side Lunges\n" +
                        "Wall Sit\n" +
                        "Leg Raises\n" +
                        "Jumping Jacks\n" +
                        "High Knees\n" +
                        "Mountain Climbers\n" +
                        "Toe Touches\n" +
                        "Squats\n" +
                        "Lunges\n" +
                        "Glute Bridges\n" +
                        "Side Lunges\n" +
                        "Wall Sit\n" +
                        "Leg Raises\n" +
                        "Jumping Jacks";




//        String day165to172 =
//                "Push-ups\n" +
//                        "Tricep Dips\n" +
//                        "Plank\n" +
//                        "Crunches\n" +
//                        "Bicycle Crunches\n" +
//                        "Supermans\n" +
//                        "Russian Twists\n" +
//                        "Side Plank\n" +
//                        "Push-ups\n" +
//                        "Plank\n" +
//                        "Tricep Dips\n" +
//                        "Crunches\n" +
//                        "Bicycle Crunches\n" +
//                        "Supermans\n" +
//                        "Russian Twists\n" +
//                        "Side Plank\n" +
//                        "Push-ups\n" +
//                        "Plank\n" +
//                        "Tricep Dips\n" +
//                        "Crunches\n" +
//                        "Bicycle Crunches\n" +
//                        "Supermans\n" +
//                        "Russian Twists\n" +
//                        "Side Plank\n" +
//                        "Push-ups\n" +
//                        "Tricep Dips\n" +
//                        "Plank\n" +
//                        "Crunches";
        String day165 =
                "Push-ups\n" +
                        "Tricep Dips\n" +
                        "Plank\n" +
                        "Crunches\n" +
                        "Bicycle Crunches\n" +
                        "Supermans\n" +
                        "Russian Twists\n" +
                        "Side Plank\n" +
                        "Push-ups\n" +
                        "Tricep Dips\n" +
                        "Plank\n" +
                        "Crunches\n" +
                        "Bicycle Crunches\n" +
                        "Supermans\n" +
                        "Russian Twists\n" +
                        "Side Plank\n" +
                        "Push-ups\n" +
                        "Tricep Dips\n" +
                        "Plank\n" +
                        "Crunches\n" +
                        "Bicycle Crunches\n" +
                        "Supermans\n" +
                        "Russian Twists\n" +
                        "Side Plank\n" +
                        "Push-ups\n" +
                        "Tricep Dips\n" +
                        "Plank\n" +
                        "Crunches";
        String day166 =
                "Squats\n" +
                        "Lunges\n" +
                        "Glute Bridges\n" +
                        "Side Lunges\n" +
                        "Wall Sit\n" +
                        "Leg Raises\n" +
                        "Jumping Jacks\n" +
                        "High Knees\n" +
                        "Mountain Climbers\n" +
                        "Toe Touches\n" +
                        "Squats\n" +
                        "Lunges\n" +
                        "Glute Bridges\n" +
                        "Side Lunges\n" +
                        "Wall Sit\n" +
                        "Leg Raises\n" +
                        "Jumping Jacks\n" +
                        "High Knees\n" +
                        "Mountain Climbers\n" +
                        "Toe Touches\n" +
                        "Squats\n" +
                        "Lunges\n" +
                        "Glute Bridges\n" +
                        "Side Lunges\n" +
                        "Wall Sit\n" +
                        "Leg Raises\n" +
                        "Jumping Jacks\n" +
                        "High Knees";


//        String day173to180 =
//                "Squats\n" +
//                        "Lunges\n" +
//                        "Glute Bridges\n" +
//                        "Side Lunges\n" +
//                        "Wall Sit\n" +
//                        "Leg Raises\n" +
//                        "Jumping Jacks\n" +
//                        "High Knees\n" +
//                        "Mountain Climbers\n" +
//                        "Toe Touches\n" +
//                        "Squats\n" +
//                        "Lunges\n" +
//                        "Glute Bridges\n" +
//                        "Side Lunges\n" +
//                        "Wall Sit\n" +
//                        "Leg Raises\n" +
//                        "Jumping Jacks\n" +
//                        "High Knees\n" +
//                        "Mountain Climbers\n" +
//                        "Toe Touches\n" +
//                        "Squats\n" +
//                        "Lunges\n" +
//                        "Glute Bridges\n" +
//                        "Side Lunges\n" +
//                        "Wall Sit\n" +
//                        "Leg Raises\n" +
//                        "Jumping Jacks\n" +
//                        "High Knees\n" +
//                        "Mountain Climbers";

        String day173 =
                "Push-ups\n" +
                        "Tricep Dips\n" +
                        "Plank\n" +
                        "Crunches\n" +
                        "Bicycle Crunches\n" +
                        "Supermans\n" +
                        "Russian Twists\n" +
                        "Side Plank\n" +
                        "Push-ups\n" +
                        "Tricep Dips\n" +
                        "Plank\n" +
                        "Crunches\n" +
                        "Bicycle Crunches\n" +
                        "Supermans\n" +
                        "Russian Twists\n" +
                        "Side Plank\n" +
                        "Push-ups\n" +
                        "Tricep Dips\n" +
                        "Plank\n" +
                        "Crunches\n" +
                        "Bicycle Crunches\n" +
                        "Supermans\n" +
                        "Russian Twists\n" +
                        "Side Plank\n" +
                        "Push-ups\n" +
                        "Tricep Dips\n" +
                        "Plank\n" +
                        "Crunches\n" +
                        "Bicycle Crunches";

        String day174 =
                "Squats\n" +
                        "Lunges\n" +
                        "Glute Bridges\n" +
                        "Side Lunges\n" +
                        "Wall Sit\n" +
                        "Leg Raises\n" +
                        "Jumping Jacks\n" +
                        "High Knees\n" +
                        "Mountain Climbers\n" +
                        "Toe Touches\n" +
                        "Squats\n" +
                        "Lunges\n" +
                        "Glute Bridges\n" +
                        "Side Lunges\n" +
                        "Wall Sit\n" +
                        "Leg Raises\n" +
                        "Jumping Jacks\n" +
                        "High Knees\n" +
                        "Mountain Climbers\n" +
                        "Toe Touches\n" +
                        "Squats\n" +
                        "Lunges\n" +
                        "Glute Bridges\n" +
                        "Side Lunges\n" +
                        "Wall Sit\n" +
                        "Leg Raises\n" +
                        "Jumping Jacks\n" +
                        "High Knees\n" +
                        "Mountain Climbers";


        String day181to190 =
                "Push-ups\n" +
                        "Tricep Dips\n" +
                        "Plank\n" +
                        "Crunches\n" +
                        "Bicycle Crunches\n" +
                        "Supermans\n" +
                        "Russian Twists\n" +
                        "Side Plank\n" +
                        "Push-ups\n" +
                        "Plank\n" +
                        "Tricep Dips\n" +
                        "Crunches\n" +
                        "Bicycle Crunches\n" +
                        "Supermans\n" +
                        "Russian Twists\n" +
                        "Side Plank\n" +
                        "Push-ups\n" +
                        "Plank\n" +
                        "Tricep Dips\n" +
                        "Crunches\n" +
                        "Bicycle Crunches\n" +
                        "Supermans\n" +
                        "Russian Twists\n" +
                        "Side Plank\n" +
                        "Push-ups\n" +
                        "Tricep Dips\n" +
                        "Plank\n" +
                        "Crunches\n" +
                        "Bicycle Crunches\n" +
                        "Supermans";


        String day191to200 =
                "Squats\n" +
                        "Lunges\n" +
                        "Glute Bridges\n" +
                        "Side Lunges\n" +
                        "Wall Sit\n" +
                        "Leg Raises\n" +
                        "Jumping Jacks\n" +
                        "High Knees\n" +
                        "Mountain Climbers\n" +
                        "Toe Touches\n" +
                        "Squats\n" +
                        "Lunges\n" +
                        "Glute Bridges\n" +
                        "Side Lunges\n" +
                        "Wall Sit\n" +
                        "Leg Raises\n" +
                        "Jumping Jacks\n" +
                        "High Knees\n" +
                        "Mountain Climbers\n" +
                        "Toe Touches\n" +
                        "Squats\n" +
                        "Lunges\n" +
                        "Glute Bridges\n" +
                        "Side Lunges\n" +
                        "Wall Sit\n" +
                        "Leg Raises\n" +
                        "Jumping Jacks\n" +
                        "High Knees\n" +
                        "Mountain Climbers\n" +
                        "Toe Touches\n" +
                        "Squats";


        String day201to210 =
                "Push-ups\n" +
                        "Tricep Dips\n" +
                        "Plank\n" +
                        "Crunches\n" +
                        "Bicycle Crunches\n" +
                        "Supermans\n" +
                        "Russian Twists\n" +
                        "Side Plank\n" +
                        "Push-ups\n" +
                        "Plank\n" +
                        "Tricep Dips\n" +
                        "Crunches\n" +
                        "Bicycle Crunches\n" +
                        "Supermans\n" +
                        "Russian Twists\n" +
                        "Side Plank\n" +
                        "Push-ups\n" +
                        "Plank\n" +
                        "Tricep Dips\n" +
                        "Crunches\n" +
                        "Bicycle Crunches\n" +
                        "Supermans\n" +
                        "Russian Twists\n" +
                        "Side Plank\n" +
                        "Push-ups\n" +
                        "Tricep Dips\n" +
                        "Plank\n" +
                        "Crunches\n" +
                        "Bicycle Crunches\n" +
                        "Supermans\n" +
                        "Russian Twists";

        String day211to220 =
                "Squats\n" +
                        "Lunges\n" +
                        "Glute Bridges\n" +
                        "Side Lunges\n" +
                        "Wall Sit\n" +
                        "Leg Raises\n" +
                        "Jumping Jacks\n" +
                        "High Knees\n" +
                        "Mountain Climbers\n" +
                        "Toe Touches\n" +
                        "Squats\n" +
                        "Lunges\n" +
                        "Glute Bridges\n" +
                        "Side Lunges\n" +
                        "Wall Sit\n" +
                        "Leg Raises\n" +
                        "Jumping Jacks\n" +
                        "High Knees\n" +
                        "Mountain Climbers\n" +
                        "Toe Touches\n" +
                        "Squats\n" +
                        "Lunges\n" +
                        "Glute Bridges\n" +
                        "Side Lunges\n" +
                        "Wall Sit\n" +
                        "Leg Raises\n" +
                        "Jumping Jacks\n" +
                        "High Knees\n" +
                        "Mountain Climbers\n" +
                        "Toe Touches\n" +
                        "Squats\n" +
                        "Lunges";


        String day221to230 =
                "Push-ups\n" +
                        "Tricep Dips\n" +
                        "Plank\n" +
                        "Crunches\n" +
                        "Bicycle Crunches\n" +
                        "Supermans\n" +
                        "Russian Twists\n" +
                        "Side Plank\n" +
                        "Push-ups\n" +
                        "Plank\n" +
                        "Tricep Dips\n" +
                        "Crunches\n" +
                        "Bicycle Crunches\n" +
                        "Supermans\n" +
                        "Russian Twists\n" +
                        "Side Plank\n" +
                        "Push-ups\n" +
                        "Plank\n" +
                        "Tricep Dips\n" +
                        "Crunches\n" +
                        "Bicycle Crunches\n" +
                        "Supermans\n" +
                        "Russian Twists\n" +
                        "Side Plank\n" +
                        "Push-ups\n" +
                        "Tricep Dips\n" +
                        "Plank\n" +
                        "Crunches\n" +
                        "Bicycle Crunches\n" +
                        "Supermans\n" +
                        "Russian Twists\n" +
                        "Side Plank\n" +
                        "Push-ups\n" +
                        "Tricep Dips";

        String day231to240 =
                "Squats\n" +
                        "Lunges\n" +
                        "Glute Bridges\n" +
                        "Side Lunges\n" +
                        "Wall Sit\n" +
                        "Leg Raises\n" +
                        "Jumping Jacks\n" +
                        "High Knees\n" +
                        "Mountain Climbers\n" +
                        "Toe Touches\n" +
                        "Squats\n" +
                        "Lunges\n" +
                        "Glute Bridges\n" +
                        "Side Lunges\n" +
                        "Wall Sit\n" +
                        "Leg Raises\n" +
                        "Jumping Jacks\n" +
                        "High Knees\n" +
                        "Mountain Climbers\n" +
                        "Toe Touches\n" +
                        "Squats\n" +
                        "Lunges\n" +
                        "Glute Bridges\n" +
                        "Side Lunges\n" +
                        "Wall Sit\n" +
                        "Leg Raises\n" +
                        "Jumping Jacks\n" +
                        "High Knees\n" +
                        "Mountain Climbers\n" +
                        "Toe Touches\n" +
                        "Squats\n" +
                        "Lunges\n" +
                        "Glute Bridges";


        String day241to247 =
                "Push-ups\n" +
                        "Tricep Dips\n" +
                        "Plank\n" +
                        "Crunches\n" +
                        "Bicycle Crunches\n" +
                        "Supermans\n" +
                        "Russian Twists\n" +
                        "Side Plank\n" +
                        "Push-ups\n" +
                        "Plank\n" +
                        "Tricep Dips\n" +
                        "Crunches\n" +
                        "Bicycle Crunches\n" +
                        "Supermans\n" +
                        "Russian Twists\n" +
                        "Side Plank\n" +
                        "Push-ups\n" +
                        "Plank\n" +
                        "Tricep Dips\n" +
                        "Crunches\n" +
                        "Bicycle Crunches\n" +
                        "Supermans\n" +
                        "Russian Twists\n" +
                        "Side Plank\n" +
                        "Push-ups\n" +
                        "Tricep Dips\n" +
                        "Plank\n" +
                        "Crunches\n" +
                        "Bicycle Crunches\n" +
                        "Supermans\n" +
                        "Russian Twists\n" +
                        "Side Plank\n" +
                        "Push-ups\n" +
                        "Tricep Dips\n" +
                        "Plank\n";


        String day248to254 =
                "Squats\n" +
                        "Lunges\n" +
                        "Glute Bridges\n" +
                        "Side Lunges\n" +
                        "Wall Sit\n" +
                        "Leg Raises\n" +
                        "Jumping Jacks\n" +
                        "High Knees\n" +
                        "Mountain Climbers\n" +
                        "Toe Touches\n" +
                        "Squats\n" +
                        "Lunges\n" +
                        "Glute Bridges\n" +
                        "Side Lunges\n" +
                        "Wall Sit\n" +
                        "Leg Raises\n" +
                        "Jumping Jacks\n" +
                        "High Knees\n" +
                        "Mountain Climbers\n" +
                        "Toe Touches\n" +
                        "Squats\n" +
                        "Lunges\n" +
                        "Glute Bridges\n" +
                        "Side Lunges\n" +
                        "Wall Sit\n" +
                        "Leg Raises\n" +
                        "Jumping Jacks\n" +
                        "High Knees\n" +
                        "Mountain Climbers\n" +
                        "Toe Touches\n" +
                        "Squats\n" +
                        "Lunges\n" +
                        "Glute Bridges\n" +
                        "Side Lunges\n" +
                        "Wall Sit\n" +
                        "Leg Raises";


        String day255to262 =
                "Push-ups\n" +
                        "Tricep Dips\n" +
                        "Plank\n" +
                        "Crunches\n" +
                        "Bicycle Crunches\n" +
                        "Supermans\n" +
                        "Russian Twists\n" +
                        "Side Plank\n" +
                        "Push-ups\n" +
                        "Plank\n" +
                        "Tricep Dips\n" +
                        "Crunches\n" +
                        "Bicycle Crunches\n" +
                        "Supermans\n" +
                        "Russian Twists\n" +
                        "Side Plank\n" +
                        "Push-ups\n" +
                        "Plank\n" +
                        "Tricep Dips\n" +
                        "Crunches\n" +
                        "Bicycle Crunches\n" +
                        "Supermans\n" +
                        "Russian Twists\n" +
                        "Side Plank\n" +
                        "Push-ups\n" +
                        "Tricep Dips\n" +
                        "Plank\n" +
                        "Crunches\n" +
                        "Bicycle Crunches\n" +
                        "Supermans\n" +
                        "Russian Twists\n" +
                        "Side Plank\n" +
                        "Push-ups\n" +
                        "Tricep Dips\n" +
                        "Plank\n" +
                        "Crunches\n";


        String day263to270 =
                "Squats\n" +
                        "Lunges\n" +
                        "Glute Bridges\n" +
                        "Side Lunges\n" +
                        "Wall Sit\n" +
                        "Leg Raises\n" +
                        "Jumping Jacks\n" +
                        "High Knees\n" +
                        "Mountain Climbers\n" +
                        "Toe Touches\n" +
                        "Squats\n" +
                        "Lunges\n" +
                        "Glute Bridges\n" +
                        "Side Lunges\n" +
                        "Wall Sit\n" +
                        "Leg Raises\n" +
                        "Jumping Jacks\n" +
                        "High Knees\n" +
                        "Mountain Climbers\n" +
                        "Toe Touches\n" +
                        "Squats\n" +
                        "Lunges\n" +
                        "Glute Bridges\n" +
                        "Side Lunges\n" +
                        "Wall Sit\n" +
                        "Leg Raises\n" +
                        "Jumping Jacks\n" +
                        "High Knees\n" +
                        "Mountain Climbers\n" +
                        "Toe Touches\n" +
                        "Squats\n" +
                        "Lunges\n" +
                        "Glute Bridges\n" +
                        "Side Lunges\n" +
                        "Wall Sit\n" +
                        "Leg Raises\n" +
                        "Jumping Jacks\n" +
                        "High Knees";


        String day271to280 =
                "Push-ups\n" +
                        "Tricep Dips\n" +
                        "Plank\n" +
                        "Crunches\n" +
                        "Bicycle Crunches\n" +
                        "Supermans\n" +
                        "Russian Twists\n" +
                        "Side Plank\n" +
                        "Push-ups\n" +
                        "Plank\n" +
                        "Tricep Dips\n" +
                        "Crunches\n" +
                        "Bicycle Crunches\n" +
                        "Supermans\n" +
                        "Russian Twists\n" +
                        "Side Plank\n" +
                        "Push-ups\n" +
                        "Plank\n" +
                        "Tricep Dips\n" +
                        "Crunches\n" +
                        "Bicycle Crunches\n" +
                        "Supermans\n" +
                        "Russian Twists\n" +
                        "Side Plank\n" +
                        "Push-ups\n" +
                        "Tricep Dips\n" +
                        "Plank\n" +
                        "Crunches\n" +
                        "Bicycle Crunches\n" +
                        "Supermans\n" +
                        "Russian Twists\n" +
                        "Side Plank\n" +
                        "Push-ups\n" +
                        "Tricep Dips\n" +
                        "Plank\n" +
                        "Crunches\n" +
                        "Bicycle Crunches\n" +
                        "Supermans\n" +
                        "Russian Twists";


        String day281to290 =
                "Squats\n" +
                        "Lunges\n" +
                        "Glute Bridges\n" +
                        "Side Lunges\n" +
                        "Wall Sit\n" +
                        "Leg Raises\n" +
                        "Jumping Jacks\n" +
                        "High Knees\n" +
                        "Mountain Climbers\n" +
                        "Toe Touches\n" +
                        "Squats\n" +
                        "Lunges\n" +
                        "Glute Bridges\n" +
                        "Side Lunges\n" +
                        "Wall Sit\n" +
                        "Leg Raises\n" +
                        "Jumping Jacks\n" +
                        "High Knees\n" +
                        "Mountain Climbers\n" +
                        "Toe Touches\n" +
                        "Squats\n" +
                        "Lunges\n" +
                        "Glute Bridges\n" +
                        "Side Lunges\n" +
                        "Wall Sit\n" +
                        "Leg Raises\n" +
                        "Jumping Jacks\n" +
                        "High Knees\n" +
                        "Mountain Climbers\n" +
                        "Toe Touches\n" +
                        "Squats\n" +
                        "Lunges\n" +
                        "Glute Bridges\n" +
                        "Side Lunges\n" +
                        "Wall Sit\n" +
                        "Leg Raises\n" +
                        "Jumping Jacks\n" +
                        "High Knees\n" +
                        "Mountain Climbers\n" +
                        "Toe Touches";


        String day291to300 =
                "Push-ups\n" +
                        "Tricep Dips\n" +
                        "Plank\n" +
                        "Crunches\n" +
                        "Bicycle Crunches\n" +
                        "Supermans\n" +
                        "Russian Twists\n" +
                        "Side Plank\n" +
                        "Push-ups\n" +
                        "Plank\n" +
                        "Tricep Dips\n" +
                        "Crunches\n" +
                        "Bicycle Crunches\n" +
                        "Supermans\n" +
                        "Russian Twists\n" +
                        "Side Plank\n" +
                        "Push-ups\n" +
                        "Plank\n" +
                        "Tricep Dips\n" +
                        "Crunches\n" +
                        "Bicycle Crunches\n" +
                        "Supermans\n" +
                        "Russian Twists\n" +
                        "Side Plank\n" +
                        "Push-ups\n" +
                        "Tricep Dips\n" +
                        "Plank\n" +
                        "Crunches\n" +
                        "Bicycle Crunches\n" +
                        "Supermans\n" +
                        "Russian Twists\n" +
                        "Side Plank\n" +
                        "Push-ups\n" +
                        "Tricep Dips\n" +
                        "Plank\n" +
                        "Crunches\n" +
                        "Bicycle Crunches\n" +
                        "Supermans\n" +
                        "Russian Twists\n" +
                        "Side Plank\n" +
                        "Push-ups";


        String day301to310 =
                "Squats\n" +
                        "Lunges\n" +
                        "Glute Bridges\n" +
                        "Side Lunges\n" +
                        "Wall Sit\n" +
                        "Leg Raises\n" +
                        "Jumping Jacks\n" +
                        "High Knees\n" +
                        "Mountain Climbers\n" +
                        "Toe Touches\n" +
                        "Squats\n" +
                        "Lunges\n" +
                        "Glute Bridges\n" +
                        "Side Lunges\n" +
                        "Wall Sit\n" +
                        "Leg Raises\n" +
                        "Jumping Jacks\n" +
                        "High Knees\n" +
                        "Mountain Climbers\n" +
                        "Toe Touches\n" +
                        "Squats\n" +
                        "Lunges\n" +
                        "Glute Bridges\n" +
                        "Side Lunges\n" +
                        "Wall Sit\n" +
                        "Leg Raises\n" +
                        "Jumping Jacks\n" +
                        "High Knees\n" +
                        "Mountain Climbers\n" +
                        "Toe Touches\n" +
                        "Squats\n" +
                        "Lunges\n" +
                        "Glute Bridges\n" +
                        "Side Lunges\n" +
                        "Wall Sit\n" +
                        "Leg Raises\n" +
                        "Jumping Jacks\n" +
                        "High Knees\n" +
                        "Mountain Climbers\n" +
                        "Toe Touches\n" +
                        "Squats";


        String day311to320 =
                "Push-ups\n" +
                        "Tricep Dips\n" +
                        "Plank\n" +
                        "Crunches\n" +
                        "Bicycle Crunches\n" +
                        "Supermans\n" +
                        "Russian Twists\n" +
                        "Side Plank\n" +
                        "Push-ups\n" +
                        "Plank\n" +
                        "Tricep Dips\n" +
                        "Crunches\n" +
                        "Bicycle Crunches\n" +
                        "Supermans\n" +
                        "Russian Twists\n" +
                        "Side Plank\n" +
                        "Push-ups\n" +
                        "Plank\n" +
                        "Tricep Dips\n" +
                        "Crunches\n" +
                        "Bicycle Crunches\n" +
                        "Supermans\n" +
                        "Russian Twists\n" +
                        "Side Plank\n" +
                        "Push-ups\n" +
                        "Tricep Dips\n" +
                        "Plank\n" +
                        "Crunches\n" +
                        "Bicycle Crunches\n" +
                        "Supermans\n" +
                        "Russian Twists\n" +
                        "Side Plank\n" +
                        "Push-ups\n" +
                        "Tricep Dips\n" +
                        "Plank\n" +
                        "Crunches\n" +
                        "Bicycle Crunches\n" +
                        "Supermans\n" +
                        "Russian Twists\n" +
                        "Side Plank\n" +
                        "Push-ups\n" +
                        "Tricep Dips";


        String day321to330 =
                "Squats\n" +
                        "Lunges\n" +
                        "Glute Bridges\n" +
                        "Side Lunges\n" +
                        "Wall Sit\n" +
                        "Leg Raises\n" +
                        "Jumping Jacks\n" +
                        "High Knees\n" +
                        "Mountain Climbers\n" +
                        "Toe Touches\n" +
                        "Squats\n" +
                        "Lunges\n" +
                        "Glute Bridges\n" +
                        "Side Lunges\n" +
                        "Wall Sit\n" +
                        "Leg Raises\n" +
                        "Jumping Jacks\n" +
                        "High Knees\n" +
                        "Mountain Climbers\n" +
                        "Toe Touches\n" +
                        "Squats\n" +
                        "Lunges\n" +
                        "Glute Bridges\n" +
                        "Side Lunges\n" +
                        "Wall Sit\n" +
                        "Leg Raises\n" +
                        "Jumping Jacks\n" +
                        "High Knees\n" +
                        "Mountain Climbers\n" +
                        "Toe Touches\n" +
                        "Squats\n" +
                        "Lunges\n" +
                        "Glute Bridges\n" +
                        "Side Lunges\n" +
                        "Wall Sit\n" +
                        "Leg Raises\n" +
                        "Jumping Jacks\n" +
                        "High Knees\n" +
                        "Mountain Climbers\n" +
                        "Toe Touches\n" +
                        "Squats\n" +
                        "Lunges\n" +
                        "Glute Bridges";

        String day331to347 =
                "Push-ups\n" +
                        "Tricep Dips\n" +
                        "Plank\n" +
                        "Crunches\n" +
                        "Bicycle Crunches\n" +
                        "Supermans\n" +
                        "Russian Twists\n" +
                        "Side Plank\n" +
                        "Push-ups\n" +
                        "Plank\n" +
                        "Tricep Dips\n" +
                        "Crunches\n" +
                        "Bicycle Crunches\n" +
                        "Supermans\n" +
                        "Russian Twists\n" +
                        "Side Plank\n" +
                        "Push-ups\n" +
                        "Plank\n" +
                        "Tricep Dips\n" +
                        "Crunches\n" +
                        "Bicycle Crunches\n" +
                        "Supermans\n" +
                        "Russian Twists\n" +
                        "Side Plank\n" +
                        "Push-ups\n" +
                        "Tricep Dips\n" +
                        "Plank\n" +
                        "Crunches\n" +
                        "Bicycle Crunches\n" +
                        "Supermans\n" +
                        "Russian Twists\n" +
                        "Side Plank\n" +
                        "Push-ups\n" +
                        "Tricep Dips\n" +
                        "Plank\n" +
                        "Crunches\n" +
                        "Bicycle Crunches\n" +
                        "Supermans\n" +
                        "Russian Twists\n" +
                        "Side Plank\n" +
                        "Push-ups\n" +
                        "Tricep Dips\n" +
                        "Plank\n" +
                        "Crunches\n" +
                        "Bicycle Crunches\n" +
                        "Supermans\n" +
                        "Russian Twists";

        String day348to365 =
                "Squats\n" +
                        "Lunges\n" +
                        "Glute Bridges\n" +
                        "Side Lunges\n" +
                        "Wall Sit\n" +
                        "Leg Raises\n" +
                        "Jumping Jacks\n" +
                        "High Knees\n" +
                        "Mountain Climbers\n" +
                        "Toe Touches\n" +
                        "Squats\n" +
                        "Lunges\n" +
                        "Glute Bridges\n" +
                        "Side Lunges\n" +
                        "Wall Sit\n" +
                        "Leg Raises\n" +
                        "Jumping Jacks\n" +
                        "High Knees\n" +
                        "Mountain Climbers\n" +
                        "Toe Touches\n" +
                        "Squats\n" +
                        "Lunges\n" +
                        "Glute Bridges\n" +
                        "Side Lunges\n" +
                        "Wall Sit\n" +
                        "Leg Raises\n" +
                        "Jumping Jacks\n" +
                        "High Knees\n" +
                        "Mountain Climbers\n" +
                        "Toe Touches\n" +
                        "Squats\n" +
                        "Lunges\n" +
                        "Glute Bridges\n" +
                        "Side Lunges\n" +
                        "Wall Sit\n" +
                        "Leg Raises\n" +
                        "Jumping Jacks\n" +
                        "High Knees\n" +
                        "Mountain Climbers\n" +
                        "Toe Touches\n" +
                        "Squats\n" +
                        "Lunges\n" +
                        "Glute Bridges\n" +
                        "Side Lunges\n" +
                        "Wall Sit\n" +
                        "Leg Raises\n" +
                        "Jumping Jacks";

//
//        if (day == 1 || day == 3 || day == 5 || day == 7 ||  day == 9) {
//            return day1;
//        }else if(day == 2 || day == 4 || day == 6 || day == 8 ||  day == 10){
//            return day2;
//        }else if (day == 11 || day == 13 || day == 15 || day == 17 ||  day == 19) {
//            return day11;
//        }else if(day == 12 || day == 14 || day == 16 || day == 18 ||  day == 20){
//            return day12;
//        }else if (day == 21 || day == 23 || day == 25 || day == 27 ||  day == 29) {
//            return day21;
//        }else if(day == 22 || day == 24 || day == 26 || day == 28 ||  day == 20){
//            return day22;
//        }
//         else if (day == 31 || day == 33 || day == 35 || day == 37 ||  day == 39) {
//            return day31;
//        }else if(day == 32 || day == 34 || day == 36 || day == 38 ||  day == 40){
//            return day32;
//        }
//         else if (day == 41 || day == 43 || day == 45 || day == 47 ||  day == 49) {
//            return day41;
//        }else if(day == 42 || day == 44 || day == 46 || day == 48 ||  day == 50){
//            return day42;
//        }
//         else if (day >= 51 && day <= 60) {
//            return day51to60;
//        } else if (day >= 61 && day <= 67) {
//            return day61to67;
//        } else if (day >= 68 && day <= 75) {
//            return day68to75;
//        } else if (day >= 76 && day <= 83) {
//            return day76to83;
//        } else if (day >= 84 && day <= 90) {
//            return day84to90;
//        } else if (day >= 91 && day <= 100) {
//            return day91to100;
//        } else if (day >= 101 && day <= 110) {
//            return day101to110;
//        } else if (day >= 111 && day <= 120) {
//            return day111to120;
//        } else if (day >= 121 && day <= 130) {
//            return day121to130;
//        } else if (day >= 131 && day <= 140) {
//            return day131to140;
//        } else if (day >= 141 && day <= 150) {
//            return day141to150;
//        } else if (day >= 151 && day <= 157) {
//            return day151to157;
//        } else if (day >= 158 && day <= 164) {
//            return day158to164;
//        } else if (day >= 165 && day <= 172) {
//            return day165to172;
//        } else if (day >= 173 && day <= 180) {
//            return day173to180;
//        } else if (day >= 181 && day <= 190) {
//            return day181to190;
//        } else if (day >= 191 && day <= 200) {
//            return day191to200;
//        } else if (day >= 201 && day <= 210) {
//            return day201to210;
//        } else if (day >= 211 && day <= 220) {
//            return day211to220;
//        } else if (day >= 221 && day <= 230) {
//            return day221to230;
//        } else if (day >= 231 && day <= 240) {
//            return day231to240;
//        } else if (day >= 241 && day <= 247) {
//            return day241to247;
//        } else if (day >= 248 && day <= 254) {
//            return day248to254;
//        } else if (day >= 255 && day <= 262) {
//            return day255to262;
//        } else if (day >= 263 && day <= 270) {
//            return day263to270;
//        } else if (day >= 271 && day <= 280) {
//            return day271to280;
//        } else if (day >= 281 && day <= 290) {
//            return day281to290;
//        } else if (day >= 291 && day <= 300) {
//            return day291to300;
//        } else if (day >= 301 && day <= 310) {
//            return day301to310;
//        } else if (day >= 311 && day <= 320) {
//            return day311to320;
//        } else if (day >= 321 && day <= 330) {
//            return day321to330;
//        } else if (day >= 331 && day <= 347) {
//            return day331to347;
//        } else if (day >= 348 && day <= 365) {
//            return day348to365;
//        } else {
//            return "Invalid day";
//        }
//    }
        if (day == 1 || day == 3 || day == 5 || day == 7 || day == 9) {
            return day1;
        } else if (day == 2 || day == 4 || day == 6 || day == 8 || day == 10) {
            return day2;
        } else if (day == 11 || day == 13 || day == 15 || day == 17 || day == 19) {
            return day11;
        } else if (day == 12 || day == 14 || day == 16 || day == 18 || day == 20) {
            return day12;
        } else if (day == 21 || day == 23 || day == 25 || day == 27 || day == 29) {
            return day21;
        } else if (day == 22 || day == 24 || day == 26 || day == 28 || day == 30) {
            return day22;
        } else if (day == 31 || day == 33 || day == 35 || day == 37 || day == 39) {
            return day31;
        } else if (day == 32 || day == 34 || day == 36 || day == 38 || day == 40) {
            return day32;
        } else if (day == 41 || day == 43 || day == 45 || day == 47 || day == 49) {
            return day41;
        } else if (day == 42 || day == 44 || day == 46 || day == 48 || day == 50) {
            return day42;
        } else if (day == 51 || day == 53 || day == 55 || day == 57 || day == 59) {
            return day51;
        } else if (day == 52 || day == 54 || day == 56 || day == 58 || day == 60) {
            return day52;
        } else if (day == 61 || day == 63 || day == 65 || day == 67) {
            return day61;
        } else if (day == 62 || day == 64 || day == 66) {
            return day62;

        }else if(day == 69 || day == 71 || day == 73 || day == 75){
            return day69 ;
        }
        else if(day == 68 || day == 70 || day == 72 || day == 74 ){
            return day70 ;
        }
        else if(day == 77 || day == 79 || day == 81 || day == 83){
            return day77 ;
        }
        else if(day == 76 || day == 78 || day == 80 || day == 82 ){
            return day78 ;
        }
        else if(day == 85 || day == 87 || day == 89 ){
            return day85 ;
        }
        else if(day == 84 || day == 86 || day == 88 || day == 90 ){
            return day86 ;
        }
        else if (day == 91 || day == 93 || day == 95 || day == 97 || day == 99) {
            return day91;
        } else if (day == 92 || day == 94 || day == 96 || day == 98 || day == 100) {
            return day92;
        } else if (day == 101 || day == 103 || day == 105 || day == 107 || day == 109) {
            return day101;
        } else if (day == 102 || day == 104 || day == 106 || day == 108 || day == 110) {
            return day102;
        } else if (day == 111 || day == 113 || day == 115 || day == 117 || day == 119) {
            return day111;
        } else if (day == 112 || day == 114 || day == 116 || day == 118 || day == 120) {
            return day112;
        } else if (day == 121 || day == 123 || day == 125 || day == 127 || day == 129) {
            return day121;
        } else if (day == 122 || day == 124 || day == 126 || day == 128 || day == 130) {
            return day122;
        } else if (day == 131 || day == 133 || day == 135 || day == 137 || day == 139) {
            return day131;
        } else if (day == 132 || day == 134 || day == 136 || day == 138 || day == 140) {
            return day132;
        } else if (day == 141 || day == 143 || day == 145 || day == 147 || day == 149) {
            return day141;
        } else if (day == 142 || day == 144 || day == 146 || day == 148 || day == 150) {
            return day142;
        }

        else if (day == 151 || day == 153 || day == 155 || day == 157 ) {
            return day151;
        } else if (day == 152 || day == 154 || day == 156 ) {
            return day152;
        } else if (day == 161 || day == 163 || day == 159) {
            return day159;
        } else if (day == 158 || day == 160 || day == 162 || day == 164) {
            return day158;
        } else if (day == 165 || day == 167 || day == 169 || day == 171 ) {
            return day165;
        } else if (day == 164 || day == 166 || day == 168 || day == 170 ) {
            return day166;
        }else if (day == 173 || day == 175 || day == 177 || day == 179 ) {
            return day173;
        }else if (day == 174 || day == 176 || day == 178 || day == 172 ) {
            return day174;
        }
//        else if (day == 151 || day == 153 || day == 155 || day == 157 || day == 159) {
//            return "day151";
//        } else if (day == 152 || day == 154 || day == 156 || day == 158 || day == 160) {
//            return "day152";
//        } else if (day == 161 || day == 163 || day == 165 || day == 167 || day == 169) {
//            return "day161";
//        } else if (day == 162 || day == 164 || day == 166 || day == 168 || day == 170) {
//            return "day162";
//        } else if (day == 171 || day == 173 || day == 175 || day == 177 || day == 179) {
//            return "day171";
//        } else if (day == 172 || day == 174 || day == 176 || day == 178 || day == 180) {
//            return "day172";
//        }



        else if (day == 181 || day == 183 || day == 185 || day == 187 || day == 189) {
            return day181;
        } else if (day == 182 || day == 184 || day == 186 || day == 188 || day == 190) {
            return day182;
        } else if (day == 191 || day == 193 || day == 195 || day == 197 || day == 199) {
            return "day191";
        } else if (day == 192 || day == 194 || day == 196 || day == 198 || day == 200) {
            return "day192";
        } else if (day == 201 || day == 203 || day == 205 || day == 207 || day == 209) {
            return "day201";
        } else if (day == 202 || day == 204 || day == 206 || day == 208 || day == 210) {
            return "day202";
        } else if (day == 211 || day == 213 || day == 215 || day == 217 || day == 219) {
            return "day211";
        } else if (day == 212 || day == 214 || day == 216 || day == 218 || day == 220) {
            return "day212";
        } else if (day == 221 || day == 223 || day == 225 || day == 227 || day == 229) {
            return "day221";
        } else if (day == 222 || day == 224 || day == 226 || day == 228 || day == 230) {
            return "day222";
        } else if (day == 231 || day == 233 || day == 235 || day == 237 || day == 239) {
            return "day231";
        } else if (day == 232 || day == 234 || day == 236 || day == 238 || day == 240) {
            return "day232";
        } else if (day == 241 || day == 243 || day == 245 || day == 247 || day == 249) {
            return "day241";
        } else if (day == 242 || day == 244 || day == 246 || day == 248 || day == 250) {
            return "day242";
        } else if (day == 251 || day == 253 || day == 255 || day == 257 || day == 259) {
            return "day251";
        } else if (day == 252 || day == 254 || day == 256 || day == 258 || day == 260) {
            return "day252";
        } else if (day == 261 || day == 263 || day == 265 || day == 267 || day == 269) {
            return "day261";
        } else if (day == 262 || day == 264 || day == 266 || day == 268 || day == 270) {
            return "day262";
        } else if (day == 271 || day == 273 || day == 275 || day == 277 || day == 279) {
            return "day271";
        } else if (day == 272 || day == 274 || day == 276 || day == 278 || day == 280) {
            return "day272";
        } else if (day == 281 || day == 283 || day == 285 || day == 287 || day == 289) {
            return "day281";
        } else if (day == 282 || day == 284 || day == 286 || day == 288 || day == 290) {
            return "day282";
        } else if (day == 291 || day == 293 || day == 295 || day == 297 || day == 299) {
            return "day291";
        } else if (day == 292 || day == 294 || day == 296 || day == 298 || day == 300) {
            return "day292";
        } else if (day == 301 || day == 303 || day == 305 || day == 307 || day == 309) {
            return "day301";
        } else if (day == 302 || day == 304 || day == 306 || day == 308 || day == 310) {
            return "day302";
        } else if (day == 311 || day == 313 || day == 315 || day == 317 || day == 319) {
            return "day311";
        } else if (day == 312 || day == 314 || day == 316 || day == 318 || day == 320) {
            return "day312";
        } else if (day == 321 || day == 323 || day == 325 || day == 327 || day == 329) {
            return "day321";
        } else if (day == 322 || day == 324 || day == 326 || day == 328 || day == 330) {
            return "day322";
        } else if (day == 331 || day == 333 || day == 335 || day == 337 || day == 339) {
            return "day331";
        } else if (day == 332 || day == 334 || day == 336 || day == 338 || day == 340) {
            return "day332";
        } else if (day == 341 || day == 343 || day == 345 || day == 347 || day == 349) {
            return "day341";
        } else if (day == 342 || day == 344 || day == 346 || day == 348 || day == 350) {
            return "day342";
        } else if (day == 351 || day == 353 || day == 355 || day == 357 || day == 359) {
            return "day351";
        } else if (day == 352 || day == 354 || day == 356 || day == 358 || day == 360) {
            return "day352";
        } else if (day == 361 || day == 363 || day == 365) {
            return "day361";
        } else if (day == 362 || day == 364) {
            return "day362";
        } else {
            return "Invalid day"; // Handles any out-of-range days
        }
    }







    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_DAY_DETAIL && resultCode == RESULT_OK && data != null) {
            String completedDay = data.getStringExtra("COMPLETED_DAY");
            if (completedDay != null) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean(completedDay, true);
                editor.apply();
                updateDaysAvailability();
                daysAdapter.notifyDataSetChanged();
                Toast.makeText(this, completedDay + " completed!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void resetProgress() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
        updateDaysAvailability();
        daysAdapter.notifyDataSetChanged();
        Toast.makeText(this, "All progress has been reset!", Toast.LENGTH_SHORT).show();
    }
    private void updateDaysAvailability() {
        for (int i = 0; i < daysList.size(); i++) {
            Day day = daysList.get(i);
            if (i == 0) {
                day.setAvailable(true); // Day 1 is always available
            } else {
                String prevDayNumber = "Day " + i;
                boolean prevDayCompleted = sharedPreferences.getBoolean(prevDayNumber, false);
                day.setAvailable(prevDayCompleted);
            }
        }
    }
}
