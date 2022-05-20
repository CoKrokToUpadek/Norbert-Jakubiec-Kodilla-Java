import java.util.*;

public class RpsRunner {
    public static void main(String[] args) throws InterruptedException {

        //rock-0
        //paper-1
        //scissors-2

        ResultCalculator resultCalculator=new ResultCalculator();

        MenuMethods menuMethods=new MenuMethods();
        String name;
        int playerScore=0;
        int AIScore=0;
        boolean end=false;

        int resultController=0;
        int numberOfRounds;
        int currentRound=1;
        String playerActionInString;
        Scanner scanner=new Scanner(System.in);
        Random random=new Random();


        menuMethods.NameSetting();
        name=menuMethods.getName();
        numberOfRounds= menuMethods.baseGameInput();
        menuMethods.printControls();
        System.out.println("Ok mister "+name+", input your first action");


        while (true){

          playerActionInString = scanner.nextLine();
          if (!playerActionInString.matches("1|2|3|n|x")){
              System.out.println("Read the instructions carefully please. As a nice program I will repeat them for you.");
              menuMethods.printControls();
          }else if(playerActionInString.equals("x")){
              menuMethods.quitPopUp();
              name=menuMethods.getName();
          }else if(playerActionInString.equals("n")){
              if (menuMethods.restartPopUp()){
                  System.out.println("Ok so im clearing the scores. Also you will be asked to enter number of rounds again");
                  playerScore=0;
                  AIScore=0;
                  numberOfRounds= menuMethods.baseGameInput();
                  System.out.println("Ok mister "+name+", input your first action");

              }
              name=menuMethods.getName();
          }else {
              int playerMove=Integer.parseInt(playerActionInString);

              resultController=resultCalculator.calculateResult(playerMove-1,random.nextInt(2));
              if (resultController==1){
                  playerScore++;
              }else if (resultController==-1){
                  AIScore++;
              }
              System.out.println("We got to the end of the "+currentRound+" round. Current Score:");
              System.out.println(name+" have "+playerScore+" points");
              System.out.println("AI have "+AIScore+" points");
              if (numberOfRounds==currentRound){
                  System.out.println("End of the game. End of the game result:");
                  System.out.println(name+" have "+playerScore+" points");
                  System.out.println("AI have "+AIScore+" points");
                  if (AIScore>playerScore){
                      System.out.println("AI won");
                  } else if(AIScore<playerScore){
                      System.out.println("Player won");
                  }else{
                      System.out.println("its a draw");
                  }

                  currentRound=1;
                  playerScore=0;
                  AIScore=0;
                  end=false;

                  System.out.println("You can now press x to exit or n to start new game");
                  while (!end) {
                      playerActionInString = scanner.nextLine();
                      if (!playerActionInString.matches("|n|x")) {
                        System.out.println("and the pressing of random buttons continue...RandomButtonsGuy");
                        name="RandomButtonsGuy";
                    } else if (playerActionInString.equals("x")) {
                        menuMethods.quitPopUp();
                        name = menuMethods.getName();
                    } else if (playerActionInString.equals("n")) {
                        if (menuMethods.restartPopUp()) {
                            playerScore = 0;
                            AIScore = 0;
                            numberOfRounds = menuMethods.baseGameInput();
                            System.out.println("Ok mister " + name + ", input your first action");
                        end=true;
                        }
                        name = menuMethods.getName();
                    }
                }


              }else {
                  currentRound++;
              }

          }
        }
    }
}
