package v1.hapra.rescalc15;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Spinner;
import android.widget.AdapterView;
import android.widget.TextView;

public class ResCalc15Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_res_calc15);

        final Spinner firstRing = (Spinner)findViewById(R.id.firstRing);
        final Spinner secondRing = (Spinner)findViewById(R.id.secondRing);
        final Spinner thirdRing = (Spinner)findViewById(R.id.thirdRing);
        final Spinner fourthRing = (Spinner)findViewById(R.id.fourthRing);
        final Spinner fifthRing = (Spinner)findViewById(R.id.fifthRing);
        final Spinner sixthRing = (Spinner)findViewById(R.id.sixthRing);

        final TextView widerstand = (TextView)findViewById(R.id.widerstand);
        final TextView toleranz = (TextView)findViewById(R.id.toleranz);
        final TextView temp = (TextView)findViewById(R.id.temp);

        AdapterView.OnItemSelectedListener listener = (new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {


                calculation state = new calculation(
                        firstRing.getSelectedItem().toString(),
                        secondRing.getSelectedItem().toString(),
                        thirdRing.getSelectedItem().toString(),
                        fourthRing.getSelectedItem().toString(),
                        fifthRing.getSelectedItem().toString(),
                        sixthRing.getSelectedItem().toString());

                widerstand.setText(state.getResistance());
                toleranz.setText(state.getTolerance());
                temp.setText(state.getTemperatureCoefficient());
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
                return;
            }
        });

        firstRing.setOnItemSelectedListener(listener);
        secondRing.setOnItemSelectedListener(listener);
        thirdRing.setOnItemSelectedListener(listener);
        fourthRing.setOnItemSelectedListener(listener);
        fifthRing.setOnItemSelectedListener(listener);
        sixthRing.setOnItemSelectedListener(listener);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_res_calc15, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
