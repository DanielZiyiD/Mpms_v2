package model;

import java.util.Date;

public class Appointment {
    private int appointmentId;
    private int patientId;
    private int branchId;
    private int gpId;
    private int reasonId;
    private Date appDateTime;

    public Appointment() {

    }

    public Appointment(int appointmentId, int patientId, int branchId, int gpId, int reasonId, Date appDateTime) {
        this.appointmentId = appointmentId;
        this.patientId = patientId;
        this.branchId = branchId;
        this.gpId = gpId;
        this.reasonId = reasonId;
        this.appDateTime = appDateTime;
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }

    public int getGpId() {
        return gpId;
    }

    public void setGpId(int gpId) {
        this.gpId = gpId;
    }

    public int getReasonId() {
        return reasonId;
    }

    public void setReasonId(int reasonId) {
        this.reasonId = reasonId;
    }

    public Date getAppDateTime() {
        return appDateTime;
    }

    public void setAppDateTime(Date appDateTime) {
        this.appDateTime = appDateTime;
    }
}
