package registration.form;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TaskTest {
    
    public TaskTest() {
        
    }

    @Test
    public void testCheckTaskDescription() {
        Task testData = new Task(); // Create instance within the test method
        
        String description1 = "Create a Login feature to authenticate users";
        String expected = "Task successfully captured";
        String actual = testData.checkTaskDescription(description1)
                ? "Task successfully captured"
                : "Please enter a task description that does not exceed 50 characters";
        
        assertEquals(expected, actual);
    }

    @Test
    public void testCreateTaskID() {
        Task testData = new Task(); // Create instance within the test method
        
        String taskName1 = "Login Feature";
        String DEVELOPER_NAME1 = "Robyn";
        String DEVELOPER_SURNAME1 = "Harrison";
        String taskStatus1 = "To do";
        int taskNumber1 = 0;
        String expected1 = "LO:0:SON";
        String actual1 = testData.createTaskID(taskName1, taskNumber1, DEVELOPER_NAME1, DEVELOPER_SURNAME1, taskStatus1);
        
        assertEquals(expected1, actual1);
    
        String taskName2 = "Add Task Feature";
        String DEVELOPER_NAME2 = "Mike";
        String DEVELOPER_SURNAME2 = "Smith";
        String taskStatus2 = "Doing";
        int taskNumber2 = 1;
        String expected2 = "AD:1:ITH";
        String actual2 = testData.createTaskID(taskName2, taskNumber2, DEVELOPER_NAME2, DEVELOPER_SURNAME2, taskStatus2); 
        
        assertEquals(expected2, actual2);
    }

    @Test
    public void testPrintTaskDetails() {
        // Add test logic and assertions for printing task details
    }

    @Test
    public void testReturnTotalHours() {
        Task testData = new Task(); // Create instance within the test method
        
        int taskDuration1 = 8;
        int taskDuration2 = 10;
        testData.returnTotalHours(taskDuration1);
        testData.returnTotalHours(taskDuration2);
        int expectedHours = 18;   
        int actualHours = testData.displayTotalHours();
      
        assertEquals(expectedHours, actualHours);
    }

    @Test
    public void testDisplayTotalHours() {
        // Add test logic and assertions for displaying total hours
    }
    
}
