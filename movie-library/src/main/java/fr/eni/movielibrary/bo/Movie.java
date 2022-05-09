package fr.eni.movielibrary.bo;

import java.util.List;

public class Movie {
    private long id;
    private String title;
    private int year;
    private int duration;
    private String synopsis;
    private Participant director;
    private List<Participant> actors;
    private Genre genre;
    private List<Opinion> opinion;

    public Movie(){
    }
    public Movie(long id, String title, int year, int duration, String synopsis ){
        this.id = id;
        this.title = title;
        this.year = year;
        this.duration = duration;
        this.synopsis = synopsis;
    }
    public Movie(String title, int year, int duration, String synopsis ){
        this.title = title;
        this.year = year;
        this.duration = duration;
        this.synopsis = synopsis;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public Participant getDirector() {
        return director;
    }

    public void setDirector(Participant director) {
        this.director = director;
    }

    public List<Participant> getActors() {
        return actors;
    }

    public void setActors(List<Participant> actors) {
        this.actors = actors;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public List<Opinion> getOpinion() {
        return opinion;
    }

    public void setOpinion(List<Opinion> opinion) {
        this.opinion = opinion;
    }

    @Override
    public String toString() {
        return "Movie - "+id+" : [title=" + title + ", year=" + year + ", \nduration=" + duration + ", \nsynopsis=" + synopsis +", \ndirector=" + director+", \nactors=" + actors+", \ngenre=" + genre +"]";
    }
}
