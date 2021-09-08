package net.jsrois.bftp1springbootmongocrud;

import net.jsrois.bftp1springbootmongocrud.models.Tutorial;
import net.jsrois.bftp1springbootmongocrud.repositories.TutorialRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@AutoConfigureDataMongo
@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Profile("!local")
public class IntegrationTests {

    @Autowired
    private MockMvc server;

    @Autowired
    private TutorialRepository tutorialRepository;

    @AfterEach
    void tearDown() {
        tutorialRepository.deleteAll();
    }

    @Test
    public void returnsTheAvailableTutorials() throws Exception {

        tutorialRepository.saveAll(List.of(
                new Tutorial("Learn Java", "A series of java exercises", true),
                new Tutorial("Learn Django and Python", "introduction to the Django web framework", true)
        ));

        server.perform(get("/api/tutorials"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[*]", hasSize(2)))
                .andExpect(jsonPath("$[0].title", equalTo("Learn Java")))
                .andExpect(jsonPath("$[0].description", equalTo("A series of java exercises")))
                .andExpect(jsonPath("$[0].published", equalTo(true)))
                .andExpect(jsonPath("$[1].title", equalTo("Learn Django and Python")))
                .andExpect(jsonPath("$[1].description", equalTo("introduction to the Django web framework")))
                .andExpect(jsonPath("$[1].published", equalTo(true)));
    }
}
