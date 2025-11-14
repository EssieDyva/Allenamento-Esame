package com.esamejava.demo.controlers;


import com.esamejava.demo.models.Film;
import com.esamejava.demo.repository.FilmRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("api/film")
public class FilmController {
    @GetMapping("selezionaFilm")
    public List<Film> selezionaUtenti() throws SQLException{
        List<Film> listaFilm = FilmRepository.getAllFilm();
        return listaFilm;
    }

}
