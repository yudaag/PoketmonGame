package Weapon;

public class 삼지창 extends Weapon {

    public 삼지창(String name, int power){
    	this.name = name;
    	setPower(power);
    }

	@Override
	public void attack() {
		// TODO Auto-generated method stub
		System.out.println("삼지창 휘두르기!!!");
	}

	

}
