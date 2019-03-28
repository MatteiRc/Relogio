public class Horario{
       private int segundos, minutos, horas;       
       //Metodo Construtor
       public Horario(int horas, int minutos, int segundos)throws Exception{
            if(!Horario.valida(horas, minutos, segundos))
                throw new Exception("Horario invalido");           
            this.segundos = segundos;
            this.minutos = minutos;
            this.horas = horas;     
       }
       private static boolean valida(int horas, int minutos, int segundos){
            if((segundos<0 || segundos>=60) || 
               (minutos<0 || minutos>=60) || 
               (horas<0 || horas>=24))
                 return false; 
            return true;      
       }
       //Metodos getters e setters
       public int getSegundos(){
            return this.segundos;
       }         
       public int getMinutos(){
            return this.minutos;   
       }        
       public int getHoras(){
            return this.horas;     
       }    
       public void setSegundos(int segundos)throws Exception{
            if(!Horario.valida(this.horas, this.minutos, segundos))
                throw new Exception("Segundos invalido");  
            this.segundos = segundos;                     
       }        
       public void setMinutos(int minutos)throws Exception{
            if(!Horario.valida(this.horas, minutos, this.segundos))
                throw new Exception("Minutos invalidos");
            this.minutos = minutos;                     
       }        
       public void setHoras(int horas)throws Exception{
            if(!Horario.valida(horas, this.minutos, this.segundos))
                throw new Exception("Horas invalidas");
            this.horas = horas;                    
       }            
       public void adiantar(int qtdSegundos)throws Exception{
            if(qtdSegundos<0)
                throw new Exception("Segundos invalidos");
            Horario ret = null;
            for(int cont=0; cont<qtdSegundos; cont++){
               try{
                   ret = new Horario(this.horas, this.minutos, this.segundos+1);
                   this.segundos++;
               }catch(Exception a){
                   try{ 
                       ret = new Horario(this.horas, this.minutos+1, 0);
                       this.segundos=0;
                       this.minutos++;
                   }catch(Exception b){
                      try{
                        ret = new Horario(this.horas+1, 0, 0);
                        this.segundos=0;
                        this.minutos=0;
                        this.horas++;
                      }catch(Exception c){
                        this.segundos=0;
                        this.minutos=0;
                        this.horas=0;
                      }
                   }    
               }
            }
       }             
       public void atrasar(int qtdSegundos)throws Exception{
            if(qtdSegundos<0)
                throw new Exception("Segundos invalidos");
            Horario ret = null;
            for(int cont=0; cont<qtdSegundos; cont++){
                try{
                    ret = new Horario(this.horas, this.minutos, this.segundos-1);
                    this.segundos--;
                }catch(Exception a){
                    try{
                        ret = new Horario(this.horas, this.minutos-1, 59);
                        this.segundos=59;
                    }catch(Exception b){
                        try{
                            ret = new Horario(this.horas-1, 59, 59);
                            this.segundos=59;
                            this.minutos=59;
                            this.horas--;
                        }catch(Exception c){
                            this.segundos = 59;
                            this.minutos = 59;
                            this.horas = 23;
                        }
                    }
                }
                     
            }
       }     
       public String toString(){
            return (this.horas<10?"0":"")+this.horas+":"+
                   (this.minutos<10?"0":"")+this.minutos+":"+
                   (this.segundos<10?"0":"")+this.segundos; 
       }    
       public boolean equals(Object obj){
            if(this == obj)
               return true;
            if(obj == null)
               return false;
            Horario rel = (Horario) obj;
            if((this.segundos != rel.segundos)|| 
               (this.minutos != rel.minutos) || 
               (this.horas != rel.horas))
               return false;
            return true;           
       }    
       public int hashCode(){
            int ret = 1;
            ret = ret*2+ new Integer(this.segundos).hashCode();
            ret = ret*2+ new Integer(this.minutos).hashCode();
            ret = ret*2+ new Integer(this.horas).hashCode();
            return ret<0?-ret:ret; 
       } 
       public Horario(Horario modelo)throws Exception{
          if(modelo ==null)
              throw new Exception("Modelo ausente");
          this.segundos = modelo.segundos;
          this.minutos = modelo.minutos;
          this.horas = modelo.horas;
       }
       public Object clone(){
          Horario ret = null;
          try{
              ret = new Horario(this);
          }catch(Exception erro){}
          return ret;
       }
}