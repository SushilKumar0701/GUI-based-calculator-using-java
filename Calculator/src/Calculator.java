import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
class Calculator extends JFrame implements ActionListener {
	static JFrame f;
	static JTextField tf;
	String s0,s1,s2;
	Calculator() {
		s0=s1=s2= " ";
	}
	public static void main(String[] args) {
		f=new JFrame("My Calculator");
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

		Calculator c=new Calculator();
		tf=new JTextField(17);
		tf.setEditable(false);
		JButton b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,badd,bsub,bmul,bdiv,bpoint,bequal,bclear;
		
		b0=new JButton("0");
		b1=new JButton("1");
		b2=new JButton("2");
		b3=new JButton("3");
		b4=new JButton("4");
		b5=new JButton("5");
		b6=new JButton("6");
		b7=new JButton("7");
		b8=new JButton("8");
		b9=new JButton("9");
		bpoint=new JButton(".");
		bequal=new JButton("=");
		bclear=new JButton("C");
		
		badd=new JButton("+");
		bsub=new JButton("-");
		bmul=new JButton("*");
		bdiv=new JButton("/");
		
		JPanel jp=new JPanel();
		
		b0.addActionListener(c);
		b1.addActionListener(c);
		b2.addActionListener(c);
		b3.addActionListener(c);
		b4.addActionListener(c);
		b5.addActionListener(c);
		b6.addActionListener(c);
		b7.addActionListener(c);
		b8.addActionListener(c);
		b9.addActionListener(c);
		bdiv.addActionListener(c);
		bmul.addActionListener(c);
		bsub.addActionListener(c);
		badd.addActionListener(c);
		bequal.addActionListener(c);
		bpoint.addActionListener(c);
		bclear.addActionListener(c);
		
		Font font=new Font("consolas",Font.BOLD,20);
		tf.setFont(font);
		b0.setFont(font);
		b1.setFont(font);
		b2.setFont(font);
		b3.setFont(font);
		b4.setFont(font);
		b5.setFont(font);
		b6.setFont(font);
		b7.setFont(font);
		b8.setFont(font);
		b9.setFont(font);
		badd.setFont(font);
		bsub.setFont(font);
		bmul.setFont(font);
		bdiv.setFont(font);
		bpoint.setFont(font);
		bequal.setFont(font);
		bclear.setFont(font);
		
		
		jp.add(tf);
		jp.add(b1);
		jp.add(b2);
		jp.add(b3);
		jp.add(bdiv);
		jp.add(b4);
		jp.add(b5);
		jp.add(b6);
		jp.add(bmul);
		jp.add(b7);
		jp.add(b8);
		jp.add(b9);
		jp.add(bsub);
		jp.add(bpoint);
		jp.add(b0);
		jp.add(bclear);
		jp.add(badd);
		jp.add(bequal);
		
		jp.setBackground(Color.blue);
		f.add(jp);
		f.setSize(220, 270);
		f.show();
		f.setLayout(new GridLayout());
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String s=e.getActionCommand();
		if((s.charAt(0)>='0' && s.charAt(0)<='9')|| s.charAt(0)=='.') {
			if(!s1.equals(""))
				s2=s2+s;
			else
				s0=s0+s;
			tf.setText(s0 + s1 + s2);
		}
		else if(s.charAt(0)=='C') {
			s0=s1=s2="";
			tf.setText(s0 + s1 + s2);
		}
		else if(s.charAt(0)== '=') {
			double total = 0;
			if(s1.equals("+"))
				total=(Double.parseDouble(s0) + Double.parseDouble(s2));
			if(s1.equals("-"))
				total=(Double.parseDouble(s0) - Double.parseDouble(s2));
			if(s1.equals("*"))
				total=(Double.parseDouble(s0) * Double.parseDouble(s2));
			if(s1.equals("/"))
				total=(Double.parseDouble(s0) / Double.parseDouble(s2));
			
			tf.setText(s0 + s1 + s2 + "=" +total);
			s0=Double.toString(total);
			s1=s2="";
		}
		else {
			if(s1.equals("") || s2.equals(""))
				s1=s;
			else {
				double total = 0;
				if(s1.equals("+"))
					total=(Double.parseDouble(s0) + Double.parseDouble(s2));
				if(s1.equals("-"))
					total=(Double.parseDouble(s0) - Double.parseDouble(s2));
				if(s1.equals("*"))
					total=(Double.parseDouble(s0) * Double.parseDouble(s2));
				if(s1.equals("/"))
					total=(Double.parseDouble(s0) / Double.parseDouble(s2));
				
				s0=Double.toString(total);
				s1=s;
				s2="";
			}
			tf.setText(s0 + s1 + s2);
		}
	}
}
