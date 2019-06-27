import java.util.*;

public abstract class Animal{



protected enum Gender{
   FEMALE, MALE
}
protected Gender gender;
protected int age;
protected int genAge;

   public Animal(){
      Random rand = new Random();
         genAge=rand.nextInt(2);
         if(this instanceof Bear){
            age=rand.nextInt(10);
               }
         else if(this instanceof Fish){
            age=rand.nextInt(4);
            }
               if(genAge==0){
               gender=gender.MALE;
               } 
               else if(genAge==1){
               gender=gender.FEMALE;
               }
       }
       
    public Animal(int aniAge, int gen){
      age=aniAge;
      if(gen==0){
      gender=gender.FEMALE;
      }
      else if(gen>=1){
      gender=gender.MALE;
      }
    }
    
    abstract boolean maxAge();
    abstract boolean incrAge();
    
    
  /*public String toString() {
		
		String str = "";
			if (this instanceof Fish){
            if(gender==gender.FEMALE){
				   str += "F" + "F" + age;
               }
            else if(gender==gender.MALE){
				   str += "F" + "M" + age;
               }
			}
			if (this instanceof Bear){
            if(gender==gender.FEMALE){
				   str += "B" + "F" + age;
               }
            else if(gender==gender.MALE){
				   str += "B" + "M" + age;
               }


		}
		return str;
	}*/

}

