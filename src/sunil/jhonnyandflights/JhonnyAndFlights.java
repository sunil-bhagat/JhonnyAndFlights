package sunil.jhonnyandflights;

/**
 * @author Sunil Bhagat
 */

import java.util.Calendar;
import java.util.Scanner;


class Solution{

    /**
     * converts months in to numbers
     * @param month name of month
     * @return
     * @throws Exception
     */
    public static int convertMonth(String month) throws Exception{
        switch (month) {
            case "January":
                return 0;
            case "February":
                return 1;
            case "March":
                return 2;
            case "April":
                return 3;
            case "May":
                return 4;
            case "June":
                return 5;
            case "July":
                return 6;
            case "August":
                return 7;
            case "September":
                return 8;
            case "October":
                return 9;
            case "November":
                return 10;
            case "December":
                return 11;
            default:
                throw  new Exception("Invalid Month format");
        }

    }
    public static  Calendar getFirstMonday(int year, int month){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_WEEK,Calendar.MONDAY);
        calendar.set(Calendar.DAY_OF_WEEK_IN_MONTH,1);
        calendar.set(Calendar.MONTH,month);
        calendar.set(Calendar.YEAR,year);
        return calendar;
    }
    public static Calendar getLastSunday(int year,int month){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_WEEK,Calendar.SUNDAY);
        calendar.set(Calendar.DAY_OF_WEEK_IN_MONTH,1);
        calendar.set(Calendar.MONTH,month+1);
        calendar.set(Calendar.YEAR,year);
        calendar.add(Calendar.WEEK_OF_MONTH,-1);
        return calendar;
    }

    /**
     * return the number of weeks between visiting and returning Dates.
     * @param visitingYear
     * @param startMonth
     * @param endMonth
     * @param firstDay
     * @return
     */
    public int solution(int visitingYear, String startMonth, String endMonth, String firstDay){

        Calendar visitingDate = Calendar.getInstance();
        Calendar returningDate= Calendar.getInstance();
        try {
            visitingDate = getFirstMonday(visitingYear,convertMonth(startMonth));
            returningDate = getLastSunday(visitingYear,convertMonth(endMonth));
        }catch (Exception e){
            System.out.println(e);
        }

        int weeks = returningDate.get(Calendar.WEEK_OF_YEAR)-visitingDate.get(Calendar.WEEK_OF_YEAR);
        return weeks;
    }

}
public class JhonnyAndFlights {

    public static void main(String[] args){
        int visitingYear;
        String startMonth,endMonth,firstDay;
        Scanner scan = new Scanner(System.in);
        visitingYear = scan.nextInt();
        scan.nextLine();
        startMonth=scan.nextLine();
        endMonth=scan.nextLine();
        firstDay=scan.nextLine();
        Solution solution1= new Solution();
        int weeks=  solution1.solution(visitingYear,startMonth,endMonth,firstDay);
        System.out.println(weeks);
    }
}
