import Utils.CriacaoDeListas;
import VO.ResponseVO;
import enums.*;
import models.*;
import services.Petshop;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static enums.Vacinas.*;

public class Main {
    public static void main(String[] args) {

        // Criando o PetShop947
        Petshop petshop947 = new Petshop();

        // Setando e exibindo a lista de serviços, remédios e alimentos
        petshop947.verServicos();
        petshop947.verRemedios();
        petshop947.verAlimentos();

        // Criando o caso de teste.
        // Criando variaveis e listas necessarias para o cliente 1, que tem um único pet (Dobby).
        // Criando Lista de Animais do cliente em branco
        List<Animais> listaPetsMoises = new ArrayList<>();

        // Criando lista de vacinas do animal em branco
        List<EsquemaVacinal> esquemaVacinalDobby = new ArrayList<>();

        // Criando Esquema de vacina e setando a Vacina_1 para teste
        EsquemaVacinal vacina1TomadaDobby = new EsquemaVacinal(LocalDate.of(2020, 5, 30), VACINA_1, "Vacina aplicada");

        // Adicionando esquema de vacina do animal
        esquemaVacinalDobby.add(vacina1TomadaDobby);

        // Criando o animal do cliente, setando o esquema vacinal alimentado acima.
        Animais Dobby = new Cachorro("Dobby", LocalDate.of(2019, 3, 30), "Golden Retriever", Porte.GRANDE, 25.00, EstadoAnimal.SUJO, esquemaVacinalDobby, "Sem observação");

        // Adicionando o animal criado na lista de pets do cliente.
        listaPetsMoises.add(Dobby);

        // Criando o cliente, setando o ID e a lista de pets.
        Clientes Moises = new Clientes(1, listaPetsMoises);
        Moises.setNome("Moises");

        // Criando lista de pets para receber serviços no petshop
        List<Animais> petsParaReceberServicosMoises = new ArrayList<>();
        petsParaReceberServicosMoises.add(Dobby);


        // Criando variaveis e listas necessarias para o cliente 2, que tem 3 pets (Toto, Caramelo e Bichano).
        // Criando Lista de Animais do cliente em branco
        List<Animais> listaPetsThalles = new ArrayList<>();

        // Criando lista de vacinas dos animais em branco
        List<EsquemaVacinal> esquemaVacinalToto = new ArrayList<>();
        List<EsquemaVacinal> esquemaVacinalCaramelo = new ArrayList<>();
        List<EsquemaVacinal> esquemaVacinalBichano = new ArrayList<>();

        // Criando Esquema de vacina e setando as para teste
        EsquemaVacinal vacina1TomadaToto = new EsquemaVacinal(LocalDate.of(2022, 6, 12), VACINA_1, "Vacina aplicada");
        EsquemaVacinal vacina1TomadaCaramelo = new EsquemaVacinal(LocalDate.of(2022, 7, 30), VACINA_1, "Vacina aplicada");
        EsquemaVacinal vacina2TomadaCaramelo = new EsquemaVacinal(LocalDate.of(2022, 10, 30), Vacinas.VACINA_2, "Vacina aplicada");
        EsquemaVacinal vacina1TomadaBichano = new EsquemaVacinal(LocalDate.of(2022, 10, 20), VACINA_1, "Vacina aplicada");
        EsquemaVacinal vacina2TomadaBichano = new EsquemaVacinal(LocalDate.of(2022, 11, 20), Vacinas.VACINA_2, "Vacina aplicada");
        EsquemaVacinal vacina3TomadaBichano = new EsquemaVacinal(LocalDate.of(2022, 12, 20), Vacinas.VACINA_3, "Vacina aplicada");

        // Adicionando esquema de vacina dos animal
        esquemaVacinalToto.add(vacina1TomadaToto);
        esquemaVacinalCaramelo.add(vacina1TomadaCaramelo);
        esquemaVacinalCaramelo.add(vacina2TomadaCaramelo);
        esquemaVacinalBichano.add(vacina1TomadaBichano);
        esquemaVacinalBichano.add(vacina2TomadaBichano);
        esquemaVacinalBichano.add(vacina3TomadaBichano);

        // Criando os animais do cliente, setando os esquemas vacinais alimentados acima.
        Animais Toto = new Cachorro("Toto", LocalDate.of(2019, 2, 22), "Fox Paulistinha", Porte.MEDIO, 12.00, EstadoAnimal.SUJO, esquemaVacinalToto, "Sem observação");
        Animais Caramelo = new Cachorro("Caramelo", LocalDate.of(2020, 1, 15), "Fox Paulistinha", Porte.MEDIO, 12.00, EstadoAnimal.SUJO, esquemaVacinalToto, "Sem observação");
        Animais Bichano = new Cachorro("Bichano", LocalDate.of(2021, 11, 8), "Fox Paulistinha", Porte.MEDIO, 12.00, EstadoAnimal.SUJO, esquemaVacinalBichano, "Sem observação");

        // Adicionando o animal criado na lista de pets do cliente.
        listaPetsThalles.add(Toto);
        listaPetsThalles.add(Caramelo);
        listaPetsThalles.add(Bichano);

        // Criando o cliente, setando o ID e a lista de pets.
        Clientes Thalles = new Clientes(2, listaPetsThalles);
        Thalles.setNome("Thalles");

        // Criando lista de pets para receber serviços no petshop
        List<Animais> petsParaReceberServicosThalles = new ArrayList<>();
        petsParaReceberServicosThalles.add(Toto);
        petsParaReceberServicosThalles.add(Bichano);


        // Início dos testes do cliente com um único pet
        // Criando ResponseVO
        ResponseVO responseVO = new ResponseVO();

        // Teste de atendimento clinico

        // Imprimir estado do pet antes do serviço
        System.out.println("O cliente " + Moises.getNome() + " entregou o pet " + Dobby.getNome() + " para o serviço de " + Servicos.ATENDIMENTO_CLINICO);
        System.out.println("A observação cadastrada no animal " + Dobby.getNome() + " antes do serviço de " + Servicos.ATENDIMENTO_CLINICO + " é: " + Dobby.getObservacoes());

        // Enviando animal para Atendimento Clínico
        responseVO = petshop947.atendimentoClinico(Moises, petsParaReceberServicosMoises, "Avaliação Clínica");
        System.out.println(responseVO.toString());


        // Teste de Vacinação

        // Imprimir estado do pet antes do serviço
        System.out.println("O cliente " + Moises.getNome() + " entregou o pet " + Dobby.getNome() + " para o serviço de " + Servicos.VACINACAO);
        System.out.println("A observação cadastrada no animal " + Dobby.getNome() + " antes do serviço de " + Servicos.VACINACAO + " é: " + Dobby.getObservacoes());
        System.out.println("O esquema vacinal do animal antes do serviço é: ");
        Dobby.imprimirEsquemaVacinal();

        // Setando lista de vacinas a serem aplicadas.
        List<Vacinas> vacinasParaSeremAplicadasMoises = new ArrayList<>();
        for (Animais a : Moises.getPets()) {
            String indicacaoVacina = a.getObservacoes();
            List<Vacinas> vacinasParaSeremTomadas = new ArrayList<>();
            if (indicacaoVacina.equals("Tomar a " + VACINA_1)) {
                vacinasParaSeremTomadas.add(VACINA_1);
            } else if ((indicacaoVacina.equals("Tomar a " + VACINA_2))) {
                vacinasParaSeremAplicadasMoises.add(VACINA_2);
            } else if ((indicacaoVacina.equals("Tomar a " + VACINA_3))) {
                vacinasParaSeremAplicadasMoises.add(VACINA_3);
            } else if ((indicacaoVacina.equals("Tomar a " + VACINA_4))) {
                vacinasParaSeremAplicadasMoises.add(VACINA_4);
            } else if ((indicacaoVacina.equals("Tomar a " + VACINA_5))) {
                vacinasParaSeremAplicadasMoises.add(VACINA_5);
            }
        }

        // Enviando animal para Vacinação
        responseVO = petshop947.vacinacao(Moises, Moises.getPets(), vacinasParaSeremAplicadasMoises, Dobby.getObservacoes());
        System.out.println(responseVO.toString());

        // Imprimir estado do pet depois do serviço
        System.out.println("A observação cadastrada no animal " + Dobby.getNome() + " depois do serviço de " + Servicos.VACINACAO + " é: " + Dobby.getObservacoes());
        System.out.println("O esquema vacinal do animal depois do serviço é: ");
        Dobby.imprimirEsquemaVacinal();


        // Imprimir estado do pet antes do serviço
        System.out.println("O cliente " + Moises.getNome() + " entregou o pet " + Dobby.getNome() + " para o serviço de " + Higiene.BANHO);
        System.out.println("O estado do animal " + Dobby.getNome() + "antes do serviço é: " + Dobby.estadoAnimal);


        // Enviando animal para Higienização
        responseVO = petshop947.higienizacao(Moises, petsParaReceberServicosMoises, Higiene.BANHO, "Banho comum");
        System.out.println(responseVO.toString());

        // Imprimir estado do pet depois do serviço
        System.out.println("O estado do animal " + Dobby.getNome() + "depois do serviço é: " + Dobby.estadoAnimal);


        // Testando método de pagamento
        // Setando Lista de inteiros com IDs dos serviços e produtos adquiridos

        List<Integer> listaCarrinho = new ArrayList<>();
        listaCarrinho.add(4);
        listaCarrinho.add(5);
        listaCarrinho.add(2);
        listaCarrinho.add(9);
        listaCarrinho.add(12);

        // Chamando metodo de pagamento com lista de serviços e produtos
        petshop947.pagamento(listaCarrinho);


        // Início dos testes para o cliente com mais de um pet

        // Teste de atendimento clinico

        // Imprimir estado do pet antes do serviço
        System.out.println("O cliente " + Thalles.getNome() + " entregou o pet " + Toto.getNome() + " para o serviço de " + Servicos.ATENDIMENTO_CLINICO);
        System.out.println("A observação cadastrada no animal " + Toto.getNome() + " antes do serviço de " + Servicos.ATENDIMENTO_CLINICO + " é: " + Toto.getObservacoes());
        System.out.println("O cliente " + Thalles.getNome() + " entregou o pet " + Bichano.getNome() + " para o serviço de " + Servicos.ATENDIMENTO_CLINICO);
        System.out.println("A observação cadastrada no animal " + Bichano.getNome() + " antes do serviço de " + Servicos.ATENDIMENTO_CLINICO + " é: " + Bichano.getObservacoes());


        // Enviando animais para Atendimento Clínico
        responseVO = petshop947.atendimentoClinico(Thalles, petsParaReceberServicosThalles, "Avaliação Clínica");
        System.out.println(responseVO.toString());


        // Teste de Vacinação

        // Imprimir estado dos pets antes do serviço
        System.out.println("O cliente " + Thalles.getNome() + " entregou o pet " + Toto.getNome() + " para o serviço de " + Servicos.VACINACAO);
        System.out.println("A observação cadastrada no animal " + Toto.getNome() + " antes do serviço de " + Servicos.VACINACAO + " é: " + Toto.getObservacoes());
        System.out.println("O esquema vacinal do animal " + Toto.getNome() + " antes do serviço é: ");
        Toto.imprimirEsquemaVacinal();

        System.out.println("O cliente " + Thalles.getNome() + " entregou o pet " + Bichano.getNome() + " para o serviço de " + Servicos.VACINACAO);
        System.out.println("A observação cadastrada no animal " + Bichano.getNome() + " antes do serviço de " + Servicos.VACINACAO + " é: " + Bichano.getObservacoes());
        System.out.println("O esquema vacinal do animal " + Bichano.getNome() + " antes do serviço é: ");
        Bichano.imprimirEsquemaVacinal();

        // Setando lista de vacinas a serem aplicadas.
        List<Vacinas> vacinasParaSeremAplicadasThalles = new ArrayList<>();
        for (Animais a : Thalles.getPets()) {
            String indicacaoVacina = a.getObservacoes();
            List<Vacinas> vacinasParaSeremTomadas = new ArrayList<>();
            if (indicacaoVacina.equals("Tomar a " + VACINA_1)) {
                vacinasParaSeremTomadas.add(VACINA_1);
            } else if ((indicacaoVacina.equals("Tomar a " + VACINA_2))) {
                vacinasParaSeremAplicadasThalles.add(VACINA_2);
            } else if ((indicacaoVacina.equals("Tomar a " + VACINA_3))) {
                vacinasParaSeremAplicadasThalles.add(VACINA_3);
            } else if ((indicacaoVacina.equals("Tomar a " + VACINA_4))) {
                vacinasParaSeremAplicadasThalles.add(VACINA_4);
            } else if ((indicacaoVacina.equals("Tomar a " + VACINA_5))) {
                vacinasParaSeremAplicadasThalles.add(VACINA_5);
            }
        }


        // Enviando animais para Vacinação
        responseVO = petshop947.vacinacao(Thalles, petsParaReceberServicosThalles, vacinasParaSeremAplicadasThalles, Toto.getObservacoes());
        System.out.println(responseVO.toString());


        // Imprimir estado dos pets depois do serviço
        System.out.println("A observação cadastrada no animal " + Toto.getNome() + " depois do serviço de " + Servicos.VACINACAO + " é: " + Toto.getObservacoes());
        System.out.println("O esquema vacinal do animal " + Toto.getNome() + " depois do serviço é: ");
        Toto.imprimirEsquemaVacinal();
        System.out.println("A observação cadastrada no animal " + Bichano.getNome() + " depois do serviço de " + Servicos.VACINACAO + " é: " + Bichano.getObservacoes());
        System.out.println("O esquema vacinal do animal " + Bichano.getNome() + " depois do serviço é: ");
        Bichano.imprimirEsquemaVacinal();


        // Imprimir estado do pet antes do serviço
        System.out.println("O cliente " + Thalles.getNome() + " entregou o pet " + Toto.getNome() + " para o serviço de " + Higiene.BANHO_E_TOSA);
        System.out.println("O estado do animal antes do serviço é: " + Toto.estadoAnimal);
        System.out.println("O cliente " + Thalles.getNome() + " entregou o pet " + Bichano.getNome() + " para o serviço de " + Higiene.BANHO_E_TOSA);
        System.out.println("O estado do animal antes do serviço é: " + Bichano.estadoAnimal);


        // Enviando animal para Higienização
        responseVO = petshop947.higienizacao(Thalles, petsParaReceberServicosThalles, Higiene.BANHO_E_TOSA, "Banho e tosa");
        System.out.println(responseVO.toString());

        // Imprimir estado do pet depois do serviço
        System.out.println("O estado do animal " + Toto.getNome() + " depois do serviço é: " + Toto.estadoAnimal);
        System.out.println("O estado do animal " + Bichano.getNome() + " depois do serviço é: " + Bichano.estadoAnimal);


        // Testando método de pagamento
        // Setando Lista de inteiros com IDs dos serviços e produtos adquiridos

        List<Integer> listaCarrinho2 = new ArrayList<>();
        listaCarrinho2.add(4);
        listaCarrinho2.add(4);
        listaCarrinho2.add(5);
        listaCarrinho2.add(5);
        listaCarrinho2.add(3);
        listaCarrinho2.add(3);
        listaCarrinho2.add(6);
        listaCarrinho2.add(8);
        listaCarrinho2.add(11);
        listaCarrinho2.add(13);

        // Chamando metodo de pagamento com lista de serviços e produtos
        petshop947.pagamento(listaCarrinho2);
    }

}

