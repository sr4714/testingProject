package com.example.demo;

import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.web.multipart.MultipartFile;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

//import java.io.File;

//import org.junit.jupiter.api.Test;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import com.example.demo.controller.UserController;
import com.example.demo.model.FileDb;
//@SpringBootTest
import com.example.demo.model.User;
import com.example.demo.repository.FileDbRepository;
//@RunWith(SpringRunner.class)
public class SpringBootTest {
    
	@Test
	public void testUserRegistrationDb() {
		User user1 = new User();
		UserController control = mock(UserController.class);
		user1.setUsername("testUser");
		user1.setPassword("notagoodpassword");
		control.createUser(user1);
		when(control.getUser("testUser", "notagoodpassword")).thenReturn(ResponseEntity.ok(null) );
		control.createUser(user1);
		Mockito.when(control.getUser("testUser", "notagoodpassword")).thenReturn(ResponseEntity.ok(null));
		Mockito.verify(control).getUser("testUser", "notagoodpassword");
		
		assertEquals(control.getUser("testUser", "notagoodpassword"), ResponseEntity.ok(null));
	}
//	@MockBean
//	MultipartFile file;
//	@Autowired
//	@Test
//	public void testFileDb() {
//		User user1 = new User();
//		user1.setUsername("testUser");
//		user1.setPassword("password");
//		FileDb dbase = mock(FileDb.class);
//		
//	}
	
	@Test
	public void testGetUser() {
		User user1 = new User();
		user1.setUsername("DoctorWho");
		user1.setPassword("bAdWoLfTaRdIs");
		assertEquals(user1.getUsername(), "DoctorWho");
		assertEquals(user1.getPassword(), "bAdWoLfTaRdIs");
	}
}
