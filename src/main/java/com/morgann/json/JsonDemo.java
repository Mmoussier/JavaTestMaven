package com.morgann.json;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JsonDemo {
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        // Création d'un fichier JSON à partir d'un objet
        System.out.println("-------- Création d'un fichier JSON à partir d'un objet -------");
        Team team = new Team(1,"Gloden Knights", "Las Vegas", "Western", "Pacific");
        objectMapper.writeValue(new File("team.json"), team);

        // Création d'un tableau JSON à partir d'une liste d'objets
        System.out.println("-------- Création d'un tableau JSON à partir d'une liste d'objets -------");
        List<Team> teams = new ArrayList<>();
        teams.add(team);
        team = new Team(2,"Bruins", "Boston", "Eastern", "Atlantic");
        teams.add(team);
        team = new Team(3,"Penguins", "Pittsburgh", "Eastern", "Metropolitan");
        teams.add(team);
        team = new Team(4,"Rangers", "New York", "Eastern", "metropolitan");
        teams.add(team);
        objectMapper.writeValue(new File("teams.json"), teams);

        System.out.println("-------- Lecture fichier JSON avec 1 seul objet : team.json -------");
        team = objectMapper.readValue(new File("src/main/resources/team.json"), Team.class);
        System.out.println(team.toString());

        System.out.println("-------- Lecture fichier JSON avec 1 tableau d'objets : teams.json -------");
        List<Team> teamsJson = Arrays.asList(objectMapper.readValue(new File("src/main/resources/teams.json"), Team[].class));
        for(Team team1 : teamsJson) {
            System.out.println(team1.toString());
        }

        // Lecture JSON sans objet avec readTree
        System.out.println("-------- Lecture JSON sans objet avec readTree -----------");
        JsonNode root = objectMapper.readTree(new File("src/main/resources/team.json"));
        System.out.println("Contenu JSON : " + root.toString());
        System.out.println("id : " + root.get("id").asText());
        System.out.println("name : " + root.get("name").asText());
        System.out.println("location : " + root.get("location").asText());
        System.out.println("conference : " + root.get("conference").asText());
        System.out.println("division : " + root.get("division").asText());
    }

}
