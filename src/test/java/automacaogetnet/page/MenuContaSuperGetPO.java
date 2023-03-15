package automacaogetnet.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/*Page object do Menu "Conta SuperGet" */
public class MenuContaSuperGetPO extends BasePO {

    /*Elemento de input de opção "Como ativar meu cartão SuperGet" */
    @FindBy(css = "#faq-accordion-2")
    public WebElement inputComoAtivarMeuCartaoSuperGet;

    /*Elemento de texto de "Como ativar meu cartão SuperGet" */
    @FindBy(css = "li:nth-child(3) > div > div > p")
    public WebElement textoComoAtivarMeuCartaoSuperGet;

    /*Elemento de imagem do menu "Conta SuperGet" */
    @FindBy(css = "div.gn-banner-bloco-2.gn-desk > img")
    public WebElement imageTelaInicialContaSuperGet;

	/**
     * Construtor da classe.
     * @param driver Driver da página.
     */
    public MenuContaSuperGetPO(WebDriver driver) {
        super(driver);
    }
}
