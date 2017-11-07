package ee.pri.sanders.musiccatalog;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Stream;

import org.junit.Test;

import ee.pri.sanders.musiccatalog.dao.ArtistDAO;
import ee.pri.sanders.musiccatalog.model.Artist;
import ee.pri.sanders.musiccatalog.model.Track;

public class ModelTest {

  @Test
  public void testArtist() {
    Artist artist = new Artist("Pink Floyd", "GB");
    System.out.println("Artist: " + artist);
    
    
    List<Track> tracks = Arrays.asList(
        new Track("Pink Floyd", "Another Brick in the Wall", 131),
        new Track("Pink Floyd", "The Post War Dream", 182),
        new Track("Pink Floyd", "Southampton Dock", 133)
    );
    
    Stream<Integer> stream = tracks.stream().map(track -> track.getLength());
    
    tracks.stream()
      .map(track -> track.getLength())
      .forEach(System.out::println);
    
    tracks.stream()
      .mapToInt(track -> track.getLength())
      .sum();
    
    // Print out all countries
    String[] locales = Locale.getISOCountries();
    Arrays.asList(locales).stream()
      .forEach(a -> {
        Locale l = new Locale("", a);
        System.out.println(a + " -> " + l.getDisplayCountry());
      }
      );
    
    System.out.println(new Locale("", "EE").getDisplayCountry());
    
//    List<Artist> artists = new ArtistDAO().getArtists();
//    artists.stream().forEach(System.out::println);
  }

}