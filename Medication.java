import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Medication {

    // Declare variables
    private int id;
    private String name;
    private String dose;
    private int quantityInStock;
    private LocalDate expiryDate;

    // Constructors
    public Medication() {

    }

    public Medication(int id, String name, String dose, int quantityInStock, LocalDate expiryDate) {
        this.id = id;
        this.name = name;
        this.dose = dose;
        this.quantityInStock = quantityInStock;
        this.expiryDate = expiryDate;
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

    public String getDose() {
        return this.dose;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }

    public int getQuantityInStock() {
        return this.quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public LocalDate getExpiryDate() {
        return this.expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    // Override toString method
    @Override
    public String toString() {
        return String.format("Medication[id = %d, name = %s, dose = %s, quantity in stock = %d, expiry date = %s]",
                this.id,
                this.name, this.dose, this.quantityInStock,
                this.expiryDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
    }
}
