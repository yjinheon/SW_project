package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
 
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
 
@SuppressWarnings("serial")
public class ManageView extends JFrame {
 
    public ManageView() {
 
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setSize(1600, 900);
        setTitle("ManageView");
        setLayout(null);
        // 내 윈도우 화면
        Dimension frameSize = this.getSize();
        Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((windowSize.width - frameSize.width) / 2, (windowSize.height - frameSize.height) / 2);
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, 1600, 900);
        layeredPane.setLayout(null);
 
        // 배경
        JPanel myPanel = new MyPanel();
        myPanel.setLayout(null);
        myPanel.setBounds(0, -30, 1600, 900);
        // 시계
        ImgClock imgClock = new ImgClock();
        imgClock.setLayout(null);
        imgClock.setBounds(15, 20, 179, 149);
        imgClock.setOpaque(false); // 배경이 투명처리
        new Thread(imgClock).start();
        // 시계 글씨
        ClockMessage clockMessage = new ClockMessage();
        clockMessage.setBounds(80, 53, 100, 100);
        clockMessage.setOpaque(false);
        new Thread(clockMessage).start();
 
        // 움직이는 광원처리
        MyStarPanel myStarPanel = new MyStarPanel();
        myStarPanel.setLayout(null);
        myStarPanel.setBounds(0, -30, 1600, 900);
        myStarPanel.setOpaque(false);
        new Thread(myStarPanel).start();
         
         
         
        //TODO 여기도 계속 잡아줌
        // 최종 삽입
        layeredPane.add(myPanel, new Integer(0));
        layeredPane.add(imgClock, new Integer(4));
        layeredPane.add(clockMessage, new Integer(5));
        layeredPane.add(myStarPanel, new Integer(3));
        add(layeredPane);
    }
 
    public static void main(String[] args) {
        new ManageView();
    }
 
    // 메인 배경 화면
    class MyPanel extends JPanel {
        Image image;
        public MyPanel() {
            image = Toolkit.getDefaultToolkit().createImage("img/mainHud_back.png");
        }
        @Override
        public void paint(Graphics g) {
            super.paint(g);
            g.drawImage(image, 0, 0, this);
        }
    }
 
    // 시계이미지
    class ImgClock extends JPanel implements Runnable {
        Image img[] = new Image[4];
        int i = 2;
        public ImgClock() {
            img[1] = Toolkit.getDefaultToolkit().createImage("img/cl1.png");
            img[2] = Toolkit.getDefaultToolkit().createImage("img/cl2.png");
            img[3] = Toolkit.getDefaultToolkit().createImage("img/cl3.png");
            img[0] = img[1];
        }
        @Override
        public void paint(Graphics g) {
            super.paint(g);
            g.drawImage(img[0], 0, 0, this);
        }
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(10000);
                    switch (i) {
                    case 1:
                        img[0] = img[i];
                        i++;
                        repaint();
                        break;
                    case 2:
                        img[0] = img[i];
                        i++;
                        repaint();
                        break;
                    case 3:
                        img[0] = img[i];
                        i = 1;
                        repaint();
                        break;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
 
    // 시계글씨
    class ClockMessage extends JPanel implements Runnable {
        int i = Calendar.getInstance().get(Calendar.AM_PM);
        String[] ampm = { "AM", "PM" };
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
        String time = sdf.format(new Date());
        JLabel timeLabel, ampmLabel;
 
        public ClockMessage() {
            this.setLayout(null);
 
            timeLabel = new JLabel(time);
            timeLabel.setBounds(0, 0, 100, 20);
            timeLabel.setForeground(new Color(36, 205, 198));
            timeLabel.setFont(new Font("배달의민족 한나", Font.BOLD, 12));
 
            ampmLabel = new JLabel(ampm[i]);
            ampmLabel.setBounds(15, 20, 100, 30);
            ampmLabel.setForeground(new Color(36, 205, 198));
            ampmLabel.setFont(new Font("배달의민족 한나", Font.BOLD, 12));
 
            add(timeLabel, BorderLayout.NORTH);
            add(ampmLabel, BorderLayout.CENTER);
        }
 
        @Override
        public void run() {
            do {
                try {
                    Thread.sleep(1000);
 
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                timeLabel.setText(sdf.format(new Date()));
            } while (true);
        }
    }
 
    // 광원처리
    class MyStarPanel extends JPanel implements Runnable {
        Image img;
        int i = 1;
        int sleep = 25;
        int sx = 77, sy=0;
 
        public MyStarPanel() {
            img = Toolkit.getDefaultToolkit().createImage("img/starDdong.png");
        }
        @Override
        public void paint(Graphics g) {
            super.paint(g);
            if(img!=null) g.drawImage(img, sx, sy, this);
        }
 
        @Override
        public void run() {
            try {
                do {
                    Thread.sleep(sleep);
                    switch (i) {
                    case 1: sy+=2; if(sy>791) i=2; break;
                    case 2: sx+=2; if(sx>1507) i=3; break;
                    case 3: sy-=2; if(sy<53) i=4; break;
                    case 4: sx-=2; if(sx<77) i=1; break;
                    }
                    repaint();
                } while (true);
            } catch (Exception e) {
                System.out.println("무슨 에런지참. ");
            }
        }
 
    }
 
    // TODO 계속 들어감
 
}