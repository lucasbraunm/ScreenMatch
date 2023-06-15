package br.com.lubraunm.screenmatch.models;

public class Series extends Content {
    private int seasons;
    private boolean active;
    private int episodesPerSeason;
    private double episodeDuration;

    public int getSeasons() {
        return seasons;
    }

    public void setSeasons(int seasons) {
        this.seasons = seasons;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getEpisodesPerSeason() {
        return episodesPerSeason;
    }

    public void setEpisodesPerSeason(int episodesPerSeason) {
        this.episodesPerSeason = episodesPerSeason;
    }

    public double getEpisodeDuration() {
        return episodeDuration;
    }

    public void setEpisodeDuration(double episodeDuration) {
        this.episodeDuration = episodeDuration;
    }

    @Override
    public double getDurationInMinutes() {
        return seasons * episodesPerSeason * episodeDuration;
    }
}
