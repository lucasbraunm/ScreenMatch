package br.com.lubraunm.screenmatch.models;

import br.com.lubraunm.screenmatch.utils.Rateable;

public class Movie extends Content implements Rateable {

    private String director;

    public Movie(String title, int releaseYear) {
        super(title, releaseYear);
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getRating() {
        return (int) calculateScore() / 2;
    }

}
