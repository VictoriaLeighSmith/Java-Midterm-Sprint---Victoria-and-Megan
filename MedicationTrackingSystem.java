import java.util.ArrayList;
import java.time.LocalDate;

public class MedicationTrackingSystem {

    // Declare variables
    private ArrayList<Patient> patients = new ArrayList<>();
    private ArrayList<Medication> medications = new ArrayList<>();
    private ArrayList<Doctor> doctors = new ArrayList<>();
    private ArrayList<Prescription> prescriptions = new ArrayList<>();

    // Default no arg constructor to initialize the system
    public MedicationTrackingSystem() {

    }

    // Add, remove and edit methods
    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public boolean removePatient(String name) {
        Patient patient = searchPatientByName(name);

        if (patient != null) {
            patients.remove(patient);
            return true;
        }

        return false;
    }

    public boolean editPatient(String patientName, String newPatientName, int newAge, String newPhoneNumber) {
        Patient patient = searchPatientByName(patientName);

        if (patient != null) {
            patient.setName(newPatientName);
            patient.setAge(newAge);
            patient.setPhoneNumber(newPhoneNumber);

            return true;
        }

        return false;
    }

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    public boolean removeDoctor(String name) {
        Doctor doctor = searchDoctorByName(name);

        if (doctor != null) {
            doctors.remove(doctor);
            return true;
        }

        return false;
    }

    public boolean editDoctor(String doctorName, String newName, int newAge, String newPhoneNumber,
            String newSpecialization) {
        Doctor doctor = searchDoctorByName(doctorName);

        if (doctor != null) {
            doctor.setName(newName);
            doctor.setAge(newAge);
            doctor.setPhoneNumber(newPhoneNumber);
            doctor.setSpecialization(newSpecialization);

            return true;
        }

        return false;
    }

    public void addMedication(Medication medication) {
        medications.add(medication);
    }

    public boolean removeMedication(String name) {
        Medication medication = searchMedicationByName(name);

        if (medication != null) {
            medications.remove(medication);
            return true;
        }

        return false;
    }

    public boolean editMedication(String medicationName, String newName, String newDose, int newQuantityInStock,
            LocalDate newExpiryDate) {
        Medication medication = searchMedicationByName(medicationName);

        if (medication != null) {
            medication.setName(newName);
            medication.setDose(newDose);
            medication.setQuantityInStock(newQuantityInStock);
            medication.setExpiryDate(newExpiryDate);

            return true;
        }

        return false;
    }

    public Patient searchPatientByName(String name) {

        for (Patient patient : patients) {
            if (patient.getName().equals(name)) {
                return patient;
            }
        }

        return null;
    }

    public Doctor searchDoctorByName(String name) {

        for (Doctor doctor : doctors) {
            if (doctor.getName().equals(name)) {
                return doctor;
            }
        }

        return null;
    }

    public Medication searchMedicationByName(String name) {

        for (Medication medication : medications) {
            if (medication.getName().equals(name)) {
                return medication;
            }
        }

        return null;
    }

    public boolean addPatientToDoctor(String patientName, String doctorName) {
        Patient patient = searchPatientByName(patientName);
        Doctor doctor = searchDoctorByName(doctorName);

        if (patient != null && doctor != null) {
            doctor.addPatient(patient);
            return true;
        }

        return false;
    }

    public boolean acceptPrescription(int prescriptionId, String doctorName, String patientName,
            String medicationName) {
        Doctor doctor = searchDoctorByName(doctorName);
        Patient patient = searchPatientByName(patientName);
        Medication medication = searchMedicationByName(medicationName);

        if (doctor != null && patient != null && medication != null) {
            Prescription prescription = new Prescription(prescriptionId, doctor, patient, medication);

            prescriptions.add(prescription);
            patient.addPrescription(prescription);
            patient.addMedication(medication);

            return true;
        }

        return false;
    }

    public void generateSystemReport() {
        System.out.println("============== SYSTEM REPORT ===============");
        System.out.println();
        System.out.println("Patients:");
        System.out.println();

        // Loop through patients and print - this will use each class' toString method.
        for (Patient patient : patients) {
            System.out.println(patient);
        }

        System.out.println();
        System.out.println("Medications:");
        System.out.println();

        // Loop through medications and print
        for (Medication medication : medications) {
            System.out.println(medication);
        }

        System.out.println();
        System.out.println("Doctors:");
        System.out.println();

        // Loop through doctors and print
        for (Doctor doctor : doctors) {
            System.out.println(doctor);
        }

        System.out.println();
        System.out.println("Prescriptions:");
        System.out.println();

        // Loop through prescriptions and print
        for (Prescription prescription : prescriptions) {
            System.out.println(prescription);
        }

        System.out.println();
        System.out.println("============================================");
    }

    public void generateExpiredMedicationReport() {
        System.out.println();
        System.out.println("=========== EXPIRED MEDICATIONS ============");
        System.out.println();

        // Loop through medications, check expiry date against today's date
        for (Medication medication : medications) {
            if (medication.getExpiryDate().isBefore(LocalDate.now())) {
                System.out.println(medication);
            }
        }

        System.out.println();
        System.out.println("============================================");
        System.out.println();
    }

    public boolean printPrescriptionByDoctor(String doctorName) {
        Doctor doctor = searchDoctorByName(doctorName);
        boolean prescriptionsFound = false;

        if (doctor == null) {
            return false;
        }

        System.out.println();
        System.out.printf("Prescriptions Written by %s", doctor.getName());
        System.out.println();

        // Loop through doctor's prescriptions
        for (Prescription prescription : prescriptions) {
            if (prescription.getDoctor().equals(doctor)) {
                System.out.println(prescription);
                prescriptionsFound = true;
            }
        }

        System.out.println();
        return prescriptionsFound;
    }

    public boolean printPatientPrescriptionDrugNames(String patientName) {
        Patient patient = searchPatientByName(patientName);
        boolean prescriptionsFound = false;

        if (patient == null) {
            return false;
        }

        System.out.println();
        System.out.printf("Prescriptions for %s", patient.getName());
        System.out.println();

        // Loop through patient's prescriptions and print
        for (Prescription prescription : patient.getPrescriptions()) {
            // Check to make sure that the prescription hasn't expired before printing
            if (prescription.getIssueDate().isAfter(LocalDate.now().minusYears(1))) {
                System.out.println(prescription.getMedication().getName());
                prescriptionsFound = true;
            }

        }
        System.out.println();
        return prescriptionsFound;
    }

    public boolean restockMedication(String medicationName, int quantity) {
        Medication medication = searchMedicationByName(medicationName);

        if (medication != null) {
            medication.setQuantityInStock(medication.getQuantityInStock() + quantity);
            return true;
        }

        return false;
    }
}
