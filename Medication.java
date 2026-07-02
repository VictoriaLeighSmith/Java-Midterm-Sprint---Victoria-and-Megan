import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * The Medication class stores information about a medication.
 * It includes the medication's name, dose, quantity in stock,
 * and expiry date.
 *
 * @author Megan Hickey
 * @author Victoria Smith
 */

public class Medication {

    // Declare variables
    private int id;
    private String name;
    private String dose;
    private int quantityInStock;
    private LocalDate expiryDate;

    // Constructors

    /**
     * Default constructor.
     */

    public Medication() {

    }

    /**
     * Creates a new medication.
     *
     * @param id              The medication ID.
     * @param name            The medication name.
     * @param dose            The medication dose.
     * @param quantityInStock The quantity currently in stock.
     * @param expiryDate      The medication expiry date.
     */

    public Medication(int id, String name, String dose, int quantityInStock, LocalDate expiryDate) {
        this.id = id;
        this.name = name;
        this.dose = dose;
        this.quantityInStock = quantityInStock;
        this.expiryDate = expiryDate;
    }

    // Getter and setter methods

    /**
     * Returns the medication ID.
     *
     * @return The medication ID.
     */

    public int getId() {
        return this.id;
    }

    /**
     * Returns the medication name.
     *
     * @return The medication name.
     */

    public String getName() {
        return this.name;
    }

    /**
     * Updates the medication name.
     *
     * @param name The new medication name.
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the medication dose.
     *
     * @return The medication dose.
     */

    public String getDose() {
        return this.dose;
    }

    /**
     * Updates the medication dose.
     *
     * @param dose The new medication dose.
     */

    public void setDose(String dose) {
        this.dose = dose;
    }

    /**
     * Returns the quantity currently in stock.
     *
     * @return The quantity in stock.
     */

    public int getQuantityInStock() {
        return this.quantityInStock;
    }

    /**
     * Updates the quantity currently in stock.
     *
     * @param quantityInStock The new quantity in stock.
     */

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    /**
     * Returns the medication expiry date.
     *
     * @return The expiry date.
     */

    public LocalDate getExpiryDate() {
        return this.expiryDate;
    }

    /**
     * Updates the medication expiry date.
     *
     * @param expiryDate The new expiry date.
     */

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    /**
     * Returns the medication information as a formatted string.
     *
     * @return Formatted medication information.
     */

    @Override
    public String toString() {
        return String.format(
                "Medication[id = %d, name = %s, dose = %s, quantity in stock = %d, expiry date = %s]",
                this.id,
                this.name,
                this.dose,
                this.quantityInStock,
                this.expiryDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
    }
}