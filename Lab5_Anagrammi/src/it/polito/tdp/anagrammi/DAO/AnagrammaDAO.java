package it.polito.tdp.anagrammi.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.anagrammi.DAO.ConnectDB;


public class AnagrammaDAO{
	
public boolean isCorrect(String anagramma) {
	final String sql = "SELECT nome FROM parola where nome=?";



	try {
		Connection conn = ConnectDB.getConnection();
		PreparedStatement st = conn.prepareStatement(sql);
         st.setString(1, anagramma);
		ResultSet rs = st.executeQuery();
        
		if(rs.next()) {conn.close();    return true;}
        
		else {conn.close(); return false;}

	} catch (SQLException e) {
		// e.printStackTrace();
		throw new RuntimeException("Errore Db");
	}
}
}

