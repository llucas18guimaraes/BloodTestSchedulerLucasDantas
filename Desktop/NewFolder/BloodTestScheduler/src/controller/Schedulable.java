/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import model.Patient;


/**
 *
 * @author lucasguimaraes
 */
public interface Schedulable {
    // Method to add a patient to the scheduler
    void addPatient(Patient patient);

    // Method to get the next patient based on priority
    Patient getNextPatient();
}
