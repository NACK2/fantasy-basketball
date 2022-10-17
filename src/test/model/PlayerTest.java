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
    public void setHeightTest() {
        player.setHeight(201);
        assertEquals(201, player.getHeight());
    }

    @Test
    public void setHeightBoundaryTest() {
        player.setHeight(1);
        assertEquals(1, player.getHeight());
    }

    @Test
    public void setWeightTest() {
        player.setWeight(75);
        assertEquals(75, player.getWeight());
    }

    @Test
    public void setWeightBoundaryTest() {
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
}
