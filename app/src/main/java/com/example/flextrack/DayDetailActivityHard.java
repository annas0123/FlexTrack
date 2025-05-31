
package com.example.flextrack;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DayDetailActivityHard extends AppCompatActivity {

    private static final long ONE_MINUTE_IN_MILLIS = 60000; // 1 minute in milliseconds
    private static final long THIRTY_SECONDS_IN_MILLIS = 30000; // 30 seconds in milliseconds
    private CountDownTimer exerciseTimer;
    private CountDownTimer restTimer;
    private TextView dayTextView;
    private TextView timerTextView , During;
    private ProgressBar progressbar;
    private TextView exercisesTextView;
    private ImageView exerciseImageView;
    private Button startWorkoutButton, completeButton, pauseButton, resumeButton;
    private String[] exercises;
    private int currentExerciseIndex = 0;



    private long exerciseTimeRemaining = ONE_MINUTE_IN_MILLIS;
    private long restTimeRemaining = THIRTY_SECONDS_IN_MILLIS;
    private boolean isExercisePhase = true; // Indicates if the current phase is exercise or rest

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_detail);

        dayTextView = findViewById(R.id.day_text_view);
        timerTextView = findViewById(R.id.timer_text_view);
        exercisesTextView = findViewById(R.id.exercises_text_view);
        exerciseImageView = findViewById(R.id.exercise_image_view);
        startWorkoutButton = findViewById(R.id.start_workout_button);
        completeButton = findViewById(R.id.Complete);
        pauseButton = findViewById(R.id.pause_button);
        resumeButton = findViewById(R.id.resume_button);

        //----------------progress bar------------------//
        During = findViewById(R.id.During);
        During.setVisibility(View.GONE);


        //----------------progress bar------------------//

        completeButton.setVisibility(View.GONE);
        pauseButton.setVisibility(View.GONE);
        resumeButton.setVisibility(View.GONE);

        Intent intent = getIntent();
        String dayNumber = intent.getStringExtra("DAY_NUMBER_H");
        exercises = intent.getStringExtra("EXERCISES_H").split("\n");
        int minutes = intent.getIntExtra("TIMER_H", 12);  // Default to 12 minutes if not provided

        dayTextView.setText(dayNumber);
        exercisesTextView.setText(intent.getStringExtra("EXERCISES_H"));

        startWorkoutButton.setOnClickListener(v -> startWorkout(minutes));

        completeButton.setOnClickListener(v -> {
            saveCompletionStatus(dayNumber);
            setResult(RESULT_OK, new Intent().putExtra("COMPLETED_DAY", dayNumber));
            finish();
        });

        pauseButton.setOnClickListener(v -> pauseTimers());
        resumeButton.setOnClickListener(v -> resumeTimers());
    }

    private void saveCompletionStatus(String dayNumber) {
        SharedPreferences sharedPreferences = getSharedPreferences("DayCompletionStatusHard", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(dayNumber, true);
        editor.apply();
    }

    private void startWorkout(int minutes) {

        //----------------progress bar------------------//

        timerTextView.setVisibility(View.GONE);
        During.setVisibility(View.VISIBLE);
        //----------------progress bar------------------//

        currentExerciseIndex = 0;
        startWorkoutButton.setVisibility(View.GONE);
        pauseButton.setVisibility(View.VISIBLE);
        startExercise();
    }

    private void startExercise() {
        if (currentExerciseIndex < exercises.length) {
            String currentExercise = exercises[currentExerciseIndex];
            exercisesTextView.setText(currentExercise);
            loadExerciseImage(currentExercise);
            startExerciseTimer(exerciseTimeRemaining);

        } else {
            During.setVisibility(View.VISIBLE);

            During.setText("All DONE");
            completeWorkout();
        }
    }


    private void loadExerciseImage(String exercise) {
        int imageResId = R.drawable.ic_launcher_foreground; // Default image

        switch (exercise) {
            case "Jumping Jacks":
                imageResId = R.drawable.jumping_jack;
                break;
            case "Squats":
                imageResId = R.drawable.squat;
                break;
            case "Push-ups":
                imageResId = R.drawable.pushup;
                break;
            case "Plank":
                imageResId = R.drawable.plank;
                break;
            case "Lunges":
                imageResId = R.drawable.lunges;
                break;
            case "Crunches":
                imageResId = R.drawable.crunches;
                break;
            case "High Knees":
                imageResId = R.drawable.high_knees;
                break;
            case "Glute Bridges":
                imageResId = R.drawable.glutebridges;
                break;
            case "Mountain Climbers":
                imageResId = R.drawable.mountain_climber;
                break;
            case "Leg Raises":
                imageResId = R.drawable.leg_raise;
                break;
            case "Tricep Dips":
                imageResId = R.drawable.tricep_dips;
                break;
            case "Russian Twists":
                imageResId = R.drawable.russian_twists;
                break;
            case "Side Lunges":
                imageResId = R.drawable.side_lunges;
                break;
            case "Bicycle Crunches":
                imageResId = R.drawable.sit_up;
                break;
            case "Supermans":
                imageResId = R.drawable.superman;
                break;
            case "Wall Sit":
                imageResId = R.drawable.wall_sit;
                break;
            case "Toe Touches":
                imageResId = R.drawable.toe_touches;
                break;
            case "Side Plank":
                imageResId = R.drawable.side_plank;
                break;
        }

        exerciseImageView.setImageResource(imageResId);
    }
    private void startExerciseTimer(long timeInMillis) {
        exerciseTimer = new CountDownTimer(timeInMillis, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {
                exerciseTimeRemaining = millisUntilFinished;
                During.setText("" + millisUntilFinished / 1000 + "");
            }

            @Override
            public void onFinish() {
                exerciseTimeRemaining = ONE_MINUTE_IN_MILLIS;
                isExercisePhase = false;
                startRestTimer(restTimeRemaining);
            }
        }.start();
    }

    private void startRestTimer(long timeInMillis) {
        exercisesTextView.setText("Rest: 30 seconds");
        loadRestImage();

        restTimer = new CountDownTimer(timeInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                restTimeRemaining = millisUntilFinished;
                During.setText(" " + millisUntilFinished / 1000 + "");
            }

            @Override
            public void onFinish() {
                restTimeRemaining = THIRTY_SECONDS_IN_MILLIS;
                isExercisePhase = true;
                currentExerciseIndex++;
                startExercise();
            }
        }.start();
    }

    private void completeWorkout() {
        During.setVisibility(View.VISIBLE);
        timerTextView.setText("Workout complete!");
        completeButton.setVisibility(View.VISIBLE);
        pauseButton.setVisibility(View.GONE);
        resumeButton.setVisibility(View.GONE);
    }


    private void pauseTimers() {
        if (exerciseTimer != null) {
            exerciseTimer.cancel();
            exerciseTimer = null;
        }

        if (restTimer != null) {
            restTimer.cancel();
            restTimer = null;
        }

        pauseButton.setVisibility(View.GONE);
        resumeButton.setVisibility(View.VISIBLE);
    }

    private void resumeTimers() {
        if (isExercisePhase) {
            startExerciseTimer(exerciseTimeRemaining);
        } else {
            startRestTimer(restTimeRemaining);
        }

        resumeButton.setVisibility(View.GONE);
        pauseButton.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (exerciseTimer != null) {
            exerciseTimer.cancel();
        }
        if (restTimer != null) {
            restTimer.cancel();
        }
    }

    private void loadRestImage() {
        exerciseImageView.setImageResource(R.drawable.rest);
    }


}
