package automacaogetnet.runners;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import automacaogetnet.test.ContaSuperGet.ValidaMensagemDeTextoExplicativoDoCartaoSuperGetTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        ValidaMensagemDeTextoExplicativoDoCartaoSuperGetTest.class
})
@Categories.IncludeCategory(automacaogetnet.suites.AllTests.class)

/*Classe responsável por gerenciar a execução das categorias dos testes */
public class AllTests {
    
}
