package helpers;

import config.BrowserstackConfig;
import org.aeonbits.owner.ConfigFactory;

import static io.restassured.RestAssured.given;
import static spec.GeneralSpec.defaultLoggingRequestSpec;

public class BrowserstackAttachListener {
    static final BrowserstackConfig config = ConfigFactory.create(BrowserstackConfig.class, System.getProperties());

    public static String videoUrl(String sessionId) {
        String url = String.format("https://api.browserstack.com/app-automate/sessions/%s.json", sessionId);

        return given(defaultLoggingRequestSpec)
                .auth().basic(config.user(), config.key())
                .get(url)
                .then()
                .log().all()
                .statusCode(200)
                .extract().path("automation_session.video_url");
    }
}
