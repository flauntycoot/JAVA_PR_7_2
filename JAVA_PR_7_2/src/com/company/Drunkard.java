package com.company;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Drunkard {
    ArrayList<Integer> player1 = new ArrayList<Integer>();
    ArrayList<Integer> player2 = new ArrayList<Integer>();
    private int amountOfSteps = 0;

    public void startCards() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите значения пяти карт первого игрока:");
        for (int i = 0;i < 5;i++)
            player1.add(scanner.nextInt());
        System.out.print("Введите значения пяти карт второго игрока:");
        for (int i = 0;i < 5;i++)
            player2.add(scanner.nextInt());
    }

    public abstract void ifCardsAreEquals();
    public abstract void repushToPlayer1Deck();
    public abstract void repushToPlayer2Deck();
    public abstract int checkPlayer1Size();
    public abstract int checkPlayer2Size();
    public abstract int Card1();
    public abstract int Card2();

    public void Game() {
        startCards();
        while (amountOfSteps <= 106 && checkPlayer1Size() != 0 && checkPlayer2Size() != 0) {
            amountOfSteps++;
            if (Card1() == 0)
                repushToPlayer1Deck();
            else if (Card2() == 0)
                repushToPlayer2Deck();
            else if (Card1() > Card2())
                repushToPlayer1Deck();
            else if (Card2() > Card1())
                repushToPlayer2Deck();
            else if (Card1() == Card2())
                ifCardsAreEquals();
        }
        if (amountOfSteps == 107)
            System.out.println("Ботва!");
        else if (checkPlayer1Size() == 0)
            System.out.println("Второй игрок победил!");
        else if (checkPlayer2Size() == 0)
            System.out.println("Первый игрок победил!");
    }
}