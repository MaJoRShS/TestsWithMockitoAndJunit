package services;

import br.ce.wcaquino.exception.NaoPodeDividirPorZeroException;

public class Calculadora {
    public int somar(int a, int b) {
        return a + b;
    }

    public int subtracao(int a, int b) {
        return a - b;
    }

    public int divide(int a, int b) throws NaoPodeDividirPorZeroException {
        if(b == 0 ){
            throw new NaoPodeDividirPorZeroException();
        }
        return a / b;
    }
}
