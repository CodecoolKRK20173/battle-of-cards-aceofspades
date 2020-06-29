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

public class CSVCardsDAO implements CardsDAO<Card> {

    private List<Card> cards = new ArrayList<>();
    private String content;

    public CSVCardsDAO() throws IOException, URISyntaxException {

        URL res = getClass().getClassLoader().getResource("villains.csv");
        File file = Paths.get(res.toURI()).toFile();
        String absolutePath = file.getAbsolutePath();

        List<String> cardLines = Files.lines(Paths.get(absolutePath)).collect(Collectors.toList());

        for(int i = 1; i < cardLines.size(); i++){
            String[] cardData = cardLines.get(i).split(",");

            add(new Card(cardData[0], cardData[1], Integer.parseInt(cardData[2]), Integer.parseInt(cardData[3]), Integer.parseInt(cardData[4]), Integer.parseInt(cardData[5])));
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
