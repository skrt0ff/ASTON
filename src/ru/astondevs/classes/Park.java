package ru.astondevs.classes;

public class Park {
    private String namePark;
    private String timePark;

    public Park(String namePark, String timePark) {
        this.namePark = namePark;
        this.timePark = timePark;
    }

    public void displayPark() {
        System.out.println("Добро пожаловать в парк " + this.namePark + "!\nВремя работы парка: " + this.timePark + "\n\n");
    }

    public class Attraction {
        private String attractionName;
        private String attractionTime;
        private int cost;

        public Attraction(String attractionName, String attractionTime, int cost) {
            this.attractionName = attractionName;
            this.attractionTime = attractionTime;
            this.cost = cost;
        }

        public void displayAttraction() {
            System.out.println("Аттракцион: " + this.attractionName);
            System.out.println("Время работы: " + this.attractionTime);
            System.out.println("Стоимость: " + this.cost);
        }
    }

    public class Restaurant {

    }

    public class Shop {

    }

}
