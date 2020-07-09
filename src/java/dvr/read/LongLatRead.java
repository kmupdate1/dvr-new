package read;

//import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class LongLatRead {
	private BufferedReader bReader = null;


	public LongLatRead(int month, String readFileName) throws Exception {
		/*
		String csvFileName;
		if ( month < 10 ) {
			csvFileName = csvFile(readFileName + "0" + month);
		} else {
			csvFileName = csvFile(readFileName + month);
		}
		*/

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

			//new LongLatWrite(RESOURCE_PATH + "mac/" + columuns[2] + ".csv")
				//.search(RESOURCE_PATH, columuns[0], columuns[1]);
		}

		try {
			bReader.close();
		} catch(Exception e) {
			e.printStackTrace();
		}

		return res;
	}

	/*
	private String csvFile(String name) {
		return RESOURCE_PATH + "regist/" + name + ".csv";
	}
	*/
}
