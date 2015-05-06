package Task.Medicine.Version.Company;


public class Company {
    private Certificate certificate;
    private Dosage dosage;
    private Package aPackage;

    public Company(Certificate certificate, Dosage dosage, Package aPackage) {
        this.setCertificate(certificate);
        this.setDosage(dosage);
        this.setaPackage(aPackage);
    }

    public Certificate getCertificate() {
        return certificate;
    }

    public void setCertificate(Certificate certificate) {
        this.certificate = certificate;
    }

    public Dosage getDosage() {
        return dosage;
    }

    public void setDosage(Dosage dosage) {
        this.dosage = dosage;
    }

    public Package getaPackage() {
        return aPackage;
    }

    public void setaPackage(Package aPackage) {
        this.aPackage = aPackage;
    }

    @Override
    public String toString() {
        return "Company: " + "\n" +
                getCertificate().toString() + "\n" +
                getDosage().toString() + "\n" +
                getaPackage().toString();
    }
}
