
public class ByteCode {
	/**
	 *  ByteCodes de la practica.
	 *  Funciones que necesitan o no parametros, 
	 *  para las que usan el acceso a memoria(load, strore..),
	 * 
	 */
	private int param;
	private ENUM_BYTECODE funct;
	/**
	 * Sirve para las funciones que no necesitan el int param
	 * 
	 */
	public ByteCode (ENUM_BYTECODE op){/* Sirve para las funciones que no necesitan int param*/
		this.funct = op;
	}
	/**
	 * Funciones de acceso a memoria, load, store
	 */
	
	public ByteCode(ENUM_BYTECODE mnemo, int param){ /*Para Store, Load... */
		this.funct = mnemo;
		this.param = param;
	}

	/**
	 * Se pide cual es el parametro de las funciones que lo necesitan
	 * 
	 */
	public int getParam(){ /*Pedimos cual es el parametro de las funciones que lo necesiten*/
		return this.param;
	}
	/**
	 * Muestra el ojeto por pantalla
	 */
	
	public String toString(){ /*Mostrar el objeto por pantalla*/
		return this.funct + (funct.getNumArgs() > 0 ? (" " + param) : "");
	}
	
	public ENUM_BYTECODE getFunction() {
		return this.funct;
	}


	
}



	
	
	
	
	 


