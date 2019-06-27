public class Fish extends Animal{

protected int strength;

   public Fish(){
   super();
   }
   
   public Fish(int aniAge, int gen){
   super(aniAge,gen);
   }

   public boolean maxAge(){
      if(age>=4){
         return true;
         }
      else if(age<4){
         return false;
         }
     
     return false;
   }
   
   public boolean incrAge(){
      age++;
         
     if(maxAge()==true){
      return false;
      }
      return true;
   }
   
   @Override
	public String toString(){
		String g = "";
		if(gender == gender.MALE){
			g = "M";
		}
		if(gender == gender.FEMALE){
			g = "F";
		}
		return g + age;
	}




}//end of program.