package controller;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;

public class EspeciesAnimalBean implements Serializable {
    
   private Map<String,Map<String,String>> data = new HashMap<String, Map<String,String>>();
   private String especie;
   private Map<String,String> especies;
   
    
   @PostConstruct
   public void init() {
   	especies  = new HashMap<String, String>();
   	especies.put("Cachorro", "Cachorro");
   	especies.put("Gato", "Gato");
  
   	
   }

   public Map<String, Map<String, String>> getData() {
       return data;
   }

   

   public Map<String, String> getEspecies() {
       return especies;
   }
}