package Task;


import Task.Medicine.Medicine;
import Task.Medicine.Version.Company.*;
import Task.Medicine.Version.Version;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.jar.Attributes;
import Task.Medicine.Version.Company.Package;


public class Handler extends DefaultHandler {

    private Medicine medicine = null;
    private Version version = null;
    private Company company = null;
    private Dosage dosage = null;
    private Certificate certificate = null;
    private Package aPackage = null;
    String content = null;

    private List<Medicine> medicines;


    public List<Medicine> getMedicines() {
        return medicines;
    }

    public void setMedicines(List<Medicine> medicines) {
        this.medicines = medicines;
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }

    public Version getVersion() {
        return version;
    }

    public void setVersion(Version version) {
        this.version = version;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Dosage getDosage() {
        return dosage;
    }

    public void setDosage(Dosage dosage) {
        this.dosage = dosage;
    }

    public Certificate getCertificate() {
        return certificate;
    }

    public void setCertificate(Certificate certificate) {
        this.certificate = certificate;
    }

    public Package getaPackage() {
        return aPackage;
    }

    public void setaPackage(Package aPackage) {
        this.aPackage = aPackage;
    }


    public void startElement (String uri, String localName, String qName, org.xml.sax.Attributes attributes)
            throws SAXException
    {
        switch (qName) {
            case "medicine":
                setMedicine(new Medicine());
                setMedicines(new ArrayList<>());
                break;
            case "version":
                setVersion(new Version());
                break;
            case "company":
                setCompany(new Company());
                break;
            case "dosage":
                setDosage(new Dosage());
                break;
            case "certificate":
                setCertificate(new Certificate());
                break;
            case "package":
                setaPackage(new Package());
                break;
        }
    }

    public void endElement(String uri, String localName, String qName) {
        switch (qName) {
            case "medicine":
                getMedicines().add(getMedicine());
                break;
            case "version":
                getMedicine().addVersion(getVersion());
                break;
            case "company":
                getVersion().addCompany(getCompany());
                break;
            case "dosage":
                getCompany().setDosage(getDosage());
                break;
            case "certificate":
                getCompany().setCertificate(getCertificate());
                break;
            case "package":
                getCompany().setaPackage(getaPackage());
                break;
            case "analog":
                getMedicine().addAnalog(content);
                break;
            case "name":
                getMedicine().setName(content);
                break;
            case "group":
                getMedicine().setGroup(content);
                break;
            case "vname":
                getVersion().setVersion(content);
                break;
            case "number":
                getCertificate().setNumber(Integer.parseInt(content));
                break;
            case "expiration-date":
                getCertificate().setExpirationDate(content);
                break;
            case "registration-company":
                getCertificate().setRegistrationCompany(content);
                break;
            case "amount":
                getDosage().setAmount(content);
                break;
            case "period":
                getDosage().setPeriod(content);
                break;
            case "type":
                getaPackage().setType(content);
                break;
            case "items-amount":
                getaPackage().setAmount(content);
                break;
            case "price":
                getaPackage().setPrice(content);
                break;
            case "medicines":
                System.out.println(getMedicines());
        }
    }

    public void characters(char ch[], int start, int length) {
        content = String.copyValueOf(ch, start, length).trim();
    }
}
