package gastos.ajacs.com.gastos;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.RuntimeExceptionDao;

import java.util.List;


public class StartActivity extends Activity {

    private DatabaseHelper helper;
    private Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        createUiElements();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.start, menu);
        createData();
        return true;
    }

    private void createUiElements(){
//        saveButton =  (Button)findViewById(R.id.saveBtn);
    }

    private void createData(){

        helper = OpenHelperManager.getHelper(this,DatabaseHelper.class);
        RuntimeExceptionDao<Note,Integer> noteDao = helper.getNoteRuntimeExceptionDao();
        noteDao.create(new Note("Comprar cosas de walmart 1","En esta nota hay texto de prueba de walmart 1"));
        noteDao.create(new Note("Comprar cosas de walmart 2","En esta nota hay texto de prueba de walmart 2"));
        noteDao.create(new Note("Comprar cosas de walmart 3","En esta nota hay texto de prueba de walmart 3"));

        List<Note> notes = noteDao.queryForAll();
        Log.d("notes", notes.toString());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
