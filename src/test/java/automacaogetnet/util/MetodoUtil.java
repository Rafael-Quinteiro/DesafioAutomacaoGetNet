package automacaogetnet.util;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/* Classe responsável por armazenar métodos úteis ao projeto. */
public class MetodoUtil {

    /*Driver que será utilizado por todos os testes do sistema. */
    public WebDriver driver;

    /**
     * Construtor da classe.
     * @param driver : Driver utilizado pelo sistema.
     */
    public MetodoUtil(WebDriver driver) {
        this.driver = driver;
    }

    public void rolarAteOElementoDesejado(WebElement elemento) {
        new Actions(driver)
                .scrollToElement(elemento)
                .perform();
    }

    /**
     * Metodo que retorna um texto de um elemento.
     * @param elemento Elemento que será utilizado para obter o texto.
     * @return Retorna o elemento consultado.
     */
    public String obterTexto(WebElement elemento){
        return elemento.getText();
    }

    /**
     * Método para aguardar o elemento até ele ser clicável.
     * @param tempoMaximoEspera : Segundos para o elemento ser clicável.
     * @param elemento : Elemento a ser clicável.
    */
    public void aguardarElementoSerClicavel(Integer tempoMaximoEspera, WebElement elemento) {
        WebDriverWait esperar = new WebDriverWait(driver, Duration.ofSeconds(tempoMaximoEspera));
        esperar.until(ExpectedConditions.elementToBeClickable(elemento));
    }

    /**
     * Método para aguardar o carregamento de um elemento específico.
     * @param elemento : Elemento a ser carregado.
     * @param tempoMaximoEspera : Segundos para o carregamento do elemento.
     */
    public void aguardarElementoFicarVisivel(WebElement elemento, int tempoMaximoEspera) {
        WebDriverWait esperar = new WebDriverWait(driver, Duration.ofSeconds(tempoMaximoEspera));
	    elemento = esperar.until(ExpectedConditions.visibilityOf(elemento));
    }

    /**
     * Método responsável por aguardar um tempo pré-determinado.
     * @param tempoMaximoEspera : Tempo de espera explícito que deverá ser definido no método.
     * @throws InterruptedException
     */
    public void esperaExplicita(long tempoMaximoEspera) throws InterruptedException {
        Thread.sleep(tempoMaximoEspera);
    }

    /**
     * Método responsável por salvar o print na pasta de prints.
     * @param file : Diretório da pasta dos prints.
     * @param descricaoTeste : Descrição dos testes.
     */
    public String salvarCapturaDeTela(String file, String descricaoTeste) {
        File Destinationfile = new File("src/screenshots/" + descricaoTeste + ".png");
        File scrfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String absolutepath_screen = Destinationfile.getAbsolutePath();

        try {
            FileHandler.copy(scrfile, Destinationfile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return absolutepath_screen;
    }
}
