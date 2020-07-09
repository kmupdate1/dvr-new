package dvr.main;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.IOException;

import dvr.read.LongLatRead;

public class LongLatReadREGIST extends LongLatRead {
	private BufferedReader bufferedReader = null;

	public LongLatReadREGIST(String readFileName) throws Exception {
		super(readFileName);
	}

	public void specificRead() {

	}
}
