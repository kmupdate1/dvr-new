package dvr.strategy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;

public class LongLatSearch {

	private static final double LONG_PIVOT = 0.471974;
	private static final double LAT_PIVOT  = 0.381834;

	private double preLongititude;
	private double preLatitude;

	private BufferedReader bufferedReader;

	public LongLatSearch(String searchFile) {
		bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(searchFilePath)));
	}

	public String[] search(String[] tudes) {
		String[] res = null;
		if ( isStrange(tudes) ) {
			res = tudes;
		}

		return res;
	}

	private boolean isStrange(String[] tudes) {
		boolean result = false;

		double tude0 = Double.parseDouble(tudes[0]);
		double tude1 = Double.parseDouble(tudes[1])

		double longDiff = tude0 - this.preLongititude;
		double latDiff  = tude1 - this.preLatitude;

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

		return result;
	}
}
