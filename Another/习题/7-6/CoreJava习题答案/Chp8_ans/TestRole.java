package chp8;

import java.util.Date;

interface Role{
	int attack();
	void practise();
}

interface MagicStick{
	int fire();
}

class GreenStick implements MagicStick{
	public int fire(){
		Date d = new Date();
		if (d.getMonth() >=6 && d.getMonth() <= 8){
			return 2;
		}else return 1;
	}
}

class BlackStick implements MagicStick{
	public int fire(){
		Date d = new Date();
		if (d.getMonth() % 2 == 0){
			return 2;
		}else return 1;
	}
}

interface Weapon{
	int fire();
	void setSoldier(Soldier s);
}

class Bolo implements Weapon{
	private Soldier s;
	public void setSoldier(Soldier s){
		this.s = s;
	}
	public int fire(){
		if (s.getAge()>=18) return 100;
		else return 50;
	}
}

class Pike implements Weapon{
	private Soldier s;
	private String name;
	public Pike(){}
	public Pike(String name){this.name = name;}
	
	public int fire() {
		if (s.getName().equals(name)){
			return 1000;
		}else {
			return 25;
		}
	}
	public void setSoldier(Soldier s) {
		this.s = s;
	}
	
}

abstract class NamedRole implements Role{
	private String name;
	private int age;
	
	public NamedRole(){}
	
	public NamedRole(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

class Magicer extends NamedRole{
	private int level = 1;
	private MagicStick stick;
	public Magicer(){}
	
	public Magicer(String name, int age,  int level) {
		super(name, age);
		if (level > 10 || level < 1){
			System.out.println("level error!");
			return;
		}
		this.level = level;
	}
	
	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		if (level<1 || level > 10){
			System.out.println("level error!");
			return;
		}
		this.level = level;
	}

	public MagicStick getStick() {
		return stick;
	}

	public void setStick(MagicStick stick) {
		this.stick = stick;
	}

	public int attack(){
		return level * 5;
	}

	public void practise() {
		level ++;
		if (stick != null){
			level += stick.fire();
		}
	}
}

class Soldier extends NamedRole{
	private int hurt;
	private Weapon weapon;
	
	public Soldier(){}
	
	public Soldier(String name,int age,  int hurt) {
		super(name, age);
		this.hurt = hurt;
	}

	public Weapon getWeapon() {
		return weapon;
	}

	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}

	public int getHurt() {
		return hurt;
	}

	public void setHurt(int hurt) {
		this.hurt = hurt;
	}
	
	public int attack(){
		int result = hurt;
		if (weapon != null){
			result += weapon.fire();
		}
		return result;
	}

	public void practise() {
		hurt += 10;
	}
}


public class TestRole {
	public static void main(String[] args) {
		MagicStick ms1 = new GreenStick();
		MagicStick ms2 = new BlackStick();
		Magicer m1 = new Magicer("John", 20, 5);
		Magicer m2 = new Magicer("Tom", 30, 8);
		m1.setStick(ms1);
		m2.setStick(ms2);
		
		System.out.println(m1.attack());
		System.out.println(m2.attack());
		
		m1.practise();
		m2.practise();
		
		System.out.println(m1.attack());
		System.out.println(m2.attack());
		
		
		Weapon w1 = new Bolo();
		Weapon w2 = new Pike("Jerry");
		Soldier s1 = new Soldier("Tom", 19, 100);
		Soldier s2 = new Soldier("Jerry", 25, 150);

		//注意，既要调用Soldier的setWeapon方法，也要调用Weapon的setSoldier方法
		s1.setWeapon(w1);
		w1.setSoldier(s1);
		
		s2.setWeapon(w2);
		w2.setSoldier(s2);
		
		System.out.println(s1.attack());
		System.out.println(s2.attack());
		
		s1.practise();
		s2.practise();
		
		System.out.println(s1.attack());
		System.out.println(s2.attack());
	}
}
