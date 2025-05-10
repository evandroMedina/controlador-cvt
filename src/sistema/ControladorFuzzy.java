package sistema;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import net.sourceforge.jFuzzyLogic.FIS; //possibilita a leitura do arquivo .fcl
import net.sourceforge.jFuzzyLogic.FunctionBlock;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Variable;
import org.antlr.runtime.tree.Tree;

public class ControladorFuzzy {

    public static void main(String[] args) throws Exception {
        String filename = "controle_fuzzy.fcl";
        FIS fis = FIS.load(filename, true); //apresenta informações no terminal sobre o carregameto do arquivo no 

        if (fis == null) {
            System.err.println("Não foi possível carregar o arquivo .fcl: '" + filename + "'");
            System.exit(1);
        }

        //imprimi as funções de pertinência das variáveis
        JFuzzyChart.get().chart(fis);

        List<Trajeto> trajetos = new ArrayList<Trajeto>();
        Trajeto t1 = new Trajeto();

        FunctionBlock fb = fis.getFunctionBlock(null);

        //======== 1 - VEÍCULO PARADO =================//
        t1.setNome("T1 - Veículo Parado");
        t1.setRotacaoMotor(900);
        t1.setAberturaBorboleta(0);
        t1.setFrenagem(10);
        t1.setVelocidadeVeiculo(0);
        trajetos.add(t1);

        //======== 2 - VEÍCULO ARRANCANDO =================//
        Trajeto t2 = new Trajeto();

        t2.setNome("T2 - Veículo Arrancando");
        t2.setRotacaoMotor(1500);
        t2.setAberturaBorboleta(40);
        t2.setFrenagem(0);
        t2.setVelocidadeVeiculo(10);
        trajetos.add(t2);

        //======== 3 - VEÍCULO EM ALTA VELOCIDADE REDUZINDO PARA PARAR =================//
        Trajeto t3 = new Trajeto();

        t3.setNome("T3 - Veículo em alta velocidade reduzindo para parar ");
        t3.setRotacaoMotor(5500);
        t3.setAberturaBorboleta(0);
        t3.setFrenagem(8);
        t3.setVelocidadeVeiculo(90);
        trajetos.add(t3);

        //======== 4 - VEÍCULO EM VELOCIDADE MÉDIA EM ACELERAÇÃO PARA AUMENTO DA VELOCIDADE =================//
        Trajeto t4 = new Trajeto();

        t4.setNome("T4 - Veículo em velocidade média em aceleração para aumento da velocidade ");
        t4.setRotacaoMotor(4750);
        t4.setAberturaBorboleta(90);
        t4.setFrenagem(0);
        t4.setVelocidadeVeiculo(60);
        trajetos.add(t4);

        //======== 5 - VEÍCULO EM ALTA VELOCIADE EM ACLIVE =================//
        Trajeto t5 = new Trajeto();

        t5.setNome("T5 - Veículo em alta velocidade em aclive");
        t5.setRotacaoMotor(4500);
        t5.setAberturaBorboleta(100);
        t5.setFrenagem(0);
        t5.setVelocidadeVeiculo(150);
        trajetos.add(t5);

        //======== 6 - VEÍCULO EM ALTA VELOCIADE EM DECLIVE =================//
        Trajeto t6 = new Trajeto();

        t6.setNome("T6 - Veículo em alta velocide em declive ");
        t6.setRotacaoMotor(6500);
        t6.setAberturaBorboleta(0);
        t6.setFrenagem(0);
        t6.setVelocidadeVeiculo(180);
        trajetos.add(t6);

        //======== 7 - VEÍCULO EM ACLIVE ACENTUADO =================//
        Trajeto t7 = new Trajeto();

        t7.setNome("T7 - Veículo em aclive acentuado");
        t7.setRotacaoMotor(1500);
        t7.setAberturaBorboleta(90);
        t7.setFrenagem(0);
        t7.setVelocidadeVeiculo(20);
        trajetos.add(t7);

        //======== 8 - VEÍCULO EM DECLIVE ACENTUADO =================//Tr
        Trajeto t8 = new Trajeto();

        t8.setNome("T8 - Veículo em declive acentuado");
        t8.setRotacaoMotor(900);
        t8.setAberturaBorboleta(0);
        t8.setFrenagem(6);
        t8.setVelocidadeVeiculo(5);
        trajetos.add(t8);

        // Printa o bloco de função
        //System.out.println(fb);
        for (Trajeto t : trajetos) {
            fb.setVariable("rotacao_motor", t.getRotacaoMotor());
            fb.setVariable("abertura_borboleta", t.getAberturaBorboleta());
            fb.setVariable("frenagem", t.getFrenagem());
            fb.setVariable("velocidade_veiculo", t.getVelocidadeVeiculo());

            fb.evaluate();

            t.setAbertura_polia1(fb.getVariable("controlePolia1").getValue());
            t.imprimirTrajeto();

            fb.getVariable("controlePolia1").defuzzify();

            // Mostra o gráfico da variável de saída pelo Centro de Gravidade
            Variable resposta = fis.getVariable("controlePolia1");
            JFuzzyChart.get().chart(resposta, resposta.getDefuzzifier(), true);
        }
    }
}

/*
        System.out.println("Percentual (0 a 100) de abertura da Polia Primária " + new DecimalFormat(".##").format(fb.getVariable("controlePolia1").getValue()) + " %");
        System.out.println("Rotação do motor (0 a 6500) = " + fb.getVariable("rotacao_motor").getValue() + " RPM");
        System.out.println("Abertura da borboleta (0 a 100) = " + fb.getVariable("abertura_borboleta").getValue() + " % de abertura");
        System.out.println("Frenagem (0 a 10) = " + fb.getVariable("frenagem").getValue() + " bar");
        System.out.println("Velocidade do veículo (0 a 100) = " + fb.getVariable("velocidade_veiculo").getValue() + " Km/h\n");
 */
