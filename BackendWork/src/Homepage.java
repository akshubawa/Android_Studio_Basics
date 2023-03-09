import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Homepage extends JFrame {

    private JPanel contentPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Homepage frame = new Homepage();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Homepage() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        setTitle("Dashboard");

        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setLayout(null);
        setContentPane(contentPane);

        JLabel lblTitle = new JLabel("Dashboard");
        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblTitle.setBounds(150, 30, 150, 30);
        contentPane.add(lblTitle);

        JButton btnHome = new JButton("Home");
        btnHome.setBounds(50, 80, 100, 30);
        contentPane.add(btnHome);

        JButton btnSignUp = new JButton("Sign Up");
        btnSignUp.setBounds(200, 80, 100, 30);
        contentPane.add(btnSignUp);

        JButton btnLogin = new JButton("Login");
        btnLogin.setBounds(350, 80, 100, 30);
        contentPane.add(btnLogin);

        JButton btnTicketBooking = new JButton("Ticket Booking");
        btnTicketBooking.setBounds(50, 130, 100, 30);
        contentPane.add(btnTicketBooking);

        JButton btnMap = new JButton("Map");
        btnMap.setBounds(200, 130, 100, 30);
        contentPane.add(btnMap);

        JButton btnContactUs = new JButton("Contact Us");
        btnContactUs.setBounds(350, 130, 100, 30);
        contentPane.add(btnContactUs);
    }

}
