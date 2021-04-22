/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.laboratorul9.daointerface;

import com.mycompany.laboratorul9.domain.Director;
import java.util.List;

/**
 *
 * @author Radu
 */
public interface DirectorDao {

    public List<Director> getAllDirectors();

    public Director getDirector(int id);

    public void updateDirector(Director director);

    public void deleteDirector(Director director);
}
