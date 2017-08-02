package learners.com.unitconverter;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by baldor on 27/7/17.
 */

public class DatabaseHandler extends SQLiteOpenHelper {

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "UnitConverter";

    // Formulas table name
    private static final String TABLE_FORMULAS = "Formulas";

    // Formulas Table Columns names
    private static final String KEY_TO = "to";
    private static final String KEY_FROM = "from";
    private static final String KEY_VALUE = "value";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_FORMULAS_TABLE = "CREATE TABLE " + TABLE_FORMULAS + "("
                + KEY_TO + " TEXT," + KEY_FROM + " TEXT,"
                + KEY_VALUE + " REAL" + ")";
        db.execSQL(CREATE_FORMULAS_TABLE);

        //INSERTING FORMULAS
        insertFormulas();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_FORMULAS);

        // Create tables again
        onCreate(db);
    }

    // Adding new formula
    void addFormula(Formula formula) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_FROM, formula.getFrom());
        values.put(KEY_TO, formula.getTo());
        values.put(KEY_VALUE, formula.getValue());

        // Inserting Row
        db.insert(TABLE_FORMULAS, null, values);
        db.close(); // Closing database connection
        Log.d("DBIN", formula.getFrom());
        Log.d("DBIN", formula.getTo());
        Log.d("DBIN", formula.getValue().toString());
    }

    // Getting single formula
    Formula getFormula(String from, String to) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_FORMULAS, new String[]{KEY_FROM,
                        KEY_TO, KEY_VALUE}, KEY_FROM + "=? AND " + KEY_TO + "=?",
                new String[]{from, to}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Formula formula = new Formula(cursor.getString(0),
                cursor.getString(1), Double.parseDouble(cursor.getString(2)));
        // return contact
        return formula;
    }

    private void insertFormulas() {
        //AREA
        squareKilometreFormulas();
        squareMetreFormulas();
        squareMileFormulas();
    }

    private void squareKilometreFormulas() {
        addFormula(new Formula(
                Resources.getSystem().getString(R.string.square_kilometre),
                Resources.getSystem().getString(R.string.square_metre),
                1000000.0));
        addFormula(new Formula(
                Resources.getSystem().getString(R.string.square_kilometre),
                Resources.getSystem().getString(R.string.square_mile),
                0.386102));
        addFormula(new Formula(
                Resources.getSystem().getString(R.string.square_kilometre),
                Resources.getSystem().getString(R.string.square_yard),
                1196000.0));
        addFormula(new Formula(
                Resources.getSystem().getString(R.string.square_kilometre),
                Resources.getSystem().getString(R.string.square_foot),
                10760000.0));
        addFormula(new Formula(
                Resources.getSystem().getString(R.string.square_kilometre),
                Resources.getSystem().getString(R.string.square_inch),
                1550000000.0));
        addFormula(new Formula(
                Resources.getSystem().getString(R.string.square_kilometre),
                Resources.getSystem().getString(R.string.hectare),
                100.0));
        addFormula(new Formula(
                Resources.getSystem().getString(R.string.square_kilometre),
                Resources.getSystem().getString(R.string.acre),
                247.105));
    }

    private void squareMetreFormulas() {
        addFormula(new Formula(
                Resources.getSystem().getString(R.string.square_metre),
                Resources.getSystem().getString(R.string.square_kilometre),
                0.000001));
        addFormula(new Formula(
                Resources.getSystem().getString(R.string.square_metre),
                Resources.getSystem().getString(R.string.square_mile),
                0.0000003861));
        addFormula(new Formula(
                Resources.getSystem().getString(R.string.square_metre),
                Resources.getSystem().getString(R.string.square_yard),
                1.19599));
        addFormula(new Formula(
                Resources.getSystem().getString(R.string.square_metre),
                Resources.getSystem().getString(R.string.square_foot),
                10.7639));
        addFormula(new Formula(
                Resources.getSystem().getString(R.string.square_metre),
                Resources.getSystem().getString(R.string.square_inch),
                1550.0));
        addFormula(new Formula(
                Resources.getSystem().getString(R.string.square_metre),
                Resources.getSystem().getString(R.string.hectare),
                0.0001));
        addFormula(new Formula(
                Resources.getSystem().getString(R.string.square_metre),
                Resources.getSystem().getString(R.string.acre),
                0.000247105));
    }

    private void squareMileFormulas() {
        addFormula(new Formula(
                Resources.getSystem().getString(R.string.square_mile),
                Resources.getSystem().getString(R.string.square_kilometre),
                2.58999));
        addFormula(new Formula(
                Resources.getSystem().getString(R.string.square_mile),
                Resources.getSystem().getString(R.string.square_metre),
                2590000.0));
        addFormula(new Formula(
                Resources.getSystem().getString(R.string.square_mile),
                Resources.getSystem().getString(R.string.square_yard),
                3098000.0));
        addFormula(new Formula(
                Resources.getSystem().getString(R.string.square_mile),
                Resources.getSystem().getString(R.string.square_foot),
                27880000.0));
        addFormula(new Formula(
                Resources.getSystem().getString(R.string.square_mile),
                Resources.getSystem().getString(R.string.square_inch),
                4014000000.0));
        addFormula(new Formula(
                Resources.getSystem().getString(R.string.square_mile),
                Resources.getSystem().getString(R.string.hectare),
                258.999));
        addFormula(new Formula(
                Resources.getSystem().getString(R.string.square_mile),
                Resources.getSystem().getString(R.string.acre),
                640.0));
    }

    private void squareYardFormulas() {
        addFormula(new Formula(
                Resources.getSystem().getString(R.string.square_yard),
                Resources.getSystem().getString(R.string.square_kilometre),
                0.00000083613));
        addFormula(new Formula(
                Resources.getSystem().getString(R.string.square_yard),
                Resources.getSystem().getString(R.string.square_metre),
                0.836127));
        addFormula(new Formula(
                Resources.getSystem().getString(R.string.square_yard),
                Resources.getSystem().getString(R.string.square_mile),
                0.00000032283));
        addFormula(new Formula(
                Resources.getSystem().getString(R.string.square_yard),
                Resources.getSystem().getString(R.string.square_foot),
                9.0));
        addFormula(new Formula(
                Resources.getSystem().getString(R.string.square_yard),
                Resources.getSystem().getString(R.string.square_inch),
                1296.0));
        addFormula(new Formula(
                Resources.getSystem().getString(R.string.square_yard),
                Resources.getSystem().getString(R.string.hectare),
                0.000083613));
        addFormula(new Formula(
                Resources.getSystem().getString(R.string.square_yard),
                Resources.getSystem().getString(R.string.acre),
                0.000206612));
    }
}
