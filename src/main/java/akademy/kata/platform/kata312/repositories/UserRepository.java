package akademy.kata.platform.kata312.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import akademy.kata.platform.kata312.model.User;

@Repository

public interface UserRepository extends JpaRepository<User, Long> {
}
