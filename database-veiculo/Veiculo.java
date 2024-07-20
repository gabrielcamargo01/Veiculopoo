import java.util.Date;
import java.text.SimpleDateFormat;
import com.j256.ormlite.table.DatabaseTable;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.DataType;

@DatabaseTable(tableName = "veiculo")
public class Veiculo
{   
    @DatabaseField(generatedId = true)
    private int ano;
    
    @DatabaseField
    private String modelo;
    
    @DatabaseField
    public int registration;
    
    @DatabaseField(dataType=DataType.DATE)
   public Date birthday;    
    
    public String printBirthday() {
        SimpleDateFormat dateFor = new SimpleDateFormat("dd/MM/yyyy");
           return dateFor.format(birthday);
    }

//Start GetterSetterExtension Source Code

    /**GET Method Propertie id*/
    public int getAno(){
        return this.ano;
    }//end method getId

    /**SET Method Propertie id*/
    public void setAno(int ano){
        this.ano = ano;
    }//end method setId

    /**GET Method Propertie modelo*/
    public String getModelo(){
        return this.modelo;
    }//end method getFullName

    /**SET Method Propertie fullName*/
    public void setModelo(String modelo){
        this.modelo = modelo;
    }//end method setFullName

    /**GET Method Propertie registration*/
    public int getRegistration(){
        return this.registration;
    }//end method getRegistration

    /**SET Method Propertie registration*/
    public void setRegistration(int registration){
        this.registration = registration;
    }//end method setRegistration

    /**GET Method Propertie birthday*/
    //public Date getBirthday(){
        //return this.birthday;
    //}//end method getBirthday

    /**SET Method Propertie birthday*/
    //public void setBirthday(Date birthday){
        //this.birthday = birthday;
    //}//end method setBirthday

//End GetterSetterExtension Source Code


}//End class