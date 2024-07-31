package models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@Data
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetFilmsResponse {
    private List<Doc> docs;
    private int total;
    private int limit;
    private int page;
    private int pages;
}

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
class Genre {
    private String name;
}

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
class Country {
    private String name;
}

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
class ReleaseYear {
    private int start;
    private int end;
}

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
class ExternalId {
    private String kpHD;
    private String imdb;
    private Integer tmdb;
}

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
class Name {
    private String name;
    private String language;
    private String type;
}

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
class Logo {
    private String url;
    private String previewUrl;
}

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
class Poster {
    private String url;
    private String previewUrl;
}

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
class Backdrop {
    private String url;
    private String previewUrl;
}

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
class Rating {
    private double kp;
    private double imdb;
    private int filmCritics;
    private int russianFilmCritics;
    private Object await;
}

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
class Votes {
    private int kp;
    private int imdb;
    private int filmCritics;
    private int russianFilmCritics;
    private int await;
}