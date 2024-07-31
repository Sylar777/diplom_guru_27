package models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Doc {
    private List<String> internalNames;
    private String name;
    private String alternativeName;
    private String enName;
    private int year;
    private List<Genre> genres;
    private List<Country> countries;
    private List<ReleaseYear> releaseYears;
    private int id;
    private ExternalId externalId;
    private List<Name> names;
    private String type;
    private String description;
    private String shortDescription;
    private Logo logo;
    private Poster poster;
    private Backdrop backdrop;
    private Rating rating;
    private Votes votes;
    private int movieLength;
    private double internalRating;
    private int internalVotes;
    @JsonProperty("isSeries")
    private boolean isSeries;
    private boolean ticketsOnSale;
    private Integer totalSeriesLength;
    private Integer seriesLength;
    private String ratingMpaa;
    private Integer ageRating;
    private Object top10;
    private Object top250;
    private int typeNumber;
    private String status;
}
