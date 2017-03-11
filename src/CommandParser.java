
public class CommandParser {
	/*Parsea los comandos, en caso de error devolvemos null*/
	/**
	 * En esta clase parseamos los comandos, si da error devolvemos null.
	 * Para ello tenemos que comprobar las palabras, en caso de ser 0 devolvemos null
	 * en caso de ser uno, se comprobaran los comandos help, quit, reset y run.
	 *  En caso de ser dos solo seran newinst o replace.
	 * En el caso de ser 3 tambien sera solo newinst.
	 */
	
	public static Command parse(String line){
		line = line.trim();
	    String words[] = line.split(" +");
	    if (words.length == 0) return null; /*Comprobamos si la longitud de la palabra es 0*/
	    else{
	      words[0] = words[0].toLowerCase(); /*Convierte las  letras a mayuscula*/
	      if (words.length == 1){ //Comandos que solo neceistan una palabra
	    	  	if (words[0].equalsIgnoreCase("HELP")) return  new Command(ENUM_COMMAND.HELP);
	            else if (words[0].equalsIgnoreCase("QUIT")) return  new Command(ENUM_COMMAND.QUIT);
	            else if (words[0].equalsIgnoreCase("RESET")) return  new Command(ENUM_COMMAND.RESET);
	            else if (words[0].equalsIgnoreCase("RUN")) return  new Command(ENUM_COMMAND.RUN);
	            else return null;
	      }
	      else if(words.length == 2){ //Comandos que necesitan dos palabras
	    	  	if (words[0].equalsIgnoreCase("NEWINST")){		 
	    	  		String bytecode = words[1];
					ByteCode bc = ByteCodeParser.parse(bytecode);
					if (bc != null)	return new Command (ENUM_COMMAND.NEWINST, bc);
					else return null;
					
	    	  	}
	    	  	else if (words[0].equalsIgnoreCase("REPLACE")){
		    		  int n = Integer.parseInt(words[1]);
		    		  return new Command (ENUM_COMMAND.REPLACE, n);
	    	  	}
	      }
	      else if (words.length == 3){//2
	    	  if (words[0].equalsIgnoreCase("NEWINST")){
	    		  
	    		  ByteCode bc = ByteCodeParser.parse(new String(words[1] + " +" + words[2]));
	    		  if (bc != null)  return new Command (ENUM_COMMAND.NEWINST, bc);
	    		  else return null;
	    		  
	    	  }
	    	  
	    	  }
	    	  else return null;

	      }
		return null;
	}
}


