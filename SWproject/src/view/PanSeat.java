package view;
 
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
 
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
 
public class PanSeat extends JPanel {
    private BufferedImage img = null;
    JLabel[] label = new JLabel[4];
    private int numSeat;
     
     
    public PanSeat(int numSeat) {
        this.numSeat = numSeat;
        img("gameOff");
        setLayout(null);
 
        JPanel panImg = new InnerPanel();
        panImg.setBounds(0, 0, 99, 99);
        panImg.setOpaque(false);
                 
        //�������� �г�
        JPanel panContent = new JPanel();
        panContent.setLayout(null);
        panContent.setBounds(0, 0, 99, 99);
        int posLabel = 15;
        for (int i = 0; i < 4; i++) {
            if (i == 0)
                label[i] = new JLabel((numSeat + 1) + "자리");
            else
                label[i] = new JLabel("");
 
            label[i].setBounds(20, posLabel, 80, 15);
            posLabel += 16;
            label[i].setForeground(new Color(36, 205, 198));
           
            panContent.add(label[i]);
        }
        panContent.setOpaque(false);
         
         
        //���̷��̾��г�
        JLayeredPane panLayered = new JLayeredPane();
        panLayered.setBounds(0, 0, 1600, 900);
        panLayered.setLayout(null);
        panLayered.setOpaque(false);
        panLayered.add(panImg, new Integer(0), 0);
        panLayered.add(panContent, new Integer(1), 0);
        add(panLayered);
         
        setVisible(true);
        setOpaque(false);
        setFocusable(true);
    }
 
    public static void main(String[] args) {
        JFrame frameTest = new JFrame();
        frameTest.setTitle("자리");
        frameTest.add(new PanSeat(1));
        frameTest.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameTest.setSize(99, 144);
        frameTest.setVisible(true);
    }
 
    class InnerPanel extends JPanel {
        private static final long serialVersionUID = 1547128190348749556L;
        public void paint(Graphics g) {
            super.paint(g);
            g.drawImage(img, 0, 0, null);
        }
    }
 
    public void img(String filename) {
        // �̹��� �޾ƿ��� - gameOn, gameOff (�α���, �α׿���)
        try {
            img = ImageIO.read(new File("img/img/"+filename+".png"));
        } catch (IOException e) {
            System.out.println("예시!");
            System.exit(0);
        }
        repaint();
    }
}