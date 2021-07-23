package Place;

import java.util.ArrayList;

import Poketmon.Poketmon;

public class Ocean extends Place {
    private static Ocean instance;

    private Ocean(){
    	where = "깊은 바다 속";
    	poketmons = new ArrayList<Poketmon>(); //Poketmon 타입 ArrayList 생성 
    }

    public static Ocean getInstance(){
    	if(instance == null) //아직 객체가 생성되지 않았을 때  
    		instance = new Ocean(); 
        return instance;
    }
}
