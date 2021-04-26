/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.laboratorul9.jdbc.daointerface;

import com.mycompany.laboratorul9.jdbc.domain.Genre;
import java.util.List;

/**
 *
 * @author Radu
 */
public interface GenreDao {

    public List<Genre> getAllGenres();

    public Genre getGenre(int id);

    public void updateGenre(Genre genre);

    public void deleteGenre(Genre genre);
}