package integration;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class ReportsControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetMovesByAccountAndDate() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/reports")
                .param("accountId", "123")
                .param("startDate", "2023-01-01")
                .param("endDate", "2023-01-31")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").isArray());
    }
}
