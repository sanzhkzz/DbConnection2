package com.company;

import com.company.controllers.TrainController;
import com.company.entities.Locomotive;
import com.company.entities.Train;
import com.company.repositories.interfaces.ILocomotiveRepository;
import com.company.repositories.interfaces.ITrainRepository;

import java.util.Scanner;

public class TrainFrontend {
    private final TrainController controller;
    private final Scanner scanner;

    public TrainFrontend(ITrainRepository repo , ILocomotiveRepository locomotiveRepo){
        this.controller=new TrainController(repo, locomotiveRepo) ;
        this.scanner=new Scanner(System.in) ;
    }

    public void start() {
        while (true) {
            System.out.println();
            System.out.println("Welcome to My Application");
            System.out.println("Select option:");
            System.out.println("1. Get all trains");
            System.out.println("2. Get train by id");
            System.out.println("3. Create train");
            System.out.println("4. Get capacity by train id");
            System.out.println("5. Create locomotive");
            System.out.println("6. Get locomotive by id");
            System.out.println("7. Get all locomotives");
            System.out.println("0. Exit");
            System.out.println();
            try {
                System.out.print("Enter option (1-7): ");
                int option = scanner.nextInt();
                if (option == 1) {
                    getAllTrainsMenu();
                } else if (option == 2) {
                    getTrainByIdMenu();
                } else if (option == 3) {
                    createTrainMenu();
                } else if (option == 4) {
                    getTrainCapacityByIdMenu();
                } else if (option == 5) {
                    createLocomotiveMenu();
                } else if (option == 6) {
                    getLocomotiveByIdMenu();
                } else if (option == 7) {
                    getAllLocomotivesMenu();

                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                scanner.next(); // to ignore incorrect input
            }

            System.out.println("*************************");

        }
    }

    public void getAllTrainsMenu() {
        String response = controller.getAllTrains();
        System.out.println(response);
    }

    public void getTrainByIdMenu() {
        System.out.println("Please enter id");

        int id = scanner.nextInt();
        Train train = controller.getTrain(id);
        String response = (train == null ? "Train was not found!" : train.toString());
        System.out.println(response);
    }

    public void createTrainMenu() {
        System.out.println("Please enter name");
        String name = scanner.next();
        System.out.println("Please enter number");
        String number = scanner.next();
        System.out.println("Please enter capacity ");
        int capacity  = scanner.nextInt();

        String response = controller.createTrain(name, number, capacity);
        System.out.println(response);
    }

    public void getTrainCapacityByIdMenu() {
        System.out.println("Please enter id");

        int id = scanner.nextInt();

        Train train = controller.getTrain(id);
        String response = (train == null ? "Train was not found!" : "" + train.getCapacity());
        System.out.println(response);
    }

    public void createLocomotiveMenu() {
        System.out.println("Please enter train_id");
        int train_id = scanner.nextInt();
        if(controller.getTrain(train_id).getId() < 1){
            return;
        }
        System.out.println("Please enter name");
        String name = scanner.next();



        String response = controller.createLocomotive(name, train_id);
        System.out.println(response);
    }

    public void getLocomotiveByIdMenu() {
        System.out.println("Please enter id");

        int id = scanner.nextInt();
        String response = controller.getLocomotive(id);

        System.out.println(response);
    }

    public void getAllLocomotivesMenu() {
        String response = controller.getAllLocomotives();
        System.out.println(response);
    }

}


