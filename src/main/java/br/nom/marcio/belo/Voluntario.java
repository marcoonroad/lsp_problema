package br.nom.marcio.belo;

import java.math.BigDecimal;

public class Voluntario extends Funcionario {
    protected Voluntario (String nome, BigDecimal salarioAnualIgnorado) {
        super (nome, BigDecimal.ZERO);
    }

    @Override
    public void reajustar (BigDecimal taxa) {
        throw new IllegalStateException ("Não implementado!");
    }
}

// END
