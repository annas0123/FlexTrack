package com.example.flextrack;

import android.os.Handler;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Set;

public class PlanCategories extends AppCompatActivity {
    private Button easy, buttonReminder , medium , hard , challenge365 , about;
    private Handler handler = new Handler();
    private Runnable updateTimeRunnable;
    private TextView remainingTimeTextView;

    private SharedPreferences sharedPreferences;
    private static final String PREFS_NAME = "PrefsFile";
    private static final String PASSWORD_KEY = "password";
    private Spinner spinnerAmPm;


//    private TextView previousTimeTextView, currentTimeTextView;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan_categories);

        remainingTimeTextView = findViewById(R.id.remainingTimeTextView);
        sharedPreferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        buttonReminder = findViewById(R.id.reminder);
        spinnerAmPm = findViewById(R.id.spinnerAmPm);


        buttonReminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isPasswordSet()) {
                    promptForPassword();
                } else {
                    showReminderDialog();
                }
            }
        });

        easy = findViewById(R.id.easy);
        medium = findViewById(R.id.medium);
        hard = findViewById(R.id.hard);
        challenge365 = findViewById(R.id.challenge365);
        about = findViewById(R.id.aboutapp);



        easy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PlanCategories.this, easy.class);
                startActivity(i);
            }
        });

        medium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PlanCategories.this, medium.class);
                startActivity(i);
            }
        });
        hard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PlanCategories.this, hard.class);
                startActivity(i);
            }
        });
        challenge365.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PlanCategories.this, challenge365.class);
                startActivity(i);
            }
        });
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PlanCategories.this, tips.class);
                startActivity(i);
            }
        });

        loadReminderTime(); // Load and display the saved reminder time
    }

    private void showReminderDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_reminder, null);
        builder.setView(dialogView);

        EditText editTextHour = dialogView.findViewById(R.id.editTextHour);
        EditText editTextMinute = dialogView.findViewById(R.id.editTextMinute);
        Spinner spinnerAmPm = dialogView.findViewById(R.id.spinnerAmPm);
        Button buttonSetReminder = dialogView.findViewById(R.id.buttonSetReminder);

        // Retrieve the string array from resources (assumes am_pm contains "AM" and "PM")
        String[] am_pm = getResources().getStringArray(R.array.am_pm);

        // Create an adapter using the array
        ArrayAdapter<String> combinedAdapter = new ArrayAdapter<>(this, R.layout.spinner_item, am_pm);
        combinedAdapter.setDropDownViewResource(R.layout.spinner_item); // Custom layout for dropdown

        // Set the adapter to the spinner
        spinnerAmPm.setAdapter(combinedAdapter);

        AlertDialog dialog = builder.create();

        buttonSetReminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int hour = Integer.parseInt(editTextHour.getText().toString());
                    int minute = Integer.parseInt(editTextMinute.getText().toString());
                    String amPm = spinnerAmPm.getSelectedItem().toString();
                    setReminder(hour, minute, amPm);
                    saveReminderTime(hour, minute, amPm);
                    updateRemainingTime(hour, minute, amPm); // Update the remaining time after setting the reminder
                    dialog.dismiss();
                } catch (NumberFormatException e) {
                    Toast.makeText(PlanCategories.this, "Please enter valid time values", Toast.LENGTH_SHORT).show();
                }
            }
        });

        dialog.show();
    }

    public void setReminder(int hour, int minute, String amPm) {
        // Convert the given time to 24-hour format
        if (amPm.equals("PM") && hour != 12) {
            hour += 12;
        } else if (amPm.equals("AM") && hour == 12) {
            hour = 0;
        }

        // Set the calendar to the specified time
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minute);
        calendar.set(Calendar.SECOND, 0);

        // If the time has already passed, set it for the next day
        if (calendar.before(Calendar.getInstance())) {
            calendar.add(Calendar.DATE, 1);
        }

        // Create a unique request code for the PendingIntent
        int uniqueRequestCode = (int) System.currentTimeMillis();

        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(this, AlarmReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, uniqueRequestCode, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        // Cancel any existing alarms with the same PendingIntent
        alarmManager.cancel(pendingIntent);

        // Set a repeating alarm to trigger every day at the specified time
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent);
    }



    private void saveReminderTime(int hour, int minute, String amPm) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("reminder_hour", hour);
        editor.putInt("reminder_minute", minute);
        editor.putString("reminder_am_pm", amPm);
        editor.apply();
    }

    private void loadReminderTime() {
        int hour = sharedPreferences.getInt("reminder_hour", -1);
        int minute = sharedPreferences.getInt("reminder_minute", -1);
        String amPm = sharedPreferences.getString("reminder_am_pm", null);

        if (hour != -1 && minute != -1 && amPm != null) {
            updateRemainingTime(hour, minute, amPm); // Update the UI with the saved time
        }
    }

    private boolean isPasswordSet() {
        String password = sharedPreferences.getString(PASSWORD_KEY, null);
        return password != null;
    }

    private void promptForPassword() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_password, null);
        builder.setView(dialogView);

        EditText editTextPassword = dialogView.findViewById(R.id.editTextPassword);
        Button buttonSubmit = dialogView.findViewById(R.id.buttonSubmit);
        Button buttonResetPassword = dialogView.findViewById(R.id.buttonResetPassword);

        AlertDialog dialog = builder.create();

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String enteredPassword = editTextPassword.getText().toString();
                String savedPassword = sharedPreferences.getString(PASSWORD_KEY, null);
                if (enteredPassword.equals(savedPassword)) {
                    showReminderDialog();
                    dialog.dismiss();
                } else {
                    Toast.makeText(PlanCategories.this, "Incorrect password", Toast.LENGTH_SHORT).show();
                }
            }
        });

        buttonResetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetPassword();
                dialog.dismiss();
            }
        });

        dialog.show();
    }

    private void resetPassword() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_reset_password, null);
        builder.setView(dialogView);

        EditText editTextNewPassword = dialogView.findViewById(R.id.editTextNewPassword);
        Button buttonSetPassword = dialogView.findViewById(R.id.buttonSetPassword);

        AlertDialog dialog = builder.create();

        buttonSetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newPassword = editTextNewPassword.getText().toString();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(PASSWORD_KEY, newPassword);
                editor.apply();
                Toast.makeText(PlanCategories.this, "Password reset successfully", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        dialog.show();
    }

