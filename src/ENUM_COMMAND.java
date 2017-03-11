
public enum ENUM_COMMAND {
	/*Enumerado de los comandos que el usuario puede usar en la maquina virtualS*/
	/**
	 * Enumerado de los comandos que el usuario puede usar en la maquina virtual
	 */
	HELP,
	QUIT,
	NEWINST(1),
	RUN,
	RESET,
	REPLACE();
	
	int numArgs;
	
	ENUM_COMMAND(){
		this.numArgs = 0;
	}
	
	ENUM_COMMAND(int n){
		this.numArgs = n;
	}
	public int getNumArgs(){
		return numArgs;
	}
	
//	public static String inverso(ENUM_COMMAND command){
//		String commandstring = "";
//		if (command == ENUM_COMMAND.HELP) commandstring = "HELP";
//		else if (command == ENUM_COMMAND.QUIT ) commandstring = "QUIT";
//		else if (command == ENUM_COMMAND.NEWINST) commandstring = "NEWINST";
//		else if (command == ENUM_COMMAND.RUN) commandstring = "RUN";
//		else if (command == ENUM_COMMAND.RESET) commandstring = "RESET";
//		else if (command == ENUM_COMMAND.REPLACE) commandstring = "REPLACE";
//		return commandstring;		
//	}
//	
//	public static String Explication (ENUM_COMMAND command){
//		String definition = "";
//		if (command == ENUM_COMMAND.HELP) definition = ("Muestra esta ayuda");
//		else if (command == ENUM_COMMAND.QUIT) definition = ("Cierra la aplicacion");
//		else if (command == ENUM_COMMAND.NEWINST) definition = ("Introduce una nueva instruccion del programa");
//		else if (command == ENUM_COMMAND.RUN) definition = ("Ejecuta el programa");
//		else if (command == ENUM_COMMAND.RESET) definition = ("Vacia el programa actual");
//		else if (command == ENUM_COMMAND.REPLACE) definition = ("Reemplaza la instruccion N por la solicitada por el usuario");
//		
//		return definition;
//	}
	

}
