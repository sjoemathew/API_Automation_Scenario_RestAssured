package test.update;

import arguments.holders.BoardIdValidationArgumentsHolder;
import arguments.providers.BoardNameValidationArgumentsProvider;
import consts.BoardEndpoints;
import io.restassured.internal.common.assertion.Assertion;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import test.BaseTest;

public class UpdateBoardValidationTest extends BaseTest {


    @ParameterizedTest
    @ArgumentsSource(BoardNameValidationArgumentsProvider.class)
    public void checkUpdateBoardWithInvalidId(BoardIdValidationArgumentsHolder validationArguments)
    {
        Response response = requestWithAuth()
                .pathParams(validationArguments.getPathParams())
                .put(BoardEndpoints.UPDATE_BOARD_URL);
        response
                .then()
                .statusCode(validationArguments.getStatusCode());
        Assertions.assertEquals(validationArguments.getErrorMessage(),response.body().asString());
    }

}
