package hospital;

import java.util.ArrayList;

public class Doctor {

    private int doctorId;
    private String name;
    private String specialization;
    private ArrayList<String> slots;

    public Doctor(int doctorId, String name, String specialization) {
        this.doctorId = doctorId;
        this.name = name;
        this.specialization = specialization;
        this.slots = new ArrayList<String>();
    }

    public int getDoctorId() {
        return doctorId;
    }

    public String getName() {
        return name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public ArrayList<String> getSlots() {
        return slots;
    }

    public void addSlot(String slot) {
        slots.add(slot);
    }

    public String toString() {
        return "Doctor ID: " + doctorId
                + " | Dr. " + name
                + " | Specialization: " + specialization;
    }
}