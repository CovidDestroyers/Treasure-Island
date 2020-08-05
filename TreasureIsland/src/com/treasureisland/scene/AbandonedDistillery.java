package com.treasureisland.scene;

import com.treasureisland.TreasureIslandGameplay;
import com.treasureisland.player.Player;


public class AbandonedDistillery extends Scene {
    private final TreasureIslandGameplay treasureIslandGameplay = TreasureIslandGameplay.getInstance();
    private final Player player = Player.getInstance();

    @Override
    public String getLocationName() {
        return "Abandoned distillery";
    }

    @Override
    public void talkToNPC(){
        treasureIslandGameplay.storylineProgression("TI.txt", getLocationName(), "BGStart", "BGEnd");
    }

    @Override
    public void lookAroundLocation(){
        treasureIslandGameplay.storylineProgression("TI.txt", getLocationName(), "DSStart", "DSEnd");
        player.setPlayerHealth(player.getPlayerHealth() - 50);
    }

    @Override
    public void investigateArea(){
        treasureIslandGameplay.storylineProgression("TI.txt", getLocationName(), "DRStart", "DREnd");
    }

    @Override
    public void vendor() {

    }

}
