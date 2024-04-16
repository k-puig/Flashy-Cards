package com.kpuig.flashycards.cards;

import com.google.gson.annotations.*;

public class FlashCard {
    @SerializedName("front")
    public String front;

    @SerializedName("back")
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
