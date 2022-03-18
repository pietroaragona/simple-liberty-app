package com.paragona.demoliberty.persistence.resources;

import com.paragona.demoliberty.persistence.dao.TipoMetadatoDao;
import com.paragona.demoliberty.persistence.models.TipoMetadato;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonObjectBuilder;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@RequestScoped
@Path("db-metadati")
public class TipoMetadatoResource {

    @Inject
    TipoMetadatoDao tipoMetadatoDao;


    /**
     * This method returns the existing/stored events in Json format
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public JsonArray getEvents() {
        JsonObjectBuilder builder = Json.createObjectBuilder();
        JsonArrayBuilder finalArray = Json.createArrayBuilder();

        for (TipoMetadato event : tipoMetadatoDao.readAll()) {
            builder.add("tipo", event.getTipo()).add("id", event.getId());
            finalArray.add(builder.build());
        }
        return finalArray.build();
    }

}
