import java.util.HashMap;

public class DateFormat {
    public static void main(String args[]) {
        String A = "25th Apr 2217";
        System.out.println(dateFormat(A));
    }

    public static String dateFormat(String A) {
        HashMap<String, String> days = new HashMap<>();
        days.put("1st", "01");
        days.put("2nd", "02");
        days.put("3rd", "03");
        days.put("4th", "04");
        days.put("5th", "05");
        days.put("6th", "06");
        days.put("7th", "07");
        days.put("8th", "08");
        days.put("9th", "09");
        days.put("10th", "10");
        days.put("11th", "11");
        days.put("12th", "12");
        days.put("13th", "13");
        days.put("14th", "14");
        days.put("15th", "15");
        days.put("16th", "16");
        days.put("17th", "17");
        days.put("18th", "18");
        days.put("19th", "19");
        days.put("20th", "20");
        days.put("21th", "21");
        days.put("22th", "22");
        days.put("23th", "23");
        days.put("24th", "24");
        days.put("25th", "25");
        days.put("26th", "26");
        days.put("27th", "27");
        days.put("28th", "28");
        days.put("29th", "29");
        days.put("30th", "30");
        days.put("31th", "31");

        HashMap<String, String> month = new HashMap<>();
        month.put("Jan", "01");
        month.put("Feb", "02");
        month.put("Mar", "03");
        month.put("Apr", "04");
        month.put("May", "05");
        month.put("Jun", "06");
        month.put("Jul", "07");
        month.put("Aug", "08");
        month.put("Sep", "09");
        month.put("Oct", "10");
        month.put("Nov", "11");
        month.put("Dec", "12");

        String[] date = A.split(" ", 3);
        String formattedDate = new String();

        for (int i = 2; i >= 0; i--) {
            String curr = date[i];
            if (i == 1) {
                curr = month.get(curr);
                formattedDate = formattedDate + "-" + curr;
            } else if (i == 0) {
                curr = days.get(curr);
                formattedDate = formattedDate + "-" + curr;
            } else {
                formattedDate = curr;
            }
        }

        return formattedDate;
    }
}
