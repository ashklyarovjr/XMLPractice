package Task.Medicine_Structure.Version.Company;


import javax.xml.bind.annotation.XmlElement;

public class Certificate {
    @XmlElement
    private int number;
    @XmlElement
    private String expirationDate;
    @XmlElement
    private String registrationCompany;

    public Certificate() {
        super();
    }

    public Certificate(int number, String expirationDate, String registrationCompany) {
        this.setNumber(number);
        this.setExpirationDate(expirationDate);
        this.setRegistrationCompany(registrationCompany);
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getRegistrationCompany() {
        return registrationCompany;
    }

    public void setRegistrationCompany(String registrationCompany) {
        this.registrationCompany = registrationCompany;
    }

    @Override
    public String toString() {
        return " Certificate: " +
                "  Number: " + getNumber() + "\n" +
                "  Expiration Date: " + getExpirationDate() + "\n" +
                "  Registration Company: " + getRegistrationCompany();
    }
}
