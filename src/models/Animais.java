package models;

import enums.EstadoAnimal;
import enums.Porte;

import java.time.LocalDate;
import java.util.*;

import static enums.Vacinas.*;

public abstract class Animais {

    String nome;
    LocalDate nascimento;
    String raca;
    Porte porte;
    Double peso;
    public EstadoAnimal estadoAnimal;
    public List<EsquemaVacinal> vacinas = new List<EsquemaVacinal>() {
        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean contains(Object o) {
            return false;
        }

        @Override
        public Iterator<EsquemaVacinal> iterator() {
            return null;
        }

        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        @Override
        public <T> T[] toArray(T[] a) {
            return null;
        }

        @Override
        public boolean add(EsquemaVacinal esquemaVacinal) {
            return false;
        }

        @Override
        public boolean remove(Object o) {
            return false;
        }

        @Override
        public boolean containsAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean addAll(Collection<? extends EsquemaVacinal> c) {
            return false;
        }

        @Override
        public boolean addAll(int index, Collection<? extends EsquemaVacinal> c) {
            return false;
        }

        @Override
        public boolean removeAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean retainAll(Collection<?> c) {
            return false;
        }

        @Override
        public void clear() {

        }

        @Override
        public EsquemaVacinal get(int index) {
            return null;
        }

        @Override
        public EsquemaVacinal set(int index, EsquemaVacinal element) {
            return null;
        }

        @Override
        public void add(int index, EsquemaVacinal element) {

        }

        @Override
        public EsquemaVacinal remove(int index) {
            return null;
        }

        @Override
        public int indexOf(Object o) {
            return 0;
        }

        @Override
        public int lastIndexOf(Object o) {
            return 0;
        }

        @Override
        public ListIterator<EsquemaVacinal> listIterator() {
            return null;
        }

        @Override
        public ListIterator<EsquemaVacinal> listIterator(int index) {
            return null;
        }

        @Override
        public List<EsquemaVacinal> subList(int fromIndex, int toIndex) {
            return null;
        }
    };
    String observacoes;

    public Animais(String nome, LocalDate nascimento, String raca, Porte porte, Double peso, EstadoAnimal estadoAnimal, List<EsquemaVacinal> vacinas, String observacoes) {
        this.nome = nome;
        this.nascimento = nascimento;
        this.raca = raca;
        this.porte = porte;
        this.peso = peso;
        this.estadoAnimal = estadoAnimal;
        this.vacinas = vacinas;
        this.observacoes = observacoes;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public Porte getPorte() {
        return porte;
    }

    public void setPorte(Porte porte) {
        this.porte = porte;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public EstadoAnimal getEstadoAnimal() {
        return estadoAnimal;
    }

    public void setEstadoAnimal(EstadoAnimal estadoAnimal) {
        this.estadoAnimal = estadoAnimal;
    }

    public List<EsquemaVacinal> getVacinas() {
        return vacinas;
    }

    public void setVacinas(List<EsquemaVacinal> vacinas) {
        this.vacinas = vacinas;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    @Override
    public String toString() {
        return "Animais{" +
                "nome='" + nome + '\'' +
                ", nascimento=" + nascimento +
                ", raca='" + raca + '\'' +
                ", porte=" + porte +
                ", peso=" + peso +
                ", estadoAnimal=" + estadoAnimal +
                ", vacinas=" + vacinas +
                ", observacoes='" + observacoes + '\'' +
                '}';
    }

    public void imprimirEsquemaVacinal() {
        for (EsquemaVacinal v : vacinas) {
            System.out.println("-> Data da Vacinação: " + v.getData() + " | Vacina: " + v.getVacina() + " | Observação da Vacina: " + v.getObservacao() + '\n');
            }
        }



    }

