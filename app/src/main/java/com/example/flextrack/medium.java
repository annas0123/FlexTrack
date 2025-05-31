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



public class medium extends AppCompatActivity {

    private RecyclerView recyclerView;
    private DaysAdapterMedium daysAdapter;
    private List<Day> daysList;
    private Button resetButton;

    private static final int REQUEST_CODE_DAY_DETAIL = 2;
    private SharedPreferences sharedPreferences;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy);

        recyclerView = findViewById(R.id.recycler_view);
        resetButton = findViewById(R.id.clearalldata);

        daysList = new ArrayList<>();
        sharedPreferences = getSharedPreferences("DayCompletionStatusMedium", MODE_PRIVATE);

        for (int i = 1; i <= 30; i++) {
            String dayNumber = "Day " + i;
            boolean isDayCompleted = sharedPreferences.getBoolean(dayNumber, false);
            Day day = new Day(dayNumber, "Exercise plan for " + dayNumber, 12);
            day.setAvailable(i == 1 || sharedPreferences.getBoolean("Day " + (i - 1), false)); // Set availability
            daysList.add(day);
        }

        daysAdapter = new DaysAdapterMedium(daysList, new DaysAdapterMedium.OnItemClickListener() {
            @Override
            public void onItemClick(Day day) {
                String dayNumber = day.getDayNumber();
                boolean isDayCompleted = sharedPreferences.getBoolean(dayNumber, false);

                if (isDayCompleted) {
                    Toast.makeText(medium.this, dayNumber + " is already completed!", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(medium.this, DayDetailActivityMedium.class);
                    intent.putExtra("DAY_NUMBER_M", day.getDayNumber());
                    intent.putExtra("EXERCISES_M", getExercisesForDay(day.getDayNumber()));
                    intent.putExtra("TIMER_M", day.getMinutes()); // Pass the minutes to the detail activity
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

        String day1 = "day1", day2 = "day2", day3 = "day3", day4 = "day4", day5 = "day5",
                day6 = "day6", day7 = "day7", day8 = "day8", day9 = "day9", day10 = "day10",
                day11 = "day11", day12 = "day12", day13 = "day13", day14 = "day14", day15 = "day15",
                day16 = "day16", day17 = "day17", day18 = "day18", day19 = "day19", day20 = "day20",
                day21 = "day21", day22 = "day22", day23 = "day23", day24 = "day24", day25 = "day25",
                day26 = "day26", day27 = "day27", day28 = "day28", day29 = "day29", day30 = "day30";

        // Medium level workout plan - 10-12 exercises per day (1 minute each)
        day1 = "Jumping Jacks\n" +
                "Squats\n" +
                "Push-ups\n" +
                "Plank\n" +
                "Lunges\n" +
                "Crunches\n" +
                "High Knees\n" +
                "Glute Bridges\n" +
                "Mountain Climbers\n" +
                "Leg Raises\n";

        day2 = "Tricep Dips\n" +
                "Russian Twists\n" +
                "Side Lunges\n" +
                "Bicycle Crunches\n" +
                "Supermans\n" +
                "Wall Sit\n" +
                "Toe Touches\n" +
                "Side Plank\n" +
                "Jumping Jacks\n" +
                "Squats\n";

        day3 = "Push-ups\n" +
                "Plank\n" +
                "Lunges\n" +
                "Crunches\n" +
                "High Knees\n" +
                "Glute Bridges\n" +
                "Mountain Climbers\n" +
                "Leg Raises\n" +
                "Tricep Dips\n" +
                "Russian Twists\n";

        day4 = "Side Lunges\n" +
                "Bicycle Crunches\n" +
                "Supermans\n" +
                "Wall Sit\n" +
                "Toe Touches\n" +
                "Side Plank\n" +
                "Jumping Jacks\n" +
                "Squats\n" +
                "Push-ups\n" +
                "Plank\n";

        day5 = "Lunges\n" +
                "Crunches\n" +
                "High Knees\n" +
                "Glute Bridges\n" +
                "Mountain Climbers\n" +
                "Leg Raises\n" +
                "Tricep Dips\n" +
                "Russian Twists\n" +
                "Side Lunges\n" +
                "Bicycle Crunches\n";

        day6 = "Supermans\n" +
                "Wall Sit\n" +
                "Toe Touches\n" +
                "Side Plank\n" +
                "Jumping Jacks\n" +
                "Squats\n" +
                "Push-ups\n" +
                "Plank\n" +
                "Lunges\n" +
                "Crunches\n" +
                "High Knees\n";

        day7 = "Glute Bridges\n" +
                "Mountain Climbers\n" +
                "Leg Raises\n" +
                "Tricep Dips\n" +
                "Russian Twists\n" +
                "Side Lunges\n" +
                "Bicycle Crunches\n" +
                "Supermans\n" +
                "Wall Sit\n" +
                "Toe Touches\n";

        day8 = "Side Plank\n" +
                "Jumping Jacks\n" +
                "Squats\n" +
                "Push-ups\n" +
                "Plank\n" +
                "Lunges\n" +
                "Crunches\n" +
                "High Knees\n" +
                "Glute Bridges\n" +
                "Mountain Climbers\n";

        day9 = "Leg Raises\n" +
                "Tricep Dips\n" +
                "Russian Twists\n" +
                "Side Lunges\n" +
                "Bicycle Crunches\n" +
                "Supermans\n" +
                "Wall Sit\n" +
                "Toe Touches\n" +
                "Side Plank\n" +
                "Jumping Jacks\n";

        day10 = "Squats\n" +
                "Push-ups\n" +
                "Plank\n" +
                "Lunges\n" +
                "Crunches\n" +
                "High Knees\n" +
                "Glute Bridges\n" +
                "Mountain Climbers\n" +
                "Leg Raises\n" +
                "Tricep Dips\n" +
                "Russian Twists\n";

        day11 = "Side Lunges\n" +
                "Bicycle Crunches\n" +
                "Supermans\n" +
                "Wall Sit\n" +
                "Toe Touches\n" +
                "Side Plank\n" +
                "Jumping Jacks\n" +
                "Squats\n" +
                "Push-ups\n" +
                "Plank\n" +
                "Lunges\n";

        day12 = "Crunches\n" +
                "High Knees\n" +
                "Glute Bridges\n" +
                "Mountain Climbers\n" +
                "Leg Raises\n" +
                "Tricep Dips\n" +
                "Russian Twists\n" +
                "Side Lunges\n" +
                "Bicycle Crunches\n" +
                "Supermans\n" +
                "Wall Sit\n";

        day13 = "Toe Touches\n" +
                "Side Plank\n" +
                "Jumping Jacks\n" +
                "Squats\n" +
                "Push-ups\n" +
                "Plank\n" +
                "Lunges\n" +
                "Crunches\n" +
                "High Knees\n" +
                "Glute Bridges\n" +
                "Mountain Climbers\n";

        day14 = "Leg Raises\n" +
                "Tricep Dips\n" +
                "Russian Twists\n" +
                "Side Lunges\n" +
                "Bicycle Crunches\n" +
                "Supermans\n" +
                "Wall Sit\n" +
                "Toe Touches\n" +
                "Side Plank\n" +
                "Jumping Jacks\n" +
                "Squats\n";

        day15 = "Push-ups\n" +
                "Plank\n" +
                "Lunges\n" +
                "Crunches\n" +
                "High Knees\n" +
                "Glute Bridges\n" +
                "Mountain Climbers\n" +
                "Leg Raises\n" +
                "Tricep Dips\n" +
                "Russian Twists\n" +
                "Side Lunges\n";

        day16 = "Bicycle Crunches\n" +
                "Supermans\n" +
                "Wall Sit\n" +
                "Toe Touches\n" +
                "Side Plank\n" +
                "Jumping Jacks\n" +
                "Squats\n" +
                "Push-ups\n" +
                "Plank\n" +
                "Lunges\n" +
                "Crunches\n";

        day17 = "High Knees\n" +
                "Glute Bridges\n" +
                "Mountain Climbers\n" +
                "Leg Raises\n" +
                "Tricep Dips\n" +
                "Russian Twists\n" +
                "Side Lunges\n" +
                "Bicycle Crunches\n" +
                "Supermans\n" +
                "Wall Sit\n" +
                "Toe Touches\n";

        day18 = "Side Plank\n" +
                "Jumping Jacks\n" +
                "Squats\n" +
                "Push-ups\n" +
                "Plank\n" +
                "Lunges\n" +
                "Crunches\n" +
                "High Knees\n" +
                "Glute Bridges\n" +
                "Mountain Climbers\n" +
                "Leg Raises\n";

        day19 = "Tricep Dips\n" +
                "Russian Twists\n" +
                "Side Lunges\n" +
                "Bicycle Crunches\n" +
                "Supermans\n" +
                "Wall Sit\n" +
                "Toe Touches\n" +
                "Side Plank\n" +
                "Jumping Jacks\n" +
                "Squats\n" +
                "Push-ups\n";

        day20 = "Plank\n" +
                "Lunges\n" +
                "Crunches\n" +
                "High Knees\n" +
                "Glute Bridges\n" +
                "Mountain Climbers\n" +
                "Leg Raises\n" +
                "Tricep Dips\n" +
                "Russian Twists\n" +
                "Side Lunges\n" +
                "Bicycle Crunches\n";

        day21 = "Supermans\n" +
                "Wall Sit\n" +
                "Toe Touches\n" +
                "Side Plank\n" +
                "Jumping Jacks\n" +
                "Squats\n" +
                "Push-ups\n" +
                "Plank\n" +
                "Lunges\n" +
                "Crunches\n" +
                "High Knees\n";

        day22 = "Glute Bridges\n" +
                "Mountain Climbers\n" +
                "Leg Raises\n" +
                "Tricep Dips\n" +
                "Russian Twists\n" +
                "Side Lunges\n" +
                "Bicycle Crunches\n" +
                "Supermans\n" +
                "Wall Sit\n" +
                "Toe Touches\n" +
                "Side Plank\n";

        day23 = "Jumping Jacks\n" +
                "Squats\n" +
                "Push-ups\n" +
                "Plank\n" +
                "Lunges\n" +
                "Crunches\n" +
                "High Knees\n" +
                "Glute Bridges\n" +
                "Mountain Climbers\n" +
                "Leg Raises\n" +
                "Tricep Dips\n";

        day24 = "Russian Twists\n" +
                "Side Lunges\n" +
                "Bicycle Crunches\n" +
                "Supermans\n" +
                "Wall Sit\n" +
                "Toe Touches\n" +
                "Side Plank\n" +
                "Jumping Jacks\n" +
                "Squats\n" +
                "Push-ups\n" +
                "Plank\n";

        day25 = "Lunges\n" +
                "Crunches\n" +
                "High Knees\n" +
                "Glute Bridges\n" +
                "Mountain Climbers\n" +
                "Leg Raises\n" +
                "Tricep Dips\n" +
                "Russian Twists\n" +
                "Side Lunges\n" +
                "Bicycle Crunches\n" +
                "Supermans\n";

        day26 = "Wall Sit\n" +
                "Toe Touches\n" +
                "Side Plank\n" +
                "Jumping Jacks\n" +
                "Squats\n" +
                "Push-ups\n" +
                "Plank\n" +
                "Lunges\n" +
                "Crunches\n" +
                "High Knees\n" +
                "Glute Bridges\n";

        day27 = "Mountain Climbers\n" +
                "Leg Raises\n" +
                "Tricep Dips\n" +
                "Russian Twists\n" +
                "Side Lunges\n" +
                "Bicycle Crunches\n" +
                "Supermans\n" +
                "Wall Sit\n" +
                "Toe Touches\n" +
                "Side Plank\n" +
                "Jumping Jacks\n";

        day28 = "Squats\n" +
                "Push-ups\n" +
                "Plank\n" +
                "Lunges\n" +
                "Crunches\n" +
                "High Knees\n" +
                "Glute Bridges\n" +
                "Mountain Climbers\n" +
                "Leg Raises\n" +
                "Tricep Dips\n" +
                "Russian Twists\n";

        day29 = "Side Lunges\n" +
                "Bicycle Crunches\n" +
                "Supermans\n" +
                "Wall Sit\n" +
                "Toe Touches\n" +
                "Side Plank\n" +
                "Jumping Jacks\n" +
                "Squats\n" +
                "Push-ups\n" +
                "Plank\n" +
                "Lunges\n";

        day30 = "Jumping Jacks\n" +
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
                "Wall Sit\n";}

        if (day == 1) {
            return day1;
        } else if (day == 2) {
            return day2;
        } else if (day == 3) {
            return day3;
        } else if (day == 4) {
            return day4;
        } else if (day == 5) {
            return day5;
        } else if (day == 6) {
            return day6;
        } else if (day == 7) {
            return day7;
        } else if (day == 8) {
            return day8;
        } else if (day == 9) {
            return day9;
        } else if (day == 10) {
            return day10;
        } else if (day == 11) {
            return day11;
        } else if (day == 12) {
            return day12;
        } else if (day == 13) {
            return day13;
        } else if (day == 14) {
            return day14;
        } else if (day == 15) {
            return day15;
        } else if (day == 16) {
            return day16;
        } else if (day == 17) {
            return day17;
        } else if (day == 18) {
            return day18;
        } else if (day == 19) {
            return day19;
        } else if (day == 20) {
            return day20;
        } else if (day == 21) {
            return day21;
        } else if (day == 22) {
            return day22;
        } else if (day == 23) {
            return day23;
        } else if (day == 24) {
            return day24;
        } else if (day == 25) {
            return day25;
        } else if (day == 26) {
            return day26;
        } else if (day == 27) {
            return day27;
        } else if (day == 28) {
            return day28;
        } else if (day == 29) {
            return day29;
        } else if (day == 30) {
            return day30;
        } else {
            return "Rest Day";
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
