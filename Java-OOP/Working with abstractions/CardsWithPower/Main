package OOP.Abstractions.Excercise.CardsWithPower;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String rankCard = scanner.nextLine();
        String suitCard = scanner.nextLine();
        int cardPower = CardsPower.valueOf(rankCard).getCardPower()+SuitsPower.valueOf(suitCard).getSuitPower();
        System.out.printf("Card name: %s of %s; Card power: %d", CardsPower.valueOf(rankCard),SuitsPower.valueOf(suitCard),cardPower);
    }
}
