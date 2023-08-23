package pruebasTesteo;

import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EmployeeTest2 {

	Employee empleado_worker = new Employee(5000, "USD", 0.0F, EmployeeType.Worker);
	Employee empleado_supervisor = new Employee(100, "USD", 0.12F, EmployeeType.Supervisor);
	Employee empleado_manager = new Employee(3750, "USD", 15.2F, EmployeeType.Manager);

	// Se pone a prueba en el método cuando el EmployeeType es Worker, supervisor y manager

	@Test
	@DisplayName("Bono segun tipo de trabajador 'USD'")
	void bonoSegunTipoDeTrabajadorUsd() {
		assertAll("Bono USD", () -> assertEquals(599.0, empleado_worker.CalculateYearBonus(), 1),
				() -> assertEquals(999.0, empleado_supervisor.CalculateYearBonus(), 1),
				() -> assertEquals(1999.0, empleado_manager.CalculateYearBonus(), 1));
	}
	
	// caso de prueba cuando la moneda no es de tipo dolar

	@Test
	@DisplayName("Bono segun tipo de trabajador 'no dinero en USD' ")
	void bonoSegunTipoDeTrabajadorNotUsd() {
		assertAll("Bono USD", () -> assertEquals(354.0, empleado_worker.CalculateYearBonus(), 1),
				() -> assertEquals(355.0, empleado_supervisor.CalculateYearBonus(), 1),
				() -> assertEquals(9999.0, empleado_manager.CalculateYearBonus(), 1));
	}

}
