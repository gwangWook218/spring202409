package com.akw.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.akw.dto.CustDTO;

@Repository
@Mapper
public interface CustRepository {

	@Select("SELECT \r\n"
			+ "	p_no, \r\n"
			+ "	p_name, \r\n"
			+ "	DATE_FORMAT(p_birth, '%Y년 %m월 %d일') AS p_birth,\r\n"
			+ "	CONCAT(p_tel1,'-',p_tel2,'-',p_tel3) AS p_tel, \r\n"
			+ "	CASE\r\n"
			+ "		when p_city = '10'then '서울'\r\n"
			+ "		when p_city = '20'then '경기'\r\n"
			+ "		when p_city = '30'then '부산'\r\n"
			+ "		when p_city = '40'then '대구'\r\n"
			+ "		else '기타'\r\n"
			+ "	END p_city,\r\n"
			+ "	CASE\r\n"
			+ "		when p_gender = 'M'then '남'\r\n"
			+ "		when p_gender = 'F'then '여'\r\n"
			+ "		else '기타'\r\n"
			+ "	END p_gender\r\n"
			+ "FROM custtbl")
	public List<CustDTO> findAll();
	
	@Insert("""
			<script>
			insert into custtbl
			set p_no=#{p_no}, p_name=#{p_name}, p_birth=#{p_birth}, p_tel1=#{p_tel1}, p_tel2=#{p_tel2}, p_tel3=#{p_tel3}, p_city=#{p_city}, p_gender=#{p_gender}
			</script>
			""")
	public int save(CustDTO dto);
	
	@Select("select * from custtbl where p_no=#{p_no}")
	public CustDTO findById(String p_no);
	
	@Update("""
			<script>
			update custtbl
			set p_no=#{p_no}, p_name=#{p_name}, p_birth=#{p_birth}, p_tel1=#{p_tel1}, p_tel2=#{p_tel2}, p_tel3=#{p_tel3}, p_city=#{p_city}, p_gender=#{p_gender}
			where p_no=#{p_no}
			</script>
			""")
	public int update(CustDTO dto);
	
	@Delete("delete from custtbl where p_no=#{p_no}")
	public int deleteById(String p_no);
}
