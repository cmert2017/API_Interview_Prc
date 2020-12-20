import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;
import pojo.Article;

import java.util.List;

import static io.restassured.RestAssured.*;
/*
https://newsapi.org/v2/top-headlines?country=us&apiKey=API_KEY
Send request to above request URL
print all article authors if source id is not null
 */
public class Q3 {
    private String API_KEY = "36b6de05a25f4e549e44ecbf0bcde12f";

    @Test
    public void test1(){
        List<Article> articleList = get("https://newsapi.org/v2/top-headlines?country=us&apiKey=" + API_KEY).jsonPath().getList("articles.findAll{it.source.id!=null}", Article.class);

       articleList.forEach(System.out::println);
        
    }

}
