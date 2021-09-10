import database.AppointmentDb;
import database.ReasonDb;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

public class Mpms {
    private AppointmentDb appointmentDb;
    private ReasonDb reasonDb;

    public static void main(String[] args) {
        Mpms mpms = new Mpms();
        mpms.start();
        System.out.println();
    }

    public Mpms() {
        appointmentDb = new AppointmentDb();
        reasonDb = new ReasonDb();
    }

    public void start()
    {
        appointmentDb.fetch();
        reasonDb.fetch();
        generateReport();
    }

    public void generateReport() {
        System.out.println("Please enter the start date (Year/Month/Date e.g 1990/01/01):");
        Scanner scanner = new Scanner(System.in);
        String startDateStr = scanner.nextLine();
        System.out.println("Please enter the end date (Year/Month/Date e.g 1990/01/01):");
        String endDateStr = scanner.nextLine();
        try {
            Date startDate = new SimpleDateFormat("yyyy/MM/dd").parse(startDateStr);
            Date endDate = new SimpleDateFormat("yyyy/MM/dd").parse(endDateStr);
            HashMap<Integer, Integer> resultMap = appointmentDb.generateReasonReport(startDate, endDate);
            int resultSum = 0;
            for (Integer integer : resultMap.values())
                resultSum += integer;

            for (int i = 0; i < reasonDb.getReasons().size(); i++)
                System.out.println(reasonDb.getReasons().get(i).getType()
                        + ": " + (resultMap.get(i + 1) * 1.0)/resultSum * 100 + "%");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
