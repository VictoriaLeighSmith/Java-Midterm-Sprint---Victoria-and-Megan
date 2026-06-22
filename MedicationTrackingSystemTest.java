import java.time.LocalDate;
import java.util.Scanner;

public class MedicationTrackingSystemTest {
    public static void main(String[] args) {

        // Create the medication tracking system
        MedicationTrackingSystem system = new MedicationTrackingSystem();

        // Create scanner and set choice to a default value
        Scanner scanner = new Scanner(System.in);
        int choice = -1;

        // Keep showing the menu until the user chooses to exit
        while (choice != 0) {

            // Print menu options
            System.out.println();
            System.out.println("======== PHARMACY MANAGEMENT SYSTEM ========");
            System.out.println();
            System.out.println("Menu Options");
            System.out.println();
            System.out.println("1.  Add Patient");
            System.out.println("2.  Remove Patient");
            System.out.println("3.  Edit Patient");
            System.out.println("4.  Add Doctor");
            System.out.println("5.  Remove Doctor");
            System.out.println("6.  Edit Doctor");
            System.out.println("7.  Add Medication");
            System.out.println("8.  Remove Medication");
            System.out.println("9.  Edit Medication");
            System.out.println("10. Search Patient by Name");
            System.out.println("11. Search Doctor by Name");
            System.out.println("12. Search Medication by Name");
            System.out.println("13. Add Patient to Doctor");
            System.out.println("14. Accept Prescription");
            System.out.println("15. Generate System Report");
            System.out.println("16. Generate Expired Medication Report");
            System.out.println("17. Print Prescriptions by Doctor");
            System.out.println("18. Print Patient Prescription Drug Names");
            System.out.println("19. Restock Medication");
            System.out.println("0.  Exit");
            System.out.println();
            System.out.println("============================================");
            System.out.println();

            // Get menu choice from user
            System.out.println("Choose the number corresponding with your desired option (0 to Exit): ");
            choice = scanner.nextInt();

            switch (choice) {

                // Add a patient to the system
                case 1:
                    System.out.println("Enter patient id: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // clear leftover Enter

                    System.out.println("Enter patient name: ");
                    String name = scanner.nextLine();

                    System.out.println("Enter patient age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine(); // clear leftover Enter

                    System.out.println("Enter patient phone number: ");
                    String phoneNumber = scanner.nextLine();

                    Patient newPatient = new Patient(id, name, age, phoneNumber);
                    system.addPatient(newPatient);

                    System.out.println("Patient added successfully.");
                    System.out.println(newPatient);
                    break;

                // Remove a patient from the system
                case 2:
                    scanner.nextLine(); // clear leftover Enter

                    System.out.println("Enter patient name to remove: ");
                    String removeName = scanner.nextLine();

                    Patient patientToRemove = system.searchPatientByName(removeName);

                    if (patientToRemove != null) {
                        system.removePatient(patientToRemove);
                        System.out.println("Patient removed successfully.");
                    } else {
                        System.out.println("Patient not found.");
                    }
                    break;

                // Edit a patient's information
                case 3:
                    scanner.nextLine(); // clear leftover Enter

                    System.out.println("Enter patient name to edit: ");
                    String editPatientName = scanner.nextLine();

                    Patient patientToEdit = system.searchPatientByName(editPatientName);

                    if (patientToEdit != null) {
                        System.out.println("Enter new patient name: ");
                        String newPatientName = scanner.nextLine();

                        System.out.println("Enter new patient age: ");
                        int newPatientAge = scanner.nextInt();
                        scanner.nextLine(); // clear leftover Enter

                        System.out.println("Enter new patient phone number: ");
                        String newPatientPhone = scanner.nextLine();

                        system.editPatient(patientToEdit, newPatientName, newPatientAge, newPatientPhone);

                        System.out.println("Patient edited successfully.");
                        System.out.println(patientToEdit);
                    } else {
                        System.out.println("Patient not found.");
                    }
                    break;

                // Add a doctor to the system
                case 4:
                    System.out.println("Enter doctor id: ");
                    int docId = scanner.nextInt();
                    scanner.nextLine(); // clear leftover Enter

                    System.out.println("Enter doctor name: ");
                    String docName = scanner.nextLine();

                    System.out.println("Enter doctor age: ");
                    int docAge = scanner.nextInt();
                    scanner.nextLine(); // clear leftover Enter

                    System.out.println("Enter doctor phone number: ");
                    String docPhoneNumber = scanner.nextLine();

                    System.out.println("Enter doctor specialty: ");
                    String specialty = scanner.nextLine();

                    Doctor newDoctor = new Doctor(docId, docName, docAge, docPhoneNumber, specialty);
                    system.addDoctor(newDoctor);

                    System.out.println("Doctor added successfully.");
                    System.out.println(newDoctor);
                    break;

                // Remove a doctor from the system
                case 5:
                    scanner.nextLine(); // clear leftover Enter

                    System.out.println("Enter doctor name to remove: ");
                    String removeDoc = scanner.nextLine();

                    Doctor doctorToRemove = system.searchDoctorByName(removeDoc);

                    if (doctorToRemove != null) {
                        system.removeDoctor(doctorToRemove);
                        System.out.println("Doctor removed successfully.");
                    } else {
                        System.out.println("Doctor not found.");
                    }
                    break;

                // Edit a doctor's information
                case 6:
                    scanner.nextLine(); // clear leftover Enter

                    System.out.println("Enter doctor name to edit: ");
                    String editDoctorName = scanner.nextLine();

                    Doctor doctorToEdit = system.searchDoctorByName(editDoctorName);

                    if (doctorToEdit != null) {
                        System.out.println("Enter new doctor name: ");
                        String newDoctorName = scanner.nextLine();

                        System.out.println("Enter new doctor age: ");
                        int newDoctorAge = scanner.nextInt();
                        scanner.nextLine(); // clear leftover Enter

                        System.out.println("Enter new doctor phone number: ");
                        String newDoctorPhone = scanner.nextLine();

                        System.out.println("Enter new doctor specialty: ");
                        String newSpecialty = scanner.nextLine();

                        system.editDoctor(doctorToEdit, newDoctorName, newDoctorAge, newDoctorPhone, newSpecialty);

                        System.out.println("Doctor edited successfully.");
                        System.out.println(doctorToEdit);
                    } else {
                        System.out.println("Doctor not found.");
                    }
                    break;

                // Add a medication to the system
                case 7:
                    System.out.println("Enter medication id: ");
                    int medId = scanner.nextInt();
                    scanner.nextLine(); // clear leftover Enter

                    System.out.println("Enter medication name: ");
                    String medName = scanner.nextLine();

                    System.out.println("Enter dose: ");
                    String dose = scanner.nextLine();

                    System.out.println("Enter quantity in stock: ");
                    int quantInStock = scanner.nextInt();
                    scanner.nextLine(); // clear leftover Enter

                    System.out.println("Enter expiry date (yyyy-MM-dd): ");
                    String expiryDate = scanner.nextLine();
                    LocalDate parsedExpiryDate = LocalDate.parse(expiryDate);

                    Medication newMed = new Medication(medId, medName, dose, quantInStock, parsedExpiryDate);
                    system.addMedication(newMed);

                    System.out.println("Medication added successfully.");
                    System.out.println(newMed);
                    break;

                // Remove a medication from the system
                case 8:
                    scanner.nextLine(); // clear leftover Enter

                    System.out.println("Enter medication name to remove: ");
                    String removeMed = scanner.nextLine();

                    Medication medToRemove = system.searchMedicationByName(removeMed);

                    if (medToRemove != null) {
                        system.removeMedication(medToRemove);
                        System.out.println("Medication removed successfully.");
                    } else {
                        System.out.println("Medication not found.");
                    }
                    break;

                // Edit a medication's information
                case 9:
                    scanner.nextLine(); // clear leftover Enter

                    System.out.println("Enter medication name to edit: ");
                    String editMed = scanner.nextLine();

                    Medication medToEdit = system.searchMedicationByName(editMed);

                    if (medToEdit != null) {
                        System.out.println("Enter new medication name: ");
                        String newMedName = scanner.nextLine();

                        System.out.println("Enter new dose: ");
                        String newDose = scanner.nextLine();

                        System.out.println("Enter new quantity in stock: ");
                        int newQuantInStock = scanner.nextInt();
                        scanner.nextLine(); // clear leftover Enter

                        System.out.println("Enter new expiry date (yyyy-MM-dd): ");
                        String newExpiryDate = scanner.nextLine();
                        LocalDate parsedNewExpiryDate = LocalDate.parse(newExpiryDate);

                        system.editMedication(medToEdit, newMedName, newDose, newQuantInStock, parsedNewExpiryDate);

                        System.out.println("Medication edited successfully.");
                        System.out.println(medToEdit);
                    } else {
                        System.out.println("Medication not found.");
                    }
                    break;

                // Search for a patient by name
                case 10:
                    scanner.nextLine(); // clear leftover Enter

                    System.out.println("Enter patient name: ");
                    String searchName = scanner.nextLine();

                    Patient foundPatient = system.searchPatientByName(searchName);

                    if (foundPatient != null) {
                        System.out.println("Patient found successfully.");
                        System.out.println(foundPatient);
                    } else {
                        System.out.println("Patient not found.");
                    }
                    break;

                // Search for a doctor by name
                case 11:
                    scanner.nextLine(); // clear leftover Enter

                    System.out.println("Enter doctor name: ");
                    String searchDocName = scanner.nextLine();

                    Doctor foundDoctor = system.searchDoctorByName(searchDocName);

                    if (foundDoctor != null) {
                        System.out.println("Doctor found successfully.");
                        System.out.println(foundDoctor);
                    } else {
                        System.out.println("Doctor not found.");
                    }
                    break;

                // Search for a medication by name
                case 12:
                    scanner.nextLine(); // clear leftover Enter

                    System.out.println("Enter medication name: ");
                    String searchMedName = scanner.nextLine();

                    Medication foundMedication = system.searchMedicationByName(searchMedName);

                    if (foundMedication != null) {
                        System.out.println("Medication found successfully.");
                        System.out.println(foundMedication);
                    } else {
                        System.out.println("Medication not found.");
                    }
                    break;

                // Add an existing patient to an existing doctor's patient list
                case 13:
                    scanner.nextLine(); // clear leftover Enter

                    System.out.println("Enter patient name: ");
                    String patientNameForDoctor = scanner.nextLine();

                    System.out.println("Enter doctor name: ");
                    String doctorNameForPatient = scanner.nextLine();

                    Patient patientForDoctor = system.searchPatientByName(patientNameForDoctor);
                    Doctor doctorForPatient = system.searchDoctorByName(doctorNameForPatient);

                    if (patientForDoctor != null && doctorForPatient != null) {
                        system.addPatientToDoctor(patientForDoctor, doctorForPatient);
                        System.out.println("Patient added to doctor successfully.");
                    } else {
                        System.out.println("Patient or doctor not found.");
                    }
                    break;

                // Accept a prescription and link it to the patient and medication
                case 14:
                    scanner.nextLine(); // clear leftover Enter

                    System.out.println("Enter prescription id: ");
                    int prescriptionId = scanner.nextInt();
                    scanner.nextLine(); // clear leftover Enter

                    System.out.println("Enter doctor name: ");
                    String prescriptionDoctorName = scanner.nextLine();

                    System.out.println("Enter patient name: ");
                    String prescriptionPatientName = scanner.nextLine();

                    System.out.println("Enter medication name: ");
                    String prescriptionMedicationName = scanner.nextLine();

                    Doctor rxDoctor = system.searchDoctorByName(prescriptionDoctorName);
                    Patient rxPatient = system.searchPatientByName(prescriptionPatientName);
                    Medication rxMedication = system.searchMedicationByName(prescriptionMedicationName);

                    if (rxDoctor != null && rxPatient != null && rxMedication != null) {
                        Prescription newPrescription = new Prescription(prescriptionId, rxDoctor, rxPatient,
                                rxMedication);
                        system.acceptPrescription(newPrescription);

                        System.out.println("Prescription accepted successfully.");
                        System.out.println(newPrescription);
                    } else {
                        System.out.println("Doctor, patient, or medication not found.");
                    }
                    break;

                // Print a report containing all system data
                case 15:
                    system.generateSystemReport();
                    break;

                // Print a report showing expired medications
                case 16:
                    system.generateExpiredMedicationReport();
                    break;

                // Print all prescriptions written by a specific doctor
                case 17:
                    scanner.nextLine(); // clear leftover Enter

                    System.out.println("Enter doctor name: ");
                    String doctorPrescriptionName = scanner.nextLine();

                    Doctor prescriptionDoctor = system.searchDoctorByName(doctorPrescriptionName);

                    if (prescriptionDoctor != null) {
                        system.printPrescriptionByDoctor(prescriptionDoctor);
                    } else {
                        System.out.println("Doctor not found.");
                    }
                    break;

                // Print prescription drug names for a specific patient
                case 18:
                    scanner.nextLine(); // clear leftover Enter

                    System.out.println("Enter patient name: ");
                    String patientPrescriptionName = scanner.nextLine();

                    Patient prescriptionPatient = system.searchPatientByName(patientPrescriptionName);

                    if (prescriptionPatient != null) {
                        system.printPatientPrescriptionDrugNames(prescriptionPatient);
                    } else {
                        System.out.println("Patient not found.");
                    }
                    break;

                // Restock an existing medication
                case 19:
                    scanner.nextLine(); // clear leftover Enter

                    System.out.println("Enter medication name to restock: ");
                    String restockName = scanner.nextLine();

                    Medication medToRestock = system.searchMedicationByName(restockName);

                    if (medToRestock != null) {
                        System.out.println("Enter quantity to add: ");
                        int restockQuantity = scanner.nextInt();

                        system.restockMedication(medToRestock, restockQuantity);

                        System.out.println("Medication restocked successfully.");
                        System.out.println(medToRestock);
                    } else {
                        System.out.println("Medication not found.");
                    }
                    break;

                // Exit the menu
                case 0:
                    System.out.println("Exiting Pharmacy Management System.");
                    break;

                // Display message for invalid menu options
                default:
                    System.out.println("Invalid option. Please choose a number from the menu.");
                    break;
            }
        }

        // Close scanner when program ends
        scanner.close();
    }
}