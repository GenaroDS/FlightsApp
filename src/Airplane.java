import java.util.ArrayList;

public class Airplane {
    private String planeId;
    private String airline;
    private int capacity;
    private String from;
    private String to;
    private ArrayList<Seat> seats;
    
    public Airplane(String id, String airline,String from, String to, int capacity){
        this.planeId = id;
        this.airline = airline;
        this.capacity = capacity;
        this.from = from;
        this.to = to;
        this.seats = new ArrayList<>();
    }
    
    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public void showSeats(){
        this.seats.forEach(System.out::println);
    }

    public void prepareSeats(){
        int i = 1;
        while (i <= capacity){
            seats.add(new Seat(i));
            i++;
        }
    }

    public boolean isItFull(){
        int i = 0;
        while (i < capacity){
            if (!(this.seats.get(i).isAvailable())){
                return false;
            }            
        }
        return true;
    }

    public void reserveSeat(){
        int i = 0;
        boolean state = false;
        while (i < this.seats.size()){
            if (this.seats.get(i).isAvailable()){
                this.seats.get(i).reserveSeat();    
                state = true;                
                break;                        
            }
            i++;            
        }
        if (state) {
            System.out.println("Seat succesfully reserved");
            TicketGenerator ticketer = new TicketGenerator(this.planeId, this.seats.get(i));
            String ticket = ticketer.generateTicket();
            System.out.println( "Seat succesfully reserved, your ticket ID number is: " + ticket);
            return;
        } else {
            System.out.println("The flight is full"); 
            return;
        }
    }



    public String getPlaneId() {
        return planeId;
    }

    public int availableSeats(){
        int availables = 0;
        int index = 0;
        while (index < this.seats.size()){
            if (this.seats.get(index).isAvailable()){
                availables ++;
            }
            index++;
        }
        return availables;
    }

    public String toString(){
        return "Flight ID:"+ this.planeId +" From: " + this.from + " To: "+ this.to + " Airline: " + this.airline + " Capacity: " + this.capacity + " Seats available: " + (availableSeats());
    }

    
}
