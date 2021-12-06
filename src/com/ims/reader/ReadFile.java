package com.ims.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import com.ims.model.CardsVO;
import com.ims.model.InputItemVO;
import com.ims.model.ItemsVO;

public class ReadFile {

	public static String readFile(String fileName) {
		System.out.println("Reading file : " + fileName);
		String path = System.getProperty("user.dir") + "/" + fileName;
		File f = new File(path);
		String line = null;
		String data = "";
		try {
			BufferedReader reader = new BufferedReader(new FileReader(f));
			while ((line = reader.readLine()) != null) {
				if (data.equals("")) {
					data = line;
					continue;
				}
				data = data + "  " + line;
			}

			System.out.println(data);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}

	public static List<ItemsVO> convertToDBItem() {
		List<ItemsVO> itemsList = new ArrayList<>();
		String fileData = readFile("Dataset - Sheet1.csv");
		String[] items = fileData.split(" ");

		for (int i = 1; i < items.length; i++) {
			String[] data = items[i].split(",");
			if (data.length > 1) {
				ItemsVO item = new ItemsVO();
				item.setCategory(data[0]);
				item.setItem(data[1]);
				item.setQuantity(Integer.valueOf(data[2]));
				item.setPrice(Double.valueOf(data[3]));
				itemsList.add(item);
			}
		}
		return itemsList;

	}
	
	public static List<InputItemVO> convertToInputItems(){
		List<InputItemVO> itemsList = new ArrayList<>();
		String fileData = readFile("Input2 - Sheet1.csv");
		String[] items = fileData.split(" ");

		for (int i = 1; i < items.length; i++) {
			String[] data = items[i].split(",");
			if (data.length > 1) {
				InputItemVO item = new InputItemVO();
				item.setItem(data[0]);
				item.setQuantity(Integer.valueOf(data[1]));
				item.setCardNumber(data[2]);
				itemsList.add(item);
			}
		}
		return itemsList;
	}
	public static Set<String> convertToDBCards(){
		Set<String> cardsSet = new HashSet<>();
		String fileData = readFile("Cards - Sheet1.csv");
		String[] cards = fileData.split(" ");

		for (int i = 0; i < cards.length; i++) {
			if (cards.length > 0) {
				cardsSet.add(cards[i]);
			}
		}
		System.out.println(cards.length + "Cards List from the file : "+cardsSet);
		return cardsSet;
	}
	
}
