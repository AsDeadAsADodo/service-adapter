package adapter;


import core.TopService;

import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Description:
 * @Author: EM
 * @CreateTime: 2019-08-16 11:04
 */
public class ServiceAdapterImpl implements ServiceAdapter {

    private Map<String, TopService> adapter = new HashMap<>();

    private final String basePackage;

    public ServiceAdapterImpl(String basePackage) {
        this.basePackage = basePackage;
        String[] list = getServiceImplStrings();

        for (String s : list) {
            TopService topService = getTopService(s);
            if (topService != null) {
                String signature = topService.getSignature();
                adapter.put(signature, topService);
            }
        }
    }

    private TopService getTopService(String s) {
        Class<?> service = null;
        try {
            //目录情况 dir
            if(!s.contains(".")) return null;
            service = Class.forName(basePackage + "." + s.replace(".class", ""));
            //接口情况 is an interface
            if(service.isInterface()){
                return null;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        TopService topService = null;
        try {
            Object object = service.newInstance();
            //非实现类情况 not an implementation class
            if(object instanceof TopService){
                topService = (TopService)object;
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return topService;
    }

    private String[] getServiceImplStrings() {
        String sub = basePackage.replace(".", "/");
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        URL resource = classLoader.getResource(sub);
        File file = new File(resource.getPath());
        return file.list();
    }

    @Override
    public final TopService getSuitableService(String signature) {
        TopService topService = adapter.get(signature);
        if (topService == null) {
            throw new IllegalArgumentException("No suitable test[没有匹配的service]");
        }
        return topService;
    }

    @Override
    public final Set<String> findAllServiceSignature() {
        return adapter.keySet();
    }
}
