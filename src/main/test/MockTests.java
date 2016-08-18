import application.MainController;
import application.Service;
import application.Start;
import model.entities.Client;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.HttpRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.HttpSessionRequiredException;

import javax.servlet.http.HttpSession;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;
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

  //  @Autowired
  //  private Service service;



    @Test
    public void login() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(this.mainController).build();
        mockMvc.perform(get("/"))
                .andExpect(status().isOk());
           //     .andExpect(request().sessionAttribute());
        ;
    }

    @Test
    public void checkMenu() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(this.mainController).build();
        try
        {mockMvc.perform(get("/viewCart"));
        }
        catch(HttpSessionRequiredException noClient)
        {
            System.out.println("No \"client\" session attribute");
        }
    }
}
