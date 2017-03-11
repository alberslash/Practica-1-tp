public class CPU {
	/**
	 * Maquina virtual capaz de ejecutar un ByteCode
	 */
	private Memory memory = new Memory();
	private OperandStack stack = new OperandStack();
	private boolean end = false;
	
	/**
	 * Comprueba si la aplicacion es detenida o finalizada
	 */
	
	public boolean isHalted(){ //Deteniendo o finalizacion
		
		return end;
		
	}
	/**
	 * Muestra el estado de la cpu, la memoria y la pila
	 */
	
	public String toString(){
		String s = System.getProperty("line.separator") + 
				"Estado de la CPU: " + System.getProperty("line.separator") +
				"	Memoria: " + memory.toString() + System.getProperty("line.separator") +
				"	Pila: " + stack.toString() + System.getProperty("line.separator");
		return s;
	}
	
//comprueba las instrucciones y realiza las operaciones
	/**
	 * Comprobacion de las instruccciones y las operaciones.
	 * recibe una instruccion, comprueba que tipo es y devuelse y se ha realizado con exito la operacion.
	 * en todas las operaciones compara que este en el enumerado,
	 * en las operaciones que tenga el numero minimo de elemtos que pueda usar,
	 * y en las de acceso a memoria comprueba que puede acceder a ella mientras esta no este vacia
	 */
	public boolean execute(ByteCode instruction){
		if(instruction.getFunction() == ENUM_BYTECODE.ADD && this.stack.getNumElems() >= 2){ //Suma
			int cima = stack.getCima();
			//int subcima = stack.getSubCima();
			this.stack.pop();
			int subcima = stack.getCima();
			this.stack.pop();
			int suma = cima + subcima;		
			this.stack.push(suma);
		}
		else if (instruction.getFunction()== ENUM_BYTECODE.SUB && this.stack.getNumElems() >= 2){//Resta
			int cima = stack.getCima();
			//int subcima = stack.getSubCima();
			this.stack.pop();
			int subcima = stack.getCima();
			this.stack.pop();
			int resta = subcima - cima;
			this.stack.push(resta);

		}
		else if (instruction.getFunction() == ENUM_BYTECODE.DIV && this.stack.getNumElems() >= 2){ //Division
			int division = 0;
			int cima = stack.getCima();
			this.stack.pop();
			int subcima = stack.getCima();
			this.stack.pop();
			if (cima != 0){ 
				division = subcima / cima;
				this.stack.push(division);
			}
			else end = true;
		}
		else if (instruction.getFunction() == ENUM_BYTECODE.MUL && this.stack.getNumElems() >= 2){//Multiplicacion
			int cima = stack.getCima();
			this.stack.pop();
			int subcima = stack.getCima();
			this.stack.pop();
			int multiplicacion = cima * subcima;
			this.stack.push(multiplicacion);

		}
		else if (instruction.getFunction() == ENUM_BYTECODE.OUT){//Escribe el entero almacenado encima de la pila
			if(this.stack.getNumElems()> 1)
			System.out.println(this.stack.getCima());
			else System.out.println("<Vacia>");

		}
		
		else if(instruction.getFunction() == ENUM_BYTECODE.PUSH){//Apila elementos en la pila
			this.stack.push(instruction.getParam());

		}
		else if (instruction.getFunction() == ENUM_BYTECODE.STORE && !this.stack.isEmpty()){ //Escribe en pos de la memoria el contenido de la cima de la pila
			this.memory.write(instruction.getParam(), this.stack.getCima());
			this.stack.pop();

		}
		else if (instruction.getFunction() == ENUM_BYTECODE.LOAD)// Lee de la memoria el valor de pos
		{
			int pos = instruction.getParam();
			this.stack.push(this.memory.read(pos));

		}
		else if (instruction.getFunction() == ENUM_BYTECODE.HALT)//Para la maquina
		{
			this.end = true;
		}
		else end = true;
		return end;
	}
	
	

}
