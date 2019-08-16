package test.pure.sub;

import test.pure.MyService;

/**
 * @Description:
 * @Author: EM
 * @CreateTime: 2019-08-16 14:50
 */
//该类不会被扫描到
public final class Sleep implements MyService {
    @Override
    public void doThings() {
        System.out.println("i sleep a while");
    }

    @Override
    public String getSignature() {
        return "sleep";
    }
}
