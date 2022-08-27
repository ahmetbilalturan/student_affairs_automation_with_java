/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ogrenciisleriotomasyonu;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.awt.image.ImageObserver.HEIGHT;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import static ogrenciisleriotomasyonu.OgretimUyesi.i;
import static ogrenciisleriotomasyonu.OgretimUyesi.idler;

/**
 *
 * @author asus
 */
class SifreDegistirOgretim extends JFrame implements ActionListener{
    JLabel id = new JLabel("ID: ");
    JLabel idtxt = new JLabel((String) idler.get(i));
    JLabel sifre = new JLabel("Eski Şifre: ");
    JLabel sifre2 = new JLabel("Yeni Şifre: ");
    JButton değiştir = new JButton("Değiştir");
    JPasswordField sifre1pass = new JPasswordField();
    JPasswordField sifre2pass = new JPasswordField();
    JButton anamenü = new JButton("Ana Menüye Dön");
    String b,c;
    OgretimUyesi ogretim;
    
    SifreDegistirOgretim(){
        try {
            this.ogretim = new OgretimUyesi();
        } catch (IOException ex) {
            Logger.getLogger(SifreDegistirOgretim.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setVisible(true);
        this.setSize(700,725);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(null);
        this.add(id);
        this.add(sifre);
        this.add(sifre2);
        this.add(değiştir);
        this.add(sifre1pass);
        this.add(sifre2pass);
        this.add(idtxt);
        this.add(anamenü);
        
        id.setVisible(true);
        id.setBounds(210,170,100,25);
        
        anamenü.setVisible(true);
        anamenü.addActionListener(this);
        anamenü.setBounds(455,550,150,65);
        
        değiştir.setVisible(true);
        değiştir.setBounds(300,300,100,25);
        değiştir.addActionListener(this);
        
        sifre.setVisible(true);
        sifre.setBounds(210,210,100,25);
        
        sifre2.setVisible(true);
        sifre2.setBounds(210,250,100,25);
        
        sifre1pass.setBounds(270,210,165,25);
        sifre1pass.setVisible(true);
        
        sifre2pass.setVisible(true);
        sifre2pass.setBounds(270,250,165,25);
        
        idtxt.setVisible(true);
        idtxt.setBounds(270,170,165,25);
        idtxt.setFont(new Font("Selam", Font.ITALIC, 15));
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==değiştir){
            b=sifre1pass.getText();
            c=sifre2pass.getText();
            try {
                if(ogretim.şifreDeğiştir(b, c)==true){
                    JOptionPane.showMessageDialog(this, "Şifre Değiştirme Başarılı!");
                    this.dispose();
                    new LoginFrameOgretim();
                }
                else{
                    JOptionPane.showMessageDialog(this, "Şifre Değiştirme Başarısız!","ID veya şifre hatalı!",HEIGHT);
                    this.dispose();
                    new SifreDegistirOgretim();
                }
            } catch (IOException ex) {
                Logger.getLogger(SifreDegistirOgretim.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(e.getSource()==anamenü){
            this.dispose();
            new MainMenuOgretim();
        }
    }
}