package other;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TimeToWords {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int hours = Integer.parseInt(reader.readLine());
        int minutes = Integer.parseInt(reader.readLine());
        reader.close();
        System.out.println(getWordsFromName(hours, minutes));
    }

    public static String getWordsFromName(int hours, int minutes) {
        String time_name = "";
        if ((hours >= 1 && hours <= 12) && (minutes >= 0 && minutes <= 59)) {
            String hour_mint[] = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
                    "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen",
                    "Twenty", "Twenty one", "Twenty two", "Twenty three", "Twenty four", "Twenty five",
                    "Twenty six", "Twenty seven", "Twenty eight", "Twenty nine"};
            String hourWord;
            if (hours == 12)
                hourWord = hour_mint[1];
            else
                hourWord = hour_mint[hours + 1];
            if (minutes == 0)
                time_name = hour_mint[hours] + " o' clock";
            else if (minutes == 15)
                time_name = "quarter past " + hour_mint[hours];
            else if (minutes == 30)
                time_name = "half past " + hour_mint[hours];
            else if (minutes == 45)
                time_name = "quarter to " + hourWord;
            else if (minutes < 30)
                time_name = hour_mint[minutes] + " minutes past " + hour_mint[hours];
            else
                time_name = hour_mint[60 - minutes] + " minutes to " + hourWord;
        } else
            time_name = "invalid time format";
        return time_name;
    }

}
