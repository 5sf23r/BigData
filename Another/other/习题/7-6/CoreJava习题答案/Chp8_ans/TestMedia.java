package chp8;

interface MediaPlayer{
	void play();
	void stop();
	void open();
}

class DVDPlayer implements MediaPlayer{

	public void open() {
		System.out.println("DVDPlayer Open");
	}

	public void play() {
		System.out.println("DVD play");
	}

	public void stop() {
		System.out.println("DVD stop");
	}
	
}

class CDPlayer implements MediaPlayer{

	public void open() {
		System.out.println("CDPlayer Open");
	}

	public void play() {
		System.out.println("CD play");
	}

	public void stop() {
		System.out.println("CD stop");
	}
	
}

class TapePlayer implements MediaPlayer{

	public void open() {
		System.out.println("Tape Open");
	}

	public void play() {
		System.out.println("Tape play");
	}

	public void stop() {
		System.out.println("Tape stop");
	}
	
}

class Controller{
	private MediaPlayer[] players;
	public Controller(){
		players = new MediaPlayer[3];
		players[0] = new DVDPlayer();
		players[1] = new CDPlayer();
		players[2] = new TapePlayer();
	}
	
	public void play(int i){
		this.players[i].play();
	}
	
	public void stop(int i){
		this.players[i].stop();
	}
	public void open(int i){
		this.players[i].open();
	}
}
