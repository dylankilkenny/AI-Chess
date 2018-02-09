import java.util.*;

public class AIAgent{
  Random rand;

  public AIAgent(){
    rand = new Random();
  }

/*
  The method randomMove takes as input a stack of potential moves that the AI agent
  can make. The agent uses a rondom number generator to randomly select a move from
  the inputted Stack and returns this to the calling agent.
*/

  public Move randomMove(Stack possibilities){

    int moveID = rand.nextInt(possibilities.size());
    System.out.println("Agent randomly selected move : "+moveID);
    for(int i=1;i < (possibilities.size()-(moveID));i++){
      possibilities.pop();
    }
    Move selectedMove = (Move)possibilities.pop();
    return selectedMove;
  }

  public Move SelectedStrategy(int strategy, Stack whiteMoves, Stack blackMoves){
    Move move = new Move();
    if(strategy == 0){
      move = randomMove(whiteMoves);
      return move;
    }
    else if(strategy == 1){
      move = nextBestMove(whiteMoves, blackMoves);
      return move;
    }
    else{
      return move;
    }
  }

  public Move nextBestMove(Stack possibilities, Stack possibilitiesBlack){

    int points = 0;
    Move selectedMove= null;
    Stack random = (Stack) possibilities.clone();
    

    while(possibilities.size() > 0){

      Move move = (Move) possibilities.pop();

      if(!(possibilities.size()==1)){

        if(points < move.getScore()){
          points = move.getScore();
          selectedMove = move;
        }
      } 
      
      if((possibilities.size()==1)&&points==0){
        selectedMove = (Move)possibilities.pop();
      }

    } 


    if (points > 0) {
      
      return selectedMove;
   
    }else {
      //If no piece can be taken, make a random move
      return randomMove(random);
    
    }
    
    

}

  public Move twoLevelsDeep(Stack possibilities){
    Move selectedMove = new Move();
    return selectedMove;
  }
}
