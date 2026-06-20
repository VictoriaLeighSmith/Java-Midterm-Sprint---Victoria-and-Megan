import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Prescription {

    // Declare variables
    private int id;
    private Doctor doctor;
    private Patient patient;
    private Medication medication;
    private LocalDate issueDate;
    private LocalDate prescriptionExpiry;

    // Constructors
    public Prescription() {

    }

    public Prescription(int id, Doctor doctor, Patient patient, Medication medication) {
        this.id = id;
        this.doctor = doctor;
        this.patient = patient;
        this.medication = medication;
        this.issueDate = LocalDate.now();
        this.prescriptionExpiry = issueDate.plusYears(1);
    }

    // Getter and setter methods
    public int getId() {
        return this.id;
    }

    public Doctor getDoctor() {
        return this.doctor;
    }

    public Patient getPatient() {
        return this.patient;
    }

    public Medication getMedication() {
        return this.medication;
    }

    public LocalDate getIssueDate() {
        return this.issueDate;
    }

    public LocalDate getPrescriptionExpiry() {
        return this.prescriptionExpiry;
    }

    // Override toString method
    @Override
    public String toString() {
        return String.format(
                "Prescription[id = %d, doctor = %s, patient = %s, medication = %s, issue date = %s, expiry date = %s]",
                this.id, this.doctor.getName(), this.patient.getName(), this.medication.getName(),
                this.issueDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                this.prescriptionExpiry.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
    }

}
