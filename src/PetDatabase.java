
import java.util.ArrayList;



public class PetDatabase {
    
    private ArrayList<Pet> pets = new ArrayList<Pet>();
    
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
}
