package dvr.read;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.IOException;

public class LongLatReader {
	protected BufferedReader bufferedReader = null;

	public LongLatReader(String readFileName) throws IOException, Exception {
		// oome出そう
		try {
			bufferedReader = new BufferedReader(
				new InputStreamReader(
					new FileInputStream(readFileName)
					)
				);
		} catch (OutOfMemoryError e) {
			System.out.println("ファイル読込みの際に、バッファオーバーフローを起こしました。");
		}
	}

	public void read(ReadOneLineListener listener) throws IOException, Exception {

		String line = bufferedReader.readLine();

		while ( line != null ) {
			listener.hasRead(line.split(","));
		}

		bufferedReader.close();
	}

	public interface ReadOneLineListener {
		public void hasRead(String[] lineStrs) throws IOException, Exception;
	}
}
