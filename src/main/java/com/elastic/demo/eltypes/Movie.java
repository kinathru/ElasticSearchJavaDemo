package com.elastic.demo.eltypes;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

/**
 * Created by Kinath on 6/11/2017.
 */
@JsonInclude(JsonInclude.Include.NON_NULL) @JsonPropertyOrder({"vote_count", "id", "video", "vote_average", "title", "popularity", "original_language", "original_title", "genre_ids", "overview", "release_date"})
public class Movie
{
    @JsonProperty("vote_count") private Integer voteCount;
    @JsonProperty("id") private Integer id;
    @JsonProperty("video") private Boolean video;
    @JsonProperty("vote_average") private Integer voteAverage;
    @JsonProperty("title") private String title;
    @JsonProperty("popularity") private Double popularity;
    @JsonProperty("original_language") private String originalLanguage;
    @JsonProperty("original_title") private String originalTitle;
    @JsonProperty("genre_ids") private List<String> genreIds = null;
    @JsonProperty("overview") private String overview;
    @JsonProperty("release_date") private String releaseDate;

    public Movie()
    {
    }

    public Movie( Integer voteCount, Integer id, Boolean video, Integer voteAverage, String title, Double popularity, String originalLanguage, String originalTitle, List<String> genreIds, String overview, String releaseDate )
    {
        this.voteCount = voteCount;
        this.id = id;
        this.video = video;
        this.voteAverage = voteAverage;
        this.title = title;
        this.popularity = popularity;
        this.originalLanguage = originalLanguage;
        this.originalTitle = originalTitle;
        this.genreIds = genreIds;
        this.overview = overview;
        this.releaseDate = releaseDate;
    }

    public Integer getVoteCount()
    {
        return voteCount;
    }

    public void setVoteCount( Integer voteCount )
    {
        this.voteCount = voteCount;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId( Integer id )
    {
        this.id = id;
    }

    public Boolean getVideo()
    {
        return video;
    }

    public void setVideo( Boolean video )
    {
        this.video = video;
    }

    public Integer getVoteAverage()
    {
        return voteAverage;
    }

    public void setVoteAverage( Integer voteAverage )
    {
        this.voteAverage = voteAverage;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle( String title )
    {
        this.title = title;
    }

    public Double getPopularity()
    {
        return popularity;
    }

    public void setPopularity( Double popularity )
    {
        this.popularity = popularity;
    }

    public String getOriginalLanguage()
    {
        return originalLanguage;
    }

    public void setOriginalLanguage( String originalLanguage )
    {
        this.originalLanguage = originalLanguage;
    }

    public String getOriginalTitle()
    {
        return originalTitle;
    }

    public void setOriginalTitle( String originalTitle )
    {
        this.originalTitle = originalTitle;
    }

    public List<String> getGenreIds()
    {
        return genreIds;
    }

    public void setGenreIds( List<String> genreIds )
    {
        this.genreIds = genreIds;
    }

    public String getOverview()
    {
        return overview;
    }

    public void setOverview( String overview )
    {
        this.overview = overview;
    }

    public String getReleaseDate()
    {
        return releaseDate;
    }

    public void setReleaseDate( String releaseDate )
    {
        this.releaseDate = releaseDate;
    }
}
