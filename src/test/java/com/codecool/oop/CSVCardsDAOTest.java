package com.codecool.oop;

import com.codecool.oop.table.Card;
import junit.framework.TestCase;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class CSVCardsDAOTest extends TestCase {

    @Test
    public void test() {

        try {
            URL res = getClass().getClassLoader().getResource("villains.csv");
            File file = Paths.get(res.toURI()).toFile();
            String absolutePath = file.getAbsolutePath();

            List<String> cardLines = Files.lines(Paths.get(absolutePath)).collect(Collectors.toList());


            String[] firstCardData = cardLines.get(1).split(",");
            String[] midCardData = cardLines.get(cardLines.size() / 2).split(",");
            String[] lastCardData = cardLines.get(cardLines.size() - 1).split(",");


            Card firstCard = new Card(firstCardData[0], firstCardData[1], Integer.parseInt(firstCardData[2]), Integer.parseInt(firstCardData[3]), Integer.parseInt(firstCardData[4]), Integer.parseInt(firstCardData[5]));
            Card midCard = new Card(midCardData[0], midCardData[1], Integer.parseInt(midCardData[2]), Integer.parseInt(midCardData[3]), Integer.parseInt(midCardData[4]), Integer.parseInt(midCardData[5]));
            Card lastCard = new Card(lastCardData[0], lastCardData[1], Integer.parseInt(lastCardData[2]), Integer.parseInt(lastCardData[3]), Integer.parseInt(lastCardData[4]), Integer.parseInt(lastCardData[5]));


            System.out.println(firstCard.toString());
            System.out.println(midCard.toString());
            System.out.println(lastCard.toString());

        } catch (URISyntaxException uriSyntaxException) {
            uriSyntaxException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
}
}