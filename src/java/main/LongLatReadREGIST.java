package dvr.main;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.IOException;

import dvr.read.LongLatRead;

public class LongLatReadREGIST extends LongLatRead {
	public LongLatReadREGIST(String readFileName) throws Exception {
		super(readFileName);
	}

	@Override
	public String[] read() throws IOException, Exception {
		String[] res;

		int index = 0;
		while ( (String line = super.bufferedReader.readLine()) != null ) {
			System.out.println("----------------------------------");

			System.out.println(index + "件目");
			String[] columuns = line.split(",");

			for (int i = 0; i < columuns.length; i++) {
				res[i] = columuns[i];
			}
			index++;
		}

		super.bufferedReader.close();

		return res;
	}

	public void specificRead() {

	}
}
