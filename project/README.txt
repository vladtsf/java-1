Vlad T's Connect4
------------------------
This is my implementation of Connect4.


Additional Smart Action:
------------------------
It is pretty simple. The SmartComputerPlayer scans the board.
If it finds a move that makes it the winner, it makes the move.
The logic can be found in the `SmartComputerPlayer` class, in the method `otherSmartThing.`

Extras:
------------------------
In order to write tests and keep the `grid` property encapsulated,
I created a helper called `BombFactory` that basically reads a text template
and generates a board based on what it has read. It's very convenient.

Running Tests:
------------------------
Tests can be run with JUnit.

Bomb Usage:
------------------------
To make a so called bomb move, one should press the "b" button and chose a desired location using the cursor.
Once "b" is pressed, the cursor will change its icon. If you try to use a bomb while you're out, the cursor icon will indicate so, as well.