package Game;

import Player.Player;
import Item.*;
import Place.*;
import Poketmon.*;
import Weapon.*;
import myWindow.MyView;

import java.util.InputMismatchException;
import java.util.Scanner;

import Exception.IllegalNumException; //사용자 정의 예외 
import Exception.ZeroException;

public class Main {
	static Scanner kbd = new Scanner(System.in);
	static Player player;
	static Place place;
	static int pickPoketmon; //내가 선택한 포켓몬의 리스트에서의 Index 값 -> 삭제할 때 사용하기 위해서 필요함
	
	/*
	 	1. 초기 설정 
	*/
	
	public static void startGame() { 
		System.out.println("환영합니다!\n지금부터 포켓몬 게임을 시작합니다.\n로딩중. . .");
	}
	
	public static void player() {//플레이어 생성 메서드 
		System.out.print("플레이어의 이름 : ");
		String name = kbd.next();
		player = new Player(name);
	}
	
	public static void chooseFirstPoketmon() { //플레이어의 첫번째 포켓몬 선택 메서드 
		int pick = 0;
		Poketmon pm = null;
		
		
		System.out.println("\n생성할 포켓몬을 선택하세요.");
		System.out.println("1.이상해씨\t 2.파이리\t3.피카츄");
		
		//사용자 정의 예외를 사용한 예외처리 & try-catch 구조 
		while(true) {
			try {
				pick = kbd.nextInt();
				if(pick < 1 || pick > 3) throw new IllegalNumException();
				break;
			}catch(IllegalNumException e) { //숫자 범위 초과 시 예외 처리
				System.out.println("[경고] 잘못된 번호 입력! 다시 입력하세요.");
			}
		}
		
		if(pick==1) pm = new 이상해씨(2, 30, "이상해씨다");
		else if(pick == 2) pm = new 파이리(1, 30, "파이리다");
		else pm = new 피카츄(3, 30, "피카츄다"); 
		
		player.myPoket.createPoketmon(pm); //플레이어의 포켓볼에 획득한 포켓몬 저장
		
	}
	
	public static void chooseFirstWeapon() { //첫 무기 생성 메서드 
		int pick = 0;
		Weapon w = null;
		
		System.out.println("\n생성할 무기 선택하세요.");
		System.out.println("1.대포\t2.삼지창\t3.쌍검");
	
		//사용자 정의 예외를 사용한 예외처리
		while(true) {
			try {
				pick = kbd.nextInt();
				if(pick < 1 || pick > 3) throw new IllegalNumException(); 
				break;
			}catch(IllegalNumException e) { //숫자 범위 초과 시 예외 처리
				System.out.println("[경고] 잘못된 번호 입력! 다시 입력하세요.");
			}
		}
		
		if(pick == 1) w = new 대포("왕대포", 5);
		else if(pick == 2) w = new 삼지창("삼지창", 4);
		else w = new 쌍검("쌍검", 3); 
				
		player.myPoket.poketmons.get(0).getWeapon(w); //플레이어의 포켓몬이 획득한 무기 저장
		
	}
	
	public static void choosePlace() { //대전을 펼칠 장소 선택 메서드 
		int pick = 0;
		
		System.out.println("\n이동할 장소를 선택하세요.");
		System.out.println("1.Forest\t2.Ocean");
	
		//사용자 정의 예외를 사용한 예외처리
		while(true) {
			try {
				pick = kbd.nextInt();
				if(pick < 1 || pick > 2) throw new IllegalNumException();
				break;
			}catch(IllegalNumException e) { //숫자 범위 초과 시 예외 처리
				System.out.println("[경고] 잘못된 번호 입력! 다시 입력하세요.");
			}
		}
		
		if(pick == 1) place = Forest.getInstance();
		else place = Ocean.getInstance();
		
	}
	
	public static void createPoketmonTo() { //선택한 장소에 포켓몬들 생성하기 
		Poketmon p1 = new 이상해씨(3, 30, "이상해씨 빌런");
		Poketmon p2 = new 피카츄(2, 30, "피카츄 빌런");
		
		place.createPoketmon(p1);
		place.createPoketmon(p2);
		
		System.out.println("[알림] " + place.where + "에 포켓몬이 모두 생성되었습니다!");
	}
	
	/*
		2. 게임 진행
	*/
	
