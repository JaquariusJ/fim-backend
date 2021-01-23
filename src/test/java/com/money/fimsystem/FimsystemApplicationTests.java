package com.money.fimsystem;

//import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
//import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
//import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
//import com.baomidou.mybatisplus.core.metadata.IPage;
//import com.baomidou.mybatisplus.core.toolkit.Wrappers;
//import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
//import com.baomidou.mybatisplus.extension.service.additional.update.impl.LambdaUpdateChainWrapper;
//import com.money.fimsystem.common.entity.User;
//import com.money.fimsystem.business.mapper.UserMapper;
//import org.assertj.core.util.Maps;
//import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@SpringBootTest
@RunWith(SpringRunner.class)
public class FimsystemApplicationTests {
//	@Autowired
//	private UserMapper userMapper;
//
//	@Test
//	public void select() {
//		List<User> users = userMapper.selectList(null);
//		System.out.println(users);
//	}
//
//	@Test
//	public void insert() {
//		User user = new User();
//		user.setUsername("test2");
//		user.setPassword("2222222");
//		user.setIphone(1235646545646l);
//		user.setRemark("hello world");
//		int insert = userMapper.insert(user);
//		System.out.println("影响条数:" + insert);
//	}
//
//	@Test
//	public void selectbyid() {
//		User user = userMapper.selectById("3");
//		System.out.println(user);
//	}
//
//	@Test
//	public void selectbyids() {
//		List<Integer> ids = Arrays.asList(4, 7);
//		List<User> users = userMapper.selectBatchIds(ids);
//		users.forEach(n -> System.out.println(n));
//	}
//
//	@Test
//	public void selectMap() {
//		Map<String, Object> maps = Maps.newHashMap("username", "xiaojian");
//		maps.put("password", "2222222");
//		List<User> users = userMapper.selectByMap(maps);
//		users.forEach(n -> System.out.println(n));
//
//	}
//
//	@Test
//	public void selectTest() {
//		QueryWrapper<User> query = Wrappers.query();
//		QueryWrapper<User> queryWrapper =
//				query.likeRight("username", "xiao").or().
//						eq("username", "wujian").orderByDesc("userid");
//		List<User> users = userMapper.selectList(queryWrapper);
//		users.forEach(n -> System.out.println(n));
//	}
//
//	//	insql  子查询，apply，可以用于复杂的条件表达式，{0}为变量
//	@Test
//	public void selectTest2() {
//		QueryWrapper<User> query = Wrappers.query();
//		QueryWrapper<User> queryWrapper =
//				query.apply("date_format(create_time,'%Y-%m-%d')={0}", "2020-08-17").
//						inSql("username", "select username from sys_user where userid < 5");
//		List<User> users = userMapper.selectList(queryWrapper);
//		users.forEach(n -> System.out.println(n));
//	}
//
//	@Test
//	public void selectTest3() {
//		QueryWrapper<User> query = Wrappers.query();
//		//不查询password列
//		QueryWrapper<User> queryWrapper =
//				query.select(User.class, pre -> !pre.getColumn().equals("password"));
//		//只查询username，userid列
////		QueryWrapper<User> queryWrapper =
////				query.select("userid","username");
//		List<User> users = userMapper.selectList(queryWrapper);
//		users.forEach(n -> System.out.println(n));
//	}
//
//	@Test
//	public void selectTest4() {
//		LambdaQueryWrapper<User> lambdaQuaery = Wrappers.lambdaQuery();
//		lambdaQuaery.lt(User::getUserid, "1297893029910396929");
//		List<User> users = userMapper.selectAll(lambdaQuaery);
//		users.forEach(n -> System.out.println(n));
//	}
//
//	@Test
//	public void selectTest5() {
//		LambdaQueryWrapper<User> lambdaQuaery = Wrappers.lambdaQuery();
//		Page<User> page = new Page(1, 2);
//		IPage<User> iPage = userMapper.selectMyPage(page, lambdaQuaery);
//		System.out.println("总记录:" + iPage.getTotal());
//		System.out.println("总条数：" + iPage.getSize());
//		List<User> users = iPage.getRecords();
//		users.forEach(n -> System.out.println(n));
//	}
//
//	@Test
//	public void update1() {
//		User user = new User();
//		user.setIphone(154235588434564l);
//		int i = userMapper.updateById(user);
//		System.out.println("影响条数:" + i);
//	}
//
//	//lambdaUpdate为条件构造器，会出现在where条件中，user会出现在set中
//	@Test
//	public void update2() {
//		LambdaUpdateWrapper<User> updateWrapper = Wrappers.lambdaUpdate();
//		updateWrapper.eq(User::getUserid, "1297893029910396929");
//		User user = new User();
//		user.setUsername("李四");
//		int i = userMapper.update(user, updateWrapper);
//		System.out.println("影响条数:" + i);
//	}
//
//
//	//lambdaUpdate为条件构造器，会出现在where条件中，user会出现在set中
//	@Test
//	public void update3() {
//		User whereuser = new User();
//		whereuser.setUsername("xiaojian");
//		LambdaUpdateWrapper<User> updateWrapper = Wrappers.<User>lambdaUpdate(whereuser);
//		updateWrapper.eq(User::getUsername, "xiaojian");
//		User user = new User();
//		user.setUsername("李四");
//		int i = userMapper.update(user, updateWrapper);
//		System.out.println("影响条数:" + i);
//	}
//
//	@Test
//	public void update4() {
//		LambdaUpdateWrapper<User> updateWrapper = Wrappers.lambdaUpdate();
//		updateWrapper.eq(User::getUserid, "4").set(User::getUsername, "王五");
//		int i = userMapper.update(null, updateWrapper);
//		System.out.println("影响条数:" + i);
//	}
//
//	@Test
//	public void update5() {
//		new LambdaUpdateChainWrapper<User>(userMapper)
//				.eq(User::getUserid, "5").set(User::getUsername, "赵六").update();
//	}
//
//	@Test
//	public void delete1() {
//		int i = userMapper.deleteById("9");
//		System.out.println(i);
//	}
//
//	@Test
//	public void delete2() {
//		Map<String, Object> deletemap = Maps.newHashMap("userid", "8");
//		int i = userMapper.deleteByMap(deletemap);
//		System.out.println(i);
//	}
//
//	@Test
//	public void delete3() {
//		int i = userMapper.deleteBatchIds(Arrays.asList("6", "7"));
//		System.out.println(i);
//	}
//
//	@Test
//	public void delete4() {
//		LambdaQueryWrapper<User> queryWrapper = Wrappers.lambdaQuery();
//		queryWrapper.eq(User::getUserid, "5").eq(User::getUsername, "赵六");
//		int i = userMapper.delete(queryWrapper);
//		System.out.println(i);
//	}
//
//	@Test
//	public void ar1() {
//		User user = new User();
//		user.setUsername("大胖");
//		user.setIphone(3212313l);
//		user.insertOrUpdate();
//		//user.insertOrUpdate();
//
//	}
//
//	@Test
//	public void ar2() {
//		User user = new User();
//		User newuser = user.selectById();
//		System.out.println(user == newuser);
//
//	}
//
//	@Test
//	public void ar3() {
//		User user = new User();
//		user.setUserid(1296472702802149377l);
//		user.setPassword("helloworld");
//		boolean b = user.updateById();
//		System.out.println(b);
//
//	}
//
//	@Test
//	public void ar4() {
//		User user = new User();
//		user.setUserid(1296466697925976066l);
//		boolean b = user.deleteById();
//		System.out.println(b);
//	}
//
//	@Test
//	public void u1() {
//		User user = userMapper.selectById("1297893029910396929");
//		user.setUsername("张三");
//		System.out.println(user);
//		userMapper.updateById(user);
//	}
//
//	@Test
//	public void s1() {
//		User user = userMapper.selectById("1297893029910396929");
//	}

}