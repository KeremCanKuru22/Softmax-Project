public class Main {
    public static void main(String[] args) {
        // Mahalleleri içeren bir dizi oluşturduk.
        String[] mahalleler = {"İstasyon Mahallesi", "Karakaş Mahallesi", "Pınar Mahallesi"};

        // Her mahalle için 5 kriterden oluşan bir dizi oluşturduk. 3 mahalle ve 5 kriter olduğu için 3x5'lik bir 2D dizi tanımlıyoruz.
        double[][] kriterler = new double[3][5]; // 3 mahalle, 5 kriter

        // Mahalle kriterleri için 100 üzerinden sentetik verileri tanımladık.
        kriterler[0] = new double[]{80, 75, 60, 70, 85}; // İstasyon Mahallesi
        kriterler[1] = new double[]{70, 65, 55, 80, 75}; // Karakaş Mahallesi
        kriterler[2] = new double[]{85, 80, 50, 75, 70}; // Pınar Mahallesi

        // Softmax hesaplaması için bir dizi tanımlıyoruz.
        double[] puanlar = new double[3]; // 3 mahalle için puanlar
        double toplamExp = 0; // Üssel değerlerin toplamını tutan değişken

        // Her mahalle için Softmax puanı hesaplıyoruz.
        for (int i = 0; i < 3; i++) {
            puanlar[i] = softmaxPuan(kriterler[i]); // Softmax puanı hesaplanıyor
            toplamExp += Math.exp(puanlar[i]); // Üssel değerler toplama ekleniyor
        }

        // Normalizasyon ve yüzdelik hesaplama
        double[] yuzdeler = new double[3]; // Yüzdelik değerleri tutan dizi
        double enYuksekPuan = Double.MIN_VALUE; // En yüksek puanı tutmak için değişken
        int enUygunMahalleIndeksi = -1; // En uygun mahalleyi belirlemek için değişken

        // Her mahalle için yüzdelik skor hesaplıyoruz.
        for (int i = 0; i < 3; i++) {
            yuzdeler[i] = (Math.exp(puanlar[i]) / toplamExp) * 100; // Yüzdelik hesaplanıyor
            if (yuzdeler[i] > enYuksekPuan) {
                enYuksekPuan = yuzdeler[i]; // En yüksek yüzdelik puan belirleniyor
                enUygunMahalleIndeksi = i; // En uygun mahalle indeksi belirleniyor
            }
        }

        // Sonuçları yazdırıyoruz.
        System.out.println("Kırklareli Toplu Taşıma Güzergah Planlaması Sonuçları:");
        for (int i = 0; i < 3; i++) {
            double toplamFayda = kriterler[i][0] + kriterler[i][1] + kriterler[i][3] + kriterler[i][4];
            double maliyet = kriterler[i][2];
            System.out.println("----------------------------------------------------");
            System.out.println("Mahalle: " + mahalleler[i]);
            System.out.println("  Nüfus Yoğunluğu: " + kriterler[i][0]);
            System.out.println("  Ulaşım Altyapısı: " + kriterler[i][1]);
            System.out.println("  Maliyet: " + kriterler[i][2]);
            System.out.println("  Çevresel Etki: " + kriterler[i][3]);
            System.out.println("  Sosyal Fayda: " + kriterler[i][4]);
            System.out.printf("  Toplam Fayda: %.1f, Maliyet: %.1f%n", toplamFayda, maliyet);
            System.out.printf("  Yüzdelik Skor: %.2f%%%n", yuzdeler[i]);
        }

        System.out.println("----------------------------------------------------");
        System.out.println("En uygun güzergah: " + mahalleler[enUygunMahalleIndeksi] + " (Yüzdelik Skor: " + String.format("%.2f", enYuksekPuan) + "%)");
    }

    // Softmax puanını hesaplayan metot
    public static double softmaxPuan(double[] kriterler) {
        // Her kriter için ağırlıkları tanımlıyoruz
        double agirlikNufus = 0.3;
        double agirlikUlasim = 0.2;
        double agirlikMaliyet = -0.1; // Maliyet negatif etki yaratır
        double agirlikCevre = 0.2;
        double agirlikSosyal = 0.2;

        // Kriterler ile ağırlıkları çarpıp topluyoruz.
        return (kriterler[0] * agirlikNufus + kriterler[1] * agirlikUlasim + kriterler[2] * agirlikMaliyet +
                kriterler[3] * agirlikCevre + kriterler[4] * agirlikSosyal);
    }
}
