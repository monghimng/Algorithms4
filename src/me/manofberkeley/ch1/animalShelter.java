package me.manofberkeley.ch1;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Created by MOng on 12/26/2016.
 */
public class animalShelter {
    LinkedList<String> queue = new LinkedList<>();
    public void enqueue(String animal){
        queue.add(animal);
    }

    public String dequeueAny(){
        return queue.pollFirst();
    }

    public String dequeueSpecific(String target){
        ListIterator<String> iter = queue.listIterator();
        while(iter.hasNext()){
            String animal = iter.next();
            if(animal.equals("target")){
                iter.remove();
                return animal;
            }
        }
        return null;
    }

    public String dequeueDog(){
        return dequeueSpecific("Dog");
    }

    public String dequeueCat(){
        return dequeueSpecific("Cat");
    }
}
