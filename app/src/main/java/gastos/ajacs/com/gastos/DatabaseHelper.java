package gastos.ajacs.com.gastos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

/**
 * Created by adderly on 11/09/14.
 */
public class DatabaseHelper extends OrmLiteSqliteOpenHelper{

    private static final String DATABASE_NAME = "gastos.db";
    private static final int DATABASE_VERSION = 1;
    private Dao<Note,Integer> noteDao = null;
    private RuntimeExceptionDao<Note,Integer> noteRuntimeDao = null;

    public DatabaseHelper(Context context){

        super(context,DATABASE_NAME,null,DATABASE_VERSION, R.raw.ormlite_config);//R.raw.ormlite_config

    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource,Note.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            TableUtils.dropTable(connectionSource,Note.class,true);
            onCreate(database,connectionSource);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Dao<Note,Integer> getDao() throws SQLException {
        if(noteDao == null){
            noteDao = getDao(Note.class);
        }
        return noteDao;
    }

    public RuntimeExceptionDao<Note,Integer> getNoteRuntimeExceptionDao(){
        if(noteRuntimeDao == null){
            noteRuntimeDao = getRuntimeExceptionDao(Note.class);
        }
        return noteRuntimeDao;
    }



}
