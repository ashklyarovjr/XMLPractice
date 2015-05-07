package Task;


import Task.Medicine.Medicine;
import Task.Medicine.Version.Company.*;
import Task.Medicine.Version.Company.Package;
import Task.Medicine.Version.Version;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Node;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class DOMParser {
    public static void main(String[] args) {
        try {
            File file = new File("myxml.xml");
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document document = builder.parse(file);

            System.out.println("Main element - " + document.getDocumentElement().getNodeName());
            NodeList nodeList = document.getElementsByTagName(document.getDocumentElement().getChildNodes().item(1).getNodeName());

            System.out.println("-------------------------------------");
            Medicine medicine;
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    org.w3c.dom.Element element = (org.w3c.dom.Element) node;

                    String name = element.getElementsByTagName("name").item(0).getChildNodes().item(0).getNodeValue();
                    String pharm = element.getElementsByTagName("pharm").item(0).getChildNodes().item(0).getNodeValue();
                    String group = element.getElementsByTagName("group").item(0).getChildNodes().item(0).getNodeValue();

                    medicine = new Medicine(name, pharm, group);

                    NodeList analogs = element.getElementsByTagName("analogs").item(0).getChildNodes();
                    for (int j = 0; j < analogs.getLength(); j++) {
                        Node node1 = analogs.item(j);
                        if (node1.getNodeType() == Node.ELEMENT_NODE)
                            medicine.addAnalog(analogs.item(j).getChildNodes().item(0).getNodeValue());
                    }

                    NodeList versions = element.getElementsByTagName("versions").item(0).getChildNodes();
                    int verLen = versions.getLength();
                    int index = 0;
                    for (int j = 0; j < versions.getLength(); j++) {
                        Node node1 = versions.item(j);

                        if (node1.getNodeType() == Node.ELEMENT_NODE) {

                            String versionName = element.getElementsByTagName("vname").item(index).getChildNodes().item(0).getNodeValue();

                            Version version = new Version(versionName);
                            NodeList companies = element.getElementsByTagName("companies").item(0).getChildNodes();

                            for (int k = 0; k < companies.getLength(); k++) {

                                Node node2 = companies.item(k);

                                if (node2.getNodeType() == Node.ELEMENT_NODE) {

                                    Company company;

                                    Certificate certificate = new Certificate();

                                    certificate.setNumber(Integer.parseInt(element.getElementsByTagName("number").item(index).getChildNodes().item(0).getNodeValue()));
                                    certificate.setExpirationDate(element.getElementsByTagName("expiration-date").item(index).getChildNodes().item(0).getNodeValue());
                                    certificate.setRegistrationCompany(element.getElementsByTagName("registration-company").item(index).getChildNodes().item(0).getNodeValue());

                                    Dosage dosage = new Dosage();
                                    dosage.setAmount(element.getElementsByTagName("amount").item(index).getChildNodes().item(0).getNodeValue());
                                    dosage.setPeriod(element.getElementsByTagName("period").item(index).getChildNodes().item(0).getNodeValue());

                                    Package aPack = new Package();
                                    aPack.setType(element.getElementsByTagName("type").item(index).getChildNodes().item(0).getNodeValue());
                                    aPack.setAmount(element.getElementsByTagName("items-amount").item(index).getChildNodes().item(0).getNodeValue());
                                    aPack.setPrice(element.getElementsByTagName("price").item(index).getChildNodes().item(0).getNodeValue());

                                    index++;

                                    company = new Company(certificate, dosage, aPack);

                                    version.addCompany(company);
                                }
                            }
                            medicine.addVersion(version);
                        }
                    }
                    System.out.println(medicine.toString());
                }

            }

        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
    }


}




