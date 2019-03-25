package com.xue.oa.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xue.oas.domain.Privilege;

public class PrivilegeTest extends SpringUtils{
	/**
	 * 插入两个类型的数据
	 *   1、菜单类型的数据
	 *   2、功能类型的数据
	 */
	@Test
	public void testSavePrivilege_Menuitem(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
		SessionFactory sessionFactory = (SessionFactory)applicationContext.getBean("sessionFactory");
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
/***********************************************************************************/
		/*
		 * 个人办公
		 */
		Privilege Privilegeitem1 = new Privilege();
		Privilegeitem1.setId(1L);
		Privilegeitem1.setIcon("css/images/MenuIcon/FUNC20082.gif");
		Privilegeitem1.setName("办公自动化");
		Privilegeitem1.setPid(0L);
		Privilegeitem1.setType("1");
		Privilegeitem1.setIsParent(true);
		
		Privilege Privilege2 = new Privilege();
		Privilege2.setId(2L);
		Privilege2.setIcon("css/images/MenuIcon/FUNC20001.gif");
		Privilege2.setName("个人办公");
		//Privilege2.setChecked(false);
		Privilege2.setPid(1L);
		Privilege2.setType("1");
		Privilege2.setIsParent(true);
		
		Privilege Privilege21 = new Privilege();
		Privilege21.setId(21L);
		Privilege21.setIcon("css/images/MenuIcon/FUNC20054.gif");
		Privilege21.setName("个人考勤");
		//Privilege21.setChecked(false);
		Privilege21.setPid(2L);
		Privilege21.setType("1");
		Privilege21.setIsParent(false);
		
		
		Privilege Privilege22 = new Privilege();
		Privilege22.setId(22L);
		Privilege22.setIcon("css/images/MenuIcon/FUNC23700.gif");
		Privilege22.setName("日程安排");
		//Privilege22.setChecked(false);
		Privilege22.setPid(2L);
		Privilege22.setType("1");
		Privilege22.setIsParent(false);
		
		Privilege Privilege23 = new Privilege();
		Privilege23.setId(23L);
		Privilege23.setIcon("css/images/MenuIcon/FUNC20069.gif");
		Privilege23.setName("工作计划");
		//Privilege23.setChecked(false);
		Privilege23.setPid(2L);
		Privilege23.setType("1");
		Privilege23.setIsParent(false);
		
		Privilege Privilege24 = new Privilege();
		Privilege24.setId(24L);
		Privilege24.setIcon("css/images/MenuIcon/FUNC20056.gif");
		Privilege24.setName("工作日记");
		//Privilege24.setChecked(false);
		Privilege24.setPid(2L);
		Privilege24.setType("1");
		Privilege24.setIsParent(false);
		
		Privilege Privilege25 = new Privilege();
		Privilege25.setId(25L);
		Privilege25.setIcon("css/images/MenuIcon/time_date.gif");
		Privilege25.setName("通讯录");
		//Privilege25.setChecked(false);
		Privilege25.setPid(2L);
		Privilege25.setType("1");
		Privilege25.setIsParent(false);
/*********************************************************************************/	
		/*
		 * 审批流转
		 */
		Privilege Privilege3 = new Privilege();
		Privilege3.setId(3L);
		///Privilege3.setChecked(false);
		Privilege3.setIsParent(true);
		Privilege3.setPid(1L);
		Privilege3.setName("审批流转");
		Privilege3.setType("1");
		Privilege3.setIcon("css/images/MenuIcon/FUNC20057.gif");
		
		Privilege Privilege31 = new Privilege();
		Privilege31.setId(31L);
		//Privilege31.setChecked(false);
		Privilege31.setIsParent(false);
		Privilege31.setPid(3L);
		Privilege31.setName("审批流程管理");
		Privilege31.setIcon("css/images/MenuIcon/manager.gif");
		
		Privilege Privilege32 = new Privilege();
		Privilege32.setId(32L);
		//Privilege32.setChecked(false);
		Privilege32.setIsParent(false);
		Privilege32.setPid(3L);
		Privilege32.setName("表单模板管理");
		Privilege32.setIcon("css/images/MenuIcon/formmodel.gif");
		
		Privilege Privilege33 = new Privilege();
		Privilege33.setId(33L);
		Privilege33.setIsParent(false);
		//Privilege33.setChecked(false);
		Privilege33.setPid(3L);
		Privilege33.setName("发起申请");
		Privilege33.setIcon("css/images/MenuIcon/FUNC241000.gif");
		
		Privilege Privilege34 = new Privilege();
		Privilege34.setId(34L);
		Privilege34.setIsParent(false);
		//Privilege34.setChecked(false);
		Privilege34.setPid(3L);
		Privilege34.setName("审批申请");
		Privilege34.setIcon("css/images/MenuIcon/FUNC20029.gif");
		
		Privilege Privilege35 = new Privilege();
		Privilege35.setId(35L);
		Privilege35.setIsParent(false);
		//Privilege35.setChecked(false);
		Privilege35.setPid(3L);
		Privilege35.setName("状态查询");
		Privilege35.setIcon("css/images/MenuIcon/FUNC20029.gif");
/************************************************************************************/
		/*
		 * 知识管理
		 */
		Privilege Privilege4 = new Privilege();
		Privilege4.setId(4L);
		Privilege4.setIsParent(false);
		//Privilege4.setChecked(false);
		Privilege4.setPid(1L);
		Privilege4.setName("知识管理");
		Privilege4.setIcon("css/images/MenuIcon/FUNC20056.gif");
/*******************************************************************************/
		/*
		 * 综合行政
		 */
		Privilege Privilege5 = new Privilege();
		Privilege5.setId(5L);
		Privilege5.setIsParent(true);
		//Privilege5.setChecked(false);
		Privilege5.setPid(1L);
		Privilege5.setName("管理行政");
		Privilege5.setIcon("css/images/MenuIcon/manager.gif");
		
		Privilege Privilege51 = new Privilege();
		Privilege51.setId(51L);
		Privilege51.setIsParent(false);
		//Privilege51.setChecked(false);
		Privilege51.setPid(5L);
		Privilege51.setName("考勤管理");
		Privilege51.setIcon("css/images/MenuIcon/FUNC20070.gif");
		
		Privilege Privilege52 = new Privilege();
		Privilege52.setId(52L);
		Privilege52.setIsParent(false);
		//Privilege52.setChecked(false);
		Privilege52.setPid(5L);
		Privilege52.setName("会议管理");
		Privilege52.setIcon("css/images/MenuIcon/FUNC20064.gif");
		
		Privilege Privilege53 = new Privilege();
		Privilege53.setId(53L);
		Privilege53.setIsParent(false);
		//Privilege53.setChecked(false);
		Privilege53.setPid(5L);
		Privilege53.setName("车辆管理");
		Privilege53.setIcon("css/images/MenuIcon/radio_blue.gif");
/**************************************************************************************/
		/*
		 * 人力资源管理
		 * 	档案管理
		 * 	培训记录
		 * 	奖金记录
		 * 	职位变更
		 * 	人事合同
		 * 	薪酬制度
		 */
		Privilege Privilege6 = new Privilege();
		Privilege6.setId(6L);
		Privilege6.setIsParent(true);
		//Privilege6.setChecked(false);
		Privilege6.setPid(1L);
		Privilege6.setName("人力资源");
		Privilege6.setIcon("css/images/MenuIcon/FUNC20001.gif");
		
		Privilege Privilege61 = new Privilege();
		Privilege61.setId(61L);
		Privilege61.setIsParent(false);
		//Privilege61.setChecked(false);
		Privilege61.setPid(6L);
		Privilege61.setName("档案管理");
		Privilege61.setIcon("css/images/MenuIcon/FUNC20076.gif");
		
		Privilege Privilege62 = new Privilege();
		Privilege62.setId(62L);
		Privilege62.setIsParent(false);
		//Privilege62.setChecked(false);
		Privilege62.setPid(6L);
		Privilege62.setName("培训记录");
		Privilege62.setIcon("css/images/MenuIcon/FUNC55000.gif");
		
		Privilege Privilege63 = new Privilege();
		Privilege63.setId(63L);
		Privilege63.setIsParent(false);
		//Privilege63.setChecked(false);
		Privilege63.setPid(6L);
		Privilege63.setName("奖赏记录");
		Privilege63.setIcon("css/images/MenuIcon/FUNC55000.gif");
		
		Privilege Privilege64 = new Privilege();
		Privilege64.setId(64L);
		Privilege64.setIsParent(false);
		//Privilege64.setChecked(false);
		Privilege64.setPid(6L);
		Privilege64.setName("职位变更");
		Privilege64.setIcon("css/images/MenuIcon/FUNC55000.gif");
		
		Privilege Privilege65 = new Privilege();
		Privilege65.setId(65L);
		Privilege65.setIsParent(false);
		//Privilege65.setChecked(false);
		Privilege65.setPid(6L);
		Privilege65.setName("人事合同");
		Privilege65.setIcon("css/images/MenuIcon/FUNC55000.gif");
		
		Privilege Privilege66 = new Privilege();
		Privilege66.setId(66L);
		Privilege66.setIsParent(false);
		//Privilege66.setChecked(false);
		Privilege66.setPid(6L);
		Privilege66.setName("薪酬制度");
		Privilege66.setIcon("css/images/MenuIcon/FUNC20001.gif");
/*****************************************************************************************/
		/*
		 * 电子邮件
		 */
		Privilege Privilege7 = new Privilege();
		Privilege7.setId(7L);
		Privilege7.setIsParent(false);
		//Privilege7.setChecked(false);
		Privilege7.setPid(1L);
		Privilege7.setName("电子邮件");
		Privilege7.setIcon("css/images/MenuIcon/eml.gif");

/*******************************************************************/
		/*
		 * 实用工具
		 * 	车票预定
		 * 	GIS查询
		 * 	邮政编码
		 */
		Privilege Privilege8 = new Privilege();
		Privilege8.setId(8L);
		Privilege8.setIsParent(true);
		//Privilege8.setChecked(false);
		Privilege8.setPid(1L);
		Privilege8.setName("实用工具");
		Privilege8.setIcon("css/images/MenuIcon/FUNC20076.gif");
		Privilege Privilege81 = new Privilege();
		Privilege81.setId(81L);
		Privilege81.setIsParent(false);
		//Privilege81.setChecked(false);
		Privilege81.setPid(8L);
		Privilege81.setName("车票预定");
		Privilege81.setIcon("css/images/MenuIcon/FUNC220000.gif");
		Privilege Privilege82 = new Privilege();
		Privilege82.setId(82L);
		Privilege82.setIsParent(false);
		//Privilege82.setChecked(false);
		Privilege82.setPid(8L);
		Privilege82.setName("GIS查询");
		Privilege82.setIcon("css/images/MenuIcon/search.gif");
		Privilege Privilege83 = new Privilege();
		Privilege83.setId(83L);
		Privilege83.setIsParent(false);
		//Privilege83.setChecked(false);
		Privilege83.setPid(8L);
		Privilege83.setName("邮政编码");
		Privilege83.setIcon("css/images/MenuIcon/FUNC249000.gif");
/**************************************************************************/
		/*
		 * 个人设置
		 * 		个人信息
		 * 		密码修改
		 */
		Privilege Privilege9 = new Privilege();
		Privilege9.setId(9L);
		Privilege9.setIsParent(true);
		//Privilege9.setChecked(false);
		Privilege9.setPid(1L);
		Privilege9.setName("个人设置");
		Privilege9.setIcon("css/images/MenuIcon/FUNC20001.gif");
		Privilege Privilege91 = new Privilege();
		Privilege91.setId(91L);
		Privilege91.setIsParent(false);
		//Privilege91.setChecked(false);
		Privilege91.setPid(9L);
		Privilege91.setName("个人信息");
		Privilege91.setIcon("css/images/MenuIcon/FUNC20001.gif");
		Privilege Privilege92 = new Privilege();
		Privilege92.setId(92L);
		Privilege92.setIsParent(false);
		//Privilege92.setChecked(false);
		Privilege92.setPid(9L);
		Privilege92.setName("密码修改");
		Privilege92.setIcon("css/images/MenuIcon/FUNC241000.gif");
/***********************************************************************************/
		/*
		 * 系统管理
		 * 	岗位管理
		 * 	部门管理
		 * 	用户管理
		 */
		Privilege Privilege10 = new Privilege();
		Privilege10.setId(10L);
		Privilege10.setIsParent(true);
		//Privilege10.setChecked(false);
		Privilege10.setPid(1L);
		Privilege10.setName("系统管理");
		Privilege10.setIcon("css/images/MenuIcon/system.gif");
		Privilege Privilege101 = new Privilege();
		Privilege101.setId(101L);
		Privilege101.setIsParent(false);
		//Privilege101.setChecked(false);
		Privilege101.setPid(10L);
		Privilege101.setName("岗位管理");
		Privilege101.setIcon("css/images/MenuIcon/FUNC20001.gif");
		Privilege Privilege102 = new Privilege();
		Privilege102.setId(102L);
		Privilege102.setIsParent(false);
		//Privilege102.setChecked(false);
		Privilege102.setPid(10L);
		Privilege102.setName("部门管理");
		Privilege102.setIcon("css/images/MenuIcon/department.gif");
		Privilege Privilege103 = new Privilege();
		Privilege103.setId(103L);
		Privilege103.setIsParent(false);
		//Privilege103.setChecked(false);
		Privilege103.setPid(10L);
		Privilege103.setName("用户管理");
		Privilege103.setIcon("css/images/MenuIcon/FUNC20001.gif");
/**********************************************************************/
		/*
		 * {
		 * 	1,1
		 * 	2,5
		 * 	3,5
		 * 	4,1
		 * 	5,3
		 * 	6,6
		 * 	7,1
		 * 	8,3
		 * 	9,2
		 * 	10,3
		 * }
		 */
		
		session.save(Privilegeitem1);
		
		session.save(Privilege2);
		session.save(Privilege21);
		session.save(Privilege22);
		session.save(Privilege23);
		session.save(Privilege24);
		session.save(Privilege25);
		
		
		session.save(Privilege3);
		session.save(Privilege31);
		session.save(Privilege32);
		session.save(Privilege33);
		session.save(Privilege34);
		session.save(Privilege35);
		
		session.save(Privilege4);
		
		session.save(Privilege5);
		session.save(Privilege51);
		session.save(Privilege52);
		session.save(Privilege53);
		
		session.save(Privilege6);
		
		session.save(Privilege61);
		session.save(Privilege62);
		session.save(Privilege63);
		session.save(Privilege64);
		session.save(Privilege65);
		session.save(Privilege66);
		
		session.save(Privilege7);
		
		session.save(Privilege8);
		session.save(Privilege81);
		session.save(Privilege82);
		session.save(Privilege83);
		
		session.save(Privilege9);
		session.save(Privilege91);
		session.save(Privilege92);
		
		session.save(Privilege10);
		session.save(Privilege101);
		session.save(Privilege102);
		session.save(Privilege103);
		transaction.commit();
		session.close();
	}
	
