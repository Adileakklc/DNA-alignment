package alignment;

import java.util.Scanner;

/**
 * Bu program iki DNA dizisinin en uygun hizalanmas�n� hesaplar ve g�rsel olarak sunar.
 * Hizalama i�lemi s�ras�nda e�le�me ve uyumsuzluklara g�re puanlama yap�l�r.
 */
public class DNAAlignment {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("�lk DNA dizisini girin: ");
        String dna1 = scanner.nextLine();

        System.out.print("�kinci DNA dizisini girin: ");
        String dna2 = scanner.nextLine();

        Alignment result = align(dna1, dna2);

        System.out.println("En Uygun DNA Hizalamas�:");
        System.out.println(result);
        System.out.println("Hizalama Puan�: " + result.score());

        scanner.close();
    }

    /**
     * �ki DNA dizisi aras�ndaki en uygun hizalamay� rek�rsif olarak hesaplar ve d�nd�r�r.
     * Dizilerin ayn� uzunlukta olmas� gerekmez.
     */
    private static Alignment align(String dna1, String dna2) {
        if (dna1.isEmpty() && dna2.isEmpty()) {
            return new Alignment();
        } else if (dna1.isEmpty()) {
            Alignment result = align(dna1, dna2.substring(1));
            result.addMatch('-', dna2.charAt(0));
            return result;
        } else if (dna2.isEmpty()) {
            Alignment result = align(dna1.substring(1), dna2);
            result.addMatch(dna1.charAt(0), '-');
            return result;
        } else {
            Alignment first = align(dna1.substring(1), dna2);
            first.addMatch(dna1.charAt(0), '-');

            Alignment second = align(dna1, dna2.substring(1));
            second.addMatch('-', dna2.charAt(0));

            Alignment both = align(dna1.substring(1), dna2.substring(1));
            both.addMatch(dna1.charAt(0), dna2.charAt(0));

            return maxAlignment(first, second, both);
        }
    }

    private static Alignment maxAlignment(Alignment a, Alignment b, Alignment c) {
        if (a.score() >= b.score() && a.score() >= c.score()) {
            return a;
        } else if (b.score() >= a.score() && b.score() >= c.score()) {
            return b;
        } else {
            return c;
        }
    }

    /**
     * Yard�mc� s�n�f, iki DNA diziliminin hizalanmas�n� ve puanlamas�n� temsil eder.
     */
    private static class Alignment {
        private String dna1;
        private String dna2;

        /**
         * Karakter i�ermeyen yeni bir hizalama objesi olu�turur.
         */
        public Alignment() {
            this.dna1 = "";
            this.dna2 = "";
        }

        public void addMatch(char c1, char c2) {
            this.dna1 = c1 + this.dna1;
            this.dna2 = c2 + this.dna2;
        }

        public int score() {
            int score = 0;
            for (int i = 0; i < this.dna1.length(); i++) {
                if (this.dna1.charAt(i) == this.dna2.charAt(i)) {
                    score += 2;
                } else {
                    score -= 1;
                }
            }
            return score;
        }

        public String toString() {
            return this.dna1 + "\n" + this.dna2;
        }
    }
}
