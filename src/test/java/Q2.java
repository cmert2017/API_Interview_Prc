import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static io.restassured.RestAssured.*;

/*
Using Star War API ,
Send a request to https://swapi.dev/api/people
Extract the field with the name height of all the people
Print the average height on the console (edited)
 */

public class Q2 {

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
    public void test1(){

       Response response = get("/people");

        Set<String> setOfPeopleHairColor =  new TreeSet<>();
        System.out.println(response.jsonPath().getList("results.hair_color"));
        int size = response.jsonPath().getList("results.hair_color").size();
        for (int i = 0; i < size; i++) {
            String root = response.body().jsonPath().getString("results["+i+"].hair_color");
            if ((root.contains(","))){
                setOfPeopleHairColor.add(root.replace(", ","-"));
            }else if (root.contains("n/a") || root.contains("none")) {

            }else{
            setOfPeopleHairColor.add(root);
            }
        }

    System.out.println("setOfPeopleHairColor = " + setOfPeopleHairColor);

    }

    @Test @DisplayName("Second Solution")
    public void test2(){
        List<String> listHairColor = get("https://swapi.dev/api/people").then().extract().jsonPath().getList("results.hair_color");
        System.out.println("listHairColor = " + listHairColor);

        listHairColor.removeIf(p -> p.equals("n/a") || p.equals("none"));

        HashSet<String> set = new HashSet<>(listHairColor);

        System.out.println("hairColor = " + set);

    }



}
