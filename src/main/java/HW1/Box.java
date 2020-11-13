package HW1;

import java.util.ArrayList;

public class Box<T extends Fruit> {
    private ArrayList<T> arrayList;

    public Box(){
        arrayList = new ArrayList<T>();
    }

    public void add(T t){
        arrayList.add(t);
    }

    public void addAll(Box<T> box){
        arrayList.addAll(box.arrayList);
    }

    public void removeAll(Box<T> box){
        arrayList.removeAll(box.arrayList);
    }

    public float getWeight(){
        float weight = 0;
        for (T t: arrayList) {
            weight += t.getWeight();
        }
        return weight;
    }

    public boolean compare(Box<? extends Fruit> box){
        return this.getWeight() == box.getWeight();
    }

    public Box<T> poreIntoAnotherBox(Box<T> box){
        box.addAll(this);
        removeAll(this);
        return box;
    }

    @Override
    public String toString(){
        return arrayList.toString();
    }
}
