package denofury;

import java.time.LocalDate;

public class Task {


    private String Title;
    private String description;
    private LocalDate date;

    public Task(){

    }
    public Task(String title, String description, LocalDate date){
        this.Title = title;
        this.description = description;
        this.date = date;

    }

    public void setTitle(String title) {
        Title = title;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return Title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDate() {
        return date;
    }
}
