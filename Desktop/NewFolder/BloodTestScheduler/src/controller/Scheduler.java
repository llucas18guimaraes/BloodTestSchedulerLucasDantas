package controller;
import model.Patient;
import java.util.PriorityQueue;
import java.util.Comparator;

/**
 *
 * @author lucasguimaraes
 */

public class Scheduler implements Schedulable {
    private PriorityQueue<Patient> queue;

    public Scheduler() {
        this.queue = new PriorityQueue<>(new Comparator<Patient>() {
            @Override
            public int compare(Patient p1, Patient p2) {
                // Compare patients based on priority, hospital status, and age
                int priorityOrder = getPriorityValue(p1.getPriority()) - getPriorityValue(p2.getPriority());
                if (priorityOrder != 0) {
                    return priorityOrder; // Higher priority first
                }

                // If priority is the same, hospital patients go first
                if (p1.isFromHospital() && !p2.isFromHospital()) {
                    return -1; // p1 goes first
                }
                if (!p1.isFromHospital() && p2.isFromHospital()) {
                    return 1; // p2 goes first
                }

                // If both have the same priority and hospital status, older patients go first
                return Integer.compare(p2.getAge(), p1.getAge());
            }

            private int getPriorityValue(String priority) {
                switch (priority) {
                    case "Urgent": return 1;
                    case "Medium": return 2;
                    case "Low": return 3;
                    default: return 4; //  lowest priority
                }
            }
        });
    }

    @Override
    public void addPatient(Patient patient) {
        queue.add(patient);
    }

    @Override
    public Patient getNextPatient() {
        return queue.poll();
    }

    // To Test the priority queue sorting 
    public static void main(String[] args) {
        Scheduler scheduler = new Scheduler();

        // Adding patients with different priorities to test
        scheduler.addPatient(new Patient("Alice", "Urgent", 65, "Dr. Smith", false));
        scheduler.addPatient(new Patient("Bobe", "Medium", 45, "Dr. Eoin", false));
        scheduler.addPatient(new Patient("Lucas", "Low", 30, "Dr. Emma", true)); // From hospital
        scheduler.addPatient(new Patient("Gaby", "Urgent", 50, "Dr. Jack", true)); // Urgent + hospital
        scheduler.addPatient(new Patient("Jorge", "Medium", 75, "Dr. Fran", false));

        // Gets patients based on priority
        System.out.println("Next patient: " + scheduler.getNextPatient());
        System.out.println("Next patient: " + scheduler.getNextPatient());
        System.out.println("Next patient: " + scheduler.getNextPatient());
        System.out.println("Next patient: " + scheduler.getNextPatient());
        System.out.println("Next patient: " + scheduler.getNextPatient());
    }
}
