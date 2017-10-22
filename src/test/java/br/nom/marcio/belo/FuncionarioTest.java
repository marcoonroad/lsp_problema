package br.nom.marcio.belo;

import org.junit.Test;
import java.math.BigDecimal;

import static org.junit.Assert.*;

public class FuncionarioTest {
    @Test
    public void reajustarMensalistaTest ( ) {
        Funcionario mensalista = new Mensalista ("Marcio", new BigDecimal ("120000"));

        mensalista.reajustar (new BigDecimal ("5"));

        BigDecimal salarioAposReajuste = mensalista.getSalarioAnual ( );

        assertEquals (new BigDecimal ("126000.00"), salarioAposReajuste);
    }

    @Test(expected = IllegalArgumentException.class)
    public void reajustarMensalistaForaFaixaTest ( ) {
        Funcionario mensalista = new Mensalista ("Marcio", new BigDecimal ("120000.00"));

        // Fonte de erro:
        // Reajuste do mensalista tem que ser entre 0 e 10
        mensalista.reajustar (new BigDecimal ("15"));
    }

    // ======================================================================================

    @Test
    public void reajustarBonificadoTest ( ) {
        Funcionario bonificado = new Bonificado ("Ana", new BigDecimal ("80000.00"));

        bonificado.reajustar (BigDecimal.ONE);
        BigDecimal salarioAposReajuste = bonificado.getSalarioAnual ( );

        assertEquals (new BigDecimal ("80800.00"), salarioAposReajuste);
    }

    @Test
    public void bonificarBonificadoTest ( ) {
        Bonificado bonificado = new Bonificado ("Ana", new BigDecimal ("80000.00"));
        bonificado.acumularBonus (new BigDecimal ("4000"));

        BigDecimal salarioAposReajuste = bonificado.getSalarioAnual ( );

        assertEquals (new BigDecimal ("84000.00"), salarioAposReajuste);
    }

    @Test
    public void bonificadoQuebrouInvariant ( ) {
        Funcionario bonificado = new Bonificado ("Ana", new BigDecimal ("80000.00"));

        bonificado.reajustar (new BigDecimal ("9.00"));
        BigDecimal salarioAposReajuste = bonificado.getSalarioAnual ( );

        assertEquals (new BigDecimal ("87200.00"), salarioAposReajuste);
    }

    // ===========================================================================================

    @Test
    public void testVoluntario ( ) {
        Funcionario funcionario = new Voluntario ("Leo", new BigDecimal ("1000000"));

        assertEquals (new BigDecimal ("0.00"), funcionario.getSalarioAnual ( ));
    }

    @Test(expected=IllegalStateException.class)
    public void reajustarVoluntario ( ) {
        Funcionario funcionario = new Voluntario ("Jimmy Doidão", new BigDecimal ("200.00"));

        // Fonte de erro:
        // voluntário não tem reajuste pois não tem salário
        funcionario.reajustar (BigDecimal.ONE);
    }
}

// END
