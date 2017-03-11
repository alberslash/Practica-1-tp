
public enum ENUM_BYTECODE {
	/*Enumerado de las operaciones que puede introducir el usuario en la maquina virtual*/
	/**
	 * Enumerado de las operaciones que puede introucir el usuario en la maquina virtual.
	 */
	ADD,
	SUB,
	MUL,
	DIV,
	PUSH(1),
	LOAD(1),
	STORE(1),
	OUT,
	HALT;
	
	private int numArgs;
	
	ENUM_BYTECODE() {
		this(0);
		}
	ENUM_BYTECODE(int n){
		this.numArgs = n;
	}
	
	public int getNumArgs(){
		return numArgs;
	}
	
//	public static String bcInver(ENUM_BYTECODE bc){
//		String inver = "";
//		if (bc == ENUM_BYTECODE.ADD) inver = "ADD";
//		else if (bc == ENUM_BYTECODE.DIV) inver = "DIV";
//		else if (bc == ENUM_BYTECODE.LOAD) inver = "LOAD";
//		else if (bc == ENUM_BYTECODE.MUL) inver = "MUL";
//		else if (bc == ENUM_BYTECODE.PUSH) inver = "PUSH";
//		else if (bc == ENUM_BYTECODE.STORE) inver = "STORE";
//		else if (bc == ENUM_BYTECODE.SUB) inver = "SUB";
//		return inver;
//	}
}
