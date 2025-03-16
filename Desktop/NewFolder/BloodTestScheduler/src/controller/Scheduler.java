package controller;
import model.Patient;
import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

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

   // Stores last 5 NoShow patients
private LinkedList<Patient> noShowList = new LinkedList<>();

// Adds a patient to the NoShow list (keeps only last 5)
public void addNoShow(Patient patient) {
    if (noShowList.size() >= 5) {
        noShowList.removeFirst();
    }
    noShowList.add(patient);
}

// Retrieves the list of NoShow patients
public List<Patient> getNoShowPatients() {
    return new ArrayList<>(noShowList);
}

public List<Patient> getPatients() {
    return new ArrayList<>(queue); // Converts PriorityQueue to List
}
public Patient peekNextPatient() {
    return queue.peek(); // This retrieves the next patient without removing them
}
public int countPatientsRecursive(PriorityQueue<Patient> tempQueue) {
    if (tempQueue.isEmpty()) return 0; // Base case: If queue is empty, return 0
    Patient removed = tempQueue.poll(); // Remove one patient
    int count = 1 + countPatientsRecursive(tempQueue); // Recursive call
    tempQueue.add(removed); // Restore the removed patient to maintain data integrity
    return count;
}
}