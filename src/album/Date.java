/**
 Date class which contains month, day, and year of a date and checks if the date is valid and compares two dates
 @author Omkar Kadam, Colin Lee
 */

package album;
import java.util.Calendar;

public class Date implements Comparable<Date> {
    public static final int QUADRENNIAL = 4;
    public static final int CENTENNIAL = 100;
    public static final int QUATERCENTENNIAL = 400;
    public static final int THIRTYONE = 31;
    public static final int THIRTY = 30;

    private int year;
    private int month;
    private int day;

    /**
     Constructor for Date class
     @param month month of the date
     @param day day of the month for the date
     @param year year of the date
     */
    public Date(int month, int day, int year)  {
        setMonth(month);
        setDay(day);
        setYear(year);
    }

    public static void main(String[]args){
        Date date = new Date(11, 32,2006);
        Date date2 = new Date(13, 21,2000);
        Date date3 = new Date(2, 12,2024);
        Date date4 = new Date(2, 22,2024);
        Date date5 = new Date(11, 21,800);
        Date date6 = new Date(11, 21,2000);
        Date date7 = new Date(3, 5,2012);
        System.out.println("Valid? :"+date.isValid());
        System.out.println("Valid? :"+date2.isValid());
        System.out.println("Valid? :"+date3.isValid());
        System.out.println("Valid? :"+date4.isValid());
        System.out.println("Valid? :"+date5.isValid());
        System.out.println("Valid? :"+date6.isValid());
        System.out.println("Valid? :"+date7.isValid());
    }

    /**
     isValid() checks if the current date is a valid date
     @return true or false if the date is valid or not
     */
    public boolean isValid(){
        boolean leap = false;
        if(this.getYear() % QUADRENNIAL == 0){
            if(this.getYear() % CENTENNIAL == 0) {
                if(this.getYear() % QUATERCENTENNIAL == 0){
                    leap = true;
                }
            }else{
                leap = true;
            }
        }
        if(this.getMonth() > 0 && this.getMonth() <= 12 && isDay(leap) && this.getYear() >= 1900){
            if(this.compareTo(currentTime()) < 0)
                return true;
        }
        return false;
    } //check if the date is a valid calendar date

    /**
     currentTime uses the calendar class to find the current date
     @return the current date
     */
    public Date currentTime(){
        Calendar calendar = Calendar.getInstance();
        return new Date(calendar.get(Calendar.MONTH)+1, calendar.get(Calendar.DAY_OF_MONTH),calendar.get(Calendar.YEAR));
    }

    /**
     isDay checks whether a day is a valid day based on which month it is. It also accounts for leap years.
     @param leap whether the current year is a leap year
     @return true or false if the day exists in the month
     */
    private boolean isDay(boolean leap){
        int days = 0;
        int february;
        if(leap)
            february = 29;
        else
            february = 28;
        days = switch (this.getMonth()) {
            case 1 -> THIRTYONE;
            case 2 -> february;
            case 3 -> THIRTYONE;
            case 4, 11 -> THIRTY;
            case 5 -> THIRTYONE;
            case 6 -> THIRTY;
            case 7 -> THIRTYONE;
            case 8 -> THIRTYONE;
            case 9 -> THIRTY;
            case 10 -> THIRTYONE;
            case 12 -> THIRTYONE;
            default -> days;
        };
        if(this.getDay() <= days && this.getDay() > 0)
            return true;
        return false;
    }

    /**
     Compares two dates based on their years, months, and dates
     @param o the date to be compared.
     @return 0 if the dates are equal, -1 if the first date is before the compared date, 1 if the first date is after the compared date
     */
    @Override
    public int compareTo(Date o) {
        if(this.getYear() == o.getYear()){
            if(this.getMonth() == o.getMonth()){
                if(this.getDay() == o.getDay()){
                    return 0;
                }else if(this.getDay() < o.getDay()){
                    return -1;
                }else{
                    return 1;
                }
            }else if(this.getMonth() < o.getMonth()){
                return -1;
            }else{
                return 1;
            }
        }else if(this.getYear() < o.getYear()){
            return -1;
        }
        return 1;
    }

    /**
     Prints date in mm/dd/yyyy format
     @return string of date
     */
    @Override
    public String toString() {
        return month + "/" + day + "/" + year;
    }

    /**
     Get year of date
     @return year of date
     */
    public int getYear() {
        return year;
    }

    /**
     Get month of date
     @return month of date
     */
    public int getMonth() {
        return month;
    }

    /**
     Get day of date
     @return day of date
     */
    public int getDay() {
        return day;
    }

    /**
     Set year of date
     @param year year to set for date
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     Set month of date
     @param month month to set for date
     */
    public void setMonth(int month) {
        this.month = month;
    }

    /**
     Set day of date
     @param day day to set for date
     */
    public void setDay(int day) {
        this.day = day;
    }
}