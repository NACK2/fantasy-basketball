# My Personal Project: Fantasy Basketball 
### Nicholas Kang

The project I am pursuing is **Fantasy Basketball**.

- **What will the application do?**

This desktop application will allow users to be in a fantasy basketball league 
with other users on the same computer. Each user will be able to draft players
from the NBA of their choice, as long as they have not been taken by another user.
Depending on how the players on a users team perform, 
the user may gain or lose points. The user with the most points 
at the end of a season will be the winner. 

- **Who will use it?**

The people who can use this application are those who are interested in basketball and enjoy the idea of a hypothetical, 
fantasy basketball league between the game's greatest players.

- **Why is this project of interest to you?**

The players drafted by the users will most likely not be teammates in reality,
therefore it interests me to experiment and create something that is impossible to confirm in real life.
I have never  participated in fantasy basketball leagues myself, so this 
will be an opportunity for me to learn, research, and develop at the 
same time. 

## User stories
- As a user, I want to be able to create a fantasy team and add it to a list containing all the fantasy teams
  (Adding fantasyTeam class to allFantasyTeams class)
- As a user, I want to be able to draft any available NBA player to my fantasy team
  (Adding Player class to fantasyTeam class)
- As a user, I want to be able to view a player's measurements (height, weight, etc.)
- As a user, I want to be able to view every player on my and other users fantasy teams
- As a user, I want to be able to match up against another users fantasy team
- As a user, I want to be able to see how many points, rebounds, assists, etc. every player on my team has
- As a user, I want to be able to add a player to a class of all players
- As a user, I want to be able to save my fantasy team to a file
- As a user, I want to be able to load my fantasy team from a file

Note: The persistence packages in main and test were modeled after 
https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo

# Instructions for Grader
- First "Adding Multiple X's to Y": Click "play", then you will be asked to enter two user names. The two usernames will be
added to a FantasyTeam class and will be used as the owner name of a fantasy team
- Second "Adding Multiple X's to Y": After entering two user names, both users
will get a chance to draft 5 players by entering the players name, team, height, etc. That information
will be used to create a Player class, then that Player class will be added to a FantasyTeam class, which will
eventually be added to an AllFantasyTeam class
- The visual component is the background image of a basketball court that remains throughout the entire program
- The user can save to file after both users have drafted players to their team (Note: After saving to file,
there is no more functionality beyond that as of yet, which is why you can't do anything after saving)
- The user can load from file at the beginning of the program (Note, after loading from file, the players loaded
from file will display on screen, but there is no functionality from there, you must restart the program)