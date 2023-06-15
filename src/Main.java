import br.com.lubraunm.screenmatch.models.Movie;
import br.com.lubraunm.screenmatch.models.Series;
import br.com.lubraunm.screenmatch.utils.RecomendationFilter;
import br.com.lubraunm.screenmatch.utils.TimeCalculator;

public class Main {
    public static void main(String[] args) {
        Movie myMovie = new Movie();

        myMovie.setTitle("The Godfather");
        myMovie.setReleaseYear(1970);
        myMovie.setDurationInMinutes(180);

        Movie otherMovie = new Movie();

        otherMovie.setTitle("Avatar");
        otherMovie.setReleaseYear(2023);
        otherMovie.setDurationInMinutes(200);

        myMovie.rate(8);
        myMovie.rate(5);
        myMovie.rate(10);

        System.out.println("Score: %s".formatted(myMovie.calculateScore()));

        Series myTvShow = new Series();
        myTvShow.setTitle("Lost");
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
    }
}
