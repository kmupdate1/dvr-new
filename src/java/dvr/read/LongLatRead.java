package read;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class LongLatRead {
	private static final String RESOURCE_PATH = "/home/ken/dvr/resources/";

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

	// ファイルがデカすぎてBufferdReaderに収まりきらないから、なんとかする。
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
					new File(RESOURCE_PATH + "mac/" + columuns[colno] + ".csv").createNewFile();
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

	// inline method
	private String csvFile(String name) {
		return RESOURCE_PATH + "regist/" + name + ".csv";
	}
}
