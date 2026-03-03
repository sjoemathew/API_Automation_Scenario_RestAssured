package test.create;

import arguments.providers.BoardNameValidationArgumentsProvider;
import consts.BoardEndpoints;
import io.restassured.http.ContentType;
import io.restassured.internal.common.assertion.Assertion;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import test.BaseTest;

import java.util.Map;

public class CreateBoardValidationTest  extends BaseTest {

    @ParameterizedTest
    @ArgumentsSource(BoardNameValidationArgumentsProvider.class)
    public void checkCreatorBoardWithInvalidName(Map bodyParams)
    {
        Response response =
                requestWithAuth()
                        .body(bodyParams)
                        .contentType(ContentType.JSON)
                        .post(BoardEndpoints.CREATE_BOARD_URL);

        response.then().statusCode(400);
        Assertions.assertEquals("Invalid value for name",response.body().asString());

    }
}
