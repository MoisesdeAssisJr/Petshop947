package models;

import java.util.ArrayList;
import java.util.List;

public class Clientes extends Pessoa{

    int id;
    List<Animais> pets = new ArrayList<>();

    public Clientes(int id, List<Animais> pets) {
        this.id = id;
        this.pets = pets;
    }


    public Clientes() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Animais> getPets() {
        return pets;
    }

    public void setPets(List<Animais> pets) {
        this.pets = pets;
    }


}
