package Task.Medicine.Version.Company;

/**
 * Created by Anton_Shkliarov on 5/6/2015.
 */
public class Package {
    private String type;
    private int amount;
    private double price;

    public Package(String type, int amount, double price) {
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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return " Package: " + "\n" +
                "  Type: " + getType() + "\n" +
                "  Amount: " + getAmount() + "\n" +
                "  Price: " + getPrice() + " UAH";
    }
}
