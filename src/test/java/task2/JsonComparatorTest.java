package task2;

import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class JsonComparatorTest {
    private static JsonComparator jsonComparator;
    private static JSONObject jsonExpected;

    @BeforeAll
    public static void setup() {
        jsonComparator = new JsonComparator();
        jsonExpected = new JSONObject();
        jsonExpected.put("Id", 1033);
        jsonExpected.put("Content", "Ander's Item");
        jsonExpected.put("ItemType", "ignore");
        jsonExpected.put("Checked", false);
        jsonExpected.put("ProjectId", "ignore");
        jsonExpected.put("ParentId", "ignore");
        jsonExpected.put("Deleted", false);
    }

    @Test
    public void verifyCorrectComparisons() {
        JSONObject jsonActual = new JSONObject();
        System.out.println("Running verifyCorrectComparisons");
        jsonActual.put("Id", 1033);
        jsonActual.put("Content", "Ander's Item");
        jsonActual.put("ItemType", "9");
        jsonActual.put("Checked", false);
        jsonActual.put("ProjectId", "8");
        jsonActual.put("ParentId", "7");
        jsonActual.put("Deleted", false);
        Assertions.assertTrue(jsonComparator.compare(jsonExpected, jsonActual), "Incorrect Comparison");
    }

    @Test
    public void verifyIncorrectComparisons() {
        JSONObject jsonActual = new JSONObject();
        System.out.println("Running verifyIncorrectComparisons");
        jsonActual.put("Id", 1033);
        jsonActual.put("Content", "Andersaurio's Item");
        jsonActual.put("ItemType", "9");
        jsonActual.put("Checked", true);
        jsonActual.put("ProjectId", "8");
        jsonActual.put("ParentId", "7");
        jsonActual.put("Deleted", false);
        Assertions.assertFalse(jsonComparator.compare(jsonExpected, jsonActual), "Incorrect Comparison");
    }

    @Test
    public void verifyIgnoredComparisons() {
        JSONObject jsonActual = new JSONObject();
        System.out.println("Running verifyIgnoredComparisons");
        jsonActual.put("Id", 1033);
        jsonActual.put("Content", "Ander's Item");
        jsonActual.put("ItemType", "9");
        jsonActual.put("Checked", false);
        jsonActual.put("ProjectId", "8");
        jsonActual.put("ParentId", "7");
        jsonActual.put("Deleted", false);
        Assertions.assertTrue(jsonComparator.compare(jsonExpected, jsonActual), "Incorrect Comparison");
    }
}