	public static void manual() { //게임 진행 메뉴얼 메서드 
		int pick = 0;
		boolean checkPlace = false;
		
		//test용
		/*
		System.out.println("1.대결하기\t2.내 포켓몬 보기\t3.내 아이템 보기\t4.게임 종료");
		try {
			pick = kbd.nextInt();
			if(pick < 1 || pick > 4) throw new IllegalNumException("[경고] 잘못된 번호 입력! 다시 입력하세요.");
		}catch(IllegalNumException e) {
			e.getMessage();
		}
		
		
		
		fight();
		*/
		
		//test할 때는 아래 코드 주석!
		while(true) {
			System.out.println("\n1.대결하기\t 2.내 포켓몬 보기\t3.내 아이템 보기\t4.게임 종료");
			
			try {
				pick = kbd.nextInt();
				if(pick < 1 || pick > 4) throw new IllegalNumException();
			}catch(IllegalNumException e) { //숫자 범위 초과 시 예외 처리 
				System.out.println("[경고] 잘못된 번호 입력! 다시 입력하세요.");
				continue;
			}catch(InputMismatchException e) { //숫자 이외의 값 입력 시 예외 처리 
				kbd.nextLine();
				System.out.println("[경고] 잘못된 번호 입력! 다시 입력하세요.");
				continue;
			}
			
			if(pick == 1) fight(); //1.대결하기 
			else if(pick == 2) player.showPoket(); //2.내 포켓몬 보기 
			else if(pick == 3) player.showItem(); //3.내 아이템 보기 
			else { //4.게임종료 
				endGame();
				break;
			}
			
			if(player.myPoket.poketmons.size() == 0) { //내 포켓볼에 포켓몬이 없을 때 
				System.out.println("[알림] 대결에 나갈 포켓몬이 없습니다. 게임을 종료합니다.");
				break;
			}
			
			checkPlace = checkNumOfPoketmon(); //이렇게 안하고 그냥 size()해도 됨!(위에 처럼)
			
			if(checkPlace == true) {
				System.out.println("축하합니다! " + place.where + "에 있는 포켓몬을 모두 잡았습니다!\n게임을 종료합니다.");
				break;
			}
			
		}
		
	}
	
	public static void endGame() { 
		System.out.println("[알림] 게임을 종료합니다.");
	}
	
	public static boolean checkNumOfPoketmon() { //대결 장소에 포켓몬이 남아있는지 확인하는 메소드(포켓몬이 없다면 게임 종료)
		if(place.numOfPoketmons == 0) return true;
		else return false;
	}
	
	public static void fight() { 
		Poketmon other = null; //상대 포켓몬 
		Poketmon mine = null; //내 포켓몬 
		Weapon myWeapon = null;
		Item myItem = null;
		boolean result = false; 
		
		System.out.println("\n대결 준비 중 . . .");
		other = place.poketmons.get(0); //항상 리스트의 첫번째 객체 선택됨 
			
		System.out.println(place.where + "에 " + other.name + "가 나타났습니다!");
		other.introduce();
			
		//내 포켓몬 선택하기 
		mine = chooseMyPoketmon();
		//내 포켓몬의 무기 선택하기
		myWeapon = chooseMyWeapon(mine);
		//사용 아이템 선택하기 
		myItem = chooseMyItem();
		
		//test용  
		//startFight(other, mine, myWeapon, myItem);
		
		//test할 때는 아래 코드 주석!
		//대결 찐 시작
		result = startFight(other, mine, myWeapon, myItem);
		
		if(result) { //대결에서 이겼을 때 
			win(other);
		}
		else { //대결에서 졌을 때 
			lose(mine);
		}
	}
	
	/*
		2-1. fight() 상세 - 포켓몬 선택, 포켓몬의 무기 선택, 사용자 아이템 선택 
	*/
	public static Poketmon chooseMyPoketmon() { //대결에 나갈 내 포켓몬 선택 메서드 
		player.showPoket();
		System.out.print("포켓몬 선택(숫자로 표시) : ");
		pickPoketmon = kbd.nextInt() - 1; 
		
		return player.myPoket.poketmons.get(pickPoketmon);
	}
	
	public static Weapon chooseMyWeapon(Poketmon mine) { //대결에 사용할 포켓몬의 무기 선택 메서드 
		int pick = 0;
		
		if(mine.weapons.size() == 0) { //사용할 무기가 없을 때 
			System.out.println("사용할 무기가 없습니다.");
			return null;
		}
		else {
			mine.showWeapon();
			System.out.print("무기 선택(숫자로 표시) : ");
			pick = kbd.nextInt() - 1;
			return mine.weapons.get(pick);
		}
	}
	
