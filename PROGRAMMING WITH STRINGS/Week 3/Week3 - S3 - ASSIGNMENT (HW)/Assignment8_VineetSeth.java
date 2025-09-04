/**
 * Assignment8_HospitalManagement.java
 * Author: Vineet Seth
 * Description: Hospital Patient Management System with appointments, treatments,
 * billing, and reporting. Includes JavaDoc and error handling.
 */

import java.util.*;

/**
 * Represents a patient in the hospital.
 */
class Patient {
    private String patientId, patientName, gender, contactInfo;
    private int age;
    private List<String> medicalHistory = new ArrayList<>();
    private List<String> currentTreatments = new ArrayList<>();

    static int totalPatients = 0;
    static String hospitalName = "City Care Hospital";

    /**
     * Constructs a new Patient.
     * @param id Patient ID
     * @param name Patient name
     * @param age Patient age
     * @param gender Patient gender
     * @param contact Patient contact info
     */
    public Patient(String id, String name, int age, String gender, String contact) {
        this.patientId = id;
        this.patientName = name;
        this.age = age;
        this.gender = gender;
        this.contactInfo = contact;
        totalPatients++;
    }

    /**
     * Adds a medical history entry.
     * @param history History description
     */
    public void addMedicalHistory(String history) {
        medicalHistory.add(history);
    }

    /**
     * Adds a treatment to the patient's current treatments.
     * @param treatment Treatment description
     */
    public void addTreatment(String treatment) {
        currentTreatments.add(treatment);
    }

    /**
     * Discharges the patient by clearing current treatments.
     */
    public void dischargePatient() {
        currentTreatments.clear();
        System.out.println(patientName + " has been discharged.");
    }

    public String getPatientName() { return patientName; }
    public List<String> getCurrentTreatments() { return currentTreatments; }

    @Override
    public String toString() {
        return patientName + " (ID: " + patientId + ") | Age: " + age + " | Gender: " + gender;
    }
}

/**
 * Represents a doctor in the hospital.
 */
class Doctor {
    private String doctorId, doctorName, specialization;
    private List<String> availableSlots = new ArrayList<>();
    private int patientsHandled = 0;
    private double consultationFee;

    /**
     * Constructs a new Doctor.
     * @param id Doctor ID
     * @param name Doctor name
     * @param specialization Doctor specialization
     * @param fee Consultation fee
     * @param slots Available time slots
     */
    public Doctor(String id, String name, String specialization, double fee, String[] slots) {
        this.doctorId = id;
        this.doctorName = name;
        this.specialization = specialization;
        this.consultationFee = fee;
        availableSlots.addAll(Arrays.asList(slots));
    }

    /**
     * Books a time slot for an appointment.
     * @param slot Desired slot
     * @return true if booked
     * @throws Exception if slot is unavailable
     */
    public boolean bookSlot(String slot) throws Exception {
        if (!availableSlots.contains(slot)) {
            throw new Exception("Slot " + slot + " not available for Dr. " + doctorName);
        }
        availableSlots.remove(slot);
        patientsHandled++;
        return true;
    }

    public double getConsultationFee() { return consultationFee; }
    public String getDoctorName() { return doctorName; }
    public int getPatientsHandled() { return patientsHandled; }
}

/**
 * Represents a hospital appointment.
 */
class Appointment {
    private String appointmentId;
    private Patient patient;
    private Doctor doctor;
    private String appointmentDate, appointmentTime;
    private String status; // Scheduled, Completed, Cancelled
    private String type;   // Consultation, Follow-up, Emergency
    private double billingAmount;

    static int totalAppointments = 0;
    static double totalRevenue = 0;

    /**
     * Constructs an Appointment.
     * @param id Appointment ID
     * @param p Patient
     * @param d Doctor
     * @param date Appointment date
     * @param time Appointment time
     * @param type Appointment type
     */
    public Appointment(String id, Patient p, Doctor d, String date, String time, String type) {
        this.appointmentId = id;
        this.patient = p;
        this.doctor = d;
        this.appointmentDate = date;
        this.appointmentTime = time;
        this.status = "Scheduled";
        this.type = type;
        totalAppointments++;
    }

    /**
     * Schedule the appointment with error handling.
     */
    public void schedule() {
        try {
            if (!status.equals("Scheduled")) {
                throw new Exception("Cannot schedule an appointment with status: " + status);
            }
            doctor.bookSlot(appointmentTime);
            System.out.println("Appointment " + appointmentId + " scheduled for " + patient.getPatientName() +
                    " with Dr. " + doctor.getDoctorName() + " at " + appointmentTime);
        } catch (Exception e) {
            System.out.println("Error scheduling appointment: " + e.getMessage());
            status = "Failed";
        }
    }

