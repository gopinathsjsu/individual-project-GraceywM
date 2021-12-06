package com.ims.main;

import com.ims.service.CardServiceImpl;

import java.io.IOException;

public class IMSMain {
	public static void main(String[] args) throws IOException {
		CardServiceImpl cardService = new CardServiceImpl();
		cardService.processOrder();
	}
}
