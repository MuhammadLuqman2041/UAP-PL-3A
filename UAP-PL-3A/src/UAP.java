import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class UAP extends JFrame {
    public static void main(String[] args) {
        // Window Utama
        JFrame frame = new JFrame("Pengecekan Bilangan Genap/Ganjil");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLayout(new BorderLayout());

        // Panel Utama dengan GridBagLayout
        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Margin antar komponen

        // Komponen Input
        JLabel labelInput = new JLabel("Masukkan Angka:");
        JTextField inputField = new JTextField(15);

        // Tombol
        JButton cekButton = new JButton("Cek");
        JButton hapusButton = new JButton("Hapus Data");
        JButton editButton = new JButton("Edit Data");

        // Tambahkan ikon ke tombol
        try {
            URL urlHapus = new URL("https://cdn-icons-png.flaticon.com/512/9790/9790368.png");
            ImageIcon iconHapus = new ImageIcon(urlHapus);
            hapusButton.setIcon(new ImageIcon(iconHapus.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));

            URL urlCek = new URL("https://cdn-icons-png.flaticon.com/512/5610/5610944.png");
            ImageIcon iconCek = new ImageIcon(urlCek);
            cekButton.setIcon(new ImageIcon(iconCek.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));

            URL urlEdit = new URL("https://cdn-icons-png.flaticon.com/512/10336/10336582.png");
            ImageIcon iconEdit = new ImageIcon(urlEdit);
            editButton.setIcon(new ImageIcon(iconEdit.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        // Tambahkan Komponen ke Panel Input
        gbc.gridx = 0; gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        inputPanel.add(labelInput, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        inputPanel.add(inputField, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        inputPanel.add(cekButton, gbc);

        gbc.gridx = 0; gbc.gridy = 3;
        inputPanel.add(hapusButton, gbc);

        gbc.gridx = 0; gbc.gridy = 4;
        inputPanel.add(editButton, gbc);
