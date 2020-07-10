package dvr.strategy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.IOException;

public class LongLatSearcher {

	private static final Double LONG_PIVOT = 0.471974;
	private static final Double LAT_PIVOT  = 0.381834;

	private Double preLongititude;
	private Double preLatitude;

	private Integer index = 0;

/*
	private BufferedReader bufferedReader;

	public LongLatSearch(String searchFile) throws IOException, Exception{
		bufferedReader = new BufferedReader(
			new InputStreamReader(
				new FileInputStream(searchFilePath)
				)
			);
	}
*/
	public String[] search(String[] tudes) {
		String[] res = null;
		if ( isStrange(tudes) ) {
			res = tudes;
		}

		return res;
	}

	public String[] search(String tude0, String tude1) {
		String[] tudes = {tude0, tude1};
		return search(tudes);
	}

	private boolean isStrange(String[] tudes) {
		boolean result = false;

		Double tude0 = Double.parseDouble(tudes[0]);
		Double tude1 = Double.parseDouble(tudes[1]);

		Double longDiff = tude0 - this.preLongititude;
		Double latDiff  = tude1 - this.preLatitude;

		if ( tude0 == 0.0 || tude1 == 0.0 ) {
			result = true;
		}

		if ( index > 0 ) {
			if ( longDiff > LONG_PIVOT || latDiff > LAT_PIVOT ) {
				result = true;
			}
		}

		this.preLongititude = tude0;
		this.preLatitude    = tude1;

		index++;

		return result;
	}
}
