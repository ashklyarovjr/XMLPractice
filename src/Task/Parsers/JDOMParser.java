package Task.Parsers;

import Task.AbstractMedBuilder;
import Task.Medicine_Structure.Medicine;
import Task.Medicine_Structure.Medicines;
import Task.Medicine_Structure.Version.Company.Certificate;
import Task.Medicine_Structure.Version.Company.Company;
import Task.Medicine_Structure.Version.Company.Dosage;
import Task.Medicine_Structure.Version.Company.Package;
import Task.Medicine_Structure.Version.Version;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jdom2.Document;

public class JDOMParser extends AbstractMedBuilder{

    @Override
    public Medicines parse(String fileName) {

        SAXBuilder saxBuilder = new SAXBuilder();
        File file = new File(fileName);
        try {

            Document document = saxBuilder.build(file);
            Element element = document.getRootElement();

            List listElement = element.getChildren("medicine");

            Medicine medicine;
            for (Object aListElement : listElement) {
                Element node = (Element) aListElement;

                String name = node.getChildText("name");
                String pharm = node.getChildText("pharm");
                String group = node.getChildText("group");

                medicine = new Medicine(name, pharm, group);

                List<Element> analogs = node.getChild("analogs").getChildren("analog");
                for (Element node1 : analogs) {
                    medicine.addAnalog(node1.getValue());
                }

                List<Element> versions = node.getChild("versions").getChildren("version");
                for (Element element1 : versions) {


                    String versionName = element1.getChildText("vname");

                    Version version = new Version(versionName);

                    List<Element> companies = element1.getChild("companies").getChildren("company");
                    for (Element element2 : companies) {

                        Company company;

                        Certificate certificate = new Certificate();

                        certificate.setNumber(Integer.parseInt(element2.getChild("certificate").getChildText("number")));
                        certificate.setExpirationDate(element2.getChild("certificate").getChildText("expiration-date"));
                        certificate.setRegistrationCompany(element2.getChild("certificate").getChildText("registration-company"));

                        Dosage dosage = new Dosage();
                        dosage.setAmount(element2.getChild("dosage").getChildText("amount"));
                        dosage.setPeriod(element2.getChild("dosage").getChildText("period"));

                        Package aPack = new Package();
                        aPack.setType(element2.getChild("package").getChildText("type"));
                        aPack.setAmount(element2.getChild("package").getChildText("items-amount"));
                        aPack.setPrice(element2.getChild("package").getChildText("price"));


                        company = new Company(certificate, dosage, aPack);

                        version.addCompany(company);
                    }

                    medicine.addVersion(version);

                }
                System.out.println(medicine.toString());
                getMedicines().addMedicine(medicine);
            }
        } catch (JDOMException | IOException e1) {
            e1.printStackTrace();
        }
        return getMedicines();
    }
}

