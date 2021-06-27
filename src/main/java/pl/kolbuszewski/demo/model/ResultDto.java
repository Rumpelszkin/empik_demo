package pl.kolbuszewski.demo.model;

public class ResultDto {

    private long id;
    private String login;
    private String name;
    private String type;
    private String avatarUrl;
    private String createdAt;
    private double calculations;

    public ResultDto(long id, String login, String name, String type, String avatarUrl, String createdAt) {
        this.id = id;
        this.login = login;
        this.name = name;
        this.type = type;
        this.avatarUrl = avatarUrl;
        this.createdAt = createdAt;
    }

    public void setCalculations(double calculations) {
        this.calculations = calculations;
    }

    public long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public double getCalculations() {
        return calculations;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
