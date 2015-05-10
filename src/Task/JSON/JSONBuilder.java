package Task.JSON;

import Task.AbstractMedBuilder;
import Task.MedicineFactory;
import Task.Medicine_Structure.Medicines;
import Task.Medicine_Structure.Medicine;
import Task.Medicine_Structure.Version.Company.Company;
import Task.Medicine_Structure.Version.Version;
import Task.Parsers.DOMParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class JSONBuilder {


    /**
     * Parse Medicines into JSONArray
     * @param medicines - object of Medicines class
     * @return JSONArray
     * */
    @SuppressWarnings("unchecked call")
    public static JSONArray buildJSON (Medicines medicines) {

        JSONObject jsonMedicine;
        JSONObject jsonCertificate;
        JSONObject jsonDosage;
        JSONObject jsonPackage;
        JSONObject jsonAnalogs;
        JSONObject jsonCompany;
        JSONObject jsonVersion;

        JSONArray jsonMedsArray = new JSONArray();

        JSONObject jsonMedicines = new JSONObject();

        int k = 1;
        for (Medicine medicine : medicines.getMedicines()) {

            jsonMedicine = new JSONObject();
            jsonAnalogs = new JSONObject();

            jsonMedicine.put("name", medicine.getName());
            jsonMedicine.put("pharm", medicine.getPharm());
            jsonMedicine.put("group", medicine.getGroup());

            int i = 1;
            for (String analog : medicine.getAnalogs()) {
                jsonAnalogs.put("analog" + i + "", analog);
                i++;
            }

            jsonMedicine.put("analogs", jsonAnalogs);
            i = 1;

            for (Version version : medicine.getVersions()) {
                jsonVersion = new JSONObject();
                jsonVersion.put("vname" + i, version.getVersion());
                int j = 1;
                for (Company company : version.getCompanies()) {

                    jsonCompany = new JSONObject();

                    jsonCertificate = new JSONObject();
                    jsonDosage = new JSONObject();
                    jsonPackage = new JSONObject();

                    jsonCertificate.put("number" + j, company.getCertificate().getNumber());
                    jsonCertificate.put("expiration-date" + j, company.getCertificate().getExpirationDate());
                    jsonCertificate.put("registration-company" + j, company.getCertificate().getRegistrationCompany());

                    jsonDosage.put("amount" + j, company.getDosage().getAmount());
                    jsonDosage.put("period" + j, company.getDosage().getPeriod());

                    jsonPackage.put("type" + j, company.getaPackage().getType());
                    jsonPackage.put("items-amount" + j, company.getaPackage().getAmount());
                    jsonPackage.put("price" + j, company.getaPackage().getPrice());

                    jsonCompany.put("certificate" + j, jsonCertificate);
                    jsonCompany.put("dosage" + j, jsonDosage);
                    jsonCompany.put("package" + j, jsonPackage);

                    jsonVersion.put("company" + j, jsonCompany);
                    j++;
                }
                jsonMedicine.put("version" + i, jsonVersion);
                i++;
            }
            jsonMedicines.put("medicine" + k, jsonMedicine);
            jsonMedsArray.add(jsonMedicines);
            k++;
        }
        return jsonMedsArray;
    }


    /**
     * Method writes JSONArray to .json file
     * @param filepath  - full path to the .json file
     * @param jsonObject - JSONArray object
     * */
    public static void writeIntoJSONFile(String filepath, JSONArray jsonObject) throws IOException {
        File file  =  new File(filepath);
        FileWriter fileWriter = null;
        try {
            fileWriter =  new FileWriter(file);
            fileWriter.write(jsonObject.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileWriter != null)  {
                fileWriter.close();
            }
        }
    }



    public static void main(String[] args) throws IOException {
        MedicineFactory factory = new MedicineFactory();

        AbstractMedBuilder parser = factory.medsParser("SAX");

        writeIntoJSONFile("medicines.json", buildJSON(parser.parse("myxml.xml")));

    }
}
