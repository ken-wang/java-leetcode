package parallel;

class SharingLong {
	volatile long v;
//	long p1, p2, p3, p4, p5, p6;
}

class LightThread extends Thread {
	SharingLong[] shares;
	int index;

	LightThread(SharingLong[] shares, int index) {
		this.shares = shares;
		this.index = index;
	}

	@Override
	public void run() {
		for (int i = 0; i < 100000000; i++) {
			shares[index].v++;
		}
	}

}

public class FalseSharingDemo {

	public static void main(String[] args) throws InterruptedException {
		int size = Runtime.getRuntime().availableProcessors();
		System.out.println("Processors size:" + size);
		for (int i = 0; i < 10; i++) {
			benchmark(size);
		}

	}

	public static void benchmark(int size) throws InterruptedException {
		SharingLong[] shares = new SharingLong[size];

		for (int i = 0; i < size; i++) {
			shares[i] = new SharingLong();
		}

		Thread[] threads = new Thread[size];
		for (int i = 0; i < size; i++) {
			threads[i] = new LightThread(shares, i);
		}
		for (int i = 0; i < size; i++) {
			threads[i].start();
		}
		long start = System.currentTimeMillis();

		for (Thread t : threads) {
			t.join();
		}
		long time = System.currentTimeMillis() - start;
		System.out.println("total costs time:" + time);

	}

}
