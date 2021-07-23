package Weapon;

public class 쌍검 extends Weapon {

    public 쌍검(String name, int power){
    	this.name = name;
    	setPower(power);
    }

	@Override
	public void attack() {
		// TODO Auto-generated method stub
		System.out.println("쌍검 휘두르기!!!");
	}
}
