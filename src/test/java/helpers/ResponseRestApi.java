package helpers;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import models.*;

import static io.restassured.RestAssured.given;
import static spec.GeneralSpec.defaultLoggingRequestSpec;
import static spec.GeneralSpec.defaultLoggingКesponseSpec;

public class ResponseRestApi {
    @Step("Get Title by name via API")
    public static GetTitleResponse getTitleByNameViaApi(String page, String limit, String filmName) {
        return given()
                .spec(defaultLoggingRequestSpec)
                .header("accept", "application/json")
                .header("X-API-KEY", System.getProperty("apikey", "0RNAGBE-2BEM2CC-PB1RM4V-T5C4GV4"))
                .get("/movie/search?page={page}&limit={limit}&query={query}", page, limit, filmName)
                .then()
                .spec(defaultLoggingКesponseSpec)
                .statusCode(200)
                .extract().as(GetTitleResponse.class);
    }

    @Step("Get random title via API")
    public static RandomTitleResponse getRandomTitle() {
        return given()
                .spec(defaultLoggingRequestSpec)
                .header("accept", "application/json")
                .header("X-API-KEY", System.getProperty("apikey", "0RNAGBE-2BEM2CC-PB1RM4V-T5C4GV4"))
                .get("/movie/random")
                .then()
                .spec(defaultLoggingКesponseSpec)
                .statusCode(200)
                .extract().as(RandomTitleResponse.class);
    }

    @Step("Get random title by Type via API")
    public static RandomTitleResponse getRandomTitleByType(String type) {
        return given()
                .spec(defaultLoggingRequestSpec)
                .header("accept", "application/json")
                .header("X-API-KEY", System.getProperty("apikey", "0RNAGBE-2BEM2CC-PB1RM4V-T5C4GV4"))
                .get("/movie/random?type={type}", type)
                .then()
                .spec(defaultLoggingКesponseSpec)
                .statusCode(200)
                .extract().as(RandomTitleResponse.class);
    }

    @Step("Get error response for title awards via API")
    public static ErrorResponse getErrorResponseForTitleAwards(int page, int limit) {
        return given()
                .spec(defaultLoggingRequestSpec)
                .header("accept", "application/json")
                .header("X-API-KEY", System.getProperty("apikey", "0RNAGBE-2BEM2CC-PB1RM4V-T5C4GV4"))
                .get("/movie/awards?page={page}&limit={limit}&winning=", page, limit)
                .then()
                .spec(defaultLoggingКesponseSpec)
                .statusCode(400)
                .extract().as(ErrorResponse.class);
    }

    @Step("Get title awards via API")
    public static TitleAwardsResponse getTitleAwards(int page, int limit, boolean isWinning) {
        return given()
                .spec(defaultLoggingRequestSpec)
                .header("accept", "application/json")
                .header("X-API-KEY", System.getProperty("apikey", "0RNAGBE-2BEM2CC-PB1RM4V-T5C4GV4"))
                .get("/movie/awards?page={page}&limit={limit}&winning={winning}", page, limit, isWinning)
                .then()
                .spec(defaultLoggingКesponseSpec)
                .statusCode(200)
                .extract().as(TitleAwardsResponse.class);
    }
}
