import java.awt.*;
import javax.swing.*;

// ===== Parent Class =====
class Disease {
    String name;
    String detail;

    public Disease(String name, String detail) {
        this.name = name;
        this.detail = detail;
    }

    public String getName() { return name; }
    public String getDetail() { return detail; }
}

// ===== Child Classes =====
class SindhiDisease extends Disease {
    public SindhiDisease(String name, String detail) { super(name, detail); }
}
class UrduDisease extends Disease {
    public UrduDisease(String name, String detail) { super(name, detail); }
}
class EnglishDisease extends Disease {
    public EnglishDisease(String name, String detail) { super(name, detail); }
}

// ===== Main GUI Class =====
public class HealthProject extends JFrame {
    private JComboBox<String> langBox;
    private JTextArea output;
    private JPanel buttonPanel;

    // --- Diseases in 3 languages ---
    private Disease[][] diseases = {
        {   // English
            new EnglishDisease("Fever", "Tablets: Paracetamol, Panadol\nSyrup: Calpol\nCare: Rest, drink water."),
            new EnglishDisease("Headache", "Tablets: Ibuprofen, Aspirin\nCare: Avoid noise, rest."),
            new EnglishDisease("Stomach Pain", "Tablets: Buscopan\nCare: Avoid spicy food."),
            new EnglishDisease("Cough & Cold", "Syrup: Benylin, Cofcol\nCare: Stay warm, avoid cold drinks."),
            new EnglishDisease("Diarrhea", "ORS: Electral\nTablets: Loperamide\nCare: Drink clean water."),
            new EnglishDisease("Toothache", "Tablet: Ibuprofen\nOil: Clove oil\nCare: Avoid sweet & cold food."),
            new EnglishDisease("Burn", "Wash with cool water\nCream: Silverex\nCare: Keep clean."),
            new EnglishDisease("Allergy", "Tablet: Cetirizine\nCream: Hydrocortisone\nCare: Avoid triggers."),
            new EnglishDisease("Malaria", "Tablet: Chloroquine (if available)\nCare: Sleep under mosquito net."),
            new EnglishDisease("High Blood Pressure", "Common Medicine: Amlodipine\nCare: Avoid salty food."),
            new EnglishDisease("Snake Bite", "Keep patient calm\nDo NOT cut or suck poison\nTake to hospital quickly."),
        },
        {   // Urdu
            new UrduDisease("بخار", "گوریاں: پیراسٹامول، پیناڈول\nسیرپ: کیلپول\nاحتیاط: آرام کریں، زیادہ پانی پئیں۔"),
            new UrduDisease("سر درد", "گوریاں: بروفین، ڈسپرین\nاحتیاط: شور سے بچیں، آرام کریں۔"),
            new UrduDisease("پیٹ کا درد", "گوریاں: بوسکوپان\nاحتیاط: مرچ سے پرہیز کریں۔"),
            new UrduDisease("زکام اور کھانسی", "سیرپ: بینلین، کفکول\nاحتیاط: خود کو گرم رکھیں۔"),
            new UrduDisease("دست", "او آر ایس: لیکٹرال\nگوریاں: لوپرامائیڈ\nاحتیاط: صاف پانی پئیں۔"),
            new UrduDisease("دانت کا درد", "گوریاں: آئبروفین\nتیل: لونگ کا تیل\nاحتیاط: ٹھنڈی اور میٹھی چیزیں نہ کھائیں۔"),
            new UrduDisease("جلنا", "ٹھنڈے پانی سے دھوئیں\nکریم: سلوریکس\nاحتیاط: زخم کو صاف رکھیں۔"),
            new UrduDisease("الرجی", "گوریاں: سیٹریزین\nکریم: ہائیڈروکارٹیسون\nاحتیاط: الرجی والی چیزوں سے بچیں۔"),
            new UrduDisease("ملیریا", "گوریاں: کلوروکوئین (اگر دستیاب ہو)\nاحتیاط: مچھر دانی استعمال کریں۔"),
            new UrduDisease("بلڈ پریشر", "دوائی: ایملاڈپین\nاحتیاط: نمک کم کھائیں۔"),
            new UrduDisease("سانپ کا کاٹنا", "مریض کو پرسکون رکھیں\nزہر نہ چوسیں\nفوراً اسپتال لے جائیں۔"),
        },
        {   // Sindhi
            new SindhiDisease("بخار", "💊 پيراسٽامول، ڪيلپول\n🧴 گهڻو پاڻي پيئو، آرام ڪريو۔ :"),
            new SindhiDisease("سردرد", "💊 بروفين، ڊسپرين\n🧴 شور کان بچو، آرام ڪريو۔"),
            new SindhiDisease("پيٽ جو سور", "💊 بيسڪاپان\n🧴 مرچ وارا کاڌا نه کائو۔"),
            new SindhiDisease("زڪام ۽ کنگهه", "💊 سيرپ: بينيلن، ڪفڪول\n🧴 پاڻ کي گرم رکو۔"),
            new SindhiDisease("ڏٺ ۽ موشن ", "💊 او آر ايس، لوپرامائيڊ\n🧴 صاف پاڻي پيئو۔"),
            new SindhiDisease("ڏندن جو سور", "💊 آئبروفين\n🧴 لونگ جو تيل لڳايو۔"),
            new SindhiDisease("ساڙ", "💧 ٿڌي پاڻي سان ڌوءُ\n🧴 سلورڪس ڪريم لڳايو۔"),
            new SindhiDisease("الرجي", "💊 سيٽريزين\n🧴 هائيڊروڪارٽيسون ڪريم لڳايو۔"),
            new SindhiDisease("مليريا", "💊 ڪلوروڪوئين (جيڪڏهن ملي)\n🧴 مڇرن کان بچاءُ ڪريو۔"),
            new SindhiDisease("بلڊ پريشر", "💊 ايملاڊپين\n🧴 لوڻ گهٽ استعمال ڪريو۔"),
            new SindhiDisease("ناگ جو ڏنگ", "😨 مريض کي پرسڪون رکو\n🚑 اسپتال جلدي وٺي وڃو۔"),
        }
    };

