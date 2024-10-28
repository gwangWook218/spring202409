package com.akw.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.akw.dto.ArtistDTO;
import com.akw.dto.PointDTO;

@Repository
@Mapper
public interface ArtistRepository {

	// --참가자 참가 등록 ---------------------------

	// insert 어노테이션 사용법1
	@Insert("INSERT INTO artistTBL  \r\n" + "VALUES "
			+ "(#{artist_id},#{artist_name},#{artist_birth},#{artist_gender},#{talent},#{agency})")
	@Options(useGeneratedKeys = true, keyProperty = "artist_id")
	public int insertOne(ArtistDTO artistDTO);

	// -- 참가자 목록 조회 기본 ---------------------------
	@Select("SELECT * from artistTBL")
	public List<ArtistDTO> selectAll_basic();

	// -- 참가자 목록 조회
	@Select("SELECT \r\n" + "	artist_id, \r\n" + "	artist_name,  \r\n"
			+ "	DATE_FORMAT(artist_birth, '%Y년 %m월 %d일') AS artist_birth,\r\n" + "	case\r\n"
			+ "		when artist_gender='F' then '남성'\r\n" + "		when artist_gender='M' then '여성'\r\n"
			+ "		ELSE '기타'\r\n" + "	end AS artist_gender,\r\n" + "	case\r\n"
			+ "		when talent='1' then '보컬'\r\n" + "		when talent='2' then '댄스'\r\n"
			+ "		when talent='3' then '랩'\r\n" + "		ELSE '기타'\r\n" + "	end AS talent,\r\n" + "	agency\r\n"
			+ "FROM artistTBL\r\n" + "ORDER BY artist_id")
	public List<ArtistDTO> selectAll();

	// -- 참가자 목록 조회 한명
	@Select("SELECT * FROM artisttbl WHERE artist_id = #{artist_id}")
	public ArtistDTO selectOne(String artist_id);

	// -- 참가자 정보 수정 ---------------------------
	@Update("""
			<script>
			UPDATE artisttbl
			SET artist_name=#{artist_name}, artist_birth=#{artist_birth},
				artist_gender=#{artist_gender}, talent=#{talent},
				agency=#{agency}
			WHERE artist_id=#{artist_id}
			</script>
			""")
	public void update(ArtistDTO artistDTO);

	// -- 참가자 정보 삭제 ---------------------------
	@Delete("DELETE FROM artisttbl WHERE artist_id=#{artist_id}")
	public void delete(String artist_id);

	// -- 멘토 점수 조회 ---------------------------
	@Select("SELECT \r\n" + "	a.artist_id AS artist_id,\r\n" + "	a.artist_name AS artist_name, \r\n"
			+ "	DATE_FORMAT(a.artist_birth, '%Y년 %m월 %d일') AS artist_birth,\r\n" + "	p.point AS point, \r\n"
			+ "	CASE\r\n" + "		when point > 89 then 'A'\r\n" + "		when point between 80 and 89 then 'B'\r\n"
			+ "		when point between 70 and 79 then 'C'\r\n" + "		when point between 60 and 69 then 'D'\r\n"
			+ "		when point BETWEEN 50 AND 69 then 'E'\r\n" + "		else 'F'\r\n" + "	END grade, \r\n"
			+ "	m.mento_name \r\n" + "FROM pointTBL p\r\n"
			+ "	LEFT OUTER JOIN artistTBL a ON p.artist_id = a.artist_id\r\n"
			+ "	LEFT OUTER JOIN mentoTBL m ON p.mento_id = m.mento_id\r\n" + "ORDER BY serial_no")
	public List<PointDTO> selectMentoPoint();

	// -- 참가자 등수 조회 ---------------------------
	@Select("SELECT \r\n" + "	p.artist_id AS artist_id,\r\n" + "	a.artist_name AS artist_name,\r\n"
			+ "	sum(p.point) AS sum_point,\r\n" + "	ROUND(AVG(p.point), 2) as avg_point,\r\n"
			+ "	RANK() OVER(ORDER BY SUM(p.point) desc) AS rank\r\n" + "FROM pointTBL p\r\n"
			+ "	LEFT OUTER JOIN artistTBL a ON p.artist_id = a.artist_id\r\n" + "GROUP BY \r\n"
			+ "	artist_id, artist_name\r\n" + "ORDER BY \r\n" + "	AVG(p.point) DESC")
	public List<PointDTO> selectRank();
}
