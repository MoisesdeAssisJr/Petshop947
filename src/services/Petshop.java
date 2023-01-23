package services;

import Utils.CriacaoDeListas;
import VO.ResponseVO;
import enums.EstadoAnimal;
import enums.Higiene;
import enums.Servicos;
import enums.Vacinas;
import models.*;

import java.math.BigDecimal;

import java.time.LocalDate;
import java.util.*;

import static enums.Vacinas.*;

public class Petshop {

    String cnpj;
    Endereco endereco;
    final BigDecimal PRECO_HIGIENIZAR_TOSA = BigDecimal.valueOf(90);
    final BigDecimal PRECO_HIGIENIZAR_BANHO = BigDecimal.valueOf(70);
    final BigDecimal PRECO_HIGIENIZAR_BANHO_E_TOSA = BigDecimal.valueOf(150);
    final BigDecimal PRECO_ATENDIMENTO_CLINICO = BigDecimal.valueOf(160);
    final BigDecimal PRECO_VACINACAO = BigDecimal.valueOf(90);

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }


    public ResponseVO higienizacao(Clientes cliente, List<Animais> animais, Higiene higiene, String observacao) {
        BigDecimal precoHigienizacao = BigDecimal.ZERO;
        for (Animais a : animais) {
            switch (higiene) {
                case BANHO -> {
                    a.estadoAnimal = EstadoAnimal.LIMPO;
                    precoHigienizacao = precoHigienizacao.add(PRECO_HIGIENIZAR_BANHO);
                }
                case TOSA -> {
                    a.estadoAnimal = EstadoAnimal.TOSADO;
                    precoHigienizacao = precoHigienizacao.add(PRECO_HIGIENIZAR_TOSA);
                }
                case BANHO_E_TOSA -> {
                    a.estadoAnimal = EstadoAnimal.LIMPO_E_TOSADO;
                    precoHigienizacao = precoHigienizacao.add(PRECO_HIGIENIZAR_BANHO_E_TOSA);
                }
            }
        }
        BigDecimal qtdAnimais = BigDecimal.valueOf(animais.size());

        return new ResponseVO(cliente.getId(), Servicos.HIGIENIZAR, precoHigienizacao.multiply(qtdAnimais), cliente);
    }

    public ResponseVO atendimentoClinico(Clientes cliente, List<Animais> animais, String observacao) {
        for (Animais a : animais) {
            Random random = new Random();
            int observacaoAtendimentoClinico = random.nextInt(1, 6);
            if (observacaoAtendimentoClinico == 1) {
                a.setObservacoes("Tomar a " + VACINA_1);
            } else if (observacaoAtendimentoClinico == 2) {
                a.setObservacoes("Tomar a " + VACINA_2);
            } else if (observacaoAtendimentoClinico == 3) {
                a.setObservacoes("Tomar a " + VACINA_3);
            } else if (observacaoAtendimentoClinico == 4) {
                a.setObservacoes("Tomar a " + VACINA_4);
            } else if (observacaoAtendimentoClinico == 5) {
                a.setObservacoes("Tomar a " + VACINA_5);
            }
            System.out.println("Após atendimento clínico, o animal " + a.getNome() + " recebeu a seguinte observação clínica: " + a.getObservacoes());
        }

        BigDecimal qtdAnimais = BigDecimal.valueOf(animais.size());
        return new ResponseVO(cliente.getId(), Servicos.ATENDIMENTO_CLINICO, PRECO_ATENDIMENTO_CLINICO.multiply(qtdAnimais), cliente);
    }

    public ResponseVO vacinacao(Clientes cliente, List<Animais> animal, List<Vacinas> vacina, String observacao) {
        BigDecimal precoVacinas = BigDecimal.ZERO;
        Boolean vacinaJaAplicada = false;
        for (Animais a: animal) {
            EsquemaVacinal esquemaVacinalAntes = null;
            for (int i = 0; i < a.getVacinas().size(); i++) {
                esquemaVacinalAntes = a.getVacinas().get(i);
                if (esquemaVacinalAntes.equals(vacina)) {
                    vacinaJaAplicada = true;
                }
            }
        }
            for (int i = 0; i < vacina.size() ; i++) {
                Animais animalControle = animal.get(i);
                List<EsquemaVacinal> esquemaVacinalControle = new ArrayList<>();
                esquemaVacinalControle = animalControle.getVacinas();
                for (int j = 0; j < esquemaVacinalControle.size(); j++) {
                    Vacinas vacinaControle = esquemaVacinalControle.get(j).getVacina();
                    if (vacinaJaAplicada) {
                        System.out.println(vacina.get(i) + " já aplicada no animal " + animalControle.getNome());
                        animalControle.setObservacoes("Esquema vacinal atualizado." + '\n');
                        break;
                    } else if (!vacinaJaAplicada && vacina.indexOf(vacina.get(i)) == animal.indexOf(animalControle)){
                        animalControle.vacinas.add(new EsquemaVacinal(LocalDate.parse("2022-01-20"), vacina.get(i), "Vacina Aplicada"));
                        precoVacinas = precoVacinas.add(PRECO_VACINACAO);
                        System.out.println(vacina.get(i) + " aplicada no animal " + animalControle.getNome() + " | Preço: R$" + PRECO_VACINACAO);
                        animalControle.setObservacoes("Esquema vacinal atualizado." + '\n');
                        break;
                    }
                }
            }
        return new ResponseVO(cliente.getId(), Servicos.VACINACAO, precoVacinas, cliente);
    }

    public void verAlimentos() {
        CriacaoDeListas listaAlimentos = new CriacaoDeListas();

        List<Alimentos> catalogoAlimentos = listaAlimentos.criarListaAlimentos();
        System.out.println("---#--- PetShop 947 ---#---");
        System.out.println(" - Catálogo de Alimentos: - ");
        System.out.println(catalogoAlimentos.toString() + '\n');

    }

    public void verRemedios() {
        CriacaoDeListas listaRemedios = new CriacaoDeListas();

        List<Remedio> catalogoRemedios = listaRemedios.criarListaRemedios();
        System.out.println("---#--- PetShop 947 ---#---");
        System.out.println(" - Catálogo de Remédios: - ");
        System.out.println(catalogoRemedios.toString() + '\n');
    }

    public void verServicos() {
        CriacaoDeListas listaServicos = new CriacaoDeListas();

        List<TabelaDeServicos> catalogoServicos = listaServicos.criarListaDeServicos();
        System.out.println("---#--- PetShop 947 ---#---");
        System.out.println(" - Catálogo de Serviços: - ");
        System.out.println(catalogoServicos.toString() + '\n');
    }

    public void pagamento(List<Integer> itens) {
        CriacaoDeListas listaAlimentos = new CriacaoDeListas();
        List<Alimentos> catalogoAlimentos = listaAlimentos.criarListaAlimentos();

        CriacaoDeListas listaRemedios = new CriacaoDeListas();
        List<Remedio> catalogoRemedios = listaRemedios.criarListaRemedios();

        CriacaoDeListas listaServicos = new CriacaoDeListas();
        List<TabelaDeServicos> catalogoServicos = listaServicos.criarListaDeServicos();

        BigDecimal totalCarrinho = BigDecimal.ZERO;

        System.out.println('\n' + "---#--- PetShop 947 ---#---");
        System.out.println("   -    Cupom Fiscal   -   ");
        System.out.println("Lista de serviços e produtos adquiridos - Preço");

        for (Integer i : itens) {
                if (i <= 5) {
                    for (int j = 0; j <= 4; j++) {
                        int idControle = catalogoServicos.get(j).getId();
                        if (idControle == i) {
                            String servicoAdquirido = catalogoServicos.get(i-1).getNome();
                            BigDecimal precoServicoAdquirido = catalogoServicos.get(i-1).getPreco();
                            System.out.println("ID: " + i + " | Serviço: " + servicoAdquirido + " - Preço: R$" + precoServicoAdquirido);
                            totalCarrinho = totalCarrinho.add(precoServicoAdquirido);
                        }
                    }
                } else if (i >= 6 && i <= 10) {
                    for (int j = 0; j <= 4; j++) {
                        int idControle = catalogoRemedios.get(j).getId();
                        if (idControle == i) {
                            String remedioAdquirido = catalogoRemedios.get(i-6).getNome();
                            BigDecimal precoRemedioAdquirido = catalogoRemedios.get(i-6).getPreco();
                            System.out.println("ID: " + i + " | Remédio: " + remedioAdquirido + " - Preço: R$" + precoRemedioAdquirido);
                            totalCarrinho = totalCarrinho.add(precoRemedioAdquirido);
                        }
                    }
                } else if (i >= 11 && i <= 15) {
                    for (int j = 0; j <= 4; j++) {
                        int idControle = catalogoAlimentos.get(j).getId();
                        if (idControle == i) {
                            String alimentoAdquirido = catalogoAlimentos.get(i-11).getNome();
                            BigDecimal precoAlimentoAdquirido = catalogoAlimentos.get(i-11).getPreco();
                            System.out.printf("ID: " + i + " | Alimento: " + alimentoAdquirido + " - Preço: R$" + precoAlimentoAdquirido + '\n');
                            totalCarrinho = totalCarrinho.add(precoAlimentoAdquirido);
                        }
                    }
                }
            }
        System.out.println('\n' + "Total: R$" + totalCarrinho);
        System.out.println("---#--- PetShop 947 ---#---");
        System.out.println("Volte Sempre!" + '\n');
        }
    }







