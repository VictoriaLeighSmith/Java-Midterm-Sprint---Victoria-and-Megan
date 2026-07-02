import java.util.ArrayList;

/**
 * The Doctor class represents a doctor in the pharmacy management system.
 * It stores the doctor's information, specialization, and assigned patients.
 *
 * @author Megan Hickey
 * @author Victoria Smith
 */
public class Doctor extends Person {

    // Declare variables
    private String specialization;
    private ArrayList<Patient> patients = new ArrayList<>();

    // Constructors

    /**
     * Default constructor.
     */

    public Doctor() {

    }

    /**
     * Creates a new doctor.
     *
     * @param id             The doctor's ID.
     * @param name           The doctor's name.
     * @param age            The doctor's age.
     * @param phoneNumber    The doctor's phone number.
     * @param specialization The doctor's area of specialization.
     */

    public Doctor(int id, String name, int age, String phoneNumber, String specialization) {
        super(id, name, age, phoneNumber);
        this.specialization = specialization;
    }

    // Getter, setter, and add/remove methods

    /**
     * Returns the doctor's specialization.
     *
     * @return The doctor's specialization.
     */

    public String getSpecialization() {
        return this.specialization;
    }

    /**
     * Updates the doctor's specialization.
     *
     * @param specialization The new specialization.
     */

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    /**
     * Returns the doctor's assigned patients.
     *
     * @return ArrayList of patients.
     */

    public ArrayList<Patient> getPatients() {
        return this.patients;
    }

    /**
     * Adds a patient to the doctor's patient list.
     *
     * @param patient The patient to add.
     */

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    /**
     * Removes a patient from the doctor's patient list.
     *
     * @param patient The patient to remove.
     */

    public void removePatient(Patient patient) {
        patients.remove(patient);
    }

    /**
     * Returns the doctor's information as a formatted string.
     *
     * @return Formatted doctor information.
     */

    @Override
    public String toString() {
        return String.format(
                "Doctor[id = %d, name = %s, age = %d, phone number = %s, specialization = %s]",
                super.id,
                super.name,
                super.age,
                super.phoneNumber,
                this.specialization);
    }
}