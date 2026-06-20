import java.util.ArrayList;
import java.time.LocalDate;

public class MedicationTrackingSystem {

    // Declare variables
    private ArrayList<Patient> patients = new ArrayList<>();
    private ArrayList<Medication> medications = new ArrayList<>();
    private ArrayList<Doctor> doctors = new ArrayList<>();
    private ArrayList<Prescription> prescriptions = new ArrayList<>();

    // Line for report formatting
    String line = ("-").repeat(40);

    // Default no arg constructor to initialize the system
    public MedicationTrackingSystem() {

    }

    // Add, remove and edit methods
    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public void removePatient(Patient patient) {
        patients.remove(patient);
    }

    public void editPatient(Patient patient, String name, int age, String phoneNumber) {
        // Might want to break these up into individual methods so that the user doesn't
        // have to providate all values if they only want to change one? Or give the
        // option to input null for a value and validate.
        patient.setName(name);
        patient.setAge(age);
        patient.setPhoneNumber(phoneNumber);
    }

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    public void removeDoctor(Doctor doctor) {
        doctors.remove(doctor);
    }

    public void editDoctor(Doctor doctor, String name, int age, String phoneNumber, String specialization) {
        // Same as the editPatient method, maybe break this up? Not sure what the best
        // approach is. Once we get to testing we can see.
        doctor.setName(name);
        doctor.setAge(age);
        doctor.setPhoneNumber(phoneNumber);
        doctor.setSpecialization(specialization);
    }

    public void addMedication(Medication medication) {
        medications.add(medication);
    }

    public void removeMedication(Medication medication) {
        medications.remove(medication);
    }

    public void editMedication(Medication medication, String name, String dose, int quantityInStock,
            LocalDate expiryDate) {
        // Same here with breaking it up.
        medication.setName(name);
        medication.setDose(dose);
        medication.setQuantityInStock(quantityInStock);
        medication.setExpiryDate(expiryDate);
    }

    public Patient searchPatientByName(String name) {

        for (Patient patient : patients) {
            if (patient.getName().equals(name)) {
                return patient;
            }
        }

        // If patient isn't found, display an error. We can fix this up, just getting
        // logic going. We have to return null here otherwise Java complains.
        System.out.println("Patient not found!");
        return null;
    }

    public Doctor searchDoctorByName(String name) {

        for (Doctor doctor : doctors) {
            if (doctor.getName().equals(name)) {
                return doctor;
            }
        }

        // If doctor isn't found, display an error. We can fix this up, just getting
        // logic going. We have to return null here otherwise Java complains.
        System.out.println("Doctor not found!");
        return null;
    }

    public Medication searchMedicationByName(String name) {

        for (Medication medication : medications) {
            if (medication.getName().equals(name)) {
                return medication;
            }
        }

        // If medication isn't found, display an error. We can fix this up, just getting
        // logic going. We have to return null here otherwise Java complains.
        System.out.println("Medication not found!");
        return null;
    }

    public void addPatientToDoctor(Patient patient, Doctor doctor) {
        doctor.addPatient(patient);
    }

    public void acceptPrescription(Prescription prescription) {
        prescriptions.add(prescription);
        prescription.getPatient().addPrescription(prescription);
        prescription.getPatient().addMedication(prescription.getMedication());
    }

    public void generateSystemReport() {
        // Need to format this once we start testing. Chucking it in for now.
        System.out.println(line);
        System.out.println("SYSTEM REPORT");
        System.out.println(line);
        System.out.println();
        System.out.println("Patients:");

        // Loop through patients and print - this will use each class' toString method.
        // I probably need to change the formatting but just went with how we did it in
        // class for now.
        for (Patient patient : patients) {
            System.out.println(patient);
        }

        System.out.println();
        System.out.println("Medications:");

        // Loop through medications and print
        for (Medication medication : medications) {
            System.out.println(medication);
        }

        System.out.println();
        System.out.println("Doctors:");

        // Loop through doctors and print
        for (Doctor doctor : doctors) {
            System.out.println(doctor);
        }

        System.out.println();
        System.out.println("Prescriptions:");

        // Loop through prescriptions and print
        for (Prescription prescription : prescriptions) {
            System.out.println(prescription);
        }

        System.out.println();
        System.out.println(line);
    }

    public void generateExpiredMedicationReport() {

        System.out.println(line);
        System.out.println("EXPIRED MEDICATIONS");
        System.out.println(line);

        // Loop through medications, check expiry date against today's date
        for (Medication medication : medications) {
            if (medication.getExpiryDate().isBefore(LocalDate.now())) {
                System.out.println(medication);
            }
        }

        System.out.println();
        System.out.println(line);
    }

    public void printPrescriptionByDoctor(Doctor doctor) {

        System.out.println(line);
        System.out.printf("Prescriptions Written by %s", doctor.getName());
        System.out.println(line);

        // Loop through doctor's prescriptions
        for (Prescription prescription : prescriptions) {
            if (prescription.getDoctor().equals(doctor)) {
                System.out.println(prescription);
            }
        }

        System.out.println();
        System.out.println(line);

    }

    public void printPatientPrescriptionDrugNames(Patient patient) {

        System.out.println(line);
        System.out.printf("Prescriptions for %s", patient.getName());
        System.out.println(line);

        // Loop through patient's prescriptions and print
        for (Prescription prescription : patient.getPrescriptions()) {
            // Check to make sure that the prescription hasn't expired before printing
            if (prescription.getIssueDate().isAfter(LocalDate.now().minusYears(1)))
                System.out.println(prescription.getMedication().getName());
        }

        System.out.println();
        System.out.println(line);
    }

    public void restockMedication(Medication medication, int quantity) {
        medication.setQuantityInStock(medication.getQuantityInStock() + quantity);
    }
}
