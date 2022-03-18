package com.paragona.demoliberty.persistence.models;


import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "TIPO_METADATO")
@NamedQuery(name = "TipoMetadato.findAll", query = "SELECT tm FROM TipoMetadato tm")
public class TipoMetadato implements Serializable {

    @Id
    @Column(name = "SEQU_LONG_ID")
    private Integer id;
    @Column(name = "TIPO")
    private String tipo;

    public TipoMetadato() {}

    public TipoMetadato(Integer id, String tipo) {
        this.id = id;
        this.tipo = tipo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TipoMetadato that = (TipoMetadato) o;
        return id.equals(that.id) && tipo.equals(that.tipo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tipo);
    }
}
