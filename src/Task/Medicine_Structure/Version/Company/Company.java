package Task.Medicine_Structure.Version.Company;

import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "company")
public class Company {


    private Certificate certificate;


    private Dosage dosage;


    private Package aPackage;

    public Company() {
        super();
    }

    public Company(Certificate certificate, Dosage dosage, Package aPackage) {
        this.setCertificate(certificate);
        this.setDosage(dosage);
        this.setaPackage(aPackage);
    }

    public Certificate getCertificate() {
        return certificate;
    }

    @XmlElement(name = "certificate")
    public void setCertificate(Certificate certificate) {
        this.certificate = certificate;
    }

    public Dosage getDosage() {
        return dosage;
    }

    @XmlElement(name = "dosage")
    public void setDosage(Dosage dosage) {
        this.dosage = dosage;
    }

    public Package getaPackage() {
        return aPackage;
    }

    @XmlElement(name = "package")
    public void setaPackage(Package aPackage) {
        this.aPackage = aPackage;
    }

    @Override
    public String toString() {
        return "\n" + "Company: " + "\n" +
                getCertificate().toString() + "\n" +
                getDosage().toString() + "\n" +
                getaPackage().toString();
    }
}
