package DAO;

import java.util.*;

import Entity.Board;

public interface BoardDAO {
	public boolean insert(Board board);
	public Board findByID(int id);
	public List<Board> findOwnBoard(String username);
	public List<Board> findPublicBoard();
	public List<Board> findPrivate(String username);
	public Set<Integer> findAllAvailbleBoardID(String username);
}