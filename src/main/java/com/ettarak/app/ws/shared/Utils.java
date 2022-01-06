package com.ettarak.app.ws.shared;

import java.security.SecureRandom;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class Utils {

	private final Random RANDOM = new SecureRandom();
	private final String ALPHANUMERIC = "0123456789abcdefghijkmlnopkrstuvwxyABCDEFGHIJKLMNOPKRSTUVWXY";

	public String generateUserId(int length) {
		StringBuilder returnValue = new StringBuilder();

		for (int i = 0; i < length; i++) {

			returnValue.append(ALPHANUMERIC.charAt(RANDOM.nextInt(ALPHANUMERIC.length())));
		}

		return new String(returnValue);
	}

}
