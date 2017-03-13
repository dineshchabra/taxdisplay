package com.example.dinesh.taxdisplay;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import static com.example.dinesh.taxdisplay.dataclass.TABLE_TAXDATA;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void disdata(){

        ListView listView = (ListView) findViewById(R.id.list1);
        ArrayList<taxclass> taxlist = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + TABLE_TAXDATA;
        SQLiteDatabase db = this.getReadbleDatabase();

        Cursor cursor = db.rawQuery(selectQuery,null);

        if (cursor.moveToFirst()) {
            do {
                 taxclass taxc = new taxclass();

                 taxc.setDesc(cursor.getString(0));
                 taxc.setAmt(Float.parseFloat(cursor.getString(1)));

                 taxlist.add(taxc);


            } while (cursor.moveToNext());

        }

        ArrayAdapter<taxclass> listAdapter = new ArrayAdapter<>(this,R.layout.simplerow,taxlist);
        listView.setAdapter(listAdapter);

    }

    public void updata(){

        /*dataclass db = new dataclass(this);
        db.addetail(new taxclass("Basic Salary",570311.00f));*/
        Toast.makeText(getApplicationContext(), "End Of Updation !!!",
                Toast.LENGTH_SHORT).show();
    }
}
