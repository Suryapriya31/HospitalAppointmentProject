package expense;

import java.time.LocalDate;
import java.util.Scanner;

public class ExpenseApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ExpenseManager manager =
                new ExpenseManager();

        while (true) {

            System.out.println();
            System.out.println("================================");
            System.out.println("     PERSONAL EXPENSE TRACKER");
            System.out.println("================================");

            System.out.println("1. Add Expense");
            System.out.println("2. View All Expenses");
            System.out.println("3. Search Expense");
            System.out.println("4. Update Expense");
            System.out.println("5. Delete Expense");
            System.out.println("6. Total Expense");
            System.out.println("7. Category-wise Expense");
            System.out.println("8. Monthly Expense");
            System.out.println("9. Display Categories");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");

            String choice = sc.nextLine();

            try {

                switch (choice) {

                case "1":

                    System.out.println();
                    System.out.println(
                            "===== ADD EXPENSE =====");

                    System.out.print(
                            "Enter Expense ID: ");

                    int expenseId =
                            Integer.parseInt(
                                    sc.nextLine());

                    System.out.print(
                            "Enter Category: ");

                    String category =
                            sc.nextLine();

                    System.out.print(
                            "Enter Description: ");

                    String description =
                            sc.nextLine();

                    System.out.print(
                            "Enter Amount: ");

                    double amount =
                            Double.parseDouble(
                                    sc.nextLine());

                    System.out.print(
                            "Enter Date (dd-MM-yyyy): ");

                    String dateInput =
                            sc.nextLine();

                    LocalDate date =
                            manager.parseDate(
                                    dateInput);

                    Expense expense =
                            new Expense(
                                    expenseId,
                                    category,
                                    description,
                                    amount,
                                    date);

                    manager.addExpense(expense);

                    pause(sc);

                    break;


                case "2":

                    manager.viewAllExpenses();

                    pause(sc);

                    break;


                case "3":

                    System.out.println();
                    System.out.println(
                            "===== SEARCH EXPENSE =====");

                    System.out.print(
                            "Enter Expense ID: ");

                    int searchId =
                            Integer.parseInt(
                                    sc.nextLine());

                    manager.searchExpense(
                            searchId);

                    pause(sc);

                    break;


                case "4":

                    System.out.println();
                    System.out.println(
                            "===== UPDATE EXPENSE =====");

                    System.out.print(
                            "Enter Expense ID: ");

                    int updateId =
                            Integer.parseInt(
                                    sc.nextLine());

                    System.out.print(
                            "Enter New Category: ");

                    String newCategory =
                            sc.nextLine();

                    System.out.print(
                            "Enter New Description: ");

                    String newDescription =
                            sc.nextLine();

                    System.out.print(
                            "Enter New Amount: ");

                    double newAmount =
                            Double.parseDouble(
                                    sc.nextLine());

                    System.out.print(
                            "Enter New Date (dd-MM-yyyy): ");

                    String newDateInput =
                            sc.nextLine();

                    LocalDate newDate =
                            manager.parseDate(
                                    newDateInput);

                    manager.updateExpense(
                            updateId,
                            newCategory,
                            newDescription,
                            newAmount,
                            newDate);

                    pause(sc);

                    break;


                case "5":

                    System.out.println();
                    System.out.println(
                            "===== DELETE EXPENSE =====");

                    System.out.print(
                            "Enter Expense ID: ");

                    int deleteId =
                            Integer.parseInt(
                                    sc.nextLine());

                    manager.deleteExpense(
                            deleteId);

                    pause(sc);

                    break;


                case "6":

                    manager.calculateTotalExpense();

                    pause(sc);

                    break;


                case "7":

                    System.out.println();
                    System.out.println(
                            "===== CATEGORY-WISE EXPENSE =====");

                    System.out.print(
                            "Enter Category: ");

                    String searchCategory =
                            sc.nextLine();

                    manager.categoryWiseExpense(
                            searchCategory);

                    pause(sc);

                    break;


                case "8":

                    System.out.println();
                    System.out.println(
                            "===== MONTHLY EXPENSE =====");

                    System.out.print(
                            "Enter Month (1-12): ");

                    int month =
                            Integer.parseInt(
                                    sc.nextLine());

                    System.out.print(
                            "Enter Year: ");

                    int year =
                            Integer.parseInt(
                                    sc.nextLine());

                    manager.monthlyExpense(
                            month,
                            year);

                    pause(sc);

                    break;


                case "9":

                    manager.displayCategories();

                    pause(sc);

                    break;


                case "0":

                    System.out.println();
                    System.out.println(
                            "Thank you for using "
                            + "Personal Expense Tracker.");

                    sc.close();

                    return;


                default:

                    System.out.println();
                    System.out.println(
                            "ERROR: Invalid choice. "
                            + "Please enter 0 to 9.");

                    pause(sc);

                    break;
                }

            } catch (NumberFormatException e) {

                System.out.println();
                System.out.println(
                        "ERROR: Please enter a valid number.");

                pause(sc);

            } catch (ExpenseException e) {

                System.out.println();
                System.out.println(
                        "ERROR: " + e.getMessage());

                pause(sc);
            }
        }
    }


    public static void pause(Scanner sc) {

        System.out.println();
        System.out.println(
                "Press ENTER to return to the main menu...");

        sc.nextLine();
    }
}