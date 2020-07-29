package com.treasureisland;


import com.treasureisland.items.Items;
import com.treasureisland.items.Vendor;
import com.treasureisland.player.Player;

import javax.swing.*;

;import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.ConsoleHandler;

public class Client {
    public static void main(String[] args) throws InterruptedException {
        TreasureIslandGameplay beginGame = TreasureIslandGameplay.getInstance();
        beginGame.customGameplayOptions();

    }
}