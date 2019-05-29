
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;



public class PetDatabase {
    
    private String fileName = "pets.txt";
    
    private ArrayList<Pet> pets = new ArrayList<Pet>();
    
    public void load(){
        try {
            Scanner s = new Scanner(new File(fileName));
            while(s.hasNextLine()){
                String line = s.nextLine();
                if (line.trim().equals("")) continue;
                String[] pair = line.split(" ");
                add(new Pet(pair[0], Integer.parseInt(pair[1])));
            }
            s.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PetDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void save(){
        try {
            PrintWriter writer = new PrintWriter(fileName);
            for(Pet p:pets){
                writer.println(p.getName() + " " + p.getAge());
            }
            writer.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PetDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void add(Pet p){
        pets.add(p);
    }
    
    public ArrayList<Pet> getPets(){
        return pets;
    }
    
    public int getCount(){
        return pets.size();
    }
    
    public void remove(int id){
        pets.remove(id);
    }
    
    public static void main(String[] args){
        PetDatabase db = new PetDatabase();
        db.load();
        db.add(new Pet("Micky", 5));
        db.add(new Pet("Boomer", 13));
        for(Pet p:db.getPets()){
            System.out.println(p.getName() + ":" + p.getAge());
        }
        db.save();
    }
}
