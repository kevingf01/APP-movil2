package database;

//Bibliotecas de SQLite
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {

    // Constructor para acceder a la database
    public AdminSQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    // OnCreate para construir sentencias SQL
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE agendar(rut int primary key, nombre text, fecha text, hora text)");

    }

    //OnUpgrade para emplear cambios esquematicos
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
