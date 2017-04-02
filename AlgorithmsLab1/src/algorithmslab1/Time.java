package algorithmslab1;

import java.util.Scanner;

/**
 *
 * @author Oona
 */
public class Time implements Comparable<Time> {

    private Scanner scanner;
    private String time;
    private int hours;
    private int minutes;

    public Time() {
        scanner = new Scanner(System.in);
    }
    
    public Time(int hours, int minutes) {
        this.hours = hours;
        this.minutes = minutes;
    }

    //ask and read user input
    //parse the reply and save hours and minutes into variables
    public void read(String question) {
        String delims = "[:]+";
        String[] tokens;

        System.out.print(question);
        time = scanner.nextLine();
        tokens = time.split(delims);
        hours = Integer.parseInt(tokens[0]);
        minutes = Integer.parseInt(tokens[1]);
    }

    //compare 2 Time objects: this and the given one
    //return false if the given time is earlier
    public boolean lessThan(Time time2) {
        if (this.hours >= time2.hours && this.minutes >= time2.minutes) {
            return false;
        } else if (this.hours > time2.hours && this.minutes < time2.minutes) {
            return false;
        } else {
            return true;
        }
    }

    //compare the two Time objects and calculate the difference (=duration)
    //return new Time object that is the duration
    public Time subtract(Time timeToSubtract) {

        //copying the time values so that we can use them for calculating the difference
        int hoursToCompare = timeToSubtract.hours;
        int minutesToCompare = timeToSubtract.minutes;

        int minuteCounter = 0;

        Time timeToReturn = new Time();
        int durationHours = 0;
        int durationMinutes = 0;

        //adding minutes to the counter until the 2 times we're comparing are equal
        while (this.hours > hoursToCompare) {
            minuteCounter++;
            if (minutesToCompare < 59) {
                minutesToCompare++;
            } else {
                minutesToCompare = 0;
                hoursToCompare++;
            }
        }
        while (this.hours == hoursToCompare && this.minutes != minutesToCompare) {
            minuteCounter++;
            if (minutesToCompare < 59) {
                minutesToCompare++;
            } else {
                minutesToCompare = 0;
                hoursToCompare++;
            }
        }

        //dividing the counter minutes into hours and minutes and saving to a new Time object
        durationHours = minuteCounter / 60;
        durationMinutes = minuteCounter - (durationHours * 60);
        timeToReturn.hours = durationHours;
        timeToReturn.minutes = durationMinutes;

        return timeToReturn;
    }

    //print out/display the duration
    public void print() {
        System.out.format("%02d:%02d", this.hours, this.minutes);
    }

    public int getMinutes() {
        return this.minutes;
    }

    public int getHours() {
        return this.hours;
    }

    @Override
    public int compareTo(Time otherTime) {
        if(Integer.compare(this.hours, otherTime.hours) == 0 && Integer.compare(this.minutes, otherTime.minutes) == 0) {
            return 0;
        } else if(this.lessThan(otherTime)) {
            return -1;
        } else return 1;
        
    }

    @Override
    public String toString() {
        String formattedTime = String.format("%02d:%02d", this.hours, this.minutes);
        return formattedTime;
    }
    
    
}
