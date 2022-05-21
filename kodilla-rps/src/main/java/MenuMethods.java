import java.util.Scanner;

public class MenuMethods {
    String initialNumberOfRounds;
    int numberOfRounds=0;
   private Scanner scanner=new Scanner(System.in);
    private  String name;
    private String navigator;
    public void printControls(){
        System.out.println("base control of the game:");
        System.out.println("press 1 to play rock");
        System.out.println("press 2 to play paper");
        System.out.println("press 3 to play scissors");
        System.out.println("press x to end the game");
        System.out.println("press n to restart");
    }

    public int baseGameInput() throws InterruptedException {
        System.out.println("Input number of rounds you want to play");

        boolean controller=true;

        while (controller){
            initialNumberOfRounds=scanner.nextLine();
            if(initialNumberOfRounds.isEmpty()){
                initialNumberOfRounds="wrongInput";
            }
            try{
                numberOfRounds=Integer.parseInt(initialNumberOfRounds);
                controller=false;
            }catch (NumberFormatException e){
                System.out.println("Wrong format or no input. Please try again");
            }
        }

        if (numberOfRounds==0){
            System.out.println("You pulled a sneaky on me. Goodbye then!");
            Thread.sleep(3000);
            System.exit(0);
        }

        return numberOfRounds;
    }


    public  void NameSetting(){
        System.out.println("Input Your Name:");
        name=scanner.nextLine();
        if (name.isEmpty())
        {
            System.out.println("if you dont want to be named, form now on you are knows as BigNoseMan");
            name="BigNoseMan";
        }
    }

    public void quitPopUp(){
        System.out.println("Are you sure you want to quit? y/n");
        navigator=scanner.nextLine();
        if (navigator.equals("y")){
            System.out.println("bye bye");
            System.exit(0);
        }else if(navigator.equals("n")){
            System.out.println("ok, then continue playing");
        } else {
            System.out.println("Pressing random buttons are you? From now on you gonna be called BigHeadMan");
            name="BigHeadMan";
        }
    }

    public boolean restartPopUp(){
        System.out.println("Are you sure you want to restart? y/n");
        navigator=scanner.nextLine();
        if (navigator.equals("y")){
            System.out.println("here we go again!");
          return true;
        }else if(navigator.equals("n")){
            System.out.println("ok, then continue the round");
            return false;
        } else {
            System.out.println("Whatever.....FatFingerMan");
            name="FatFingerMan";
            return false;
        }
    }

    public String getName() {
        return name;
    }
}
