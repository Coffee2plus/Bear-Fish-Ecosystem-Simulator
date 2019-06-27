import java.util.Scanner;

public class RiverSimulator{

   public static void main(String[] args){
   
   Scanner scan = new Scanner(System.in);
   int key = 1;
   int userIn=0;
   
   System.out.println("Welcome to the River Ecosystem Simulator!");
   
   int riverLength;
   int riverCycles;
   
   while(true){
    userIn = 0;
   System.out.println("Please choose: 1(for random river) or 2 (to exit the simulator)");
   userIn=scan.nextInt();
     
      if(userIn==1){//Executes the river program.
      System.out.println("Creating a randomized river!");
         while (true){
					System.out.println("Enter the river length (an integer bigger than 0)");
					riverLength = scan.nextInt();
					
					if (riverLength <= 0){
						System.out.println("Invalid input. Please try again.");
						continue;
					}
					break;
				}
				
				while (true){
					System.out.println("Enter the number of cycles (an integer bigger than 0)");
					riverCycles = scan.nextInt();
					
					if (riverCycles <= 0){
						System.out.println("Invalid input. Please try again.");
						continue;
					}
					break;      
               }
             River river = new River(riverLength);//Creates river.
				for (int i = 0; i < riverLength; i++){//Adds animal objects.
               //int aniRandomNum = rand.nextInt();
					river.addRandom(new Fish());
             //1  System.out.println(i +"Added to river");
				}
				
				System.out.println("Initial river:");
            System.out.println("Length:"+riverLength);
            System.out.println("Cycles:"+riverCycles);
				System.out.println(river.toString());
				System.out.println();
				
				for (int i = 0; i < riverCycles; i++){//Runs the river simulation.
					System.out.println("After cycle " + (i+1));
					river.updateRiver(); 
					System.out.println(river.toString());
					
				}
           
         }
            
      if(userIn==2){//Exits the RiverSimulator.
      System.out.println("Thank you for using the simulator. Goodbye!");
      System.exit(0);
      }
      
      if(userIn!=1&&userIn!=2){//If invalid input for userIn is entered.
      System.out.println("Sorry, this input is invalid at this time. Please try again.");
      }
      }//end of while loop


   }
   
   
   
   }
