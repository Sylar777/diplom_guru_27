package spec;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static helpers.CustomApiListener.withCustomTemplates;
import static io.restassured.RestAssured.with;
import static io.restassured.filter.log.LogDetail.*;
import static io.restassured.http.ContentType.JSON;

public class GeneralSpec {
    public static final RequestSpecification defaultLoggingRequestSpec = with()
            .filter(withCustomTemplates())
            .log().all()
            .contentType(JSON);

    public static final ResponseSpecification defaultLoggingКesponseSpec = new ResponseSpecBuilder()
            .log(ALL)
            .build();
}
