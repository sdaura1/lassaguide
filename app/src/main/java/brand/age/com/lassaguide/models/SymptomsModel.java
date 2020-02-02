package brand.age.com.lassaguide.models;

public class SymptomsModel {

    String title;
    String body;

    public SymptomsModel() {
    }

    public SymptomsModel(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public String getName() {
        return title;
    }

    public void setName(String title) {
        this.title = title;
    }

    public String getNumber() {
        return body;
    }

    public void setNumber(String body) {
        this.body = body;
    }
}
