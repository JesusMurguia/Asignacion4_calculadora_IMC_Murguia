package mx.edu.itson.asignacion4_calculadora_imc_Murguia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val weight: EditText=findViewById(R.id.etWeight)
        val height: EditText=findViewById(R.id.etHeight)
        val calcular:Button=findViewById(R.id.btnCalcular)
        val imc: TextView=findViewById(R.id.imc)
        val range: TextView=findViewById(R.id.range)

        calcular.setOnClickListener {
            imc.setText(calcularIMC(weight.text.toString().toFloat(),height.text.toString().toFloat()).toString())
            range.setText(calcularCategoria(imc.text.toString().toFloat()))
        }
    }

    fun calcularIMC(weight:Float,height:Float):Float{
        return weight/((height/100)*(height/100))
    }

    fun calcularCategoria(imc:Float): String =
        when{
            imc < 18.5 ->  "Low weight"
            imc in 18.5..24.99 ->  "Normal"
            imc in 25.0..29.99 ->  "Overweight"
            imc in 30.0..34.99 ->  "Obesity grade 1"
            imc in 35.0..39.99 ->  "Obesity grade 2"
            imc >40 ->  "Obesity grade 3"
            else -> imc.toString()
        }


}