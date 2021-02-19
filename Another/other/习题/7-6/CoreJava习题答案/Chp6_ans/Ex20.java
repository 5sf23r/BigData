package chp6;

class Role{
	private String name;
	//构造方法
	public Role(){}
	
	public Role(String name) {
		this.name = name;
	}
	
	// set/get方法
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	//业务方法
	public int attack(){
		return 0;
	}
}

class Magicer extends Role{
	private int level = 1;
	
	public Magicer(){}
	
	public Magicer(String name, int level) {
		super(name);
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

	public int attack(){
		return level * 5;
	}
}

class Soldier extends Role{
	private int hurt;
	
	public Soldier(){}
	
	public Soldier(String name, int hurt) {
		super(name);
		this.hurt = hurt;
	}

	public int getHurt() {
		return hurt;
	}

	public void setHurt(int hurt) {
		this.hurt = hurt;
	}
	
	public int attack(){
		return hurt;
	}
}


class Team{
	private Role[] teams = new Role[6];
	//需要利用index来表示组队中现有多少个成员
	private int index = 0;
	public Team(){}

	public void addMember(Role role){
		if (index == 6){ //如果已有6个成员
			System.out.println("组队已满！");
			return;
		}
		//如果成员未满六个，则新成员的下标正好是index
		//例如，原有2个成员，index为2，这两个成员的下标为0、1
		//则新成员位置为teams[2]即teams[index]
		teams[index] = role;
		index++;
	}
	public int attackSum(){
		int sum = 0;
		for(int i = 0; i<index; i++){
			sum += teams[i].attack();
		}
		return sum;
	}
}

public class Ex20 {
	public static void main(String[] args) {
		Magicer m1 = new Magicer("tom", 5);
		Magicer m2 = new Magicer("jerry", 10);
		Soldier s1 = new Soldier("john", 20);
		Soldier s2 = new Soldier("jim", 40);
		Team team = new Team();
		team.addMember(m1);
		team.addMember(m2);
		team.addMember(s1);
		team.addMember(s2);
		int totalAttack = team.attackSum();
		System.out.println("总攻击伤害为" + totalAttack);
	}
}
