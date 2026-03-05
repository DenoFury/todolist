package denofury;

import java.time.LocalDate;

public class Task {


    private String Title;
    private String description;
    private LocalDate date;

    public Task(String title, String description, LocalDate date){
        this.Title = title;
        this.description = description;
        this.date = date;

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
