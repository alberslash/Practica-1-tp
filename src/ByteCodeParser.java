public class ByteCodeParser {
	/**
	 * 
	 * En esta clase parseamos el string para saber de que tipo de instruccion se trata,
	 * comprobamos la longitud de la palabra, siendo 0 devolvemos null,
	 * siendo 1 sera una operacion tipo add, divv...
	 * y siendo 2 es una operaccion de acceso a memoria load, store...
	 * 
	 * 
	 */

      public static ByteCode parse(String line){
        line = line.trim(); 
        String []words= line.split(" +");
        if (words.length == 0) return null; /*Comprobamos si la longitud de la palabra es 0*/
        else{
          words[0] = words[0].toLowerCase(); /*Convierte las  letras a mayuscula*/
          if (words.length == 1){ //Intrucciones  que solo necesitan una palabra
            if (words[0].equalsIgnoreCase("ADD")) return  new ByteCode(ENUM_BYTECODE.ADD);
            else if (words[0].equalsIgnoreCase("DIV")) return  new ByteCode(ENUM_BYTECODE.DIV);
            else if (words[0].equalsIgnoreCase("SUB")) return  new ByteCode(ENUM_BYTECODE.SUB);
            else if (words[0].equalsIgnoreCase("MUL")) return  new ByteCode(ENUM_BYTECODE.MUL);
            else if (words[0].equalsIgnoreCase("HALT")) return  new ByteCode(ENUM_BYTECODE.HALT);
            else if (words[0].equalsIgnoreCase("OUT")) return  new ByteCode(ENUM_BYTECODE.OUT);
            else return null;
          }
          else if (words.length == 2){ //Instrucciones que necesitan dos palabras
        	  if (words[0].equalsIgnoreCase("STORE")) return  new ByteCode(ENUM_BYTECODE.STORE, Integer.parseInt(words[1]));
              else if (words[0].equalsIgnoreCase("LOAD")) return  new ByteCode(ENUM_BYTECODE.LOAD, Integer.parseInt(words[1]));
              else if (words[0].equalsIgnoreCase("PUSH")) return  new ByteCode(ENUM_BYTECODE.PUSH, Integer.parseInt(words[1]));
              else return null;
          }
        }
      return null;
      }
     
    }
