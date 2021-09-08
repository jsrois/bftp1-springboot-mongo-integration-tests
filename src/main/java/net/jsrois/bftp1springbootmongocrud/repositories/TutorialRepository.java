package net.jsrois.bftp1springbootmongocrud.repositories;

import net.jsrois.bftp1springbootmongocrud.models.Tutorial;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TutorialRepository extends MongoRepository<Tutorial, String> {
    List<Tutorial> findByPublished(boolean published);
    List<Tutorial> findByTitleContaining(String title);
}