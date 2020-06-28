package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Tvshow;

public class TvshowDao {
	private Connection connection;
	private final String GET_TVSHOWS_QUERY = "SELECT * FROM tvshows";
	private final String GET_TVSHOW_BY_ID_QUERY = "SELECT * FROM tvshows WHERE id = ?";
	private final String CREATE_NEW_TVSHOW_QUERY = "INSERT INTO tvshows(first_name, last_name, tvshow_name) VALUES(?,?,?)";
	private final String DELETE_TVSHOW_BY_ID_QUERY = "DELETE FROM tvshows WHERE id = ?";
	private final String UPDATE_TVSHOW_QUERY = "UPDATE tvshows SET tvshow_name = ? WHERE id = ?";


	//once database connection established you can configure daos to access data
	//add a method for the display teams to get all the teams to display them
	
	public TvshowDao() {
		
		connection = DBConnection.getConnection();
	}
	
	public List<Tvshow> getTvshows() throws SQLException {
		ResultSet rs = connection.prepareStatement(GET_TVSHOWS_QUERY).executeQuery();
		List<Tvshow> tvshows = new ArrayList<Tvshow>();
	
	while (rs.next()) {
		tvshows.add(populateTvshow(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
	}
	return tvshows;

}
	
	
	
	public Tvshow getTvshowByID(int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(GET_TVSHOW_BY_ID_QUERY);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		rs.next();
		return populateTvshow(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
	}
	
	public void createNewTvshow(String firstName, String lastName, String tvshow) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(CREATE_NEW_TVSHOW_QUERY);
		ps.setString(1, firstName);
		ps.setString(2, lastName);
		ps.setString(3, tvshow);
		ps.executeUpdate();
		}
	
	public void deleteTvshowByID(int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(DELETE_TVSHOW_BY_ID_QUERY);
		ps.setInt(1, id);
		ps.executeUpdate();
	}
	
	public void updateTVshowByID(int id, String tvshow) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(UPDATE_TVSHOW_QUERY);
		ps.setString(1, tvshow);
		ps.setInt(2, id);
		ps.executeUpdate();
	}
	
	private Tvshow populateTvshow(int id, String firstName, String lastName, String tvshow) {
		return new Tvshow(id, firstName, lastName, tvshow);
	}
}