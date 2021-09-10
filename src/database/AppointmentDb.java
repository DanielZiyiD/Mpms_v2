package database;

import connector.DbConnector;
import model.Appointment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class AppointmentDb {
    private ArrayList<Appointment> appointments;
    private DbConnector dbConnector;

    public AppointmentDb() {
        appointments = new ArrayList<>();
        dbConnector = new DbConnector();
    }

    public AppointmentDb(ArrayList<Appointment> appointments, DbConnector dbConnector) {
        this.appointments = appointments;
        this.dbConnector = dbConnector;
    }

    public void fetch() {
        dbConnector.setFileName("Appointment.txt");
        dbConnector.setHasHeader(true);
        ArrayList<String> lines = dbConnector.readDataFromFile();
        for (String line : lines)
        {
            // AppointmentId,PatientId,BranchId,GpId,ReasonId,AppDateTime
            // 1,1,1,1,1,2021/09/10 10:00
            String[] lineArray = line.split(",");
            Appointment appointment = new Appointment();
            appointment.setAppointmentId(Integer.parseInt(lineArray[0]));
            appointment.setPatientId(Integer.parseInt(lineArray[1]));
            appointment.setBranchId(Integer.parseInt(lineArray[2]));
            appointment.setGpId(Integer.parseInt(lineArray[3]));
            appointment.setReasonId(Integer.parseInt(lineArray[4]));
            // Date DateFormat
            try {
                Date date = new SimpleDateFormat("yyyy/MM/dd HH:mm").parse(lineArray[5]);
                appointment.setAppDateTime(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            appointments.add(appointment);
        }
    }

    public HashMap<Integer, Integer> generateReasonReport(Date startDate, Date endDate) {
        // {1: 2, 2: 3}
        HashMap<Integer, Integer> resultMap = new HashMap<>();
        for (Appointment appointment : appointments)
        {
            Date appDate = appointment.getAppDateTime();
            // (appDate >= startDate) && (appDate <= endDate)
            if ((appDate.after(startDate) || appDate.equals(startDate))
                    && (appDate.before(endDate) || appDate.equals(endDate)))
            {
                int reasonId = appointment.getReasonId();
                if (resultMap.get(reasonId) != null)
                {
                    int count = resultMap.get(reasonId);
                    count += 1;
                    resultMap.replace(reasonId, count);
                }
                else
                    resultMap.put(appointment.getReasonId(), 1);
            }
        }

        return resultMap;
    }

    public ArrayList<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(ArrayList<Appointment> appointments) {
        this.appointments = appointments;
    }

    public DbConnector getDbConnector() {
        return dbConnector;
    }

    public void setDbConnector(DbConnector dbConnector) {
        this.dbConnector = dbConnector;
    }
}
