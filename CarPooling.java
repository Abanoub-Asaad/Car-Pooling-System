package carpooling_package;

import static carpooling_package.CarPooling.sc;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * <h1>Car Pooling</h1>
 * Car Pooling System is an application that helps managing cars scheduling and
 * bookings.
 * <p>
 * <br>
 * I used (Single Responsibility Principle) as a SOLID Principle.
 * <br>
 * <br>CarPooling class is a child and its parent is RootClass
 */
public class CarPooling extends RootClass {

    /**
     * intialize_cars is a mehtod to intialize the cars that I have with its
     * location, destination, code, capacity and driver name.
     * <p>
     * intialize_menu is a method to display in the menu (The valid options that
     * the user can choose from )
     */
    public static void main(String[] args) {

        Car car_obj = new Car();

        car_obj.intialize_cars();

        intialize_menu();

    }

}

//-----------------------------------------------------------------------------
class RootClass {

    /**
     * is the minimum age to be a subscriber
     * <br>
     * It's "final".
     */
    public final int Alowed_age = 20;
    /**
     * is an array to store all the passengers (Subscribers and
     * Non-Subscribers).
     */
    public static ArrayList<Passenger> passengers_array = new ArrayList<Passenger>();
    /**
     * is an array to store all the cars.
     */
    public static ArrayList<Car> cars_array = new ArrayList<Car>();
    /**
     * is a Scanner to read data.
     */
    public static Scanner sc = new Scanner(System.in);
    /**
     * is the variable that I use in reading data from the user in menu page.
     * <br> It's "private and static"
     */
    public static int choice_menu;
    /**
     * is the variable that I use in reading data from the user in the last step
     * after opening each method which cintains 2 options (Return to Menu or
     * Exit the program).
     * <br> It's "private and static"
     */
    public static int choice_endOfStep;
    /**
     * to read line in some parts as a test to make it works well.
     */
    public static String test;

    /**
     * is a method to display in the menu (The valid options that the user can
     * choose from )
     * <br>Here I used an Exception handling if the user entered a string or
     * char instead of integers.
     */
    public static void intialize_menu() {
        System.out.println("----------------------------------------------------\n"
                + "Welcome, Our Dear Client\n\nSelect the operation that you want by choosing the number of the process");
        System.out.println("Click [1] : Add " + "New User\n" + "Click [2] : " + "Subscribe\n" + "Click [3] : " + "Un-Subscribe\n" + "Click [4] : " + "Search for Route, Reserve a Ticket and Write a review\n\n");
        System.out.print("Your choice : ");

        try {
            choice_menu = sc.nextInt();
            chooseFromHomePage();
        } catch (Exception e) {
            System.out.println("\nPlease, Enter Valid Input\n");
            test = sc.nextLine();
            intialize_menu();
        }

    }

    /**
     * is a method to take the input from the user which is the option that he
     * chose to be executed
     * <br> It's a "static method"
     * <br> 1 : Add New User
     * <br> 2 : Subscribe
     * <br> 3 : UnSubscribe
     * <br> 4 : Search for Route and Reserve a Ticket and after both the user
     * can write a review if he wants.
     */
    public static void chooseFromHomePage() {
        if (choice_menu == 1) {
            Process prosess_obj = new Process(1);
        } else if (choice_menu == 2) {
            Process prosess_obj = new Process(2);
        } else if (choice_menu == 3) {
            Process prosess_obj = new Process(3);
        } else if (choice_menu == 4) {
            Process prosess_obj = new Process(4);
        } else {
            System.out.println("Please, Enter Valid Input");
            intialize_menu();
        }

    }

    /**
     * In the end of each part of the program, there're 2 sentences apears to
     * the user
     * <br> (1) Do you want to return to Menu, Click 5
     * <br> (2) Do you want to exit, Click 6.
     */
    public static void endOfStep() {

        System.out.println("-------------------------------------------------------");
        System.out.println("If You want to return to Menu choose [5]\nIf You want to exit choose[6]");
        choice_endOfStep = sc.nextInt();
        if (choice_endOfStep == 5) {
            intialize_menu();
            chooseFromHomePage();
        } else if (choice_endOfStep == 6) {
            System.exit(0);
        } else {
            System.out.println("Please, Enter Valid Input");
            endOfStep();
        }
    }
}
//---------------------------------------------------------------------

