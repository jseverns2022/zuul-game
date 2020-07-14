import java.util.Scanner;
import java.util.ArrayList;
public class GameDriver {
    public static void main(String[] args){
        int amountMoves = 0;
        Scanner scan = new Scanner(System.in);
        //Key array that will be added to if the user finds the key in the tv room.
        ArrayList<String> keyarray = new ArrayList();



        // used to store keys that user picks up.
        Room mainRoom = new Room("main", "This is the main room", false,false, null);
        Room currentRoom = mainRoom;
        Room livingRoom = new Room("living", "This is the living room", false, false, null);

        Room tvRoom = new Room("tv", "This is the tv room", false, false,"exit");
        Room bedRoom = new Room("bed", "This is the bedroom", false, false, null);
        Room office = new Room("office", "This is the office", false, false, null);

        Room exit = new Room("exit", "this is the exit", true,true, null);
        //tells the program what the user imputs to get into specific rooms
        mainRoom.setNearbyRooms(0, livingRoom);
        livingRoom.setNearbyRooms(2, mainRoom);
        livingRoom.setNearbyRooms(3, exit);
        exit.setNearbyRooms(1, livingRoom);

        tvRoom.setNearbyRooms(3, mainRoom);
        mainRoom.setNearbyRooms(1, tvRoom);
        office.setNearbyRooms(0, mainRoom);
        mainRoom.setNearbyRooms(2, office);
        bedRoom.setNearbyRooms(1, mainRoom);
        mainRoom.setNearbyRooms(3, bedRoom);
        bedRoom.setNearbyRooms(0, exit);
        exit.setNearbyRooms(2, bedRoom);

//While the the user has not gone through the exit and has less than 6 moves
        while(!currentRoom.equals(exit)&&amountMoves<=6) {
            //If the current room has a key
            if(currentRoom.getKeyToRoom() != null){
                //add the key to the KeyToRoom array
                keyarray.add(currentRoom.getKeyToRoom());
            }
            System.out.println("You are currently in the "+currentRoom.getName() + "room");
            currentRoom.printAvailableRooms();
            System.out.println("Please enter your next move: 0: north, 1: east, 2: south, 3: west");
            // TODO print all the keys in the current room, null
            int userMove = scan.nextInt();
            //If the user tries to move in a direction without a room
            if(currentRoom.getRoom(userMove) == null){
                //Tell the user they cannot move in this direction
                System.out.println("You cannot move in this direction");
            }else {
                //If the current room is locked
                if(currentRoom.getRoom(userMove).getisLocked() == true) {
                    //If the user has the key in the "KeyToRoom" array
                    if (keyarray.contains(currentRoom.getRoom(userMove).getName())) {
                        //Unlock the exit
                        exit.setLocked(false);
                        //and move them into the exit. This is the final step and the user has won the game
                        currentRoom = currentRoom.getRoom(userMove);
                        amountMoves++;

                    } else {
                        //If the user does not have the key in the array, tell them they have to find the key somewhere
                        System.out.println("You need to find the key somewhere");
                    }


                }else{
                    // runs when door is not locked
                    currentRoom = currentRoom.getRoom(userMove);
                    amountMoves++;

                }


            }

        }
        if(amountMoves>6 || !currentRoom.equals(exit)){
            //If you have moved over 6 times and have not reached the exit, you loose
            System.out.println("You lost");
        }else{
            //Once you unlock the door to the exit, you win!!!
            System.out.println("You win, congratulations!");
        }

    }
}
