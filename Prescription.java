import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * The Prescription class represents a prescription in the pharmacy system.
 * It connects a doctor, patient, and medication together while storing the
 * issue date and expiry date.
 *
 * @author Megan Hickey
 * @author Victoria Smith
 */

public class Prescription {

    // Declare variables
    private int id;
    private Doctor doctor;
    private Patient patient;
    private Medication medication;
    private LocalDate issueDate;
    private LocalDate prescriptionExpiry;

    // Constructors

    /**
     * Default constructor.
     */

    public Prescription() {

    }

    /**
     * Creates a new prescription.
     *
     * @param id         The prescription ID.
     * @param doctor     The doctor writing the prescription.
     * @param patient    The patient receiving the prescription.
     * @param medication The medication being prescribed.
     */

    public Prescription(int id, Doctor doctor, Patient patient, Medication medication) {
        this.id = id;
        this.doctor = doctor;
        this.patient = patient;
        this.medication = medication;
        this.issueDate = LocalDate.now();
        this.prescriptionExpiry = issueDate.plusYears(1);
    }

    // Getter methods

    /**
     * Returns the prescription ID.
     *
     * @return The prescription ID.
     */

    public int getId() {
        return this.id;
    }

    /**
     * Returns the doctor who wrote the prescription.
     *
     * @return The doctor.
     */

    public Doctor getDoctor() {
        return this.doctor;
    }

    /**
     * Returns the patient receiving the prescription.
     *
     * @return The patient.
     */

    public Patient getPatient() {
        return this.patient;
    }

    /**
     * Returns the medication on the prescription.
     *
     * @return The medication.
     */

    public Medication getMedication() {
        return this.medication;
    }

    /**
     * Returns the date the prescription was created.
     *
     * @return The issue date.
     */

    public LocalDate getIssueDate() {
        return this.issueDate;
    }

    /**
     * Returns the prescription expiry date.
     *
     * @return The expiry date.
     */

    public LocalDate getPrescriptionExpiry() {
        return this.prescriptionExpiry;
    }

    /**
     * Returns the prescription information as a formatted string.
     *
     * @return Formatted prescription information.
     */

    @Override
    public String toString() {
        return String.format(
                "Prescription[id = %d, doctor = %s, patient = %s, medication = %s, issue date = %s, expiry date = %s]",
                this.id,
                this.doctor.getName(),
                this.patient.getName(),
                this.medication.getName(),
                this.issueDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                this.prescriptionExpiry.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
    }

}