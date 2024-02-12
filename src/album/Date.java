//@author Omkar Kadam, Colin Lee

package album;
import java.util.Calendar;
import java.text.DecimalFormat;

public class Date implements Comparable<Date> {
    public static final int QUADRENNIAL = 4;
    public static final int CENTENNIAL = 100;
    public static final int QUATERCENTENNIAL = 400;
    public static final int THIRTYONE = 31;
    public static final int THIRTY = 30;

    private int year;
    private int month;
    private int day;

    public Date(int year, int month, int day){
        this.year = year;
        this.month = month;
        this.day = day;
    }

    //today or a future date. use Calendar class
    public boolean isValid(){
        if(this.getMonth() <= 12 && isDay() && this.getYear() >= 1900){
            return true;
        }
        return false;
    } //check if the date is a valid calendar date

    private boolean isDay(){
        int days = 0;
        switch(this.getMonth()){
            case 1:
                days = THIRTYONE;
            case 2:
                days = 28;
            case 3:
                days = THIRTY;
            case 4:
                days = THIRTYONE;
            case 5:
                days = THIRTY;
            case 6:
                days = THIRTYONE;
            case 7:
                days = THIRTY;
            case 8:
                days = THIRTYONE;
            case 9:
                days = THIRTY;
            case 10:
                days = THIRTYONE;
            case 11:
                days = THIRTY;
            case 12:
                days = THIRTYONE;
        }
        if(this.getDay() <= days)
            return true;
        return false;
    }

    @Override
    public int compareTo(Date o) {
        return 0;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setDay(int day) {
        this.day = day;
    }
}