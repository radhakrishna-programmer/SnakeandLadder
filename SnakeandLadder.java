 import java.util.HashMap;
 import java.util.Map;
 import java.util.Random;
 import java.util.Scanner;
/* SnakeNLadder class consists of keys and attributes of snakes and ladders positions and methods*/
 class SnakeNLadder{
     final static int WinPoint =100;
      static Map <Integer, Integer> snake = new HashMap<Integer , Integer>();
      static Map <Integer, Integer> ladder = new HashMap<Integer , Integer>();
    
    {
        
        snake.put(99,76);
        snake.put(92,64);
        snake.put(85,15);
        snake.put(64,46);
        snake.put(76,19);
        snake.put(54,30);
        snake.put(11,7);



        ladder.put(71,91);
        ladder.put(63,81);
        ladder.put(28,84);
        ladder.put(40,59);
        ladder.put(20,38);
        ladder.put(9,31);
        ladder.put(4,14);
        
    }
    public int rollDice(){
        int n=0;
        Random r=new Random();
        n=r.nextInt(7);
        return (n==0?1:n);
    }
    public int PlayerValue(int player , int diceValue){
        player =player+diceValue;
        if(player > WinPoint){
            player=player-diceValue;
            return player;
        }
        if(null !=snake.get(player)){
            System.out.println("Snake  Swallowed" );
            player =snake.get(player);
        }
        if(null !=ladder.get(player)){
            System.out.println(" Climb the ladder" );
            player =ladder.get(player);
        }
         return player;
    }
    public boolean isWin( int player){
        return WinPoint ==player;
    }
    public void startGame(){
         int player1=0,player2=0;
         int currentPlayer=-1;
         Scanner input =new Scanner(System.in);
         String str;
         int diceValue=0;
          do{
              System.out.println(currentPlayer ==-1 ?"\n\n First Player Turn":"Second Player Turn");
              System.out.println("Press d to roll Dice");
              str=input.next();
              diceValue=rollDice();
              if(currentPlayer ==-1){
                   player1=PlayerValue(player1, diceValue);
                   System.out.println("First Player :" +player1);
                   System.out.println("SecondPlayer :" +player2);
                   System.out.println("----------------------------------");
                    if(isWin(player1)){
                        System.out.println("Player 1 Wins the Game");
                    return;
                    }
                }
                else{
                    player2=PlayerValue(player2, diceValue);
                    System.out.println("First Player :" +player1);
                    System.out.println("SecondPlayer :" +player2);
                    System.out.println("----------------------------------");
                     if(isWin(player2)){
                         System.out.println("Player 2 Wins the Game");
                     return;
                     }
                }

                currentPlayer=-currentPlayer;
          }while("d".equals(str));
    }
}
   

public class SnakeandLadder{
    public static void main(String[]args) {
        int counter= 100;// sets the counter and iteration vaiables to be used in making the board
        System.out.println ("-----------------------------------------------------Game Board-----------------------------------------------------");
        
        /*
        This while loop makes the board for the player to visualize what the
        game looks like, it uses a counter to increment or decrement by 1.
        It will also subtract by 9 or 10 when necessary to create a board
        exactly like the one given.
        */
        while (counter > 0){// start while
            if (counter%10 == 0 && counter != 100){// checks if the counter is at a 90, or 80...
              
                if(counter!=0)
                System.out.print("\n" + counter + "\t"); // just prints out the counter with a line breck
            }
            else
            System.out.print(counter + "\t"); // just prints out the counter
            counter+=-1; // sets counter to add by iteration
        }
        System.out.println();
        System.out.println ("-------------------------------------------------------------------------------------------");
        
        SnakeNLadder s=new SnakeNLadder();
        s.startGame();
    }
}