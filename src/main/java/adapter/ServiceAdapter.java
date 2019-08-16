package adapter;

import core.TopService;

import java.util.Set;

public interface ServiceAdapter<T extends TopService> {

    /**
     * get Suitable Service
     * 获取适配的Service
     *
     * @param signature
     * @return T
     */
    T getSuitableService(String signature);

    /**
     * get all implementation classes signature
     * 获取该接口下所有实现类签名
     *
     * @return Set<String>
     */
    Set<String> findAllServiceSignature();
}
