package com.company;

import java.util.LinkedList;
import java.util.Queue;

public class OnQueue extends Drunkard{
    private Queue<Integer> player1Q;
    private Queue<Integer> player2Q;

    @Override
    public void startCards() {
        super.startCards();
        player1Q = new LinkedList<>();
        player2Q = new LinkedList<>();
        player1Q.addAll(player1);
        player2Q.addAll(player2);
        player1.clear();
        player2.clear();
    }

    @Override
    public void ifCardsAreEquals() {
        player1Q.add(player2Q.poll());
        player1Q.add(player1Q.poll());
        player2Q.add(player1Q.poll());
        player2Q.add(player2Q.poll());
    }

    @Override
    public void repushToPlayer1Deck() {
        player1Q.add(player1Q.poll());
        player1Q.add(player2Q.poll());
    }

    @Override
    public void repushToPlayer2Deck() {
        player2Q.add(player2Q.poll());
        player2Q.add(player1Q.poll());
    }

    @Override
    public int checkPlayer1Size() {
        return player1Q.size();
    }

    @Override
    public int checkPlayer2Size() {
        return player2Q.size();
    }

    @Override
    public int Card1() {
        return player1Q.peek();
    }

    @Override
    public int Card2() {
        return player2Q.peek();
    }

    public OnQueue() {
        Game();
    }

    public static void main(String[] args) {
        new OnQueue();
    }
}
