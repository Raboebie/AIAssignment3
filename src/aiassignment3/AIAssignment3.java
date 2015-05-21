/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aiassignment3;

import java.util.Random;

/**
 *
 * @author dihan
 */
public class AIAssignment3 {

    /**
     * @param args the command line arguments
     */
 public static void main(String[] args) throws Exception {
     
  float[][] train = new float[][]{new float[]{0, 0}, new float[]{0, 1}, new float[]{1, 0}, new float[]{1, 1}};
  float[][] res = new float[][]{new float[]{0}, new float[]{1}, new float[]{1}, new float[]{0}};
  MLP mlp = new MLP(2, new int[]{2, 1});
  mlp.getLayer(1).setIsSigmoid(true);
  Random r = new Random();
  int en = 1000;
  
  
  for (int e = 0; e < en; e++) {

   for (int i = 0; i < res.length; i++) {
    int idx = r.nextInt(res.length);
    mlp.train(train[idx], res[idx], 0.3f, 0.6f);
   }

   if ((e + 1) % 100 == 0) {
    System.out.println();
    for (int i = 0; i < res.length; i++) {
     float[] t = train[i];
     System.out.printf("%d epoch\n", e + 1);
     System.out.printf("%.1f, %.1f --> %.3f\n", t[0], t[1], mlp.run(t)[0]);
    }
   }
  }
 }
    
}
