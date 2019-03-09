package JVM.ClassLoader.MyClassLoader;

/**
 * @ClassName : BrokenDelegeteClassLoader
 * @Description :
 * @Author : xcx
 * @Date : 2019-03-09 16:32
 * @Version : 1.0
 */
public class BrokenDelegeteClassLoader extends MyClassLoader {
    @Override
    protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        synchronized (getClassLoadingLock(name)){
            Class<?> clazz = findLoadedClass(name);
            if(clazz == null){
                if(name.startsWith("java.") || name.startsWith("javax")){
                    try {
                        clazz = getSystemClassLoader().loadClass(name);
                    } catch (Exception e){

                    }
                } else {
                    try {
                        clazz = this.findClass(name);
                    } catch (ClassNotFoundException e){

                    }
                    if(clazz == null){
                        if (getParent() != null){
                            clazz = getParent().loadClass(name);
                        } else {
                            clazz = getSystemClassLoader().loadClass(name);
                        }
                    }
                }
            }

            if (null == clazz){
                throw new ClassNotFoundException("The class " + name + " not found");
            }
            if(resolve){
                resolveClass(clazz);
            }
            return clazz;

        }
        
    }
}
