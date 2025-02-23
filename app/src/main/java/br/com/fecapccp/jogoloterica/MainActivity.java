package br.com.fecapccp.jogoloterica;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public String Result;
    public TextView numeros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        numeros = findViewById(R.id.textNumeros);
        Result = getString(R.string.result, "00", "00", "00", "00", "00", "00");
        numeros.setText(Result);
    }

    public void sortearNumeros(View view){
        numeros = findViewById(R.id.textNumeros);

        int[] megaNum = new int[6];
        String[] resultado = new String[6];
        Random random = new Random();

        for(int i = 0; i < megaNum.length; i++){
            int holder = random.nextInt(60)+1;
            for(int j = 0; j < i; j++){
                if (holder == megaNum[j]) {
                    holder = random.nextInt(60)+1;
                }
            }
            megaNum[i] = holder;
        }

        //Arrays.sort(megaNum); //MANEIRA FÁCIL

        BubbleSort(megaNum);

        for(int i = 0; i < megaNum.length; i++){
            if(megaNum[i] > 0 && megaNum[i] < 10){
                resultado[i] = "0" + megaNum[i];
            } else {
                resultado[i] = Integer.toString(megaNum[i]);
            }
        }

        Result = getString(R.string.result, resultado[0], resultado[1], resultado[2], resultado[3], resultado[4], resultado[5]);
        numeros.setText(Result);
    }

    public static void BubbleSort(int[] arr){
        int n = arr.length;
        boolean troca;
        for(int i = 0; i < n-1; i++){
            troca = false;
            for(int j = 0; j < n-1-i; j++){
                if(arr[j] > arr[j+1]){
                    int holder = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = holder;
                    troca = true;
                }
            }
            if (!troca) break;
        }

    }

}

