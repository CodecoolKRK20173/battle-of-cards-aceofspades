package com.codecool.oop.table;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class CardTest {

    Card card1 = new Card("Freddy Krueger", "A Nightmare on Elm Street",1,7,5,35);
    Card card2 = new Card("Jason Vorhees", "Friday the 13th",1,7,1,161);


    @Test
    public void testCompareTo() {
        card1.setCategoryToCompare(Category.INTELLIGENCE);
        card2.setCategoryToCompare(Category.INTELLIGENCE);
        Assert.assertEquals(1, card1.compareTo(card2));
    }

    @Test
    public void testEquals() {
        card1.setCategoryToCompare(Category.WEAPONS);
        card2.setCategoryToCompare(Category.WEAPONS);
        Assert.assertEquals(card1, card2);
    }
}