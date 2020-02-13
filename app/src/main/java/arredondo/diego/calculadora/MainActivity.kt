package arredondo.diego.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var tot : Double = 0.0
    var operacion = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn0.setOnClickListener{if(operacion == -2) tvRes.setText("0") else tvRes.setText(tvRes.text.toString() + "0")}
        btn1.setOnClickListener{if(operacion == -2) tvRes.setText("1") else tvRes.setText(tvRes.text.toString() + "1")}
        btn2.setOnClickListener{if(operacion == -2) tvRes.setText("2") else tvRes.setText(tvRes.text.toString() + "2")}
        btn3.setOnClickListener{if(operacion == -2) tvRes.setText("3") else tvRes.setText(tvRes.text.toString() + "3")}
        btn4.setOnClickListener{if(operacion == -2) tvRes.setText("4") else tvRes.setText(tvRes.text.toString() + "4")}
        btn5.setOnClickListener{if(operacion == -2) tvRes.setText("5") else tvRes.setText(tvRes.text.toString() + "5")}
        btn6.setOnClickListener{if(operacion == -2) tvRes.setText("6") else tvRes.setText(tvRes.text.toString() + "6")}
        btn7.setOnClickListener{if(operacion == -2) tvRes.setText("7") else tvRes.setText(tvRes.text.toString() + "7")}
        btn8.setOnClickListener{if(operacion == -2) tvRes.setText("8") else tvRes.setText(tvRes.text.toString() + "8")}
        btn9.setOnClickListener{if(operacion == -2) tvRes.setText("9") else tvRes.setText(tvRes.text.toString() + "9")}

        btnres.setOnClickListener{
            var ns = tvRes.text.toString()
            if(ns.length>0) getRes(ns.toDouble(), true)
            else Toast.makeText(this,"ERROR: No hay numero para operar", Toast.LENGTH_LONG)
        }
        btnsuma.setOnClickListener{setOp(1)}
        btnresta.setOnClickListener{setOp(2)}
        btnmult.setOnClickListener{setOp(3)}
        btndiv.setOnClickListener{setOp(4)}
        btndel.setOnClickListener{
            if(operacion == -2 ) tvRes.setText("")
            var ns = tvRes.text.toString()
            if(ns.length>0)
                tvRes.setText(ns.substring(0,ns.length-1))
        }
    }

    fun getRes(n:Double, target:Boolean = false){

        when(operacion){
            1 ->{ //Suma
                tot+=n
            }
            2 ->{ //Resta
                tot-=n
            }
            3 ->{ //Multiplicación
                tot*=n
            }
            4->{ //División
                if(n == 0.0) Toast.makeText(this,"ERROR: División entre 0", Toast.LENGTH_LONG)
                else tot/=n
            }
        }
        tvRes.setText(tot.toString())
        if(target) {
            tvResAnterior.setText("")
            operacion = -2
        }

    }

    fun setOp(op:Int){
        var ns = tvRes.text.toString()
        if(ns.length>0){
            var n = ns.toDouble()
            if(operacion == -1) tot = n
            else if (operacion == -2) tvResAnterior.setText(n.toString())
            else {
                tvResAnterior.setText("")
                getRes(n)
            }
            operacion = op
            when(op){
                1-> tvOp.setText("+")
                2-> tvOp.setText("-")
                3-> tvOp.setText("*")
                4-> tvOp.setText("/")
            }
            tvRes.setText("")
        } else Toast.makeText(this,"ERROR: No hay numero para operar", Toast.LENGTH_LONG)

    }

}
