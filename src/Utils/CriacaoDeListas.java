package Utils;

import enums.Servicos;
import models.Alimentos;
import models.Remedio;
import models.TabelaDeServicos;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CriacaoDeListas {

    public List<Remedio> criarListaRemedios() {
        List<Remedio> listaRemedios = new ArrayList<>();
        Remedio protetorHepatico = new Remedio(6, "Protetor Hepático ABC", BigDecimal.valueOf(15.00));
        Remedio vermifugo = new Remedio(7, "Vermífugo BCD", BigDecimal.valueOf(75.00));
        Remedio desparasitacaoExterna = new Remedio(8, "Desparasitação CDE", BigDecimal.valueOf(65.00));
        Remedio vitaminaPelos = new Remedio(9, "Vitamina para pelos DEF", BigDecimal.valueOf(90.00));
        Remedio analgesico = new Remedio(10, "Analgésico EFG", BigDecimal.valueOf(7.50));
        listaRemedios.add(protetorHepatico);
        listaRemedios.add(vermifugo);
        listaRemedios.add(desparasitacaoExterna);
        listaRemedios.add(vitaminaPelos);
        listaRemedios.add(analgesico);

        return listaRemedios;
    }

    public List<Alimentos> criarListaAlimentos () {
        List<Alimentos> listaAlimentos = new ArrayList<>();
        Alimentos racaoCaninaFilhote = new Alimentos(11, "Ração Canina para Filhotes 15kg", BigDecimal.valueOf(145.00));
        Alimentos racaoCaninaAdulto = new Alimentos(12, "Ração Canina para Adultos 23kg", BigDecimal.valueOf(380.50));
        Alimentos racaoFelinaFilhote = new Alimentos(13, "Ração Felina para Filhotes 5kg", BigDecimal.valueOf(60.00));
        Alimentos racaoFelinaAdulto = new Alimentos(14, "Ração Felina para Adultos 7kg", BigDecimal.valueOf(97.40));
        Alimentos racaoFelinaAlergicos = new Alimentos(15, "Ração Felina para alérgicos 6kg", BigDecimal.valueOf(138.00));
        listaAlimentos.add(racaoCaninaFilhote);
        listaAlimentos.add(racaoCaninaAdulto);
        listaAlimentos.add(racaoFelinaFilhote);
        listaAlimentos.add(racaoFelinaAdulto);
        listaAlimentos.add(racaoFelinaAlergicos);

        return listaAlimentos;
    }

    public List<TabelaDeServicos> criarListaDeServicos () {
        List<TabelaDeServicos> listaServicos = new ArrayList<>();
        TabelaDeServicos higienizacaoTosa = new TabelaDeServicos(1, "Tosa", BigDecimal.valueOf(90.00));
        TabelaDeServicos higienizacaoBanho = new TabelaDeServicos(2, "Banho", BigDecimal.valueOf(70.00));
        TabelaDeServicos higienizacaoBanhoETosa = new TabelaDeServicos(3, "Banho e Tosa", BigDecimal.valueOf(150.00));
        TabelaDeServicos atendimentoClinico = new TabelaDeServicos(4, "Atendimento Clínico", BigDecimal.valueOf(160.00));
        TabelaDeServicos vacinacao = new TabelaDeServicos(5, "Vacinação", BigDecimal.valueOf(90.00));

        listaServicos.add(higienizacaoTosa);
        listaServicos.add(higienizacaoBanho);
        listaServicos.add(higienizacaoBanhoETosa);
        listaServicos.add(atendimentoClinico);
        listaServicos.add(vacinacao);


        return listaServicos;
    }


}
