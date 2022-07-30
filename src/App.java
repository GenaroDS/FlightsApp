import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        /*MainFrame frame = new MainFrame();
        frame.initialize();*/
        ArrayList<Airplane> flights = initialize();        
        flights.forEach(Airplane::prepareSeats);
        /*flights.forEach(Airplane::showSeats);*/
        System.out.println("hi");
        System.out.println("1: Show flights");
        System.out.println("2: Book a flight");
        System.out.println("3: Cancel a flight");
        System.out.println("4: Consult flight");
        System.out.println("5: Quit.");
        Scanner scanner = new Scanner(System.in); 
        while (true){
            System.out.println("Command:");
            String command = scanner.nextLine();

            /* SHOW FLIGHTS */
            if (command.equals("1")){
                flights.forEach(System.out::println);
            }

            /* BOOK FLIGHTS */
            if (command.equals("2")){
                System.out.println("Where do you want to travel?");
                String destination = scanner.nextLine();
                System.out.println("From where?");
                String departure = scanner.nextLine();
                ArrayList<Airplane> filteredFlights = filterFlights(flights,departure,destination);
                if (!(filteredFlights.isEmpty())){
                    System.out.println("This are the available flights");
                    filteredFlights.forEach(System.out::println);
                    System.out.println("Select you desired flight (Flight ID)");
                    String flightID = scanner.nextLine();
                    int i = 0;
                    while (i <= filteredFlights.size()-1){
                        if (filteredFlights.get(i).getPlaneId().equals(flightID)){
                            filteredFlights.get(i).reserveSeat();                                    
                        }
                        i++;
                    }
                } else{
                    System.out.println("There are no flights available that match your requisites.");
                }
            }
            /* CANCEL FLIGHTS */
            if (command.equals("3")){
                System.out.println("Insert the ID of the desired ticket to cancel.");
                String ticketToCancel = scanner.nextLine();
                flightCancel(ticketToCancel, flights);                
            }
            
            if (command.equals("5")){
                scanner.close();
                break;
            }
        }
    }
    public static void flightCancel(String ticket, ArrayList<Airplane> flights){
        String flightId = ticket.substring(1, 4);
        String seatId = ticket.substring(4);
        System.out.println("SEAT ID"+ seatId + "flight id" + flightId);
        int i = 0;
        while (i <= flights.size()-1){
            if (flights.get(i).getPlaneId().equals(flightId)){
                flights.get(i).cancelReservedSeat(seatId);
            }
            i++;
        }
    }


    public static ArrayList<Airplane> initialize() {
        Airplane flight1 = new Airplane("001", "Fly Emirates", "ROS", "BCN", 2);        
        Airplane flight2 = new Airplane("002", "Fly Emirates", "ROS", "BCN", 30);
        Airplane flight3 = new Airplane("003", "Fly Bondi", "BAS", "MDR", 20);
        Airplane flight4 = new Airplane("004", "Fly Bondi", "BAS", "MDR", 30);
        ArrayList<Airplane> flights = new ArrayList<>();
        flights.add(flight1);
        flights.add(flight2);
        flights.add(flight3);
        flights.add(flight4);
        return flights;
    }


    public static ArrayList<Airplane> filterFlights(ArrayList<Airplane> flights, String from, String to){
        ArrayList<Airplane> newList = new ArrayList<>();
        int index = 0;
        while (flights.size() > index){
            if ((flights.get(index).getFrom().equals(from)) && (flights.get(index).getTo().equals(to))){
                newList.add(flights.get(index));
            }
            index++;
        }
        return newList;
    }

}
