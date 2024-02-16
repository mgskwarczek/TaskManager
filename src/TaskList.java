import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class TaskList {
    private List<Task> tasks;

    public TaskList() {
        this.tasks = new ArrayList<>();
    }
    public void addTask(Task task){
        tasks.add(task);
    }

    /*
    public void removeTask(Task task){
        tasks.remove(task);
    }
     */

    public void editTask(Task oldTask, Task newTask){
        int index = tasks.indexOf(oldTask);
        if(index != -1){ //gdy znalezione
            tasks.set(index, newTask); //update task
        } else {
            System.out.println("Task not found.");
        }
    }

    // public void markAsCompleted(Task task){
    //   task.markAsCompleted();
    //}
    public void markAsCompleted (String titleToMark) {
        for (Task task : tasks) {
            if(task.getTitle().equals(titleToMark)) {
                task.markAsCompleted();
                return;
            }
        }
        System.out.println("Task with title '" + titleToMark + "' not found.");
    }

    public void showTask(){
        System.out.println("Your to-do list: ");

        for(Task task : tasks){
            System.out.println(task);
            System.out.println("          ");
        }
    }

    public void removeTask(String title) {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getTitle().equals(title)) {
                tasks.remove(i);
                break;
            }
        }
    }

    public void saveToFile(String filePath) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write("Title, Description, Deadline, Completed\n"); // Nagłówek CSV
            for (Task task : this.tasks) {
                writer.write(task.getTitle() + ", " + task.getDescription() + ", " + task.getDeadline() + ", " + task.isCompleted() + "\n");
            }
            writer.flush();
            System.out.println("Task list saved to " + filePath);
        }
    }


    public void loadFromFile(String filePath) throws IOException {
        //tasks.clear(); //?
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(","); // Podział danych z linii

                /*if (data.length != 4) { // Sprawdzenie liczby elementów w tablicy
                    System.err.println("Error in line: " + line);
                    continue;
                }
                 */
                String title = data[0].trim();
                String description = data[1];  //data[1].trim();
                String deadline = data[2]; //? trim?
                boolean completed = Boolean.parseBoolean(data[3]);

                Task task = new Task(title, description, deadline, completed);
                tasks.add(task);
            }
            System.out.println("Task list loaded from " + filePath);
        }
        // tasks.addAll(task);
    }
}
