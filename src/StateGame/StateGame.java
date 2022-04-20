package StateGame;

import java.util.Scanner;
import java.io.*;
import java.util.Random;
import java.util.TreeMap;

public class StateGame {

    public static void main(String[] args) throws FileNotFoundException{
        File stateFile = new File("state.txt");
        Scanner in = new Scanner(stateFile);
        
        TreeMap<String,String> states = new TreeMap<>();
        
        while(in.hasNext()){
            String line = in.nextLine();
            String[] splitted = line.split(", ");
            states.put(splitted[1], splitted[0]);
        }
        
//        for(String stateName: states.keySet())
//            System.out.println("State: "+stateName+", Capital: "+states.get(stateName));
        char keepGoing = 'y';
        int highscore = 0;
        int score = 0;
        while('y' == keepGoing || 'Y' == keepGoing){
            score = game(states);
            if(score > highscore)
                highscore = score;
            Scanner userInput = new Scanner(System.in);
            System.out.println("Game Over! Score: "+score+" Highscore: "+highscore+"\n Would you like to play again(enter 'y')?");
            keepGoing = userInput.next().charAt(0);
        }
              
    }
    
    public static int game(TreeMap<String,String> states){
        int score = 0;
        int lives = 5;
        
        while(lives > 0){
            Random rand = new Random();
            String state = states.keySet().toArray()[rand.nextInt(50)].toString();
            System.out.println("What is the capital of "+state+": ");
            
            Scanner userInput = new Scanner(System.in);
            String userAnwser = userInput.nextLine();
            if(userAnwser.equalsIgnoreCase(states.get(state))){
                System.out.println("Correct!");
                score++;
            }else{
                System.out.println("Incorrect! The capital of "+state+" is "+states.get(state));
                lives--;
            }
        } 
        
        return score;
    }
    
}
