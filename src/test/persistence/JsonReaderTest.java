package persistence;

import model.AllFantasyTeams;
import model.FantasyTeam;
import model.Player;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class JsonReaderTest {
    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            AllFantasyTeams allFantasyTeams = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyWorkRoom() {
        JsonReader reader = new JsonReader("./data/testReaderZeroFantasyTeams.json");
        try {
            AllFantasyTeams allFantasyTeams = reader.read();
            assertTrue(allFantasyTeams.getTeams().isEmpty());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderTwoFantasyTeams() {
        JsonReader reader = new JsonReader("./data/testReaderTwoFantasyTeams.json");
        try {
            AllFantasyTeams allFantasyTeams = reader.read();

            FantasyTeam fantasyTeamOne = new FantasyTeam("Bob");
            FantasyTeam fantasyTeamTwo = new FantasyTeam("Bill");
            allFantasyTeams.addTeam(fantasyTeamOne);
            allFantasyTeams.addTeam(fantasyTeamTwo);
            draftPlayers(fantasyTeamOne, fantasyTeamTwo);
            setStats(fantasyTeamOne, fantasyTeamTwo);

            List<FantasyTeam> retAllFantasyTeams = allFantasyTeams.getTeams();
            FantasyTeam retFantasyTeamOne = allFantasyTeams.getTeams().get(0);
            FantasyTeam retFantasyTeamTwo = allFantasyTeams.getTeams().get(1);

            assertTrue(allFantasyTeams.userExists("Bob"));
            assertTrue(allFantasyTeams.userExists("Bill"));
            assertFalse(allFantasyTeams.userExists("Joe"));

            assertEquals("Bob", retAllFantasyTeams.get(0).getUser());
            assertEquals("Bill", retAllFantasyTeams.get(1).getUser());

            assertEquals("LeBron James", retFantasyTeamOne.getFantasyTeam().get(0).getName());
            assertEquals("Kevin Durant", retFantasyTeamOne.getFantasyTeam().get(1).getName());
            assertEquals("Kobe Bryant", retFantasyTeamTwo.getFantasyTeam().get(0).getName());
            assertEquals("Michael Jordan", retFantasyTeamTwo.getFantasyTeam().get(1).getName());

            assertEquals(15, retFantasyTeamOne.getTotalPoints());
            assertEquals(10, retFantasyTeamOne.getTotalRebounds());
            assertEquals(7, retFantasyTeamOne.getTotalAssists());
            assertEquals(4, retFantasyTeamOne.getTotalSteals());
            assertEquals(3, retFantasyTeamOne.getTotalBlocks());
            assertEquals(39, retFantasyTeamOne.getTeamMatchScore());
            assertEquals(39, retFantasyTeamOne.getTeamTotalScore());

            assertEquals(13, retFantasyTeamTwo.getTotalPoints());
            assertEquals(12, retFantasyTeamTwo.getTotalRebounds());
            assertEquals(10, retFantasyTeamTwo.getTotalAssists());
            assertEquals(5, retFantasyTeamTwo.getTotalSteals());
            assertEquals(2, retFantasyTeamTwo.getTotalBlocks());
            assertEquals(42, retFantasyTeamTwo.getTeamMatchScore());
            assertEquals(42, retFantasyTeamTwo.getTeamTotalScore());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    public void draftPlayers(FantasyTeam fantasyTeamOne, FantasyTeam fantasyTeamTwo) {
        Player playerOne = new Player();
        playerOne.setName("LeBron James");
        Player playerTwo = new Player();
        playerTwo.setName("Kevin Durant");
        Player playerThree = new Player();
        playerThree.setName("Kobe Bryant");
        Player playerFour = new Player();
        playerFour.setName("Michael Jordan");

        fantasyTeamOne.draftPlayer(playerOne);
        fantasyTeamOne.draftPlayer(playerTwo);
        fantasyTeamTwo.draftPlayer(playerThree);
        fantasyTeamTwo.draftPlayer(playerFour);
    }

    public void setStats(FantasyTeam fantasyTeamOne, FantasyTeam fantasyTeamTwo) {
        fantasyTeamOne.setTotalPoints(15);
        fantasyTeamOne.setTotalRebounds(10);
        fantasyTeamOne.setTotalAssists(7);
        fantasyTeamOne.setTotalSteals(4);
        fantasyTeamOne.setTotalBlocks(3);
        fantasyTeamOne.setTeamMatchScore();

        fantasyTeamTwo.setTotalPoints(13);
        fantasyTeamTwo.setTotalRebounds(12);
        fantasyTeamTwo.setTotalAssists(10);
        fantasyTeamTwo.setTotalSteals(5);
        fantasyTeamTwo.setTotalBlocks(2);
        fantasyTeamTwo.setTeamMatchScore();
    }
}
