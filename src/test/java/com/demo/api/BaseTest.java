package com.demo.api;

import org.apache.commons.codec.binary.Base64;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class BaseTest {

	@Autowired
    private PasswordEncoder passwordEncoder;
	
	
	//@Test
	void base64 () {
		String credentials = "agrocontratacion:agrocontratacion";
		String encodedCredentials = new String(Base64.encodeBase64(credentials.getBytes()));
		
		//System.out.println(encodedCredentials);
	}
	
	
	@Test
	public void generarPass() {
		
		String pass="ApiBarakaldo2021";
		System.out.println(passwordEncoder.encode(pass));
	}

	
}
