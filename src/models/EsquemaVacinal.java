package models;

import enums.Vacinas;

import java.time.LocalDate;
import java.util.Date;

public class EsquemaVacinal {

    LocalDate data;
    Vacinas vacina;
    String observacao;

    public EsquemaVacinal(LocalDate data, Vacinas vacina, String observacao) {
        this.data = data;
        this.vacina = vacina;
        this.observacao = observacao;
    }
    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
    public Vacinas getVacina() {
        return vacina;
    }

    public void setVacina(Vacinas vacina) {
        this.vacina = vacina;
    }
    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}
