package br.com.lubraunm.screenmatch.models;

import br.com.lubraunm.screenmatch.exception.YearConversionException;
import com.google.gson.annotations.SerializedName;

public class Content {
    private String title;
    private int releaseYear;
    private boolean includedInPlan;
    private double scoreSum;
    private int scoreTotal;
    private double durationInMinutes;

    public Content(String title, int releaseYear) {
        this.title = title;
        this.releaseYear = releaseYear;
    }

    public Content(ContentOMDB contentOMDB) throws YearConversionException {
        this.title = contentOMDB.title();
        if (contentOMDB.year().length() > 4) {
            throw new YearConversionException("Error converting year from the response with more than 04 characters");
        }
        this.releaseYear = Integer.valueOf(contentOMDB.year());
        this.durationInMinutes = Double.valueOf(contentOMDB.runtime().substring(0, 3));
    }

    public String getTitle() {
        return title;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public boolean isIncludedInPlan() {
        return includedInPlan;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public void setIncludedInPlan(boolean includedInPlan) {
        this.includedInPlan = includedInPlan;
    }

    public void rate(double score) {
        scoreSum += score;
        scoreTotal++;
    }

    public double calculateScore() {
        return scoreSum / scoreTotal;
    }

    public double getDurationInMinutes() {
        return durationInMinutes;
    }

    public void setDurationInMinutes(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }

    @Override
    public String toString() {
        return "Content{" +
                "title='" + title + '\'' +
                ", releaseYear=" + releaseYear +
                ", durationInMinutes=" + durationInMinutes +
                '}';
    }
}
