package dvr.read;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.IOException;

public class LongLatRead {
	protected BufferedReader bufferedReader = null;

	public LongLatRead(String readFileName) throws Exception {
		// oome出そう
		try {
			bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(readFileName)));
		} catch (OutOfMemoryError e) {
			System.out.println("ファイル読込みの際に、バッファオーバーフローを起こしました。");
		}
	}

	public void read(ReadOneLine readOneLine) throws IOException, Exception {

		int index = 0;
		while ( (String line = bufferedReader.readLine()) != null ) {
			readOneLine.hasRead(line.split(","));

		}

		bufferedReader.close();
	}

	public String[] read() throws IOException {

	}

	public interface ReadOneLine {
		public String[] hasRead();
	}
}
