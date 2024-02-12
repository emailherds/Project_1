//@author Omkar Kadam, Colin Lee

package album;
import java.util.Calendar;
import java.text.DecimalFormat;
import java.util.Queue;

public class Date implements Comparable<Date> {
    public static final int QUADRENNIAL = 4;
    public static final int CENTENNIAL = 100;
    public static final int QUATERCENTENNIAL = 400;
    public static final int THIRTYONE = 31;
    public static final int THIRTY = 30;

    private int year;
    private int month;
    private int day;

    public Date(int month, int day, int year)  {
        setMonth(month);
        setDay(day);
        setYear(year);
    }

    public static void main(String[]args){
//        Date date = new Date(03, 30,2004);
//        System.out.println("Valid? :"+date.isValid());
        Date date2 = new Date(03, 29,2004);
//        System.out.println("Comparison: "+date.compareTo(date2));
        System.out.println("Current: "+ date2.currentTime().getMonth());
    }

    //today or a future date. use Calendar class
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
        if(this.getMonth() > 0 && this.getMonth() <= 12 && isDay(leap) && this.getYear() >= 0){
            return true;
        }
        return false;
    } //check if the date is a valid calendar date

    public Date currentTime(){
        Calendar calendar = Calendar.getInstance();
        return new Date(calendar.get(Calendar.MONTH)+1, calendar.get(Calendar.DAY_OF_MONTH),calendar.get(Calendar.YEAR));
    }

    private boolean isDay(boolean leap){
        int days = 0;
        int february = 0;
        if(leap)
            february = 29;
        else
            february = 28;
        switch(this.getMonth()){
            case 1:
                days = THIRTYONE;
                break;
            case 2:
                days = february;
                break;
            case 3:
                days = THIRTY;
                break;
            case 4:
                days = THIRTYONE;
                break;
            case 5:
                days = THIRTY;
                break;
            case 6:
                days = THIRTYONE;
                break;
            case 7:
                days = THIRTY;
                break;
            case 8:
                days = THIRTYONE;
                break;
            case 9:
                days = THIRTY;
                break;
            case 10:
                days = THIRTYONE;
                break;
            case 11:
                days = THIRTY;
                break;
            case 12:
                days = THIRTYONE;
                break;
        }
        if(this.getDay() <= days && this.getDay() > 0)
            return true;
        return false;
    }

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