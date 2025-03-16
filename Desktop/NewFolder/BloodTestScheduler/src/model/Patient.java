/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author lucasguimaraes
 */
public class Patient implements Comparable<Patient> {
    private String name;
    private String priority; // Urgent, Medium, Low
    private int age;
    private String gpDetails;
    private boolean fromHospital; // True if coming from a hospital

    // Constructor: Initializes a patient object
    public Patient(String name, String priority, int age, String gpDetails, boolean fromHospital) {
        this.name = name;
        this.priority = priority;
        this.age = age;
        this.gpDetails = gpDetails;
        this.fromHospital = fromHospital;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getPriority() {
        return priority;
    }

    public int getAge() {
        return age;
    }

    public String getGpDetails() {
        return gpDetails;
    }

    public boolean isFromHospital() {
        return fromHospital;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGpDetails(String gpDetails) {
        this.gpDetails = gpDetails;
    }

    public void setFromHospital(boolean fromHospital) {
        this.fromHospital = fromHospital;
    }

    @Override
public int compareTo(Patient other) {
    // Compare patients based on priority, hospital status, and age
    int priorityOrder = getPriorityValue(this.priority) - getPriorityValue(other.priority);
    if (priorityOrder != 0) {
        return priorityOrder; // Higher priority first
    }

    // If priority is the same, hospital patients go first
    if (this.fromHospital && !other.fromHospital) {
        return -1; // this patient go first
    }
    if (!this.fromHospital && other.fromHospital) {
        return 1; // oter patient goes first
    }

    // If both have the same priority and hospital status, older patients go first
    return Integer.compare(other.age, this.age);
}

// to assign numerical priority values
private int getPriorityValue(String priority) {
    switch (priority) {
        case "Urgent": return 1;
        case "Medium": return 2;
        case "Low": return 3;
        default: return 4; // Lowest priority
    }
}

    // toString to print patient details
    @Override
    public String toString() {
        return "Patient{" +
                "name='" + name + '\'' +
                ", priority='" + priority + '\'' +
                ", age=" + age +
                ", gpDetails='" + gpDetails + '\'' +
                ", fromHospital=" + fromHospital +
                '}';
    }
}
