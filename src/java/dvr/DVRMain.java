import java.io.File;
import java.io.IOException;

import read.LongLatRead;
import write.LongLatWrite;
import search.LongLatSearch;

public class DVRMain {
	private static final int START = 6;
	private static final int STOP  = 12;

	private static final String RESOURCE_PATH = "/home/ken/dvr/resources/";

	public static void main(String[] args) throws IOException, Exception {
		int month = START;
		while ( month <= STOP ) {
			String[] res = new LongLatRead(month, fileDirectory("regist") + csvFile("t_regist_gps" + fileNameMonth(month))).read();

			String searchFile = fileDirectory("pc-regist") + csvFile(res[0] + "_" + res[1] + "_" + fileNameMonth(month));

			String filePath = fileDirectory("mac") + csvFile(res[2]);
			File isExist = new File(filePath);
			if ( !isExist.exists() ) {
				new File(filePath).createNewFile();
			}

			String[] writeData = new LongLatSearch(searchFile).search(new LongLatRead(month, searchFile));
			new LongLatWrite(filePath).write(writeData);

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
		return RESOURCE_PATH + directiory + "/";
	}

	// inline
	private static String csvFile(String fileName) {
		return fileName + ".csv";
	}
}
