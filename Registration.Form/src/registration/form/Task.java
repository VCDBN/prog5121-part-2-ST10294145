package registration.form;
import javax.swing.JOptionPane;
/**
 * 
 * @author saihilgurupersad
 */
public class Task {

    public static int taskNumberCounter = 1;
    public static int totalHours = 0;
    public String taskName;
    public int taskNumber;
    public String taskDescription;
    public String developerDetails;
    public int taskDuration;
    public String taskID;
    public String taskOptions;

    public void TaskStatus() {
        taskNumber = taskNumberCounter++;
        String[] options = { "To Do", "Doing", "Done" };
        int choice = JOptionPane.showOptionDialog(null, "Select an option:", "Task Status",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

        if (choice == 0) {
            taskOptions = "To Do";
        } else if (choice == 1) {
            taskOptions = "Doing";
        } else if (choice == 2) {
            taskOptions = "Done";
        } else {
            taskOptions = "No option selected";
        }
    }

    public boolean checkTaskDescription() {
        //Create a restriction of 50 characters for task description 
        int size = taskDescription.length();

        if (size > 50) {
            JOptionPane.showMessageDialog(null, "Please enter a task description of 50 characters or less.");
            return false;
        }

        JOptionPane.showMessageDialog(null, "Task successfully captured.");
        return true;
    }

    //Create a method that displays all required information in the correct format
    public String createTaskID() {
        String initials = taskName.substring(0, Math.min(2, taskName.length())).toUpperCase();
        String lastThreeLetters = developerDetails.substring(developerDetails.length() - Math.min(3, developerDetails.length())).toUpperCase();
        taskID = initials + ":" + taskNumber + ":" + lastThreeLetters;
        return taskID;
    }

    String printTaskDetails() {
        String message = "Task Status: " + taskOptions + "\n" + "Developer Details: " + developerDetails + "\n" + "Task Number: " + taskNumber + "\n" + "Task Name: " + taskName + "\n" + "Task Description: "+ taskDescription + "\n" + "Task ID: " + taskID + "\n" + "Task Duration: " + taskDuration + " hours";
        JOptionPane.showMessageDialog(null, message, "Task Details", JOptionPane.INFORMATION_MESSAGE);
        return null;
    }

    public static int returnTotalHours() {
        //this displays the total amount of hours it will take the developer to complete all their tasks combined
        return totalHours;
    }

    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Welcome to EasyKanban");

        int choice;
        int numTasks;
        boolean loggedIn = false;

        // Simulating login
        while (!loggedIn) {
            // Perform login and set loggedIn to true if successful
            loggedIn = true;
        }

        do {
            choice = Integer.parseInt(JOptionPane.showInputDialog(
                    "Menu:\n" + "1) Add tasks\n" + "2) Show report\n" + "3) Quit"));

            switch (choice) {
                case 1:
                    numTasks = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of tasks:"));

                    for (int i = 0; i < numTasks; i++) {
                        Task task = new Task();

                        task.taskName = JOptionPane.showInputDialog("Enter task name:"); // Added input for task name
                        //Added input for the task description with a note of character limit
                        task.taskDescription = JOptionPane.showInputDialog("Enter task description:\n Note: Task description is limited to 50 characters.");
                        //Added input for the Developer Details with a note satating fullname
                        task.developerDetails = JOptionPane.showInputDialog("Enter developer details:\n Note: Enter full name.");
                        task.taskDuration = Integer.parseInt(JOptionPane.showInputDialog("Enter task duration in hours:"));

                        if (task.checkTaskDescription()) {
                            task.TaskStatus(); // Call TaskStatus to set taskOptions
                            task.createTaskID();
                            task.printTaskDetails();
                            totalHours += task.taskDuration;
                        } else {
                            i--; // Retry entering the task details
                        }
                    }
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "Coming Soon", "Show Report",JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Exiting the application");
                    JOptionPane.showMessageDialog(null, "Will now display total hours.");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid choice", "Error", JOptionPane.ERROR_MESSAGE);
                    break;
            }
        } while (choice != 3);

        JOptionPane.showMessageDialog(null, "Total combined hours of all tasks: " + totalHours + " Hours ","Total Hours", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showInternalMessageDialog(null, "Good Bye!","Final exit page", JOptionPane.INFORMATION_MESSAGE);
    }
}
