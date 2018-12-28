public class History {
    private int money;
    private String description;
    private String typeAccount;
    private String date;

    public History(int money, String description, String typeAccount, String date) {
        this.money = money;
        this.description = description;
        this.typeAccount = typeAccount;
        this.date = date;
    }

    public int getMoney() {
        return money;
    }

    public String getDescription() {
        return description;
    }

    public String getTypeAccount() {
        return typeAccount;
    }

    public String getDate() {
        return date;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTypeAccount(String typeAccount) {
        this.typeAccount = typeAccount;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
