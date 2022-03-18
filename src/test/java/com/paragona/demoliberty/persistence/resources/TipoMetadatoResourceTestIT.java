package com.paragona.demoliberty.persistence.resources;

import jakarta.json.JsonArray;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TipoMetadatoResourceTestIT {

    private static final Jsonb JSONB = JsonbBuilder.create();

    @Test
    public void testFinfAll(){
        String port = "9080";
        String context = "simple-liberty-app";
        String url = "http://localhost:" + port + "/" + context + "/";

        Client client = ClientBuilder.newClient();

        WebTarget target = client.target(url + "api/db-metadati");
        Response response = target.request().get();

        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus(),
                "Incorrect status code from " + url);

        String json = response.readEntity(String.class);
        JsonArray result = JSONB.fromJson(json, JsonArray.class);

        assertFalse( result.isEmpty() );

        response.close();
    }

}