package ee.pri.sanders.musiccatalog.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import ee.pri.sanders.musiccatalog.dao.ArtistDAO;
import ee.pri.sanders.musiccatalog.dao.ArtistRepository;
import ee.pri.sanders.musiccatalog.model.Artist;

@Controller
public class ArtistController {
  
  @Autowired
  private ArtistDAO artistDao;
  
  @Autowired
  private ArtistRepository artistRepository;
  
  @RequestMapping(value = "/")
  public String something(Model model) {
    System.out.println("Thymeleaf");
    
    List<Artist> artists = artistDao.getArtists();
    artists.stream().forEach(System.out::println);
    
    artistRepository.findAll();
    
    
    model.addAttribute("thyme", "The Thymeleaf");
    model.addAttribute("artists", artistRepository.findAll());
    return "artists";
  }
}