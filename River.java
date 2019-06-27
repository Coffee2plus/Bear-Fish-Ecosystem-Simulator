import java.util.*;

public class River{

   public Animal[] river;	
   
   private int length;
   Random rand = new Random();//For generating random numbers.
   
   public River (int methodlength) {
		this.length = methodlength;
		river = new Animal[length];
	}

   public int getLength() {
		return length;
	}
   
   public int numEmpty() {
		int numEmpty = 0;
		for (int i = 0; i < length; i++) {	
			if (river[i] == null)
				numEmpty++;
		}
		return numEmpty;
	}

  /*public boolean addRandom(Animal animal) {
		int aniNum= rand.nextInt(3);//Determines a number to be used to decide how to fill the array.
      if (numEmpty() == 0){
			//System.out.println("Whoops! The river seems to be a bit too full for a new fella.");
         return false;
         }
     else{
         for (int i = 0; i < length; i++){
           System.out.println(aniNum);
            
					if (aniNum == 0){
						river[i] = new Bear();
                  return true;
                  }
					else if (aniNum == 1){
                  river[i] = null;
                  return true;
                  }
					else if (aniNum==2){
						river[i] = new Fish();
                  return true;
                  }
               }		
			return true;
				}
         
         } */
         
         // Initialize array with random animals 
	public boolean addRandom(Animal animal) {
		if (numEmpty() == 0)
			return false;	
			
		else {		
			//Generate random integer to decide null, bear, or fish
			int k = (int)(Math.random() * 3);
				// if k = 0, insert null
				// if k = 1, insert bear
				// if k = 2, insert fish
			
			for (int i = 0; i < length; i++){
				if(river[i] == null){
					if (k == 0)
						river[i] = new Fish();
					else if (k == 1)
						river[i] = new Bear();
					else if (k==2)
						river[i] = null;		
					return true;
				}
				
			} 
			return true;
		}
	}

         
         public void updateCell(int i){
         
         int randNum=rand.nextInt(3);//Random number for determining movement.
         int randGenNum=rand.nextInt(2);//Random number for determining baby gender if a baby is had.
         boolean newAnimal = false;
         //NOTE: int j is just in case i-1 or i+1 passes below zero or exceeds length, respectively. This is to avoid errors.
         
         if(river[i]== null){//If null, nothing.
            return;
         }
         
         //else if(river[i].maxAge() == true){//If animal is at max age, it dies, resulting in its spot being replaced with null.
         //   river[i]=null;
         //   }
         
         else if(river[i] instanceof Bear){//In case of a base.            
         
            
            if(randNum==0){
               //nothing happens
               }
            else if(randNum==1){//The bear will move left, however:
            int j = i-1;
            
               if(j<0){
                  j=length-1;
                  }
               if(!(river[j]instanceof Bear&&river[j]instanceof Fish)){//Bear will move left unimpeded.
                  river[j]=river[i];
                  river[i]=null;
                  }
               else if(river[i-1]instanceof Fish){//Bear kills fish and moves to its spot.
                  river[j]=null;
                  river[j]=river[i];
                  }
               else if(river[i-1]instanceof Bear){//The bears will engage in one of two activities
                  if(river[i].gender==river[j].gender){//If they're the same gender, they will fight to the death.
                     if(((Bear)river[i]).getStrength()<(((Bear)river[j]).getStrength())){
                        river[i]=null;//Moving bear dies and position becomes in array becomes null.
                        }
                     else if(((Bear)river[i]).getStrength()>(((Bear)river[j]).getStrength())){
                        river[j]= river[i];
                        river[i]=null;
                        }
                     else if(((Bear)river[i]).getStrength()==(((Bear)river[j]).getStrength())){
                        //Nothing happens.
                        }
                     }
                   if(river[i].gender!=river[j].gender){
                     if(numEmpty()!=0){
                     
                     while(newAnimal = false){
                           if(!(river[i] instanceof Bear&&river[i]instanceof Fish)){
                              if(randGenNum==0){
                                  river[i]=new Bear(0,0);
                                        } 
                              else if(randGenNum==1){
                                    river[i]=new Bear(0,1);
                                       }
                              newAnimal=true;
                                    }
                           }
                           }
                        }
               
                     }
            
                  }
         else if(randNum==2){//The bear will move right, however:
               int j = i+1;
            
               if(j>=length){
                  j=0;
                  }
               if(!(river[j]instanceof Bear&&river[j]instanceof Fish)){//Bear will move right unimpeded.
                  river[j]=river[i];
                  river[i]=null;
                  }
               else if(river[j]instanceof Fish){//Bear kills fish and moves to its spot.
                  river[j]=null;
                  river[j]=river[i];
                  }
               else if(river[j]instanceof Bear){//The bears will engage in one of two activities
                  if(river[i].gender==river[j].gender){//If they're the same gender, they will fight to the death.
                     if(((Bear)river[i]).getStrength()<(((Bear)river[j]).getStrength())){
                        river[i]=null;//Moving bear dies and position becomes in array becomes null.
                        }
                     else if(((Bear)river[i]).getStrength()>(((Bear)river[j]).getStrength())){
                        river[j]= river[i];
                        }
                     else if(((Bear)river[i]).getStrength()==(((Bear)river[j]).getStrength())){
                        //Nothing happens.
                        }
                     }
                   if(river[i].gender!=river[j].gender){
                     if(numEmpty()!=0){
                     
                     while(newAnimal = false){
                           if(!(river[i] instanceof Bear&&river[i]instanceof Fish)){
                              if(randGenNum==0){
                                  river[i]=new Bear(0,0);
                                        } 
                              else if(randGenNum==1){
                                    river[i]=new Bear(0,1);
                                       }
                              newAnimal=true;
                                    }
                           }
                           }
                        }
               
                     }
            
                  }
         
         
               }
         
         else if(river[i] instanceof Fish){//In case of a Fish.            
         
            
            if(randNum==0){
               //nothing happens
               }
            else if(randNum==1){//The Fish will move left, however:
            int j = i-1;
            
               if(j<0){
                  j=length-1;
                  }
               if(!(river[j]instanceof Bear&&river[j]instanceof Fish)){//Fish will move left unimpeded.
                  river[j]=river[i];
                  river[i]=null;
                  }
               else if(river[i-1]instanceof Bear){//Bear kills fish and stays in its spot.
                  river[i]=null;
                  
                  }
               else if(river[j]instanceof Fish){//The Fish will engage in one or no activities
                  if(river[i].gender==river[j].gender){//If they're the same gender, nothing happens.
                     //Whoa, nothing.
                     }
                   if(river[i].gender!=river[j].gender){
                     if(numEmpty()!=0){
                     
                     while(newAnimal = false){
                           if(!(river[i] instanceof Bear&&river[i]instanceof Fish)){
                              if(randGenNum==0){
                                  river[i]=new Fish(0,0);
                                        } 
                              else if(randGenNum==1){
                                    river[i]=new Fish(0,1);
                                       }
                              newAnimal=true;
                                    }
                           }
                           }
                        }
               
                     }
            
                  }
         else if(randNum==2){//The Fish will move right, however:
         int j = i+1;
            
               if(j>=length){
                  j=0;
                  }
               if(!(river[j]instanceof Bear&&river[j]instanceof Fish)){//Fish will move right unimpeded.
                  river[j]=river[i];
                  river[i]=null;
                  }
               else if(river[i+1]instanceof Bear){//Bear kills fish and stays in its spot.
                  river[i]=null;
                  }
               else if(river[j]instanceof Fish){//The Fish will engage in one or no activities
                    if(river[i].gender!=river[j].gender){
                     if(numEmpty()!=0){
                     
                     while(newAnimal = false){
                           if(!(river[i] instanceof Bear&&river[i]instanceof Fish)){
                              if(randGenNum==0){
                                  river[i]=new Fish(0,0);
                                        } 
                              else if(randGenNum==1){
                                    river[i]=new Fish(0,1);
                                       }
                              newAnimal=true;
                                    }
                           }
                           }
                        }
               
                     }
            
                  }
         
         
               }
         
         
         
         
         
  }
  
  public void updateRiver(){
  
   for(int i=0;i<length;i++){
   updateCell(i);
      }
  for (int j = 0; j < length; j++){
			if (river[j] != null){
				if (river[j].incrAge() == false){
					river[j] = null;
				}
			}
		}	

   
  }  
  	
	public String toString() {
		
		String str = "";
				
		for (int i = 0; i < length; i++){
			if (river[i] == null){
				str += "--- " ;
				continue;
			}
			else if (river[i] instanceof Fish){
				str += "F" + river[i].toString() + " ";
			}
			else if (river[i] instanceof Bear){
				str += "B" + river[i].toString() + " ";
			}

		}
		return str;
	}
      
}
    
