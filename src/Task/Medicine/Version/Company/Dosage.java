package Task.Medicine.Version.Company;


public class Dosage {
    private int amount;
    private int period;

    public Dosage(int amount, int period) {
        this.setAmount(amount);
        this.setPeriod(period);
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    @Override
    public String toString() {
        return " Dosage: " + "\n" +
                "  Amount: " + getAmount() + "\n" +
                "  Period: " + getPeriod();
    }
}
