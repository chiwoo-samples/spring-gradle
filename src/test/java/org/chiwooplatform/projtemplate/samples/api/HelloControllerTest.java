package org.chiwooplatform.projtemplate.samples.api;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringJUnitWebConfig
@WebMvcTest(controllers = { HelloController.class })
public class HelloControllerTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired protected MockMvc mvc;

    /**
     * {@link HelloController#hello()}
     */
    @Test
    void ut_hello_success() throws Exception {
        assertNotNull(mvc);
        mvc.perform(get("/hello").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andDo(print());
    }

    /**
     * {@link HelloController#greeting(String)}
     */
    @Test
    void ut_greeting_success() throws Exception {
        mvc.perform(get("/greeting").param("name", "simple Sims").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Nice to meet you simple Sims")).andDo(print());
    }

    /**
     * {@link HelloController#query(String)}
     */
    @Test
    void ut_query_success() throws Exception {
        mvc.perform(get("/query").param("name", "").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                .andExpect(jsonPath("$[0].message").value("Nice to meet you Sims")).andDo(print());
    }
}
