import java.io.File;
import java.io.IOException;

import java.util.List;
import java.util.ArrayList;

import dvr.read.LongLatReader;
import dvr.write.LongLatWriter;
import dvr.strategy.PCidREGISTidCompare;

public class CompareMain {

	public static final String debug = "ここまで";

	public static void debugger(String debug) {
		System.out.println(debug);
	}

	public static void main(String[] args) throws IOException, Exception {
		String resourcesPath = args[0];
		Integer start = Integer.parseInt(args[1]);
		Integer stop  = Integer.parseInt(args[2]);
		// String gpsFilePath = "/home/ken/dvr/resources/body/t_gps06.csv";
		while ( start < stop ) {

			final String gpsFilePath = resourcesPath + "body/t_gps" + fileNameMonth(start) + ".csv";
			final Integer month = start;

			new LongLatReader(gpsFilePath).read(new LongLatReader.ReadOneLineListener() {
				private List<String> pcregistList = new ArrayList<String>();

				private String longlatSetFile;

				@Override
				public void hasRead(String[] lineStrs) throws IOException, Exception {
					LongLatWriter pc_regist = new LongLatWriter(longlatSetFile);

					debugger(debug);

					longlatSetFile = resourcesPath + "pc-regist/" + lineStrs[0] + "_" + lineStrs[1] + "_" + fileNameMonth(month) + ".csv";
					String set = lineStrs[0] + lineStrs[1];
					if ( !pcregistList.contains(set) ) {
						new File(longlatSetFile).createNewFile();
						pcregistList.add(set);

						debugger("ファイル生成");
					}

					debugger("debugdebug");

					pc_regist.write(lineStrs[8], lineStrs[9]);
					pc_regist.close();
				}
			});

			debugger("脱出");

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
