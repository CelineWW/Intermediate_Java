public class TestTime {
    public static void main(String[] args) {
        // Create the first Time object with current time
        Time time1 = new Time();

        // Create the second Time object with elapse time
        Time time2 = new Time(555550000);

        // Create the third Time object with hour, minute, and second
        Time time3 = new Time(5, 23, 55);

        // Display Time in hh:mm:ss format
        System.out.println("Time1 (UTC Current): " + time1.getHour() + ":" + time1.getMinute() + ":" + time1.getSecond());
        if (time1.getHour() > 7) {
            System.out.println("Time1 (PDT Current): " + (time1.getHour() - 7) + ":" + time1.getMinute() + ":" + time1.getSecond());
        }
        else {
            System.out.println("Time1 (PDT Current): " + (time1.getHour() + 17) + ":" + time1.getMinute() + ":" + time1.getSecond());
        }
        System.out.println("Time2: " + time2.getHour() + ":" + time2.getMinute() + ":" + time2.getSecond());
        System.out.println("Time3: " + time3.getHour() + ":" + time3.getMinute() + ":" + time3.getSecond());

        time3.setTime(System.currentTimeMillis() + 1000);    // current UTC time + 1 second
        System.out.println("New Time3: " + time3.getHour() + ":" + time3.getMinute() + ":" + time3.getSecond());
    }
}
