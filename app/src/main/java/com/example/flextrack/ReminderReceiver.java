//package com.example.flextrack;
////package com.example.flextrack;
////
////import android.content.BroadcastReceiver;
////import android.content.Context;
////import android.content.Intent;
////import android.app.NotificationChannel;
////import android.app.NotificationManager;
////import android.app.PendingIntent;
////import androidx.core.app.NotificationCompat;
////
////public class ReminderReceiver extends BroadcastReceiver {
////
////    @Override
////    public void onReceive(Context context, Intent intent) {
////        sendNotification(context);
////    }
////
////    private void sendNotification(Context context) {
////        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
////        String channelId = "exercise_reminder_channel";
////        CharSequence channelName = "Exercise Reminder Channel";
////        int importance = NotificationManager.IMPORTANCE_HIGH;
////
////        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
////            NotificationChannel notificationChannel = new NotificationChannel(channelId, channelName, importance);
////            notificationManager.createNotificationChannel(notificationChannel);
////        }
////
////        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, channelId)
////                .setSmallIcon(R.drawable.ic_notification)
////                .setContentTitle("Exercise Reminder")
////                .setContentText("Your exercise time for the next day has started!")
////                .setPriority(NotificationCompat.PRIORITY_HIGH)
////                .setAutoCancel(true);
////
////        Intent notificationIntent = new Intent(context, MainActivity.class);
////        PendingIntent contentIntent = PendingIntent.getActivity(context, 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);
////        builder.setContentIntent(contentIntent);
////
////        notificationManager.notify(0, builder.build());
////    }
////}
//import android.app.NotificationChannel;
//import android.app.NotificationManager;
//import android.app.PendingIntent;
//import android.content.BroadcastReceiver;
//import android.content.Context;
//import android.content.Intent;
//import android.os.Build;
//import androidx.core.app.NotificationCompat;
//
//public class ReminderReceiver extends BroadcastReceiver {
//    @Override
//    public void onReceive(Context context, Intent intent) {
//        // Show notification
//        showNotification(context);
//    }
//
//    private void showNotification(Context context) {
//        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
//        String channelId = "reminder_channel_id";
//
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            NotificationChannel channel = new NotificationChannel(channelId, "Daily Reminder", NotificationManager.IMPORTANCE_HIGH);
//            notificationManager.createNotificationChannel(channel);
//        }
//
//        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, channelId)
//                .setSmallIcon(R.drawable.ic_notification)
//                .setContentTitle("Exercise Reminder")
//                .setContentText("It's time for your exercise!")
//                .setPriority(NotificationCompat.PRIORITY_HIGH);
//
//        notificationManager.notify(1, builder.build());
//    }
//}
