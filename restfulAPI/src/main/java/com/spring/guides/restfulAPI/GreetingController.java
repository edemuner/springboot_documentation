package com.spring.guides.restfulAPI;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.concurrent.atomic.AtomicLong;


@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name",
                                        defaultValue="World")
                                        String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
}

/*
The @GetMapping annotation ensures that HTTP GET requests to /greeting
 are mapped to the greeting() method.

@RequestParam binds the value of the query string parameter name into
 the name parameter of the greeting() method.
 If the name parameter is absent in the request, the defaultValue of World
  is used.

The implementation of the method body creates and returns a new
Greeting object with id and content attributes based on
the next value from the counter and formats the given name
by using the greeting template.



This code uses Spring @RestController annotation, which marks the class as
 a controller where every method returns a domain object instead of a view.
  It is shorthand for including both @Controller and @ResponseBody.

The Greeting object must be converted to JSON. Thanks to
Spring’s HTTP message converter support, you need not do
this conversion manually. Because Jackson 2 is on the classpath,
Spring’s MappingJackson2HttpMessageConverter is automatically chosen
 to convert the Greeting instance to JSON.

 */