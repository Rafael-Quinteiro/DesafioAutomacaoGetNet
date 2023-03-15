package automacaogetnet.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/*Page object do Menu "Mais Soluções" */
public class MenuMaisSolucoesPO extends BasePO {

    /*Elemento de span de opção do menu "Mais Soluções" */
    @FindBy(css = "#menu-header-menu > li:nth-child(2) > span")
    public WebElement spanMaisSolucoes;

    /*Elemento de link de opção "Conta SuperGet" do menu "Mais Soluções" */
    @FindBy(css = "li:nth-child(3) > ul > li:nth-child(3) > a")
    public WebElement linkContaSuperGet;

	/**
     * Construtor da classe.
     * @param driver Driver da página.
     */
    public MenuMaisSolucoesPO(WebDriver driver) {
        super(driver);
    }
}
