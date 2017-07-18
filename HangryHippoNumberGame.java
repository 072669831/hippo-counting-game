
/**
 * The Hangry Hippo Number Game!
 * The Hangry Hippo wants a three course meal.
 * He craves some specific meals (numbers) and will be
 * very upset if his feast is delayed.
 * Help the hangry Number Hippo satisfy his cravings.
 *
 * Emily Wu
 * April 10, 2017
 *
 */
import java.util.Scanner;
public class HangryHippoNumberGame
{
    private static Scanner usersGuess = new Scanner (System.in);
    private static Scanner usersOptions = new Scanner (System.in);
    private static Scanner usersOptions2 = new Scanner (System.in);
    private static Scanner startGame = new Scanner (System.in);
    private static Scanner playAgain = new Scanner (System.in);
    public static void main (String[]args)
    {
        //Intro
        System.out.println ("  /￣￣￣￣￣￣￣￣￣￣￣￣\\ ");
        System.out.println (" |  I am a hangry hippo |  ");
        System.out.println (" |      FEED ME!        |  ");
        System.out.println ("  \\＿　 ＿＿＿＿＿＿＿＿＿/  ");
        System.out.println ("   ∨                   ");
        System.out.println ("   (^----^)__________      ");
        System.out.println ("  / .` _'.\\          \\   ");
        System.out.println (" (   o____o)         |/   ");
        System.out.println ("  ＼  ＿  _______  __/  ");
        System.out.println ("    U   U     U  U        ");
        System.out.println ("\nInstructions: \nThe Hangry Hippo has a very specific palate and little patience.");
        System.out.println ("He demands a total of 3 courses. \nGuess which numbers he wishes to feast on for all three levels to win.");
        System.out.println ("Each wrong guess will add 5% to his Hangry Meter. \nWhen the meter reaches 100%, you lose!" );
        System.out.println ("\nAfter each wrong guess, you have the option of reducing the percentage on the \nHangry Meter by 5% or, you can choose to receive a small or large hint.\n(Choosing the big hint will increase the meter by 3% while small hints only increase by 1%)" );
        System.out.println ("Are you ready? (Enter \"y\" for yes or \"n\" for no). Good luck!!");
        String play = startGame.nextLine();

        lineBreak();
        if (play.equals("n"))
        {
            System.out.println ("Ok. :'( ");
        }
        while (play.equals("y"))
        {
            //Scores
            int numberOfTries = 1;
            int hangryMeter = 0;
            int totalNumTries = 0;

            //Input from user
            int guessNumber;

            boolean win = false;
            boolean lose = false;

            if (lose == false)
            {
                //////////////////////////////////////////////////////////////////////////Level 1: numbers from 1-399///////////////////////////////////////////////////////////////////////
                System.out.println ("\nRound 1: Appetizer \nThe Hangry Hippo is craving a number from 1-399");
                System.out.println ("\nWhat number will you be serving the Hangry Hippo?");
                displayHippo();

                System.out.println ("\nHangry Meter: " + hangryMeter + "%");

                int randomFirstNum=(int)(Math.round(Math.random()* 2)+1);
                int randomSecNum =(int)(Math.round(Math.random()* 8)+1);
                int randomThirdNum = (int)(Math.round(Math.random()* 8)+1);

                int randomNumber = (randomFirstNum * 100) + (randomSecNum * 10) + randomThirdNum;
                System.out.println (randomNumber);///////////////////////////////////////////////////////////////////////
                while (win == false && lose == false)
                {
                    System.out.println ("======================================================================");
                    System.out.println ("\nPlease enter your guess (" + numberOfTries + ") : ");
                    guessNumber = usersGuess.nextInt();
                    numberOfTries++;

                    if ((guessNumber != randomNumber))
                    {
                        hangryMeter += 5;
                        System.out.println ("\nHangry Meter: " + hangryMeter + "%");

                        System.out.println ("\nSorry, that is not the correct number");
                        System.out.println ("\nPlease enter \"d\" to decrease the Hangry Meter or enter \"h\" for a hint.");

                        //Get the integers in guessNumber
                        int firstInteger = guessNumber/ 100;
                        int secondInteger = (guessNumber - (firstInteger*100))/10;
                        int thirdInteger = guessNumber - ((firstInteger*100) + (secondInteger *10));
                        String choice = usersOptions.nextLine();

                        if (choice.equals( "d"))
                        {
                            hangryMeter -= 5;
                            displayHippo();
                            System.out.println ("Hangry Meter: " + hangryMeter + "%");
                        }
                        else if (choice.equals( "h"))
                        {
                            System.out.println ("\nPlease enter \"s\" for a small hint or a \"b\" for a big hint \nBig hints will add 3% to the Hangry Meter and small hints increase the meter by 1%");
                            String secondChoice = usersOptions2.nextLine();
                            if (secondChoice.equals("s"))
                            {
                                smallHint(guessNumber, randomNumber, randomFirstNum, randomSecNum, randomThirdNum);
                                hangryMeter += 1;
                                System.out.println ("\nHangry Meter: " + hangryMeter + "%");
                            }
                            else if (secondChoice.equals("b"))
                            {
                                bigHint(guessNumber, randomNumber, randomFirstNum, randomSecNum, randomThirdNum, firstInteger, secondInteger, thirdInteger);
                                hangryMeter += 3;
                                System.out.println ("\nHangry Meter: " + hangryMeter + "%");
                            }
                        }
                    }

                    if (hangryMeter == 100 || hangryMeter > 100)
                    {
                        loseDisplay();
                        System.out.println ("\nFinal Hangry Meter Amount: " + hangryMeter + "%");
                        lose = true;
                    }
                    if (guessNumber == randomNumber)
                    {
                        winDisplay(numberOfTries, hangryMeter);                   

                        System.out.println ("\nThat was soup-erb!"); 
                        win = true;
                        totalNumTries += numberOfTries;
                    }
                }
            }
            if (lose == false)
            { 
                ///////////////////////////////////////////////////////////////////////////Level 2: numbers from 1-750///////////////////////////////////////////////////////////////////////
                lineBreak();
                System.out.println ("\nRound 2: Main Course \nThe Hangry Hippo is craving a number from 1-750");

                System.out.println ("\nWhat number will you be serving the Hangry Hippo?");
                displayHippo();
                System.out.println ("Hangry Meter: " + hangryMeter + "%");

                int randomFirstNum=((int)(Math.round(Math.random()* 6)+1));
                int randomSecNum =(int)(Math.round(Math.random()* 4)+1);
                int randomThirdNum = (int)(Math.round(Math.random()* 9)+1);

                int randomNumber = (randomFirstNum * 100) + (randomSecNum * 10) + randomThirdNum;
                System.out.println (randomNumber);///////////////////////////////////////////////////////////////////////
                win = false;
                lose = false;

                numberOfTries = 0;

                while (win == false && lose == false)
                {       
                    System.out.println ("======================================================================");
                    System.out.println ("\nPlease enter your guess (" + numberOfTries + ") : ");
                    guessNumber = usersGuess.nextInt();
                    numberOfTries++;

                    if ((guessNumber != randomNumber))
                    {
                        hangryMeter += 5;
                        System.out.println ("\nHangry Meter: " + hangryMeter + "%");

                        System.out.println ("\nSorry, that is not the correct number");
                        System.out.println ("\nPlease enter \"d\" to decrease the Hangry Meter or enter \"h\" for a hint.");

                        //Get the integers in guessNumber
                        int firstInteger = guessNumber/ 100;
                        int secondInteger = (guessNumber - (firstInteger*100))/10;
                        int thirdInteger = guessNumber - ((firstInteger*100) + (secondInteger *10));
                        String choice = usersOptions.nextLine();

                        if (choice.equals( "d"))
                        {
                            hangryMeter -= 5;
                            displayHippo();
                            System.out.println ("Hangry Meter: " + hangryMeter + "%");
                        }
                        else if (choice.equals( "h"))
                        {
                            System.out.println ("\nPlease enter \"s\" for a small hint or a \"b\" for a big hint \nBig hints will add 3% to the Hangry Meter and small hints increase the meter by 1%");
                            String secondChoice = usersOptions2.nextLine();
                            if (secondChoice.equals("s"))
                            {
                                smallHint(guessNumber, randomNumber, randomFirstNum, randomSecNum, randomThirdNum);
                                hangryMeter += 1;
                                System.out.println ("\nHangry Meter: " + hangryMeter + "%");
                            }
                            else if (secondChoice.equals("b"))
                            {
                                bigHint(guessNumber, randomNumber, randomFirstNum, randomSecNum, randomThirdNum, firstInteger, secondInteger, thirdInteger);
                                hangryMeter += 3;
                                System.out.println ("\nHangry Meter: " + hangryMeter + "%");
                            }
                        }
                    }

                    if (hangryMeter == 100 || hangryMeter > 100)
                    {
                        loseDisplay();
                        System.out.println ("\nFinal Hangry Meter Amount: " + hangryMeter + "%");
                        lose = true;
                    }
                    if (guessNumber == randomNumber)
                    {
                        winDisplay(numberOfTries, hangryMeter);                

                        System.out.println ("Well done for meat-ing Hangry Hippo's expectations!");
                        win = true;

                        totalNumTries += numberOfTries;
                    }
                }
            }
            if (lose == false)
            {
                /////////////////////////////////////////////////////////////////////////Level 3: numbers from 1-999////////////////////////////////////////////////////////////////////////
                lineBreak();
                System.out.println ("\nRound 3: Dessert! \nThe Hangry Hippo is craving a number from 1-999");

                System.out.println ("\nWhat number will you be serving the Hangry Hippo?");
                displayHippo();
                System.out.println ("Hangry Meter: " + hangryMeter + "%");

                int randomFirstNum=((int)(Math.round(Math.random()* 8)+1));
                int randomSecNum =(int)(Math.round(Math.random()* 8)+1);
                int randomThirdNum = (int)(Math.round(Math.random()* 8)+1);

                int randomNumber = (randomFirstNum * 100) + (randomSecNum * 10) + randomThirdNum;
                System.out.println (randomNumber);///////////////////////////////////////////////////////////////////////
                win = false;
                lose = false;

                numberOfTries = 0;

                while (win == false && lose == false)
                {
                    System.out.println ("======================================================================");
                    System.out.println ("\nPlease enter your guess (" + numberOfTries + ") : ");
                    guessNumber = usersGuess.nextInt();
                    numberOfTries++;

                    if ((guessNumber != randomNumber))
                    {
                        hangryMeter += 5;
                        System.out.println ("\nHangry Meter: " + hangryMeter + "%");

                        System.out.println ("\nSorry, that is not the correct number");
                        System.out.println ("\nPlease enter \"d\" to decrease the Hangry Meter or enter \"h\" for a hint.");

                        //Get the integers in guessNumber
                        int firstInteger = guessNumber/ 100;
                        int secondInteger = (guessNumber - (firstInteger*100))/10;
                        int thirdInteger = guessNumber - ((firstInteger*100) + (secondInteger *10));
                        String choice = usersOptions.nextLine();

                        if (choice.equals( "d"))
                        {
                            hangryMeter -= 5;
                            displayHippo();
                            System.out.println ("Hangry Meter: " + hangryMeter + "%");
                        }
                        else if (choice.equals( "h"))
                        {
                            System.out.println ("\nPlease enter \"s\" for a small hint or a \"b\" for a big hint \nBig hints will add 3% to the Hangry Meter and small hints increase the meter by 1%");
                            String secondChoice = usersOptions2.nextLine();
                            if (secondChoice.equals("s"))
                            {
                                smallHint(guessNumber, randomNumber, randomFirstNum, randomSecNum, randomThirdNum);
                                hangryMeter += 1;
                                System.out.println ("\nHangry Meter: " + hangryMeter + "%");
                            }
                            else if (secondChoice.equals("b"))
                            {
                                bigHint(guessNumber, randomNumber, randomFirstNum, randomSecNum, randomThirdNum, firstInteger, secondInteger, thirdInteger);
                                hangryMeter += 3;
                                System.out.println ("\nHangry Meter: " + hangryMeter + "%");
                            }
                        }
                    }

                    if (hangryMeter == 100 || hangryMeter > 100)
                    {
                        loseDisplay();
                        System.out.println ("\nFinal Hangry Meter Amount: " + hangryMeter + "%");
                        lose = true;
                    }
                    if (guessNumber == randomNumber)
                    {
                        win = true;

                        winDisplay(numberOfTries, hangryMeter);

                        System.out.println ("Tea-rrific! The Hangry Hippo feels flan-tastic. ");

                        System.out.println ("It took you a total of " + totalNumTries + " tries");
                        System.out.println("Congratulations, you win!.");
                    }
                }
            }
            lineBreak();

            System.out.println("\n Would you like to play again?\nEnter y or n");
            String replay = playAgain.nextLine();
            if(replay.equals("n"))
            {
                System.out.println ("Ok. Thank you for playing");
                play = "n";
            }
            if (replay.equals ("y"))
            {
                play = "y";
            }
        }
    }

