package automacaogetnet.global;

/*Classe responsável por armazenar variáveis utilizadas por todo o projeto. */
public class Constantes {
    
    /*Versão do Chrome Driver */
    public static final String VERSAO_CHROME_DRIVER = "111";
    
    /*Tempo máximo de espera de elementos. */
    public final static int TEMPO_MAXIMO_ESPERA = 20;

    /*Constante da página inicial do Getnet. */
    public static final String URL_BASE = "https://site.getnet.com.br/"; 

    /*Constante do caminho do chromedriver. */
    public static final String PATH_CHROME_DRIVER = "src/test/java/automacaogetnet/resource/chromedriver-" + VERSAO_CHROME_DRIVER +".exe";

    /*Versão do navegador usado para testes. */
    public static final String NAVEGADOR = "Google Chrome" + VERSAO_CHROME_DRIVER;

    /*Sistema operacional do ambiente de testes. */
    public static final String SISTEMA_OPERACIONAL = System.getProperty("os.name");
}
