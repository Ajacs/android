package gastos.ajacs.com.gastos;

import com.j256.ormlite.field.DatabaseField;

import java.util.Date;

/**
 * Created by adderly on 11/09/14.
 */
public class Note {
    @DatabaseField(generatedId = true)
    int id;
    @DatabaseField
    String subject;
    @DatabaseField
    String text;
    @DatabaseField
    Date date;


    public Note(){

    }

    public Note(String subject, String text) {
        this.subject = subject;
        this.text = text;
        this.date = new Date(System.currentTimeMillis());
    }


    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", subject='" + subject + '\'' +
                ", text='" + text + '\'' +
                ", date=" + date +
                '}';
    }
}
