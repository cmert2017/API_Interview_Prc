import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.ToIntFunction;
import java.util.stream.IntStream;

import static io.restassured.RestAssured.*;

/*
Using Star War API ,
Send a request to https://swapi.dev/api/people
Extract the field with the name height of all the people
Print the average height on the console (edited)
 */

public class Q1 {

    @BeforeAll
    public static void setUp(){
        baseURI = "https://swapi.dev";
        basePath = "/api";
    }
    @AfterAll
    public static void tearDown(){
        reset();
    }
    @Test
    public void testFindAverageHeightOfPeople(){

        List<Integer> listPeople = given()
                                        .accept(ContentType.JSON).
                                  when()
                                        .get("/people")
                                        .jsonPath().getList("results.height",Integer.class);
        int sum=0;
        for (int i = 0; i < listPeople.size(); i++) {
            sum+=listPeople.get(i);
        }

        Integer averageHeight = sum /listPeople.size();
        System.out.println("averageHeight = " + averageHeight);
    }



}
