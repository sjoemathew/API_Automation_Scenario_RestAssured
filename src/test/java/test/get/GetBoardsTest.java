package test.get;

import consts.BoardEndpoints;
import consts.UrlParamValues;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import test.BaseTest;

public class GetBoardsTest extends BaseTest {




    @Test
    public void checkGetBoards()
    {
        requestWithAuth()
                .queryParam("fields","id,name")
                 .pathParam("member",UrlParamValues.USER_NAME)
                .get(BoardEndpoints.GET_ALL_BOARDS_URL)
                .then()
                .statusCode(200)
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/get_boards.json"));
    }

    @Test
    public void checkGetBoard()
    {
        requestWithAuth().pathParam("id", UrlParamValues.EXISTING_BOARD_ID)
                .get("/1/boards/{id}")
                .then()
                .statusCode(200)
                .body("name", Matchers.equalTo("My_board"))
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/get_board.json"));
    }
}
