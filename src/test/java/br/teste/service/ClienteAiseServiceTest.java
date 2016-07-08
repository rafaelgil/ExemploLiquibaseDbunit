package br.teste.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;

import br.domain.Cliente;
import br.service.ServiceCliente;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:/spring.xml")
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
        DbUnitTestExecutionListener.class })
@DatabaseSetup("/dbunit/cliente.xml")
public class ClienteAiseServiceTest extends AbstractTransactionalJUnit4SpringContextTests{
	
	@Autowired
	private ServiceCliente clienteService;
		
	@Test
	public void testFindById(){
		Cliente cliente = clienteService.findById(1l);
		Assert.assertNotNull(cliente);
		Assert.assertEquals("RONALD A. WALLACE", cliente.getNome());
	}
	
	@Test
	@ExpectedDatabase(value="/dbunit/expected/cliente.xml", assertionMode=DatabaseAssertionMode.NON_STRICT_UNORDERED)
	public void salvar(){
		Cliente cliente = new Cliente();
		cliente.setCodigo(10L);
		cliente.setCpf("691.152.720-10");
		cliente.setRg("22.223.317-5");
		cliente.setNome("EMANUEL YURI CARLOS EDUARDO CAMPOS");
		
		clienteService.salvar(cliente);
	}

}
