package com.example.mars_deployment.controller;

import com.example.mars_deployment.model.SpaceResources;
import com.example.mars_deployment.repository.SpaceResourceRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(SpaceResourceController.class)
public class SpaceResourceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SpaceResourceRepository repository;

    @Test
    public void shouldReturnListOfResources() throws Exception {
        SpaceResources oxygen = new SpaceResources("Oxygen Tank", 10);
        SpaceResources food = new SpaceResources("Food Pack", 25);

        Mockito.when(repository.findAll()).thenReturn(Arrays.asList(oxygen, food));

        mockMvc.perform(get("/resources"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].name").value("Oxygen Tank"))
                .andExpect(jsonPath("$[1].name").value("Food Pack"));
    }
}
