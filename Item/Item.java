package Item;

public abstract class Item {
    public String name;
    private int power;

    public void 설명() {
    	System.out.printf("아이템 이름 : %s 공격력 : %d\n", name, power);
    };

    public int getPower(){
        return power;
    }

    public void setPower(int power){
    	this.power = power;
    }
    
}
