package automacaogetnet.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/*Page object da página inicial do Getnet */
public class ElementosBasePO extends BasePO {

    /*Elemento de botão para permitir cookies do site */
    @FindBy(css = "a.cc-btn.cc-allow")
    public WebElement btnPemitir;

    /**
     * Construtor da classe.
     * @param driver Driver da página.
     */
    public ElementosBasePO(WebDriver driver) {
        super(driver);
    } 
}
