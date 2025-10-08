package utils;
import com.google.gson.Gson;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
public class TestDataReader {
    private static final String TEST_DATA_PATH = "src/test/resources/testdata/loginTestData.json";
    public static Map<String, Object> getTestData(String key) {
        try (FileReader reader = new FileReader(TEST_DATA_PATH)) {
            Gson gson = new Gson();
            Map<String, Map<String, Object>> data = gson.fromJson(reader, Map.class);
            return data.get(key);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("❌ Unable to read test data file.");
        }
    }
}