package chp8;

interface Performer{
	void perform();
}

class Singer implements Performer{

	public void perform() {
		System.out.println("Singer sing a song");
	}
	
}

class Dancer implements Performer{

	public void perform() {
		System.out.println("Dancer have a dance");
	}
	
}

class Player implements Performer{

	public void perform() {
		System.out.println("Player play music");
	}
	
}

class Program {
	private Performer[] ps;
	public Program(){
		ps = new Performer[3];
		ps[0] = new Singer();
		ps[1] = new Dancer();
		ps[2] = new Player();
	}
	
	public void show(){
		for(int i = 0; i<ps.length; i++){
			ps[i].perform();
		}
	}
}


public class TestProgram {

	public static void main(String[] args) {
		Program p = new Program();
		p.show();
	}

}