    /**
     * Cancels the appointment.
     */
    public void cancel() {
        if (status.equals("Completed")) {
            System.out.println("Cannot cancel a completed appointment.");
            return;
        }
        status = "Cancelled";
        System.out.println("Appointment " + appointmentId + " cancelled.");
    }

    /**
     * Generate billing based on appointment type.
     */
    public void generateBill() {
        if (!status.equals("Scheduled")) {
            System.out.println("Cannot generate bill. Appointment status: " + status);
            return;
        }
        double rate = doctor.getConsultationFee();
        switch (type.toLowerCase()) {
            case "follow-up": rate *= 0.5; break;
            case "emergency": rate *= 1.5; break;
        }
        billingAmount = rate;
        totalRevenue += billingAmount;
        status = "Completed";
        System.out.println("Billing for " + patient.getPatientName() + ": ₹" + billingAmount);
    }

    /**
     * Updates patient's treatment.
     * @param treatment Treatment description
     */
    public void updateTreatment(String treatment) {
        if (status.equals("Cancelled")) {
            System.out.println("Cannot update treatment. Appointment is cancelled.");
            return;
        }
        patient.addTreatment(treatment);
        System.out.println("Treatment '" + treatment + "' added for " + patient.getPatientName());
    }

    public String getStatus() { return status; }
}

/**
 * Utility class for hospital management reporting.
 */
class HospitalManagement {
    /**
     * Generates hospital report for patients and doctors.
     */
    public static void generateHospitalReport(Patient[] patients, Doctor[] doctors) {
        System.out.println("\n--- Hospital Report ---");
        System.out.println("Hospital: " + Patient.hospitalName);
        System.out.println("Total Patients: " + Patient.totalPatients);
        System.out.println("Total Appointments: " + Appointment.totalAppointments);
        System.out.println("Total Revenue: ₹" + Appointment.totalRevenue);

        System.out.println("\nDoctors:");
        for (Doctor d : doctors) {
            System.out.println(d.getDoctorName() + " | Patients Handled: " + d.getPatientsHandled());
        }

        System.out.println("\nPatients and Current Treatments:");
        for (Patient p : patients) {
            System.out.println(p.getPatientName() + " | Treatments: " + p.getCurrentTreatments());
        }
    }

    /**
     * Prints utilization for each doctor.
     */
    public static void getDoctorUtilization(Doctor[] doctors) {
        System.out.println("\n--- Doctor Utilization ---");
        for (Doctor d : doctors) {
            System.out.println(d.getDoctorName() + " handled " + d.getPatientsHandled() + " patients.");
        }
    }

    /**
     * Prints statistics for each patient.
     */
    public static void getPatientStatistics(Patient[] patients) {
        System.out.println("\n--- Patient Statistics ---");
        for (Patient p : patients) {
            System.out.println(p.getPatientName() + " | Current Treatments: " + p.getCurrentTreatments().size());
        }
    }
}

/**
 * Main class to test Hospital Management System.
 */
public class Assignment8_VineetSeth {
    public static void main(String[] args) {
        // Patients
        Patient p1 = new Patient("P001", "Aarav", 30, "Male", "9999999999");
        Patient p2 = new Patient("P002", "Riya", 25, "Female", "8888888888");
        Patient p3 = new Patient("P003", "Soham", 40, "Male", "7777777777");

        p1.addMedicalHistory("Diabetes");
        p2.addMedicalHistory("Asthma");
        p3.addMedicalHistory("Hypertension");

        // Doctors
        Doctor d1 = new Doctor("D001", "Dr. Mehta", "Cardiology", 1000, new String[]{"10AM", "11AM"});
        Doctor d2 = new Doctor("D002", "Dr. Sharma", "General", 500, new String[]{"10AM", "12PM"});
        Doctor d3 = new Doctor("D003", "Dr. Verma", "Orthopedics", 800, new String[]{"9AM", "11AM"});

        // Appointments
        Appointment a1 = new Appointment("A001", p1, d1, "2025-09-10", "10AM", "Consultation");
        Appointment a2 = new Appointment("A002", p2, d2, "2025-09-10", "12PM", "Follow-up");
        Appointment a3 = new Appointment("A003", p3, d3, "2025-09-11", "11AM", "Emergency");

        a1.schedule();
        a2.schedule();
        a3.schedule();

        a1.updateTreatment("Blood Pressure Check");
        a2.updateTreatment("Inhaler Prescription");
        a3.updateTreatment("Fracture Fixing");

        a1.generateBill();
        a2.generateBill();
        a3.generateBill();

        p2.dischargePatient();

        HospitalManagement.generateHospitalReport(new Patient[]{p1, p2, p3}, new Doctor[]{d1, d2, d3});
        HospitalManagement.getDoctorUtilization(new Doctor[]{d1, d2, d3});
        HospitalManagement.getPatientStatistics(new Patient[]{p1, p2, p3});
    }
}
