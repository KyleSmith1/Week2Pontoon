package week2pontoon;

import java.util.Scanner;


/*
 * @author 14001835
 */
public class Game {

    int card1 = 0;
    int card2 = 0;
    int newCard = 0;
    int total;
    int houseTotal;
    int cardsDrawn[] = new int[10];
    int cardCount = 3;

    public Game() {
        houseTotal = houseTotal(16);
        cardsDrawn[0] = houseTotal;
        card1 = getRandomNumber();
        cardsDrawn[1] = card1;
        card2 = getRandomNumber();
        cardsDrawn[2] = card2;
        total = calcTotal(card1, card2);

        System.out.println("You have drawn " + card1 + " and " + card2);
        System.out.println("Current total: " + total);
        Scanner kboard = new Scanner(System.in);
        String choice = "";
        System.out.println("Do you wish to draw another card y/n?");
        choice = kboard.next();
        while (choice.equalsIgnoreCase("y")) {
            newCard = getRandomNumber();
            cardsDrawn[cardCount++] = newCard;
            System.out.println("New Card: " + newCard);
            total = calcTotal(total, newCard);
            System.out.println("Current total is: " + total + " ");
            if (busted(total) == true) {

                System.out.println("Busted! You have gone above 21");
                break;
            } else {
                System.out.println("Do you wish to draw another card y/n?");
                choice = kboard.next();
            }

        }
        if (getResult(total, houseTotal) == true) {
            System.out.println("You have won with " + total);
            System.out.println("The house had a total of " + houseTotal);
            displayCards(cardsDrawn);
        } else {
            System.out.println("You have lost with " + total);
            System.out.println("The house had a total of " + houseTotal);
            displayCards(cardsDrawn);
        }

    }

    public int getRandomNumber() {
        return (int) (Math.random() * 10 + 1);
    }

    public int calcTotal(int card1, int card2) {
        return card1 + card2;
    }

    public boolean getResult(int total, int houseTotal) {
        if (total > houseTotal && total <= 21) {

            return true;

        } else {

            return false;

        }
    }

    public boolean busted(int total) {

        if (total > 21) {

            return true;

        } else {

            return false;

        }

    }

    public int houseTotal(int minNumber) {

        int house = 0;
        while (house < minNumber) {

            house = calcTotal(getRandomNumber(), getRandomNumber());

        }

        return (house);

    }

    public void displayCards(int cardsDrawn[]) {
        System.out.print("Cards drawn: ");
        for (int cardNo = 1; cardNo < 10; cardNo++) {
            if (cardsDrawn[cardNo] != 0) {
                if (cardNo == 1) {
                    System.out.print(cardsDrawn[cardNo]);
                } else {
                    System.out.print("," + cardsDrawn[cardNo]);
                }
            }

        }
        System.out.println();
    }

}
