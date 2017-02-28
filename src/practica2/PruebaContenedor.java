package practica2;

import java.util.ArrayList;

public class PruebaContenedor {
    
    public static void main(String[] args) {
        Time time = new Time();
        
        for (int i = 0; i < 10; i++) {
            time.startTime(i);
            System.out.println(i + " tiempo inicial : " + (double)time.getTime(i));
            for (int j = 0; j < 10000; j++) {
                
            }
            time.stopTime(i);
            System.out.println(i + " tiempo final : " + (double)time.getTime(i) + "\n");
        }
        System.out.println(time.meanTime());
    }
    
    
    private static class Time{
        private ArrayList<Long> time;

        private Time() {
            time = new ArrayList<>();
        }
        
        private long getTime(int i) {
            return time.get(i);
        }
        
        private void startTime(int i) {
            time.add(i, Long.valueOf(System.currentTimeMillis()));
        }
        
        private void stopTime(int i) {
            time.set(i, Long.sum(System.currentTimeMillis(), -time.get(i)));
        }
        
        private double meanTime() {
            double totalTime = .0;
            for (Long timeLapse : time) {
                totalTime += (double)timeLapse;
            }
            return totalTime/(double)(time.size()*1000);
        }
    }
}