package model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Spittle {

    @Id
    @GeneratedValue
    Long id;

    public Spittle() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
