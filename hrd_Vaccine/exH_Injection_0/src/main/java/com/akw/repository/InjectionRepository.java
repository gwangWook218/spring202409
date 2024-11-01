package com.akw.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.akw.dto.InjectionDTO;

@Repository
@Mapper
public interface InjectionRepository {

	@Select("SELECT i.i_code AS i_code, i_name, COUNT(*) AS i_cnt\r\n"
			+ "FROM ordertbl o, injectiontbl i\r\n"
			+ "WHERE o.i_code = i.i_code\r\n"
			+ "GROUP BY i.i_code, i.i_name\r\n"
			+ "ORDER BY i.i_code;")
	public List<InjectionDTO> findAll();
	
	@Insert("""
			<script>
			insert into injectiontbl
			set i_code=#{i_code}, i_name=#{i_name}, i_age=#{i_age}
			</script>
			""")
	public int save(InjectionDTO dto);
	
	@Select("select * from injectiontbl where i_code=#{i_code}")
	public InjectionDTO findById(String i_code);
	
	@Update("""
			<script>
			update injectiontbl
			set i_code=#{i_code}, i_name=#{i_name}, i_age=#{i_age}
			where i_code=#{i_code}
			</script>
			""")
	public int update(InjectionDTO dto);
	
	@Delete("delete from injectiontbl where i_code=#{i_code}")
	public int deleteById(String i_code);
}
