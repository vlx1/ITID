package model;

//import com.oracle.webservices.internal.api.databinding.Databinding;

/**
 * Created by Viktor on 20.11.2016.
 */
public class Car {
    private int id;
    private String model;
    private int mileage;
    private int ownerId;

    public Car (int id, String model, int mileage, int ownerId) {
        this.id = id;
        this.model = model;
        this.mileage = mileage;
        this.ownerId = ownerId;
    }
    public Car(Builder builder) {
        this.id = builder.id;
        this.model = builder.model;
        this.mileage = builder.mileage;
        this.ownerId = builder.ownerId;
    }

    public static class Builder {
        private int id;
        private String model;
        private int mileage;
        private int ownerId;

        public Builder id(int value){
            id = value;
            return this;
        }
        public Builder model(String value){
            model = value;
            return this;
        }
        public Builder mileage(int value){
            mileage = value;
            return this;
        }
        public Builder ownerId(int value){
            ownerId = value;
            return this;
        }
        public Car build() {
            return new Car(this);
        }
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }


}
