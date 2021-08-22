package com.work;

import java.io.File;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.MappingJsonFactory;

/**
 * java流式加载json文件
 */
public class ParseJsonSample {
    public static void main(String[] args) {
        try {
            // json文件
            String json_file_name = "HelloWorld.json";
            File file = new File(json_file_name);

            JsonFactory f = new MappingJsonFactory();
            JsonParser jp = f.createJsonParser(file);
            JsonToken current;
            current = jp.nextToken();
            if (current != JsonToken.START_OBJECT) {
                System.out.println("Error: root should be object: quiting.");
                return;
            }
            while (jp.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = jp.getCurrentName();
                // move from field name to field value
                current = jp.nextToken();
                if (fieldName.equals("data")) {
                    if (current == JsonToken.START_ARRAY) {
                        // For each of the records in the array
                        while (jp.nextToken() != JsonToken.END_ARRAY) {
                            // read the record into a tree model,
                            // this moves the parsing position to the end of it
                            JsonNode node = jp.readValueAsTree();
                            // And now we have random access to everything in the object
                            System.out.println("path: " + node.get("path").getValueAsText());
                            System.out.println("file: " + node.get("file").getValueAsText());
                            System.out.println("commond: " + node.get("commond").getValueAsText());
                            System.out.println("********************************************");
                        }
                    } else {
                        System.out.println("Error: records should be an array: skipping.");
                        jp.skipChildren();
                    }
                } else {
                    System.out.println("Unprocessed property: " + fieldName);
                    jp.skipChildren();
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
