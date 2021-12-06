package com.ims.service;

import java.io.IOException;
import java.util.List;

import com.ims.model.InputItemVO;

public interface ICartService {
	void processOrder() throws IOException;

	List<String> validateInputItemQuantity();

	String validateCategoryThreshold();

	void getCategoryOfInputItem(List<InputItemVO> inputItems);

	Double calculateTotalPrice();
}
