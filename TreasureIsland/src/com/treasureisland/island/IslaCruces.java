package com.treasureisland.island;

import com.treasureisland.player.Player;
import com.treasureisland.scene.ChurchCruces;
import com.treasureisland.scene.DoubleCrossTavernCruces;
import com.treasureisland.scene.SaintsLodgeCruces;
import com.treasureisland.scene.Scene;
import com.treasureisland.scene.SouthendBeachCruces;

public class IslaCruces extends Island {
  private final Scene churchCruces =
    new ChurchCruces("Church Cruces");
  private final Scene southEndBeach =
    new SouthendBeachCruces("Southend Beach");
  private final Scene saintsLodge =
    new SaintsLodgeCruces("Saints Lodge");
  private final Scene doubleCrossTavern =
    new DoubleCrossTavernCruces("Double Cross Tavern");

  public IslaCruces() {
    setIslandName("Isla Cruces");
    setCurrentScene(churchCruces);

    churchCruces.connectSouth(doubleCrossTavern);
    churchCruces.connectEast(saintsLodge);
    doubleCrossTavern.connectEast(southEndBeach);
    saintsLodge.connectSouth(southEndBeach);
  }

  @Override
  public void talkToNPC(Player player) throws InterruptedException {

  }

  @Override
  public void lookAroundLocation(Player player) throws InterruptedException {

  }

  @Override
  public void vendor(Player player) {
  }


  @Override
  public String toString() {
    return "IslaCruces{" +
      "churchCruces=" + churchCruces +
      ", southEndBeach=" + southEndBeach +
      ", saintsLodge=" + saintsLodge +
      ", doubleCrossTavern=" + doubleCrossTavern +
      "} " + super.toString();
  }
}
