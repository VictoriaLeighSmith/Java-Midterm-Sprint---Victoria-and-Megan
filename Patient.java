import java.util.ArrayList;

/**
 * Represents a patient in the pharmacy management system.
 * Stores the patient's information, medications, and prescriptions.
 *
 * @author Megan Hickey
 * @author Victoria Smith
 */

public class Patient extends Person {

    // Declare variables
    private ArrayList<Medication> medications = new ArrayList<>();
    private ArrayList<Prescription> prescriptions = new ArrayList<>();

    // Constructors

    /**
     * Default constructor.
     */
    public Patient() {

    }

    /**
     * Creates a new patient.
     *
     * @param id          The patient's ID.
     * @param name        The patient's name.
     * @param age         The patient's age.
     * @param phoneNumber The patient's phone number.
     */

    public Patient(int id, String name, int age, String phoneNumber) {
        super(id, name, age, phoneNumber);
    }

    // Getter/setter and add/remove methods

    /**
     * Returns the patient's medications.
     *
     * @return ArrayList of medications.
     */

    public ArrayList<Medication> getMedications() {
        return this.medications;
    }

    /**
     * Adds a medication to the patient's list.
     *
     * @param medication The medication to add.
     */

    public void addMedication(Medication medication) {
        medications.add(medication);
    }

    /**
     * Removes a medication from the patient's list.
     *
     * @param medication The medication to remove.
     */

    public void removeMedication(Medication medication) {
        medications.remove(medication);
    }

    /**
     * Returns the patient's prescriptions.
     *
     * @return ArrayList of prescriptions.
     */

    public ArrayList<Prescription> getPrescriptions() {
        return this.prescriptions;
    }

    /**
     * Adds a prescription to the patient's list.
     *
     * @param prescription The prescription to add.
     */

    public void addPrescription(Prescription prescription) {
        prescriptions.add(prescription);
    }

    /**
     * Removes a prescription from the patient's list.
     *
     * @param prescription The prescription to remove.
     */

    public void removePrescription(Prescription prescription) {
        prescriptions.remove(prescription);
    }

    /**
     * Returns the patient's information as a string.
     *
     * @return Formatted patient information.
     */

    @Override
    public String toString() {
        return String.format(
                "Patient[id = %d, name = %s, age = %d, phone number = %s]",
                this.id,
                this.name,
                this.age,
                this.phoneNumber);
    }
}