package ee.pri.sanders.musiccatalog.model;

public class Track {
  
  private String name;
  
  // TODO create artist type
  private String artist;
  
  private int lengthSeconds;
  
  public Track(String name, String artist, int length) {
    this.name = name;
    this.artist = artist;
    this.lengthSeconds = length;
  }

  public int getLength() {
    return this.lengthSeconds;
  }
}
