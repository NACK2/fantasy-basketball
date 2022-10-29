package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {
    private Player player;

    @BeforeEach
    public void setUp() {
        player = new Player();
    }

    @Test
    public void setNameTest() {
        player.setName("Nick");
        assertEquals("Nick", player.getName());
    }

    @Test
    public void setTeamTest() {
        player.setTeam("Los Angeles Lakers");
        assertEquals("Los Angeles Lakers", player.getTeam());
    }

    @Test
    public void setPositionTest() {
        player.setPosition("Power Forward");
        assertEquals("Power Forward", player.getPosition());
    }

    @Test
    public void setHeightTest1() {
        player.setHeight(201);
        assertEquals(201, player.getHeight());
    }

    @Test
    public void setHeightTest2() {
        player.setHeight(1);
        assertEquals(1, player.getHeight());
    }

    @Test
    public void setWeightTest1() {
        player.setWeight(75);
        assertEquals(75, player.getWeight());
    }

    @Test
    public void setWeightTest2() {
        player.setWeight(1);
        assertEquals(1, player.getWeight());
    }

    @Test
    public void checkPlayerExistsTrueTest() {
        AllPlayers allPlayers = new AllPlayers();
        player.setName("LeBron James");
        allPlayers.addPlayer(player);
        assertTrue(player.checkPlayerExists("Lebron James", allPlayers));
    }

    @Test
    public void checkPlayerExistsTrueCapitalizationTest() {
        AllPlayers allPlayers = new AllPlayers();
        player.setName("LeBron James");
        allPlayers.addPlayer(player);
        assertTrue(player.checkPlayerExists("LEBRON jaMeS", allPlayers));
    }

    @Test
    public void checkPlayerExistsFalseTest() {
        AllPlayers allPlayers = new AllPlayers();
        player.setName("LeBron James");
        allPlayers.addPlayer(player);
        assertFalse(player.checkPlayerExists("Michael Jordan", allPlayers));
    }

    @Test
    public void setPointsTest() {
        player.setPoints(10);
        assertEquals(10, player.getPoints());
    }

    @Test
    public void setReboundsTest() {
        player.setRebounds(12);
        assertEquals(12, player.getRebounds());
    }

    @Test
    public void setAssistsTest() {
        player.setAssists(6);
        assertEquals(6, player.getAssists());
    }

    @Test
    public void setStealsTest() {
        player.setSteals(4);
        assertEquals(4, player.getSteals());
    }

    @Test
    public void setBlocksTest() {
        player.setBlocks(2);
        assertEquals(2, player.getBlocks());
    }
}
