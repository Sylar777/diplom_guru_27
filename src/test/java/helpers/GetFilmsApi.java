package helpers;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import models.GetFilmsResponse;


import static io.restassured.RestAssured.given;
import static spec.GeneralSpec.requestSpec;
import static spec.GeneralSpec.responseSpec;

public class GetFilmsApi {
    @Step("Get film by name via API")
    public static GetFilmsResponse getFilmByNameViaApi(String page, String limit, String filmName) {
        GetFilmsResponse getFilmsResponse = given()
                .spec(requestSpec)
                .contentType(ContentType.JSON)
                .header("accept", "application/json")
                .header("X-API-KEY", "0RNAGBE-2BEM2CC-PB1RM4V-T5C4GV4")
                .get("/movie/search?page={page}&limit={limit}&query={query}", page, limit, filmName)
                .then()
                .spec(responseSpec)
                .statusCode(200)
                .extract().as(GetFilmsResponse.class);
        return getFilmsResponse;
    }
}
