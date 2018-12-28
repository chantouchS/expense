public class Data {
    private String type, detail;
    private String amount;

    public Data(String type, String description, String amount) {
        this.amount = amount;
        this.type = type;
        this.detail = description;
    }

    public String getType() {
        return type;
    }

    public String getDetail() {
        return detail;
    }

    public String getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        String record = "";
        record += type + " : ";
        record += detail + " ";
        record += type.equals("Income")?"+" + amount:"-" + amount;
        return record;
    }
}
