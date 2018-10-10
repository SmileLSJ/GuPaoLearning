package com.learning.gupo.proxy.custom;
import java.lang.reflect.Method;
public class $Proxy0 implements com.learning.gupo.proxy.custom.Person{
FInvocationHandler h;
public $Proxy0(FInvocationHandler h) {
this.h = h;
}
public void sayHello(){
try{
Method m = com.learning.gupo.proxy.custom.Person.class.getMethod("sayHello",new Class[]{});
this.h.invoke(this,m,null);
}catch(Throwable e){e.printStackTrace();}
}
}