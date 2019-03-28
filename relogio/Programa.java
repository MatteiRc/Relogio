public class Programa{  
    public static void main(String[] args){
           try{  
               Horario inicio = new Horario(0, 0, 0);
               Horario fim = new Horario(2, 30, 40);
               if(!inicio.equals(fim))
                   System.out.println("Diferentes");
               else
                   System.out.println("Iguais");
               inicio.atrasar(1);
               System.out.println(inicio);    
           }catch(Exception erro){
               System.err.println(erro.getMessage());
           }            
       } 
}