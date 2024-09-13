/**
 * - Time Class includes:
 * - data fields: hour, minute, and second
 * - constructors:
 *      - 1. A no-arg constructor that creates a Time object for the current time.
 *      - 2. A constructor that constructs a Time object with a specified elapsed time since midnight, January 1, 1970, in milliseconds.
 *      - 3. A constructor that constructs a Time object with the specified hour, minute, and second.
 * - Accessors: getter methods of hour, minute, and second.
 * - Mutators: setter methods using the elapsed time.
 *
 * @Author: Celine Wang
 * classname: CISC 191
 * @Version: 1.0
 */

public class Time {
    /** Data Field*/
    private int hour;
    private int minute;
    private int second;

    /** Construct a time with the current time by default */
    public Time() {
        this(System.currentTimeMillis());
    }

    /** Construct a time with a specified elapsed time in milliseconds since midnight, January 1, 1970. */
    public Time(long milliseconds) {
        this.second = (int)(milliseconds / 1000) % 60;
        this.minute = (int)(milliseconds / (1000 * 60)) % 60 ;
        this.hour = (int)(milliseconds / (1000 * 60 * 60)) % 24;
    }


    /** Construct a time with the specified hour, minute, and second. */
    public Time(int hour, int minute, int second){
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    // Accessors
    /** Get hour
     * @return hour
     */
    public int getHour() {
        return hour;
    }

    /** Get minute
     * @return minute
     */
    public int getMinute(){
        return minute;
    }

    /** Get second
     * @return second
     */
    public int getSecond(){
        return second;
    }

    // Mutator
    /** Set time using elapse time
     * @param elapseTime elapse time
     */
    public void setTime(long elapseTime) {
        this.second = (int)(elapseTime/ 1000) % 60;
        this.minute = (int)(elapseTime/ 1000 / 60) % 60 ;
        this.hour = (int)(elapseTime / 1000 / 60 / 60 ) % 24;
    }
}

