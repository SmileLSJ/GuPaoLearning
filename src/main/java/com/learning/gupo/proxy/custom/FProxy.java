package com.learning.gupo.proxy.custom;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

import com.learning.gupo.custom.custom.GPPorxy;


//代理类
public class FProxy{
	
	private static String ln = "\r\n";
	
	public static Object newInstance(FClassLoader classLoader
			,Class<?>[] interfaces, FInvocationHandler h){
		try{
			//1、生成源代码
			String proxySrc = generateSrc(interfaces[0]);
			
			//2、将生成的源代码输出到磁盘，保存为.java文件
			String filePath = FProxy.class.getResource("").getPath();
			File f = new File(filePath + "$Proxy0.java");
			FileWriter fw = new FileWriter(f);
			fw.write(proxySrc);
			fw.flush();
			fw.close();
		
			//3. 编译源文件，生产class文件
			//3.1 获取java编译器
			JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
			//3.2获取到java文件控制器
			StandardJavaFileManager manager = compiler.getStandardFileManager(null, null, null);
			//3.3通过文件控制器，将需要编译的文件，转换为Iterable
			Iterable iterable = manager.getJavaFileObjects(f);
			
			//3.4添加到编译器任务重
			CompilationTask task = compiler.getTask(null, manager, null, null, null, iterable);
			//3.5执行编译
			task.call();
			manager.close();
		
			//4.将class文件中的内容，动态加载到JVM中来
			Class proxyClass = classLoader.findClass("$Proxy0");
			
			//5.返回被代理后的代理对象
			Constructor c = proxyClass.getConstructor(FInvocationHandler.class);
			f.delete();
			
			return c.newInstance(h);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static Object newInstance1(FClassLoader classLoader
			,Class<?>[] interfaces, FInvocationHandler h){
		
		try {
			//1.根据实现 的接口产生源代码
			String sourceCode = generateSrc(interfaces[0]);
			
			//2.将生产的内容保存到磁盘，保存为.java文件
			String path = FProxy.class.getResource("").getPath();
			System.out.println("当前的类路劲为："+path);
			File f = new File(path + "$Proxy0.java");
			FileWriter fw = new FileWriter(f);
			fw.write(sourceCode);
			fw.flush();
			fw.close();
			
			
			//3. 编译源文件，生产class文件
			//3.1 获取java编译器
			JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
			//3.2获取到java文件控制器
			StandardJavaFileManager manager = compiler.getStandardFileManager(null, null, null);
			//3.3通过文件控制器，将需要编译的文件，转换为Iterable
			Iterable iterable = manager.getJavaFileObjects(f);
			
			//3.4添加到编译器任务重
			CompilationTask task = compiler.getTask(null, manager, null, null, null, iterable);
			//3.5执行编译
			task.call();
			manager.close();
			
			
			//4. 将class文件加载到JVM中
			//5. 返回被代理后的代理对象
			Class proxyClass = classLoader.findClass("$Proxy0");
			Constructor c = proxyClass.getConstructor(FInvocationHandler.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return null;
	}
	
	
	private static String generateSrc(Class<?> interfaces){
		StringBuffer src = new StringBuffer();
		src.append("package com.learning.gupo.proxy.custom;" + ln);
		src.append("import java.lang.reflect.Method;" + ln);
		src.append("public class $Proxy0 implements " + interfaces.getName() + "{" + ln);
		
		src.append("FInvocationHandler h;" + ln);
		
		src.append("public $Proxy0(FInvocationHandler h) {" + ln);
		src.append("this.h = h;" + ln);
		src.append("}" + ln);
		
		for (Method m : interfaces.getMethods()) {
			src.append("public " + m.getReturnType().getName() + " " + m.getName() + "(){" + ln);
			
			src.append("try{" + ln);
			src.append("Method m = " + interfaces.getName() + ".class.getMethod(\"" +m.getName()+"\",new Class[]{});" + ln);
			src.append("this.h.invoke(this,m,null);" + ln);
			src.append("}catch(Throwable e){e.printStackTrace();}" + ln);
			src.append("}" + ln);
		}
		
		src.append("}");
		
		return src.toString();
	}
}