    public static void displayHippo()
    {
        System.out.println ("   (`-\"\"\"-`)    ");
        System.out.println ("   /.`   '.\\  ");
        System.out.println ("  |.--._.--.|  ");
        System.out.println ("  (o       o)  ");
        System.out.println ("   `-u---u-'   ");
    }

    public static void lineBreak()
    {
        System.out.println ("\n===========================================================================================");
        System.out.println ("*******************************************************************************************");
        System.out.println ("===========================================================================================");
    }

    public static void bigHint(int guessNumber, int randomNumber, int randomFirstNum, int randomSecNum, int randomThirdNum, int firstInteger, int secondInteger, int thirdInteger)
    {
        int numCorrect = 0;
        int wrongPlace = 0;
        //To check if the user guessed the number right
        if (firstInteger == randomFirstNum)
        {
            numCorrect +=1;
        }

        if (firstInteger == randomSecNum && firstInteger != randomFirstNum)
        {
            wrongPlace +=1;
        }
        //To check if a number is already correctly inputted to randomSecNum or for repeated numbers (to prevent wrongNumber from exceeding 3)
        if (firstInteger == randomSecNum && firstInteger != randomFirstNum && secondInteger == firstInteger)
        {
            wrongPlace -=1;
        }
        if (firstInteger == randomSecNum && firstInteger != randomFirstNum && thirdInteger == firstInteger)
        {
            wrongPlace -=1;
        }

        if (firstInteger == randomThirdNum && firstInteger != randomFirstNum )
        {
            wrongPlace +=1;
        }
        //To check if a number is already correctly inputted to randomThirdNum
        if (firstInteger == randomThirdNum && firstInteger != randomFirstNum && thirdInteger == firstInteger)
        {
            wrongPlace -=1;
        }
        if (firstInteger == randomThirdNum && firstInteger != randomFirstNum && secondInteger == firstInteger)
        {
            wrongPlace -=1;
        }

        //To check if the user guessed the number right
        if (secondInteger == randomSecNum)
        {
            numCorrect +=1;
        }

        if (secondInteger == randomFirstNum && secondInteger != randomSecNum)
        {
            wrongPlace +=1;
        }
        //To check if a number is already correctly inputted to randomFirstNum
        if (secondInteger == randomFirstNum && secondInteger != randomSecNum && firstInteger == secondInteger)
        {
            wrongPlace -=1;
        }
        if (secondInteger == randomThirdNum && secondInteger != randomSecNum && thirdInteger == secondInteger)
        {
            wrongPlace -=1;
        }

        if (secondInteger == randomThirdNum && secondInteger != randomSecNum )
        {
            wrongPlace +=1;
        }
        //To check if a number is already correctly inputted to randomThirdNum
        if (secondInteger == randomThirdNum && secondInteger != randomSecNum && thirdInteger == secondInteger)
        {
            wrongPlace -=1;
        }
        if (secondInteger == randomThirdNum && secondInteger != randomSecNum && firstInteger == secondInteger)
        {
            wrongPlace -=1;
        }

        //To check if the user guessed the number right
        if (thirdInteger == randomThirdNum)
        {
            numCorrect +=1;
        }

        if (thirdInteger == randomFirstNum && thirdInteger != randomThirdNum )
        {
            wrongPlace +=1;
        }
        //To check if a number is already correctly inputted to randomFirstNum
        if (thirdInteger == randomFirstNum && thirdInteger != randomThirdNum && firstInteger == thirdInteger )
        {
            wrongPlace -=1;
        }
        if (thirdInteger == randomFirstNum && thirdInteger != randomThirdNum && secondInteger == thirdInteger)
        {
            wrongPlace -=1;
        }

        if (thirdInteger == randomSecNum && thirdInteger != randomThirdNum)
        {
            wrongPlace +=1;
        }
        //To check if a number is already correctly inputted to randomSecNum
        if (thirdInteger == randomSecNum && thirdInteger != randomThirdNum && secondInteger == thirdInteger)
        {
            wrongPlace -=1;
        }
        if (thirdInteger == randomSecNum && thirdInteger != randomThirdNum && firstInteger == thirdInteger)
        {
            wrongPlace -=1;
        }

        if (numCorrect == 0 || wrongPlace == 0)
        {
            System.out.println ("");
        }
        if (numCorrect == 0 && wrongPlace == 0)
        {
            System.out.println ("None of the digits are correct");

            int randomClue = (int)(Math.round(Math.random()* 2)+1);
            if (randomClue == 1)
            {
                System.out.println ("The first digit is " + randomFirstNum);
            }
            else if (randomClue == 2)
            {
                System.out.println ("The second digit is " + randomSecNum);
            }
            else if (randomClue == 3)
            {   
                System.out.println ("The third digit is " + randomThirdNum);
            }
        }
        if (numCorrect > 0)
        {
            System.out.println ("\nYou have " + numCorrect + " digit(s) correct in the right place" );
        }
        if (wrongPlace == 3 && numCorrect >0)
        {
            System.out.println ("\nYou have " + (wrongPlace-1) + " digit(s) correct, but in the wrong place");
        }
        else if (wrongPlace > 0 )
        {
            System.out.println ("\nYou have " + wrongPlace + " digit(s) correct, but in the wrong place");
        }

    }

