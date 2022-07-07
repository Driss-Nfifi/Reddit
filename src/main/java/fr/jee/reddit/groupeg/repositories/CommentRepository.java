package fr.jee.reddit.groupeg.repositories;

import fr.jee.reddit.groupeg.models.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CommentRepository extends CrudRepository<Comment,Long> {
}
