/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package training;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Márk
 */
public class Person {
    
   private StringProperty firstName = new SimpleStringProperty(this, "firstName", "");
     
   //return the stringproperty object
   public StringProperty firstNameProperty(){
   return firstName;
   }
   
   //basic setter and getter
    public StringProperty getFirstName() {
        return firstName;
    }

    public void setFirstName(StringProperty firstName) {
        this.firstName = firstName;
    }

   

  
    
}
