package Menu;
import Metodos.*;
import Radix.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import javax.swing.*;
import java.awt.*;

public class Graficas {
    public static void main(String[] args) {
        int[] arr = Arreglo.generarArreglo(200_000);
        //int[] arr = {12345678, 80764578, 18076577, 87657878, 78330487};
        int n = arr.length;

        // Crear un array para almacenar los tiempos de ejecución
        long[] tiempos = new long[9]; // 7 algoritmos de ordenamiento

        // Crear una instancia de TimSort
        TimSort timSort = new TimSort();
        long startTime1 = System.nanoTime();
        timSort.timSort(arr, n);
        long endTime1 = System.nanoTime();
        tiempos[0] = endTime1 - startTime1;

        // Crear una instancia de CombSort
        CombSort combSort = new CombSort();
        long startTime2 = System.nanoTime();
        combSort.sort(arr);
        long endTime2 = System.nanoTime();
        tiempos[1] = endTime2 - startTime2;

        // Crear una instancia de TreeSort
        TreeSort treeSort = new TreeSort();
        long startTime3 = System.nanoTime();
        for (int i = 0; i < n; i++) {
            treeSort.insert(arr[i]);
        }
        long endTime3 = System.nanoTime();
        tiempos[2] = endTime3 - startTime3;

        // Crear una instancia de PigeOnholeSort
        PigeOnholeSort pigeonholeSort = new PigeOnholeSort();
        long startTime4 = System.nanoTime();
        pigeonholeSort.pigeonhole_sort(arr, n);
        long endTime4 = System.nanoTime();
        tiempos[3] = endTime4 - startTime4;

        // Crear una instancia de HeapSort
        HeapSort heapSort = new HeapSort();
        long startTime5 = System.nanoTime();
        heapSort.sort(arr);
        long endTime5 = System.nanoTime();
        tiempos[4] = endTime5 - startTime5;

        // Crear una instancia de BitonicSort
        BitonicSort bitonicSort = new BitonicSort();
        long startTime6 = System.nanoTime();
        bitonicSort.sort(arr, arr.length, 1);
        long endTime6 = System.nanoTime();
        tiempos[5] = endTime6 - startTime6;

        // Crear una instancia de GnomeSort
        GnomeSort gnomeSort = new GnomeSort();
        long startTime7 = System.nanoTime();
        gnomeSort.gnomeSort(arr, n);
        long endTime7 = System.nanoTime();
        tiempos[6] = endTime7 - startTime7;

        // Crear una instancia de RadixSort
        RadixSort1 radixSort1 = new RadixSort1();
        long startTime8 = System.nanoTime();
        radixSort1.radixsort(arr, n);
        long endTime8 = System.nanoTime();
        tiempos[7] = endTime8 - startTime8;

        // Crear una instancia de RadixSort
        RadixSortClassroom.RadixSortClass radixSort = new RadixSortClassroom.RadixSortClass();
        long startTime9 = System.nanoTime();
        radixSort.sort(arr);
        long endTime9 = System.nanoTime();
        tiempos[8] = endTime9 - startTime9;


        // Crear el dataset para la gráfica
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(tiempos[0], "Tiempo (ns)", "TimSort");
        dataset.addValue(tiempos[1], "Tiempo (ns)", "CombSort");
        dataset.addValue(tiempos[2], "Tiempo (ns)", "TreeSort");
        dataset.addValue(tiempos[3], "Tiempo (ns)", "PigeonholeSort");
        dataset.addValue(tiempos[4], "Tiempo (ns)", "HeapSort");
        dataset.addValue(tiempos[5], "Tiempo (ns)", "BitonicSort");
        dataset.addValue(tiempos[6], "Tiempo (ns)", "GnomeSort");
        dataset.addValue(tiempos[7], "Tiempo (ns)", "RadixSort");
        dataset.addValue(tiempos[8], "Tiempo (ns)", "RadixSort-Classroom");

        // Crear la gráfica de barras
        JFreeChart chart = ChartFactory.createBarChart(
                "Tiempos de ejecución de algoritmos de ordenamiento",
                "Algoritmo", "Tiempo (ns)", dataset,
                PlotOrientation.VERTICAL, // Orientación vertical de la gráfica
                true, // Mostrar leyenda
                true, // Mostrar tooltips
                false // No usar URLs
        );

        // Mostrar la gráfica en una ventana
        JFrame frame = new JFrame("Gráfica de Barras");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(800, 600));
        frame.getContentPane().add(chartPanel);
        frame.pack();
        frame.setVisible(true);
    }
}

