package com.paragona.demoliberty.rest.basic;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Properties;

import org.junit.jupiter.api.Test;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.Response;

public class SystemResourceIT {

    private static final Jsonb JSONB = JsonbBuilder.create();

    @Test
    void testGetProperties() {
        String port = "9080";
        String context = "simple-liberty-app";
        String url = "http://localhost:" + port + "/" + context + "/";

        Client client = ClientBuilder.newClient();

        WebTarget target = client.target(url + "api/properties");
        Response response = target.request().get();

        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus(),
            "Incorrect status code from " + url);

        String json = response.readEntity(String.class);
        Properties sys = JSONB.fromJson(json, Properties.class);

        assertEquals(System.getProperty("os.name"), sys.getProperty("os.name"), 
            "The system property for the local and remote JVM should match");

        response.close();
    }
}
