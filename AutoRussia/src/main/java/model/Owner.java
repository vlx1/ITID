package model;

/**
 * Created by Viktor on 20.11.2016.
 */
public class Owner {
    private int id;
    private String name;
    private int age;
    private String city;



    public Owner(int id, String name, int age, String city) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.city = city;
    }

    public Owner(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.age = builder.age;
        this.city = builder.city;
    }

    public static class Builder {
        private int id;
        private String name;
        private int age;
        private String city;

        public Builder id(int value){
            id = value;
            return this;
        }
        public Builder name(String value){
            name = value;
            return this;
        }
        public Builder age(int value){
            age = value;
            return this;
        }
        public Builder city(String value){
            city = value;
            return this;
        }
        public Owner build() {
            return new Owner(this);
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

}
