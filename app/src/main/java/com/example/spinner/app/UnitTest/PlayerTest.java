package com.example.spinner.app.UnitTest;

import android.test.InstrumentationTestCase;
import android.util.Log;

import com.example.spinner.app.Player;

/**
 * Created by klarsen on 5/25/2014.
 */
public class PlayerTest extends InstrumentationTestCase {
    public void testPlayerConstructs() throws Exception {
        //final int expected = 1;
        //final int reality = 5;
        //assertEquals(expected, reality);
        com.example.spinner.app.Player player;

        player = new Player();
        assertTrue(player!= null);

        player = null;
        player = new Player("Some Guy", "PHI", "QB", "5.09", "163", "10.43");
        assertTrue(player.getPosition() == "QB");
    }
    public void testPlayerDeserialize(){
        Player player = new Player();
        player.Deserialize("Some Guy~WR~Team~HGT~WGT~SPD");
        Log.v("Player Pos", player.getPosition());
        assertEquals(player.getPosition(), "WR");
    }
    public void testPlayerSerialize(){
        Player player = new Player("sinD", "TE", "MT State","5.06", "125","5.38");
        Log.v("Player string", player.Serialize());
        assertTrue(player.Serialize().length() > 1);
        assertTrue(player != null);
    }
}
