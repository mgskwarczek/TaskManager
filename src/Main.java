//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.io.IOException;



public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //task list initialization
        TaskList taskList = new TaskList();

        String ans;
        do {
            System.out.println("Let's organize your work & life!");

            //adding new task
            System.out.println("Do you want add new task? (Y/n)");
            ans = scanner.nextLine().toUpperCase();
            if(ans.equals("Y")) {
                Task newTask = createTask(scanner);
                taskList.addTask((newTask));
            }

            //showing task
            System.out.println("Show tasks? (Y/n)");
            ans = scanner.nextLine().toUpperCase();
            if(ans.equals("Y")) {
                taskList.showTask();
            }

            //removing task
            System.out.println("Remove a task? (Y/n)");
            ans = scanner.nextLine().toUpperCase();
            if (ans.equals("Y")){
                System.out.println("Enter the title of the task to remove: ");
                String titleToRemove = scanner.nextLine();
                taskList.removeTask(titleToRemove);
            }

            //completed or not
            System.out.println("Mark a task as completed? (Y/n)");
            ans = scanner.nextLine().toUpperCase();
            if(ans.equals("Y")) {
                System.out.println("Enter the title of the task to mark as");
                String titleToMark = scanner.nextLine();
                taskList.markAsCompleted(titleToMark);
            }

            //saving
            System.out.println("Save tasks to file? (Y/n");
            ans = scanner.nextLine().toUpperCase();
            if(ans.equals("Y")) {
                System.out.println("Enter the file path to save tasks: ");
                String filePath = scanner.nextLine();
                try {
                    taskList.saveToFile(filePath);
                } catch (IOException e) {
                    System.err.println("Error occurred while saving tasks to file: ");
                }
            }

            //loading
            System.out.println("Load tasks to file? (Y/n)");
            ans = scanner.nextLine().toUpperCase();
            if(ans.equals("Y")){
                //System.out.println("Enter the file path to load tasks:");
                String filePath = scanner.nextLine();
                try {
                    taskList.loadFromFile(filePath);
                } catch (IOException e ) {
                    System.err.println("Error occured while loading tasks from file: ");
                }
            }
        } while (ans.equals("Y"));

        System.out.println("See you soon!");
    }

    static Task createTask (Scanner scanner) {
        try {
            System.out.println("Title of task: ");
            String title = scanner.nextLine();

            System.out.println("Description: ");
            String description = scanner.nextLine();

            System.out.println("Date for task completion: (format: yyyy-MM-dd");
            String deadline = scanner.nextLine();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            dateFormat.parse(deadline); //validate format

            return new Task(title, description, deadline, false);
        } catch (ParseException e) {
            System.err.println("Invalid date format. Please use yyyy-MM-dd.");
            return null; //handle invalid format
        }
    }
}
