package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
}
