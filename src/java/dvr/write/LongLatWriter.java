package dvr.write;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class LongLatWriter {
	public PrintWriter printWriter;

	/*
	private String line;

	private String createFileName;

	private LongLatSearch llSearch;

	private String writeFileName;
	*/

	public LongLatWriter(String writeFileName) throws IOException, Exception {
		printWriter = new PrintWriter(
			new BufferedWriter(
				new OutputStreamWriter(
					new FileOutputStream(writeFileName)
					)
				)
			);
	}

	public void write(String[] tudes) throws IOException, Exception {
		for ( String writeStr : tudes ) {
			printWriter.write(writeStr);
		}
	}

	public void close() throws IOException, Exception {
		printWriter.close();
	}
}
