package io.pivotal.poc.bac.example.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@Controller
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Autowired
	private ObjectMapper objectMapper;

	@RequestMapping("/")
	public String index(RequestEntity<byte[]> incoming, Model model) throws Exception {
		model.addAttribute("headers", toPrettyJsonString(incoming.getHeaders()));
		return "index";
	}

	private String toPrettyJsonString(Object object) throws Exception {
		return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
	}
}
