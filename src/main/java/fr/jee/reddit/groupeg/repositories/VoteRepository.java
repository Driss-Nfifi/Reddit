package fr.jee.reddit.groupeg.repositories;

import fr.jee.reddit.groupeg.models.Vote;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoteRepository extends CrudRepository<Vote, String> {

}
