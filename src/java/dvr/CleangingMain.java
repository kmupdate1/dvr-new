import java.io.IOException;

import read.Cleanging;

public class CleangingMain {
	private static final int START = 12;
	private static final int STOP  = 12;

	public static void main(String[] args) throws IOException, Exception {
		int index = START;
		while ( index <= STOP ) {
			new Cleanging(index).read();
			/*
			new Thread(new Runnable {
				private Cleanging reader = new Cleanging(index);

				@Override
				public void run() {

				}
			}).start();
			*/
			index++;
		}
	}
}
