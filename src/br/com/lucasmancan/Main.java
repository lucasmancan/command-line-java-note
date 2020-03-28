package br.com.lucasmancan;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {

    final static SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
    final static String DEFAULT_LOCATION = System.getenv("USERPROFILE") + "\\";
    final static String DEFAULT_NAME = "note_" + format.format(new Date());
    final static String DEFAULT_EXTENSION = "txt";
    final static Scanner scanner = new Scanner(System.in);


    public static String setDefault(String fileExtension, String defaultValue) {
        if (fileExtension.isEmpty())
            return defaultValue;

        return fileExtension;
    }

    public static void main(String[] args) {

        System.out.print("Digite o nome do arquivo (Padrão: " + DEFAULT_NAME + ") : ");

        final String fileName = setDefault(scanner.nextLine(), DEFAULT_NAME);

        System.out.print("Digite a extensão do arquivo (Padrão: " + DEFAULT_EXTENSION + ") : ");

        final String extension = setDefault(scanner.nextLine(), DEFAULT_EXTENSION);

        System.out.print("Digite o local de salvamento (Pasta raiz: " + DEFAULT_LOCATION + ") : ");

        final String completeFilePath = String.format("%s\\%s.%s", DEFAULT_LOCATION + scanner.nextLine(), fileName, extension);

        try {
            execute(completeFilePath);
        } catch (Exception e) {
            System.out.println("Erro ao criar nova nota, certifique-se de ter instalado o VisualStudio Code...");
        }

    }

    private static Process execute(String completeFilePath) throws IOException {
        return Runtime.getRuntime().exec(String.format(DEFAULT_LOCATION + "AppData\\Local\\Programs\\Microsoft VS Code\\bin\\code.cmd %s", completeFilePath));
    }
}
