package write;

import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class LongLatWrite /*implements LongLatWritable */{
	//private File input;

	private String createFileName;

	public LongLatWrite(String createFileName) throws IOException {
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
}
