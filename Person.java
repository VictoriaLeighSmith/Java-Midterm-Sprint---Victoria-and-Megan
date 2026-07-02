/**
 * The Person class is the parent class for patients and doctors.
 * It stores the information that both classes have in common.
 *
 * @author Megan Hickey
 * @author Victoria Smith
 */

public abstract class Person {

    // Declare variables
    protected int id;
    protected String name;
    protected int age;
    protected String phoneNumber;

    // Constructors

    /**
     * Default constructor.
     */

    public Person() {

    }

    /**
     * Creates a new person.
     *
     * @param id          The person's ID.
     * @param name        The person's name.
     * @param age         The person's age.
     * @param phoneNumber The person's phone number.
     */

    public Person(int id, String name, int age, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    // Getter and setter methods

    /**
     * Returns the person's ID.
     *
     * @return The person's ID.
     */

    public int getId() {
        return this.id;
    }

    /**
     * Returns the person's name.
     *
     * @return The person's name.
     */

    public String getName() {
        return this.name;
    }

    /**
     * Updates the person's name.
     *
     * @param name The new name.
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the person's age.
     *
     * @return The person's age.
     */

    public int getAge() {
        return this.age;
    }

    /**
     * Updates the person's age.
     *
     * @param age The new age.
     */

    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Returns the person's phone number.
     *
     * @return The person's phone number.
     */

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    /**
     * Updates the person's phone number.
     *
     * @param phoneNumber The new phone number.
     */

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Returns the person's information as a formatted string.
     *
     * @return Formatted person information.
     */

    @Override
    public String toString() {
        return String.format(
                "Person[id = %d, name = %s, age = %d, phone number = %s]",
                this.id,
                this.name,
                this.age,
                this.phoneNumber);
    }
}