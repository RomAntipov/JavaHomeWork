package com.pb.antipov.hw9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileNumbers {
    public static final Logger logger = Logger.getLogger(FileNumbers.class.getName());

    public static void main(String[] args) {

        String fileName = "numbers.txt";

        createNumbersFile(fileName);
        readNumbersFile(fileName);
        createOddNumbersFile(fileName);
        readNumbersFile("odd-"+fileName);



  }

    public static void createNumbersFile(String fileName) {
        logger.entering(FileNumbers.class.getName(), "createNumbersFile");
        Random random = new Random();
        StringBuilder numStr = new StringBuilder();

        for (int i=0; i<10;i++){
            for (int j = 0; j < 10; j++){
                numStr.append(random.nextInt(99)+1+" ");
            }
            numStr.append("\n");
        }

        Path path = Paths.get("src\\com\\pb\\antipov\\hw9\\"+fileName);

        // write to file
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            writer.write(numStr.toString());
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Ошибка записи в файл: " + ex);

            System.out.println();
        }
        logger.log(Level.INFO, "Запись случайных чисел в файл \"" + path.toAbsolutePath() + "\" завершена!");

    }
    public static void createOddNumbersFile(String fileName) {
        logger.entering(FileNumbers.class.getName(), "createOddNumbersFile");
        // read from file
        Path path = Paths.get("src\\com\\pb\\antipov\\hw9\\"+fileName);
        StringBuilder sb = new StringBuilder();

        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while((line = reader.readLine()) != null) {
                for (String s : line.split("\\D")) {
                    if (Integer.parseInt(s)%2 == 0) {
                        sb.append(0 + " ");
                    } else {
                        sb.append(s + " ");
                    }
                }
                sb.append("\n");

            }

        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Ошибка чтения файла: " + ex);
        }

        // write to file odd numbers
        path = Paths.get("src\\com\\pb\\antipov\\hw9\\odd-"+fileName);
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            writer.write(sb.toString());
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Ошибка записи файла: " + ex);
        }
        logger.log(Level.INFO, "Запись нечетных чисел в файл \"" + path.toAbsolutePath() + "\" завершена!");


    }

    public static void readNumbersFile(String fileName) {
        logger.entering(FileNumbers.class.getName(), "readNumbersFile");
        // read from file
        Path path = Paths.get("src\\com\\pb\\antipov\\hw9\\"+fileName);
        logger.log(Level.INFO, "Чтение из файла \"" + path.toAbsolutePath() + "\"");
        try (BufferedReader reader = Files.newBufferedReader(path)) {

            System.out.println("----------------------------------");
            String line;
            while((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            System.out.println("----------------------------------");

        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Ошибка чтения файла: " + ex);
        }

        logger.log(Level.INFO, "Чтение файла успешно завершено!");

    }
}
