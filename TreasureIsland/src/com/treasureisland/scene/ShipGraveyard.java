package com.treasureisland.scene;

import com.treasureisland.TreasureIslandGameplay;
import com.treasureisland.player.Player;

public class ShipGraveyard extends Scene {
    private final TreasureIslandGameplay game = TreasureIslandGameplay.getInstance();
    private Player player = Player.getInstance();

    @Override
    public String getLocationName() {
        return "Ship Graveyard";
    }

    @Override
    public void talkToNPC(){
        System.out.println("Talking to npc ship graveyard, I was pointed to check out the biggest ship ");
        game.storylineProgression("TI.txt", getLocationName(), "SGStart", "SGStop");

    }

    @Override
    public void lookAroundLocation(){
        System.out.println("Looking around ship graveyard");
        game.storylineProgression("TI.txt", getLocationName(), "SBStart", "SBStop");

    }

    @Override
    public void investigateArea(){
        System.out.println("Investigating ship graveyard");
        game.storylineProgression("TI.txt", getLocationName(), "BBDtart", "BBDStop");
        player.playerCoinGenerator();
    }

    @Override
    public void vendor() {

    }
}
