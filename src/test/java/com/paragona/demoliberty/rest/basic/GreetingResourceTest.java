package com.paragona.demoliberty.rest.basic;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class GreetingResourceTest {
    
    @Test
    void testSayHello() {
        GreetingResource gr = new GreetingResource();
        String response = gr.sayHello();
        System.out.println("*******************   " + response);

        assertEquals("Hello", response);

    }
}
