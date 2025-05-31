package com.example.flextrack;
//
//public class Day {
//
//    private String dayNumber;
//    private String description;
//    private int minutes;
////    private int imageResourceId; // Add this field
//
//    public Day(String dayNumber, String description, int minutes) {
//        this.dayNumber = dayNumber;
//        this.description = description;
//        this.minutes = minutes;
////        this.imageResourceId = imageResourceId;
//    }
//
//    public String getDayNumber() {
//        return dayNumber;
//    }
//
//    public void setDayNumber(String dayNumber) {
//        this.dayNumber = dayNumber;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public int getMinutes() {
//        return minutes;
//    }
//
//    public void setMinutes(int minutes) {
//        this.minutes = minutes;
//    }
//
////    public int getImageResourceId() {
////        return imageResourceId;
////    }
////
////    public void setImageResourceId(int imageResourceId) {
////        this.imageResourceId = imageResourceId;
////    }
//}
public class Day {
    private String dayNumber;
    private String description;
    private int minutes;
    private boolean isAvailable;

    public Day(String dayNumber, String description, int minutes) {
        this.dayNumber = dayNumber;
        this.description = description;
        this.minutes = minutes;
        this.isAvailable = false; // Default to unavailable
    }

    public String getDayNumber() {
        return dayNumber;
    }

    public String getDescription() {
        return description;
    }

    public int getMinutes() {
        return minutes;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
