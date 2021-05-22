
public class BarberRoom {
	private boolean chair;
	private boolean barberAvailable;
	private WaitingRoom wroom;
	private int time;
	private Barber barber;

	public BarberRoom(WaitingRoom wroom) {
		chair = true;
		this.wroom = wroom;
	}

	public void setBarber(Barber barber) {
		barberAvailable = true;
		this.barber = barber;
	}

	public synchronized void getHaircut(Person person, int time) {
		while (!chair || !barberAvailable) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		wroom.exit();
		person.changePos(3);
		chair = false;
		this.time = time;
		notifyAll();
		try {
			wait();
		} catch (InterruptedException e) {
			System.err.println(e.toString());
		}
		person.changePos(0);
		if (barber.getCuts() != 10)
			barberAvailable = true;
		notifyAll();
	}

	public synchronized void giveHaircut(Barber barber) {
		while (chair) {
			barber.changePos(1);
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		barberAvailable = false;
		barber.changePos(0);
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		chair = true;
		barber.addCuts();
		notifyAll();
	}

	public synchronized void wokeUp() {
		barberAvailable = true;
		barber.resetCuts();
		notifyAll();
	}
}
