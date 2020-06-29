package com.codecool.oop;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CSVCardDAO implements CardDAO<Card> {

    private List<Card> cards = new ArrayList<>();
    private String content;

    public CSVCardDAO() throws IOException, URISyntaxException {

        URL res = getClass().getClassLoader().getResource("villains.csv");
        File file = Paths.get(res.toURI()).toFile();
        String absolutePath = file.getAbsolutePath();

        List<String> cardLines = Files.lines(Paths.get(absolutePath)).collect(Collectors.toList());

        for(int i = 1; i < cardLines.size(); i++){
            String[] tempList = cardLines.get(i).split(",");

            add(new Card(tempList[0], tempList[1], Integer.parseInt(tempList[2]), Integer.parseInt(tempList[3]), Integer.parseInt(tempList[4]), Integer.parseInt(tempList[5])));
        }
    }

    @Override
    public List<Card> getAll() {
        return cards;
    }

    @Override
    public void add(Card card) {
        this.cards.add(card);
    }

    @Override
    public void delete(Card card) {
        this.cards.remove(card);
    }
}
