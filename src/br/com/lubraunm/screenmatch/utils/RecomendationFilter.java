package br.com.lubraunm.screenmatch.utils;

public class RecomendationFilter {
    private String recomendation;

    public void filter(Rateable rateable) {
        if (rateable.getRating() >= 4) {
        System.out.println("It is amongst the best movies of the year");
        } else if (rateable.getRating() >= 2) {
            System.out.println("Good ratings");
        } else {
            System.out.println("Deserves a chance");
        }
    }
}
