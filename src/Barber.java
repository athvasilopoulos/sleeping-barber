import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import gui.BarberGui;

public class Barber extends Thread {
	private WaitingRoom wroom;
	private BarberRoom broom;
	private BarberGui gui;
	private Button barberIcon;
	private int cuts;

	public Barber(BarberGui gui, WaitingRoom wroom, BarberRoom broom) {
		this.gui = gui;
		this.wroom = wroom;
		this.broom = broom;
		barberIcon = new Button();
		changePos(1);
		cuts = 0;
	}

	public int getCuts() {
		return cuts;
	}

	public void addCuts() {
		cuts++;
	}

	public void resetCuts() {
		cuts = 0;
	}

	public void run() {
		while (true) {
			if (cuts == 10)
				rest();
			work();
		}
	}

	private void work() {
		broom.giveHaircut(this);
	}

	private void rest() {
		changePos(1);
		wroom.rest(this);
		broom.wokeUp();
	}

	public void changePos(int j) {
		if (j == 0) {
			barberIcon.setBounds(271, 57, 30, 30);
		} else {
			barberIcon.setBounds(215, 200, 20, 40);
		}
		barberIcon.setBackground(Color.green);
		barberIcon.setFont(new Font("TimesRoman", Font.BOLD, 14));
		gui.add(barberIcon);
	}

}

