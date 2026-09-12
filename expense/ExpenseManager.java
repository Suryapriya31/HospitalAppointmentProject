package expense;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ExpenseManager {

    private Map<Integer, Expense> expenses =
            new HashMap<Integer, Expense>();

    private DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("dd-MM-yyyy");


    // 1. Add Expense
    public void addExpense(Expense expense)
            throws ExpenseException {

        if (expense.getExpenseId() <= 0) {
            throw new ExpenseException(
                    "Expense ID must be greater than 0.");
        }

        if (expenses.containsKey(expense.getExpenseId())) {
            throw new ExpenseException(
                    "Expense ID already exists.");
        }

        if (expense.getCategory() == null
                || expense.getCategory().trim().isEmpty()) {
            throw new ExpenseException(
                    "Category cannot be empty.");
        }

        if (expense.getDescription() == null
                || expense.getDescription().trim().isEmpty()) {
            throw new ExpenseException(
                    "Description cannot be empty.");
        }

        if (expense.getAmount() <= 0) {
            throw new ExpenseException(
                    "Amount must be greater than 0.");
        }

        if (expense.getDate() == null) {
            throw new ExpenseException(
                    "Date cannot be empty.");
        }

        if (expense.getDate().isAfter(LocalDate.now())) {
            throw new ExpenseException(
                    "Future date is not allowed.");
        }

        expenses.put(
                expense.getExpenseId(),
                expense);

        System.out.println();
        System.out.println(
                "Expense added successfully!");

        System.out.println(expense);
    }


    // 2. View All Expenses
    public void viewAllExpenses() {

        System.out.println();
        System.out.println(
                "===== ALL EXPENSES =====");

        if (expenses.isEmpty()) {
            System.out.println(
                    "No expenses found.");
            return;
        }

        for (Expense expense :
                expenses.values()) {

            System.out.println(expense);
        }
    }


    // 3. Search Expense
    public void searchExpense(int expenseId)
            throws ExpenseException {

        Expense expense =
                expenses.get(expenseId);

        if (expense == null) {
            throw new ExpenseException(
                    "Expense not found.");
        }

        System.out.println();
        System.out.println(
                "===== EXPENSE DETAILS =====");

        System.out.println(expense);
    }


    // 4. Update Expense
    public void updateExpense(
            int expenseId,
            String category,
            String description,
            double amount,
            LocalDate date)
            throws ExpenseException {

        Expense expense =
                expenses.get(expenseId);

        if (expense == null) {
            throw new ExpenseException(
                    "Expense not found.");
        }

        if (category == null
                || category.trim().isEmpty()) {
            throw new ExpenseException(
                    "Category cannot be empty.");
        }

        if (description == null
                || description.trim().isEmpty()) {
            throw new ExpenseException(
                    "Description cannot be empty.");
        }

        if (amount <= 0) {
            throw new ExpenseException(
                    "Amount must be greater than 0.");
        }

        if (date == null) {
            throw new ExpenseException(
                    "Date cannot be empty.");
        }

        if (date.isAfter(LocalDate.now())) {
            throw new ExpenseException(
                    "Future date is not allowed.");
        }

        expense.setCategory(category);
        expense.setDescription(description);
        expense.setAmount(amount);
        expense.setDate(date);

        System.out.println();
        System.out.println(
                "Expense updated successfully!");

        System.out.println(expense);
    }


    // 5. Delete Expense
    public void deleteExpense(int expenseId)
            throws ExpenseException {

        if (!expenses.containsKey(expenseId)) {
            throw new ExpenseException(
                    "Expense not found.");
        }

        expenses.remove(expenseId);

        System.out.println();
        System.out.println(
                "Expense deleted successfully!");

        System.out.println(
                "Expense ID: " + expenseId);
    }


    // 6. Calculate Total Expense
    public void calculateTotalExpense() {

        double total = 0;

        for (Expense expense :
                expenses.values()) {

            total = total + expense.getAmount();
        }

        System.out.println();
        System.out.println(
                "===== TOTAL EXPENSE =====");

        System.out.println(
                "Total Expense: Rs."
                + String.format("%.2f", total));
    }


    // 7. Category-wise Expense
    public void categoryWiseExpense(
            String category) {

        double total = 0;
        boolean found = false;

        for (Expense expense :
                expenses.values()) {

            if (expense.getCategory()
                    .equalsIgnoreCase(category)) {

                total = total + expense.getAmount();

                found = true;
            }
        }

        System.out.println();
        System.out.println(
                "===== CATEGORY-WISE EXPENSE =====");

        if (!found) {

            System.out.println(
                    "No expenses found for category: "
                    + category);

            return;
        }

        System.out.println(
                "Category: " + category);

        System.out.println(
                "Total: Rs."
                + String.format("%.2f", total));
    }


    // 8. Monthly Expense
    public void monthlyExpense(
            int month,
            int year)
            throws ExpenseException {

        if (month < 1 || month > 12) {
            throw new ExpenseException(
                    "Month must be between 1 and 12.");
        }

        if (year < 2000
                || year > LocalDate.now().getYear()) {
            throw new ExpenseException(
                    "Invalid year.");
        }

        double total = 0;
        boolean found = false;

        for (Expense expense :
                expenses.values()) {

            LocalDate date =
                    expense.getDate();

            if (date.getMonthValue() == month
                    && date.getYear() == year) {

                total = total + expense.getAmount();

                found = true;
            }
        }

        System.out.println();
        System.out.println(
                "===== MONTHLY EXPENSE =====");

        if (!found) {

            System.out.println(
                    "No expenses found for "
                    + month + "-" + year);

            return;
        }

        System.out.println(
                "Month: " + month
                + "-" + year);

        System.out.println(
                "Total: Rs."
                + String.format("%.2f", total));
    }


    // 9. Display Categories
    public void displayCategories() {

        ArrayList<String> categories =
                new ArrayList<String>();

        for (Expense expense :
                expenses.values()) {

            String category =
                    expense.getCategory();

            if (!categories.contains(category)) {
                categories.add(category);
            }
        }

        System.out.println();
        System.out.println(
                "===== EXPENSE CATEGORIES =====");

        if (categories.isEmpty()) {

            System.out.println(
                    "No categories available.");

            return;
        }

        for (String category :
                categories) {

            System.out.println(
                    "- " + category);
        }
    }


    // Date validation
    public LocalDate parseDate(String date)
            throws ExpenseException {

        try {

            return LocalDate.parse(
                    date,
                    formatter);

        } catch (DateTimeParseException e) {

            throw new ExpenseException(
                    "Invalid date. Use dd-MM-yyyy.");
        }
    }
}