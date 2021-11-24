// TNPG: All Brians (Ryan Lau, Brian Kang, Brian Wang)
// APCS
// L01: An Adventurer is You!
// 2021-11-23
// time spent: 1.0 hr

/*
TODO:
    - [X] create 3 Protagonist subclasses
    - [X] create 3 Monster subclasses
    - [X] implement static about() method into each subclass
    - [X] allow for player to choose their class
    - [X] add "OUR DRIVER MODS" block comment
    - [X] edit README.md to
        - [X] prominently display TNPG + roster
        - [X] explain new classes
        - [X] summarize version to version mods
        - [X] list ways to grow this game in the future

    - [X] copy latest working version into root
    - [X] add heading to notes.txt
    - [X] add disco/qcc/notes into notes.txt

    - [X] fill googform
*/

/* OUR DRIVER MODS
    - implement user choice for Protagonist role
    - implement random type of Monster to spawn
*/

import java.io.*;
import java.util.*;

public class YoRPG {

  // ~~~~~~~~~~~ INSTANCE VARIABLES ~~~~~~~~~~~

  //change this constant to set number of encounters in a game
  public final static int MAX_ENCOUNTERS = 5;

  //each round, a Protagonist and a Monster will be instantiated...
  private Protagonist pat;
  private Monster smaug;

  private int moveCount;
  private boolean gameOver;
  private int difficulty;

  private InputStreamReader isr;
  private BufferedReader in;
  // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


  // ~~~~~~~~~~ DEFAULT CONSTRUCTOR ~~~~~~~~~~~
  public YoRPG() {
    moveCount = 0;
    gameOver = false;
    isr = new InputStreamReader( System.in );
    in = new BufferedReader( isr );
    newGame();
  }
  // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~



  // ~~~~~~~~~~~~~~ METHODS ~~~~~~~~~~~~~~~~~~~

  /*=============================================
    void newGame() -- gathers info to begin a new game
    pre:
    post: according to user input, modifies instance var for difficulty
    and instantiates a Protagonist
    =============================================*/
  public void newGame() {
    String s;
    String name = "";
    s = "~~~ Welcome to Ye Olde RPG! ~~~\n";

    s += "\nChoose your difficulty: \n";
    s += "\t1: Easy\n";
    s += "\t2: Not so easy\n";
    s += "\t3: Beowulf hath nothing on me. Bring it on.\n";
    s += "Selection: ";
    System.out.print( s );

    try {
	    difficulty = Integer.parseInt( in.readLine() );
    }
    catch ( IOException e ) { }

    s = "Intrepid protagonist, what doth thy call thyself? (State your name): ";
    System.out.print( s );

    try {
	    name = in.readLine();
    }
    catch ( IOException e ) { }


    s = name + ", what role doth thy be? (Choose a number corresponding to the role)\n";
    s += "\t1: Warrior: " + Warrior.about() + "\n";
    s += "\t2: Monk: " + Monk.about() + "\n";
    s += "\t3: Barbarian: " + Barbarian.about() + "\n";
    s += "Selection: ";
    System.out.print( s );

    int role = 0;

    try {
	    role = Integer.parseInt( in.readLine() );
    }
    catch ( IOException e ) { }

    //instantiate the player's character
    if (role == 1) {
        pat = new Warrior(name);
    } else if (role == 2) {
        pat = new Monk(name);
    } else if (role == 3) {
        pat = new Barbarian(name);
    } else {
        System.out.println("invalid choice, you will be a default protagonist :(");
        pat = new Protagonist( name );
    }
  }//end newGame()


  /*=============================================
    boolean playTurn -- simulates a round of combat
    pre:  Protagonist pat has been initialized
    post: Returns true if player wins (monster dies).
    Returns false if monster wins (player dies).
    =============================================*/
  public boolean playTurn() {
    int i = 1;
    int d1, d2;

    if ( Math.random() >= ( difficulty / 3.0 ) )
	    System.out.println( "\nNothing to see here. Move along!" );
    else {
	    System.out.println( "\nLo, yonder monster approacheth!" );

        int randInt = (int) (Math.random() * (3 - 1)) + 1;

        if (randInt == 1) {
            smaug = new Assassin();
        } else if (randInt == 2) {
            smaug = new Thief();
        } else if (randInt == 3) {
            smaug = new Paladin();
        } else {
            System.out.println("something went wrong! creating default monster");
            smaug = new Monster();
        }

	    while( smaug.isAlive() && pat.isAlive() ) {

        // Give user the option of using a special attack:
        // If you land a hit, you incur greater damage,
        // ...but if you get hit, you take more damage.
        try {
          System.out.println( "\nDo you feel lucky?" );
          System.out.println( "\t1: Nay.\n\t2: Aye!" );
          i = Integer.parseInt( in.readLine() );
        }
        catch ( IOException e ) { }

        if ( i == 2 )
          pat.specialize();
        else
          pat.normalize();

        d1 = pat.attack( smaug );
        d2 = smaug.attack( pat );

        System.out.println( "\n" + pat.getName() + " dealt " + d1 +
                            " points of damage.");

        System.out.println( "\n" + "Ye Olde Monster smacked " + pat.getName() +
                            " for " + d2 + " points of damage.");
	    }//end while

	    //option 1: you & the monster perish
	    if ( !smaug.isAlive() && !pat.isAlive() ) {
        System.out.println( "'Twas an epic battle, to be sure... " +
                            "You cut ye olde monster down, but " +
                            "with its dying breath ye olde monster. " +
                            "laid a fatal blow upon thy skull." );
        return false;
	    }
	    //option 2: you slay the beast
	    else if ( !smaug.isAlive() ) {
        System.out.println( "HuzzaaH! Ye olde monster hath been slain!" );
        return true;
	    }
	    //option 3: the beast slays you
	    else if ( !pat.isAlive() ) {
        System.out.println( "Ye olde self hath expired. You got dead." );
        return false;
	    }
    }//end else

    return true;
  }//end playTurn()
  // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


  public static void main( String[] args ) {
    //As usual, move the begin-comment bar down as you progressively
    //test each new bit of functionality...

    //loading...
    YoRPG game = new YoRPG();

    int encounters = 0;

    while( encounters < MAX_ENCOUNTERS ) {
    if ( !game.playTurn() )
    break;
    encounters++;
    System.out.println();
    }

    System.out.println( "Thy game doth be over." );
    /*================================================
	  ================================================*/
  }//end main

}//end class YoRPG
