import application.web.MainController;
import application.Start;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.HttpSessionRequiredException;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

/**
 * Created by MSI on 16.08.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Start.class)
public class MockTests {

    @Autowired
    private MainController mainController;

    @Test
    public void login() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(this.mainController).build();
        mockMvc.perform(get("/"))
                .andExpect(status().isOk());

    }

    @Test
    public void checkMenu() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(this.mainController).build();
        try {
            mockMvc.perform(get("/viewCart"));
        } catch (HttpSessionRequiredException noClient) {
            System.out.println("No \"client\" session attribute");
        }
    }
}
