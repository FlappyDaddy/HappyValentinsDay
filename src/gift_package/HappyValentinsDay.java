package gift_package;

import java.awt.Container;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

/**
 * A funny code for your lover, which creates a frame that let her/him choose 
 * whether she/he loves you. If she/he choose 'YES', everythingis normal, but
 * if she/he tries to choose 'NO', something interestingwould happen. First,
 * the 'NO' button would change its position, it lookes like it attemps to escape
 * from being clicked. After a couple of rounds, if she/he still want to click 
 * 'NO' button, the 'NO' button and 'YES' button will exchange their position. 
 * Besides, the window will cannot be closed untill the 'YES' button is clicked.
 * 
 * To use this code, please make sure her/his computer has installed the JRE. 
 * 
 * Note that this code is just a little joke, DO NOT USE IT AS A REAL VALENTIN'S 
 * DAY GIFT, if you want to get laid at Valentin's Day, use ROSE, WINE and FANCY
 * RESTAURANT, if you want to keep your mate's love, use YOUR HEART.
 *
 * @author rainman_zjd
 * @version initialt version, 2016.3.20
 */
public class HappyValentinsDay extends JFrame {

    private static final long serialVersionUID = 1L;

    private JLabel          label;
    private JButton         button1;
    private JButton         button2;
    private JDialog         dialog1;

    private int enterCount = 0;
    private boolean chooseFlag = false;

    public static final int screenWidth = 
            (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    public static final int screenHeight = 
            (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();

    public HappyValentinsDay() {
        label   = new JLabel("Hi, my name is rainman_zjd, I love you, do you love me?", SwingConstants.CENTER);
        button1 = new JButton("NO, I don't!");
        button2 = new JButton("Yes, I do!");
        dialog1 = new JDialog(this);
        windowInitial();
        setWindowListener();
    }// constructor

    public HappyValentinsDay(String labelTxt, String bt1Txt, String bt2Txt) {
        label   = new JLabel(labelTxt, SwingConstants.CENTER);
        button1 = new JButton(bt1Txt);
        button2 = new JButton(bt2Txt);
        dialog1 = new JDialog(this);
        windowInitial();
        chooseFlag = true;
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);
    }// constructor_String

    private void windowInitial() {
        setDialog(dialog1, "Awesome!", "Meeting you is the luckest thing in my life!");

        label.setFont(new Font("", Font.BOLD, 17));
        label.setBounds(0, 30, 480, 20);

        button1.addMouseListener(new MouseListener() { 
            @Override
            public void mouseReleased(MouseEvent e) {return;}           
            @Override
            public void mousePressed(MouseEvent e) {return;}            
            @Override
            public void mouseExited(MouseEvent e) {return;}            
            @Override
            public void mouseEntered(MouseEvent e) {
                switch(enterCount) {
                case 0:
                    button1.setBounds(75, 60, 110, 30);
                    HappyValentinsDay.this.repaint();
                    ++enterCount;
                    break;
                case 1:
                    button1.setBounds(75, 110, 110, 30);
                    HappyValentinsDay.this.repaint();
                    ++enterCount;
                    break;
                case 2:
                    button1.setBounds(155, 60, 110, 30);
                    HappyValentinsDay.this.repaint();
                    ++enterCount;
                    break;
                case 3:
                    button1.setBounds(75, 110, 110, 30);
                    HappyValentinsDay.this.repaint();
                    ++enterCount;
                    break;
                case 4:
                    button1.setBounds(310, 110, 110, 30);
                    button2.setBounds(75, 110, 110, 30);
                    HappyValentinsDay.this.repaint();
                    ++enterCount;
                    break;
                case 5:
                    button1.setBounds(75, 110, 110, 30);
                    button2.setBounds(310, 110, 110, 30);
                    HappyValentinsDay.this.repaint();
                    enterCount = 0;
                    break;
                }// seitch_entercount
            }// mouseEntered           
            @Override
            public void mouseClicked(MouseEvent e) {
                dialog1.setVisible(true);
                setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            }// mouseClicked
        });// MouseListener
        button1.setBounds(70, 110, 110, 30);
        button1.setFont(new Font("", Font.BOLD, 13));

        button2.addMouseListener(new MouseListener() {      
            @Override
            public void mouseReleased(MouseEvent e) {return;}           
            @Override
            public void mousePressed(MouseEvent e) {return;}           
            @Override
            public void mouseExited(MouseEvent e) {return;}            
            @Override
            public void mouseEntered(MouseEvent e) {return;}           
            @Override
            public void mouseClicked(MouseEvent e) {
                dialog1.setVisible(true);
                chooseFlag = true;
                setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            }// mouseClicked
        });// MouseListener
        button2.setBounds(310, 110, 110, 30);
        button2.setFont(new Font("", Font.BOLD, 13));

        Container c = getContentPane();
        c.setLayout(null);
        c.add(label);
        c.add(button1);
        c.add(button2);
        setTitle("Happy Valentin's Day!");
        setBounds(screenWidth/2-250, screenHeight/2-100, 500, 200);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
    }// windowInitial

    private void setDialog(JDialog diag, String tittle, String txt) {
        JLabel diagLabel = new JLabel(txt, SwingConstants.CENTER);
        diagLabel.setFont(new Font("", Font.BOLD, 17));
        diagLabel.setBounds(0, 40, 430, 20);
        JButton diagBut = new JButton("Confirm");
        diagBut.setFont(new Font("", Font.BOLD, 14));
        diagBut.setBounds(155, 100, 100, 30);
        diagBut.addMouseListener(new MouseListener() {            
            @Override
            public void mouseReleased(MouseEvent e) {return;}                        
            @Override
            public void mousePressed(MouseEvent e) {return;}                        
            @Override
            public void mouseExited(MouseEvent e) {return;}                     
            @Override
            public void mouseEntered(MouseEvent e) {return;}          
            @Override
            public void mouseClicked(MouseEvent e) {
                diag.dispose();
                if (chooseFlag)
                    System.exit(0);
            }// mouseClicked
        });
        diag.setTitle(tittle);
        diag.setBounds(screenWidth/2-225, screenHeight/2-100, 450, 200);
        diag.setLayout(null);
        diag.add(diagBut);
        diag.add(diagLabel);
    }// setDialog

    private void setWindowListener() {
        this.addWindowListener(new WindowListener() {           
            @Override
            public void windowOpened(WindowEvent e) {return;}         
            @Override
            public void windowIconified(WindowEvent e) {return;}           
            @Override
            public void windowDeiconified(WindowEvent e) {return;}
            @Override
            public void windowDeactivated(WindowEvent e) {return;}
            @Override
            public void windowClosed(WindowEvent e) {return;}          
            @Override
            public void windowActivated(WindowEvent e) {return;}
            @Override
            public void windowClosing(WindowEvent e) {
                if(!chooseFlag) {
                    String labelTxt = "Is your default choose is \"Yes, I do!\"?";
                    new HappyValentinsDay(labelTxt, "NO", "YES");
                }// if
            }// windowClosing
        });// WindowListener
    }// setWindowListener

    public static void main(String[] args) {
        HappyValentinsDay myApp = new HappyValentinsDay();
        myApp.setVisible(true);
    }// main

}/*HappyValentinsDay*/
