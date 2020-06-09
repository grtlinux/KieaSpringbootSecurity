package org.tain;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.tain.domain.User;
import org.tain.object.UserObject;
import org.tain.repository.UserRepository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.java.Log;

@SpringBootApplication
//@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@Log
public class KieaSpringbootSecuritySimple2Application implements CommandLineRunner {

	private static boolean flag = true;
	
	public static void main(String[] args) {
		SpringApplication.run(KieaSpringbootSecuritySimple2Application.class, args);
	}

	//////////////////////////////////////////////////////////////
	
	@Override
	public void run(String... args) throws Exception {
		if (flag) test01();
	}

	@Autowired
	private UserRepository userRepository;
	
	private void test01() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		List<UserObject> lstUser = objectMapper.readValue(new File("src/main/resources/user.json"), new TypeReference<List<UserObject>>() {});
		for (UserObject user : lstUser) {
			log.info("KANG-20200609 >>>>> " + user);
			this.userRepository.save(User.builder().username(user.getUsername()).password(user.getPassword()).role(user.getRole()).build());
		}
	}
}
