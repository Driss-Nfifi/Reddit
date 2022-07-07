package fr.jee.reddit.groupeg.repositories;

import fr.jee.reddit.groupeg.models.CommentVote;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface VoteCommentRepository extends CrudRepository<CommentVote, String> {
}
