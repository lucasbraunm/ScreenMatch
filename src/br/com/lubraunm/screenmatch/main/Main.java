package br.com.lubraunm.screenmatch.main;

import br.com.lubraunm.screenmatch.models.Movie;
import br.com.lubraunm.screenmatch.models.Series;
import br.com.lubraunm.screenmatch.utils.RecomendationFilter;
import br.com.lubraunm.screenmatch.utils.TimeCalculator;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Movie myMovie = new Movie("The Godfather", 1970);
        myMovie.setDurationInMinutes(180);

        Movie otherMovie = new Movie("Avatar", 2023);
        otherMovie.setDurationInMinutes(200);

        myMovie.rate(8);
        myMovie.rate(5);
        myMovie.rate(10);

        System.out.println("Score: %s".formatted(myMovie.calculateScore()));

        Series myTvShow = new Series("Lost", 2000);
        myTvShow.setSeasons(8);
        myTvShow.setEpisodesPerSeason(22);
        myTvShow.setEpisodeDuration(45);

        System.out.println("Time to watch Lost: %.1f minutes".formatted(myTvShow.getDurationInMinutes()));

        TimeCalculator calculator = new TimeCalculator();
        calculator.insert(myMovie);
        calculator.insert(otherMovie);
        calculator.insert(myTvShow);
        System.out.println("Total time to watch: %s".formatted(calculator.getTotalTime()));

        RecomendationFilter filter = new RecomendationFilter();
        filter.filter(myMovie);

        ArrayList<Movie> movieList = new ArrayList<>();
        movieList.add(myMovie);
        movieList.add(otherMovie);

        Movie[] movies = new Movie[2];
        movies[0] = myMovie;
        movies[1] = otherMovie;

        System.out.println(movieList);
        System.out.println(movies);


    }
}
