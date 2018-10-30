/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inheritance_lab;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
/**
 *
 * @author w58z387
 */
public class MyFrame extends JFrame implements MouseListener
{
    private JPanel my_jp = new JPanel();
    
    public MyFrame(String my_string)
    {
        super(my_string);
        this.my_jp.setBackground(new Color(255, 255, 0));
        super.getContentPane().add(my_jp);
        super.setSize(300, 600);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.addMouseListener(this);
        super.setVisible(true);
    }
    public JPanel get_panel()
    {
        return my_jp;
    }
    
    @Override
    public void mouseClicked(MouseEvent e)
    {
    }
    @Override
    public void mousePressed(MouseEvent e)
    {
    }
    @Override
    public void mouseReleased(MouseEvent e)
    {
        Random my_rand = new Random();
        Color rando_color = new Color (my_rand.nextInt(256), 
                                       my_rand.nextInt(256),
                                       my_rand.nextInt(256));
        this.my_jp.setBackground(rando_color);
    }
    @Override
    public void mouseEntered(MouseEvent e)
    {
    }
    @Override
    public void mouseExited(MouseEvent e)
    {
        this.my_jp.setBackground(new Color(255, 255, 0));
    }
    
}
