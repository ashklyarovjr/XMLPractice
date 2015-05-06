package Task.Medicine.Version.Company;

import java.util.Date;


public class Certificate {
    private int number;
    private Date expirationDate;
    private String registrationCompany;

    public Certificate(int number, Date expirationDate, String registrationCompany) {
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

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
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
