package pruebasTesteo;

import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import org.junit.jupiter.api.Test;
import java.time.*;
import org.junit.BeforeClass;


class EmployeeTest2 {

	static int mes = LocalDate.now().getMonthValue();;
	static Employee AWorker;
	static Employee BWorker;
	static Employee CManager;
	static Employee DSupervisor;
	static float A;
	static float B;
	static float C;
	static float D;

	Employee empleado_worker = new Employee(5000, "USD", 0.0F, EmployeeType.Worker);
	Employee empleado_supervisor = new Employee(100, "USD", 0.12F, EmployeeType.Supervisor);
	Employee empleado_manager = new Employee(3750, "USD", 15.2F, EmployeeType.Manager);

	
	
	
@Test
void Imtest() throws IOException {
	Boolean isEven = false;
	AWorker = new Employee(1000f, "USD", 10f, EmployeeType.Worker);
	BWorker = new Employee(1000f, "Pesos", 10f, EmployeeType.Worker);
	CManager = new Employee(3000f, "USD", 25f, EmployeeType.Manager);
	DSupervisor = new Employee(3000f, "Yen", 25f, EmployeeType.Manager);
	C = isEven ? 3017.5f : 3081.83f;
	D = isEven ? 2867.5f : 2931.8333333333f;
	A= isEven ? 1000f : 1064 + 1 / 3f;
	B = isEven ? 950f : 1014 + 1 / 3f;
	assertEquals(AWorker.cs(), A);
	assertEquals(BWorker.cs(), B);
	assertEquals(CManager.cs(), C);
	assertEquals(DSupervisor.cs(), D);
	
}
	
	
	

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
