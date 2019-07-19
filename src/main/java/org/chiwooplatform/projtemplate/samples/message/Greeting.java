package org.chiwooplatform.projtemplate.samples.message;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Greeting {

    private String name;

    private String message;

    public Greeting() {
        super();
    }

    public Greeting(String name, String message) {
        super();
        this.name = name;
        this.message = message;
    }
}
