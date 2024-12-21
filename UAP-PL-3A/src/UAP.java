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

        // Tabel Riwayat
        String[] columnNames = {"Angka", "Hasil"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        // Komponen dalam Frame
        frame.add(inputPanel, BorderLayout.NORTH); // Panel input di sebelah kiri
        frame.add(scrollPane, BorderLayout.CENTER); // Tabel di tengah

        // Fungsi Tombol Cek
        cekButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputText = inputField.getText();

                if (inputText.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Input tidak boleh kosong!", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    try {
                        double angka = Double.parseDouble(inputText);
                        String hasil;

                        // Bulatkan angka ke bilangan bulat terdekat
                        long angkaBulat = Math.round(angka);

                        // Tentukan genap atau ganjil berdasarkan pembulatan
                        hasil = (angkaBulat % 2 == 0) ? "Genap (Dibulatkan)" : "Ganjil (Dibulatkan)";

                        // Tambah ke Tabel
                        tableModel.addRow(new Object[]{angka, hasil});

                        // Kosongkan input
                        inputField.setText("");
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(frame, "Input harus berupa angka!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        // Fungsi Tombol Hapus
        hapusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    tableModel.removeRow(selectedRow);
                } else {
                    JOptionPane.showMessageDialog(frame, "Pilih data yang ingin dihapus!", "Peringatan", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        // Fungsi Tombol Edit
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    String angkaLama = tableModel.getValueAt(selectedRow, 0).toString();

                    // Dialog input untuk angka baru
                    String angkaBaru = JOptionPane.showInputDialog(frame, "Masukkan angka baru:", angkaLama);

                    if (angkaBaru != null && !angkaBaru.isEmpty()) {
                        try {
                            double angka = Double.parseDouble(angkaBaru);
                            String hasilBaru;

                            // Bulatkan angka ke bilangan bulat terdekat
                            long angkaBulat = Math.round(angka);

                            // Tentukan genap atau ganjil berdasarkan pembulatan
                            hasilBaru = (angkaBulat % 2 == 0) ? "Genap (Dibulatkan)" : "Ganjil (Dibulatkan)";

                            // Perbarui tabel
                            tableModel.setValueAt(angkaBaru, selectedRow, 0);
                            tableModel.setValueAt(hasilBaru, selectedRow, 1);

                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(frame, "Input harus berupa angka!", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "Pilih data yang ingin diedit!", "Peringatan", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        frame.setVisible(true);
    }
}
