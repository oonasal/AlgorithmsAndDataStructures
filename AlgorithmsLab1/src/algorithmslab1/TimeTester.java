package algorithmslab1;

/**
 *
 * @author Oona
 */
public class TimeTester {

    public static void main(String[] args) {
        Time time1 = new Time();
        Time time2 = new Time();
        Time duration = new Time();

        //ask for 2 times in hours and minutes
        time1.read("Enter time 1: ");
        time2.read("Enter time 2: ");

        //starting time is always the earlier one of the 2
        //compare the times, subtract later from the earlier
        //and print out the starting time
        if (time1.lessThan(time2)) {
            duration = time2.subtract(time1);
            System.out.print("Starting time was ");
            time1.print();
        } else {
            duration = time1.subtract(time2);
            System.out.print("Starting time was ");
            time2.print();
        }

        //print out the duration
        System.out.print("\nDuration was ");
        duration.print();
        System.out.print("\n");
    }

}
