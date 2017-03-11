
public class Command {
	/**
	 *  Comandos de la aplicacion,
	  	estos pueden ser utilizados por el usuario, 
	  	acemos uso de enumerado de comandos
	 */

	private ENUM_COMMAND command;
	private ByteCode instruction;
	private int replace;
	private boolean salir = true;
/**
 * constructora para los metodos que no necesitan parametro
 * 
 */
	public Command (ENUM_COMMAND op){/* Sirve para las funciones que no necesitan int param*/
		this.command = op;
		this.instruction = null;
		this.replace = -1;
	}
	
	/**
	 * Constructora para los comandos de acceso a memoria,
	 * load, store...
	 * 
	 */
	public Command(ENUM_COMMAND mnemo, ByteCode bc){ /*Para Store, Load... */
		this.command = mnemo;
		this.instruction = bc;
		this.replace = - 1;
	}
	/**
	 * Constructora para las funciones que si necesitan parametros
	 * 
	 * 
	 */
	public Command(ENUM_COMMAND mnemo, int parametro){
		this.command = mnemo;
		this.replace = parametro;
	}
	
	/**
	 * en boolean execute comprobamos la ejecucion de cada comando,
	 * para ello accedemos a la clase engine y al enumerado de comandos,
	 * Para salir de la ejecucion usamos el boolano salir.
	 * 
	 */
	public boolean execute(Engine engine){
		 if(command == ENUM_COMMAND.HELP) engine.showHelp();
			
		 
		else if (command == ENUM_COMMAND.QUIT){
			System.out.println("Fin de la ejecucion.");
			engine.endExecution();
		}
		
		else if( this.command == ENUM_COMMAND.NEWINST){ //revisar ENUM_BYTECDE:bcInver, el parametro
			
			engine.addByteCodeInstruction(this.instruction);

		}
		else if (this.command == ENUM_COMMAND.RUN)	{
			if (!engine.executeCommandRun()) salir = false;
		}
				
		else if (this.command == ENUM_COMMAND.RESET)
		{
				if(engine.resetProgram()) salir = false;
		}
		 
		else if (this.command == ENUM_COMMAND.REPLACE){
			if(!engine.replaceByteCode(replace)) salir = false;
		}
			
		
		return salir;
	}
/**
 * Muestra los comandos introducidos.
 */
	public String toString (){
		if(this.command.getNumArgs() == 0){
			return this.command.name();
		}
		else if (this.command == ENUM_COMMAND.REPLACE){
			return this.command.name() + " " + replace;
		}
		else 
		{
			return  this.command.name() + " " + this.instruction.toString();
		}
	}
}
	
