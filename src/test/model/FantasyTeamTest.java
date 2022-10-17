package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FantasyTeamTest {
    FantasyTeam fantasyTeam;

    @BeforeEach
    public void setUp() {
        fantasyTeam = new FantasyTeam("Nick");
    }

    @Test
    public void getUserTest() {
        assertEquals("Nick", fantasyTeam.getUser());
    }

    @Test
    public void draftPlayerTest() {
        Player player = new Player();
        player.setName("Michael Jordan");
        fantasyTeam.draftPlayer(player);
        assertEquals(player, fantasyTeam.getFantasyTeam().get(0));
    }

    @Test
    public void draftMultiplePlayersTest() {
        Player player = new Player();
        player.setName("Michael Jordan");
        fantasyTeam.draftPlayer(player);

        Player player2 = new Player();
        player2.setName("LeBron James");
        fantasyTeam.draftPlayer(player2);

        assertEquals(player, fantasyTeam.getFantasyTeam().get(0));
        assertEquals(player2, fantasyTeam.getFantasyTeam().get(1));
    }
}
