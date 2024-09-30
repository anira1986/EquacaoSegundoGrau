/**
 *@author:<ANA PAULA DE OLIVEIRA SILVA>
 *RA1110482123028
 *ANA PAULA DE OLIVEIRA SILVA
 */

package br.edu.fateczl.equacaosegundograu;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etValorA;
    private EditText etValorB;
    private EditText etValorC;
    private TextView tvDelta;
    private TextView tvRes1;
    private TextView tvRes2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etValorA = findViewById(R.id.etValorA);
        etValorB = findViewById(R.id.etValorB);
        etValorC = findViewById(R.id.etValorC);
        tvDelta = findViewById(R.id.tvDelta);
        tvRes1 = findViewById(R.id.tvRes1);
        tvRes2 = findViewById(R.id.tvRes2);
        Button btnCalc = findViewById(R.id.btnCalc);

        btnCalc.setOnClickListener(op -> calc());
    }

    private void calc() {
        float a = Float.parseFloat(etValorA.getText().toString());
        float b = Float.parseFloat(etValorB.getText().toString());
        float c = Float.parseFloat(etValorC.getText().toString());

        if (a == 0) {
            tvDelta.setText(getString(R.string.nao_e_segundo_grau));
            tvRes1.setText("");
            tvRes2.setText("");
            return;
        }

        float delta = (b * b) - (4 * a * c);

        if (delta < 0) {
            tvDelta.setText(getString(R.string.sem_raizes_reais));
            tvRes1.setText("");
            tvRes2.setText("");
        } else {
            double x1 = (-b + Math.sqrt(delta)) / (2 * a);
            double x2 = (-b - Math.sqrt(delta)) / (2 * a);

            tvDelta.setText(getString(R.string.delta) + delta);
            tvRes1.setText(getString(R.string.resultado_x1) + x1);
            tvRes2.setText(getString(R.string.resultado_x2) + x2);
        }
    }
}
