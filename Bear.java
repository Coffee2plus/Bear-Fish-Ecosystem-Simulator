public class Bear extends Animal{

protected int strength;

   public Bear(){
   super();
   }
   
   public Bear(int aniAge, int gen){
   super(aniAge,gen);
   }

   public boolean maxAge(){
      if(age>=10){
         return true;
         }
      else if(age<10){
         return false;
         }
         
         return false;
   }
   
   public boolean incrAge(){
      if(age<10){
         age= age+1;
         return true;
         }
      else if(age>=10){
      return false;
      }
      
      return false;
   }
   
   public int getStrength(){
		
		int[] bearAge = {0,1,2,3,4,5,6,7,8,9};
		int[] bearStrength = {1,2,3,4,5,4,3,2,1,0};
		
		for (int i = 0; i < 10; i++){
			if (bearAge[i] == age){
				strength = bearStrength[i];
			}
		}
		return strength;
	}
   @Override
	public String toString(){
		String g = "";
		if(gender == gender.MALE){
			g ="M";
		}	
		if(gender == gender.FEMALE){
			g = "F";
		}
		return g + age;
	}

}