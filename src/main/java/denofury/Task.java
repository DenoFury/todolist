package denofury;

public class Task {


    private String Title;
    private String description;

    public Task(String title, String description){
        this.Title = title;
        this.description = description;
    }

    public String getTitle() {
        return Title;
    }

    public String getDescription() {
        return description;
    }
}
