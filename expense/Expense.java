package expense;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Expense {

    private int expenseId;
    private String category;
    private String description;
    private double amount;
    private LocalDate date;

    public Expense(int expenseId, String category,
                   String description, double amount,
                   LocalDate date) {

        this.expenseId = expenseId;
        this.category = category;
        this.description = description;
        this.amount = amount;
        this.date = date;
    }

    public int getExpenseId() {
        return expenseId;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd-MM-yyyy");

        return "Expense ID: " + expenseId
                + " | Category: " + category
                + " | Description: " + description
                + " | Amount: Rs." + String.format("%.2f", amount)
                + " | Date: " + date.format(formatter);
    }
}