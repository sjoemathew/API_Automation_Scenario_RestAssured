package consts;

import java.util.Map;

public class UrlParamValues {



    public static final String VALID_KEY = "ATLASSIAN_TOKEN";

    public  static final String VALID_TOKEN="ATLASSIAN_TOKEN";

    public static final Map<String,String> AUTH_QUERY_PARAMS =
            Map.of(
                    "key",
                    VALID_KEY,
                    "token",
                    VALID_TOKEN
            );

    public static final Map<String,String> ANOTHER_USER_AUTH_QUERY_PARAMS =
            Map.of(
                    "key",
                    "ATLASSIAN_TOKEN",
                    "token",
                    "ATLASSIAN_TOKEN"
            );

    public static final String EXISTING_BOARD_ID = "ATLASSIAN_TOKEN" ;

    public static  final String BOARD_ID_TO_UPDATE = "ATLASSIAN_TOKEN";
    public  static final String USER_NAME = "learnpostman";
}
