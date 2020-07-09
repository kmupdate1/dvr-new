package strategy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;

public class LongLatSearch {

	private static final double LONG_PIVOT = 0.471974;
	private static final double LAT_PIVOT  = 0.381834;

	private double preLongititude;
	private double preLatitude;

	private BufferedReader bReader;

	public LongLatSearch(String searchFile) {
		bReader = new BufferedReader(new InputStreamReader(new FileInputStream(searchFilePath)));
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

		double longDiff = Double.parseDouble(tudes[0]) - this.preLongititude;
		double latDiff  = Double.parseDouble(tudes[1]) - this.preLatitude;

		if ( index > 0 ) {
			if ( longititude == 0.0 || latitude == 0.0 ) {
				result = true;
			} else if ( longDiff > LONG_PIVOT || latDiff > LAT_PIVOT ) {
				result = true;
			}
		}

		this.preLongititude = Double.parseDouble(tudes[0]);
		this.preLatitude    = Double.parseDouble(tudes[1]);

		return result;
	}
}
