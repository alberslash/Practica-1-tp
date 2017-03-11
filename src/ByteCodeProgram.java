
public class ByteCodeProgram {
	/**
	 * Programa actual.
	 */
	
	private static final int MAX_INSTR = 100;
	private ByteCode[] bcprogram;
	private int numBc;
	
	public ByteCodeProgram(){
		this.bcprogram = new ByteCode[ByteCodeProgram.MAX_INSTR];
		this.numBc = 0;
	}
	/**
	 * Añadimos una instruccion al programa siempre que no haya llegado al maximo
	 * 
	 *
	 */
	public boolean addBCInstruction (ByteCode instr){ //Añade una instruccion al programa siempre que no haya llegado al maximo
		if (this.numBc < MAX_INSTR){
			bcprogram[numBc] = instr;
			numBc++;
			return true;
		}
		return false;		
	}
	
	public int getNumberOfByteCode(){
		return this.numBc;
		
	}
	
	public ByteCode getByteCode (int i){
		return this.bcprogram[i];
	}
	/**
	 * El toString muestra la instruccion almadenada
	 */
	public String toString(){ //Muestra una instruccion almacenada, se le llama con un for
		String mensaje = "";
		for(int i = 0; i < this.numBc; i++){
			mensaje += i + ": " + bcprogram[i].toString() + System.getProperty("line.separator");
		}
		return mensaje;
	}
	/**
	 * El el reset resetea todo el programa que llevamos almacenado.
	 */
	
	public void reset(){
		this.numBc = 0;
	}
	/**
	 *Realiza un cambio de instruccion que el usuario de introduce 
	 */
	public void replace (int replace, ByteCode bc) //Cambio de instrucciones
	{
		if (this.numBc < MAX_INSTR){
			bcprogram[replace] = bc;
		}

	}
}
