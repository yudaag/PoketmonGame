package Place;

import java.util.ArrayList;

import Poketmon.Poketmon;

public class Forest extends Place {
    private static Forest instance;

    private Forest(){
    	where = "비밀의 숲";
    	poketmons = new ArrayList<Poketmon>(); //Poketmon 타입 ArrayList 생성
    }

    public static Forest getInstance(){
    	if(instance == null) //아직 객체가 생성되지 않았을 때  
    		instance = new Forest(); 
        return instance;
    }
}
