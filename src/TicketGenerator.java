public class TicketGenerator {
    private String ticket;
    private String flightID;
    private Seat seat;

    public TicketGenerator(String flightID, Seat seat){
        this.ticket = "";
        this.flightID = flightID; 
        this.seat = seat;
    }

    public String generateTicket(){
        this.ticket += flightID;
        this.ticket += seat.getSeatNumber();
        return this.ticket;
    }

}
