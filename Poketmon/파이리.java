package Poketmon;

import java.util.ArrayList;

import Weapon.Weapon;

public class 파이리 extends Poketmon {

    public 파이리(int power, int hp, String name){
    	sethp(hp);
    	setPower(power);
    	this.name = name;
    	weapons = new ArrayList<Weapon>(); //Weapon 타입 ArrayList 생성
    	
    	/*생성 확인*/
    	System.out.println("[알림] "+ name + "이 생성되었습니다.");
    }

	@Override
	public void attack() {
		// TODO Auto-generated method stub
		System.out.println("파이리 불꽃!!!");
	}

    
	
	

}
