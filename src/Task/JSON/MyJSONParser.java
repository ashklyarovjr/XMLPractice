package Task.JSON;

import Task.Medicine_Structure.Medicines;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MyJSONParser {
    public static Medicines buildFromJSON (String filePath) {

        String name;
        String pharm;
        String group;
        String vname;
        String analog;
        String number;
        String expDate;
        String regCompany;
        String amount;
        String period;
        String type;
        String itAmount;
        String price;

        try {
            FileReader reader = new FileReader(filePath);
            JSONParser parser = new JSONParser();

            JSONArray jsonArray = (JSONArray) parser.parse(reader);

            int length = jsonArray.size();

            for (Object object  : jsonArray) {
                JSONObject jsonObject = (JSONObject) object;

                for (int i = 0;  i < jsonObject.keySet().size(); i++) {
                    JSONArray medicine = (JSONArray) jsonObject.get("medicine" + (++i));

                    for (int j = 0; j < medicine.size(); j++) {
                        JSONObject innerObject = (JSONObject) medicine.get(i);
                    }
                }
            }










        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    /*public static void write*/

    public static void main(String[] args) {
        buildFromJSON("medicines.json");

    }
}