    public static void smallHint(int guessNumber, int randomNumber, int randomFirstNum, int randomSecNum, int randomThirdNum)
    {
        if (guessNumber > randomNumber)
        {
            System.out.println ("The Hangry Hippo desires a smaller meal (Your guess is too high)");
            System.out.println ("The sum of the first and second integer multipled by 2 is " + ((randomFirstNum + randomSecNum)*2) );
        }
        if (guessNumber < randomNumber)
        {
            System.out.println ("The Hangry Hippo desires a larger meal (Your guess is too low)");
            System.out.println ("The sum of the second and third integer plus 8 is " + ((randomSecNum + randomThirdNum)+8) );
        }
    }

    public static void loseDisplay()
    {
        System.out.println ("The Hangry Hippo is furious! You lose this round.");
        System.out.println ("  .-''''-.  ");
        System.out.println (" ('    '  '0)-/) ");
        System.out.println ("  '..____..:   \\._        >:( ");
        System.out.println ("   \\u  u (        '-..------._");
        System.out.println ("   |   /   :   '.             '--. ");
        System.out.println ("   .nn_nn/ (   :   '           '\\");
        System.out.println ("   ( '' '' /   ;   .               \\ ");
        System.out.println ("   ''----' \"\\        :            : '. ");
        System.out.println ("           .'/                         '. ");
        System.out.println ("           / /                           '. ");
        System.out.println ("       /_|     )                        \\| ");
        System.out.println ("           |   /\\                     . ' ");
        System.out.println ("           '--.__|  '--._  ,           / ");
        System.out.println ("                       /'-,        .' ");
        System.out.println ("                       /   |       _.'  ");
        System.out.println ("                       (___\\      /");
        System.out.println ("                           \\  \\  ");
        System.out.println ("                           '-'-'-'   ");
    }

    public static void winDisplay(int numberOfTries, int hangryMeter)
    {
        System.out.println ("Congratulations! The Hangry Hippo is satisfied (for now)");
        System.out.println ("It took you " + (numberOfTries-1) + " tries" );
        System.out.println ("\nHangry Meter: " + hangryMeter + "%");

        System.out.println ("          (),..(')                ");
        System.out.println ("        ,'.   .     `.       :)       ");
        System.out.println ("       .-----.         '`.        ");
        System.out.println ("      (o     o)           ;       ");
        System.out.println ("      ,`--'__,          ,'\\     ");
        System.out.println ("     ,`.____                `.    ");
        System.out.println ("    /                `,      |    ");
        System.out.println ("   '                  \\,     '   ");
        System.out.println ("   |                   /   /`,    ");
        System.out.println ("     `,  .            ,` ./  |    ");
        System.out.println ("     ' `.  ,'         |;,'   ,/   ");
        System.out.println ("_____|     |      _________,___________ ");
        System.out.println ("      `.   `.   ,'");
        System.out.println ("       ,'_,','_,");
        System.out.println ("       `'   `'");
    }
}