	/**
	 * 保存功能
	 */
	@Test
	public void testSavePrivilege_Function(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
		SessionFactory sessionFactory = (SessionFactory)applicationContext.getBean("sessionFactory");
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Privilege Privilege1 = new Privilege();
		Privilege1.setId(201L);
		Privilege1.setType("2");
		Privilege1.setPid(0L);
		Privilege1.setIcon("css/images/MenuIcon/system.gif");
		Privilege1.setName("用户增加");
		
		
		Privilege Privilege2 = new Privilege();
		Privilege2.setId(202L);
		Privilege2.setType("2");
		Privilege2.setPid(0L);
		Privilege2.setIcon("css/images/MenuIcon/system.gif");
		Privilege2.setName("用户删除");
		
		Privilege Privilege3 = new Privilege();
		Privilege3.setId(203L);
		Privilege3.setType("2");
		Privilege3.setPid(0L);
		Privilege3.setIcon("css/images/MenuIcon/system.gif");
		Privilege3.setName("用户修改");
		
		Privilege Privilege32 = new Privilege();
		Privilege32.setId(210L);
		Privilege32.setType("2");
		Privilege32.setPid(0L);
		Privilege32.setIcon("css/images/MenuIcon/system.gif");
		Privilege32.setName("用户查询");
		
		Privilege Privilege4 = new Privilege();
		Privilege4.setId(204L);
		Privilege4.setType("2");
		Privilege4.setPid(0L);
		Privilege4.setIcon("css/images/MenuIcon/system.gif");
		Privilege4.setName("部门增加");
		
		
		Privilege Privilege5 = new Privilege();
		Privilege5.setId(205L);
		Privilege5.setType("2");
		Privilege5.setPid(0L);
		Privilege5.setIcon("css/images/MenuIcon/system.gif");
		Privilege5.setName("部门删除");
		
		Privilege Privilege6 = new Privilege();
		Privilege6.setId(206L);
		Privilege6.setType("2");
		Privilege6.setPid(0L);
		Privilege6.setIcon("css/images/MenuIcon/system.gif");
		Privilege6.setName("部门修改");
		
		Privilege Privilege66 = new Privilege();
		Privilege66.setId(211L);
		Privilege66.setType("2");
		Privilege66.setPid(0L);
		Privilege66.setIcon("css/images/MenuIcon/system.gif");
		Privilege66.setName("部门查询");
		
		Privilege Privilege7 = new Privilege();
		Privilege7.setId(207L);
		Privilege7.setType("2");
		Privilege7.setPid(0L);
		Privilege7.setIcon("css/images/MenuIcon/system.gif");
		Privilege7.setName("岗位增加");
		
		
		Privilege Privilege8 = new Privilege();
		Privilege8.setId(208L);
		Privilege8.setType("2");
		Privilege8.setPid(0L);
		Privilege8.setIcon("css/images/MenuIcon/system.gif");
		Privilege8.setName("岗位删除");
		
		Privilege Privilege9 = new Privilege();
		Privilege9.setId(209L);
		Privilege9.setType("2");
		Privilege9.setPid(0L);
		Privilege9.setIcon("css/images/MenuIcon/system.gif");
		Privilege9.setName("岗位修改");
		
		Privilege Privilege99 = new Privilege();
		Privilege99.setId(212L);
		Privilege99.setType("2");
		Privilege99.setPid(0L);
		Privilege99.setIcon("css/images/MenuIcon/system.gif");
		Privilege99.setName("岗位查询");
		
		session.save(Privilege1);
		session.save(Privilege2);
		session.save(Privilege3);
		session.save(Privilege32);
		session.save(Privilege66);
		session.save(Privilege99);
		session.save(Privilege4);
		session.save(Privilege5);
		
		session.save(Privilege6);
		session.save(Privilege7);
		session.save(Privilege8);
		session.save(Privilege9);
		
		transaction.commit();
		session.close();
	}
	
}
