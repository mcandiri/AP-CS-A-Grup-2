# AP CS-A Grup 2 — Ders Notları

Bu depoda derste işlediğimiz Java kodları ve not satırları bulunur.
Her ders, çalıştırılabilir tek bir `.java` dosyasıdır; anlatımlar kodun içinde
yorum satırı (`//`) olarak yer alır.

## Dersler

| Ders | Konu | Dosya |
|------|------|-------|
| 1 | Değişkenler ve veri tipleri (`int`, `double`, `boolean`, `String`), primitive tipler | [Lesson1.java](apcsa/src/Grup1/Lesson1.java) |
| 2 | Operatörler, işlem önceliği, `%` (mod), casting, round-off error, String karşılaştırma | [Lesson2.java](apcsa/src/Grup1/Lesson2.java) |
| 3 | Mantıksal operatörler (`&&`, `||`, `!`), short-circuit, De Morgan kuralı | [Lesson3.java](apcsa/src/Grup1/Lesson3.java) |

> Yeni dersler eklendikçe bu tablo güncellenecektir.

## Notları okumak

Hiçbir kurulum yapmadan yukarıdaki tablodaki dosya adlarına tıklayarak
kodu ve açıklamaları doğrudan tarayıcıdan okuyabilirsiniz.

## Kodu bilgisayarınıza indirmek

**Yol 1 — ZIP olarak (en kolay):**
Deponun ana sayfasındaki yeşil **Code** düğmesi → **Download ZIP**.

**Yol 2 — Git ile (güncellemeleri kolayca almak için):**

```bash
git clone https://github.com/mcandiri/AP-CS-A-Grup-2.git
```

Sonradan yeni dersleri çekmek için, klasörün içinde:

```bash
git pull
```

## Eclipse'te açmak

1. Eclipse'i açın.
2. **File → Import... → General → Existing Projects into Workspace** → **Next**
3. **Select root directory** → indirdiğiniz klasörün içindeki `apcsa` klasörünü seçin.
4. **Finish**

Dersler `src` klasörü altında paket olarak görünür. Bir dersi çalıştırmak için
dosyaya sağ tıklayın → **Run As → Java Application**.

## Ödev / soru

Ders dosyalarında zaman zaman şu şekilde görevler bırakılır:

```java
/// İki double değeri doğru bir şekilde kontrol eden kodu yazın!!!
```

Bunları kendi dosyanızda deneyin; derste birlikte çözeceğiz.
