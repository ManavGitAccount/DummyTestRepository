package Tests.TrackData.data;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

public class DataReader {

    public List<HashMap<String, String>> getJsonDataToMap() throws IOException {

        //read json to string
        String jsonContent = FileUtils.readFileToString(new File("C:\\Users\\manav\\manav_java2_project\\manav_java2_project\\" +
                "manav_java2_selenium_project\\src\\test\\java\\Tests\\TrackData\\data\\PurchaseOrder.json"), StandardCharsets.UTF_8);


        ObjectMapper mapper = new ObjectMapper();
        List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {
        });
        return data;
    }
}

