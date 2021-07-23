package Player;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import Item.Item;
import Place.Poketball;
import Poketmon.Poketmon;
import Weapon.Weapon;

public class Player {
    public String name;
    public Place.Poketball myPoket;
    public List<Item> items;

    public Player(String name){
    	this.name = name;
    	myPoket = Poketball.getInstance(); //싱글톤 적용
    	items = new ArrayList<Item>(); //Item 타입 ArrayList 생성 
    	
    	/*생성 확인 알림*/
    	System.out.println("[알림] " + name + " 플레이어가 생성되었습니다.");
    }

    public Player(){
    	System.out.println("[알림] 플레이어의 이름을 설정해주세요.");
    }

    
    public void showPoket() { //플레이어의 포켓볼에 있는 포켓몬들 보여주는 메서드 
    	System.out.println("*" + name + "님의 포켓볼 속 포켓몬들*");
    	
    	//iterator() 사용해 리스트의 값들 조회하기 
    	Iterator<Poketmon> e = myPoket.poketmons.iterator();
    	while(e.hasNext()) {
    		System.out.print(e.next().name + " | ");
    	}
    	
    	System.out.println();
    	
    }
    
    public void showItem() { //플레이어가 사용할 수 있는 아이템들 보여주는 메서드 
    	System.out.println("*" + name + "님의 아이템들*");
    	
    	//iterator() 사용해 리스트의 값들 조회하기 
    	Iterator<Item> e = items.iterator();
    	while(e.hasNext()) {
    		System.out.print(e.next().name + " | ");
    	}
    	
    	System.out.println();
    }
}
