package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AllPlayersTest {
    AllPlayers allPlayers;
    Player player;

    @BeforeEach
    public void setUp() {
        allPlayers = new AllPlayers();
        player = new Player();
        player.setName("Mario");
        allPlayers.addPlayer(player);
    }

    @Test
    public void addPlayerTest() {
        assertEquals(player, allPlayers.getPlayers().get(0));
    }

    @Test
    public void addMultiplePlayersTest() {
        Player player2 = new Player();
        player2.setName("Luigi");
        allPlayers.addPlayer(player2);

        assertEquals(player, allPlayers.getPlayers().get(0));
        assertEquals(player2, allPlayers.getPlayers().get(1));
    }
}
