package by.petrikus;

import javax.swing.*;
import javax.swing.event.ListDataListener;
import java.util.ArrayList;
import java.util.Objects;


public class ListView implements ListModel<String>{
    private ArrayList<String> data;

    public ListView(){
        data = new ArrayList<>();
    }

    public int getSize() {
        return data.size();
    }

    public String getElementAt(int index) {
        return data.get(index);
    }

    public void addListDataListener(ListDataListener l) {

    }

    public void removeListDataListener(ListDataListener l) {

    }

    public void addElement(String s){
        data.add(s);
    }

    public void removeElement(int index){
        data.remove(index);
    }

    public void removeElement(Object element){
        data.remove(element);
    }
}
