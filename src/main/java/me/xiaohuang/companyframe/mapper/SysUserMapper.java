package me.xiaohuang.companyframe.mapper;

import me.xiaohuang.companyframe.entity.SysUser;
import me.xiaohuang.companyframe.vo.req.UserPageReqVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysUserMapper {
    int deleteByPrimaryKey(String id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);

    SysUser getUserInfoByName(String userName);

    List<SysUser> selectAll(UserPageReqVO vo);
}