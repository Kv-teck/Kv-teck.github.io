package exercise.Buoi4;

import java.util.HashMap;
import java.util.Map;

public class Bai1 {
    /*
    Cho chuỗi:
        Ngôn ngữ lập trình Java ban đầu được phát triển bởi Sun Microsystems do James Gosling khởi xướng và phát hành vào năm 1995.
        Phiên bản mới nhất của Java Standard Edition là Java SE 8. Với sự tiến bộ của Java và sự phổ biến rộng rãi của nó,
        nhiều cấu hình đã được xây dựng để phù hợp với nhiều loại nền tảng khác nhau.
         Ví dụ: J2EE cho các ứng dụng doanh nghiệp, J2ME cho các ứng dụng di động.
        a)	Đếm số lượng từng từ trong đoạn trên (không phân biệt hoa thường):
        Ví dụ ta có chuỗi “Tôi học lập trình, học lập trình rất hay”
        Kết quả từ
        Tôi : 1 từ
        Học : 2 từ
        Lập: 2 từ
        Trình: 2 từ
        Rất: 1 từ
        Hay: 1 từ
        b.	Viết hoa chữ đầu trong mỗi từ
        c.	Xóa các nguyên âm trong câu
        */
    public static void main(String[] args) {
        String text = "Ngôn ngữ lập trình Java ban đầu được phát triển bởi Sun Microsystems do James Gosling khởi xướng và phát hành vào năm 1995." +
                " Phiên bản mới nhất của Java Standard Edition là Java SE 8. Với sự tiến bộ của Java và sự phổ biến rộng rãi của nó," +
                " nhiều cấu hình đã được xây dựng để phù hợp với nhiều loại nền tảng khác nhau." +
                " Ví dụ: J2EE cho các ứng dụng doanh nghiệp, J2ME cho các ứng dụng di động.";

        // a) Đếm số lượng từng từ
        countWords(text);

        // b) Viết hoa chữ đầu trong mỗi từ
        capitalizeWords(text);

        // c) Xóa các nguyên âm trong câu
        removeVowels(text);
    }
    // a) Đếm số lượng từng từ
    public static void countWords(String text) {
        text = text.toLowerCase();
        String[] words = text.split("[\\W_]+");
        Map<String, Integer> wordCount = new HashMap<>();

        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        System.out.println("a) Đếm số lượng từng từ:");
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            System.out.println(entry.getKey().substring(0, 1).toUpperCase() + entry.getKey().substring(1) + " : " + entry.getValue() + " từ");
        }
    }

    // b) Viết hoa chữ đầu trong mỗi từ
    public static void capitalizeWords(String text) {
        String[] words = text.split(" ");
        StringBuilder capitalizedText = new StringBuilder();

        for (String word : words) {
            capitalizedText.append(word.substring(0, 1).toUpperCase())
                    .append(word.substring(1)).append(" ");
        }

        System.out.println("\nb) Viết hoa chữ đầu trong mỗi từ:");
        System.out.println(capitalizedText.toString().trim());
    }

    // c) Xóa các nguyên âm trong câu
    public static void removeVowels(String text) {
        String vowels = "aeiouAEIOU";
        StringBuilder result = new StringBuilder();

        for (char c : text.toCharArray()) {
            if (vowels.indexOf(c) == -1) { // Nếu không phải nguyên âm
                result.append(c);
            }
        }

        System.out.println("\nc) Xóa các nguyên âm trong câu:");
        System.out.println(result.toString());
    }
}
