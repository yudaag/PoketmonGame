package Place;

import java.util.ArrayList;

import Poketmon.Poketmon;

public class Poketball extends Place {
    private static Poketball instance;

    private Poketball(){
    	where = "포켓볼";
    	poketmons = new ArrayList<Poketmon>(); //Poketmon 타입 ArrayList 생성  
    }

    public static Poketball getInstance(){
    	if(instance == null) //아직 객체가 생성되지 않았을 때  
    		instance = new Poketball(); 
        return instance;
    }
}
