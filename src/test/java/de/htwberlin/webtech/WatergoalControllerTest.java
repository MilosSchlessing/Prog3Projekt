package de.htwberlin.webtech;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.htwberlin.webtech.classes.Watergoal;
import de.htwberlin.webtech.classes.WatergoalController;
import de.htwberlin.webtech.classes.WatergoalService;
import de.htwberlin.webtech.classes.WebtechApplication;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = WebtechApplication.class)
@AutoConfigureMockMvc
public class WatergoalControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private WatergoalService service;

    private Watergoal watergoal;
    private ObjectMapper mapper;

    @BeforeEach
    public void setUp() {
        watergoal = new Watergoal();
        watergoal.setMl(500);

        mapper = new ObjectMapper();
    }

    @Test
    public void testCreateWatergoal() throws Exception {
        when(service.save(any(Watergoal.class))).thenReturn(watergoal);

        String expected = mapper.writeValueAsString(watergoal);

        mockMvc.perform(post("/watergoal")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(watergoal)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(containsString(expected)));
    }

    @Test
    public void testGetWatergoal() throws Exception {
        when(service.get(anyLong())).thenReturn(watergoal);

        String expected = mapper.writeValueAsString(watergoal);

        mockMvc.perform(get("/watergoal/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(containsString(expected)));
    }

    @Test
    public void testGetAllThings() throws Exception {
        List<Watergoal> watergoals = Arrays.asList(watergoal);
        when(service.getAll()).thenReturn(watergoals);

        String expected = mapper.writeValueAsString(watergoals);

        mockMvc.perform(get("/watergoal"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(containsString(expected)));
    }

    @Test
    public void testUpdateWatergoal() throws Exception {
        when(service.get(anyLong())).thenReturn(watergoal);
        when(service.save(any(Watergoal.class))).thenReturn(watergoal);

        String expected = mapper.writeValueAsString(watergoal);

        mockMvc.perform(put("/watergoal/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(watergoal)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(containsString(expected)));
    }
}