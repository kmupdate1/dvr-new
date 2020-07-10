package dvr.main;

import java.io.File;
import java.io.IOException;

import dvr.read.LongLatReader;
import dvr.write.LongLatWriter;
import dvr.strategy.LongLatSearcher;

public class DVRMain {
	//private static final String RESOURCE_PATH = "/home/ken/dvr/resources/";
	private static String resourcesPath;

	public static void main(String[] args) throws IOException, Exception {
		resourcesPath = args[0];
		
		Integer start = Integer.parseInt(args[1]);
		Integer stop  = Integer.parseInt(args[2]);

		Integer month = start;
		while ( month <= stop ) {
			// read [t_regist_gpsXX.csv]
			String t_regist_gps  = fileDirectory("regist") + csvFile("t_regist_gps" + fileNameMonth(month));
			
			final Integer anonymousMonth = month;
			new LongLatReader(t_regist_gps).read(new LongLatReader.ReadOneLine() {
				@Override
				public void hasRead(String[] lineStrs) throws IOException, Exception {
					String pcid_registid = fileDirectory("pc-regist") + csvFile(lineStrs[0] + "_" + lineStrs[1] + "_" + fileNameMonth(anonymousMonth));
					String mac_address   = fileDirectory("mac") + csvFile(lineStrs[2]);

					File mac = new File(mac_address);
					if ( !mac.exists() ) {
						mac.createNewFile();
					}

					LongLatWriter writer = new LongLatWriter(mac_address);
					new LongLatReader(pcid_registid).read(new LongLatReader.ReadOneLine() {
						@Override
						public void hasRead(String[] lineStrsSub) throws IOException, Exception {
							writer.write(new LongLatSearcher().search(lineStrsSub));
						}
					});
					writer.close();
				}
			});

			month++;
		}
	}

	private static String fileNameMonth(Integer month) {
		String res = month.toString();

		if ( month < 10 ) {
			res = "0" + month.toString();
		}

		return res;
	}

	// inline
	private static String fileDirectory(String directiory) {
		return resourcesPath + directiory + "/";
	}

	// inline
	private static String csvFile(String fileName) {
		return fileName + ".csv";
	}
}
