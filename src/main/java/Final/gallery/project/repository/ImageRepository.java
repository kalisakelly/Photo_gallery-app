package Final.gallery.project.repository;


import Final.gallery.project.Model.image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<image, Long> {

    image findByName(String text);

    image findFirstByName(String text);

}
