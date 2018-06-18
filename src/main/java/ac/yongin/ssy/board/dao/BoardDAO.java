package ac.yongin.ssy.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import ac.yongin.ssy.board.vo.BoardVO;
import ac.yongin.ssy.common.JDBCUtil;

@Repository("boardDAO")
public class BoardDAO {
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;

	private final String INSERT_BOARD = "insert into board(title,writer,content) values(?,?,?)";
	private final String UPDATE_BOARD = "update board set title=?, content=? where seq=?";
	private final String DELETE_BOARD = "delete from board where seq=?";
	private final String GET_BOARD = "select * from board where seq=?";
	private final String GET_BOARD_LIST = "select * from board";
	private final String SEARCH_BOARD_1 = "select * from board where title =?";
	private final String SEARCH_BOARD_2 = "select * from board where content =?";
	private final String ADD_CNT = "update board set cnt=cnt+1 where seq=?";
	
	public void insertBoard(BoardVO vo) {
		System.out.println("==> JDBC로 insertBoard() : "+ INSERT_BOARD);
		try{
		conn = JDBCUtil.getConnection();
		stmt = conn.prepareStatement(INSERT_BOARD);
		stmt.setString(1, vo.getTitle());
		stmt.setString(2, vo.getWriter());
		stmt.setString(3, vo.getContent());
		stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, stmt);
		}
	}
	public void updateBoard(BoardVO vo) {
		System.out.println("==> JDBC로 updateBoard() : "+ UPDATE_BOARD);
		try{
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(UPDATE_BOARD);
			stmt.setString(1, vo.getTitle());
			stmt.setString(2, vo.getContent());
			stmt.setInt(3, vo.getSeq());
			stmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				JDBCUtil.close(conn, stmt);
			}
	}
	public void deleteBoard(BoardVO vo) {
		System.out.println("==> JDBC로 deleteBoard() : "+ DELETE_BOARD);
		try{
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(DELETE_BOARD);
			stmt.setInt(1, vo.getSeq());
			stmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				JDBCUtil.close(conn, stmt);
			}
	}
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("==> JDBC로 getBoard() : "+ GET_BOARD);
		BoardVO board = null;
		try{
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(GET_BOARD);
			stmt.setInt(1, vo.getSeq());
			rs = stmt.executeQuery();
			if(rs.next()) {
				board = new BoardVO();
				board.setSeq(rs.getInt(1));
				board.setTitle(rs.getString(2));
				board.setWriter(rs.getString(3));
				board.setContent(rs.getString(4));
				board.setRegDate(rs.getDate(5));
				board.setCnt(rs.getInt(6));
			}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				JDBCUtil.close(conn, stmt, rs);
			}
		return board;
	}
	public ArrayList<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("==> JDBC로 getBoardList() : "+ GET_BOARD_LIST);
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		BoardVO board = null;
		try{
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(GET_BOARD_LIST);
			rs = stmt.executeQuery();
			while(rs.next()) {
				board = new BoardVO();
				board.setSeq(rs.getInt(1));
				board.setTitle(rs.getString(2));
				board.setWriter(rs.getString(3));
				board.setContent(rs.getString(4));
				board.setRegDate(rs.getDate(5));
				board.setCnt(rs.getInt(6));
				list.add(board);
			}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				JDBCUtil.close(conn, stmt, rs);
			}
		return list;
	}
	public ArrayList<BoardVO> searchBoard(String searchKeyword) {
		System.out.println("==> JDBC로 searchBoard() : "+ SEARCH_BOARD_1);
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		BoardVO board = null;
		try{
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(SEARCH_BOARD_1);
			stmt.setString(1, searchKeyword);
			rs = stmt.executeQuery();
			while(rs.next()) {
				board = new BoardVO();
				board.setSeq(rs.getInt(1));
				board.setTitle(rs.getString(2));
				board.setWriter(rs.getString(3));
				board.setContent(rs.getString(4));
				board.setRegDate(rs.getDate(5));
				board.setCnt(rs.getInt(6));
				list.add(board);
			}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				JDBCUtil.close(conn, stmt, rs);
			}
		return list;
	}
	public ArrayList<BoardVO> searchBoard(String searchCondition, String searchKeyword) {
		System.out.println("==> JDBC로 searchBoard() : "+ SEARCH_BOARD_2);
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		BoardVO board = null;
		try{
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(SEARCH_BOARD_2);
			stmt.setString(1, searchKeyword);
			rs = stmt.executeQuery();
			while(rs.next()) {
				board = new BoardVO();
				board.setSeq(rs.getInt(1));
				board.setTitle(rs.getString(2));
				board.setWriter(rs.getString(3));
				board.setContent(rs.getString(4));
				board.setRegDate(rs.getDate(5));
				board.setCnt(rs.getInt(6));
				list.add(board);
			}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				JDBCUtil.close(conn, stmt, rs);
			}
		return list;
	}
	public void addCnt(BoardVO vo) {
		System.out.println("==> JDBC로 addCnt() : "+ ADD_CNT);
		try{
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(ADD_CNT);
			stmt.setInt(1, vo.getSeq());
			stmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				JDBCUtil.close(conn, stmt);
			}
	}
}
