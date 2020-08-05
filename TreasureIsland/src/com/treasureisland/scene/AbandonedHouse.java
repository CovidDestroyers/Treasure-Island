package com.treasureisland.scene;

import com.treasureisland.TreasureIslandGameplay;
import com.treasureisland.player.Player;

public class AbandonedHouse extends Scene {
    private final TreasureIslandGameplay game = TreasureIslandGameplay.getInstance();
    private final Player player = Player.getInstance();

    @Override
    public String getLocationName() {
        return "Abandoned House On The Hill ";
    }

    @Override
    public void talkToNPC(){
        System.out.println("After informing about the Abandoned house on the hill, my friend took me there and I searched . .");
        game.storylineProgression("TI.txt", getLocationName(), "FLStart", "FLStop");

    }

    @Override
    public void lookAroundLocation(){
        game.storylineProgression("TI.txt", getLocationName(), "DAStart", "DAStop");


    }

    @Override
    public void investigateArea() {
        game.storylineProgression("TI.txt", getLocationName(), "HPStart", "HPStop");


    }

    @Override
    public void vendor() {

    }
}
