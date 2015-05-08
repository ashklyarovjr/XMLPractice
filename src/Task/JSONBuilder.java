package Task;

import Task.Medicine.Medicine;
import Task.Medicine.Version.Company.Company;
import Task.Medicine.Version.Version;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


public class JSONBuilder {
    public static JSONArray buildJSON (List<Medicine> list) {

        JSONObject jsonMedicine;
        JSONObject jsonCertificate;
        JSONObject jsonDosage;
        JSONObject jsonPackage;
        JSONObject jsonAnalogs;
        JSONObject jsonCompany;
        JSONObject jsonVersion;

        JSONArray jsonMedsArray = new JSONArray();

        for (Medicine medicine : list) {

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
            jsonMedsArray.add(jsonMedicine);
        }
        return jsonMedsArray;
    }

    public static void main(String[] args) throws IOException {
        File file = new File("medicines.json");
        FileWriter fw = null;
        try {
            fw = new FileWriter(file);
            fw.write(buildJSON(JDOMParser.JDOMParse()).toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fw != null) {
                fw.close();
            }
        }

    }
}
