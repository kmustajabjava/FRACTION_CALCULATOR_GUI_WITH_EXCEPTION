import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GI  implements ActionListener
{  
    JTextField tf1,tf2,tf3,tf4;  
    JButton plus,sub,mul,div,clear;  
    GI()
    {  JFrame frame=new JFrame();
    	frame.setTitle("FRACTION CALCULATOR");
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setResizable(false);
    	JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel topPnl = new JPanel();
        BoxLayout boxlayout = new BoxLayout(topPnl, BoxLayout.Y_AXIS);
        topPnl.setLayout(boxlayout);
        JPanel btnPnl = new JPanel(new FlowLayout(FlowLayout.CENTER));
    	
        Color teal=new Color(0,128,128);
    	Color ygreen=new Color(154,205,50);
    	JLabel jl1=new JLabel("    FRACTION 1    ");
    	jl1.setAlignmentX(JLabel.CENTER_ALIGNMENT);
    	jl1.setFont(new Font("Courier", Font.BOLD, 16));
    	tf1=new JTextField(); 
    	tf1.setColumns(20);
    	jl1.setBackground(teal);
    	jl1.setOpaque(true);
    	jl1.setForeground(Color.black);
    	topPnl.add(jl1);
        topPnl.add(tf1);
        
    	JLabel jl2=new JLabel("    FRACTION 2    ");
    	jl2.setAlignmentX(JLabel.CENTER_ALIGNMENT);
    	jl2.setFont(new Font("Courier", Font.BOLD, 16));
    	jl2.setBackground(teal);
    	jl2.setOpaque(true);
    	jl2.setForeground(Color.black);
    	tf2=new JTextField(); 
    	tf2.setColumns(20);
    	topPnl.add(jl2);
        topPnl.add(tf2);
         
    	JLabel jl3=new JLabel("        RESULT        ");
    	jl3.setAlignmentX(JLabel.CENTER_ALIGNMENT);
    	jl3.setFont(new Font("Courier", Font.BOLD, 16));
    	jl3.setBackground(teal);
    	jl3.setOpaque(true);
    	jl3.setForeground(Color.black);
        tf3=new JTextField(); 
        tf3.setColumns(20);
        tf3.setEditable(false); 
        topPnl.add(jl3);
        topPnl.add(tf3);
        
        tf4=new JTextField();    
        tf4.setColumns(20);
        tf4.setEditable(false);
        JLabel jl4=new JLabel(" FULL FRACTION ");
        jl4.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        jl4.setFont(new Font("Courier", Font.BOLD, 16));
        jl4.setBackground(teal);
    	jl4.setOpaque(true);
    	jl4.setForeground(Color.black);
        topPnl.add(jl4);
        topPnl.add(tf4);
        
        plus=new JButton(" + ");  
        plus.setFont(new Font("Courier", Font.BOLD, 16));
        plus.setBackground(ygreen);
    	plus.setForeground(Color.black);
    	
        sub=new JButton(" - ");  
        sub.setFont(new Font("Courier", Font.BOLD, 16));
        sub.setBackground(ygreen);
    	sub.setForeground(Color.black);
    	
        mul=new JButton(" * ");  
        mul.setFont(new Font("Courier", Font.BOLD, 16));
        mul.setBackground(ygreen);
    	mul.setForeground(Color.black);
    	
        div=new JButton(" / "); 
        div.setFont(new Font("Courier", Font.BOLD, 16));
        div.setBackground(ygreen);
    	div.setForeground(Color.black);
    	
    	clear=new JButton(" CLEAR ");  
        clear.setFont(new Font("Courier", Font.PLAIN, 16));
        clear.setBackground(teal);
    	clear.setForeground(Color.black);
    	
        plus.addActionListener(this);  
        sub.addActionListener(this); 
        mul.addActionListener(this); 
        div.addActionListener(this); 
        clear.addActionListener(this);
        
        btnPnl.add(plus);
        btnPnl.add(sub);
        btnPnl.add(mul);
        btnPnl.add(div);
        btnPnl.add(clear);
        
        mainPanel.add(topPnl, BorderLayout.NORTH);
        mainPanel.add(btnPnl, BorderLayout.CENTER);
        frame.add(mainPanel);
        frame.setSize(300,300);  
        frame.setVisible(true);  
    }     
    public void actionPerformed(ActionEvent e)
    {  
    	
        String s1=tf1.getText();  
        String s2=tf2.getText();
        if(e.getSource()==clear)
        {
        	tf1.setText("");
            tf2.setText("");
            tf3.setText("");
            tf4.setText("");
        }
        if(s1.isBlank()||s1.isEmpty()||s2.isBlank()||s2.isEmpty())
        {
        	String msg="Enter Both the Fractions first";
        	JOptionPane.showMessageDialog(null,msg);
        }
        else
        {
        	try
        	{
        		Fraction F1=new Fraction(s1);
                Fraction F2=new Fraction(s2);
                Fraction result=new Fraction();	
                String data=tf3.getText();
                if(e.getSource()==plus)
                {  
                   result=F1.addFraction(F2);
                   tf3.setText(result.toString());
                   data=tf1.getText()+plus.getText()+tf2.getText()+"="+tf3.getText();
                   tf4.setText(data);
                }
                else if(e.getSource()==sub)
                {  
                	 result=F1.subFraction(F2);
                	 tf3.setText(result.toString());
                	 data=tf1.getText()+sub.getText()+tf2.getText()+"="+tf3.getText();
                	
                     tf4.setText(data);
                } 
                else if(e.getSource()==mul)
                {  
                	 result=F1.mulFraction(F2);
                	 tf3.setText(result.toString());
                	 data=tf1.getText()+mul.getText()+tf2.getText()+"="+tf3.getText();
                	 
                     tf4.setText(data);
                } 
                else if(e.getSource()==div)
                {  
                	 result=F1.divFraction(F2);
                     tf3.setText(result.toString());
                     data=tf1.getText()+div.getText()+tf2.getText()+"="+tf3.getText();
                     tf4.setText(data);
                } 
        	}
        	catch(FractionException f )
        	{
        		JOptionPane.showMessageDialog(null, "Invalid Fraction,"+f.reason);
        		tf1.setText("");
                tf2.setText("");
                tf3.setText("");
                tf4.setText("");
        	}
        	catch(NumberFormatException f1)
        	{
        		JOptionPane.showMessageDialog(null, "Invalid Fraction,");
        		tf1.setText("");
                tf2.setText("");
                tf3.setText("");
                tf4.setText("");
        	}
        }
        
    }  
public static void main(String[] args) 
{  
    new GI();  
}
}  