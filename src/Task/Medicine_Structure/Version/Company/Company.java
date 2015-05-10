package Task.Medicine_Structure.Version.Company;

import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Company {

    @XmlElement
    private Certificate certificate;

    @XmlElement
    private Dosage dosage;

    @XmlElement
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
        return "\n" + "Company: " + "\n" +
                getCertificate().toString() + "\n" +
                getDosage().toString() + "\n" +
                getaPackage().toString();
    }
}
