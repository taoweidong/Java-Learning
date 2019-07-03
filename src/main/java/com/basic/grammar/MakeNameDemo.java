package com.basic.grammar;

/*
	标识符：就是给类，接口，方法，变量等起名字。
	
	组成规则：
		A:英文字母大小写
		B:数字字符
		C:$和_
		
	注意事项：
		A:不能以数字开头
		B:不能是Java中的关键字
		C:Java语言严格区分大小写
		
	常见的命名规则：见名知意
		举例：我要定义一个学生类
			class Student {}
			class S{}
			
		包：其实就是文件夹，用于把相同的类名进行区分
			全部小写
		
			单级：liuyi
			多级：cn.itcast
				cn
					itcast
					
		类或者接口：
			一个单词：单词的首字母必须大写
				举例：Student,Dog
			多个单词：每个单词的首字母必须大写
				举例：HelloWorld,StudentName
			
		方法或者变量：
			一个单词：单词的首字母小写
				举例：main,age
			多个单词：从第二个单词开始，每个单词的首字母大写
				举例：studentAge,showAllNames()
				
		常量：
			一个单词：全部大写
				举例：PI
			多个单词：每个字母都大写，用_隔开
				举例：STUDENT_MAX_AGE
		
*/
class MakeNameDemo {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		//正确做法
		int x = 100;
		
		//不能以数字开头
		//int 1y = 100;
		int y1 = 100;
		
		//不能是Java中的关键字
		//int public = 100;
		int Public = 100;
	}
}