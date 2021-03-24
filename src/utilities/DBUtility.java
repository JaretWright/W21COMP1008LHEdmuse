package utilities;

import java.util.Arrays;
import java.util.List;

public class DBUtility {

    /**
     * This method will return a list of course codes from the DB
     */
    public static List<String> getCourseCodes()
    {
        return Arrays.asList("COMP 1002", "COMP 1030", "COMP 1035", "COMP 1045",
                "COMP 1045", "MATH 1003", "COMP 1006", "COMP 1008",
                "COMP 1098", "COMP 2003", "ENTR 1002", "COMP 1009",
                "COMP 1011", "COMP 1073", "COMP 2084", "COMP 3002",
                "COMP 2068");
    }
}
