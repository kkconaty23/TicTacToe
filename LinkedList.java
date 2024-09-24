
public class LinkedList {

    private Node head;  // Head of the linked list

    // Constructor to initialize an empty linked list
    public LinkedList() {
        this.head = null;
        for(int i= 0 ; i < 9; i++){
            insertAtEnd(" ");//fills the linked list with values for 9 spaces all being " "
        }
    }


    // Method to insert a new node at the end
    public void insertAtEnd(String data) {
        Node move = new Node(data);

        if(head == null){   //if head is empty head becomes new node created (move)
            head = move;
            return;
        }
        
        Node current = head;
         while(current.next != null){   //if the head is not empty is goes through the list to find the second to last element and makes that point to the new node
             current = current.next;
         }
         current.next = move;
        
      
    }

    // Method to update a specific position in the list
    public void updatePosition(int position, String data) {
        
        
        if(position < 1 || position > 9){   //doesnt allow inpput beyone the 3x3 space 
            System.out.println("out of bounds");
            return;
        }                   
            int index =1;
            Node current = head; 

            while(current != null && index < position){                
                current = current.next;
                index++;

            }
            if(current != null){                //this needs to be checked could be issue
                current.data = data;
            }
            
        }
    

    // Method to get the value at a specific position
    public String getPositionValue(int position) {

        if(position <1 || position >9){ //makes sure the positon is inside the bounds
            return "invalid";
        }
        Node current = head;
        int index = 1;

        while(current != null && index < position){     //cycles through the nodes stopping at the position input       
            
            current = current.next;
            index ++;
            }
            if(current != null){
                return current.data;
            }
            else{
                return " "; //if its not used leaves a blank space for the unused nodes
            }
        
    }

    // Method to display the Tic Tac Toe board
    public void displayBoard() {
        Node current = head; 
        int index = 1;
        String displayValue;

        while(current != null){
            if (current.data.isEmpty()){//assigns the vaule of each node with a number if it is empty
                displayValue = String.valueOf(index);
            }
            else{
                displayValue = current.data;
            }
            System.out.print(current.data + " ");
            if (index % 3 ==0 ){      //makes the board into a 3x3 skipping a line every 3 boxes
                System.out.println();
            }
            current = current.next;
            index++;
        }
    }

    // Method to check for a win
    public boolean checkWinCondition() {
    // Define the winning combinations (indices in a 1D list)
    int[][] winningCombinations = {//make a 2d array with all possble winning conditions, and comapre them to the position played if 3 in a row, player wins.
        {1, 2, 3},                  
        {4, 5, 6}, 
        {7, 8, 9}, 
        {1, 4, 7},
        {2, 5, 8}, 
        {3, 6, 9}, 
        {1, 5, 9}, 
        {3, 5, 7}  
    };
    
    // Check each winning combination
    for (int i = 0; i < winningCombinations.length; i++) {
        int[] combination = winningCombinations[i];
        String first = getPositionValue(combination[0]);
        String second = getPositionValue(combination[1]);
        String third = getPositionValue(combination[2]);
        
        if (!first.equals(" ") && first.equals(second) && second.equals(third)) {
            return true; // player got 3 in a row and wins
        }
    }
    return false; //did not win and game keeps going
}

    // Method to check if the board is full (for draw condition)
    public boolean isBoardFull() {
        Node current = head;

        while(current != null){
            if (current.data.equals(" ")){ //cycles threough the board if any space is equal to " " it returns false and the game goes on
                return false;
            }
            current = current.next;
        }
                return true;
                
            
   }
    
    // Method to reset the board
    public void resetBoard() {
        Node current = head;

        while(current != null){//cycles through the board and makes every space a " " blank space for a new game
            current.data = " ";
            current= current.next;
        }
    }
}
