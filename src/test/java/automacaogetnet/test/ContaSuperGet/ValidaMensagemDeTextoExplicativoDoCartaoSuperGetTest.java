package automacaogetnet.test.ContaSuperGet;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import com.aventstack.extentreports.ExtentTest;

import automacaogetnet.global.Constantes;
import automacaogetnet.page.ElementosBasePO;
import automacaogetnet.page.MenuContaSuperGetPO;
import automacaogetnet.page.MenuMaisSolucoesPO;
import automacaogetnet.suites.AllTests;
import automacaogetnet.test.BaseTest;
import automacaogetnet.test.ClasseExtentReporter.SparkReporterUtil;
import automacaogetnet.util.MetodoUtil;

/* Classe de testes de validar mensagem de texto explicativo do cartão SuperGet */
public class ValidaMensagemDeTextoExplicativoDoCartaoSuperGetTest extends BaseTest {

    /*Instância de ElementosBasePO. */ 
    private static ElementosBasePO elementosBasePO;

    /*Instância de MenuMaisSolucoesPO. */ 
    private static MenuMaisSolucoesPO menuMaisSolucoesPO;

    /*Instância de MenuContaSuperGetPO. */ 
    private static MenuContaSuperGetPO menuContaSuperGetPO;

    /*Instância de MétodoUtil. */ 
    private static MetodoUtil metodoUtil;

    /*Instancia de SparkReporterUtil. */
    public static SparkReporterUtil sparkReporterUtil;

    /*Nome da classe de teste. */
    private static final String descricaoRotina = "Valida Mensagem De Texto Explicativo Do Cartao SuperGet";

    /* Método responsável por iniciar as instâncias das classes necessárias para executar os testes. */
    @BeforeClass
    public static void iniciarTestes() {
        elementosBasePO = new ElementosBasePO(driver);
        menuMaisSolucoesPO = new MenuMaisSolucoesPO(driver);
        menuContaSuperGetPO = new MenuContaSuperGetPO(driver);
        metodoUtil = new MetodoUtil(driver);
        sparkReporterUtil = new SparkReporterUtil(driver);
    
        nomearTituloRelatorio(descricaoRotina);
    }

    /**
     * Método responsável por iniciar todos os pontos necessários antes de executar qualquer teste do sistema. *
     * @throws IOException Indica uma exceção I/O.
     */
    /*Metodo responsável por mover arquivo de relatório gerado para a devida pasta. */
    @AfterClass
    public static void MoveArquivoDeRelatorio() throws IOException {
        Path temp = Files.move
        (Paths.get("C:/DesafioAutomacaoGetNet/automacao-getnet/reports/Reports-Automation.html"),
        Paths.get("C:/DesafioAutomacaoGetNet/automacao-getnet/reports/Valida Mensagem De Texto Explicativo Do Cartao SuperGet/" + descricaoRotina + ".html"));
  
        if(temp != null)
        {
            System.out.println("");
        } else {
            System.out.println("Falha ao mover o arquivo para a pasta de relatório.");
        }
    }

    /*Teste responsável por validar texto da opção "Como ativar meu cartão SuperGet". */
    @Test
    @Category({AllTests.class})
    public void TC001_deve_Validar_Mensagem_De_Texto_Do_Cartao_SuperGet() {
        String descricaoTeste = "TC001_deve_Validar_Mensagem_De_Texto_Do_Cartao_SuperGet";
        String nomeScreenshot = this.getClass().getSimpleName() + descricaoTeste.substring(0, 5);
        ExtentTest teste = extent.createTest(descricaoTeste).assignDevice(Constantes.NAVEGADOR).assignDevice(Constantes.SISTEMA_OPERACIONAL);
        String textoComoAtivarMeuCartaoSuperGet = "Para ativar o seu cartão SuperGet, basta baixar o SuperGet na App Store ou Google Play. Para o seu primeiro acesso, você deve criar o seu login e senha: 1. Informe seu CPF e dados cadastrais para criação do login e senha do seu aplicativo; 2. Valide o e-mail cadastrado durante o credenciamento realizado na Getnet. Você receberá um código de ativação no seu e-mail para validação; 3. Acesse o menu “Cartões”; 4. Digite os dados do verso do seu cartão SuperGet; 5. Crie uma senha de 4 dígitos. Essa senha você irá utilizar para realizar compras com o seu Cartão SuperGet e fazer movimentações no seu APP SuperGet; 6. Pronto, o seu cartão foi ativado e você já pode começar a usá-lo.";

        try {
            metodoUtil.aguardarElementoFicarVisivel(elementosBasePO.btnPemitir, Constantes.TEMPO_MAXIMO_ESPERA);
            elementosBasePO.btnPemitir.click();

            metodoUtil.aguardarElementoSerClicavel(Constantes.TEMPO_MAXIMO_ESPERA, menuMaisSolucoesPO.spanMaisSolucoes);
            menuMaisSolucoesPO.spanMaisSolucoes.click();

            metodoUtil.aguardarElementoFicarVisivel(menuMaisSolucoesPO.linkContaSuperGet, Constantes.TEMPO_MAXIMO_ESPERA);
            menuMaisSolucoesPO.linkContaSuperGet.click();
            
            metodoUtil.aguardarElementoFicarVisivel(menuContaSuperGetPO.imageTelaInicialContaSuperGet, Constantes.TEMPO_MAXIMO_ESPERA);
            
            metodoUtil.rolarAteOElementoDesejado(menuContaSuperGetPO.inputComoAtivarMeuCartaoSuperGet);
            menuContaSuperGetPO.inputComoAtivarMeuCartaoSuperGet.click();

            metodoUtil.aguardarElementoFicarVisivel(menuContaSuperGetPO.textoComoAtivarMeuCartaoSuperGet, Constantes.TEMPO_MAXIMO_ESPERA);
            Assert.assertEquals(textoComoAtivarMeuCartaoSuperGet, metodoUtil.obterTexto(menuContaSuperGetPO.textoComoAtivarMeuCartaoSuperGet));

            sparkReporterUtil.rotularTesteSucesso(teste);
        } catch (Throwable t) {
            sparkReporterUtil.encerrarTesteFalha(teste, nomeScreenshot, t);
            irParaPaginaInicialDoGetNet(driver);        
        }
    }
}
 