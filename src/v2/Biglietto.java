package v2;

import static v2.main.ALTEZZA;
import static v2.main.LARGHEZZA;

public class Biglietto {
    private String[] righe;

    public Biglietto(String textHeader, String textFooter, String content) {
        righe = new String[ALTEZZA];
        headerRender(textHeader, (ALTEZZA / 2) - 1);
        righe[ALTEZZA / 2] = centerString(content);
        footerRender(textFooter,(ALTEZZA / 2) - 1);
    }

    /**
     * renderizza il testo dell'header sulle prime h righe
     * @param text testo da renderizzare
     * @param h numero di righe
     */
    private void headerRender(String text, int h) {
        if ((text.length() / LARGHEZZA) + 1 > h) throw new IllegalArgumentException("Header troppo lungo");
        String[] buf_header = textToRow(text);
        for (int i = 0; i < text.length() / LARGHEZZA + 1; i++) {
            righe[i] = centerString(buf_header[i]);
        }
    }

    /**
     * renderizza il testo del footer sulle ultime h righe
     * @param text testo da renderizzare
     * @param h numero di righe
     */
    private void footerRender(String text, int h) {
        int text_height = text.length() / LARGHEZZA;
        if (text.length() % LARGHEZZA != 0) text_height++;
        System.out.println(text_height % LARGHEZZA);
        if (text_height > h) throw new IllegalArgumentException("Footer troppo lungo");

        String[] buf_footer = textToRow(text);
        for (int i = 0; i < text_height; i++) {
            int gap = h - text_height;
            righe[righe.length - h + i + gap] = centerString(buf_footer[i]);
        }
    }

    /**
     * converte un testo in una serie di sottostringhe lunghe quanto la larghezza del biglietto
     * @param text
     * @return array di stringhe
     */
    private String[] textToRow(String text) {
        int n = (text.length() / LARGHEZZA) + 1;
        String[] out = new String[n];
        for (int r = 0; r < n; r++) {
            int inizio = r * LARGHEZZA;
            int fine = (r + 1) * LARGHEZZA;
            if (fine > text.length()) fine = text.length();
            out[r] = text.substring(inizio, fine);
        }
        return out;
    }

    /**
     * centra una stringa
     * @param text
     * @return
     */
    private String centerString(String text) {
        int spaces = (LARGHEZZA - text.length()) / 2;
        String out = "";
        for (int i = 0; i < spaces; i++) out += " ";
        out += text;
        for (int i = 0; i < spaces; i++) out += " ";
        return out;
    }


    /**
     * ritorna la riga
     * @param row
     * @return riga
     */
    public String get(int row) {
        String tmp = righe[row];
        if (tmp == null) tmp = "";
        String spaces = "";
        for (int s = 0; s < LARGHEZZA - tmp.length(); s++) spaces += " ";
        return tmp + spaces;
    }

    @Override
    public String toString() {
        String out = "";
        for (String riga : righe) {
            if (riga != null) out += riga + '\n';
        }
        return out;
    }
}
