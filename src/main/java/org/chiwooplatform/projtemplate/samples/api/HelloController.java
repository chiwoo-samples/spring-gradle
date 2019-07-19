package org.chiwooplatform.projtemplate.samples.api;

import org.chiwooplatform.projtemplate.samples.message.Greeting;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class HelloController {

    @GetMapping(value = "/hello", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("hello");
    }

    @GetMapping(value = "/greeting", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Greeting> greeting(@RequestParam(name = "name") String name) {
        return ResponseEntity.ok(new Greeting(name, "Nice to meet you " + name));
    }

    @GetMapping(value = "/query", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Greeting>> query(@RequestParam(name = "name") String name) {
        List<Greeting> result = Arrays
                .asList(new Greeting("Sims", "Nice to meet you Sims"), new Greeting("Wooyeon", "Nice to meet you Wooyeon"),
                        new Greeting("Jongseok", "Nice to meet you Jongseok"));
        if (StringUtils.hasText(name)) {
            result = result.stream().filter(p -> p.getName().startsWith(name)).collect(Collectors.toList());
        }
        return ResponseEntity.ok(result);
    }
}
