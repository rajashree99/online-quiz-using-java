/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication9;

import java.awt.*;  
import java.awt.event.*;  
import javax.swing.*;  
  
class OnlineTest extends JFrame implements ActionListener  
{  
    JLabel l;  
    JRadioButton jb[]=new JRadioButton[5];  
    JButton b1,b2;  
    ButtonGroup bg;  
    int count=0,current=0,x=1,y=1,now=0;  
    int m[]=new int[10];      
    OnlineTest(String s)  
    {  
        super(s);  
        l=new JLabel();  
        add(l);  
        bg=new ButtonGroup();  
        for(int i=0;i<5;i++)  
        {  
            jb[i]=new JRadioButton();     
            add(jb[i]);  
            bg.add(jb[i]);  
        }  
        b1=new JButton("Next");  
        b2=new JButton("Bookmark");  
        b1.addActionListener(this);  
        b2.addActionListener(this);  
        add(b1);add(b2);  
        set();  
        l.setBounds(30,40,450,20);  
        jb[0].setBounds(50,80,100,20);  
        jb[1].setBounds(50,110,100,20);  
        jb[2].setBounds(50,140,100,20);  
        jb[3].setBounds(50,170,100,20);  
        b1.setBounds(100,240,100,30);  
        b2.setBounds(270,240,100,30);  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        setLayout(null);  
        setLocation(250,100);  
        setVisible(true);  
        setSize(600,350);  
    }  
    public void actionPerformed(ActionEvent e)  
    {  
        if(e.getSource()==b1)  
        {  
            if(check())  
                count=count+1;  
            current++;  
            set();    
            if(current==9)  
            {  
                b1.setEnabled(false);  
                b2.setText("Result");  
            }  
        }  
        if(e.getActionCommand().equals("Bookmark"))  
        {  
            JButton bk=new JButton("Bookmark"+x);  
            bk.setBounds(480,20+30*x,100,30);  
            add(bk);  
            bk.addActionListener(this);  
            m[x]=current;  
            x++;  
            current++;  
            set();    
            if(current==9)  
                b2.setText("Result");  
            setVisible(false);  
            setVisible(true);  
        }  
        for(int i=0,y=1;i<x;i++,y++)  
        {  
        if(e.getActionCommand().equals("Bookmark"+y))  
        {  
            if(check())  
                count=count+1;  
            now=current;  
            current=m[y];  
            set();  
            ((JButton)e.getSource()).setEnabled(false);  
            current=now;  
        }  
        }  
      
        if(e.getActionCommand().equals("Result"))  
        {  
            if(check())  
                count=count+1;  
            current++;  
            //System.out.println("correct ans="+count);  
            JOptionPane.showMessageDialog(this,"correct ans="+count);  
            System.exit(0);  
        }  
    }  
    void set()  
    {  
        jb[4].setSelected(true);  
        if(current==0)  
        {  
            l.setText("Que1: If the numerator of a fraction is increased by 500% and the denominator is increased by 300%, the resultant fraction is 1(1/17). What was the original fraction?");  
            jb[0].setText("12/17");jb[1].setText("13/12");jb[2].setText("3/17");jb[3].setText("4/17");   
        }  
        if(current==1)  
        {  
            l.setText("Que2:The number obtained by interchanging the digits of a two-digit number is less than the original number by 63. If the sum of the digits of the number is 11, what is the original number?");  
            jb[0].setText("92");jb[1].setText("29");jb[2].setText("24");jb[3].setText("none of these");  
        }  
        if(current==2)  
        {  
            l.setText("Que3:  In how many different ways can the letters of the word DAILY be arranged?");
            jb[0].setText("120");jb[1].setText("400");jb[2].setText("300");jb[3].setText("100");
        }  
        if(current==3)  
        {  
            l.setText("Que4: By how much is 3/5 of 735 greater than 2/3 of 633?");  
            jb[0].setText("19");jb[1].setText("20");jb[2].setText("21");jb[3].setText("25");  
        }  
        if(current==4)  
        {  
            l.setText("Que5: A train running at the speed of 60 km/hr crosses a pole in 9 seconds. What is the length of the tra");  
            jb[0].setText("150");jb[1].setText("120");jb[2].setText("140");jb[3].setText("100");  
        }  
        if(current==5)  
        {  
            l.setText("Que6: A train 125 m long passes a man, running at 5 km/hr in the same direction in which the train is going, in 10 seconds. The speed of the train is:");  
            jb[0].setText("50km/hr");jb[1].setText("540km/hr");jb[2].setText("40km/hr");jb[3].setText("60km/hr");  
        }  
        if(current==6)  
        {  
            l.setText("Que7: The length of the bridge, which a train 130 metres long and travelling at 45 km/hr can cross in 30 seconds, is: ");  
            jb[0].setText("245m");jb[1].setText("256m");jb[2].setText("234m");  
                        jb[3].setText("455m");  
        }  
        if(current==7)  
        {  
            l.setText("Que8: Two trains running in opposite directions cross a man standing on the platform in 27 seconds and 17 seconds respectively and they cross each other in 23 seconds. The ratio of their speeds is:");  
            jb[0].setText("3:2");jb[1].setText("1:3");jb[2].setText("5:1");  
                        jb[3].setText("none of these");         
        }  
        if(current==8)  
        {  
            l.setText("Que9: A train passes a station platform in 36 seconds and a man standing on the platform in 20 seconds. If the speed of the train is 54 km/hr, what is the length of the platform?");  
            jb[0].setText("240");jb[1].setText("255");jb[2].setText("455");jb[3].setText("788");  
        }  
        if(current==9)  
        {  
            l.setText("Que10: Two trains of equal lengths take 10 seconds and 15 seconds respectively to cross a telegraph post. If the length of each train be 120 metres, in what time (in seconds) will they cross each other travelling in opposite direction?");  
            jb[0].setText("12s");jb[1].setText("12.5s");jb[2].setText("13s");  
                        jb[3].setText("20.2s");  
        }  
        l.setBounds(30,40,450,20);  
        for(int i=0,j=0;i<=90;i+=30,j++)  
            jb[j].setBounds(50,80+i,200,20);  
    }  
    boolean check()  
    {  
        if(current==0)  
            return(jb[0].isSelected());  
        if(current==1)  
            return(jb[0].isSelected());  
        if(current==2)  
            return(jb[0].isSelected());  
        if(current==3)  
            return(jb[0].isSelected());  
        if(current==4)  
             return(jb[0].isSelected()); 
        if(current==5)  
           return(jb[0].isSelected()); 
        if(current==6)  
           return(jb[0].isSelected()); 
        if(current==7)  
            return(jb[0].isSelected());  
        if(current==8)  
            return(jb[0].isSelected()); 
        if(current==9)  
            return(jb[0].isSelected()); 
        return false;  
    }  
    public static void main(String s[])  
    {  
        new OnlineTest("Online Test for Aptitude");
    }  
}  
