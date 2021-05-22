import gui.BarberGui;

public class SleepingBarberAppV4 {
	
	public static void main(String[] args) {
		BarberGui gui = new BarberGui();
		WaitingRoom wroom = new WaitingRoom();
		BarberRoom broom = new BarberRoom(wroom);
		Barber barber = new Barber(gui,wroom,broom);
		wroom.setBarber(barber);
		broom.setBarber(barber);
		Person p[] = new Person[10];
		for (int i = 0; i < p.length; i++) {
			p[i] = new Person(i,gui,wroom,broom);
		}

		// Start the people and the barber as active threads
		barber.start();
		for (int i = 0; i < p.length; i++) {
			p[i].start();
		}
	}
}
