package Final.gallery.project.repository;


import Final.gallery.project.Model.SiteUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SiteUserRepository extends JpaRepository<SiteUser,Long> {
    Optional<SiteUser> findByName(String name);

}
