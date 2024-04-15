package com.kpuig.flashycards.cards;

public class FlashCard {
    public String front;
    public String back;

    public FlashCard() {
        this.front = "";
        this.back = "";
    }

    public FlashCard(String front, String back) {
        this.front = front;
        this.back = back;
    }

    @Override
    public int hashCode() {
        return front.hashCode() ^ back.hashCode();
    }

    @Override
    public String toString() {
        return "Front: " + front + " | Back: " + back;
    }
}
