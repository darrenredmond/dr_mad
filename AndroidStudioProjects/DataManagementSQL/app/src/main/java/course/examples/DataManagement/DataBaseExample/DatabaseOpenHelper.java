package course.examples.DataManagement.DataBaseExample;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseOpenHelper extends SQLiteOpenHelper {
	
	final static String TABLE_NAME = "authors";
	final static String AUTHOR_NAME = "name";
	final static String AUTHOR_DOB = "dob";
	final static String AUTHOR_COUNT = "count";
	final static String _ID = "_id";
	final static String[] columns = { _ID, AUTHOR_NAME, AUTHOR_DOB, AUTHOR_COUNT};

	final private static String CREATE_CMD = "CREATE TABLE " + TABLE_NAME + " (" + _ID
			+ " INTEGER PRIMARY KEY AUTOINCREMENT, "
			+ AUTHOR_NAME + " TEXT NOT NULL,"
			+ AUTHOR_DOB + " TEXT NOT NULL,"
			+ AUTHOR_COUNT + " TEXT NOT NULL)";

	final private static String INSERT_CMD = "insert into " + TABLE_NAME + " ("
			+ AUTHOR_NAME + ","
			+ AUTHOR_DOB + " ,"
			+ AUTHOR_COUNT + ") values ('Darren Redmond', '01/11/1974', '4')";

	final private static String NAME = "author_db";
	final private static Integer VERSION = 1;
	final private Context mContext;

	public DatabaseOpenHelper(Context context) {
		super(context, NAME, null, VERSION);
		this.mContext = context;
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(CREATE_CMD);
		db.execSQL(INSERT_CMD);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		/*if (oldVersion == 1 && newVersion == 2) {
			db.execSQL(ALTER_CMD);
		}*/
		// N/A
	}

	void deleteDatabase() {
		mContext.deleteDatabase(NAME);
	}
}
