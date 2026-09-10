package hospital;

import java.util.Scanner;

public class HospitalApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        HospitalManagementSystem system =
                new HospitalManagementSystem();

        while (true) {

            System.out.println("\n===== HOSPITAL APPOINTMENT MANAGEMENT =====");
            System.out.println("1. Register Patient");
            System.out.println("2. Add Doctor");
            System.out.println("3. Add Doctor Slot");
            System.out.println("4. Book Appointment");
            System.out.println("5. Cancel Appointment");
            System.out.println("6. View Available Slots");
            System.out.println("7. View Doctor Schedule");
            System.out.println("8. View Patient History");
            System.out.println("9. Display Patients");
            System.out.println("10. Display Doctors");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");

            try {

                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {

                case 1:

                    System.out.print("Enter Patient ID: ");
                    int patientId =
                            Integer.parseInt(sc.nextLine());

                    System.out.print("Enter Patient Name: ");
                    String patientName = sc.nextLine();

                    System.out.print("Enter Age: ");
                    int age =
                            Integer.parseInt(sc.nextLine());

                    System.out.print("Enter Phone: ");
                    String phone = sc.nextLine();

                    Patient patient =
                            new Patient(
                                    patientId,
                                    patientName,
                                    age,
                                    phone);

                    system.registerPatient(patient);

                    break;


                case 2:

                    System.out.print("Enter Doctor ID: ");
                    int doctorId =
                            Integer.parseInt(sc.nextLine());

                    System.out.print("Enter Doctor Name: ");
                    String doctorName = sc.nextLine();

                    System.out.print("Enter Specialization: ");
                    String specialization =
                            sc.nextLine();

                    Doctor doctor =
                            new Doctor(
                                    doctorId,
                                    doctorName,
                                    specialization);

                    system.addDoctor(doctor);

                    break;


                case 3:

                    System.out.print("Enter Doctor ID: ");
                    doctorId =
                            Integer.parseInt(sc.nextLine());

                    System.out.print(
                            "Enter Slot (dd-MM-yyyy HH:mm): ");

                    String slot = sc.nextLine();

                    system.addDoctorSlot(
                            doctorId,
                            slot);

                    break;


                case 4:

                    System.out.print("Enter Patient ID: ");
                    patientId =
                            Integer.parseInt(sc.nextLine());

                    System.out.print("Enter Doctor ID: ");
                    doctorId =
                            Integer.parseInt(sc.nextLine());

                    System.out.print(
                            "Enter Slot (dd-MM-yyyy HH:mm): ");

                    slot = sc.nextLine();

                    system.bookAppointment(
                            patientId,
                            doctorId,
                            slot);

                    break;


                case 5:

                    System.out.print(
                            "Enter Appointment ID: ");

                    String appointmentId =
                            sc.nextLine();

                    system.cancelAppointment(
                            appointmentId);

                    break;


                case 6:

                    System.out.print(
                            "Enter Doctor ID: ");

                    doctorId =
                            Integer.parseInt(sc.nextLine());

                    system.viewAvailableSlots(
                            doctorId);

                    break;


                case 7:

                    System.out.print(
                            "Enter Doctor ID: ");

                    doctorId =
                            Integer.parseInt(sc.nextLine());

                    system.viewDoctorSchedule(
                            doctorId);

                    break;


                case 8:

                    System.out.print(
                            "Enter Patient ID: ");

                    patientId =
                            Integer.parseInt(sc.nextLine());

                    system.viewPatientHistory(
                            patientId);

                    break;


                case 9:

                    system.displayPatients();

                    break;


                case 10:

                    system.displayDoctors();

                    break;


                case 0:

                    System.out.println(
                            "Thank you for using Hospital Management System.");

                    sc.close();

                    return;


                default:

                    System.out.println(
                            "Invalid choice. Please try again.");
                }

            } catch (NumberFormatException e) {

                System.out.println(
                        "Please enter a valid number.");

            } catch (HospitalException e) {

                System.out.println(
                        "Error: " + e.getMessage());
            }
        }
    }
}