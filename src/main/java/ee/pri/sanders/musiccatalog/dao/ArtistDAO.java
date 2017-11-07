package ee.pri.sanders.musiccatalog.dao;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import ee.pri.sanders.musiccatalog.model.Artist;

// TODO remove - duplicate - this is now done by ArtistRepository
@Component
public class ArtistDAO {
  
  private JdbcTemplate jdbcTemplate;
  
  @Autowired
  public ArtistDAO(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }
  
  public List<Artist> getArtists() {
    
    String name = (String) jdbcTemplate.queryForObject(
        "select 4*5 from dual", String.class);
    System.out.println("4 * 5 = " + name);
    
    System.out.println("Numnber of artists : " + 
        jdbcTemplate.queryForObject(
            "select count(*) from artist", String.class)
    );
    
    return Arrays.asList(
        new Artist("Pink Floyd", "GB"),
        new Artist("Massive Attack", "GB"),
        new Artist("Iron Maiden", "GB")
    );
  }
  
}