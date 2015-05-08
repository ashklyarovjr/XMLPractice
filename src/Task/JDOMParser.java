package Task;

import Task.Medicine.Medicine;
import Task.Medicine.Version.Company.Certificate;
import Task.Medicine.Version.Company.Company;
import Task.Medicine.Version.Company.Dosage;
import Task.Medicine.Version.Company.Package;
import Task.Medicine.Version.Version;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Document;

public class JDOMParser {

    public static List<Medicine> JDOMParse() {
        List<Medicine> medicines = new ArrayList<>();
        SAXBuilder saxBuilder = new SAXBuilder();
        File file = new File("myxml.xml");
        try {

            Document document = saxBuilder.build(file);
            Element element = document.getRootElement();

            List listElement = element.getChildren("medicine");

            Medicine medicine;
            for (int i = 0; i < listElement.size(); i++) {
                Element node = (Element) listElement.get(i);

                String name = node.getChildText("name");
                String pharm = node.getChildText("pharm");
                String group = node.getChildText("group");

                medicine = new Medicine(name, pharm, group);

                List<Element> analogs = node.getChild("analogs").getChildren("analog");
                for (int j = 0; j < analogs.size(); j++) {
                    Element node1 = analogs.get(j);
                    medicine.addAnalog(node1.getValue());
                }

                List<Element> versions = node.getChild("versions").getChildren("version");
                for (Element element1 : versions ) {


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

                        Task.Medicine.Version.Company.Package aPack = new Package();
                        aPack.setType(element2.getChild("package").getChildText("type"));
                        aPack.setAmount(element2.getChild("package").getChildText("items-amount"));
                        aPack.setPrice(element2.getChild("package").getChildText("price"));


                        company = new Company(certificate, dosage, aPack);

                        version.addCompany(company);
                    }

                    medicine.addVersion(version);

                }
                System.out.println(medicine.toString());
                medicines.add(medicine);
            }
        } catch (JDOMException | IOException e1) {
            e1.printStackTrace();
        }
    return medicines;
    }
}

