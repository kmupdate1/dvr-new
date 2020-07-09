package dvr.read;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.IOException;

public class LongLatRead {
	private BufferedReader bufferedReader = null;

	public LongLatRead(String readFileName) throws Exception {
		bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(readFileName)));
	}

	public String[] read(int[] elements) throws IOException {
		String[] res;

		int index = 0;
		while ( (String line = bufferedReader.readLine()) != null ) {
			System.out.println("----------------------------------");

			System.out.println(index + "件目");
			String[] columuns = line.split(",");

			for (int i = 0; i < elements.length; i++) {
				res[i] = columuns[i];
			}
			index++;
		}

		try {
			bufferedReader.close();
		} catch(Exception e) {
			e.printStackTrace();
		}

		return res;
	}

	public String[] read() throws IOException {

	}
}
