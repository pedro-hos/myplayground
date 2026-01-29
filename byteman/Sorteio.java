///usr/bin/env jbang "$0" "$@" ; exit $?

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class Sorteio {

    public static void main(String... args) {
        sorteia();
    }

    public static void sorteia() {
        String sorteado = "";
        List<String> inscritos = leArquivo();
        int max = inscritos.size();
        int randomNumber = (int) (Math.random() * max) + 1;
        sorteado = inscritos.get(randomNumber);
        printInfo(sorteado, randomNumber);
    }

    public static List<String> leArquivo() {
        Path path = Paths.get("inscritos.txt");
        List<String> lines = Collections.emptyList();
        try {
            lines = Files.readAllLines(path, StandardCharsets.UTF_8);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lines;
    }

    public static void printInfo(String nome, int numero) {
        String banner = """
            +--------------------------------------------------+
            |                      JUG VALE                    |
            +--------------------------------------------------+
            |                                                  |
            |                    PARABÉNS                      |
            |                                                  |
            +--------------------------------------------------+

                    NOME: """ + nome + """

                    \tNÚMERO: """ + numero + """

            ----------------------------------------------------
            """;

            System.out.println(banner);
    }
}
