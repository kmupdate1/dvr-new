package read;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class LongLatRead {
	private BufferedReader bReader = null;

	private String line;

	public LongLatRead(int num) throws Exception {
		String csvFileName;
		if ( num < 10 ) {
			csvFileName = csvFile("t_regist_gps0" + num);
		} else {
			csvFileName = csvFile("t_regist_gps" + num);
		}

		bReader = new BufferedReader(new InputStreamReader(new FileInputStream(csvFileName)));
	}

	public void read() throws IOException {
		int index = 0;

		while ( (line = bReader.readLine()) != null ) {
			System.out.println("----------------------------------");

			System.out.println(index + "件目");
			String[] columuns = line.split(",");

			for (int colno = 0; colno < columuns.length; colno++) {
				if ( colno == 0 ) {
					System.out.println(columuns[colno]);					
				} else if ( colno == 1 ) {
					System.out.println(columuns[colno]);
				} else if ( colno == 6 ) {
					System.out.println(columuns[colno]);					
				}
			}
			index++;
		}

		try {
			bReader.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private String csvFile(String name) {
		return "/home/ken/dvr/resources/" + name + ".csv";
	}
}
