package com.paragona.demoliberty.persistence.dao;

import com.paragona.demoliberty.persistence.models.TipoMetadato;
import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@RequestScoped
public class TipoMetadatoDao {

    @PersistenceContext(name = "jpa-unit")
    private EntityManager em;

    public List<TipoMetadato> readAll() {
        return em.createNamedQuery("TipoMetadato.findAll", TipoMetadato.class).getResultList();
    }
}
