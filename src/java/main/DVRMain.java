package dvr.main;

import java.io.File;
import java.io.IOException;

import dvr.read.LongLatRead;
import dvr.write.LongLatWrite;
import dvr.search.LongLatSearch;

public class DVRMain {
	//private static final String RESOURCE_PATH = "/home/ken/dvr/resources/";
	private static String resourcePath;

	public static void main(String[] args) throws IOException, Exception {
		resourcePath = args[0];
		
		int start = Integer.parseInt(args[1]);
		int stop  = Integer.parseInt(args[2]);

		int month = start;
		while ( month <= stop ) {
			// read [t_regist_gpsXX.csv]
			String t_regist_gps  = fileDirectory("regist") + csvFile("t_regist_gps" + fileNameMonth(month));
			String[] res = new LongLatReadREGIST(t_regist_gps).specificRead();

			String pcid_registid = fileDirectory("pc-regist") + csvFile(res[0] + "_" + res[1] + "_" + fileNameMonth(month));
			String mac_address   = fileDirectory("mac") + csvFile(res[2]);

			File mac = new File(mac_address);
			if ( !mac.exists() ) {
				new File(mac_address).createNewFile();
			}

			String[] writeData = new LongLatSearch(pcid_registid).search(new LongLatRead(month, pcid_registid).read());
			new LongLatWrite(mac_address).write(writeData);

			month++;
		}
	}

	private static String fileNameMonth(int month) {
		String res = toString(month);

		if ( month < 10 ) {
			res = "0" + toString(month);
		}

		return res;
	}

	// inline
	private static String fileDirectory(String directiory) {
		return resourcePath + directiory + "/";
	}

	// inline
	private static String csvFile(String fileName) {
		return fileName + ".csv";
	}
}
