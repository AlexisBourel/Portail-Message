package co.simplon.portail.message.controller;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.*;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.filters.CorsFilter;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import co.simplon.portail.message.Application;
import co.simplon.portail.message.model.Message;
import co.simplon.portail.message.model.Tour;
import co.simplon.portail.message.model.User;
import co.simplon.portail.message.service.MessageService;
import co.simplon.portail.message.service.impl.MockServiceImpl;
import co.simplon.portail.message.filter.CORSFilter;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(classes = Application.class)
public class MessageControllerTest {
	/*
	 * Tuto : https://memorynotfound.com/unit-test-spring-mvc-rest-service-junit-mockito/#unit-test-http-post
	 */

	@Mock
	MessageService messageService;
	@Mock
	MockServiceImpl mockService;
	@InjectMocks
	MessageController messageController;

	MockMvc mockMvc;

	User autor = new User();
	Tour tour1 = new Tour();
	Tour tour2 = new Tour();
	Message message1 = new Message();
	Message message2 = new Message();
	List<Message> messages = new ArrayList<>();
	long id = 2;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(messageController).addFilters(new CORSFilter()).build();
		tour1.setId(1);
		tour1.setName("Tour1");
		tour2.setId(2);
		tour2.setName("Tour2");
		message1 = mockMessage(1, "message1", tour1);
		message2 = mockMessage(2, "message2", tour2);

	}

	@Test
	public void GetAllTest() throws Exception {
		messages.add(message1);
		messages.add(message2);
		when(messageService.getAll()).thenReturn(messages);
		mockMvc.perform(get("/message")).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(jsonPath("$[0].id", is(1))).andExpect(jsonPath("$[0].title", is("message1")))
				.andExpect(jsonPath("$[1].id", is(2))).andExpect(jsonPath("$[1].title", is("message2")));
		verify(messageService).getAll();
		verifyNoMoreInteractions(messageService);
	}

	@Test
	public void GetAllTestEmpty() throws Exception {
		when(messageService.getAll()).thenReturn(messages);
		mockMvc.perform(get("/message")).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
		verify(mockService).populateDbWithMockedData();
		verify(messageService, Mockito.times(2)).getAll();
		verifyNoMoreInteractions(mockService);
		verifyNoMoreInteractions(messageService);
	}

	@Test
	public void getAllMessageForTourByIdTest() throws Exception {
		messages.add(message2);
		when(messageService.getAllTourMessages(2)).thenReturn(messages);
		mockMvc.perform(get("/message/tour/2")).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
		verify(messageService).getAllTourMessages(2);
		verifyNoMoreInteractions(messageService);
		
	}

	@Test
	public void getOneByIdTest() throws Exception {
		when(messageService.getOneById(1)).thenReturn(message1);
		mockMvc.perform(get("/message/1")).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
		verify(messageService).getOneById(1);
		verifyNoMoreInteractions(messageService);
	}

	@Test
	public void createTest() throws Exception {
		Message message = new Message();
		message.setId(id);
		message.setAutor(autor);
		message.setTour(tour1);
		message.setContent("content");
		message.setCreatedAt(Date.valueOf(LocalDate.now()));
		message.setType("Autre");
		message.setTitle("title");
		//when(messageService.create(message1)).thenReturn(message1);
		mockMvc.perform(post("/message").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
				.content(asJsonString(message)))
		.andExpect(status().isOk());
		verify(messageService).create(message);
		verifyNoMoreInteractions(messageService);
	}

	/*
     * converts a Java object into JSON representation
     */
	public static String asJsonString(final Object obj) {
	    try {
	        return new ObjectMapper().writeValueAsString(obj);
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}

	private Message mockMessage(long id, String title, Tour tour) {
		Message message = new Message();
		message.setId(id);
		message.setAutor(autor);
		message.setTour(tour);
		message.setContent("content");
		message.setCreatedAt(Date.valueOf(LocalDate.now()));
		message.setType("Autre");
		message.setTitle(title);
		return message;

	}

}