//    private void updateRemainingTime(final int hour, final int minute, final String amPm) {
//        // Convert to 24-hour format
//        int adjustedHour = hour;
//        if (amPm.equals("PM") && hour != 12) {
//            adjustedHour += 12;
//        } else if (amPm.equals("AM") && hour == 12) {
//            adjustedHour = 0;
//        }
//
//        // Create a Calendar object for the reminder time
//        final Calendar reminderTime = Calendar.getInstance();
//        reminderTime.set(Calendar.HOUR_OF_DAY, adjustedHour);
//        reminderTime.set(Calendar.MINUTE, minute);
//        reminderTime.set(Calendar.SECOND, 0);
//
//        // Real-time update of remaining time
//        updateTimeRunnable = new Runnable() {
//            @Override
//            public void run() {
//                Calendar now = Calendar.getInstance();
//
//                if (reminderTime.before(now)) {
//                    reminderTime.add(Calendar.DATE, 1);
//                }
//
//                long diffMillis = reminderTime.getTimeInMillis() - now.getTimeInMillis();
//                long diffSeconds = (diffMillis / 1000) % 60; // Gets the seconds part
//                long diffHours = diffMillis / (60 * 60 * 1000);
//                long diffMinutes = (diffMillis / (60 * 1000)) % 60;
//
//                remainingTimeTextView.setText("Remaining time: " + diffHours + " hours " + diffMinutes + " minutes" + diffSeconds + " seconds ");
//
//                handler.postDelayed(this, 1000); // Update every second
//            }
//        };
//
//        handler.post(updateTimeRunnable);
//    }
private void updateRemainingTime(final int hour, final int minute, final String amPm) {
    // Convert to 24-hour format
    int adjustedHour = hour;
    if (amPm.equals("PM") && hour != 12) {
        adjustedHour += 12;
    } else if (amPm.equals("AM") && hour == 12) {
        adjustedHour = 0;
    }

    // Create a Calendar object for the reminder time
    final Calendar reminderTime = Calendar.getInstance();
    reminderTime.set(Calendar.HOUR_OF_DAY, adjustedHour);
    reminderTime.set(Calendar.MINUTE, minute);
    reminderTime.set(Calendar.SECOND, 0);

    // Remove any previous runnable to prevent multiple timers
    if (updateTimeRunnable != null) {
        handler.removeCallbacks(updateTimeRunnable);
    }

    // Real-time update of remaining time
    updateTimeRunnable = new Runnable() {
        @Override
        public void run() {
            Calendar now = Calendar.getInstance();

            if (reminderTime.before(now)) {
                reminderTime.add(Calendar.DATE, 1);
            }

            long diffMillis = reminderTime.getTimeInMillis() - now.getTimeInMillis();
            long diffSeconds = (diffMillis / 1000) % 60; // Gets the seconds part
            long diffHours = diffMillis / (60 * 60 * 1000);
            long diffMinutes = (diffMillis / (60 * 1000)) % 60;

            remainingTimeTextView.setText("Remaining time: " + diffHours + " hours " + diffMinutes + " minutes " + diffSeconds + " seconds ");

            handler.postDelayed(this, 1000); // Update every second
        }
    };

    handler.post(updateTimeRunnable);
}

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Remove any pending updates to prevent memory leaks
        handler.removeCallbacks(updateTimeRunnable);
    }

}
