package fr.jee.reddit.groupeg.repositories;
import fr.jee.reddit.groupeg.models.Subject;
import fr.jee.reddit.groupeg.models.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SubjectRepository extends PagingAndSortingRepository<Subject,Long> {
    public List<Subject> findSubjectByUser(User user);
    List<Subject> findAllByVote(int vote, Pageable pageable);
}
