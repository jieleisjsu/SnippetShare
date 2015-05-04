package DAO;

import java.util.List;

import Entity.Snippet;

public interface SnippetDAO {
	public boolean insert(Snippet snippet);
	public List<Snippet> findByBoard(int boardID);
	public boolean deleteByID(int id);
	public boolean update(int id, Snippet snippet);
	public Snippet findByID(int id);
	public List<Snippet> findByUsername(String username);
}
