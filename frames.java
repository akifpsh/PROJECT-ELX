import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class frames extends mysqls{

    JLabel label=new JLabel("BİLGİ GİRİNİZ :");
    JLabel label2=new JLabel("HAYKIR EGEMEN SUNAR");
    JLabel label3=new JLabel("  ");
    JTextField field=new JTextField();
    JTextField tf2=new JTextField();

    public void framess() throws SQLException{
        //frame açış
        JFrame frame=new JFrame("EGE");

        //tablo kısmı
        String [] data=new String[10];
        String [] column={"TC","TEL NO","İSİM","SOYİSİM","BABA İSİM","BABA TC","ANNE İSİM","ANNE TC","İL","İLÇE"};

        JTable table=new JTable();
        DefaultTableModel tablo=new DefaultTableModel();
        tablo.setColumnIdentifiers(column);
        
        JScrollPane scroll=new JScrollPane();
        scroll.setBounds(70,100,800,370);
        frame.add(scroll);
        scroll.setViewportView(table);
        table.setModel(tablo);
        
        //BİLGİ GİRİŞ
        label.setBounds(80,30,150,30);
        label.setFont(new Font("font",Font.ITALIC,20));
        frame.add(label);
        
        //BİLGİ TARAMA 
        JButton button=new JButton("ARA");
        button.setBounds(400,30,80,30);
        button.setBackground(Color.WHITE);
        frame.add(button);
        button.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e){ 
            try {
                int count=0;
                tablo.setRowCount(0);
                mysqlss();
                while(rs.next()){
                    if(field.getText().equals(rs.getString("TC"))||field.getText().equals(rs.getString("İSİM"))){
                        count++;
                        label3.setForeground(Color.green);
                        label3.setText(count+" ADET VERİ BULUNDU");
                        data[0]=rs.getString("TC");
                        data[1]=rs.getString("TELNO");
                        data[2]=rs.getString("isim");
                        data[3]=rs.getString("soyisim");
                        data[4]=rs.getString("BABAİSİM");
                        data[5]=rs.getString("BABATC");
                        data[6]=rs.getString("ANNEİSİM");
                        data[7]=rs.getString("ANNETC");
                        data[8]=rs.getString("İL");
                        data[9]=rs.getString("İLÇE");
                        tablo.addRow(data);
                    }
                    else{
                        label3.setForeground(Color.red);
                        label3.setText("VERİ BULUNAMADI");
                    }                    
                }
                table.setModel(tablo);
            } catch (SQLException e1) {
                e1.printStackTrace();
            }

        }

        });

        //egemen ismi
        label2.setFont(new Font("font",Font.ITALIC,20));
        label2.setBounds(600,30,300,30);
        frame.add(label2);

        label3.setFont(new Font("font",Font.ITALIC,20));
        label3.setBounds(300,60,300,30);
        frame.add(label3);

        //bilgi yazılan alan
        field.setBounds(230,30,135,30);
        field.setForeground(Color.black);
        field.setFont(new Font("font",Font.PLAIN,20));
        frame.add(field);

        //hatayı bulamadım bunsuz olmuyor dursun.
        tf2.setBounds(10,20,40,50);
        frame.add(tf2);
        tf2.setVisible(false);

        //frame devamı
        frame.setSize(960,540);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
   


