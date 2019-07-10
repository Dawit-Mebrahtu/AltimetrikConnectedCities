package com.altimetrik.connectedcities.connectedcities;

//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class ConnectedcitiesApplicationTests {
//
//    @Test
//    public void contextLoads() {
//    }
//
//}


import com.altimetrik.connectedcities.connectedcities.controller.CitiesController;
import com.altimetrik.connectedcities.connectedcities.service.CitiesService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CitiesController.class)
public class ConnectedcitiesApplicationTests {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CitiesService service;

    // write test cases here
    @Test
    public void givenTwoCities_whenConnected_thenReturnJsonBoolean()
            throws Exception {

        given(service.isConnected("A","D")).willReturn(true);

        mvc.perform(get("/connected?origin=A&destination=D")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
//                .andExpect(jsonPath("$", hasSize(1)))
//                .andExpect(jsonPath("$[0].name", is(alex.getName())));
    }
}