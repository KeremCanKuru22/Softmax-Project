# Toplu Taşıma Güzergah Planlaması

Bu proje, Kırklareli ilindeki farklı mahalleler için toplu taşıma güzergahlarını değerlendiren bir Java programıdır. Program, üç mahalleyi belirleyerek her bir mahalle için çeşitli kriterlere göre bir değerlendirme yapar ve en uygun güzergahı seçmek için Softmax algoritmasını kullanır.

## Özellikler

- **Mahalle Değerlendirmesi:** 3 mahalle için 5 farklı kriter (nüfus yoğunluğu, ulaşım altyapısı, maliyet, çevresel etki ve sosyal fayda) ile değerlendirme yapılır.
- **Softmax Kullanımı:** Softmax algoritması, her mahalle için kriterlere dayalı puanlar hesaplar ve bu puanları normalize ederek yüzdelik skorlar oluşturur.
- **Sonuçlar:** Her mahalle için toplam fayda, maliyet ve yüzdelik skor hesaplanır. En uygun mahalle, yüzdelik skoru ile belirlenir.

## Kullanılan Teknolojiler

- **Java:** Program, Java dilinde yazılmıştır.
- **Matematiksel Hesaplamalar:** Softmax algoritması, her mahalle için kriterlerin ağırlıklı ortalamalarını hesaplamak için kullanılır.

## Program Akışı

1. **Mahalleler ve Kriterler:** Mahalleler ve her bir mahalle için kriterler tanımlanır.
2. **Softmax Hesaplaması:** Softmax fonksiyonu, her mahalle için puanları normalize eder.
3. **Yüzdelik Hesaplama:** Normalleştirilmiş puanlar üzerinden her mahalle için yüzdelik skor hesaplanır.
4. **Sonuçlar:** Mahallelerin kriterlerine göre toplam fayda ve maliyet hesaplanır, ardından en uygun mahalle belirlenir.

## Çalıştırma Talimatları

1. Java geliştirme ortamınızı kurun.
2. `Main.java` dosyasını indirin veya kopyalayın.
3. Terminal veya komut istemcisine aşağıdaki komutu yazın:
