package Task.Medicine_Structure.Version.Company;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "dosage")
public class Dosage {


    private String amount;


    private String period;

    public Dosage() {
        super();
    }

    public Dosage(String amount, String period) {
        this.setAmount(amount);
        this.setPeriod(period);
    }

    public String getAmount() {
        return amount;
    }

    @XmlElement(name = "amount")
    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getPeriod() {
        return period;
    }

    @XmlElement(name = "period")
    public void setPeriod(String period) {
        this.period = period;
    }

    @Override
    public String toString() {
        return " Dosage: " + "\n" +
                "  Amount: " + getAmount() + "\n" +
                "  Period: " + getPeriod();
    }
}
