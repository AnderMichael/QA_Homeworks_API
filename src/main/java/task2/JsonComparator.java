package task2;

import org.json.JSONObject;

public class JsonComparator {
    public boolean compare(JSONObject expectedResult, JSONObject actualResult) {
        boolean theyAreEqual = true;
        for (String key : expectedResult.keySet()) {
            if (actualResult.keySet().contains(key)) {
                if (!expectedResult.get(key).toString().equals("ignore")) {
                    if (!actualResult.get(key).equals(expectedResult.get(key))) {
                        theyAreEqual = false;
                        System.out.println(String.format("%s ---> EXPECTED: %s ACTUAL: %s", key, actualResult.get(key).toString(), expectedResult.get(key).toString()));
                    }
                }
            } else {
                theyAreEqual = false;
                System.out.println("Not exists");
            }
        }
        return theyAreEqual;
    }
}