/**
 * It's a class that controls on moving from function to another and the
 * branching of the methods.
 */
class Process {

    /**
     * to read the input from the user.
     * <br> It's a private variable.
     */
    private int choice;
    /**
     * is an object from CarPooling class to access this class.
     * <br> It's a private variable.
     */
    private static CarPooling car_pooling_obj;
    /**
     * is an object from Car class to access this class.
     * <br> It's a private variable.
     */
    private static Car car_obj;
    /**
     * is a variable to check if the passenger registered in the system or not.
     */
    public static boolean registerd;
    /**
     * is the entered ID
     */
    public static int entered_id;

    /**
     * @param choice is the input that the user entered (The option he chose
     * from the menu).
     */
    public Process(int choice) {
        this.choice = choice;
        start();
    }

    /**
     * If the user chose 1, It would make him add new user (Initially
     * Unsubscriber).
     * <br>If the user chose 2, It would make him subscribe the system (But
     * first he check if entered a correct ID)
     * <br>If the user chose 3, It would make him Un-subscribe the system (But
     * first he check if entered a correct ID)
     * <br>If the user chose 4, It would make him choose the route, reserve a
     * ticket and write a review(But first he check if entered a correct ID).
     */
    public void start() {
        if (choice == 1) {
            Passenger passenger_obj = new Non_Subsciber();
        } else if (choice == 2) {
            enterYourID(2);
        } else if (choice == 3) {
            enterYourID(3);
        } else if (choice == 4) {
            enterYourID(4);
        }

        CarPooling.endOfStep();
    }

    /**
     * Here the branching of the most of the system for 3 methods:
     * <br> choice = 2 : It would make him subscribe the system (But first he
     * check if entered a correct ID)
     * <br> choice = 3 : It would make him Un-subscribe the system (But first he
     * check if entered a correct ID)
     * <br> choice = 4 : It would make him choose the route, reserve a ticket
     * and write a review(But first he check if entered a correct ID).
     *
     * @param choice
     */
    public static void enterYourID(int choice) {

        car_pooling_obj = new CarPooling();
        car_obj = new Car();
        registerd = false;
        ArrayList<Passenger> passengers_array = CarPooling.passengers_array;

        System.out.println("Please, Enter Your ID to check If you're registered or not");
        entered_id = CarPooling.sc.nextInt();

        if (entered_id - 1 < passengers_array.size() && entered_id - 1 > -1) {
            registerd = true;
            System.out.println("OK, You registered in the System Previously");

        }

        if (registerd) {

            Passenger passenger = passengers_array.get(entered_id - 1);
            if (choice == 2) {
                if (passenger.passenger_age >= car_pooling_obj.Alowed_age) {
                    if (passenger.isSubscriber) {
                        System.out.println("You're already a Subscriber\nAnd There's " + passenger.num_trips + " are available");
                    } else {
                        passenger.isSubscriber = true;
                        passenger.num_trips = 5;
                        System.out.println("You're now a Subscriber, Enjoy!");
                    }
                } else {
                    System.out.println("\nSorry your age isn't allowed in subscribtion, So you're not subscribed\n");
                }

            } else if (choice == 3) {
                if (!passenger.isSubscriber) {
                    System.out.println("You're already a Non-Subscriber");
                } else {
                    passenger.isSubscriber = false;
                    passenger.num_trips = 0;
                    System.out.println("You're now a Non-Subscriber User");
                }
            } else if (choice == 4) {
                car_obj.print_routes_of_cars();
                System.out.println("Choose your Route");
                car_obj.choose_Route(entered_id);
            }

        } else {
            System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
            System.out.println("Sorry,You're not registered in the System\n" + "Click [1] to enter Your ID again\nClick [2] to register");
            System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
            int choicee = CarPooling.sc.nextInt();
            if (choicee == 1) {
                enterYourID(choice);
            } else {
                Passenger passenger_obj = new Non_Subsciber();
            }

        }
    }
}

