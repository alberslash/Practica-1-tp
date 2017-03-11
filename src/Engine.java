import java.util.Scanner;

public class Engine {
	/**
	 * La clase engine interpreta los comandos. Lo primero que encontramos 
	 * son las constructoras y el enumerado.
	 */
  /*Clase que interpreta los comandos*/
  private ByteCodeProgram program;
  private boolean end;
  private static Scanner in = new Scanner(System.in);
  private ENUM_COMMAND funct;
  
  public ENUM_COMMAND getOpcode(){
      return this.funct;
    }
  
  public Engine(){
    this.program =new ByteCodeProgram();
    this.end =false;
    
  }
  /**
   * La funcion start inicia la aplicacion, comprueba lo que el usuario
   * ha introducido, en caso de ser correcto realiza las operaciones indicadas,
   * de lo contrario muestra el error por pantalla.
   */
  public void start(){ //Inicio de la aplicacion, comprueba lo introducido por el usuario.
    this.end=false;
    while(!end){
      String s = in.nextLine();
      Command command= null;
      command = CommandParser.parse(s);//Line
     
      if(command==null)
     {
    	  System.out.println("Error, comando nulo.");
    	  if(this.program.getNumberOfByteCode() != -1) System.out.println(this.program.toString());
     }
      else
      {
    	  System.out.println("Comienza la ejecucion de " + s.toUpperCase());  
    	  if(!command.execute(this)){
    		 System.out.println("Error: Ejecucion incorrecta del comando");
    	  }
    	 
      } 
    }   
   
    in.close();
  }
  
  /**
   * ExecuteCommanRun, ejecuta el run, en el tenemos que mostrar
   * el estado de la pila y de la memoria juntos con las instruccuines 
   * introducidas por el usuario(Programa almacenado)
   * 
   */
  public boolean executeCommandRun(){
	  CPU cpu = new CPU();
	  int i = 0;
	  boolean seguir = true;
	  while(i< program.getNumberOfByteCode() && !cpu.isHalted() && seguir){
		  ByteCode instr = this.program.getByteCode(i);
		  System.out.println("El estado de la maquina tras ejecutar el bytecode " + instr + " es : ");
		  if(!cpu.execute(instr)){
			  System.out.println(cpu.toString());
			  i++;
		  }
		  else seguir = false;
		  
		 
	  }
	  System.out.println("El programa almacenado:" + System.getProperty("line.separator") + program.toString());
	  return seguir;
	 

	}
  
  /***
   * El booleano showHelp te indice que realiza cada comando.
   * Introduciendo help por la consola te muestra aquellos comandos
   * de la maquina virtual, siempre devuelve true.
   * @return
   */
  public static boolean showHelp(){ //Ayuda de la aplicacion, informa de cada comando.
	  System.out.println("HELP: Muestra eesta ayuda");
      System.out.println("QUIT: Cierra la aplicacion");
      System.out.println("RUN: Ejecuta el programa");
      System.out.println("NEWINST BYTECODE: Introduce una nueva instruccion al programa");
      System.out.println("RESET: Vacia el programa actual");
      System.out.println("REPLACE N: Remplaza la instruccion N por la solicitada al usuario");
      return true;

  }
  
  /**
   * Comprueba si ha terminado la ejecucion
   * @return
   */
  public boolean endExecution(){ //comrpobar
	  return this.end=true;
	  }
  /**
   * Añade la instruccion al programa almacenado, 
   * @param bc
   * @return
   */
  public boolean addByteCodeInstruction(ByteCode bc){
	  System.out.println("Programa almacenado: ");
	  program.addBCInstruction(bc);
	  System.out.println(program.toString()) ;
	return end;
	}
  /**
   * Resetea el programa, libera la memoria y la pila
   * @return
   */
  public boolean resetProgram(){ //Comprobar
	  program.reset();
	return end;
	}
  /**
   * El usuario elige una instruccion n la reemplaza por otra que el elija.
   */
  
  public boolean replaceByteCode(int replace){
	  System.out.print("Nueva instruccion: ");
	  String s1 = in.nextLine();
	  ByteCode instr = null;
	  instr = ByteCodeParser.parse(s1); 
	  if (instr!=null && replace < program.getNumberOfByteCode()) {
		  program.replace(replace, instr);
		  return true;
	  }
	  else return false;
	}


}
  
