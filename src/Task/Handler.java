package Task;


import Task.Medicine.Medicine;
import Task.Medicine.Version.Company.Company;
import Task.Medicine.Version.Version;
import org.xml.sax.helpers.DefaultHandler;

import java.util.List;


public class Handler extends DefaultHandler {

    private Medicine medicine;

    private List<Version> versions;
    private List<Company> companies;
    private List<Medicine> medicines;
    private boolean bName;
    private boolean bPharm;
    private boolean bGroup;
    private boolean bAnalog;
    private boolean bVName;
    private boolean bCompany;
    private boolean bCertificate;
    private boolean bNumber;
    private boolean bExpDate;
    private boolean bRegComp;
    private boolean bDosage;
    private boolean bDosAmount;
    private boolean bDosPeriod;
    private boolean bPack;
    private boolean bPackType;
    private boolean bPackItAmount;
    private boolean bPackItPrice;



    public void startDocument(String uri,String localname, String qName) {

        if (qName.equalsIgnoreCase("name")){
            //TODO: To be continued...
        }
    }
    
    @Override
    public void endDocument() {
    }

    @Override
    public void characters(char ch[], int start, int length) {

    }
}
