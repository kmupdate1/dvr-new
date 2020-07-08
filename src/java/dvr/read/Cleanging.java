package read;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

import write.LongLatWrite;

public class Cleanging {
	private static final String RESOURCE_PATH = "/home/ken/dvr/resources/";

	private BufferedReader bReader = null;
	private String line;

	public Cleanging(int num) throws Exception {
		String csvFileName;
		if ( num < 10 ) {
			csvFileName = csvFile("t_gps0" + num);
		} else {
			csvFileName = csvFile("t_gps" + num);
		}

		bReader = new BufferedReader(new InputStreamReader(new FileInputStream(csvFileName)));
	}

	public void read() throws IOException {
		int index = 0;

		while ( (line = bReader.readLine()) != null ) {
			System.out.println("----------------------------------");

			System.out.println(index + "件目");
			String[] columuns = line.split(",");

			//new LongLatWrite(RESOURCE_PATH + "mac/" + columuns[2] + ".csv")
				//.search(RESOURCE_PATH, columuns[0], columuns[1]);
			
			for (int i = 0; i < 4; i++) {
				System.out.println(columuns[i]);
			}
			
			index++;
		}
		System.out.println("----------------------------------");

		try {
			bReader.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	// inline method
	private String csvFile(String name) {
		return RESOURCE_PATH + "body/" + name + ".csv";
	}
}
