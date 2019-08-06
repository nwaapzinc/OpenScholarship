/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package senter;

import com.mysql.cj.protocol.Resultset;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author saba
 */
public class NewClass {
    public static void main(String[] args) {
        try {   
          //  Connection con=DriverManager.getConnection("jdbc:mysql://db4free.net/sedata","remote","11111111");
          Connection con=DriverManager.getConnection("jdbc:mysql://nwaapz.ir/nwaapzir_scx","nwaapzir_remote","fckgwrhqqU");
            String query="SELECT * FROM `insrank`;";
            String upQuer="UPDATE `insrank` SET `QsRank`=? WHERE `id`=?";
            Statement st=con.createStatement();
            PreparedStatement pst=con.prepareStatement(upQuer);
            
            ResultSet rs=st.executeQuery(query);
            while(rs.next())
            {
                int qsrank=rs.getInt("QsRank");
                int idk=rs.getInt("id");
                if(qsrank>10000)
                {
                  String p1=String.valueOf(qsrank);
                  String p2=String.valueOf(qsrank);
                  if(qsrank>10000000)
                  {
                            p1=p1.substring(0, 3);
                            p2=p2.substring(3, 7);


                            int FqsRank=(Integer.valueOf(p1)+Integer.valueOf(p2))/2;

                            pst.setInt(1, FqsRank);
                            pst.setInt(2, idk);
                            pst.executeUpdate(); 
                            System.err.println(qsrank+" updated to"+FqsRank);
                  }else{
                            p1=p1.substring(0, 3);
                            p2=p2.substring(3, 6);


                            int FqsRank=(Integer.valueOf(p1)+Integer.valueOf(p2))/2;

                            pst.setInt(1, FqsRank);
                            pst.setInt(2, idk);
                            pst.executeUpdate(); 
                            System.err.println(qsrank+" updated to"+FqsRank);
                  }
                 
                    
                     
                  
                }
                
            }
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(NewClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
