package br.com.lubraunm.screenmatch.utils;

import br.com.lubraunm.screenmatch.models.Content;
import br.com.lubraunm.screenmatch.models.Movie;

public class TimeCalculator {
    private int totalTime;

    public int getTotalTime() {
        return totalTime;
    }

    public void insert(Content f) {
        totalTime += f.getDurationInMinutes();
    }

}
