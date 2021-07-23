package Weapon;

public abstract class Weapon implements myInterface.Attackable {
    public String name;
    private int power;

    public int getPower(){
        return power;
    }

    public void setPower(int power){
    	this.power = power;
    }

}
