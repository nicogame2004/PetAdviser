package com.example.petadviser;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Método que se ejecuta al hacer clic en el botón
    public void onClickFindPet(View view) {
        // Obtener referencia al Spinner y TextView
        Spinner category = (Spinner) findViewById(R.id.category);
        TextView breeds = (TextView) findViewById(R.id.breeds);

        // Obtener la categoría seleccionada
        String petCategory = String.valueOf(category.getSelectedItem());

        // Obtener las razas según la categoría
        String[] breedList = getBreeds(petCategory);

        // Mostrar las razas en el TextView
        StringBuilder breedsFormatted = new StringBuilder();
        for (String breed : breedList) {
            breedsFormatted.append(breed).append("\n");
        }
        breeds.setText(breedsFormatted.toString());
    }

    // Método para obtener las razas según la categoría
    private String[] getBreeds(String category) {
        if (category.equals("Pastores")) {
            return getResources().getStringArray(R.array.pastor_breeds);
        } else if (category.equals("Pinscher")) {
            return getResources().getStringArray(R.array.pinscher_breeds);
        } else if (category.equals("Terrier")) {
            return getResources().getStringArray(R.array.terrier_breeds);
        } else {
            return new String[]{"No breeds found"};
        }
    }
}