import java.util.ArrayList;

public class Patient extends Person {

    // Declare variables
    private ArrayList<Medication> medications = new ArrayList<>();
    private ArrayList<Prescription> prescriptions = new ArrayList<>();

    // Constructors
    public Patient() {

    }

    public Patient(int id, String name, int age, String phoneNumber) {
        super(id, name, age, phoneNumber);
    }

    // Getter/setter and add/remove methods
    public ArrayList<Medication> getMedications() {
        return this.medications;
    }

    public void addMedication(Medication medication) {
        medications.add(medication);
    }

    public void removeMedication(Medication medication) {
        medications.remove(medication);
    }

    public ArrayList<Prescription> getPrescriptions() {
        return this.prescriptions;
    }

    public void addPrescription(Prescription prescription) {
        prescriptions.add(prescription);
    }

    public void removePrescription(Prescription prescription) {
        prescriptions.remove(prescription);
    }

    // Override toString method
    @Override
    public String toString() {
        return String.format("Patient[id = %d, name = %s, age = %d, phone number = %s]", this.id, this.name, this.age,
                this.phoneNumber);
    }
}