//---------------------------------------------------------------------
/**
 * passenger_interface is an interface that contains 2 methods: enterName() and
 * enterAge()
 * <br>Passenger class is the class that implements this interface.
 */
interface passenger_interface {

    public void enterName();

    public void enterAge();

}

//---------------------------------------------------------------------
/**
 *
 * Passenger is an abstract class that contains some variables and they
 * <br>ID, chosen_route, Alowed_age, passenger_name, passenger_age,
 * isSubscriber(boolean) and num_trips.
 */
abstract class Passenger implements passenger_interface {

    public int ID = 0;
    public int chosen_route = 0;
    public final int Alowed_age = 20;
    public String passenger_name;
    public int passenger_age;
    public boolean isSubscriber = false;
    public int num_trips = 0;

    Passenger() {
    }

}

//---------------------------------------------------------------------
/**
 *
 * Subsciber is a Class that contains all the data that related to the Subsciber
 * users
 * <br> is also a child and its parent is Passenger class.
 */
class Subsciber extends Passenger {

    /**
     * is a constructor and here also I call some methods and they are
     * enterName(), enterAge() and checkAge()
     */
    Subsciber() {

        enterName();
        enterAge();
        checkAge();
    }

    /**
     * is a method to make the user enter his name
     * <br> Here I used Overriding.
     */
    @Override
    public void enterName() {
        System.out.print("Please, Enter your name:  ");
        passenger_name = CarPooling.sc.next();
    }

    /**
     * is a method to make the user enter his age
     * <br> Here I used Overriding.
     */
    @Override
    public void enterAge() {
        System.out.print("Please, Enter your age:  ");
        try {
            passenger_age = CarPooling.sc.nextInt();
        } catch (Exception e) {
            CarPooling.test = sc.nextLine();
            enterAge();
        }
    }

    /*
     * is a method to check if the enetered age is greater than or equal the allowed age to be a subscriber.
     */
    public void checkAge() {
        if (passenger_age >= Alowed_age) {
            System.out.println("\nCongratulation - You've subscribed successfully\n");
            isSubscriber = true;
            CarPooling.passengers_array.add(this);
            this.ID = CarPooling.passengers_array.size();
            System.out.println("And Your ID is : " + ID);
            this.num_trips = 5;
        } else {
            System.out.println("\nSorry your age isn't allowed in subscribtion, So you're not subscribed\n");
            Passenger passenger_obj = new Non_Subsciber(passenger_name, passenger_age);
        }
    }

}

//---------------------------------------------------------------------
/**
 *
 * Non_Subsciber is a Class that contains all the data that related to the
 * Non-Subscriber users
 * <br> is also a child and its parent is Passenger class.
 */
class Non_Subsciber extends Passenger {

    /**
     * is a constructor and inside it I call another method to execute the
     * roles.
     */
    Non_Subsciber() {
        make_unsubscriber();
    }

    /**
     * is a method to make the user a non-subscriber user.
     */
    public void make_unsubscriber() {
        isSubscriber = false;
        enterName();
        enterAge();
        CarPooling.passengers_array.add(this);
        ID = CarPooling.passengers_array.size();
        System.out.println("\nYou're now a Non-Subsciber User\n");
        System.out.println("***************************************");
        System.out.println("AND Your ID is :  " + ID);
        System.out.println("***************************************");
    }

    /**
     * is a method to initialize the name and age that were sent as parameters
     * <br> Then add the non-subscriber passenger to the array of passengers.
     * <br> Here I used overloading.
     *
     * @param name
     * @param age
     */
    Non_Subsciber(String name, int age) {

        this.passenger_name = passenger_name;
        this.passenger_age = passenger_age;
        this.isSubscriber = false;
        CarPooling.passengers_array.add(this);
        ID = CarPooling.passengers_array.size();
    }

