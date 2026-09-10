package hospital;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class HospitalManagementSystem {

    private Map<Integer, Patient> patients =
            new HashMap<Integer, Patient>();

    private Map<Integer, Doctor> doctors =
            new HashMap<Integer, Doctor>();

    private Map<String, Appointment> appointments =
            new HashMap<String, Appointment>();

    private DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");


    // Register Patient
    public void registerPatient(Patient patient)
            throws HospitalException {

        if (patients.containsKey(patient.getPatientId())) {
            throw new HospitalException(
                    "Patient ID already exists.");
        }

        patients.put(patient.getPatientId(), patient);

        System.out.println(
                "Patient registered successfully.");
    }


    // Add Doctor
    public void addDoctor(Doctor doctor)
            throws HospitalException {

        if (doctors.containsKey(doctor.getDoctorId())) {
            throw new HospitalException(
                    "Doctor ID already exists.");
        }

        doctors.put(doctor.getDoctorId(), doctor);

        System.out.println(
                "Doctor added successfully.");
    }


    // Add Doctor Slot
    public void addDoctorSlot(
            int doctorId, String slot)
            throws HospitalException {

        Doctor doctor = doctors.get(doctorId);

        if (doctor == null) {
            throw new HospitalException(
                    "Doctor not found.");
        }

        doctor.addSlot(slot);

        System.out.println(
                "Slot added successfully.");
    }


    // Book Appointment
    public void bookAppointment(
            int patientId,
            int doctorId,
            String slot)
            throws HospitalException {

        Patient patient = patients.get(patientId);
        Doctor doctor = doctors.get(doctorId);

        if (patient == null) {
            throw new HospitalException(
                    "Patient not found.");
        }

        if (doctor == null) {
            throw new HospitalException(
                    "Doctor not found.");
        }

        if (!doctor.getSlots().contains(slot)) {
            throw new HospitalException(
                    "This slot is not available.");
        }

        String key = doctorId + "_" + slot;

        if (appointments.containsKey(key)
                && !appointments.get(key).isCancelled()) {

            throw new HospitalException(
                    "This time slot is already booked.");
        }

        LocalDateTime dateTime;

        try {
            dateTime =
                    LocalDateTime.parse(slot, formatter);
        } catch (Exception e) {
            throw new HospitalException(
                    "Invalid date/time. Use dd-MM-yyyy HH:mm");
        }

        String appointmentId =
                "A" + (appointments.size() + 1);

        Appointment appointment =
                new Appointment(
                        appointmentId,
                        patient,
                        doctor,
                        dateTime);

        appointments.put(key, appointment);

        System.out.println(
                "Appointment booked successfully.");

        System.out.println(appointment);
    }


    // Cancel Appointment
    public void cancelAppointment(
            String appointmentId)
            throws HospitalException {

        for (Appointment appointment :
                appointments.values()) {

            if (appointment.getAppointmentId()
                    .equalsIgnoreCase(appointmentId)
                    && !appointment.isCancelled()) {

                appointment.cancel();

                System.out.println(
                        "Appointment cancelled successfully.");

                return;
            }
        }

        throw new HospitalException(
                "Active appointment not found.");
    }


    // View Available Slots
    public void viewAvailableSlots(
            int doctorId)
            throws HospitalException {

        Doctor doctor = doctors.get(doctorId);

        if (doctor == null) {
            throw new HospitalException(
                    "Doctor not found.");
        }

        System.out.println(
                "\nAvailable slots for Dr. "
                + doctor.getName() + ":");

        boolean found = false;

        for (String slot : doctor.getSlots()) {

            String key = doctorId + "_" + slot;

            if (!appointments.containsKey(key)
                    || appointments.get(key).isCancelled()) {

                System.out.println(slot);
                found = true;
            }
        }

        if (!found) {
            System.out.println(
                    "No available slots.");
        }
    }


    // View Doctor Schedule
    public void viewDoctorSchedule(
            int doctorId)
            throws HospitalException {

        Doctor doctor = doctors.get(doctorId);

        if (doctor == null) {
            throw new HospitalException(
                    "Doctor not found.");
        }

        System.out.println(
                "\nDoctor Schedule:");

        for (Appointment appointment :
                appointments.values()) {

            if (appointment.getDoctor()
                    .getDoctorId() == doctorId
                    && !appointment.isCancelled()) {

                System.out.println(appointment);
            }
        }
    }


    // View Patient History
    public void viewPatientHistory(
            int patientId)
            throws HospitalException {

        if (!patients.containsKey(patientId)) {
            throw new HospitalException(
                    "Patient not found.");
        }

        System.out.println(
                "\nPatient History:");

        boolean found = false;

        for (Appointment appointment :
                appointments.values()) {

            if (appointment.getPatient()
                    .getPatientId() == patientId) {

                System.out.println(appointment);
                found = true;
            }
        }

        if (!found) {
            System.out.println(
                    "No appointment history.");
        }
    }


    // Display Patients
    public void displayPatients() {

        System.out.println(
                "\nRegistered Patients:");

        for (Patient patient :
                patients.values()) {

            System.out.println(patient);
        }
    }


    // Display Doctors
    public void displayDoctors() {

        System.out.println("\nDoctors:");

        for (Doctor doctor :
                doctors.values()) {

            System.out.println(doctor);
        }
    }
}