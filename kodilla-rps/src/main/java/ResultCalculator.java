
public class ResultCalculator {

  private static final ListOfMoves baseGame=new ListOfMoves();
    WinLoseDrawForMoves.move [] arrayOfMoves=WinLoseDrawForMoves.move.values();

  public int calculateResult(int indexOfPlayerMove, int indexOfAIMove){


      WinLoseDrawForMoves.move moveByAI=arrayOfMoves[indexOfAIMove];
      WinLoseDrawForMoves.move moveByPlayer=arrayOfMoves[indexOfPlayerMove];

      if(indexOfPlayerMove == indexOfAIMove){
          System.out.println("Both player and AI played "+ moveByPlayer +", so its a draw and no one gets a point");
          return 0;
      }


      if ( ListOfMoves.getPossibleMoves().get(indexOfPlayerMove).getLoseAgainst().contains(moveByAI)){
          System.out.println("AI played "+moveByAI+", and player played "+ moveByPlayer +". The AI gets a point");
          return -1;
      }
      System.out.println("AI played "+moveByAI+", and player played "+ moveByPlayer +". The player gets a point");
    return 1;
  }
}
