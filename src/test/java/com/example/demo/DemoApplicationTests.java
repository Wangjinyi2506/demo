package com.example.demo;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private UserMapper userMapper;

	@Test
	public void findAll() {
		List<User> users = userMapper.selectList(null);
		System.out.println(users);
	}

	@Test
	public void testAdd() {
		User user = new User();
		user.setName("李四889");
		user.setAge(20);
		user.setEmail("1243@qq.com");
		int insert = userMapper.insert(user);
		//userMapper的返回值就是项目表里成功加了几条记录
		System.out.println(insert);
	}

	@Test
	public void testSelect1() {
		List<User> users = userMapper.selectBatchIds(Arrays.asList(1, 2, 3));
		System.out.println(users);
	}


	//测试乐观锁
	@Test
	public void TestOptimisticLocker(){
		User user = userMapper.selectById(1380136752399822849L);
		user.setName("张三99983");
		userMapper.updateById(user);

	}

}
