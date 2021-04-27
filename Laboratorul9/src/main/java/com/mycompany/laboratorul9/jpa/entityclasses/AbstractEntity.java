/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.laboratorul9.jpa.entityclasses;

import com.mycompany.laboratorul9.jpa.singleton.EntityManagerSingleton;
import javax.persistence.Id;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.MappedSuperclass;
import javax.persistence.Query;

/**
 *
 * @author Radu
 */
@MappedSuperclass
public abstract class AbstractEntity implements Serializable {

    @Id
    @Basic(optional = false)
    protected Long id;

    protected String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
