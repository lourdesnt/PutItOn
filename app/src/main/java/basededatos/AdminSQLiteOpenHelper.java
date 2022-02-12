package basededatos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {

    public static AdminSQLiteOpenHelper instance;

    public AdminSQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public static AdminSQLiteOpenHelper getInstance(Context context){
        if(instance == null){
            instance = new AdminSQLiteOpenHelper(context, "administracion", null, 3);
        }
        return instance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table if not exists productos (referencia int primary key, nombre text, name text, precio real, talla text, cantidad int);");
        db.execSQL("create table if not exists usuarios (nombre text primary key, contrasena text);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
