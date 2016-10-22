package productosstream;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Yasmin
 */
public class TextoDelimitado {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        String [] cod = {"p1","p2","p3"};
        String [] desc = {"parafusos","cravos","tachas"};
        Double [] prezo = {3.00,4.00,5.00};
        
        PrintWriter write = new PrintWriter(new BufferedWriter(new FileWriter("productos.txt")));
        for (int i=0; i<prezo.length; i ++) {
            write.print(cod[i]);
            write.print('\t');
            write.print(desc[i]);
            write.print('\t');
            write.println(prezo[i]);
        }
        write.close();
        
       BufferedReader read = new BufferedReader(new FileReader("productos.txt"));
       
       String s;
       for(int z=0;z<3;z++){
           s = read.readLine();
           String [] p = s.split("\t");
           System.out.println(new Product(p[0],p[1],Double.parseDouble(p[2])));
       }
       read.close();
    }
    
}
