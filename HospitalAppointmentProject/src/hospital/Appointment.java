package hospital;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Appointment {

    private String appointmentId;
    private Patient patient;
    private Doctor doctor;
    private LocalDateTime dateTime;
    private boolean cancelled;

    public Appointment(String appointmentId,
                       Patient patient,
                       Doctor doctor,
                       LocalDateTime dateTime) {

        this.appointmentId = appointmentId;
        this.patient = patient;
        this.doctor = doctor;
        this.dateTime = dateTime;
        this.cancelled = false;
    }

    public String getAppointmentId() {
        return appointmentId;
    }

    public Patient getPatient() {
        return patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public boolean isCancelled() {
        return cancelled;
    }

    public void cancel() {
        cancelled = true;
    }

    public String toString() {

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

        return "Appointment ID: " + appointmentId
                + " | Patient: " + patient.getName()
                + " | Doctor: Dr. " + doctor.getName()
                + " | Date & Time: " + dateTime.format(formatter)
                + " | Status: "
                + (cancelled ? "Cancelled" : "Booked");
    }
}