package Poketmon;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import Item.Item;
import Weapon.Weapon;

public abstract class Poketmon implements myInterface.Attackable {
    public String name;
    private int hp; 
    private int power;
    public List<Weapon> weapons;

    public int gethp(){
        return hp;
    }

    public void sethp(int hp){
    	this.hp = hp;
    }

    public int getPower(){
        return power;
    }

    public void setPower(int power){
    	this.power = power;
    }

    public void powerUp(){ //공격력 증대
    	power += 2;
    }
    
    public void getWeapon(Weapon w) { //무기 획득 메서드 
    	weapons.add(w);
    }
    
    public void introduce() { //포켓몬의 name, hp, power 소개 
    	System.out.println("----------------------");
    	System.out.println("name : " + name);
    	System.out.println("hp : " + hp);
    	System.out.println("power : " + power);
    	System.out.println("----------------------");
    }
    
    public void showWeapon() { //포켓몬이 보유한 무기 보여주는 메서드 
    	System.out.println("*사용 가능한 무기*");
    	
    	//Iterator() 사용해 리스트의 값들 조회하기 
    	Iterator<Weapon> e = weapons.iterator();
    	while(e.hasNext()) {
    		System.out.println(e.next().name + " | ");
    	}
    	
    }
    
    public void show() {
    	System.out.println(name + "의 hp : " + hp);
    }
    
    public void attackbyPoketmon(Poketmon target, int attackPower) {
    	int targetHp = target.gethp(); //상대 포켓몬의 hp
    	int power = (int)Math.random()*5 + 1 + attackPower; //자신의 공격량 = 자신의 power + 랜덤값 
    	target.sethp(targetHp-power); 
    }
    
}
