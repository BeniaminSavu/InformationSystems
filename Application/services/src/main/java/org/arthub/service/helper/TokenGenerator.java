package org.arthub.service.helper;
import java.util.UUID;

public class TokenGenerator implements Generator {

	public String generateToken() {
		String token;

		UUID uuid = UUID.randomUUID();
		token = uuid.toString();
		return token;
	}

}