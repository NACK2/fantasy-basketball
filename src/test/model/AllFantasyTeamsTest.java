package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AllFantasyTeamsTest {
    AllFantasyTeams allFantasyTeams;
    FantasyTeam fantasyTeam;

    @BeforeEach
    public void setUp() {
        allFantasyTeams = new AllFantasyTeams();
        fantasyTeam = new FantasyTeam("Bob");
        allFantasyTeams.addTeam(fantasyTeam);
    }

    @Test
    public void addTeamTest() {
        assertEquals(fantasyTeam, allFantasyTeams.getTeams().get(0));
    }

    @Test
    public void addMultipleTeamsTest() {
        FantasyTeam fantasyTeam2 = new FantasyTeam("Bill");
        allFantasyTeams.addTeam(fantasyTeam2);

        assertEquals(fantasyTeam, allFantasyTeams.getTeams().get(0));
        assertEquals(fantasyTeam2, allFantasyTeams.getTeams().get(1));
    }

    @Test
    public void getTeamsTest() {
        List<FantasyTeam> fantasyTeams = allFantasyTeams.getTeams();
        assertEquals(fantasyTeam, fantasyTeams.get(0));
    }

    @Test
    public void getTeamsMultipleTest() {
        FantasyTeam fantasyTeam2 = new FantasyTeam("Bill");
        allFantasyTeams.addTeam(fantasyTeam2);

        FantasyTeam fantasyTeam3 = new FantasyTeam("Joe");
        allFantasyTeams.addTeam(fantasyTeam3);

        List<FantasyTeam> fantasyTeams = allFantasyTeams.getTeams();

        assertEquals(fantasyTeam, fantasyTeams.get(0));
        assertEquals(fantasyTeam2, fantasyTeams.get(1));
        assertEquals(fantasyTeam3, fantasyTeams.get(2));
    }

    @Test
    public void getUsersFantasyTeamExistsTest() {
        assertEquals(fantasyTeam, allFantasyTeams.getUsersFantasyTeam("Bob"));
    }

    @Test
    public void getUsersFantasyTeamExistsIgnoreCapitalizationTest() {
        assertEquals(fantasyTeam, allFantasyTeams.getUsersFantasyTeam("BOB"));
        assertEquals(fantasyTeam, allFantasyTeams.getUsersFantasyTeam("bOB"));
        assertEquals(fantasyTeam, allFantasyTeams.getUsersFantasyTeam("bob"));
    }

    @Test
    public void getUsersFantasyTeamDoesntExistTest() {
        assertEquals(null, allFantasyTeams.getUsersFantasyTeam("Joe"));
    }

    @Test
    public void userExistsTrueTest() {
        assertTrue(allFantasyTeams.userExists("Bob"));
    }

    @Test
    public void userExistsTrueIgnoreCapitalizationTest() {
        assertTrue(allFantasyTeams.userExists("bob"));
        assertTrue(allFantasyTeams.userExists("BOB"));
        assertTrue(allFantasyTeams.userExists("bOB"));
    }

    @Test
    public void userExistsFalseTest() {
        assertFalse(allFantasyTeams.userExists("Joe"));
    }
}
