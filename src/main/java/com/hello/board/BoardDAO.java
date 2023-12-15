package com.hello.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class BoardDAO {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<BoardVO> getBoardList(){
        String sql = "select * from BOARD order by seq desc";
        List<BoardVO> list = jdbcTemplate.query(sql, new RowMapper<BoardVO>() {
            @Override
            public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
                BoardVO vo = new BoardVO();
                vo.setSeq(rs.getInt("seq"));
                vo.setTitle(rs.getString("title"));
                vo.setWriter(rs.getString("writer"));
                vo.setCategory(rs.getString("category"));
                vo.setContent(rs.getString("content"));
                vo.setRegdate(rs.getDate("regdate"));
                vo.setModdate(rs.getDate("moddate"));
                return vo;
            }
        });
        return list;
    }
    private final String BOARD_INSERT = "insert into BOARD (title, writer, content) value (?,?,?)";
    private final String BOARD_UPDATE = "update BOARD set title=?, writer=?, content=? where seq=?";
    private final String BOARD_DELETE = "delete from BOARD where seq=?";
    public int insertBoard(BoardVO vo) {
        String sql = "insert into BOARD (title,writer,content,category) values("
                + "'" + vo.getTitle() + "',"
                + "'" + vo.getWriter() + "',"
                + "'" + vo.getContent() + "',"
                + "'" + vo.getCategory() + "')";
        return jdbcTemplate.update(sql);
    }
    public int deleteBoard(int seq) {
        String sql = "delete from BOARD where seq = " + seq;
        return jdbcTemplate.update(sql);
    }
    public int updateBoard(BoardVO vo) {
        return jdbcTemplate.update(BOARD_UPDATE,
                new Object[]{vo.getTitle(),vo.getWriter(),vo.getContent(),vo.getSeq()});
    }
//    public BoardVO getBoard(int seq){
//        String sql = "select * from BOARD where seq=" + seq;
//        return jdbcTemplate.queryForObject(sql, new BoardDAO());
//    }

}
