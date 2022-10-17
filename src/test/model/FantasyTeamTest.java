package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FantasyTeamTest {
    FantasyTeam fantasyTeam;
    Player player;

    @BeforeEach
    public void setUp() {
        fantasyTeam = new FantasyTeam("Nick");
        player = new Player();
        player.setName("Michael Jordan");
        fantasyTeam.draftPlayer(player);
    }

    @Test
    public void getUserTest() {
        assertEquals("Nick", fantasyTeam.getUser());
    }

    @Test
    public void draftPlayerTest() {
        assertEquals(player, fantasyTeam.getFantasyTeam().get(0));
    }

    @Test
    public void draftMultiplePlayersTest() {
        Player player2 = new Player();
        player2.setName("LeBron James");
        fantasyTeam.draftPlayer(player2);

        assertEquals(player, fantasyTeam.getFantasyTeam().get(0));
        assertEquals(player2, fantasyTeam.getFantasyTeam().get(1));
    }

    @Test
    public void getFantasyTeamTest() {
        List<Player> players = fantasyTeam.getFantasyTeam();
        assertEquals(player, players.get(0));
    }

    @Test
    public void getFantasyTeamMultipleTest() {
        Player player2 = new Player();
        player.setName("LeBron James");
        fantasyTeam.draftPlayer(player2);

        List<Player> players = fantasyTeam.getFantasyTeam();
        assertEquals(player, players.get(0));
        assertEquals(player2, players.get(1));
    }
}
