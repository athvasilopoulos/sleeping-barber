import java.awt.Button;
import java.awt.Color;
import java.awt.Font;

import gui.BarberGui;

public class Person extends Thread{
	private int id;
	private BarberGui gui;
	private WaitingRoom wroom;
	private BarberRoom broom;
	private Button personIcon;
	final Color[] colors = {Color.red,Color.yellow,Color.cyan,Color.orange,Color.pink,
			Color.blue,Color.magenta,Color.white,Color.darkGray,Color.lightGray};
	
	public Person(int id,BarberGui gui,WaitingRoom wroom,BarberRoom broom) {
		this.id = id;
		this.gui = gui;
		this.wroom = wroom;
		this.broom = broom;
		personIcon = new Button(String.valueOf(id));
	}
	
	public void run() {
		while(true) {
			outsideBarber();
			atDoor();
			enterWaiting();
			enterBarber();
		}
	}
	
	private void outsideBarber() {
		changePos(0);
		try {
			Thread.sleep((int)(Math.random() * 7000)+3000);
		}
		catch(InterruptedException e) {
			System.err.println(e.toString());
		}
	}
	
	private void atDoor() {
		changePos(1);
	}
	
	private void enterWaiting() {
		wroom.enter(this);
	}
	
	private void enterBarber() {
		int time = (int)(Math.random() * 2000);
		broom.getHaircut(this,time);
	}
	
	public void changePos(int j) {
		personIcon.setBounds(BarberGui.pos[id][j].x, BarberGui.pos[id][j].y, 20, 20);
		personIcon.setBackground(colors[id]);
		personIcon.setFont(new Font("TimesRoman",Font.BOLD,14));
		gui.add(personIcon);
	}
}