import java.util.Scanner;

public class Main {
    public void start(){

        Ledger ledgerAccount;
        ledgerAccount = new Ledger();
        Scanner in = new Scanner(System.in);
        while(true){
            int state = ledgerAccount.getState();
            if(state == Ledger.TRANSACT){
                System.out.print("Enter 1 = Income , Enter 2 = Expenses , Enter 0 = Exit " + " ");
                int number = in.nextInt();
                if(number == 1){
                    System.out.print("Enter your income : ");
                    double income = in.nextDouble();
                    System.out.print("Enter your Details : ");
                    in.useDelimiter("\n");
                    String details = in.next();
                    ledgerAccount.income(income,details);
                }
                else if(number == 2){
                    System.out.print("Enter your expenses: ");
                    double expenses = in.nextDouble();
                    System.out.print("Enter your Details : ");
                    in.useDelimiter("\n");
                    String details = in.next();
                    try {
                        ledgerAccount.expense(expenses,details);
                    } catch (OverExpenseException e) {
                        System.out.println(e.getMessage());
                    }
                }
                else if(number == 0){
                    break;
                }
            }
        }
        System.out.println("\n" + ledgerAccount.getTotal());
        System.out.println(ledgerAccount.getBalance());
    }
}
