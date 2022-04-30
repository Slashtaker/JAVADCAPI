import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class test {
    public static void main(String[] args) throws IOException {
        String a = "123";
        StringBuilder sb = new StringBuilder(a);
        System.out.println(sb);
//        BufferedReader br = new BufferedReader(new FileReader("D:\\Java\\JAVADCAPI\\src\\main\\java\\test.json"));
//        String line;
//        StringBuilder sb = new StringBuilder();
//        while ((line = br.readLine()) != null) {
//            sb.append(line);
//        }
//        JSONObject obj = new JSONObject(sb.toString());
//        JSONArray jsonArray = obj.getJSONArray("matches");
//        System.out.println(jsonArray.getJSONObject(0).getString("translation"));
    }
}
