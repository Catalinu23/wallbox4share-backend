package app.repository;

import app.entity.User;
import app.entity.Wallbox;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WallboxRepository extends JpaRepository<Wallbox,Long> {
}
