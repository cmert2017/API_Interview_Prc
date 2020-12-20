package pojo;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter @Setter @NoArgsConstructor  @AllArgsConstructor @ToString
public class Article {
    private String author;
    private String title;
    private String description;

}
