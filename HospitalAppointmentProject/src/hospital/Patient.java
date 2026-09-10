package hospital;

public class Patient {

    private int patientId;
    private String name;
    private int age;
    private String phone;

    public Patient(int patientId, String name, int age, String phone) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.phone = phone;
    }

    public int getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPhone() {
        return phone;
    }

    public String toString() {
        return "Patient ID: " + patientId
                + " | Name: " + name
                + " | Age: " + age
                + " | Phone: " + phone;
    }
}