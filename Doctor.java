import java.util.ArrayList;

public class Doctor extends Person {

    // Declare variables
    private String specialization;
    private ArrayList<Patient> patients = new ArrayList<>();

    // Constructors
    public Doctor() {

    }

    public Doctor(int id, String name, int age, String phoneNumber, String specialization) {
        super(id, name, age, phoneNumber);
        this.specialization = specialization;
    }

    // Getter/setter and add/remove methods
    public String getSpecialization() {
        return this.specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public ArrayList<Patient> getPatients() {
        return this.patients;
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public void removePatient(Patient patient) {
        patients.remove(patient);
    }

    // Override toString method
    @Override
    public String toString() {
        return String.format("Doctor[id = %d, name = %s, age = %d, phone number = %s, specialization = %s]", super.id,
                super.name, super.age, super.phoneNumber, this.specialization);
    }
}
