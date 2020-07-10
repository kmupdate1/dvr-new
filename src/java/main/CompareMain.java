package drv.main;

import java.io.File;
import java.io.IOException;

import java.util.List;
import java.util.ArrayList;

import dvr.read.LongLatReader;
import dvr.write.LongLatWriter;
import dvr.strategy.PCidREGISTidCompare;

public class CompareMain {
	public static void main(String[] args) throws IOException, Exception {
		// String gpsFilePath = "/home/ken/dvr/resources/body/t_gps06.csv";
		final String gpsFilePath = args[0];

		Integer start = Integer.parseInt(args[1]);
		Integer stop  = Integer.parseInt(args[2]);

		while ( start > stop ) {

			final Integer month = start;
			new LongLatReader(gpsFilePath).read(new LongLatReader.ReadOneLineListener() {
				private List<String[]> pcregistList = new ArrayList<String[]>();

				private File longlatSet;
				private String longlatSetFile;

				@Override
				public void hasRead(String[] lineStrs) throws IOException, Exception {
					longlatSetFile = gpsFilePath + lineStrs[0] + "_" + lineStrs[1] + "_" + fileNameMonth(month) + ".csv";
					if ( !isExistsSets(lineStrs) ) {
						longlatSet = new File(longlatSetFile).createNewFile();
						pcregistList.add(lineStrs);
					}

					new LongLatWriter(longlatSetFile).write();

					counter++;
				}

				private boolean isExistsSets(String[] strs) {

				}
			});

			start++;
		}
	}

	private static String fileNameMonth(Integer month) {
		String res = month.toString();

		if ( month < 10 ) {
			res = "0" + month.toString();
		}

		return res;
	}
}
