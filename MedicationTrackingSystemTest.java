
/**
 * Runs the Pharmacy Management System.
 * Displays the menu, accepts user input, and calls the
 * appropriate methods from the MedicationTrackingSystem class.
 *
 * @author Megan Hickey
 * @author Victoria Smith
 */

import java.time.LocalDate;
import java.util.Scanner;

public class MedicationTrackingSystemTest {
    /**
     * Starts the Pharmacy Management System.
     * Displays the menu until the user chooses to exit.
     *
     * @param args Command line arguments.
     */
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
            System.out.print("Choose the number corresponding with your desired option (0 to Exit): ");
            choice = scanner.nextInt();

            switch (choice) {

                // Add a patient to the system
                case 1:
                    System.out.print("Enter patient id: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // clear leftover Enter

                    System.out.print("Enter patient full name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter patient age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine(); // clear leftover Enter

                    System.out.print("Enter patient phone number: ");
                    String phoneNumber = scanner.nextLine();

                    Patient newPatient = new Patient(id, name, age, phoneNumber);
                    system.addPatient(newPatient);

                    System.out.println("Patient added successfully.");
                    System.out.println(newPatient);

                    break;

                // Remove a patient from the system
                case 2:
                    scanner.nextLine(); // clear leftover Enter

                    System.out.print("Enter patient name to remove: ");
                    String patientToRemove = scanner.nextLine();

                    boolean removedPatient = system.removePatient(patientToRemove);
                    System.out.println(removedPatient ? "Patient removed successfully." : "Patient not found.");

                    break;

                // Edit a patient's information
                case 3:
                    scanner.nextLine(); // clear leftover Enter

                    System.out.print("Enter patient name to edit: ");
                    String editPatientName = scanner.nextLine();

                    System.out.print("Enter new patient name: ");
                    String newPatientName = scanner.nextLine();

                    System.out.print("Enter new patient age: ");
                    int newPatientAge = scanner.nextInt();
                    scanner.nextLine(); // clear leftover Enter

                    System.out.print("Enter new patient phone number: ");
                    String newPatientPhone = scanner.nextLine();

                    boolean editPatientFound = system.editPatient(editPatientName, newPatientName, newPatientAge,
                            newPatientPhone);
                    System.out.println(editPatientFound ? "Patient details edited successfully" : "Patient not found");

                    break;

                // Add a doctor to the system
                case 4:
                    System.out.print("Enter doctor id: ");
                    int docId = scanner.nextInt();
                    scanner.nextLine(); // clear leftover Enter

                    System.out.print("Enter doctor name: ");
                    String docName = scanner.nextLine();

                    System.out.print("Enter doctor age: ");
                    int docAge = scanner.nextInt();
                    scanner.nextLine(); // clear leftover Enter

                    System.out.print("Enter doctor phone number: ");
                    String docPhoneNumber = scanner.nextLine();

                    System.out.print("Enter doctor specialization: ");
                    String specialization = scanner.nextLine();

                    Doctor newDoctor = new Doctor(docId, docName, docAge, docPhoneNumber, specialization);
                    system.addDoctor(newDoctor);

                    System.out.println("Doctor added successfully.");
                    System.out.println(newDoctor);
                    break;

                // Remove a doctor from the system
                case 5:
                    scanner.nextLine(); // clear leftover Enter

                    System.out.print("Enter doctor name to remove: ");
                    String doctorToRemove = scanner.nextLine();

                    boolean removedDoctor = system.removeDoctor(doctorToRemove);
                    System.out.println(removedDoctor ? "Doctor removed successfully." : "Doctor not found.");

                    break;

                // Edit a doctor's information
                case 6:
                    scanner.nextLine(); // clear leftover Enter

                    System.out.print("Enter doctor name to edit: ");
                    String editDoctorName = scanner.nextLine();

                    System.out.print("Enter new doctor name: ");
                    String newDoctorName = scanner.nextLine();

                    System.out.print("Enter new doctor age: ");
                    int newDoctorAge = scanner.nextInt();
                    scanner.nextLine(); // clear leftover Enter

                    System.out.print("Enter new doctor phone number: ");
                    String newDoctorPhone = scanner.nextLine();

                    System.out.print("Enter new doctor specialization: ");
                    String newSpecialization = scanner.nextLine();

                    boolean doctorEdited = system.editDoctor(editDoctorName, newDoctorName, newDoctorAge,
                            newDoctorPhone,
                            newSpecialization);
                    System.out.println(doctorEdited ? "Doctor edited successfully" : "Doctor not found");

                    break;

                // Add a medication to the system
                case 7:
                    System.out.print("Enter medication id: ");
                    int medId = scanner.nextInt();
                    scanner.nextLine(); // clear leftover Enter

                    System.out.print("Enter medication name: ");
                    String medName = scanner.nextLine();

                    System.out.print("Enter dose: ");
                    String dose = scanner.nextLine();

                    System.out.print("Enter quantity in stock: ");
                    int quantInStock = scanner.nextInt();
                    scanner.nextLine(); // clear leftover Enter

                    System.out.print("Enter expiry date (YYYY-MM-DD): ");
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

                    System.out.print("Enter medication name to remove: ");
                    String medicationToRemove = scanner.nextLine();

                    boolean removedMedication = system.removeMedication(medicationToRemove);
                    System.out
                            .println(removedMedication ? "Medication removed successfully." : "Medication not found.");

                    break;

                // Edit a medication's information
                case 9:
                    scanner.nextLine(); // clear leftover Enter

                    System.out.print("Enter medication name to edit: ");
                    String editMedicationName = scanner.nextLine();

                    System.out.print("Enter new medication name: ");
                    String newMedicationName = scanner.nextLine();

                    System.out.print("Enter new dose: ");
                    String newDose = scanner.nextLine();

                    System.out.print("Enter new quantity in stock: ");
                    int newQuantityInStock = scanner.nextInt();
                    scanner.nextLine(); // clear leftover Enter

                    System.out.print("Enter new expiry date (YYYY-MM-DD): ");
                    String newExpiryDate = scanner.nextLine();
                    LocalDate parsedNewExpiryDate = LocalDate.parse(newExpiryDate);

                    boolean medicationEdited = system.editMedication(editMedicationName, newMedicationName, newDose,
                            newQuantityInStock, parsedNewExpiryDate);
                    System.out.println(medicationEdited ? "Medication edited successfully" : "Medication not found");

                    break;

                // Search for a patient by name
                case 10:
                    scanner.nextLine(); // clear leftover Enter

                    System.out.print("Enter patient name: ");
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

                    System.out.print("Enter doctor name: ");
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

                    System.out.print("Enter medication name: ");
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

                    System.out.print("Enter patient name: ");
                    String patientNameForDoctor = scanner.nextLine();

                    System.out.print("Enter doctor name: ");
                    String doctorNameForPatient = scanner.nextLine();

                    boolean addedToDoctor = system.addPatientToDoctor(patientNameForDoctor, doctorNameForPatient);
                    System.out.println(
                            addedToDoctor ? "Patient added to doctor successfully." : "Patient or doctor not found.");

                    break;

                // Accept a prescription and link it to the patient and medication
                case 14:
                    scanner.nextLine(); // clear leftover Enter

                    System.out.print("Enter prescription id: ");
                    int prescriptionId = scanner.nextInt();
                    scanner.nextLine(); // clear leftover Enter

                    System.out.print("Enter doctor name: ");
                    String prescriptionDoctorName = scanner.nextLine();

                    System.out.print("Enter patient name: ");
                    String prescriptionPatientName = scanner.nextLine();

                    System.out.print("Enter medication name: ");
                    String prescriptionMedicationName = scanner.nextLine();

                    boolean prescriptionAccepted = system.acceptPrescription(prescriptionId, prescriptionDoctorName,
                            prescriptionPatientName, prescriptionMedicationName);
                    System.out.println(prescriptionAccepted ? "Prescription accepted successfully."
                            : "Doctor, patient, or medication not found.");

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

                    System.out.print("Enter doctor name: ");
                    String doctorPrescriptionName = scanner.nextLine();

                    // Display a message if the doctor is not found or has no prescriptions.
                    boolean doctorPrescriptionsFound = system.printPrescriptionByDoctor(doctorPrescriptionName);
                    if (!doctorPrescriptionsFound) {
                        System.out.println("Doctor not found or prescriptions list empty");
                    }

                    break;

                // Print prescription drug names for a specific patient
                case 18:
                    scanner.nextLine(); // clear leftover Enter

                    System.out.print("Enter patient name: ");
                    String patientPrescriptionName = scanner.nextLine();

                    boolean patientPrescriptionsFound = system
                            .printPatientPrescriptionDrugNames(patientPrescriptionName);
                    if (!patientPrescriptionsFound) {
                        System.out.println("Patient not found or no recent prescriptions");
                    }

                    break;

                // Restock an existing medication
                case 19:
                    scanner.nextLine(); // clear leftover Enter

                    System.out.print("Enter medication name to restock: ");
                    String restockName = scanner.nextLine();

                    System.out.print("Enter quantity to add: ");
                    int restockQuantity = scanner.nextInt();

                    boolean medicationRestocked = system.restockMedication(restockName, restockQuantity);
                    System.out.println(
                            medicationRestocked ? "Medication restocked successfully" : "Medication not found");

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