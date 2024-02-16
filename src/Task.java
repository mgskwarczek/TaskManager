

public class Task {
    private String title; //title of task
    private String description;
    private String deadline;
    private boolean completed;

    public Task(String title,String description, String deadline, boolean completed) {
        this.title = title;
        this.description = description;
        this.deadline = deadline;
        this.completed = completed;
    }

    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public String getDescription(){
        return description;
    }
    public void setDescription(){
        this.description = description;
    }
    public String getDeadline(){
        return deadline;
    }
    public void setDeadline(){
        this.deadline = deadline;
    }
    public boolean isCompleted(){
        return completed;
    }
    public void setCompleted(){
        this.completed = completed;
    }

    //method - Is task completed?
    public void markAsCompleted(){
        this.completed = true;
    }

    public String toString(){
        return "Title: " + title + " "
                + "Description: " + description + " "
                + "Deadline: " + deadline + " "
                + "Completed: " + completed + " ";
    }
}
