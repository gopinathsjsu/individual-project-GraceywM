package com.ims.writer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import java.util.List;

public class WriteIntoFile {

	public static void writeIntoFile(Object data, boolean overwriteFile) {
		try {
			String fileName = "output.csv";
			String path = System.getProperty("user.dir") + "/" + fileName;
			File file = new File(path);
			BufferedWriter bw = null;

			if (data instanceof Double || data instanceof Integer) {
				// total amount
				bw = new BufferedWriter(new FileWriter(file.getName(), overwriteFile));
				bw.write("Toal Price"+"," + data);
			}

			if (data instanceof String) {
				// failed in threshold
				fileName = "output.txt";
				path = System.getProperty("user.dir") + "/" + fileName;
				file = new File(path);
				bw = new BufferedWriter(new FileWriter(file.getName(), overwriteFile));
				bw.write(String.valueOf(data));
			}

			if (data instanceof List) {
				// item qty not matching
				 fileName = "output.txt";
				 path = System.getProperty("user.dir") + "/" + fileName;
				 file = new File(path);
				bw = new BufferedWriter(new FileWriter(file.getName(), overwriteFile));
				bw.write("\nPlease correct quantities : ");
				List<String> strList = (List) data;
				for (String s : strList) {
					bw.write("\n");
					bw.write(s);
				}


			}
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
