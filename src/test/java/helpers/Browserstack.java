package helpers;

import drivers.BrowserstackDriver;

import static io.restassured.RestAssured.given;

public class Browserstack {
    BrowserstackDriver driver = new BrowserstackDriver();

    public String videoUrl(String sessionId) {
        String url = String.format("https://api.browserstack.com/app-automate/sessions/%s.json", sessionId);

        return given()
                .auth().basic(driver.getBrowserstackConfig().user(), driver.getBrowserstackConfig().key())
                .get(url)
                .then()
                .log().all()
                .statusCode(200)
                .extract().path("automation_session.video_url");
    }
}
