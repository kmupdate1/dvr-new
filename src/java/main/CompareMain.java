package drv.main;

import java.io.IOException;

import dvr.read.LongLatReader;
import dvr.write.LongLatWriter;
import dvr.strategy.PCidREGISTidCompare;

public class CompareMain {
	public static void main(String[] args) throws IOException, Exception {
		String gpsFilePath = "/home/ken/dvr/resources/body/t_gps06.csv";

		new LongLatReader(gpsFilePath).read()
	}
}
