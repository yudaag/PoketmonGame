package Weapon;

public class 대포 extends Weapon {

    public 대포(String name, int power){
    	this.name = name;
    	setPower(power);
    }

	@Override
	public void attack() {
		// TODO Auto-generated method stub
		System.out.println("대포 발사!!!");
	}

}
