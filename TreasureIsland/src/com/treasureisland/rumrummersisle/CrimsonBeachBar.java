package com.treasureisland.rumrummersisle;

import com.treasureisland.TreasureIslandGameScanner;


public class CrimsonBeachBar implements Location{
    TreasureIslandGameScanner player;
    private String locationName = "Crimson Beach Bar";

    @Override
    public String getLocationName() {
        return locationName;
    }

    @Override
    public void talkToNPC() {
        System.out.println("youre talking to npc in the bar");
    }

    @Override
    public void lookAroundLocation() {
        System.out.println("I see a boat, who would think i'd see that here");
    }

    @Override
    public void investigateArea(){
        System.out.println("being nosey in at bar");
//        player.haveAmazingItem = true;

    }

}