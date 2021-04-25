/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.laboratorul9.jdbc.daoimplementations;

import com.mycompany.laboratorul9.jdbc.singleton.DbConnection;
import com.mycompany.laboratorul9.jdbc.domain.Actor;
import com.mycompany.laboratorul9.jdbc.daointerface.ActorDao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Radu
 */
public class ActorDaoImpl implements ActorDao {

    List<Actor> actors = new ArrayList<>();
    DbConnection connection;
    private final String querryAllActors = "select * from actors";

    public ActorDaoImpl(DbConnection connection) {
        this.connection = connection;
        Statement stmt = connection.getStmt();
        ResultSet rset;
        //get all actors from database
        try {
            rset = stmt.executeQuery(querryAllActors);
            while (rset.next()) {
                int id = rset.getInt("id_actor");
                String firstName = rset.getString("first_name");
                String lastName = rset.getString("last_name");
                actors.add(new Actor(id, firstName, lastName));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public List<Actor> getAllActors() {
        return new ArrayList<>(actors);
    }

    @Override
    public Actor getActor(int id) {
        for (Actor actor : actors) {
            if (actor.getId() == id) {
                return actor;
            }
        }
        return null;
    }

    @Override
    public void updateActor(Actor actor) {
        for (Actor actorFromList : actors) {
            if (actorFromList.getId() == actor.getId()) {
                int index = actors.indexOf(actorFromList);
                actors.set(index, actor);

                //update in database
                String dmlStatement = "UPDATE actors SET first_name = ?, "
                        + "last_name = ? WHERE id_actor = ?";
                try {
                    var pstmt = connection.getConnection().prepareStatement(dmlStatement);
                    pstmt.setString(1, actor.getFirstName());
                    pstmt.setString(2, actor.getLastName());
                    pstmt.setInt(3, actor.getId());
                    pstmt.executeUpdate();
                } catch (SQLException ex) {
                    System.out.println(ex);
                }
            }
        }
    }

    @Override
    public void deleteActor(Actor actor) {
        boolean isDeleted = actors.remove(actor);
        PreparedStatement pstmt = null;
        if (isDeleted) //delete from the database
        {
            String dmlStatement = "DELETE FROM actors WHERE id_actor = ?";
            try {
                pstmt = connection.getConnection().prepareStatement(dmlStatement);
                pstmt.setInt(1, actor.getId());
                pstmt.executeUpdate();
            } catch (SQLException ex) {
                System.out.println(ex);
            }

        }
    }

}
