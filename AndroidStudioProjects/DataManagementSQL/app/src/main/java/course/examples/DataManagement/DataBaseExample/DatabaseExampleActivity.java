package course.examples.DataManagement.DataBaseExample;

import android.app.ListActivity;
import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.SimpleCursorAdapter;

public class DatabaseExampleActivity extends ListActivity {

	private DatabaseOpenHelper mDbHelper;
	private SimpleCursorAdapter mAdapter;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.main);

		// Create a new DatabaseHelper
		mDbHelper = new DatabaseOpenHelper(this);
		mDbHelper.deleteDatabase();
		mDbHelper = new DatabaseOpenHelper(this);

		// start with an empty database
		//clearAll();

		// Insert records
		insertArtists();

		// Create a cursor
		Cursor c = readArtists();
		mAdapter = new SimpleCursorAdapter(this, R.layout.list_layout, c,
				DatabaseOpenHelper.columns, new int[] { R.id._id, R.id.name, R.id.dob, R.id.count },
				0);

		setListAdapter(mAdapter);

		Button fixButton = (Button) findViewById(R.id.fix_button);
		fixButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				// execute database operations
				fix();

				// Redisplay data
				mAdapter.getCursor().requery();
				mAdapter.notifyDataSetChanged();
			}
		});

	}

	// Insert several artist records
	private void insertArtists() {

		ContentValues values = new ContentValues();

		values.put(DatabaseOpenHelper.AUTHOR_NAME, "George RR Martin");
		values.put(DatabaseOpenHelper.AUTHOR_DOB, "01/01/1948");
		values.put(DatabaseOpenHelper.AUTHOR_COUNT, "5");
		mDbHelper.getWritableDatabase().insert(DatabaseOpenHelper.TABLE_NAME, null, values);

		values.clear();

		values.put(DatabaseOpenHelper.AUTHOR_NAME, "JK Rownling");
		values.put(DatabaseOpenHelper.AUTHOR_DOB, "01/01/1948");
		values.put(DatabaseOpenHelper.AUTHOR_COUNT, "5");
		mDbHelper.getWritableDatabase().insert(DatabaseOpenHelper.TABLE_NAME, null, values);

		values.clear();

		values.put(DatabaseOpenHelper.AUTHOR_NAME, "Terry Pratchett");
		values.put(DatabaseOpenHelper.AUTHOR_DOB, "01/01/1948");
		values.put(DatabaseOpenHelper.AUTHOR_COUNT, "5");
		mDbHelper.getWritableDatabase().insert(DatabaseOpenHelper.TABLE_NAME, null, values);

		values.clear();

		values.put(DatabaseOpenHelper.AUTHOR_NAME, "Douglas Adams");
		values.put(DatabaseOpenHelper.AUTHOR_DOB, "01/01/1948");
		values.put(DatabaseOpenHelper.AUTHOR_COUNT, "5");
		mDbHelper.getWritableDatabase().insert(DatabaseOpenHelper.TABLE_NAME, null, values);
	}

	// Returns all artist records in the database
	private Cursor readArtists() {
		return mDbHelper.getWritableDatabase().query(DatabaseOpenHelper.TABLE_NAME,
				DatabaseOpenHelper.columns, null, new String[] {}, null, null,
				null);
	}

	// Modify the contents of the database
	private void fix() {

		// fix the Man in Black
		ContentValues values = new ContentValues();
		values.put(DatabaseOpenHelper.AUTHOR_NAME, "JK Rowling");

		mDbHelper.getWritableDatabase().update(DatabaseOpenHelper.TABLE_NAME, values,
				DatabaseOpenHelper.AUTHOR_NAME + "=?",
				new String[] { "JK Rownling" });

	}

	// Delete all records
	private void clearAll() {

		mDbHelper.getWritableDatabase().delete(DatabaseOpenHelper.TABLE_NAME, null, null);

	}

	// Close database
	@Override
	protected void onDestroy() {

		mDbHelper.getWritableDatabase().close();
		mDbHelper.deleteDatabase();

		super.onDestroy();

	}
}