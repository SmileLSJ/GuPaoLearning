package com.learning.gupo.proxy.custom;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


//将字节码文件加载到JVM中
public class FClassLoader extends ClassLoader{

	private File baseDir;
	
	public FClassLoader(){
		String basePath = FClassLoader.class.getResource("").getPath();
		//代表class文件保存的文件夹
		this.baseDir = new File(basePath);
	}
	
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		//获取文件
		String className = FClassLoader.class.getPackage().getName()+"."+name;
		
		String basePath = FClassLoader.class.getResource("").getPath();
		
		FileInputStream fis=null;
		ByteArrayOutputStream out=null;
		
		System.out.println("baseDir is Directory:"+baseDir.isDirectory());
		System.out.println("baseDir is File:"+baseDir.isFile());
		
		if(baseDir!=null){
			
			//new File("parent","child")表示在parent文件夹在的child，此时的child可以是文件夹，也可以是文件，
			//如果是文件夹的话表示父文件夹下的子文件夹
			File classFile = new File(baseDir,name.replace("\\.", "/")+".class");
			
			System.out.println(" classFile is Directory:"+classFile.isDirectory());
			System.out.println(" classFile is File:"+classFile.isFile());
			
			try {
				fis = new FileInputStream(classFile);
				out = new ByteArrayOutputStream();
				
				byte[] buff = new byte[1024];
				int len;
				while((len=fis.read(buff))!=-1){
					out.write(buff,0,len);
				}
				
				//生产字节码文件
				return defineClass(className, out.toByteArray(), 0, out.size());
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				if(null != fis){
					try {
						fis.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if(null != out){
					try {
						out.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
		
		return null;
	}
}
