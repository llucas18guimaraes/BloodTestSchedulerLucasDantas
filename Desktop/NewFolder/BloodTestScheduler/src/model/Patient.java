/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author lucasguimaraes
 */
public class Patient {
    private String name;
    private String priority; // Urgent, Medium, Low
    private int age;
    private String gpDetails; // details
    private boolean fromHospital; // True if coming from a hospital

    // Constructor: Initializes a patient object
    public Patient(String name, String priority, int age, String gpDetails, boolean fromHospital) {
        this.name = name;
        this.priority = priority;
        this.age = age;
        this.gpDetails = gpDetails;
        this.fromHospital = fromHospital;
    }

    // Getters: Allow access to private variables
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

    // Setters: Allow modifying private variables
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
