package v2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class main {
    static final int RIGHE = 1;
    static final int COLONNE = 1;

    static final int LARGHEZZA = 20;
    static final int ALTEZZA = 7;
    public static void main(String args[]) {
        File page;
        FileWriter w;

        String header_text = "pesca di beneficenza";
        String footer_text = "campo san martino";
        String content = "textHeader";


        try {
            page = new File("prova2.txt");
            w = new FileWriter(page);
            Biglietto b = new Biglietto(header_text, footer_text, content);

            for (int r = 0; r < RIGHE; r++) {
                for (int rb = 0; rb < ALTEZZA; rb++) {
                    for (int c = 0; c < COLONNE; c++) {
                        w.write(b.get(rb) + '|');
                    }
                    w.write("\n");
                }
                for (int i = 0; i < (COLONNE * LARGHEZZA) + COLONNE; i++) w.write("-");
                w.write("\n");
            }



            w.close();
        } catch (IOException e) {

        }
    }
}
