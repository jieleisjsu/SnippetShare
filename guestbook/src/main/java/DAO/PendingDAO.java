package DAO;
import java.util.List;

import Entity.Pending;
public interface PendingDAO {
	public boolean insert(Pending pending);
	public boolean delete(Pending pending);
	public List<Pending> findByBoardID(int boardID);
}