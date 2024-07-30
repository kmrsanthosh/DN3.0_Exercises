public class TaskManagementSystem {
    private static class Node {
        Task task;
        Node next;

        Node(Task task) {
            this.task = task;
            this.next = null;
        }
    }

    private Node head;

    public TaskManagementSystem() {
        this.head = null;
    }

    public void add(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public Task search(int taskId) {
        Node current = head;
        while (current != null) {
            if (current.task.getTaskId() == taskId) {
                return current.task;
            }
            current = current.next;
        }
        return null;
    }

    public void traverse() {
        Node current = head;
        while (current != null) {
            System.out.println(current.task);
            current = current.next;
        }
    }

    public boolean delete(int taskId) {
        if (head == null) {
            return false;
        }
        if (head.task.getTaskId() == taskId) {
            head = head.next;
            return true;
        }
        Node current = head;
        Node prev = null;
        while (current != null && current.task.getTaskId() != taskId) {
            prev = current;
            current = current.next;
        }
        if (current == null) {
            return false;
        }
        prev.next = current.next;
        return true;
    }

    public static void main(String[] args) {
        TaskManagementSystem tms = new TaskManagementSystem();

        // Add
        tms.add(new Task(1, "Complete project proposal", "In Progress"));
        tms.add(new Task(2, "Review code changes", "Pending"));
        tms.add(new Task(3, "Update documentation", "Not Started"));

        // Traverse
        System.out.println("All tasks:");
        tms.traverse();

        // Search
        Task foundTask = tms.search(2);
        System.out.println("\nFound task: " + foundTask);

        // Delete
        boolean deleted = tms.delete(1);
        System.out.println("\nTask deleted: " + deleted);

        // Traverse
        System.out.println("\nTasks after deletion:");
        tms.traverse();
    }
}