package services;

import br.ce.wcaquino.exception.NaoPodeDividirPorZeroException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculadoraTest {

    private Calculadora calc;

    @Before
    public void setUp(){
        calc = new Calculadora();
    }

    @Test
    public void deveSomarDoisValores(){
        //cenário
        int a = 5;
        int b = 3;


        //ação
        int result = calc.somar(a,b);

        //verificação
        Assert.assertEquals(8,result);
    }

    @Test
    public void deveSubtrairDoisValores(){
        int a = 8;
        int b = 5;


        int result = calc.subtracao(a,b);

        Assert.assertEquals(3,result);

    }

    @Test
    public void deveDividirDoisValores() throws NaoPodeDividirPorZeroException {
        int a = 6;
        int b = 3;

        int resultado = calc.divide(a,b);

        Assert.assertEquals(2,resultado);

    }

    @Test(expected = NaoPodeDividirPorZeroException.class)
    public void deveLancarExcecaoAoDividirPorZero() throws NaoPodeDividirPorZeroException {
        int a = 10;
        int b = 0;


        calc.divide(a,b);
        Assert.assertEquals(a,b);
    }
}
