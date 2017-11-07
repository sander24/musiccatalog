package ee.pri.sanders.musiccatalog.dao;

import org.springframework.data.repository.CrudRepository;

import ee.pri.sanders.musiccatalog.model.Artist;

public interface ArtistRepository extends CrudRepository<Artist, Long> {

//    Page<Artist> findAll(Pageable pageable);
//
//    Artist findByNameAndCountryAllIgnoringCase(String name, String country);

}