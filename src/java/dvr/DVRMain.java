import java.io.IOException;

import read.LongLatRead;

public class DVRMain {
	private static final int START = 8;
	private static final int STOP  = 8;

	public static void main(String[] args) throws IOException, Exception {
		int index = START;
		while ( index <= STOP ) {
			new LongLatRead(index).read();
			/*
			new Thread(new Runnable {
				private LongLatRead reader = new LongLatRead(index);

				@Override
				public void run() {

				}
			}).start();
			*/
			index++;
		}
	}
}
