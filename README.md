## Blackjack

#### Skill Distillery Week 3 Homework
This app simulates a SIMPLE, no bells or whistles (ok maybe a tiny bell) Blackjack game.
The value of the ACE is 11.  Keep that in mind when tallying your score.

#### How to play
When the game first runs, the user will be asked if they want to play.  The game
begins when the player types "Y".  From there, the player is prompted throughout
to stay or hit depending on the value of the hand.

#### Lessons Learned
I started off with one giant set of conditions but decided to break them up into
methods that were related to the choice the player made.  For example, if the player
chose to hit, I wanted the game/player to call a method called "Hit".  If the player
chose to stay, I wanted the game/player to be able to call a "Stay" method. Each
method would then evaluate both player and dealer hands for a winner, loser, or tie.
Going this route made it easier for me to follow the flow of the game as it entered
different "areas" rather than trying to follow one giant block of code as player
jumped from hit to stay or hit multiple times before staying.  

Yes, the methods could use some cleaning up but they were designed to help me keep
track of the dealing order.  Refactoring is definitely in the future for this one.

Logic flow was the hardest part because the game can go down various paths
depending on both player and dealer's hand values.  Debugging wasn't hard, but
rather time-consuming because I tried to keep from repeating code while still trying
to meet the requirements of the game.

Through all the blood sweat and tears, and heartache and pain, of this project, unicode made me the happiest.  My friend watched me as I played my own game, she said "You like playing
your own game, don't you?"  I said, "Yes, I made it!"