    /**
     * is a method to make the user enter his name
     * <br> Here I used Overriding.
     */
    @Override
    public void enterName() {
        System.out.print("Please, Enter your name:  ");
        passenger_name = CarPooling.sc.next();
    }

    /**
     * is a method to make the user enter his age
     * <br> Here I used Overriding.
     */
    @Override
    public void enterAge() {
        System.out.print("Please, Enter your age:  ");
        passenger_age = CarPooling.sc.nextInt();
    }

}

//----------------------------------------------------------------------------------
/**
 * This class contains everything related to the Car Class
 */
class Car {

    /**
     * To make it easy, when I want to access the arrayList of cars.
     * <br> It's private.
     */
    private ArrayList<Car> cars_array = CarPooling.cars_array;
    /**
     * is the number of the trips for each car.
     */
    public final int num_trips_per_day_for_car = 10;
    /**
     * is the number of passengers that the car can carry.
     */
    public int capacity = 0;
    /**
     * is the code for each car.
     */
    public int car_code = 0;
    /**
     * is the name of the driver.
     */
    public String driver_name;
    /**
     * is the address of the car
     */
    public String start_from_car;
    /**
     * is the destination of the car.
     */
    public String end_to_car;

    /**
     * is a constructor to initialize all the data that as parameters
     * <br> Here I used Overloading.
     *
     * @param start
     * @param destination
     * @param car_code
     * @param capacity
     * @param driver_name
     */
    Car(String start, String destination, int car_code, int capacity, String driver_name) {

        this.start_from_car = start;
        this.end_to_car = destination;
        this.car_code = car_code;
        this.capacity = capacity;
        this.driver_name = driver_name;
        CarPooling.cars_array.add(this);
    }

    Car() {
    }

    /**
     * is a mehtod to intialize the cars that I have with its location,
     * destination, code, capacity and driver name.
     */
    public void intialize_cars() {

        String from_car1 = "Cairo";
        String to_car1 = "Ghamra";
        String from_car2 = "Shobra";
        String to_car2 = "6th of October";
        String from_car3 = "Giza";
        String to_car3 = "Nasr City";
        String from_car4 = "10th of Ramadan City";
        String to_car4 = "El Obour";
        String from_car5 = "Maadi";
        String to_car5 = "Old Cairo";

        Car car1 = new Car(from_car1, to_car1, 101, 5, "Ali");
        Car car2 = new Car(from_car2, to_car2, 202, 0, "Ahmed");
        Car car3 = new Car(from_car3, to_car3, 303, 4, "Mohamed");
        Car car4 = new Car(from_car4, to_car4, 404, 10, "Nada");
        Car car5 = new Car(from_car5, to_car5, 505, 2, "Nora");
    }

    /**
     * is a method to print all the routes for each car to make the user choose
     * what he wants.
     */
    public void print_routes_of_cars() {

        System.out.println("-----------------------------------------------------");

        int i = 1;
        for (Car car : cars_array) {
            System.out.println("Click [ " + i + " ]  From :  " + car.start_from_car + "\n\t\t\t\t To :  " + car.end_to_car);
            ++i;
        }
        System.out.println("-----------------------------------------------------");
    }

    /**
     * is a method to make the user choose the route that he wants
     * <br> And After checking it and making sure that it's a valid route, then
     * the user can reserve a ticket.
     *
     * @param entered_id is the ID of the Current User.
     */
    public void choose_Route(int entered_id) {

        boolean car_filled = false;
        int chosen_route = CarPooling.sc.nextInt();

        car_code = CarPooling.cars_array.get(chosen_route - 1).car_code;
        Car cur_car = CarPooling.cars_array.get((car_code % 100) - 1);

        if (cur_car.capacity > 0) {
            CarPooling.passengers_array.get(entered_id - 1).chosen_route = chosen_route;

            System.out.println("You chosen Route Successfully\n");
            System.out.println("And its location : " + CarPooling.cars_array.get(chosen_route - 1).start_from_car);
            System.out.println("And its destination : " + CarPooling.cars_array.get(chosen_route - 1).end_to_car);
        } else {
            car_filled = true;
            System.out.println("Sorry! The Capacity for this car is filled so choose another one");
            print_routes_of_cars();
        }

        if (!car_filled) {
            System.out.println("\nClick [1] : Reserve a ticket\nClick [2] : Back to Menu");
            int ch = CarPooling.sc.nextInt();
            if (ch == 1) {
                Ticket ticket_obj = new Ticket();
                ticket_obj.reserve_ticket(entered_id, car_code);
            } else if (ch == 2) {
                CarPooling.intialize_menu();
            }
        }

    }
}

