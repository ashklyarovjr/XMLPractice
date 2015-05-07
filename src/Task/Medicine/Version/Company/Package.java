package Task.Medicine.Version.Company;


public class Package {
    private String type;
    private String amount;
    private String price;

    public Package() {
        super();
    }

    public Package(String type, String amount, String price) {
        this.setType(type);
        this.setAmount(amount);
        this.setPrice(price);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return " Package: " + "\n" +
                "  Type: " + getType() + "\n" +
                "  Amount: " + getAmount() + "\n" +
                "  Price: " + getPrice();
    }
}
