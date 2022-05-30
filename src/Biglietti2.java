import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Biglietti2 {

    static final int COLONNE = 1;

    static final int LARGHEZZA = 20;
    static final int ALTEZZA = 7;
    public static void main(String[] args) {
        File page;
        FileWriter w;

        String header_text = "pesca di beneficenza campo san martino";


        try {
            page = new File("prova.txt");
            w = new FileWriter(page);

            // HEADER
            for (int i = 0; i < COLONNE; i++) {

                //singolo biglietto
                for (int c = 0; c < LARGHEZZA; c++) {
                    if (c == LARGHEZZA - 1) w.write(" ");
                    else w.write("-");
                }
            }
            w.write("\n");
            for (int i = 0; i < COLONNE; i++) {
                ArrayList<String> righe = new ArrayList<>();

                for (int r = 0; r < (header_text.length() / LARGHEZZA) + 1; r++) {
                    int inizio = r * LARGHEZZA;
                    int fine = (r + 1) * LARGHEZZA;
                    if (fine > header_text.length()) fine = header_text.length();
                        righe.add(header_text.substring(inizio, fine));
                }
                for (String riga : righe) {
                    printLine(w, riga);
                    w.write("\n");
                }
            }
            w.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static private void printLine(FileWriter w ,String text) throws IOException {
        String spaces = "";
        for (int s = 0; s < LARGHEZZA - text.length(); s++) spaces += " ";
        w.write(text + spaces);
    }
}
