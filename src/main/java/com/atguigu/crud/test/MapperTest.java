package com.atguigu.crud.test;

import java.util.Random;
import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.atguigu.crud.bean.Department;
import com.atguigu.crud.bean.Employee;
import com.atguigu.crud.dao.DepartmentMapper;
import com.atguigu.crud.dao.EmployeeMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class MapperTest {
	
	@Autowired
	DepartmentMapper departmentMapper;
	
	@Autowired
	SqlSession sqlSession;
	
	
	@Test
	public void test() throws Exception {
//		System.out.println(departmentMapper);
//		departmentMapper.insertSelective(new Department(null,"业务部"));
		
//		System.out.println(sqlSession);
//		
		EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
		for(int i = 0;i < 1000;i++) {
			String uuid = UUID.randomUUID().toString().substring(0, 5)+i;
			mapper.insertSelective(new Employee(null, uuid, "M", uuid+"@lx.com", new Random().nextInt(2)+1));
		}
		System.out.println("批量操作成功");
		
	}
	
	
	
	// 濞村鐦疍epartmentMapper閻ㄥ嫭鏌熷▔锟�
	@Test
	public void test1() {
		//娴肩姷绮哄ù瀣槸閺傝纭�
		//1.閸掓稑缂揑OC鐎圭懓娅� 濮濄倕顔愰崳銊︽箒閸栧懎鎯坢apper閹恒儱褰涢惃鍒an
		ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
		//2.閼惧嘲褰噈apper閹恒儱褰涚仦鐐达拷锟�
		DepartmentMapper deptBean = ioc.getBean(DepartmentMapper.class);
//		System.out.println(deptBean);
		
//		deptBean.insertSelective(new Department(null, "瀵拷閸欐垿鍎�"));
//		deptBean.insertSelective(new Department(null, "濞村鐦柈锟�"));
		
		EmployeeMapper empBean = ioc.getBean(EmployeeMapper.class);
		System.out.println(empBean);
//		empBean.insertSelective(new Employee(null,"Yang","M","Yang@lx.com",1));
		
		//娴ｈ法鏁qlsesseion 閹笛嗩攽閹靛綊鍣洪幙宥勭稊 閸欘垰鐨qlsession濞ｈ濮為懛鍐差啇閸ｃ劋鑵�
//		SqlSession sqlsession = ioc.getBean(SqlSession.class);
//		System.out.println(sqlsession);
		//spring閻ㄥ嫭绁寸拠鏇熸煙濞夛拷
		for(int i = 0;i<1000;i++) {
			String uid = UUID.randomUUID().toString().substring(0, 5) + i;
			empBean.insertSelective(new Employee(null,uid,"M",uid+"Yang@lx.com",new Random().nextInt(2)+1));
		}
		
	}

}
