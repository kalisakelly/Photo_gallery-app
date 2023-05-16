package Final.gallery.project.Model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class SiteUser {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String name;

    private String password;

    private boolean enabled;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<image> imageList;

    public SiteUser() {
    }

    public SiteUser(String name, String password, boolean enabled) {
        this.name = name;
        this.password = password;
        this.enabled = enabled;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Set<image> getImageList() {
        return imageList;
    }

    public void setImageList(Set<image> imageList) {
        this.imageList = imageList;
    }
}





