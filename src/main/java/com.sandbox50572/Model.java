package com.sandbox50572;

public class Model {

    private Integer id;
    private String name;
    private String message;

    //TODO быстрая реализация проверить
    private static volatile Model instance;

    public Model() {
        this.name = "admin";
        this.message = "no messages";
        this.id = 0;
    }

    public static Model getInstance() {
        Model localInstance = instance;
        if (localInstance == null) {
            synchronized (Model.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new Model();
                }
            }
        }
        return localInstance;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Model{" +
                "id=" + id +
                ", name: '" + name + '\'' +
                ", message: " + message +
                '}';
    }


}
