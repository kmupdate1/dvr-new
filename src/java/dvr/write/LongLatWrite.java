package dvr.write;

import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.io.BufferedWriter;


import strategy.LongLatSearch;

public class LongLatWrite /*implements LongLatWritable */{
	//private File input;
	private String line;

	private String createFileName;

	private LongLatSearch llSearch;

	private String writeFileName;

	public LongLatWrite(String writeFileName) throws IOException {
		this.writeFileName = writeFileName;
	}

	public void write() {

	}

	/*
	public void search(String path, String column0, String column1) throws IOException {

		String searchFile = path + "pc-regist/" + column0 + "_" + column1 + "_12.csv";
		BufferedReader bReader = new BufferedReader(new InputStreamReader(new FileInputStream(searchFile)));

		//System.out.println(searchFile);
		llSearch = new LongLatSearch(searchFile);

		int index = 0;
		while ( (line = bReader.readLine()) != null ) {
			System.out.println(index + "件目");
			String[] columuns = line.split(",");

			boolean judge = llSearch.search(index, Double.parseDouble(columuns[0]), Double.parseDouble(columuns[1]));

			if ( judge ) {
				
			}

			index++;
		}

		try {
			int num = new FileReader(new File(searchFile)).read();
			System.out.println(num);
		} catch (FileNotFoundException e) {
			System.out.println("ファイルがありません。");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	*/
}
