package dvr.read;

//import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class LongLatRead {
	private BufferedReader bReader = null;


	public LongLatRead(String readFileName) throws Exception {
		bReader = new BufferedReader(new InputStreamReader(new FileInputStream(readFileName)));
	}

	public String[] read(int[] colsize) throws IOException {
		String[] res;

		int index = 0;
		while ( (String line = bReader.readLine()) != null ) {
			System.out.println("----------------------------------");

			System.out.println(index + "件目");
			String[] columuns = line.split(",");

			for (int i = 0; i < colsize.length; i++) {
				res[i] = columuns[i];
			}
			index++;
		}

		try {
			bReader.close();
		} catch(Exception e) {
			e.printStackTrace();
		}

		return res;
	}
}
