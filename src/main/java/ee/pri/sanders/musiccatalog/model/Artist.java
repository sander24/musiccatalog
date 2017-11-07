package ee.pri.sanders.musiccatalog.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Artist implements Serializable {
  
  @Id
  @GeneratedValue
  private Long id;
  
  @Column(nullable = false)
  private String name;
  
  @Column
  private Integer startYear;
  
  @Column
  private Integer endYear;
  
  // TBD
  // Examples: GB, US, EE
  public String countryCode;
  
  public Artist() {
  }
  
  public Artist(String name, String countryCode) {
    this.setName(name);
    this.countryCode = countryCode;
  }
  
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  } 

  public Integer getEndYear() {
    return endYear;
  }

  public void setEndYear(Integer endYear) {
    this.endYear = endYear;
  }

  public Integer getStartYear() {
    return startYear;
  }

  public void setStartYear(Integer startYear) {
    this.startYear = startYear;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
  
  public String toString() {
    return String.format("%s (%s)", getName(), countryCode);
  }
  
} 