# CS 441 Hello World!
This project contains a hello world android application which functions as a relaxing idle game. This game consists of falling Hello World bubbles 
and a dynamic upgrade system. Clicking the Hello World bubbles awards the player points based on their current power. Once the player has 
accumulated enough points to upgrade, their power will increases (along with the cost to upgrade). 

# Hello World Button spawning
I used a Handler and a Runnable object to continuously spawn Hello World bubles. There is a start delay (delays the start of the spawning) and 
a spawn delay (delays the next spawn) associated with this repeated action. The Hello World bubbles are ImageButton objects with 1 of 4 randomly 
assigned images (Red, Yellow, Blue, Green). The bubbles are moved by using an ObjectAnimator. When a bubble is clicked, the player's power is 
added to the score and the bubble pops. A popped bubble will stop moving (the associated ObjectAnimator is stopped) and the image will be changed 
to the Goodbye World image. After 0.2 seconds, the image will become inactive and invisible.

# Inspiration
This game is inpired by a variety of idle game applications, but specifically from the application "Jerry's Game". Jerry's Game consists of balloons 
rising and is meant to be a relaxing game for players. This game is meant to add a little bit of pace and competitiveness to this concept while
 still remaining relaxing to players. This is done by implementing an exponentially varying upgrade system. Considering the points are spent on
 the upgrades, the player is forced to weigh the value of each upgrade relative to their score as the upgrade costs continue to increase. The
 graphics of this game were intended to mimic an old-fashioned cartoon.

# Next steps
The next steps for this game would be implementing a saving system (so that player status is not lost on the applications closing) and adding to
 the upgrade system. Possible upgrades could be acquiring potential power-ups, decreasing gap in economy relative to power and upgrade cost, and
 automatic clickers (ex. 1 automatic click every 5 seconds, then 4.5, etc.).


