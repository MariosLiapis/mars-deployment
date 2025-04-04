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

/**
 * Unit test for SpaceResourceController using MockMvc.
 * This test verifies the GET /resources endpoint behavior without starting the full Spring context.
 */
@ExtendWith(SpringExtension.class)
@WebMvcTest(SpaceResourceController.class)
public class SpaceResourceControllerTest {

     // Injects a mock HTTP request environment
    @Autowired
    private MockMvc mockMvc;

    // Mocks the repository so the controller can run without accessing a real database
    @MockBean
    private SpaceResourceRepository repository;

    /**
     * Test that ensures that the controller returns correctly a list of resources.
     * It mocks two resource entries and verifies that the response:
     * - Has status 200 OK
     * - Returns JSON
     * - Has two elements with correct names
     */
    @Test
    public void shouldReturnListOfResources() throws Exception {
        // Prepare mock data
        SpaceResources oxygen = new SpaceResources("Oxygen Tank", 10);
        SpaceResources food = new SpaceResources("Food Pack", 25);

        // Configure the repository to return the mock data
        Mockito.when(repository.findAll()).thenReturn(Arrays.asList(oxygen, food));

        // Perform GET /resources and verify the response
        mockMvc.perform(get("/resources"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].name").value("Oxygen Tank"))
                .andExpect(jsonPath("$[1].name").value("Food Pack"));
    }
}
