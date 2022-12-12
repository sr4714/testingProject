package com.example.demo;

import static org.hamcrest.Matchers.hasSize;
// import mockito related
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.controller.UserController;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class SpringbootBackendSe317ApplicationTests {

	@Autowired
	private MockMvc controller;


	@MockBean // note that this repo is also needed in controller
	private UserRepository repo;
	
	

	@Test
	public void testService() throws Exception {
		User user = new User("admin", "admin");
		User user1 = new User("test", "test2");
		
		user.setUsername("admin");
		user.setPassword("admin");
		user1.setPassword("test2");
		user1.setUsername("test");
		
		List<User> list = new ArrayList<User>();
		list.add(user); list.add(user1);
		repo.save(user);
		
		System.out.println(repo.findAll());
		
		when(repo.findAll()).thenReturn(list);
		

		
		
				
		controller.perform(get("/api/users")).andExpect(status().isOk());
		
		 //controller.perform(get("/user/covid")).andExpect(status().isOk());
	}
}

