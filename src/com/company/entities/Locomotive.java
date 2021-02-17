package com.company.entities;

public class Locomotive {
    private int id ;
    private String name;
    private int train_id ;

    public Locomotive(){

    }

    public Locomotive(String name , int train_id){
        setName(name);
        setTrain_id(train_id);
    }

    public Locomotive(int id ,String name , int train_id ){
        setId(id);
        setName(name);
        setTrain_id(train_id);
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getTrain_id() {
        return train_id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTrain_id(int train_id) {
        this.train_id = train_id;
    }

    @Override
    public String toString(){
        return "Locomotive ID : " + getId() + " Locomotive name : " + getName() + " Locomotive train_id : " + getTrain_id() ;
    }

}
