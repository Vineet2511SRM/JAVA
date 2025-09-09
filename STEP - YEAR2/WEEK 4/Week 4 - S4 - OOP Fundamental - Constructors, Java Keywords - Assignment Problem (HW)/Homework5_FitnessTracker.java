/**
 * Program Name: Homework5_FitnessTracker.java
 * Author: Vineet Seth
 * Description: Fitness Tracker App simulation demonstrating constructor overloading
 * and displaying workout details.
 */

class Workout {
    private String activityName;
    private int durationInMinutes;
    private int caloriesBurned;

    // 1. Default constructor
    public Workout() {
        this("Walking", 30, 100);
    }

    // 2. Constructor with activity name
    public Workout(String activityName) {
        this(activityName, 30); // default duration 30 mins
    }

    // 3. Constructor with activity and duration
    public Workout(String activityName, int durationInMinutes) {
        this.activityName = activityName;
        this.durationInMinutes = durationInMinutes;
        this.caloriesBurned = durationInMinutes * 5; // calories formula
    }

    // Full constructor (internal use)
    public Workout(String activityName, int durationInMinutes, int caloriesBurned) {
        this.activityName = activityName;
        this.durationInMinutes = durationInMinutes;
        this.caloriesBurned = caloriesBurned;
    }

    // Display workout details
    public void displayWorkout() {
        System.out.println("------- Workout Details -------");
        System.out.println("Activity: " + activityName);
        System.out.println("Duration: " + durationInMinutes + " mins");
        System.out.println("Calories Burned: " + caloriesBurned + " cal");
        System.out.println("--------------------------------\n");
    }
}

// Main class
public class Homework5_FitnessTracker {
    public static void main(String[] args) {
        // Create workouts using different constructors
        Workout w1 = new Workout(); // default
        Workout w2 = new Workout("Running"); // activity only
        Workout w3 = new Workout("Cycling", 45); // activity + duration

        // Display workouts
        w1.displayWorkout();
        w2.displayWorkout();
        w3.displayWorkout();
    }
}
