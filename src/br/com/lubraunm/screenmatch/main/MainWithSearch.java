package br.com.lubraunm.screenmatch.main;

import br.com.lubraunm.screenmatch.exception.YearConversionException;
import br.com.lubraunm.screenmatch.models.Content;
import br.com.lubraunm.screenmatch.models.ContentOMDB;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainWithSearch {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scan = new Scanner(System.in);
        var movieName = "";
        List<Content> contents = new ArrayList<>();
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        while (true) {
            try {
                System.out.println("Type a movie to search: ");
                movieName = scan.nextLine();
                if (movieName.equalsIgnoreCase("sair")) {
                    break;
                }

                String search = "https://www.omdbapi.com/?t=%s&apikey=5cc71d87"
                        .formatted(movieName)
                        .replace(" ", "+");

                HttpClient client = HttpClient.newHttpClient();

                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(search))
                        .build();

                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());

                System.out.println(response.body());

                ContentOMDB movieSearchRecord = gson.fromJson(response.body(), ContentOMDB.class);
                System.out.println("Title: " + movieSearchRecord);


                Content movieSearch = new Content(movieSearchRecord);
                System.out.println(movieSearch);

                contents.add(movieSearch);
            } catch (YearConversionException error) {
                System.out.println("Aconteceu um erro");
                System.out.println(error.getMessage());
            }
        }

        System.out.println(contents);

        FileWriter writer = new FileWriter("movies.json");
        writer.write(gson.toJson(contents));
        writer.close();
    }
}
