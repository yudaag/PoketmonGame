package Place;

import java.util.ArrayList;
import java.util.List;

import Poketmon.Poketmon;

public abstract class Place {
    public String where;
    public List<Poketmon> poketmons;
    public int numOfPoketmons;

    public void createPoketmon(Poketmon pm) {
    	poketmons.add(pm);
    	numOfPoketmons++; 
    }; //장소에 포켓몬 생성하는 메서드
    
    public void removePoketmon(int index) { //배열의 특정 인덱스의 포켓몬 삭제 -> 삭제 후 빈 곳 없음 
    	poketmons.remove(index);
    	numOfPoketmons--; 
    }
    
}
