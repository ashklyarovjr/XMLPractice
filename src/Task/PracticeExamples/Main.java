package Task.PracticeExamples; /**
 * Created by Anton_Shkliarov on 5/6/2015.
 */
import org.json.simple.JSONObject;

public class Main {
    public static void main(String[] args) {
        JSONObject obj = new JSONObject();

        obj.put("name", "foo");
        obj.put("num", 100);
        obj.put("balance", 1000.21);
        obj.put("is_vip", true);

        System.out.print(obj);
    }

}
