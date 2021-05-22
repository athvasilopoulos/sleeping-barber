
public class WaitingRoom {
	private volatile int seats;
	private Barber barber;

	public WaitingRoom() {
		seats = 4;
	}

	public void setBarber(Barber barber) {
		this.barber = barber;
	}

	public synchronized void enter(Person person) {
		while (seats <= 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		seats -= 1;
		person.changePos(2);
	}

	public synchronized void exit() {
		if (barber.getCuts() != 9)
			seats += 1;
		notifyAll();
	}

	public void rest(Barber barber) {
		try {
			Thread.sleep((int) (Math.random() * 3000) + 2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		seats += 1;
	}
}
