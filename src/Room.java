public class Room {
    private String name;
    private String description;
    private Room[] nearbyRooms;
    private boolean isExit;
    private boolean isLocked;
    private String keyToRoom;


    public Room(String name, String description, boolean isExit, boolean isLocked, String keyToRoom){
        nearbyRooms = new Room[4];
        this.name = name;
        this.description = description;
        this.isExit = isExit;
        this.isLocked = isLocked;
        this.keyToRoom = keyToRoom;
    }

    public Room[] getNearbyRooms() {
        return nearbyRooms;
    }

    public void setNearbyRooms(Room[] nearbyRooms) {
        this.nearbyRooms = nearbyRooms;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public boolean isExit() {
        return isExit;
    }

    public void setExit(boolean exit) {
        isExit = exit;
    }

    public String getKeyToRoom() {
        return keyToRoom;
    }

    public void setKeyToRoom(String keyToRoom) {
        this.keyToRoom = keyToRoom;
    }

    public boolean getisLocked() {
        return isLocked;
    }

    public void setLocked(boolean locked) {
        isLocked = locked;
    }

    // gets the name of the room
    public String getName(){
        return name;
    }

    // sets the name of the room
    public void setName(String name){
        this.name = name;
    }

    // gets the description of the room
    public String getDescription() {
        return description;
    }

    // sets the description of the room
    public void setDescription(String description) {
        this.description = description;
    }

    // sets the room to the specified index in the array
    public void setNearbyRooms(int index, Room room){
        this.nearbyRooms[index] = room;
    }

    // gets the room at the specified index
    public Room getRoom(int index){
        return this.nearbyRooms[index];
    }

    public void printAvailableRooms(){
        for(int i = 0; i<this.nearbyRooms.length; i++){
            if(this.nearbyRooms[i]!=null){
                if(i == 0){
                    System.out.println("You can go north to the "+this.nearbyRooms[i].getName());
                }
                else if(i == 1){
                    System.out.println("You can go east to the "+this.nearbyRooms[i].getName());
                }
                else if(i == 2){
                    System.out.println("You can go south to the "+this.nearbyRooms[i].getName());
                }
                else {
                    System.out.println("You can go west to the "+this.nearbyRooms[i].getName());
                }
            }
        }
    }
}
