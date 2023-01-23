package models;

import enums.EstadoAnimal;
import enums.Porte;

import java.time.LocalDate;
import java.util.List;

public class Cachorro extends Animais{
    public Cachorro(String nome, LocalDate nascimento, String raca, Porte porte, Double peso, EstadoAnimal estadoAnimal, List<EsquemaVacinal> vacinas, String observacoes) {
        super(nome, nascimento, raca, porte, peso, estadoAnimal, vacinas, observacoes);
    }
}