    public HealthProject() {
        setTitle("Emergency Health Assistance");
        setSize(650, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(240, 255, 250));

        // --- Top Panel ---
        JPanel top = new JPanel();
        top.setBackground(new Color(200, 245, 240));
        JLabel title = new JLabel("❤ Emergency Health Assistance ❤", SwingConstants.CENTER);
        title.setFont(new Font("Serif", Font.BOLD, 22)); // thoda bada
        top.add(title);

        langBox = new JComboBox<>(new String[]{"English", "اردو", "سنڌي"});
        langBox.setFont(new Font("Arial", Font.PLAIN, 16)); // dropdown ka font bara
        top.add(new JLabel("Select Language: "));
        top.add(langBox);
        add(top, BorderLayout.NORTH);

        // --- Button Panel ---
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(0, 3, 10, 10));
        add(new JScrollPane(buttonPanel), BorderLayout.CENTER);

        // --- Output Area ---
        output = new JTextArea(6, 30);
        output.setLineWrap(true);
        output.setWrapStyleWord(true);
        output.setEditable(false);
        output.setFont(new Font("SansSerif", Font.PLAIN, 16)); // yahan font size bara
        output.setForeground(new Color(0, 51, 102));
        output.setBackground(new Color(255, 245, 235));
        output.setBorder(BorderFactory.createTitledBorder("Details"));
        add(new JScrollPane(output), BorderLayout.SOUTH);

        // Events
        langBox.addActionListener(e -> loadDiseases());
        loadDiseases();
    }

    private void loadDiseases() {
        buttonPanel.removeAll();
        int langIndex = langBox.getSelectedIndex();
        for (Disease d : diseases[langIndex]) {
            JButton btn = new JButton(d.getName());
            btn.setPreferredSize(new Dimension(130, 45));
            btn.setBackground(new Color(0, 153, 153));
            btn.setForeground(Color.white);
            btn.setFont(new Font("Arial", Font.BOLD, 15)); // Button text bada
            btn.setFocusPainted(false);
            btn.addActionListener(e -> output.setText(d.getDetail()));
            buttonPanel.add(btn);
        }
        buttonPanel.revalidate();
        buttonPanel.repaint();
        output.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new HealthProject().setVisible(true));
    }
}
