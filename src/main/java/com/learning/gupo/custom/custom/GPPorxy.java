package com.learning.gupo.custom.custom;

import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.nio.charset.Charset;

import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;


//��ɴ������Ĵ���
public class GPPorxy {
	
	private static String ln = "\r\n";
	
	public static Object newProxyInstance(GPClassLoader classLoader,Class<?>[] interfaces,GPInvocationHandler h){
		
		
		try{
			//1�����Դ����
			String proxySrc = generateSrc(interfaces[0]);
			
			
			//2������ɵ�Դ������������̣�����Ϊ.java�ļ�
			String filePath = GPPorxy.class.getResource("").getPath();
			File f = new File(filePath + "$Proxy0.java");
			FileWriter fw = new FileWriter(f);
			fw.write(proxySrc);
			fw.flush();
			fw.close();
		
			//3������Դ���룬�������.class�ļ�
			JavaCompiler  compiler = ToolProvider.getSystemJavaCompiler();
			StandardJavaFileManager manager = compiler.getStandardFileManager(null, null, 
					Charset.defaultCharset());
			Iterable iterable = manager.getJavaFileObjects(f);
			
			CompilationTask task = compiler.getTask(null, manager, null, null, null, iterable);
			task.call();
			manager.close();
		
			//4.��class�ļ��е����ݣ���̬���ص�JVM����
			
			//5.���ر������Ĵ������
			Class proxyClass = classLoader.findClass("$Proxy0");
			Constructor c = proxyClass.getConstructor(GPInvocationHandler.class);
			f.delete();
			
			return c.newInstance(h);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return null;
	}
	
	
	private static String generateSrc(Class<?> interfaces){
		StringBuffer src = new StringBuffer();
		src.append("package com.gupaoedu.vip.custom;" + ln);
		src.append("import java.lang.reflect.Method;" + ln);
		src.append("public class $Proxy0 implements " + interfaces.getName() + "{" + ln);
		
		src.append("GPInvocationHandler h;" + ln);
		
		src.append("public $Proxy0(GPInvocationHandler h) {" + ln);
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
