package com.company.controllers;

import com.company.entities.Locomotive;
import com.company.entities.Train;
import com.company.repositories.interfaces.ILocomotiveRepository;
import com.company.repositories.interfaces.ITrainRepository;

import java.util.List;

public class TrainController {
    private final ILocomotiveRepository locomotiveRepo ;
    private final ITrainRepository repo;

    public TrainController(ITrainRepository repo, ILocomotiveRepository locomotiveRepo) {
        this.locomotiveRepo = locomotiveRepo;
        this.repo = repo;
    }

    public String createTrain(String name, String number, int capacity) {

        Train train = new Train(name, number , capacity);

        boolean created = repo.createTrain(train);

        return (created ? "Train was created!" : "Train creation was failed!");
    }

    public Train getTrain(int id) {
        Train train = repo.getTrain(id);
        return train;

    }

    public String getAllTrains() {
        List<Train> trains = repo.getAllTrains();
        return trains.toString();
    }

    public String getCapacity(int id) {
        int capacity = repo.getCapacityById(id);

        return (capacity == -1 ? "Train was not found!" : String.valueOf(capacity));
    }



    public String createLocomotive(String name, int train_id) {

        Locomotive locomotive = new Locomotive(name, train_id);

        boolean created = locomotiveRepo.createLocomotive(locomotive);

        return (created ? "Locomotive was created!" : "Locomotive creation was failed!");
    }

    public String getLocomotive(int id) {
        Locomotive locomotive = locomotiveRepo.getLocomotive(id);

        return (locomotive == null ? "Train was not found!" : locomotive.toString());
    }

    public String getAllLocomotives() {
        List<Locomotive> locomotives = locomotiveRepo.getAllLocomotives();
        return locomotives.toString();
    }
}