//-------------------------------------------------------------------------------
/**
 *
 * This class contains all the methods that related to The Ticket.
 */
class Ticket {

    /**
     * is the percentage of discount to the subscriber user
     * <br> It's a final variable.
     */
    public final double discount = 0.5;
    /**
     * is the code for the specified Car that related to the reserved ticket
     * <br> It has a private access modifier.
     */
    private int car_code = 0;
    /**
     * is the normal price of the one trip without any discount.
     */
    public double price = 100;

    public Ticket() {

    }

    /**
     * This method is used to reserve a ticket as its name shows
     *
     * @param user_id is the ID of the passenger
     * @param car_code is the Code of the specified car.
     */
    public void reserve_ticket(int user_id, int car_code) {
        this.car_code = car_code;
        check_valid_car(user_id, car_code);
    }

    /**
     * This method to check if the chosen car is valid which means there is a
     * capacity in it.
     * <br> And if it is valid, The System will make you reserve a ticket then
     * write a review if you want
     * <br> If not, So you should take another car.
     *
     * @param user_id
     * @param car_code
     */
    public void check_valid_car(int user_id, int car_code) {

        for (Car car : CarPooling.cars_array) {

            if (car.car_code == car_code) {
                if (car.capacity > 0) {
                    --car.capacity;
                    check_discount(user_id);
                    System.out.println("------------------------------------------------------");
                    System.out.println("You reserved the ticket successfully and its price = " + price);
                    System.out.println("And its location : " + CarPooling.cars_array.get(car_code % 100 - 1).start_from_car);
                    System.out.println("And its destination : " + CarPooling.cars_array.get(car_code % 100 - 1).end_to_car);
                    System.out.println("------------------------------------------------------");
                    System.out.println("Click [1] If You want to write a review\nClick [2] Exit the program");

                    int choice = CarPooling.sc.nextInt();
                    if (choice == 1) {
                        writeReview(true);
                    } else {
                        writeReview(false);
                    }
                    break;
                } else {
                    System.out.println("Ooh Sorry, the car isn't valid right now !\nChoose another route");
                    Car car_obj = new Car();
                    car_obj.choose_Route(user_id);
                    break;
                }
            }
        }

    }

    /**
     * This method to check discount because if the user is a subscriber there
     * will a discount by 50%
     * <br> Then decrease the number of trips for him by one
     * <br> If the user is a non-subscriber, there'll not be a discount.
     *
     * @param user_id
     */
    public void check_discount(int user_id) {

        Passenger cur_passenger = CarPooling.passengers_array.get(user_id - 1);
        if (cur_passenger.isSubscriber && cur_passenger.num_trips > 0) {
            this.price = 100 * discount;
            cur_passenger.num_trips--;
        } else {
            this.price = 100;
        }

    }

    /**
     * This method to make the user write a review if he wants.
     *
     * @param ok to check if the user wants to write or not
     */
    public void writeReview(boolean ok) {
        int choice;
        if (!ok) {
            System.exit(0);
        } else {
            System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            System.out.println("Click [1] : If The System is GREAT\nClick [2] : If The System is GOOD\nClick [3] : If The System is BAD\n");
            choice = CarPooling.sc.nextInt();
            System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            System.out.println("Thanks for Your Feedback !");
        }
    }
}
