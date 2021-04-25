/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.laboratorul9.jdbc.daointerface;

import com.mycompany.laboratorul9.jdbc.domain.Actor;
import java.util.List;

/**
 *
 * @author Radu
 */
public interface ActorDao {

    public List<Actor> getAllActors();

    public Actor getActor(int id);

    public void updateActor(Actor actor);

    public void deleteActor(Actor actor);
}
