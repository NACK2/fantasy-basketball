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

    @Test
    public void setTotalPointsTest() {
        fantasyTeam.setTotalPoints(10);
        assertEquals(10, fantasyTeam.getTotalPoints());
    }

    @Test
    public void setTotalReboundsTest() {
        fantasyTeam.setTotalRebounds(16);
        assertEquals(16, fantasyTeam.getTotalRebounds());
    }

    @Test
    public void setTotalAssistsTest() {
        fantasyTeam.setTotalAssists(12);
        assertEquals(12, fantasyTeam.getTotalAssists());
    }

    @Test
    public void setTotalStealsTest() {
        fantasyTeam.setTotalSteals(4);
        assertEquals(4, fantasyTeam.getTotalSteals());
    }

    @Test
    public void setTotalBlocksTest() {
        fantasyTeam.setTotalBlocks(4);
        assertEquals(4, fantasyTeam.getTotalBlocks());
    }

    @Test
    public void setTeamMatchScoreZeroTest() {
        fantasyTeam.setTeamMatchScore();
        assertEquals(0, fantasyTeam.getTeamMatchScore());
    }

    @Test
    public void setTeamMatchScoreNonZeroTest() {
        fantasyTeam.setTotalPoints(10);
        fantasyTeam.setTotalRebounds(10);
        fantasyTeam.setTotalAssists(7);
        fantasyTeam.setTotalSteals(5);
        fantasyTeam.setTotalBlocks(2);
        fantasyTeam.setTeamMatchScore();
        assertEquals(34, fantasyTeam.getTeamMatchScore());
    }

    @Test
    public void setTeamTotalScoreTest() {
        for (int i = 0; i < 2; ++i) {
            fantasyTeam.setTotalPoints(10);
            fantasyTeam.setTotalRebounds(10);
            fantasyTeam.setTotalAssists(10);
            fantasyTeam.setTotalSteals(10);
            fantasyTeam.setTotalBlocks(10);
            fantasyTeam.setTeamMatchScore();
            assertEquals(50, fantasyTeam.getTeamMatchScore());
        }
        assertEquals(100, fantasyTeam.getTeamTotalScore());
    }
}
