public abstract class Person {

    // Declare variables
    protected int id;
    protected String name;
    protected int age;
    protected String phoneNumber;

    // Constructors
    public Person() {

    }

    public Person(int id, String name, int age, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    // Getter and setter methods
    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // Override toString method
    @Override
    public String toString() {
        return String.format("Person[id = %d, name = %s, age = %d, phone number = %s]", this.id, this.name, this.age,
                this.phoneNumber);
    }
}
