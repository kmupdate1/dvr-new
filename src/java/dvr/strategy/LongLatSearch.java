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
		bReader = new BufferedReader(new InputStreamReader(new FileInputStream(searchFile)));
	}

	public boolean search(int index, double longititude, double latitude) {
		boolean result = false;

		double longDiff = longititude - this.preLongititude;
		double latDiff  = latitude - this.preLatitude;

		if ( index > 0 ) {
			if ( longititude == 0.0 || latitude == 0.0 ) {
				result = true; 
			} else if ( longDiff > LONG_PIVOT || latDiff > LAT_PIVOT ) {
				result = true;
			}
		}

		this.preLongititude = longititude;
		this.preLatitude = latitude;

		return result;
	}
}
