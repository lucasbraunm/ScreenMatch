package br.com.lubraunm.screenmatch.models;

public class Content {
    private String title;
    private int releaseYear;
    private boolean includedInPlan;
    private double scoreSum;
    private int scoreTotal;

    private double durationInMinutes;

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
}
