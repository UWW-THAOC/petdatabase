
import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    private static Scanner s = new Scanner(System.in);
    private static PetDatabase db = new PetDatabase();
    
    public static void main(String[] args) {

        System.out.println("Pet Database Program.");
        loop:
        while (true) {
            switch (getUserChoice()) {
                case 1:
                    showAllPets();
                    break;
                case 2:
                    addPet();
                    break;
                case 3:
                    searchByName();
                    break;
                case 4:
                    break loop;
            }
        }
    }
    
    private static void searchByName() {
        System.out.print("Enter a name to search:");
        String name = s.next();
        int match = 0;
        printTableHeader();
        ArrayList<Pet> pets = db.getPets();
        
        for (int i = 0; i < pets.size(); i++) {
            if (pets.get(i).getName().equalsIgnoreCase(name)) {
                printTableRow(i, pets.get(i).getName(), pets.get(i).getAge());
                match++;
            }
        }
        printTableFooter(match);
        
    }
    
    public static int getUserChoice() {
        System.out.println("What would you like to do?");
        System.out.println(" 1) View all pets");
        System.out.println(" 2) Add a new pet");
        System.out.println(" 3) Search pets by name ");
        System.out.println(" 4) Exit program ");
        System.out.print("Your choice: ");
        return s.nextInt();
    }


    public static void addPet() {
        int tmp = db.getCount();
        s.nextLine();
        while(true){
            System.out.print("add pet (name, age): ");
            String line = s.nextLine().trim();
            if (line.equalsIgnoreCase("done")) break;
            String[] result = line.split(" ");
            db.add(new Pet(result[0], Integer.parseInt(result[1])));
        }
        int count = db.getCount()-tmp;
        System.out.println(count + " pets added.");
    }

    private static void printTableHeader(){
        System.out.println("+----------------------+");
        System.out.printf("|%3s | %-10s|%4s |\n", "ID", "NAME", "AGE");
        System.out.println("+----------------------+");
    }
    
    private static void printTableRow(int id, String name, int age){
        System.out.printf("|%3d | %-10s|%4d |\n", id, name, age);
    }
    
    private static void printTableFooter(int count){
       System.out.println("+----------------------+");
       System.out.println(count + " rows in set.");
    }    
 
    
    private static void showAllPets() {
        printTableHeader();
        ArrayList<Pet> pets = db.getPets();
        for (int i = 0; i < db.getCount(); i++) {
            printTableRow(i, pets.get(i).getName(), pets.get(i).getAge());
        }
        printTableFooter(db.getCount());
    }
    

}

