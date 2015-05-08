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
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jdom2.Document;

public class JDOMParser {
    public static void main(String[] args) {
        SAXBuilder saxBuilder = new SAXBuilder();
        File file = new File("myxml.xml");
        try {

            Document document = saxBuilder.build(file);
            Element element = document.getRootElement();
            System.out.println("Main element - " + element);

            List listElement = element.getChildren("medicine");

            System.out.println("-------------------------------------");
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
                for (int j = 0; j < versions.size(); j++) {
                    Element node1 = versions.get(i);

                    String versionName = node1.getChildText("vname");

                    Version version = new Version(versionName);

                    List<Element> companies = node1.getChild("companies").getChildren("company");
                    for (int k = 0; k < companies.size(); k++) {

                        Element node2 = companies.get(i);
                        Company company;

                        Certificate certificate = new Certificate();

                        certificate.setNumber(Integer.parseInt(node2.getChild("certificate").getChildText("number")));
                        certificate.setExpirationDate(node2.getChild("certificate").getChildText("expiration-date"));
                        certificate.setRegistrationCompany(node2.getChild("certificate").getChildText("registration-company"));

                        Dosage dosage = new Dosage();
                        dosage.setAmount(node2.getChild("dosage").getChildText("amount"));
                        dosage.setPeriod(node2.getChild("dosage").getChildText("period"));

                        Task.Medicine.Version.Company.Package aPack = new Package();
                        aPack.setType(node2.getChild("package").getChildText("type"));
                        aPack.setAmount(node2.getChild("package").getChildText("items-amount"));
                        aPack.setPrice(node2.getChild("package").getChildText("price"));


                        company = new Company(certificate, dosage, aPack);

                        version.addCompany(company);
                    }

                    medicine.addVersion(version);
                }

                System.out.println(medicine.toString());


            }
        } catch (JDOMException | IOException e1) {
            e1.printStackTrace();
        }

    }
}

