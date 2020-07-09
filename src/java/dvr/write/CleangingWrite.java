package write;

import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.io.FileWriter;

public class CleangingWrite /*implements LongLatWritable */{
	//private File input;

	private String createFileName;

	public CleangingWrite(String createFileName) throws IOException {
		new File(createFileName).createNewFile();
	}

	public void search(String path, String column0, String column1) {

		String searchFile = path + "pc-regist/" + column0 + "_" + column1 + "_07.csv";

		try {
			int num = new FileReader(new File(searchFile)).read();
			System.out.println(num);
		} catch (FileNotFoundException e) {
			System.out.println("ファイルがありません。");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void write(String column0, String column1) {
		try {
			new FileWriter(new File());
		} catch () {

		}
	}
}
