package com.learning.gupo.design_pattern.prototype.greatestsage;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

//齐天大圣
public class TheGreatestSage extends Monkey implements Cloneable,Serializable{

	private GoldRingedStaff staff;
	
	public TheGreatestSage() {
		this.staff = new GoldRingedStaff();
		this.birthday = new Date();
		this.height = 150;
		this.weight = 30;
	}
	
	/**
	 * 克隆不走构造方法，直接使用字节码复制来实现
	 */
	@Override
	protected Object clone() throws CloneNotSupportedException {

		//简单拷贝，只能拷贝简单类型和String类型
		/*try {
			return super.clone();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}*/
		
		
		try {
			// 对于序列化和反序列化，最终通过反射来生成新对象的
			//序列化
			ByteArrayOutputStream bao = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(bao);
			oos.writeObject(this);
			
			//反序列化
			ByteArrayInputStream bis = new ByteArrayInputStream(bao.toByteArray());
			ObjectInputStream ois = new ObjectInputStream(bis);
			TheGreatestSage copy = (TheGreatestSage)ois.readObject();
			
			copy.setBirthday(new Date());
			
			return copy;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
		
		
	}

	/**
	  深度拷贝
	     大圣本尊的生日是:1539180708155
		克隆体的生日是：1539180708206
		大圣和克隆体是否是一个对象false
		大圣的金箍棒是：com.learning.gupo.design_pattern.prototype.greatestsage.
					GoldRingedStaff@75b84c92
		克隆体的金箍棒是：com.learning.gupo.design_pattern.prototype.greatestsage.
					GoldRingedStaff@214c265e
	 */
	//变化
	public void change() {
		try {
			TheGreatestSage copy = (TheGreatestSage)clone();
			System.out.println("大圣本尊的生日是:"+this.getBirthday().getTime());
			System.out.println("克隆体的生日是："+copy.getBirthday().getTime());
			System.out.println("大圣和克隆体是否是一个对象"+(this==copy));
			System.out.println("大圣的金箍棒是："+this.getStaff());
			System.out.println("克隆体的金箍棒是："+copy.getStaff());
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public GoldRingedStaff getStaff() {
		return staff;
	}

	public void setStaff(GoldRingedStaff staff) {
		this.staff = staff;
	}
}
