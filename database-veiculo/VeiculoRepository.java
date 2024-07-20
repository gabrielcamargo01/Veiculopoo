import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.dao.Dao;
import java.sql.SQLException;
import com.j256.ormlite.table.TableUtils;
import java.util.List;
import java.util.ArrayList;

public class VeiculoRepository
{
    private static Database database;
    private static Dao<Veiculo, Integer> dao;
    private List<Veiculo> loadedStudents;
    private Veiculo loadedStudent; 
    
    public VeiculoRepository(Database database) {
        VeiculoRepository.setDatabase(database);
        loadedStudents = new ArrayList<Veiculo>();
    }
    
    public static void setDatabase(Database database) {
        VeiculoRepository.database = database;
        try {
            dao = DaoManager.createDao(database.getConnection(), Veiculo.class);
            TableUtils.createTableIfNotExists(database.getConnection(), Veiculo.class);
        }
        catch(SQLException e) {
            System.out.println(e);
        }            
    }
    
    public Veiculo create(Veiculo veiculo) {
        int nrows = 0;
        try {
            nrows = dao.create(veiculo);
            if ( nrows == 0 )
                throw new SQLException("Error: object not saved");
            this.loadedStudent = veiculo;
            loadedStudents.add(veiculo);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return veiculo;
    }    

    public void update(Veiculo veiculo) {
      // TODO
    }

    public void delete(Veiculo veiculo) {
      // TODO
    }
    
    public Veiculo loadFromId(int id) {
        try {
            this.loadedStudent = dao.queryForId(id);
            if (this.loadedStudent != null)
                this.loadedStudents.add(this.loadedStudent);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return this.loadedStudent;
    }    
    
    public List<Veiculo> loadAll() {
        try {
            this.loadedStudents =  dao.queryForAll();
            if (this.loadedStudents.size() != 0)
                this.loadedStudent = this.loadedStudents.get(0);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return this.loadedStudents;
    }

    // getters and setters ommited...        
}