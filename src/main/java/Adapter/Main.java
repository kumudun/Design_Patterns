package Adapter;

public class Main {
    public static void main(String[] args) {
        NewDateInterface dateAdapter = new CalendarToNewDateAdapter();

        // Set date: 25/12/2025
        dateAdapter.setDay(25);
        dateAdapter.setMonth(12);
        dateAdapter.setYear(2025);

        System.out.println("Initial Date: "
                + dateAdapter.getDay() + "/"
                + dateAdapter.getMonth() + "/"
                + dateAdapter.getYear());

        // Advance by 10 days
        dateAdapter.advanceDays(10);
        System.out.println("After advancing 10 days: "
                + dateAdapter.getDay() + "/"
                + dateAdapter.getMonth() + "/"
                + dateAdapter.getYear());

        // Advance by 30 days
        dateAdapter.advanceDays(30);
        System.out.println("After advancing 30 more days: "
                + dateAdapter.getDay() + "/"
                + dateAdapter.getMonth() + "/"
                + dateAdapter.getYear());
    }
}