	public static Item chooseMyItem() { //대결에 사용할 내 아이템 선택 메서드 
		int pick = 0;
		
		if(player.items.size() == 0) { //사용할 아이템이 없을 때  
			System.out.println("사용할 아이템이 없습니다.");
			return null;
		}
		else {
			player.showItem();;
			System.out.print("아이템 선택(숫자로 표시) : ");
			pick = kbd.nextInt() - 1;
			return player.items.get(pick);
		}
	}
	
	/*
	 	2-2. 대결 찐 시작  
	 */
	
	public static boolean startFight(Poketmon other, Poketmon mine, Weapon myWeapon, Item myItem) { 
		System.out.println("\n대결을 시작합니다!");
		
		int myAttackPower = mine.getPower(); //나의 공격치(포켓몬 power + 무기 power + item power)
		int otherPower = other.getPower();
		
		int myHp = mine.gethp();
		int otherHp = other.gethp();
		
		boolean whooseWin = false;
		
		//null 객체에 대한 예외 처리(weapon, item)  
		try {
			myAttackPower += myWeapon.getPower();
		}catch(NullPointerException e) { //무기 선택 안했을 때 
			myAttackPower += 0;
		}
		
		try {
			myAttackPower += myItem.getPower();
		}catch(NullPointerException e) { //아이템 선택 안했을 때 
			myAttackPower += 0; 
		}
		
		System.out.println("------------------------------------------------------------");
		System.out.println("내 포켓몬 공격세기 : " + myAttackPower + " | 상대방 포켓몬 공격세기 : " + otherPower);
		System.out.println("------------------------------------------------------------");
		
		
		new MyView(player, other, mine, myAttackPower, otherPower); //윈도우 창 생성 

		
		//추가) View가 끝났는지 체크하기 -> main의 thread sleep 걸어주기  
		while(true) {
			try {
				Thread.sleep(2000); //2초
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			if(MyView.end == true) {
				System.out.println("대결 종료! 윈도우가 종료됩니다.\n");
				break;
			}
			else System.out.println("대결중 . . .\n");
		}
		
		MyView.end = false; //end 값 false로 초기화 
		
		if(MyView.whooseWin) { //플레이어 승리 시 
			MyView.whooseWin = false; //whooseWin값 초기화 
			return true;
		}
		else return false; //상대방 승리 시 

	}
	
	public static void win(Poketmon other) { //대결에서 이겼을 때 -> 해당 포켓몬 획득 & 아이템 랜덤 획득 
		System.out.println("[알림] 대결에서 승리하였습니다!");
		
		//상대 포켓몬 획득 
		place.removePoketmon(0);
		player.myPoket.createPoketmon(other);
		
		//아이템 랜덤 획득 
		int pick = (int)Math.random()*3; //0,1,2
		Item item = null;
		
		if(pick == 0) item = new 반짝가루("반짝가루", 4);
		else if(pick == 1) item = new 눈덩이("눈덩이", 3); 
		else item = new 연막탄("연막탄", 2);
		
		player.items.add(item);
		
		System.out.println("대결에서 승리하여 . . . ");
		System.out.println("[포켓몬] " + other.name + "을 획득하였습니다!");
		System.out.println("[아이템] " + item.name + "을 획득하였습니다!");
	}
	
	public static void lose(Poketmon mine) { //대결에서 졌을 때 -> 대결에 나갔던 포켓몬 잃음 & 해당 대결 장소에 추가됨 
		System.out.println("[알림] 대결에서 졌습니다. . .");
		
		//대결에 나갔던 포켓몬 잃음 
		player.myPoket.removePoketmon(pickPoketmon);
		//대결 장소에 해당 포켓몬 추가 
		place.createPoketmon(mine);
		
		System.out.println(mine.name + "을 잃었습니다. . .");
	}

	public static void main(String[] args) {
		//1. 플레이어 생성
		startGame();
		player();
		//2. 플레이어의 첫 포켓몬 선택 
		chooseFirstPoketmon();
		//3. 포켓몬의 무기 선택 
		chooseFirstWeapon();
		//4. 대결 장소 선택
		choosePlace();
		//5. 선택한 장소에 포켓몬 생성
		createPoketmonTo();
		//6. 메뉴얼 시작  
		manual();

	}

}
