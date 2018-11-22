import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Account {

    private int balanceMoney;
    private ArrayList<History> transactions = new ArrayList<>();
    private Boolean edit =false;
    private int editNum;

    public Account() {
        this.balanceMoney = 0;
    }

    public Account(int balanceMoney){
        this.balanceMoney = balanceMoney;
    }

    public void income(String des, int money,String date) {
        balanceMoney = balanceMoney + money;
        transactions.add(new History(money, des, "income",date));
    }

    public void expense(String des, int money,String date) {
        if (money > balanceMoney){
            System.out.println("Your have negative balance.");
        }
        balanceMoney = balanceMoney - money;
        transactions.add(new History(money, des, "expense",date));
    }

    public void checkEdit(String type,String des, int money,String date){
        for (int i = 0 ; i < transactions.size() ; i++){
            if (type.equals(transactions.get(i).getTypeAccount()) &&des.equals(transactions.get(i).getDescription())
                    && money == transactions.get(i).getMoney() && date.equals(transactions.get(i).getDate())){
                edit = true;
                editNum = i;
                this.balanceMoney = 0;
            }else {
                edit = false;
            }
        }

    }

    public void editMoney(String type,String des, int money,String date){
        if (edit){
            transactions.get(editNum).setTypeAccount(type);
            transactions.get(editNum).setDescription(des);
            transactions.get(editNum).setMoney(money);
            transactions.get(editNum).setDate(date);
            changeBalance();
            edit = false;
        }

    }

    public void changeBalance(){
        for (int i = 0 ; i < transactions.size() ; i++){
            if (transactions.get(i).getTypeAccount().equals("income")){
                this.balanceMoney = this.balanceMoney + transactions.get(i).getMoney();
            }else{
                this.balanceMoney = this.balanceMoney - transactions.get(i).getMoney();
            }

        }
    }
    public int getBalanceMoney() {
        return balanceMoney;
    }

    public String resultHistory() {
        String result = "";
        for(int loop = 0; loop < transactions.size(); loop++){
            result = result + transactions.get(loop).getTypeAccount() + " : " + transactions.get(loop).getMoney()
                    + " , description :  " + transactions.get(loop).getDescription() + " , date : " + transactions.get(loop).getDate() + "\n";
        }
        return result;
    }

    public Boolean getEdit() {
        return edit;
    }

    public void saveFiles(String filename){
        File file = new File(filename);
        FileWriter writer;
        try {
            writer = new FileWriter(file, true);
            for (int i =0; i<transactions.size();i++){
                writer.write(transactions.get(i).getTypeAccount() + " ");
                writer.write(transactions.get(i).getDate() + " ");
                writer.write(transactions.get(i).getDescription() + " ");
                writer.write(transactions.get(i).getMoney() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
