import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
//PESCA BENEFICENZA
//       32
//SAGRA SAN LORENZO
public class StampaBiglietti {
    public static void main(String[] args) {
        int n_ticket = 28;
        File page;
        FileWriter w;
        try {
            while (n_ticket > 0) {
                String title = "Biglietti" + n_ticket + "-" + (n_ticket - 27) + ".txt";
                page = new File("Quadrifoglio.txt");
                w = new FileWriter(page);


                int nc = 4;
                int nr = 7;
                //righe
                for (int i = 0; i < nr; i++) {
                    //colonne

                    //header
                    for (int c = 0; c < nc; c++) {
                        w.write("PESCA BENEFICENZA   ");
                    }
                    w.write("\n");
                    w.write("\n");
                    w.write("\n");
                    for (int c = 0; c < nc; c++) {
                        //w.write("  QUADRIFOGLIO      ");
                        writeNumber(w, n_ticket);
                        n_ticket--;
                    }
                    w.write("\n");
                    w.write("\n");
                    w.write("\n");
                    //footer
                    for (int c = 0; c < nc; c++) {
                        w.write("SAGRA SAN LORENZO   ");
                    }
                    w.write("\n");
                    w.write("\n");
                }
                w.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static void writeNumber(FileWriter w, int n) throws IOException {
        String end = "          ";
        String spaz = "";
        w.write("   N. " + n);

        if (n < 1000) spaz = " ";
        if (n < 100) spaz = "  ";
        if (n < 10) spaz = "   ";
        w.write(end + spaz);
    }
}
