/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author HP
 */
import controller.Manager;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {

    public static void main(String[] args) {
        BufferedReader br = null;
        try {
            Manager manager = new Manager(); 

            int countLine = manager.countLine(); 

            int count = 1;
            br = new BufferedReader(new FileReader(new File("D:\\\\FPTU Documents\\\\PRO\\\\Code\\\\NetBeansProjects\\\\NormolizeText\\\\src\\\\main\\\\java\\\\input.txt")));
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("D:\\\\FPTU Documents\\\\PRO\\\\Code\\\\NetBeansProjects\\\\NormolizeText\\\\src\\\\main\\\\java\\\\output.txt", true)));
            String line;

            while ((line = br.readLine()) != null) {
                if (manager.isLineEmpty(line)) {
                    continue;
                }
      
                line = manager.formatOneSpace(line);
                line = manager.formatSpecialCharacters(line);
                line = manager.afterDotUpperCase(line);
                line = manager.noSpaceQuotes(line);
                line = manager.firstUppercase(line);
                line = manager.lastAddDot(line);

                pw.print(line);
                if (count < countLine) {
                    pw.print(System.getProperty("line.separator"));
                }
                count++;
            }
            br.close();
            pw.close();
            System.out.println("Normalize successful.");
        } catch (FileNotFoundException ex) {
            System.err.println("Can't not found");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

