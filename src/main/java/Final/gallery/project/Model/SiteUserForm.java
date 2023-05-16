package Final.gallery.project.Model;

public class SiteUserForm {

    private String name;

    private String profile;


    private String password;

    public SiteUserForm(){}

    public SiteUserForm(String name, String profile, String password) {
        this.name = name;
        this.profile = profile;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }

}
