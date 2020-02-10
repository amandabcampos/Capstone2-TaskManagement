import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/*
 * 
 * @author amandabcampos
 *
 */

public class TaskManagementApp {

	public static void main(String[] args) {

		Scanner scnr = new Scanner(System.in);
		List<Task> tasks = new LinkedList<>();

		greeting();
		displayMenu();

		boolean looping = true;
		while (looping) {
			int option = Validator.getInt(scnr, "What would you like to do? ", 1, 8);
			switch (option) {
			case 1:
				listTasks(tasks);
				displayMenu();
				break;
			case 2:
				String name = Validator.getString(scnr, "Team Member Name: ");
				String description = Validator.getString(scnr, "Task Description: ");
				Date dueDate = Validator.getDate(scnr, "Due date: dd/mm/yyyy ");
				addTask(tasks, name, description, dueDate);
				displayMenu();
				break;
			case 3:
				if (!tasks.isEmpty()) {
					int number = Validator.getInt(scnr, "Task to be deleted number: ", 1, tasks.size());
					System.out.printf(
							"-------------------------------------------------------------------------------------\n");
					System.out.println(tasks.get(number - 1));
					if (Validator.getString(scnr, "Are you sure? ").startsWith("y")) {
						deleteTask(tasks, number);
						displayMenu();
						break;
					} else {
						displayMenu();
						break;
					}
				} else {
					System.out.println("Task list is empty");
					break;
				}

			case 4:
				if (!tasks.isEmpty()) {
					int index = Validator.getInt(scnr, "Task number: ", 1, tasks.size());
					System.out.printf(
							"-------------------------------------------------------------------------------------\n");
					System.out.println(tasks.get(index - 1));
					if (Validator.getString(scnr, "Are you sure? ").startsWith("y")) {
						markComplete(tasks, index);
						displayMenu();
						break;
					} else {
						displayMenu();
						break;
					}
				} else {
					System.out.println("Task list is empty");
					break;
				}
			case 5:
				if (!tasks.isEmpty()) {
					String memberName = Validator.getString(scnr, "Member name: ");
					displayTaskMember(tasks, memberName);
					displayMenu();
					break;
				} else {
					System.out.println("Task list is empty");
					break;
				}
			case 6:
				if (!tasks.isEmpty()) {
					Date setDueDate = Validator.getDate(scnr, "Due date: dd/mm/yyyy ");
					displayTaskDueDate(tasks, setDueDate);
					displayMenu();
					break;
				} else {
					System.out.println("Task list is empty");
					break;
				}
			case 7:
				if (!tasks.isEmpty()) {
					int index = Validator.getInt(scnr, "Task number: ", 1, tasks.size());
					String newMemberName = Validator.getString(scnr, "New member name: ");
					String newDescription = Validator.getString(scnr, "New description name: ");
					Date newDueDate = Validator.getDate(scnr, "New due date: ");
					editTask(tasks, index, newMemberName, newDescription, newDueDate);
					displayMenu();
					break;
				} else {
					System.out.println("Task list is empty");
					break;
				}

			case 8:
				if (Validator.getString(scnr, "Are you sure? ").startsWith("y")) {
					System.out.print("Have a great day!");
					looping = false;
					break;
				} else {
					displayMenu();
					break;
				}
			}
		}
		scnr.close();

	}

	public static void greeting() {
		System.out.println("Welcome to the Task Management App!");
	}

	public static void displayMenu() {
		System.out.println("\n1. List tasks\n2. Add task\n3. Delete task\n"
				+ "4. Mark task complete\n5. Display tasks for team member\n6. Display tasks before date\n"
				+ "7. Edit task\n8. Quit\n");
	}

	public static void listTasks(List<Task> tasks) {
		if (tasks.isEmpty()) {
			System.out.println("No tasks have been entered.");
		} else {
			System.out.printf("\n%18s  %15s  %15s  %30s\n", "Team Member Name", "Due Date", "Done?", "Description");

			System.out
					.println("-------------------------------------------------------------------------------------\n");
			for (Task task : tasks) {
				System.out.println((tasks.indexOf(task) + 1) + ". " + task);
			}
		}
	}

	public static void addTask(List<Task> tasks, String name, String description, Date dueDate) {
		if (!tasks.isEmpty()) {
			for (Task task : tasks) {
				if (task.getTeamMemberName().equals(name) && task.getDescription().equals(description)
						&& task.getDueDate().equals(dueDate)) {
					System.out.println("Task already exists");
					break;
				}
			}
		}
		Task newTask = new Task(name, description, dueDate);
		tasks.add(newTask);
		System.out.println("\nTask entered!");

	}

	public static void deleteTask(List<Task> tasks, int index) {
		tasks.remove(index - 1);
		System.out.println("Task " + index + " deleted!");
	}

	public static void markComplete(List<Task> tasks, int number) {
		if (!tasks.get(number - 1).isCompletionStatus()) {
			tasks.get(number - 1).setCompletionStatus(true);
			System.out.println("Task " + number + " is now completed. Good job!");
		} else {
			System.out.println("Task was already completed");
		}

	}

	public static void displayTaskMember(List<Task> tasks, String name) {
		int i = 0;
		System.out.printf("-------------------------------------------------------------------------------------\n");
		for (Task task : tasks) {
			if (task.getTeamMemberName().toLowerCase().equals(name)) {

				System.out.println(task);
				i++;
			}
		}
		if (i == 0) {
			System.out.println("Member not found");
			System.out.printf("-------------------------------------------------------------------------------------");
		}

	}

	public static void editTask(List<Task> tasks, int index, String name, String description, Date dueDate) {
		tasks.get(index - 1).setTeamMemberName(name);
		tasks.get(index - 1).setDescription(description);
		tasks.get(index - 1).setDueDate(dueDate);
		tasks.get(index - 1).setCompletionStatus(false);
		System.out.println("Task " + index + " was updated");
	}

	public static void displayTaskDueDate(List<Task> tasks, Date dueDate) {
		int i = 0;
		System.out.printf("-------------------------------------------------------------------------------------\n");
		for (Task task : tasks) {
			if (task.getDueDate().compareTo(dueDate) <= 0) {
				System.out.println(task);
				i++;
			}
		}
		if (i == 0) {
			System.out.println("No tasks before such date");
			System.out.printf("-------------------------------------------------------------------------------------");
		}
	}

}
